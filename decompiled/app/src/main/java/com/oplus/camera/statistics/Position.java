package com.oplus.camera.statistics;

/* loaded from: classes2.dex */
public final class Position {
    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;
    private static final com.google.protobuf.Descriptors.Descriptor internal_static_com_oplus_camera_statistics_AddrInfo_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_com_oplus_camera_statistics_AddrInfo_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor internal_static_com_oplus_camera_statistics_LocInfo_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_com_oplus_camera_statistics_LocInfo_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor internal_static_com_oplus_camera_statistics_UserInfo_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_com_oplus_camera_statistics_UserInfo_fieldAccessorTable;

    public interface AddrInfoOrBuilder extends com.google.protobuf.MessageOrBuilder {
        java.lang.String getArea();

        com.google.protobuf.ByteString getAreaBytes();

        java.lang.String getCity();

        com.google.protobuf.ByteString getCityBytes();

        java.lang.String getCountry();

        com.google.protobuf.ByteString getCountryBytes();

        java.lang.String getProvince();

        com.google.protobuf.ByteString getProvinceBytes();

        java.lang.String getStreet();

        com.google.protobuf.ByteString getStreetBytes();

        boolean hasArea();

        boolean hasCity();

        boolean hasCountry();

        boolean hasProvince();

        boolean hasStreet();
    }

    public interface LocInfoOrBuilder extends com.google.protobuf.MessageOrBuilder {
        java.lang.String getBid();

        com.google.protobuf.ByteString getBidBytes();

        java.lang.String getBssid();

        com.google.protobuf.ByteString getBssidBytes();

        java.lang.String getCid();

        com.google.protobuf.ByteString getCidBytes();

        java.lang.String getLac();

        com.google.protobuf.ByteString getLacBytes();

        float getLat();

        float getLong();

        java.lang.String getMcc();

        com.google.protobuf.ByteString getMccBytes();

        java.lang.String getMnc();

        com.google.protobuf.ByteString getMncBytes();

        java.lang.String getNid();

        com.google.protobuf.ByteString getNidBytes();

        java.lang.String getPcba();

        com.google.protobuf.ByteString getPcbaBytes();

        java.lang.String getSid();

        com.google.protobuf.ByteString getSidBytes();

        java.lang.String getSsid();

        com.google.protobuf.ByteString getSsidBytes();

        boolean hasBid();

        boolean hasBssid();

        boolean hasCid();

        boolean hasLac();

        boolean hasLat();

        boolean hasLong();

        boolean hasMcc();

        boolean hasMnc();

        boolean hasNid();

        boolean hasPcba();

        boolean hasSid();

        boolean hasSsid();
    }

    public interface UserInfoOrBuilder extends com.google.protobuf.MessageOrBuilder {
        com.oplus.camera.statistics.Position.AddrInfo getAddrInfo();

        com.oplus.camera.statistics.Position.AddrInfoOrBuilder getAddrInfoOrBuilder();

        com.oplus.camera.statistics.Position.LocInfo getGps();

        com.oplus.camera.statistics.Position.LocInfoOrBuilder getGpsOrBuilder();

        boolean hasAddrInfo();

        boolean hasGps();
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) {
    }

    private Position() {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry extensionRegistry) {
        registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) extensionRegistry);
    }

    public static final class AddrInfo extends com.google.protobuf.GeneratedMessageV3 implements com.oplus.camera.statistics.Position.AddrInfoOrBuilder {
        public static final int AREA_FIELD_NUMBER = 2;
        public static final int CITY_FIELD_NUMBER = 3;
        public static final int COUNTRY_FIELD_NUMBER = 5;
        private static final com.oplus.camera.statistics.Position.AddrInfo DEFAULT_INSTANCE = new com.oplus.camera.statistics.Position.AddrInfo();

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<com.oplus.camera.statistics.Position.AddrInfo> PARSER = new com.google.protobuf.AbstractParser<com.oplus.camera.statistics.Position.AddrInfo>() { // from class: com.oplus.camera.statistics.Position.AddrInfo.1
            @Override // com.google.protobuf.Parser
            public com.oplus.camera.statistics.Position.AddrInfo parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.oplus.camera.statistics.Position.AddrInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PROVINCE_FIELD_NUMBER = 4;
        public static final int STREET_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile java.lang.Object area_;
        private int bitField0_;
        private volatile java.lang.Object city_;
        private volatile java.lang.Object country_;
        private byte memoizedIsInitialized;
        private volatile java.lang.Object province_;
        private volatile java.lang.Object street_;

        private AddrInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private AddrInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.street_ = "";
            this.area_ = "";
            this.city_ = "";
            this.province_ = "";
            this.country_ = "";
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AddrInfo(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            boolean z_renamed = false;
            while (!z_renamed) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                com.google.protobuf.ByteString bytes = codedInputStream.readBytes();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.street_ = bytes;
                            } else if (tag == 18) {
                                com.google.protobuf.ByteString bytes2 = codedInputStream.readBytes();
                                this.bitField0_ |= 2;
                                this.area_ = bytes2;
                            } else if (tag == 26) {
                                com.google.protobuf.ByteString bytes3 = codedInputStream.readBytes();
                                this.bitField0_ |= 4;
                                this.city_ = bytes3;
                            } else if (tag == 34) {
                                com.google.protobuf.ByteString bytes4 = codedInputStream.readBytes();
                                this.bitField0_ |= 8;
                                this.province_ = bytes4;
                            } else if (tag != 42) {
                                if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                }
                            } else {
                                com.google.protobuf.ByteString bytes5 = codedInputStream.readBytes();
                                this.bitField0_ |= 16;
                                this.country_ = bytes5;
                            }
                        }
                        z_renamed = true;
                    } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                        throw e_renamed.setUnfinishedMessage(this);
                    } catch (java.io.IOException e2) {
                        throw new com.google.protobuf.InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_AddrInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_AddrInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(com.oplus.camera.statistics.Position.AddrInfo.class, com.oplus.camera.statistics.Position.AddrInfo.Builder.class);
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public boolean hasStreet() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public java.lang.String getStreet() {
            java.lang.Object obj = this.street_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.street_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public com.google.protobuf.ByteString getStreetBytes() {
            java.lang.Object obj = this.street_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.street_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public boolean hasArea() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public java.lang.String getArea() {
            java.lang.Object obj = this.area_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.area_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public com.google.protobuf.ByteString getAreaBytes() {
            java.lang.Object obj = this.area_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.area_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public boolean hasCity() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public java.lang.String getCity() {
            java.lang.Object obj = this.city_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.city_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public com.google.protobuf.ByteString getCityBytes() {
            java.lang.Object obj = this.city_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.city_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public boolean hasProvince() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public java.lang.String getProvince() {
            java.lang.Object obj = this.province_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.province_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public com.google.protobuf.ByteString getProvinceBytes() {
            java.lang.Object obj = this.province_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.province_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public boolean hasCountry() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public java.lang.String getCountry() {
            java.lang.Object obj = this.country_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.country_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public com.google.protobuf.ByteString getCountryBytes() {
            java.lang.Object obj = this.country_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.country_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasStreet()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasArea()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasCity()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasProvince()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasCountry()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            if ((this.bitField0_ & 1) == 1) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 1, this.street_);
            }
            if ((this.bitField0_ & 2) == 2) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 2, this.area_);
            }
            if ((this.bitField0_ & 4) == 4) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 3, this.city_);
            }
            if ((this.bitField0_ & 8) == 8) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 4, this.province_);
            }
            if ((this.bitField0_ & 16) == 16) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 5, this.country_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + com.google.protobuf.GeneratedMessageV3.computeStringSize(1, this.street_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, this.area_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, this.city_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, this.province_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, this.country_);
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.oplus.camera.statistics.Position.AddrInfo)) {
                return super.equals(obj);
            }
            com.oplus.camera.statistics.Position.AddrInfo addrInfo = (com.oplus.camera.statistics.Position.AddrInfo) obj;
            boolean z_renamed = hasStreet() == addrInfo.hasStreet();
            if (hasStreet()) {
                z_renamed = z_renamed && getStreet().equals(addrInfo.getStreet());
            }
            boolean z2 = z_renamed && hasArea() == addrInfo.hasArea();
            if (hasArea()) {
                z2 = z2 && getArea().equals(addrInfo.getArea());
            }
            boolean z3 = z2 && hasCity() == addrInfo.hasCity();
            if (hasCity()) {
                z3 = z3 && getCity().equals(addrInfo.getCity());
            }
            boolean z4 = z3 && hasProvince() == addrInfo.hasProvince();
            if (hasProvince()) {
                z4 = z4 && getProvince().equals(addrInfo.getProvince());
            }
            boolean z5 = z4 && hasCountry() == addrInfo.hasCountry();
            if (hasCountry()) {
                z5 = z5 && getCountry().equals(addrInfo.getCountry());
            }
            return z5 && this.unknownFields.equals(addrInfo.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptorForType().hashCode();
            if (hasStreet()) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getStreet().hashCode();
            }
            if (hasArea()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getArea().hashCode();
            }
            if (hasCity()) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + getCity().hashCode();
            }
            if (hasProvince()) {
                iHashCode = (((iHashCode * 37) + 4) * 53) + getProvince().hashCode();
            }
            if (hasCountry()) {
                iHashCode = (((iHashCode * 37) + 5) * 53) + getCountry().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static com.oplus.camera.statistics.Position.AddrInfo parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.oplus.camera.statistics.Position.AddrInfo parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.oplus.camera.statistics.Position.AddrInfo parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.oplus.camera.statistics.Position.AddrInfo parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.oplus.camera.statistics.Position.AddrInfo parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.AddrInfo) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.statistics.Position.AddrInfo parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.AddrInfo) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.statistics.Position.AddrInfo parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.AddrInfo) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.statistics.Position.AddrInfo parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.AddrInfo) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.statistics.Position.AddrInfo parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.AddrInfo) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.oplus.camera.statistics.Position.AddrInfo parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.AddrInfo) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.statistics.Position.AddrInfo.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.oplus.camera.statistics.Position.AddrInfo.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.oplus.camera.statistics.Position.AddrInfo.Builder newBuilder(com.oplus.camera.statistics.Position.AddrInfo addrInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(addrInfo);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.statistics.Position.AddrInfo.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.oplus.camera.statistics.Position.AddrInfo.Builder() : new com.oplus.camera.statistics.Position.AddrInfo.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.oplus.camera.statistics.Position.AddrInfo.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.oplus.camera.statistics.Position.AddrInfo.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.oplus.camera.statistics.Position.AddrInfo.Builder> implements com.oplus.camera.statistics.Position.AddrInfoOrBuilder {
            private java.lang.Object area_;
            private int bitField0_;
            private java.lang.Object city_;
            private java.lang.Object country_;
            private java.lang.Object province_;
            private java.lang.Object street_;

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_AddrInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_AddrInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(com.oplus.camera.statistics.Position.AddrInfo.class, com.oplus.camera.statistics.Position.AddrInfo.Builder.class);
            }

            private Builder() {
                this.street_ = "";
                this.area_ = "";
                this.city_ = "";
                this.province_ = "";
                this.country_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.street_ = "";
                this.area_ = "";
                this.city_ = "";
                this.province_ = "";
                this.country_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = com.oplus.camera.statistics.Position.AddrInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.AddrInfo.Builder clear() {
                super.clear();
                this.street_ = "";
                this.bitField0_ &= -2;
                this.area_ = "";
                this.bitField0_ &= -3;
                this.city_ = "";
                this.bitField0_ &= -5;
                this.province_ = "";
                this.bitField0_ &= -9;
                this.country_ = "";
                this.bitField0_ &= -17;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_AddrInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.oplus.camera.statistics.Position.AddrInfo getDefaultInstanceForType() {
                return com.oplus.camera.statistics.Position.AddrInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.AddrInfo build() {
                com.oplus.camera.statistics.Position.AddrInfo addrInfoBuildPartial = buildPartial();
                if (addrInfoBuildPartial.isInitialized()) {
                    return addrInfoBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) addrInfoBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.AddrInfo buildPartial() {
                com.oplus.camera.statistics.Position.AddrInfo addrInfo = new com.oplus.camera.statistics.Position.AddrInfo(this);
                int i_renamed = this.bitField0_;
                int i2 = (i_renamed & 1) != 1 ? 0 : 1;
                addrInfo.street_ = this.street_;
                if ((i_renamed & 2) == 2) {
                    i2 |= 2;
                }
                addrInfo.area_ = this.area_;
                if ((i_renamed & 4) == 4) {
                    i2 |= 4;
                }
                addrInfo.city_ = this.city_;
                if ((i_renamed & 8) == 8) {
                    i2 |= 8;
                }
                addrInfo.province_ = this.province_;
                if ((i_renamed & 16) == 16) {
                    i2 |= 16;
                }
                addrInfo.country_ = this.country_;
                addrInfo.bitField0_ = i2;
                onBuilt();
                return addrInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public com.oplus.camera.statistics.Position.AddrInfo.Builder mo23clone() {
                return (com.oplus.camera.statistics.Position.AddrInfo.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.AddrInfo.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.statistics.Position.AddrInfo.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.AddrInfo.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.oplus.camera.statistics.Position.AddrInfo.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.AddrInfo.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.oplus.camera.statistics.Position.AddrInfo.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.AddrInfo.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.oplus.camera.statistics.Position.AddrInfo.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.AddrInfo.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.statistics.Position.AddrInfo.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.AddrInfo.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.oplus.camera.statistics.Position.AddrInfo) {
                    return mergeFrom((com.oplus.camera.statistics.Position.AddrInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder mergeFrom(com.oplus.camera.statistics.Position.AddrInfo addrInfo) {
                if (addrInfo == com.oplus.camera.statistics.Position.AddrInfo.getDefaultInstance()) {
                    return this;
                }
                if (addrInfo.hasStreet()) {
                    this.bitField0_ |= 1;
                    this.street_ = addrInfo.street_;
                    onChanged();
                }
                if (addrInfo.hasArea()) {
                    this.bitField0_ |= 2;
                    this.area_ = addrInfo.area_;
                    onChanged();
                }
                if (addrInfo.hasCity()) {
                    this.bitField0_ |= 4;
                    this.city_ = addrInfo.city_;
                    onChanged();
                }
                if (addrInfo.hasProvince()) {
                    this.bitField0_ |= 8;
                    this.province_ = addrInfo.province_;
                    onChanged();
                }
                if (addrInfo.hasCountry()) {
                    this.bitField0_ |= 16;
                    this.country_ = addrInfo.country_;
                    onChanged();
                }
                mergeUnknownFields(addrInfo.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasStreet() && hasArea() && hasCity() && hasProvince() && hasCountry();
            }

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0021  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.oplus.camera.statistics.Position.AddrInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.oplus.camera.statistics.Position$AddrInfo> r1 = com.oplus.camera.statistics.Position.AddrInfo.PARSER     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    com.oplus.camera.statistics.Position$AddrInfo r3 = (com.oplus.camera.statistics.Position.AddrInfo) r3     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.mergeFrom(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    com.oplus.camera.statistics.Position$AddrInfo r4 = (com.oplus.camera.statistics.Position.AddrInfo) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.mergeFrom(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.statistics.Position.AddrInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oplus.camera.statistics.Position$AddrInfo$Builder");
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public boolean hasStreet() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public java.lang.String getStreet() {
                java.lang.Object obj = this.street_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.street_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public com.google.protobuf.ByteString getStreetBytes() {
                java.lang.Object obj = this.street_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.street_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder setStreet(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 1;
                this.street_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder clearStreet() {
                this.bitField0_ &= -2;
                this.street_ = com.oplus.camera.statistics.Position.AddrInfo.getDefaultInstance().getStreet();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder setStreetBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 1;
                this.street_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public boolean hasArea() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public java.lang.String getArea() {
                java.lang.Object obj = this.area_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.area_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public com.google.protobuf.ByteString getAreaBytes() {
                java.lang.Object obj = this.area_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.area_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder setArea(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 2;
                this.area_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder clearArea() {
                this.bitField0_ &= -3;
                this.area_ = com.oplus.camera.statistics.Position.AddrInfo.getDefaultInstance().getArea();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder setAreaBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 2;
                this.area_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public boolean hasCity() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public java.lang.String getCity() {
                java.lang.Object obj = this.city_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.city_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public com.google.protobuf.ByteString getCityBytes() {
                java.lang.Object obj = this.city_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.city_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder setCity(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 4;
                this.city_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder clearCity() {
                this.bitField0_ &= -5;
                this.city_ = com.oplus.camera.statistics.Position.AddrInfo.getDefaultInstance().getCity();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder setCityBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 4;
                this.city_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public boolean hasProvince() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public java.lang.String getProvince() {
                java.lang.Object obj = this.province_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.province_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public com.google.protobuf.ByteString getProvinceBytes() {
                java.lang.Object obj = this.province_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.province_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder setProvince(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 8;
                this.province_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder clearProvince() {
                this.bitField0_ &= -9;
                this.province_ = com.oplus.camera.statistics.Position.AddrInfo.getDefaultInstance().getProvince();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder setProvinceBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 8;
                this.province_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public boolean hasCountry() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public java.lang.String getCountry() {
                java.lang.Object obj = this.country_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.country_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public com.google.protobuf.ByteString getCountryBytes() {
                java.lang.Object obj = this.country_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.country_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder setCountry(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 16;
                this.country_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder clearCountry() {
                this.bitField0_ &= -17;
                this.country_ = com.oplus.camera.statistics.Position.AddrInfo.getDefaultInstance().getCountry();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder setCountryBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 16;
                this.country_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.statistics.Position.AddrInfo.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.statistics.Position.AddrInfo.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.statistics.Position.AddrInfo.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.statistics.Position.AddrInfo.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.oplus.camera.statistics.Position.AddrInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.oplus.camera.statistics.Position.AddrInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.oplus.camera.statistics.Position.AddrInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.oplus.camera.statistics.Position.AddrInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class LocInfo extends com.google.protobuf.GeneratedMessageV3 implements com.oplus.camera.statistics.Position.LocInfoOrBuilder {
        public static final int BID_FIELD_NUMBER = 13;
        public static final int BSSID_FIELD_NUMBER = 10;
        public static final int CID_FIELD_NUMBER = 4;
        public static final int LAC_FIELD_NUMBER = 3;
        public static final int LAT_FIELD_NUMBER = 6;
        public static final int LONG_FIELD_NUMBER = 7;
        public static final int MCC_FIELD_NUMBER = 1;
        public static final int MNC_FIELD_NUMBER = 2;
        public static final int NID_FIELD_NUMBER = 12;
        public static final int PCBA_FIELD_NUMBER = 8;
        public static final int SID_FIELD_NUMBER = 11;
        public static final int SSID_FIELD_NUMBER = 9;
        private static final long serialVersionUID = 0;
        private volatile java.lang.Object bid_;
        private int bitField0_;
        private volatile java.lang.Object bssid_;
        private volatile java.lang.Object cid_;
        private volatile java.lang.Object lac_;
        private float lat_;
        private float long_;
        private volatile java.lang.Object mcc_;
        private byte memoizedIsInitialized;
        private volatile java.lang.Object mnc_;
        private volatile java.lang.Object nid_;
        private volatile java.lang.Object pcba_;
        private volatile java.lang.Object sid_;
        private volatile java.lang.Object ssid_;
        private static final com.oplus.camera.statistics.Position.LocInfo DEFAULT_INSTANCE = new com.oplus.camera.statistics.Position.LocInfo();

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<com.oplus.camera.statistics.Position.LocInfo> PARSER = new com.google.protobuf.AbstractParser<com.oplus.camera.statistics.Position.LocInfo>() { // from class: com.oplus.camera.statistics.Position.LocInfo.1
            @Override // com.google.protobuf.Parser
            public com.oplus.camera.statistics.Position.LocInfo parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.oplus.camera.statistics.Position.LocInfo(codedInputStream, extensionRegistryLite);
            }
        };

        private LocInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private LocInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.mcc_ = "";
            this.mnc_ = "";
            this.lac_ = "";
            this.cid_ = "";
            this.lat_ = 0.0f;
            this.long_ = 0.0f;
            this.pcba_ = "";
            this.ssid_ = "";
            this.bssid_ = "";
            this.sid_ = "";
            this.nid_ = "";
            this.bid_ = "";
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LocInfo(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            boolean z_renamed = false;
            while (!z_renamed) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        switch (tag) {
                            case 0:
                                z_renamed = true;
                            case 10:
                                com.google.protobuf.ByteString bytes = codedInputStream.readBytes();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.mcc_ = bytes;
                            case 18:
                                com.google.protobuf.ByteString bytes2 = codedInputStream.readBytes();
                                this.bitField0_ |= 2;
                                this.mnc_ = bytes2;
                            case 26:
                                com.google.protobuf.ByteString bytes3 = codedInputStream.readBytes();
                                this.bitField0_ |= 4;
                                this.lac_ = bytes3;
                            case 34:
                                com.google.protobuf.ByteString bytes4 = codedInputStream.readBytes();
                                this.bitField0_ |= 8;
                                this.cid_ = bytes4;
                            case 42:
                                codedInputStream.readBytes();
                                this.bitField0_ |= 16;
                            case 53:
                                this.bitField0_ |= 32;
                                this.lat_ = codedInputStream.readFloat();
                            case 61:
                                this.bitField0_ |= 64;
                                this.long_ = codedInputStream.readFloat();
                            case 66:
                                com.google.protobuf.ByteString bytes5 = codedInputStream.readBytes();
                                this.bitField0_ |= 128;
                                this.pcba_ = bytes5;
                            case 74:
                                com.google.protobuf.ByteString bytes6 = codedInputStream.readBytes();
                                this.bitField0_ |= 256;
                                this.ssid_ = bytes6;
                            case 82:
                                com.google.protobuf.ByteString bytes7 = codedInputStream.readBytes();
                                this.bitField0_ |= 512;
                                this.bssid_ = bytes7;
                            case 90:
                                com.google.protobuf.ByteString bytes8 = codedInputStream.readBytes();
                                this.bitField0_ |= 1024;
                                this.sid_ = bytes8;
                            case 98:
                                com.google.protobuf.ByteString bytes9 = codedInputStream.readBytes();
                                this.bitField0_ |= 2048;
                                this.nid_ = bytes9;
                            case 106:
                                com.google.protobuf.ByteString bytes10 = codedInputStream.readBytes();
                                this.bitField0_ |= 4096;
                                this.bid_ = bytes10;
                            default:
                                if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                    z_renamed = true;
                                }
                        }
                    } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                        throw e_renamed.setUnfinishedMessage(this);
                    } catch (java.io.IOException e2) {
                        throw new com.google.protobuf.InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_LocInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_LocInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(com.oplus.camera.statistics.Position.LocInfo.class, com.oplus.camera.statistics.Position.LocInfo.Builder.class);
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasMcc() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public java.lang.String getMcc() {
            java.lang.Object obj = this.mcc_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.mcc_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public com.google.protobuf.ByteString getMccBytes() {
            java.lang.Object obj = this.mcc_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.mcc_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasMnc() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public java.lang.String getMnc() {
            java.lang.Object obj = this.mnc_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.mnc_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public com.google.protobuf.ByteString getMncBytes() {
            java.lang.Object obj = this.mnc_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.mnc_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasLac() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public java.lang.String getLac() {
            java.lang.Object obj = this.lac_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.lac_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public com.google.protobuf.ByteString getLacBytes() {
            java.lang.Object obj = this.lac_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.lac_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasCid() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public java.lang.String getCid() {
            java.lang.Object obj = this.cid_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.cid_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public com.google.protobuf.ByteString getCidBytes() {
            java.lang.Object obj = this.cid_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.cid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasLat() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public float getLat() {
            return this.lat_;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasLong() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public float getLong() {
            return this.long_;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasPcba() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public java.lang.String getPcba() {
            java.lang.Object obj = this.pcba_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.pcba_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public com.google.protobuf.ByteString getPcbaBytes() {
            java.lang.Object obj = this.pcba_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.pcba_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasSsid() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public java.lang.String getSsid() {
            java.lang.Object obj = this.ssid_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ssid_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public com.google.protobuf.ByteString getSsidBytes() {
            java.lang.Object obj = this.ssid_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.ssid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasBssid() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public java.lang.String getBssid() {
            java.lang.Object obj = this.bssid_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.bssid_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public com.google.protobuf.ByteString getBssidBytes() {
            java.lang.Object obj = this.bssid_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.bssid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasSid() {
            return (this.bitField0_ & 1024) == 1024;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public java.lang.String getSid() {
            java.lang.Object obj = this.sid_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.sid_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public com.google.protobuf.ByteString getSidBytes() {
            java.lang.Object obj = this.sid_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.sid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasNid() {
            return (this.bitField0_ & 2048) == 2048;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public java.lang.String getNid() {
            java.lang.Object obj = this.nid_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.nid_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public com.google.protobuf.ByteString getNidBytes() {
            java.lang.Object obj = this.nid_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.nid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasBid() {
            return (this.bitField0_ & 4096) == 4096;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public java.lang.String getBid() {
            java.lang.Object obj = this.bid_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.bid_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public com.google.protobuf.ByteString getBidBytes() {
            java.lang.Object obj = this.bid_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.bid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasMcc()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasMnc()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasLac()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasCid()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasLat()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasLong()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            if ((this.bitField0_ & 1) == 1) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 1, this.mcc_);
            }
            if ((this.bitField0_ & 2) == 2) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 2, this.mnc_);
            }
            if ((this.bitField0_ & 4) == 4) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 3, this.lac_);
            }
            if ((this.bitField0_ & 8) == 8) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 4, this.cid_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeFloat(6, this.lat_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeFloat(7, this.long_);
            }
            if ((this.bitField0_ & 128) == 128) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 8, this.pcba_);
            }
            if ((this.bitField0_ & 256) == 256) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 9, this.ssid_);
            }
            if ((this.bitField0_ & 512) == 512) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 10, this.bssid_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 11, this.sid_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 12, this.nid_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 13, this.bid_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + com.google.protobuf.GeneratedMessageV3.computeStringSize(1, this.mcc_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, this.mnc_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, this.lac_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, this.cid_);
            }
            if ((this.bitField0_ & 32) == 32) {
                iComputeStringSize += com.google.protobuf.CodedOutputStream.computeFloatSize(6, this.lat_);
            }
            if ((this.bitField0_ & 64) == 64) {
                iComputeStringSize += com.google.protobuf.CodedOutputStream.computeFloatSize(7, this.long_);
            }
            if ((this.bitField0_ & 128) == 128) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, this.pcba_);
            }
            if ((this.bitField0_ & 256) == 256) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, this.ssid_);
            }
            if ((this.bitField0_ & 512) == 512) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, this.bssid_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(11, this.sid_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(12, this.nid_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(13, this.bid_);
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.oplus.camera.statistics.Position.LocInfo)) {
                return super.equals(obj);
            }
            com.oplus.camera.statistics.Position.LocInfo locInfo = (com.oplus.camera.statistics.Position.LocInfo) obj;
            boolean z_renamed = hasMcc() == locInfo.hasMcc();
            if (hasMcc()) {
                z_renamed = z_renamed && getMcc().equals(locInfo.getMcc());
            }
            boolean z2 = z_renamed && hasMnc() == locInfo.hasMnc();
            if (hasMnc()) {
                z2 = z2 && getMnc().equals(locInfo.getMnc());
            }
            boolean z3 = z2 && hasLac() == locInfo.hasLac();
            if (hasLac()) {
                z3 = z3 && getLac().equals(locInfo.getLac());
            }
            boolean z4 = z3 && hasCid() == locInfo.hasCid();
            if (hasCid()) {
                z4 = z4 && getCid().equals(locInfo.getCid());
            }
            boolean z5 = z4 && hasLat() == locInfo.hasLat();
            if (hasLat()) {
                z5 = z5 && java.lang.Float.floatToIntBits(getLat()) == java.lang.Float.floatToIntBits(locInfo.getLat());
            }
            boolean z6 = z5 && hasLong() == locInfo.hasLong();
            if (hasLong()) {
                z6 = z6 && java.lang.Float.floatToIntBits(getLong()) == java.lang.Float.floatToIntBits(locInfo.getLong());
            }
            boolean z7 = z6 && hasPcba() == locInfo.hasPcba();
            if (hasPcba()) {
                z7 = z7 && getPcba().equals(locInfo.getPcba());
            }
            boolean z8 = z7 && hasSsid() == locInfo.hasSsid();
            if (hasSsid()) {
                z8 = z8 && getSsid().equals(locInfo.getSsid());
            }
            boolean z9 = z8 && hasBssid() == locInfo.hasBssid();
            if (hasBssid()) {
                z9 = z9 && getBssid().equals(locInfo.getBssid());
            }
            boolean z10 = z9 && hasSid() == locInfo.hasSid();
            if (hasSid()) {
                z10 = z10 && getSid().equals(locInfo.getSid());
            }
            boolean z11 = z10 && hasNid() == locInfo.hasNid();
            if (hasNid()) {
                z11 = z11 && getNid().equals(locInfo.getNid());
            }
            boolean z12 = z11 && hasBid() == locInfo.hasBid();
            if (hasBid()) {
                z12 = z12 && getBid().equals(locInfo.getBid());
            }
            return z12 && this.unknownFields.equals(locInfo.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptorForType().hashCode();
            if (hasMcc()) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getMcc().hashCode();
            }
            if (hasMnc()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getMnc().hashCode();
            }
            if (hasLac()) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + getLac().hashCode();
            }
            if (hasCid()) {
                iHashCode = (((iHashCode * 37) + 4) * 53) + getCid().hashCode();
            }
            if (hasLat()) {
                iHashCode = (((iHashCode * 37) + 6) * 53) + java.lang.Float.floatToIntBits(getLat());
            }
            if (hasLong()) {
                iHashCode = (((iHashCode * 37) + 7) * 53) + java.lang.Float.floatToIntBits(getLong());
            }
            if (hasPcba()) {
                iHashCode = (((iHashCode * 37) + 8) * 53) + getPcba().hashCode();
            }
            if (hasSsid()) {
                iHashCode = (((iHashCode * 37) + 9) * 53) + getSsid().hashCode();
            }
            if (hasBssid()) {
                iHashCode = (((iHashCode * 37) + 10) * 53) + getBssid().hashCode();
            }
            if (hasSid()) {
                iHashCode = (((iHashCode * 37) + 11) * 53) + getSid().hashCode();
            }
            if (hasNid()) {
                iHashCode = (((iHashCode * 37) + 12) * 53) + getNid().hashCode();
            }
            if (hasBid()) {
                iHashCode = (((iHashCode * 37) + 13) * 53) + getBid().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static com.oplus.camera.statistics.Position.LocInfo parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.oplus.camera.statistics.Position.LocInfo parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.oplus.camera.statistics.Position.LocInfo parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.oplus.camera.statistics.Position.LocInfo parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.oplus.camera.statistics.Position.LocInfo parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.LocInfo) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.statistics.Position.LocInfo parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.LocInfo) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.statistics.Position.LocInfo parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.LocInfo) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.statistics.Position.LocInfo parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.LocInfo) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.statistics.Position.LocInfo parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.LocInfo) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.oplus.camera.statistics.Position.LocInfo parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.LocInfo) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.statistics.Position.LocInfo.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.oplus.camera.statistics.Position.LocInfo.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.oplus.camera.statistics.Position.LocInfo.Builder newBuilder(com.oplus.camera.statistics.Position.LocInfo locInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(locInfo);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.statistics.Position.LocInfo.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.oplus.camera.statistics.Position.LocInfo.Builder() : new com.oplus.camera.statistics.Position.LocInfo.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.oplus.camera.statistics.Position.LocInfo.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.oplus.camera.statistics.Position.LocInfo.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.oplus.camera.statistics.Position.LocInfo.Builder> implements com.oplus.camera.statistics.Position.LocInfoOrBuilder {
            private java.lang.Object bid_;
            private int bitField0_;
            private java.lang.Object bssid_;
            private java.lang.Object cid_;
            private java.lang.Object lac_;
            private float lat_;
            private float long_;
            private java.lang.Object mcc_;
            private java.lang.Object mnc_;
            private java.lang.Object nid_;
            private java.lang.Object pcba_;
            private java.lang.Object sid_;
            private java.lang.Object ssid_;

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_LocInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_LocInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(com.oplus.camera.statistics.Position.LocInfo.class, com.oplus.camera.statistics.Position.LocInfo.Builder.class);
            }

            private Builder() {
                this.mcc_ = "";
                this.mnc_ = "";
                this.lac_ = "";
                this.cid_ = "";
                this.pcba_ = "";
                this.ssid_ = "";
                this.bssid_ = "";
                this.sid_ = "";
                this.nid_ = "";
                this.bid_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.mcc_ = "";
                this.mnc_ = "";
                this.lac_ = "";
                this.cid_ = "";
                this.pcba_ = "";
                this.ssid_ = "";
                this.bssid_ = "";
                this.sid_ = "";
                this.nid_ = "";
                this.bid_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = com.oplus.camera.statistics.Position.LocInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.LocInfo.Builder clear() {
                super.clear();
                this.mcc_ = "";
                this.bitField0_ &= -2;
                this.mnc_ = "";
                this.bitField0_ &= -3;
                this.lac_ = "";
                this.bitField0_ &= -5;
                this.cid_ = "";
                this.bitField0_ &= -9;
                this.bitField0_ &= -17;
                this.lat_ = 0.0f;
                this.bitField0_ &= -33;
                this.long_ = 0.0f;
                this.bitField0_ &= -65;
                this.pcba_ = "";
                this.bitField0_ &= -129;
                this.ssid_ = "";
                this.bitField0_ &= -257;
                this.bssid_ = "";
                this.bitField0_ &= -513;
                this.sid_ = "";
                this.bitField0_ &= -1025;
                this.nid_ = "";
                this.bitField0_ &= -2049;
                this.bid_ = "";
                this.bitField0_ &= -4097;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_LocInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.oplus.camera.statistics.Position.LocInfo getDefaultInstanceForType() {
                return com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.LocInfo build() {
                com.oplus.camera.statistics.Position.LocInfo locInfoBuildPartial = buildPartial();
                if (locInfoBuildPartial.isInitialized()) {
                    return locInfoBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) locInfoBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.LocInfo buildPartial() {
                com.oplus.camera.statistics.Position.LocInfo locInfo = new com.oplus.camera.statistics.Position.LocInfo(this);
                int i_renamed = this.bitField0_;
                int i2 = (i_renamed & 1) != 1 ? 0 : 1;
                locInfo.mcc_ = this.mcc_;
                if ((i_renamed & 2) == 2) {
                    i2 |= 2;
                }
                locInfo.mnc_ = this.mnc_;
                if ((i_renamed & 4) == 4) {
                    i2 |= 4;
                }
                locInfo.lac_ = this.lac_;
                if ((i_renamed & 8) == 8) {
                    i2 |= 8;
                }
                locInfo.cid_ = this.cid_;
                if ((i_renamed & 16) == 16) {
                    i2 |= 16;
                }
                if ((i_renamed & 32) == 32) {
                    i2 |= 32;
                }
                locInfo.lat_ = this.lat_;
                if ((i_renamed & 64) == 64) {
                    i2 |= 64;
                }
                locInfo.long_ = this.long_;
                if ((i_renamed & 128) == 128) {
                    i2 |= 128;
                }
                locInfo.pcba_ = this.pcba_;
                if ((i_renamed & 256) == 256) {
                    i2 |= 256;
                }
                locInfo.ssid_ = this.ssid_;
                if ((i_renamed & 512) == 512) {
                    i2 |= 512;
                }
                locInfo.bssid_ = this.bssid_;
                if ((i_renamed & 1024) == 1024) {
                    i2 |= 1024;
                }
                locInfo.sid_ = this.sid_;
                if ((i_renamed & 2048) == 2048) {
                    i2 |= 2048;
                }
                locInfo.nid_ = this.nid_;
                if ((i_renamed & 4096) == 4096) {
                    i2 |= 4096;
                }
                locInfo.bid_ = this.bid_;
                locInfo.bitField0_ = i2;
                onBuilt();
                return locInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public com.oplus.camera.statistics.Position.LocInfo.Builder mo23clone() {
                return (com.oplus.camera.statistics.Position.LocInfo.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.LocInfo.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.statistics.Position.LocInfo.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.LocInfo.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.oplus.camera.statistics.Position.LocInfo.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.LocInfo.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.oplus.camera.statistics.Position.LocInfo.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.LocInfo.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.oplus.camera.statistics.Position.LocInfo.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.LocInfo.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.statistics.Position.LocInfo.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.LocInfo.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.oplus.camera.statistics.Position.LocInfo) {
                    return mergeFrom((com.oplus.camera.statistics.Position.LocInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder mergeFrom(com.oplus.camera.statistics.Position.LocInfo locInfo) {
                if (locInfo == com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance()) {
                    return this;
                }
                if (locInfo.hasMcc()) {
                    this.bitField0_ |= 1;
                    this.mcc_ = locInfo.mcc_;
                    onChanged();
                }
                if (locInfo.hasMnc()) {
                    this.bitField0_ |= 2;
                    this.mnc_ = locInfo.mnc_;
                    onChanged();
                }
                if (locInfo.hasLac()) {
                    this.bitField0_ |= 4;
                    this.lac_ = locInfo.lac_;
                    onChanged();
                }
                if (locInfo.hasCid()) {
                    this.bitField0_ |= 8;
                    this.cid_ = locInfo.cid_;
                    onChanged();
                }
                if (locInfo.hasLat()) {
                    setLat(locInfo.getLat());
                }
                if (locInfo.hasLong()) {
                    setLong(locInfo.getLong());
                }
                if (locInfo.hasPcba()) {
                    this.bitField0_ |= 128;
                    this.pcba_ = locInfo.pcba_;
                    onChanged();
                }
                if (locInfo.hasSsid()) {
                    this.bitField0_ |= 256;
                    this.ssid_ = locInfo.ssid_;
                    onChanged();
                }
                if (locInfo.hasBssid()) {
                    this.bitField0_ |= 512;
                    this.bssid_ = locInfo.bssid_;
                    onChanged();
                }
                if (locInfo.hasSid()) {
                    this.bitField0_ |= 1024;
                    this.sid_ = locInfo.sid_;
                    onChanged();
                }
                if (locInfo.hasNid()) {
                    this.bitField0_ |= 2048;
                    this.nid_ = locInfo.nid_;
                    onChanged();
                }
                if (locInfo.hasBid()) {
                    this.bitField0_ |= 4096;
                    this.bid_ = locInfo.bid_;
                    onChanged();
                }
                mergeUnknownFields(locInfo.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasMcc() && hasMnc() && hasLac() && hasCid() && hasLat() && hasLong();
            }

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0021  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.oplus.camera.statistics.Position.LocInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.oplus.camera.statistics.Position$LocInfo> r1 = com.oplus.camera.statistics.Position.LocInfo.PARSER     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    com.oplus.camera.statistics.Position$LocInfo r3 = (com.oplus.camera.statistics.Position.LocInfo) r3     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.mergeFrom(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    com.oplus.camera.statistics.Position$LocInfo r4 = (com.oplus.camera.statistics.Position.LocInfo) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.mergeFrom(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.statistics.Position.LocInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oplus.camera.statistics.Position$LocInfo$Builder");
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public boolean hasMcc() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public java.lang.String getMcc() {
                java.lang.Object obj = this.mcc_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.mcc_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public com.google.protobuf.ByteString getMccBytes() {
                java.lang.Object obj = this.mcc_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.mcc_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setMcc(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 1;
                this.mcc_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder clearMcc() {
                this.bitField0_ &= -2;
                this.mcc_ = com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance().getMcc();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setMccBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 1;
                this.mcc_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public boolean hasMnc() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public java.lang.String getMnc() {
                java.lang.Object obj = this.mnc_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.mnc_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public com.google.protobuf.ByteString getMncBytes() {
                java.lang.Object obj = this.mnc_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.mnc_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setMnc(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 2;
                this.mnc_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder clearMnc() {
                this.bitField0_ &= -3;
                this.mnc_ = com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance().getMnc();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setMncBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 2;
                this.mnc_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public boolean hasLac() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public java.lang.String getLac() {
                java.lang.Object obj = this.lac_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.lac_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public com.google.protobuf.ByteString getLacBytes() {
                java.lang.Object obj = this.lac_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.lac_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setLac(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 4;
                this.lac_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder clearLac() {
                this.bitField0_ &= -5;
                this.lac_ = com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance().getLac();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setLacBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 4;
                this.lac_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public boolean hasCid() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public java.lang.String getCid() {
                java.lang.Object obj = this.cid_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.cid_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public com.google.protobuf.ByteString getCidBytes() {
                java.lang.Object obj = this.cid_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.cid_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setCid(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 8;
                this.cid_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder clearCid() {
                this.bitField0_ &= -9;
                this.cid_ = com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance().getCid();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setCidBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 8;
                this.cid_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public boolean hasLat() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public float getLat() {
                return this.lat_;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setLat(float f_renamed) {
                this.bitField0_ |= 32;
                this.lat_ = f_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder clearLat() {
                this.bitField0_ &= -33;
                this.lat_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public boolean hasLong() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public float getLong() {
                return this.long_;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setLong(float f_renamed) {
                this.bitField0_ |= 64;
                this.long_ = f_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder clearLong() {
                this.bitField0_ &= -65;
                this.long_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public boolean hasPcba() {
                return (this.bitField0_ & 128) == 128;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public java.lang.String getPcba() {
                java.lang.Object obj = this.pcba_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.pcba_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public com.google.protobuf.ByteString getPcbaBytes() {
                java.lang.Object obj = this.pcba_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.pcba_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setPcba(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 128;
                this.pcba_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder clearPcba() {
                this.bitField0_ &= -129;
                this.pcba_ = com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance().getPcba();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setPcbaBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 128;
                this.pcba_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public boolean hasSsid() {
                return (this.bitField0_ & 256) == 256;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public java.lang.String getSsid() {
                java.lang.Object obj = this.ssid_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.ssid_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public com.google.protobuf.ByteString getSsidBytes() {
                java.lang.Object obj = this.ssid_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.ssid_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setSsid(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 256;
                this.ssid_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder clearSsid() {
                this.bitField0_ &= -257;
                this.ssid_ = com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance().getSsid();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setSsidBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 256;
                this.ssid_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public boolean hasBssid() {
                return (this.bitField0_ & 512) == 512;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public java.lang.String getBssid() {
                java.lang.Object obj = this.bssid_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.bssid_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public com.google.protobuf.ByteString getBssidBytes() {
                java.lang.Object obj = this.bssid_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.bssid_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setBssid(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 512;
                this.bssid_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder clearBssid() {
                this.bitField0_ &= -513;
                this.bssid_ = com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance().getBssid();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setBssidBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 512;
                this.bssid_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public boolean hasSid() {
                return (this.bitField0_ & 1024) == 1024;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public java.lang.String getSid() {
                java.lang.Object obj = this.sid_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.sid_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public com.google.protobuf.ByteString getSidBytes() {
                java.lang.Object obj = this.sid_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.sid_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setSid(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 1024;
                this.sid_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder clearSid() {
                this.bitField0_ &= -1025;
                this.sid_ = com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance().getSid();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setSidBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 1024;
                this.sid_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public boolean hasNid() {
                return (this.bitField0_ & 2048) == 2048;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public java.lang.String getNid() {
                java.lang.Object obj = this.nid_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.nid_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public com.google.protobuf.ByteString getNidBytes() {
                java.lang.Object obj = this.nid_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.nid_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setNid(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 2048;
                this.nid_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder clearNid() {
                this.bitField0_ &= -2049;
                this.nid_ = com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance().getNid();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setNidBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 2048;
                this.nid_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public boolean hasBid() {
                return (this.bitField0_ & 4096) == 4096;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public java.lang.String getBid() {
                java.lang.Object obj = this.bid_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.bid_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public com.google.protobuf.ByteString getBidBytes() {
                java.lang.Object obj = this.bid_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.bid_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setBid(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 4096;
                this.bid_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder clearBid() {
                this.bitField0_ &= -4097;
                this.bid_ = com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance().getBid();
                onChanged();
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder setBidBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 4096;
                this.bid_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.statistics.Position.LocInfo.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.statistics.Position.LocInfo.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.statistics.Position.LocInfo.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.statistics.Position.LocInfo.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.oplus.camera.statistics.Position.LocInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.oplus.camera.statistics.Position.LocInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.oplus.camera.statistics.Position.LocInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.oplus.camera.statistics.Position.LocInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class UserInfo extends com.google.protobuf.GeneratedMessageV3 implements com.oplus.camera.statistics.Position.UserInfoOrBuilder {
        public static final int ADDRINFO_FIELD_NUMBER = 1;
        public static final int GPS_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private com.oplus.camera.statistics.Position.AddrInfo addrInfo_;
        private int bitField0_;
        private com.oplus.camera.statistics.Position.LocInfo gps_;
        private byte memoizedIsInitialized;
        private static final com.oplus.camera.statistics.Position.UserInfo DEFAULT_INSTANCE = new com.oplus.camera.statistics.Position.UserInfo();

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<com.oplus.camera.statistics.Position.UserInfo> PARSER = new com.google.protobuf.AbstractParser<com.oplus.camera.statistics.Position.UserInfo>() { // from class: com.oplus.camera.statistics.Position.UserInfo.1
            @Override // com.google.protobuf.Parser
            public com.oplus.camera.statistics.Position.UserInfo parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.oplus.camera.statistics.Position.UserInfo(codedInputStream, extensionRegistryLite);
            }
        };

        private UserInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private UserInfo() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UserInfo(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            boolean z_renamed = false;
            while (!z_renamed) {
                try {
                    try {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    com.oplus.camera.statistics.Position.AddrInfo.Builder builder = (this.bitField0_ & 1) == 1 ? this.addrInfo_.toBuilder() : null;
                                    this.addrInfo_ = (com.oplus.camera.statistics.Position.AddrInfo) codedInputStream.readMessage(com.oplus.camera.statistics.Position.AddrInfo.PARSER, extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.addrInfo_);
                                        this.addrInfo_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (tag != 18) {
                                    if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                    }
                                } else {
                                    com.oplus.camera.statistics.Position.LocInfo.Builder builder2 = (this.bitField0_ & 2) == 2 ? this.gps_.toBuilder() : null;
                                    this.gps_ = (com.oplus.camera.statistics.Position.LocInfo) codedInputStream.readMessage(com.oplus.camera.statistics.Position.LocInfo.PARSER, extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom(this.gps_);
                                        this.gps_ = builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                }
                            }
                            z_renamed = true;
                        } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                            throw e_renamed.setUnfinishedMessage(this);
                        }
                    } catch (java.io.IOException e2) {
                        throw new com.google.protobuf.InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_UserInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_UserInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(com.oplus.camera.statistics.Position.UserInfo.class, com.oplus.camera.statistics.Position.UserInfo.Builder.class);
        }

        @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
        public boolean hasAddrInfo() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
        public com.oplus.camera.statistics.Position.AddrInfo getAddrInfo() {
            com.oplus.camera.statistics.Position.AddrInfo addrInfo = this.addrInfo_;
            return addrInfo == null ? com.oplus.camera.statistics.Position.AddrInfo.getDefaultInstance() : addrInfo;
        }

        @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
        public com.oplus.camera.statistics.Position.AddrInfoOrBuilder getAddrInfoOrBuilder() {
            com.oplus.camera.statistics.Position.AddrInfo addrInfo = this.addrInfo_;
            return addrInfo == null ? com.oplus.camera.statistics.Position.AddrInfo.getDefaultInstance() : addrInfo;
        }

        @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
        public boolean hasGps() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
        public com.oplus.camera.statistics.Position.LocInfo getGps() {
            com.oplus.camera.statistics.Position.LocInfo locInfo = this.gps_;
            return locInfo == null ? com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance() : locInfo;
        }

        @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
        public com.oplus.camera.statistics.Position.LocInfoOrBuilder getGpsOrBuilder() {
            com.oplus.camera.statistics.Position.LocInfo locInfo = this.gps_;
            return locInfo == null ? com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance() : locInfo;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasAddrInfo()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasGps()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!getAddrInfo().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!getGps().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, getAddrInfo());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, getGps());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            int iComputeMessageSize = (this.bitField0_ & 1) == 1 ? 0 + com.google.protobuf.CodedOutputStream.computeMessageSize(1, getAddrInfo()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeMessageSize += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getGps());
            }
            int serializedSize = iComputeMessageSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.oplus.camera.statistics.Position.UserInfo)) {
                return super.equals(obj);
            }
            com.oplus.camera.statistics.Position.UserInfo userInfo = (com.oplus.camera.statistics.Position.UserInfo) obj;
            boolean z_renamed = hasAddrInfo() == userInfo.hasAddrInfo();
            if (hasAddrInfo()) {
                z_renamed = z_renamed && getAddrInfo().equals(userInfo.getAddrInfo());
            }
            boolean z2 = z_renamed && hasGps() == userInfo.hasGps();
            if (hasGps()) {
                z2 = z2 && getGps().equals(userInfo.getGps());
            }
            return z2 && this.unknownFields.equals(userInfo.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptorForType().hashCode();
            if (hasAddrInfo()) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getAddrInfo().hashCode();
            }
            if (hasGps()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getGps().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static com.oplus.camera.statistics.Position.UserInfo parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.oplus.camera.statistics.Position.UserInfo parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.oplus.camera.statistics.Position.UserInfo parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.oplus.camera.statistics.Position.UserInfo parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.oplus.camera.statistics.Position.UserInfo parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.UserInfo) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.statistics.Position.UserInfo parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.UserInfo) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.statistics.Position.UserInfo parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.UserInfo) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.statistics.Position.UserInfo parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.UserInfo) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.statistics.Position.UserInfo parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.UserInfo) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.oplus.camera.statistics.Position.UserInfo parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.statistics.Position.UserInfo) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.statistics.Position.UserInfo.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.oplus.camera.statistics.Position.UserInfo.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.oplus.camera.statistics.Position.UserInfo.Builder newBuilder(com.oplus.camera.statistics.Position.UserInfo userInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(userInfo);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.statistics.Position.UserInfo.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.oplus.camera.statistics.Position.UserInfo.Builder() : new com.oplus.camera.statistics.Position.UserInfo.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.oplus.camera.statistics.Position.UserInfo.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.oplus.camera.statistics.Position.UserInfo.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.oplus.camera.statistics.Position.UserInfo.Builder> implements com.oplus.camera.statistics.Position.UserInfoOrBuilder {
            private com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.AddrInfo, com.oplus.camera.statistics.Position.AddrInfo.Builder, com.oplus.camera.statistics.Position.AddrInfoOrBuilder> addrInfoBuilder_;
            private com.oplus.camera.statistics.Position.AddrInfo addrInfo_;
            private int bitField0_;
            private com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.LocInfo, com.oplus.camera.statistics.Position.LocInfo.Builder, com.oplus.camera.statistics.Position.LocInfoOrBuilder> gpsBuilder_;
            private com.oplus.camera.statistics.Position.LocInfo gps_;

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_UserInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_UserInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(com.oplus.camera.statistics.Position.UserInfo.class, com.oplus.camera.statistics.Position.UserInfo.Builder.class);
            }

            private Builder() {
                this.addrInfo_ = null;
                this.gps_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.addrInfo_ = null;
                this.gps_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.oplus.camera.statistics.Position.UserInfo.alwaysUseFieldBuilders) {
                    getAddrInfoFieldBuilder();
                    getGpsFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.UserInfo.Builder clear() {
                super.clear();
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.AddrInfo, com.oplus.camera.statistics.Position.AddrInfo.Builder, com.oplus.camera.statistics.Position.AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.addrInfo_ = null;
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -2;
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.LocInfo, com.oplus.camera.statistics.Position.LocInfo.Builder, com.oplus.camera.statistics.Position.LocInfoOrBuilder> singleFieldBuilderV32 = this.gpsBuilder_;
                if (singleFieldBuilderV32 == null) {
                    this.gps_ = null;
                } else {
                    singleFieldBuilderV32.clear();
                }
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.oplus.camera.statistics.Position.internal_static_com_oplus_camera_statistics_UserInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.oplus.camera.statistics.Position.UserInfo getDefaultInstanceForType() {
                return com.oplus.camera.statistics.Position.UserInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.UserInfo build() {
                com.oplus.camera.statistics.Position.UserInfo userInfoBuildPartial = buildPartial();
                if (userInfoBuildPartial.isInitialized()) {
                    return userInfoBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) userInfoBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.UserInfo buildPartial() {
                com.oplus.camera.statistics.Position.UserInfo userInfo = new com.oplus.camera.statistics.Position.UserInfo(this);
                int i_renamed = this.bitField0_;
                int i2 = (i_renamed & 1) != 1 ? 0 : 1;
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.AddrInfo, com.oplus.camera.statistics.Position.AddrInfo.Builder, com.oplus.camera.statistics.Position.AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    userInfo.addrInfo_ = this.addrInfo_;
                } else {
                    userInfo.addrInfo_ = (com.oplus.camera.statistics.Position.AddrInfo) singleFieldBuilderV3.build();
                }
                if ((i_renamed & 2) == 2) {
                    i2 |= 2;
                }
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.LocInfo, com.oplus.camera.statistics.Position.LocInfo.Builder, com.oplus.camera.statistics.Position.LocInfoOrBuilder> singleFieldBuilderV32 = this.gpsBuilder_;
                if (singleFieldBuilderV32 == null) {
                    userInfo.gps_ = this.gps_;
                } else {
                    userInfo.gps_ = (com.oplus.camera.statistics.Position.LocInfo) singleFieldBuilderV32.build();
                }
                userInfo.bitField0_ = i2;
                onBuilt();
                return userInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public com.oplus.camera.statistics.Position.UserInfo.Builder mo23clone() {
                return (com.oplus.camera.statistics.Position.UserInfo.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.UserInfo.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.statistics.Position.UserInfo.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.UserInfo.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.oplus.camera.statistics.Position.UserInfo.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.UserInfo.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.oplus.camera.statistics.Position.UserInfo.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.UserInfo.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.oplus.camera.statistics.Position.UserInfo.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.UserInfo.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.statistics.Position.UserInfo.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.statistics.Position.UserInfo.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.oplus.camera.statistics.Position.UserInfo) {
                    return mergeFrom((com.oplus.camera.statistics.Position.UserInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.oplus.camera.statistics.Position.UserInfo.Builder mergeFrom(com.oplus.camera.statistics.Position.UserInfo userInfo) {
                if (userInfo == com.oplus.camera.statistics.Position.UserInfo.getDefaultInstance()) {
                    return this;
                }
                if (userInfo.hasAddrInfo()) {
                    mergeAddrInfo(userInfo.getAddrInfo());
                }
                if (userInfo.hasGps()) {
                    mergeGps(userInfo.getGps());
                }
                mergeUnknownFields(userInfo.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasAddrInfo() && hasGps() && getAddrInfo().isInitialized() && getGps().isInitialized();
            }

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0021  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.oplus.camera.statistics.Position.UserInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.oplus.camera.statistics.Position$UserInfo> r1 = com.oplus.camera.statistics.Position.UserInfo.PARSER     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    com.oplus.camera.statistics.Position$UserInfo r3 = (com.oplus.camera.statistics.Position.UserInfo) r3     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.mergeFrom(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    com.oplus.camera.statistics.Position$UserInfo r4 = (com.oplus.camera.statistics.Position.UserInfo) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.mergeFrom(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.statistics.Position.UserInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oplus.camera.statistics.Position$UserInfo$Builder");
            }

            @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
            public boolean hasAddrInfo() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
            public com.oplus.camera.statistics.Position.AddrInfo getAddrInfo() {
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.AddrInfo, com.oplus.camera.statistics.Position.AddrInfo.Builder, com.oplus.camera.statistics.Position.AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    com.oplus.camera.statistics.Position.AddrInfo addrInfo = this.addrInfo_;
                    return addrInfo == null ? com.oplus.camera.statistics.Position.AddrInfo.getDefaultInstance() : addrInfo;
                }
                return (com.oplus.camera.statistics.Position.AddrInfo) singleFieldBuilderV3.getMessage();
            }

            public com.oplus.camera.statistics.Position.UserInfo.Builder setAddrInfo(com.oplus.camera.statistics.Position.AddrInfo addrInfo) {
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.AddrInfo, com.oplus.camera.statistics.Position.AddrInfo.Builder, com.oplus.camera.statistics.Position.AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(addrInfo);
                } else {
                    if (addrInfo == null) {
                        throw new java.lang.NullPointerException();
                    }
                    this.addrInfo_ = addrInfo;
                    onChanged();
                }
                this.bitField0_ |= 1;
                return this;
            }

            public com.oplus.camera.statistics.Position.UserInfo.Builder setAddrInfo(com.oplus.camera.statistics.Position.AddrInfo.Builder builder) {
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.AddrInfo, com.oplus.camera.statistics.Position.AddrInfo.Builder, com.oplus.camera.statistics.Position.AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.addrInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 1;
                return this;
            }

            public com.oplus.camera.statistics.Position.UserInfo.Builder mergeAddrInfo(com.oplus.camera.statistics.Position.AddrInfo addrInfo) {
                com.oplus.camera.statistics.Position.AddrInfo addrInfo2;
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.AddrInfo, com.oplus.camera.statistics.Position.AddrInfo.Builder, com.oplus.camera.statistics.Position.AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 1) == 1 && (addrInfo2 = this.addrInfo_) != null && addrInfo2 != com.oplus.camera.statistics.Position.AddrInfo.getDefaultInstance()) {
                        this.addrInfo_ = com.oplus.camera.statistics.Position.AddrInfo.newBuilder(this.addrInfo_).mergeFrom(addrInfo).buildPartial();
                    } else {
                        this.addrInfo_ = addrInfo;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(addrInfo);
                }
                this.bitField0_ |= 1;
                return this;
            }

            public com.oplus.camera.statistics.Position.UserInfo.Builder clearAddrInfo() {
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.AddrInfo, com.oplus.camera.statistics.Position.AddrInfo.Builder, com.oplus.camera.statistics.Position.AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.addrInfo_ = null;
                    onChanged();
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -2;
                return this;
            }

            public com.oplus.camera.statistics.Position.AddrInfo.Builder getAddrInfoBuilder() {
                this.bitField0_ |= 1;
                onChanged();
                return (com.oplus.camera.statistics.Position.AddrInfo.Builder) getAddrInfoFieldBuilder().getBuilder();
            }

            @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
            public com.oplus.camera.statistics.Position.AddrInfoOrBuilder getAddrInfoOrBuilder() {
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.AddrInfo, com.oplus.camera.statistics.Position.AddrInfo.Builder, com.oplus.camera.statistics.Position.AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (com.oplus.camera.statistics.Position.AddrInfoOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                com.oplus.camera.statistics.Position.AddrInfo addrInfo = this.addrInfo_;
                return addrInfo == null ? com.oplus.camera.statistics.Position.AddrInfo.getDefaultInstance() : addrInfo;
            }

            private com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.AddrInfo, com.oplus.camera.statistics.Position.AddrInfo.Builder, com.oplus.camera.statistics.Position.AddrInfoOrBuilder> getAddrInfoFieldBuilder() {
                if (this.addrInfoBuilder_ == null) {
                    this.addrInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<>(getAddrInfo(), getParentForChildren(), isClean());
                    this.addrInfo_ = null;
                }
                return this.addrInfoBuilder_;
            }

            @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
            public boolean hasGps() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
            public com.oplus.camera.statistics.Position.LocInfo getGps() {
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.LocInfo, com.oplus.camera.statistics.Position.LocInfo.Builder, com.oplus.camera.statistics.Position.LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    com.oplus.camera.statistics.Position.LocInfo locInfo = this.gps_;
                    return locInfo == null ? com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance() : locInfo;
                }
                return (com.oplus.camera.statistics.Position.LocInfo) singleFieldBuilderV3.getMessage();
            }

            public com.oplus.camera.statistics.Position.UserInfo.Builder setGps(com.oplus.camera.statistics.Position.LocInfo locInfo) {
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.LocInfo, com.oplus.camera.statistics.Position.LocInfo.Builder, com.oplus.camera.statistics.Position.LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(locInfo);
                } else {
                    if (locInfo == null) {
                        throw new java.lang.NullPointerException();
                    }
                    this.gps_ = locInfo;
                    onChanged();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public com.oplus.camera.statistics.Position.UserInfo.Builder setGps(com.oplus.camera.statistics.Position.LocInfo.Builder builder) {
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.LocInfo, com.oplus.camera.statistics.Position.LocInfo.Builder, com.oplus.camera.statistics.Position.LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.gps_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 2;
                return this;
            }

            public com.oplus.camera.statistics.Position.UserInfo.Builder mergeGps(com.oplus.camera.statistics.Position.LocInfo locInfo) {
                com.oplus.camera.statistics.Position.LocInfo locInfo2;
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.LocInfo, com.oplus.camera.statistics.Position.LocInfo.Builder, com.oplus.camera.statistics.Position.LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 2) == 2 && (locInfo2 = this.gps_) != null && locInfo2 != com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance()) {
                        this.gps_ = com.oplus.camera.statistics.Position.LocInfo.newBuilder(this.gps_).mergeFrom(locInfo).buildPartial();
                    } else {
                        this.gps_ = locInfo;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(locInfo);
                }
                this.bitField0_ |= 2;
                return this;
            }

            public com.oplus.camera.statistics.Position.UserInfo.Builder clearGps() {
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.LocInfo, com.oplus.camera.statistics.Position.LocInfo.Builder, com.oplus.camera.statistics.Position.LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.gps_ = null;
                    onChanged();
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -3;
                return this;
            }

            public com.oplus.camera.statistics.Position.LocInfo.Builder getGpsBuilder() {
                this.bitField0_ |= 2;
                onChanged();
                return (com.oplus.camera.statistics.Position.LocInfo.Builder) getGpsFieldBuilder().getBuilder();
            }

            @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
            public com.oplus.camera.statistics.Position.LocInfoOrBuilder getGpsOrBuilder() {
                com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.LocInfo, com.oplus.camera.statistics.Position.LocInfo.Builder, com.oplus.camera.statistics.Position.LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (com.oplus.camera.statistics.Position.LocInfoOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                com.oplus.camera.statistics.Position.LocInfo locInfo = this.gps_;
                return locInfo == null ? com.oplus.camera.statistics.Position.LocInfo.getDefaultInstance() : locInfo;
            }

            private com.google.protobuf.SingleFieldBuilderV3<com.oplus.camera.statistics.Position.LocInfo, com.oplus.camera.statistics.Position.LocInfo.Builder, com.oplus.camera.statistics.Position.LocInfoOrBuilder> getGpsFieldBuilder() {
                if (this.gpsBuilder_ == null) {
                    this.gpsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<>(getGps(), getParentForChildren(), isClean());
                    this.gps_ = null;
                }
                return this.gpsBuilder_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.statistics.Position.UserInfo.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.statistics.Position.UserInfo.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.statistics.Position.UserInfo.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.statistics.Position.UserInfo.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.oplus.camera.statistics.Position.UserInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.oplus.camera.statistics.Position.UserInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.oplus.camera.statistics.Position.UserInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.oplus.camera.statistics.Position.UserInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new java.lang.String[]{"\n_renamed\u000ePosition.proto\u0012\u001acom.oplus.camera.statistics\"Y_renamed\n_renamed\bAddrInfo\u0012\u000e\n_renamed\u0006street\u0018\u0001 \u0002(\t_renamed\u0012\f_renamed\n_renamed\u0004area\u0018\u0002 \u0002(\t_renamed\u0012\f_renamed\n_renamed\u0004city\u0018\u0003 \u0002(\t_renamed\u0012\u0010\n_renamed\bprovince\u0018\u0004 \u0002(\t_renamed\u0012\u000f\n_renamed\u0007country\u0018\u0005 \u0002(\t_renamed\"¸\u0001\n_renamed\u0007LocInfo\u0012\u000b\n_renamed\u0003mcc\u0018\u0001 \u0002(\t_renamed\u0012\u000b\n_renamed\u0003mnc\u0018\u0002 \u0002(\t_renamed\u0012\u000b\n_renamed\u0003lac\u0018\u0003 \u0002(\t_renamed\u0012\u000b\n_renamed\u0003cid\u0018\u0004 \u0002(\t_renamed\u0012\f_renamed\n_renamed\u0004\u0018\u0005 \u0002(\t_renamed\u0012\u000b\n_renamed\u0003lat\u0018\u0006 \u0002(\u0002\u0012\f_renamed\n_renamed\u0004long\u0018\u0007 \u0002(\u0002\u0012\f_renamed\n_renamed\u0004pcba\u0018\b_renamed \u0001(\t_renamed\u0012\f_renamed\n_renamed\u0004ssid\u0018\t_renamed \u0001(\t_renamed\u0012\r_renamed\n_renamed\u0005bssid\u0018\n_renamed \u0001(\t_renamed\u0012\u000b\n_renamed\u0003sid\u0018\u000b \u0001(\t_renamed\u0012\u000b\n_renamed\u0003nid\u0018\f_renamed \u0001(\t_renamed\u0012\u000b\n_renamed\u0003bid\u0018\r_renamed \u0001(\t_renamed\"t_renamed\n_renamed\bUserInfo\u00126\n_renamed\baddrInfo\u0018\u0001 \u0002(\u000b2$.com.oplus.camera.statistics.AddrInfo\u00120\n_renamed\u0003gps\u0018\u0002 ", "\u0002(\u000b2#.com.oplus.camera.statistics.LocInfoB\nB\bPosition"}, new com.google.protobuf.Descriptors.FileDescriptor[0], new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: com.oplus.camera.statistics.Position.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public com.google.protobuf.ExtensionRegistry assignDescriptors(com.google.protobuf.Descriptors.FileDescriptor fileDescriptor) {
                com.google.protobuf.Descriptors.FileDescriptor unused = com.oplus.camera.statistics.Position.descriptor = fileDescriptor;
                return null;
            }
        });
        internal_static_com_oplus_camera_statistics_AddrInfo_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_com_oplus_camera_statistics_AddrInfo_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_com_oplus_camera_statistics_AddrInfo_descriptor, new java.lang.String[]{"Street", "Area", "City", "Province", "Country"});
        internal_static_com_oplus_camera_statistics_LocInfo_descriptor = getDescriptor().getMessageTypes().get(1);
        internal_static_com_oplus_camera_statistics_LocInfo_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_com_oplus_camera_statistics_LocInfo_descriptor, new java.lang.String[]{"Mcc", "Mnc", "Lac", "Cid", "Lat", "Long", "Pcba", "Ssid", "Bssid", "Sid", "Nid", "Bid"});
        internal_static_com_oplus_camera_statistics_UserInfo_descriptor = getDescriptor().getMessageTypes().get(2);
        internal_static_com_oplus_camera_statistics_UserInfo_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_com_oplus_camera_statistics_UserInfo_descriptor, new java.lang.String[]{"AddrInfo", "Gps"});
    }
}
