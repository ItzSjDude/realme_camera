package com.oplus.camera.statistics;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class Position {
    private static Descriptors.FileDescriptor descriptor;

    /* renamed from: internal_static_com_oplus_camera_statistics_AddrInfo_descriptor */
    private static final Descriptors.Descriptor f16164x8552eb8a;

    /* renamed from: internal_static_com_oplus_camera_statistics_AddrInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f16165xf58ae808;

    /* renamed from: internal_static_com_oplus_camera_statistics_LocInfo_descriptor */
    private static final Descriptors.Descriptor f16166xcc19c4c5;

    /* renamed from: internal_static_com_oplus_camera_statistics_LocInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f16167x442e5643;

    /* renamed from: internal_static_com_oplus_camera_statistics_UserInfo_descriptor */
    private static final Descriptors.Descriptor f16168x6bd8ac70;

    /* renamed from: internal_static_com_oplus_camera_statistics_UserInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f16169xfcc62ee;

    public interface AddrInfoOrBuilder extends MessageOrBuilder {
        String getArea();

        ByteString getAreaBytes();

        String getCity();

        ByteString getCityBytes();

        String getCountry();

        ByteString getCountryBytes();

        String getProvince();

        ByteString getProvinceBytes();

        String getStreet();

        ByteString getStreetBytes();

        boolean hasArea();

        boolean hasCity();

        boolean hasCountry();

        boolean hasProvince();

        boolean hasStreet();
    }

    public interface LocInfoOrBuilder extends MessageOrBuilder {
        String getBid();

        ByteString getBidBytes();

        String getBssid();

        ByteString getBssidBytes();

        String getCid();

        ByteString getCidBytes();

        String getLac();

        ByteString getLacBytes();

        float getLat();

        float getLong();

        String getMcc();

        ByteString getMccBytes();

        String getMnc();

        ByteString getMncBytes();

        String getNid();

        ByteString getNidBytes();

        String getPcba();

        ByteString getPcbaBytes();

        String getSid();

        ByteString getSidBytes();

        String getSsid();

        ByteString getSsidBytes();

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

    public interface UserInfoOrBuilder extends MessageOrBuilder {
        AddrInfo getAddrInfo();

        AddrInfoOrBuilder getAddrInfoOrBuilder();

        LocInfo getGps();

        LocInfoOrBuilder getGpsOrBuilder();

        boolean hasAddrInfo();

        boolean hasGps();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Position() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static final class AddrInfo extends GeneratedMessageV3 implements AddrInfoOrBuilder {
        public static final int AREA_FIELD_NUMBER = 2;
        public static final int CITY_FIELD_NUMBER = 3;
        public static final int COUNTRY_FIELD_NUMBER = 5;
        private static final AddrInfo DEFAULT_INSTANCE = new AddrInfo();

        @Deprecated
        public static final Parser<AddrInfo> PARSER = new AbstractParser<AddrInfo>() { // from class: com.oplus.camera.statistics.Position.AddrInfo.1
            @Override // com.google.protobuf.Parser
            public AddrInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AddrInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PROVINCE_FIELD_NUMBER = 4;
        public static final int STREET_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object area_;
        private int bitField0_;
        private volatile Object city_;
        private volatile Object country_;
        private byte memoizedIsInitialized;
        private volatile Object province_;
        private volatile Object street_;

        private AddrInfo(GeneratedMessageV3.Builder<?> builder) {
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
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AddrInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                ByteString bytes = codedInputStream.readBytes();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.street_ = bytes;
                            } else if (tag == 18) {
                                ByteString bytes2 = codedInputStream.readBytes();
                                this.bitField0_ |= 2;
                                this.area_ = bytes2;
                            } else if (tag == 26) {
                                ByteString bytes3 = codedInputStream.readBytes();
                                this.bitField0_ |= 4;
                                this.city_ = bytes3;
                            } else if (tag == 34) {
                                ByteString bytes4 = codedInputStream.readBytes();
                                this.bitField0_ |= 8;
                                this.province_ = bytes4;
                            } else if (tag != 42) {
                                if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                }
                            } else {
                                ByteString bytes5 = codedInputStream.readBytes();
                                this.bitField0_ |= 16;
                                this.country_ = bytes5;
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException COUIBaseListPopupWindow_8) {
                        throw COUIBaseListPopupWindow_8.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Position.f16164x8552eb8a;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Position.f16165xf58ae808.ensureFieldAccessorsInitialized(AddrInfo.class, Builder.class);
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public boolean hasStreet() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public String getStreet() {
            Object obj = this.street_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.street_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public ByteString getStreetBytes() {
            Object obj = this.street_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.street_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public boolean hasArea() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public String getArea() {
            Object obj = this.area_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.area_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public ByteString getAreaBytes() {
            Object obj = this.area_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.area_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public boolean hasCity() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public String getCity() {
            Object obj = this.city_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.city_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public ByteString getCityBytes() {
            Object obj = this.city_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.city_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public boolean hasProvince() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public String getProvince() {
            Object obj = this.province_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.province_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public ByteString getProvinceBytes() {
            Object obj = this.province_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.province_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public boolean hasCountry() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public String getCountry() {
            Object obj = this.country_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.country_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
        public ByteString getCountryBytes() {
            Object obj = this.country_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.country_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
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
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.street_);
            }
            if ((this.bitField0_ & 2) == 2) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.area_);
            }
            if ((this.bitField0_ & 4) == 4) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.city_);
            }
            if ((this.bitField0_ & 8) == 8) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.province_);
            }
            if ((this.bitField0_ & 16) == 16) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.country_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int OplusGLSurfaceView_13 = this.memoizedSize;
            if (OplusGLSurfaceView_13 != -1) {
                return OplusGLSurfaceView_13;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + GeneratedMessageV3.computeStringSize(1, this.street_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(2, this.area_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(3, this.city_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(4, this.province_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(5, this.country_);
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AddrInfo)) {
                return super.equals(obj);
            }
            AddrInfo addrInfo = (AddrInfo) obj;
            boolean z = hasStreet() == addrInfo.hasStreet();
            if (hasStreet()) {
                z = z && getStreet().equals(addrInfo.getStreet());
            }
            boolean z2 = z && hasArea() == addrInfo.hasArea();
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

        public static AddrInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AddrInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AddrInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AddrInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AddrInfo parseFrom(InputStream inputStream) throws IOException {
            return (AddrInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AddrInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AddrInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AddrInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AddrInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AddrInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AddrInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AddrInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AddrInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AddrInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AddrInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AddrInfo addrInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(addrInfo);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AddrInfoOrBuilder {
            private Object area_;
            private int bitField0_;
            private Object city_;
            private Object country_;
            private Object province_;
            private Object street_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Position.f16164x8552eb8a;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Position.f16165xf58ae808.ensureFieldAccessorsInitialized(AddrInfo.class, Builder.class);
            }

            private Builder() {
                this.street_ = "";
                this.area_ = "";
                this.city_ = "";
                this.province_ = "";
                this.country_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.street_ = "";
                this.area_ = "";
                this.city_ = "";
                this.province_ = "";
                this.country_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = AddrInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
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
            public Descriptors.Descriptor getDescriptorForType() {
                return Position.f16164x8552eb8a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AddrInfo getDefaultInstanceForType() {
                return AddrInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AddrInfo build() {
                AddrInfo addrInfoBuildPartial = buildPartial();
                if (addrInfoBuildPartial.isInitialized()) {
                    return addrInfoBuildPartial;
                }
                throw newUninitializedMessageException((Message) addrInfoBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AddrInfo buildPartial() {
                AddrInfo addrInfo = new AddrInfo(this);
                int OplusGLSurfaceView_13 = this.bitField0_;
                int i2 = (OplusGLSurfaceView_13 & 1) != 1 ? 0 : 1;
                addrInfo.street_ = this.street_;
                if ((OplusGLSurfaceView_13 & 2) == 2) {
                    i2 |= 2;
                }
                addrInfo.area_ = this.area_;
                if ((OplusGLSurfaceView_13 & 4) == 4) {
                    i2 |= 4;
                }
                addrInfo.city_ = this.city_;
                if ((OplusGLSurfaceView_13 & 8) == 8) {
                    i2 |= 8;
                }
                addrInfo.province_ = this.province_;
                if ((OplusGLSurfaceView_13 & 16) == 16) {
                    i2 |= 16;
                }
                addrInfo.country_ = this.country_;
                addrInfo.bitField0_ = i2;
                onBuilt();
                return addrInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo26289clone() {
                return (Builder) super.mo26289clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int OplusGLSurfaceView_13, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, OplusGLSurfaceView_13, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof AddrInfo) {
                    return mergeFrom((AddrInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(AddrInfo addrInfo) {
                if (addrInfo == AddrInfo.getDefaultInstance()) {
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

            /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
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
            public String getStreet() {
                Object obj = this.street_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.street_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public ByteString getStreetBytes() {
                Object obj = this.street_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.street_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setStreet(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.street_ = str;
                onChanged();
                return this;
            }

            public Builder clearStreet() {
                this.bitField0_ &= -2;
                this.street_ = AddrInfo.getDefaultInstance().getStreet();
                onChanged();
                return this;
            }

            public Builder setStreetBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
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
            public String getArea() {
                Object obj = this.area_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.area_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public ByteString getAreaBytes() {
                Object obj = this.area_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.area_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setArea(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.area_ = str;
                onChanged();
                return this;
            }

            public Builder clearArea() {
                this.bitField0_ &= -3;
                this.area_ = AddrInfo.getDefaultInstance().getArea();
                onChanged();
                return this;
            }

            public Builder setAreaBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
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
            public String getCity() {
                Object obj = this.city_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.city_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public ByteString getCityBytes() {
                Object obj = this.city_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.city_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setCity(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.city_ = str;
                onChanged();
                return this;
            }

            public Builder clearCity() {
                this.bitField0_ &= -5;
                this.city_ = AddrInfo.getDefaultInstance().getCity();
                onChanged();
                return this;
            }

            public Builder setCityBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
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
            public String getProvince() {
                Object obj = this.province_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.province_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public ByteString getProvinceBytes() {
                Object obj = this.province_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.province_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setProvince(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.province_ = str;
                onChanged();
                return this;
            }

            public Builder clearProvince() {
                this.bitField0_ &= -9;
                this.province_ = AddrInfo.getDefaultInstance().getProvince();
                onChanged();
                return this;
            }

            public Builder setProvinceBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
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
            public String getCountry() {
                Object obj = this.country_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.country_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.AddrInfoOrBuilder
            public ByteString getCountryBytes() {
                Object obj = this.country_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.country_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setCountry(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.country_ = str;
                onChanged();
                return this;
            }

            public Builder clearCountry() {
                this.bitField0_ &= -17;
                this.country_ = AddrInfo.getDefaultInstance().getCountry();
                onChanged();
                return this;
            }

            public Builder setCountryBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.country_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static AddrInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AddrInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AddrInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AddrInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class LocInfo extends GeneratedMessageV3 implements LocInfoOrBuilder {
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
        private volatile Object bid_;
        private int bitField0_;
        private volatile Object bssid_;
        private volatile Object cid_;
        private volatile Object lac_;
        private float lat_;
        private float long_;
        private volatile Object mcc_;
        private byte memoizedIsInitialized;
        private volatile Object mnc_;
        private volatile Object nid_;
        private volatile Object pcba_;
        private volatile Object sid_;
        private volatile Object ssid_;
        private static final LocInfo DEFAULT_INSTANCE = new LocInfo();

        @Deprecated
        public static final Parser<LocInfo> PARSER = new AbstractParser<LocInfo>() { // from class: com.oplus.camera.statistics.Position.LocInfo.1
            @Override // com.google.protobuf.Parser
            public LocInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LocInfo(codedInputStream, extensionRegistryLite);
            }
        };

        private LocInfo(GeneratedMessageV3.Builder<?> builder) {
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
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LocInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        switch (tag) {
                            case 0:
                                z = true;
                            case 10:
                                ByteString bytes = codedInputStream.readBytes();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.mcc_ = bytes;
                            case 18:
                                ByteString bytes2 = codedInputStream.readBytes();
                                this.bitField0_ |= 2;
                                this.mnc_ = bytes2;
                            case 26:
                                ByteString bytes3 = codedInputStream.readBytes();
                                this.bitField0_ |= 4;
                                this.lac_ = bytes3;
                            case 34:
                                ByteString bytes4 = codedInputStream.readBytes();
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
                                ByteString bytes5 = codedInputStream.readBytes();
                                this.bitField0_ |= 128;
                                this.pcba_ = bytes5;
                            case 74:
                                ByteString bytes6 = codedInputStream.readBytes();
                                this.bitField0_ |= 256;
                                this.ssid_ = bytes6;
                            case 82:
                                ByteString bytes7 = codedInputStream.readBytes();
                                this.bitField0_ |= 512;
                                this.bssid_ = bytes7;
                            case 90:
                                ByteString bytes8 = codedInputStream.readBytes();
                                this.bitField0_ |= 1024;
                                this.sid_ = bytes8;
                            case 98:
                                ByteString bytes9 = codedInputStream.readBytes();
                                this.bitField0_ |= 2048;
                                this.nid_ = bytes9;
                            case 106:
                                ByteString bytes10 = codedInputStream.readBytes();
                                this.bitField0_ |= 4096;
                                this.bid_ = bytes10;
                            default:
                                if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                    z = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException COUIBaseListPopupWindow_8) {
                        throw COUIBaseListPopupWindow_8.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Position.f16166xcc19c4c5;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Position.f16167x442e5643.ensureFieldAccessorsInitialized(LocInfo.class, Builder.class);
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasMcc() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public String getMcc() {
            Object obj = this.mcc_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.mcc_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public ByteString getMccBytes() {
            Object obj = this.mcc_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mcc_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasMnc() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public String getMnc() {
            Object obj = this.mnc_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.mnc_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public ByteString getMncBytes() {
            Object obj = this.mnc_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mnc_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasLac() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public String getLac() {
            Object obj = this.lac_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.lac_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public ByteString getLacBytes() {
            Object obj = this.lac_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lac_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasCid() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public String getCid() {
            Object obj = this.cid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.cid_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public ByteString getCidBytes() {
            Object obj = this.cid_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
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
        public String getPcba() {
            Object obj = this.pcba_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.pcba_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public ByteString getPcbaBytes() {
            Object obj = this.pcba_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.pcba_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasSsid() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public String getSsid() {
            Object obj = this.ssid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ssid_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public ByteString getSsidBytes() {
            Object obj = this.ssid_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ssid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasBssid() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public String getBssid() {
            Object obj = this.bssid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.bssid_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public ByteString getBssidBytes() {
            Object obj = this.bssid_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bssid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasSid() {
            return (this.bitField0_ & 1024) == 1024;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public String getSid() {
            Object obj = this.sid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.sid_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public ByteString getSidBytes() {
            Object obj = this.sid_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasNid() {
            return (this.bitField0_ & 2048) == 2048;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public String getNid() {
            Object obj = this.nid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.nid_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public ByteString getNidBytes() {
            Object obj = this.nid_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public boolean hasBid() {
            return (this.bitField0_ & 4096) == 4096;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public String getBid() {
            Object obj = this.bid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.bid_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
        public ByteString getBidBytes() {
            Object obj = this.bid_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
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
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.mcc_);
            }
            if ((this.bitField0_ & 2) == 2) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.mnc_);
            }
            if ((this.bitField0_ & 4) == 4) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.lac_);
            }
            if ((this.bitField0_ & 8) == 8) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.cid_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeFloat(6, this.lat_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeFloat(7, this.long_);
            }
            if ((this.bitField0_ & 128) == 128) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.pcba_);
            }
            if ((this.bitField0_ & 256) == 256) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.ssid_);
            }
            if ((this.bitField0_ & 512) == 512) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.bssid_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.sid_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.nid_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.bid_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int OplusGLSurfaceView_13 = this.memoizedSize;
            if (OplusGLSurfaceView_13 != -1) {
                return OplusGLSurfaceView_13;
            }
            int iComputeStringSize = (this.bitField0_ & 1) == 1 ? 0 + GeneratedMessageV3.computeStringSize(1, this.mcc_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(2, this.mnc_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(3, this.lac_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(4, this.cid_);
            }
            if ((this.bitField0_ & 32) == 32) {
                iComputeStringSize += CodedOutputStream.computeFloatSize(6, this.lat_);
            }
            if ((this.bitField0_ & 64) == 64) {
                iComputeStringSize += CodedOutputStream.computeFloatSize(7, this.long_);
            }
            if ((this.bitField0_ & 128) == 128) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(8, this.pcba_);
            }
            if ((this.bitField0_ & 256) == 256) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(9, this.ssid_);
            }
            if ((this.bitField0_ & 512) == 512) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(10, this.bssid_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(11, this.sid_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(12, this.nid_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(13, this.bid_);
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LocInfo)) {
                return super.equals(obj);
            }
            LocInfo locInfo = (LocInfo) obj;
            boolean z = hasMcc() == locInfo.hasMcc();
            if (hasMcc()) {
                z = z && getMcc().equals(locInfo.getMcc());
            }
            boolean z2 = z && hasMnc() == locInfo.hasMnc();
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
                z5 = z5 && Float.floatToIntBits(getLat()) == Float.floatToIntBits(locInfo.getLat());
            }
            boolean z6 = z5 && hasLong() == locInfo.hasLong();
            if (hasLong()) {
                z6 = z6 && Float.floatToIntBits(getLong()) == Float.floatToIntBits(locInfo.getLong());
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
                iHashCode = (((iHashCode * 37) + 6) * 53) + Float.floatToIntBits(getLat());
            }
            if (hasLong()) {
                iHashCode = (((iHashCode * 37) + 7) * 53) + Float.floatToIntBits(getLong());
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

        public static LocInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LocInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LocInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LocInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LocInfo parseFrom(InputStream inputStream) throws IOException {
            return (LocInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LocInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LocInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LocInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LocInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LocInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LocInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LocInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LocInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LocInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LocInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LocInfo locInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(locInfo);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LocInfoOrBuilder {
            private Object bid_;
            private int bitField0_;
            private Object bssid_;
            private Object cid_;
            private Object lac_;
            private float lat_;
            private float long_;
            private Object mcc_;
            private Object mnc_;
            private Object nid_;
            private Object pcba_;
            private Object sid_;
            private Object ssid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Position.f16166xcc19c4c5;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Position.f16167x442e5643.ensureFieldAccessorsInitialized(LocInfo.class, Builder.class);
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

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
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
                boolean unused = LocInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
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
            public Descriptors.Descriptor getDescriptorForType() {
                return Position.f16166xcc19c4c5;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LocInfo getDefaultInstanceForType() {
                return LocInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LocInfo build() {
                LocInfo locInfoBuildPartial = buildPartial();
                if (locInfoBuildPartial.isInitialized()) {
                    return locInfoBuildPartial;
                }
                throw newUninitializedMessageException((Message) locInfoBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LocInfo buildPartial() {
                LocInfo locInfo = new LocInfo(this);
                int OplusGLSurfaceView_13 = this.bitField0_;
                int i2 = (OplusGLSurfaceView_13 & 1) != 1 ? 0 : 1;
                locInfo.mcc_ = this.mcc_;
                if ((OplusGLSurfaceView_13 & 2) == 2) {
                    i2 |= 2;
                }
                locInfo.mnc_ = this.mnc_;
                if ((OplusGLSurfaceView_13 & 4) == 4) {
                    i2 |= 4;
                }
                locInfo.lac_ = this.lac_;
                if ((OplusGLSurfaceView_13 & 8) == 8) {
                    i2 |= 8;
                }
                locInfo.cid_ = this.cid_;
                if ((OplusGLSurfaceView_13 & 16) == 16) {
                    i2 |= 16;
                }
                if ((OplusGLSurfaceView_13 & 32) == 32) {
                    i2 |= 32;
                }
                locInfo.lat_ = this.lat_;
                if ((OplusGLSurfaceView_13 & 64) == 64) {
                    i2 |= 64;
                }
                locInfo.long_ = this.long_;
                if ((OplusGLSurfaceView_13 & 128) == 128) {
                    i2 |= 128;
                }
                locInfo.pcba_ = this.pcba_;
                if ((OplusGLSurfaceView_13 & 256) == 256) {
                    i2 |= 256;
                }
                locInfo.ssid_ = this.ssid_;
                if ((OplusGLSurfaceView_13 & 512) == 512) {
                    i2 |= 512;
                }
                locInfo.bssid_ = this.bssid_;
                if ((OplusGLSurfaceView_13 & 1024) == 1024) {
                    i2 |= 1024;
                }
                locInfo.sid_ = this.sid_;
                if ((OplusGLSurfaceView_13 & 2048) == 2048) {
                    i2 |= 2048;
                }
                locInfo.nid_ = this.nid_;
                if ((OplusGLSurfaceView_13 & 4096) == 4096) {
                    i2 |= 4096;
                }
                locInfo.bid_ = this.bid_;
                locInfo.bitField0_ = i2;
                onBuilt();
                return locInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo26289clone() {
                return (Builder) super.mo26289clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int OplusGLSurfaceView_13, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, OplusGLSurfaceView_13, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof LocInfo) {
                    return mergeFrom((LocInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(LocInfo locInfo) {
                if (locInfo == LocInfo.getDefaultInstance()) {
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

            /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
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
            public String getMcc() {
                Object obj = this.mcc_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.mcc_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public ByteString getMccBytes() {
                Object obj = this.mcc_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.mcc_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setMcc(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.mcc_ = str;
                onChanged();
                return this;
            }

            public Builder clearMcc() {
                this.bitField0_ &= -2;
                this.mcc_ = LocInfo.getDefaultInstance().getMcc();
                onChanged();
                return this;
            }

            public Builder setMccBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
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
            public String getMnc() {
                Object obj = this.mnc_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.mnc_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public ByteString getMncBytes() {
                Object obj = this.mnc_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.mnc_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setMnc(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.mnc_ = str;
                onChanged();
                return this;
            }

            public Builder clearMnc() {
                this.bitField0_ &= -3;
                this.mnc_ = LocInfo.getDefaultInstance().getMnc();
                onChanged();
                return this;
            }

            public Builder setMncBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
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
            public String getLac() {
                Object obj = this.lac_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.lac_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public ByteString getLacBytes() {
                Object obj = this.lac_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.lac_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setLac(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.lac_ = str;
                onChanged();
                return this;
            }

            public Builder clearLac() {
                this.bitField0_ &= -5;
                this.lac_ = LocInfo.getDefaultInstance().getLac();
                onChanged();
                return this;
            }

            public Builder setLacBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
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
            public String getCid() {
                Object obj = this.cid_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.cid_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public ByteString getCidBytes() {
                Object obj = this.cid_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.cid_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setCid(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.cid_ = str;
                onChanged();
                return this;
            }

            public Builder clearCid() {
                this.bitField0_ &= -9;
                this.cid_ = LocInfo.getDefaultInstance().getCid();
                onChanged();
                return this;
            }

            public Builder setCidBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
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

            public Builder setLat(float COUIBaseListPopupWindow_12) {
                this.bitField0_ |= 32;
                this.lat_ = COUIBaseListPopupWindow_12;
                onChanged();
                return this;
            }

            public Builder clearLat() {
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

            public Builder setLong(float COUIBaseListPopupWindow_12) {
                this.bitField0_ |= 64;
                this.long_ = COUIBaseListPopupWindow_12;
                onChanged();
                return this;
            }

            public Builder clearLong() {
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
            public String getPcba() {
                Object obj = this.pcba_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.pcba_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public ByteString getPcbaBytes() {
                Object obj = this.pcba_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.pcba_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setPcba(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 128;
                this.pcba_ = str;
                onChanged();
                return this;
            }

            public Builder clearPcba() {
                this.bitField0_ &= -129;
                this.pcba_ = LocInfo.getDefaultInstance().getPcba();
                onChanged();
                return this;
            }

            public Builder setPcbaBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
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
            public String getSsid() {
                Object obj = this.ssid_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.ssid_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public ByteString getSsidBytes() {
                Object obj = this.ssid_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ssid_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setSsid(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 256;
                this.ssid_ = str;
                onChanged();
                return this;
            }

            public Builder clearSsid() {
                this.bitField0_ &= -257;
                this.ssid_ = LocInfo.getDefaultInstance().getSsid();
                onChanged();
                return this;
            }

            public Builder setSsidBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
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
            public String getBssid() {
                Object obj = this.bssid_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.bssid_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public ByteString getBssidBytes() {
                Object obj = this.bssid_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.bssid_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setBssid(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 512;
                this.bssid_ = str;
                onChanged();
                return this;
            }

            public Builder clearBssid() {
                this.bitField0_ &= -513;
                this.bssid_ = LocInfo.getDefaultInstance().getBssid();
                onChanged();
                return this;
            }

            public Builder setBssidBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
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
            public String getSid() {
                Object obj = this.sid_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.sid_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public ByteString getSidBytes() {
                Object obj = this.sid_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.sid_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setSid(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1024;
                this.sid_ = str;
                onChanged();
                return this;
            }

            public Builder clearSid() {
                this.bitField0_ &= -1025;
                this.sid_ = LocInfo.getDefaultInstance().getSid();
                onChanged();
                return this;
            }

            public Builder setSidBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
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
            public String getNid() {
                Object obj = this.nid_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.nid_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public ByteString getNidBytes() {
                Object obj = this.nid_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.nid_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setNid(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2048;
                this.nid_ = str;
                onChanged();
                return this;
            }

            public Builder clearNid() {
                this.bitField0_ &= -2049;
                this.nid_ = LocInfo.getDefaultInstance().getNid();
                onChanged();
                return this;
            }

            public Builder setNidBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
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
            public String getBid() {
                Object obj = this.bid_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.bid_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.oplus.camera.statistics.Position.LocInfoOrBuilder
            public ByteString getBidBytes() {
                Object obj = this.bid_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.bid_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setBid(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4096;
                this.bid_ = str;
                onChanged();
                return this;
            }

            public Builder clearBid() {
                this.bitField0_ &= -4097;
                this.bid_ = LocInfo.getDefaultInstance().getBid();
                onChanged();
                return this;
            }

            public Builder setBidBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4096;
                this.bid_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static LocInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LocInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LocInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LocInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class UserInfo extends GeneratedMessageV3 implements UserInfoOrBuilder {
        public static final int ADDRINFO_FIELD_NUMBER = 1;
        public static final int GPS_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private AddrInfo addrInfo_;
        private int bitField0_;
        private LocInfo gps_;
        private byte memoizedIsInitialized;
        private static final UserInfo DEFAULT_INSTANCE = new UserInfo();

        @Deprecated
        public static final Parser<UserInfo> PARSER = new AbstractParser<UserInfo>() { // from class: com.oplus.camera.statistics.Position.UserInfo.1
            @Override // com.google.protobuf.Parser
            public UserInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new UserInfo(codedInputStream, extensionRegistryLite);
            }
        };

        private UserInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private UserInfo() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UserInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    AddrInfo.Builder builder = (this.bitField0_ & 1) == 1 ? this.addrInfo_.toBuilder() : null;
                                    this.addrInfo_ = (AddrInfo) codedInputStream.readMessage(AddrInfo.PARSER, extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.addrInfo_);
                                        this.addrInfo_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (tag != 18) {
                                    if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                    }
                                } else {
                                    LocInfo.Builder builder2 = (this.bitField0_ & 2) == 2 ? this.gps_.toBuilder() : null;
                                    this.gps_ = (LocInfo) codedInputStream.readMessage(LocInfo.PARSER, extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom(this.gps_);
                                        this.gps_ = builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException COUIBaseListPopupWindow_8) {
                            throw COUIBaseListPopupWindow_8.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Position.f16168x6bd8ac70;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Position.f16169xfcc62ee.ensureFieldAccessorsInitialized(UserInfo.class, Builder.class);
        }

        @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
        public boolean hasAddrInfo() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
        public AddrInfo getAddrInfo() {
            AddrInfo addrInfo = this.addrInfo_;
            return addrInfo == null ? AddrInfo.getDefaultInstance() : addrInfo;
        }

        @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
        public AddrInfoOrBuilder getAddrInfoOrBuilder() {
            AddrInfo addrInfo = this.addrInfo_;
            return addrInfo == null ? AddrInfo.getDefaultInstance() : addrInfo;
        }

        @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
        public boolean hasGps() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
        public LocInfo getGps() {
            LocInfo locInfo = this.gps_;
            return locInfo == null ? LocInfo.getDefaultInstance() : locInfo;
        }

        @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
        public LocInfoOrBuilder getGpsOrBuilder() {
            LocInfo locInfo = this.gps_;
            return locInfo == null ? LocInfo.getDefaultInstance() : locInfo;
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
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
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
            int OplusGLSurfaceView_13 = this.memoizedSize;
            if (OplusGLSurfaceView_13 != -1) {
                return OplusGLSurfaceView_13;
            }
            int iComputeMessageSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, getAddrInfo()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(2, getGps());
            }
            int serializedSize = iComputeMessageSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UserInfo)) {
                return super.equals(obj);
            }
            UserInfo userInfo = (UserInfo) obj;
            boolean z = hasAddrInfo() == userInfo.hasAddrInfo();
            if (hasAddrInfo()) {
                z = z && getAddrInfo().equals(userInfo.getAddrInfo());
            }
            boolean z2 = z && hasGps() == userInfo.hasGps();
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

        public static UserInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static UserInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static UserInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UserInfo parseFrom(InputStream inputStream) throws IOException {
            return (UserInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UserInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UserInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UserInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static UserInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UserInfo userInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(userInfo);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserInfoOrBuilder {
            private SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> addrInfoBuilder_;
            private AddrInfo addrInfo_;
            private int bitField0_;
            private SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> gpsBuilder_;
            private LocInfo gps_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Position.f16168x6bd8ac70;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Position.f16169xfcc62ee.ensureFieldAccessorsInitialized(UserInfo.class, Builder.class);
            }

            private Builder() {
                this.addrInfo_ = null;
                this.gps_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.addrInfo_ = null;
                this.gps_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UserInfo.alwaysUseFieldBuilders) {
                    getAddrInfoFieldBuilder();
                    getGpsFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.addrInfo_ = null;
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -2;
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV32 = this.gpsBuilder_;
                if (singleFieldBuilderV32 == null) {
                    this.gps_ = null;
                } else {
                    singleFieldBuilderV32.clear();
                }
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Position.f16168x6bd8ac70;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UserInfo getDefaultInstanceForType() {
                return UserInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UserInfo build() {
                UserInfo userInfoBuildPartial = buildPartial();
                if (userInfoBuildPartial.isInitialized()) {
                    return userInfoBuildPartial;
                }
                throw newUninitializedMessageException((Message) userInfoBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UserInfo buildPartial() {
                UserInfo userInfo = new UserInfo(this);
                int OplusGLSurfaceView_13 = this.bitField0_;
                int i2 = (OplusGLSurfaceView_13 & 1) != 1 ? 0 : 1;
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    userInfo.addrInfo_ = this.addrInfo_;
                } else {
                    userInfo.addrInfo_ = (AddrInfo) singleFieldBuilderV3.build();
                }
                if ((OplusGLSurfaceView_13 & 2) == 2) {
                    i2 |= 2;
                }
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV32 = this.gpsBuilder_;
                if (singleFieldBuilderV32 == null) {
                    userInfo.gps_ = this.gps_;
                } else {
                    userInfo.gps_ = (LocInfo) singleFieldBuilderV32.build();
                }
                userInfo.bitField0_ = i2;
                onBuilt();
                return userInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo26289clone() {
                return (Builder) super.mo26289clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int OplusGLSurfaceView_13, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, OplusGLSurfaceView_13, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof UserInfo) {
                    return mergeFrom((UserInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(UserInfo userInfo) {
                if (userInfo == UserInfo.getDefaultInstance()) {
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

            /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
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
            public AddrInfo getAddrInfo() {
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    AddrInfo addrInfo = this.addrInfo_;
                    return addrInfo == null ? AddrInfo.getDefaultInstance() : addrInfo;
                }
                return (AddrInfo) singleFieldBuilderV3.getMessage();
            }

            public Builder setAddrInfo(AddrInfo addrInfo) {
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(addrInfo);
                } else {
                    if (addrInfo == null) {
                        throw new NullPointerException();
                    }
                    this.addrInfo_ = addrInfo;
                    onChanged();
                }
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setAddrInfo(AddrInfo.Builder builder) {
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.addrInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 1;
                return this;
            }

            public Builder mergeAddrInfo(AddrInfo addrInfo) {
                AddrInfo addrInfo2;
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 1) == 1 && (addrInfo2 = this.addrInfo_) != null && addrInfo2 != AddrInfo.getDefaultInstance()) {
                        this.addrInfo_ = AddrInfo.newBuilder(this.addrInfo_).mergeFrom(addrInfo).buildPartial();
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

            public Builder clearAddrInfo() {
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.addrInfo_ = null;
                    onChanged();
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -2;
                return this;
            }

            public AddrInfo.Builder getAddrInfoBuilder() {
                this.bitField0_ |= 1;
                onChanged();
                return (AddrInfo.Builder) getAddrInfoFieldBuilder().getBuilder();
            }

            @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
            public AddrInfoOrBuilder getAddrInfoOrBuilder() {
                SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> singleFieldBuilderV3 = this.addrInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (AddrInfoOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                AddrInfo addrInfo = this.addrInfo_;
                return addrInfo == null ? AddrInfo.getDefaultInstance() : addrInfo;
            }

            private SingleFieldBuilderV3<AddrInfo, AddrInfo.Builder, AddrInfoOrBuilder> getAddrInfoFieldBuilder() {
                if (this.addrInfoBuilder_ == null) {
                    this.addrInfoBuilder_ = new SingleFieldBuilderV3<>(getAddrInfo(), getParentForChildren(), isClean());
                    this.addrInfo_ = null;
                }
                return this.addrInfoBuilder_;
            }

            @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
            public boolean hasGps() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
            public LocInfo getGps() {
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    LocInfo locInfo = this.gps_;
                    return locInfo == null ? LocInfo.getDefaultInstance() : locInfo;
                }
                return (LocInfo) singleFieldBuilderV3.getMessage();
            }

            public Builder setGps(LocInfo locInfo) {
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(locInfo);
                } else {
                    if (locInfo == null) {
                        throw new NullPointerException();
                    }
                    this.gps_ = locInfo;
                    onChanged();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setGps(LocInfo.Builder builder) {
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.gps_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder mergeGps(LocInfo locInfo) {
                LocInfo locInfo2;
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 2) == 2 && (locInfo2 = this.gps_) != null && locInfo2 != LocInfo.getDefaultInstance()) {
                        this.gps_ = LocInfo.newBuilder(this.gps_).mergeFrom(locInfo).buildPartial();
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

            public Builder clearGps() {
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.gps_ = null;
                    onChanged();
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -3;
                return this;
            }

            public LocInfo.Builder getGpsBuilder() {
                this.bitField0_ |= 2;
                onChanged();
                return (LocInfo.Builder) getGpsFieldBuilder().getBuilder();
            }

            @Override // com.oplus.camera.statistics.Position.UserInfoOrBuilder
            public LocInfoOrBuilder getGpsOrBuilder() {
                SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> singleFieldBuilderV3 = this.gpsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (LocInfoOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                LocInfo locInfo = this.gps_;
                return locInfo == null ? LocInfo.getDefaultInstance() : locInfo;
            }

            private SingleFieldBuilderV3<LocInfo, LocInfo.Builder, LocInfoOrBuilder> getGpsFieldBuilder() {
                if (this.gpsBuilder_ == null) {
                    this.gpsBuilder_ = new SingleFieldBuilderV3<>(getGps(), getParentForChildren(), isClean());
                    this.gps_ = null;
                }
                return this.gpsBuilder_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static UserInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UserInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UserInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UserInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\OplusGLSurfaceView_11\u000ePosition.proto\u0012\u001acom.oplus.camera.statistics\"Y\OplusGLSurfaceView_11\bAddrInfo\u0012\u000e\OplusGLSurfaceView_11\u0006street\u0018\u0001 \u0002(\t\u0012\COUIBaseListPopupWindow_12\OplusGLSurfaceView_11\u0004area\u0018\u0002 \u0002(\t\u0012\COUIBaseListPopupWindow_12\OplusGLSurfaceView_11\u0004city\u0018\u0003 \u0002(\t\u0012\u0010\OplusGLSurfaceView_11\bprovince\u0018\u0004 \u0002(\t\u0012\u000f\OplusGLSurfaceView_11\u0007country\u0018\u0005 \u0002(\t\"¸\u0001\OplusGLSurfaceView_11\u0007LocInfo\u0012\u000b\OplusGLSurfaceView_11\u0003mcc\u0018\u0001 \u0002(\t\u0012\u000b\OplusGLSurfaceView_11\u0003mnc\u0018\u0002 \u0002(\t\u0012\u000b\OplusGLSurfaceView_11\u0003lac\u0018\u0003 \u0002(\t\u0012\u000b\OplusGLSurfaceView_11\u0003cid\u0018\u0004 \u0002(\t\u0012\COUIBaseListPopupWindow_12\OplusGLSurfaceView_11\u0004\u0018\u0005 \u0002(\t\u0012\u000b\OplusGLSurfaceView_11\u0003lat\u0018\u0006 \u0002(\u0002\u0012\COUIBaseListPopupWindow_12\OplusGLSurfaceView_11\u0004long\u0018\u0007 \u0002(\u0002\u0012\COUIBaseListPopupWindow_12\OplusGLSurfaceView_11\u0004pcba\u0018\IntrinsicsJvm.kt_4 \u0001(\t\u0012\COUIBaseListPopupWindow_12\OplusGLSurfaceView_11\u0004ssid\u0018\t \u0001(\t\u0012\r\OplusGLSurfaceView_11\u0005bssid\u0018\OplusGLSurfaceView_11 \u0001(\t\u0012\u000b\OplusGLSurfaceView_11\u0003sid\u0018\u000b \u0001(\t\u0012\u000b\OplusGLSurfaceView_11\u0003nid\u0018\COUIBaseListPopupWindow_12 \u0001(\t\u0012\u000b\OplusGLSurfaceView_11\u0003bid\u0018\r \u0001(\t\"t\OplusGLSurfaceView_11\bUserInfo\u00126\OplusGLSurfaceView_11\baddrInfo\u0018\u0001 \u0002(\u000b2$.com.oplus.camera.statistics.AddrInfo\u00120\OplusGLSurfaceView_11\u0003gps\u0018\u0002 ", "\u0002(\u000b2#.com.oplus.camera.statistics.LocInfoB\nB\bPosition"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: com.oplus.camera.statistics.Position.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = Position.descriptor = fileDescriptor;
                return null;
            }
        });
        f16164x8552eb8a = getDescriptor().getMessageTypes().get(0);
        f16165xf58ae808 = new GeneratedMessageV3.FieldAccessorTable(f16164x8552eb8a, new String[]{"Street", "Area", "City", "Province", "Country"});
        f16166xcc19c4c5 = getDescriptor().getMessageTypes().get(1);
        f16167x442e5643 = new GeneratedMessageV3.FieldAccessorTable(f16166xcc19c4c5, new String[]{"Mcc", "Mnc", "Lac", "Cid", "Lat", "Long", "Pcba", "Ssid", "Bssid", "Sid", "Nid", "Bid"});
        f16168x6bd8ac70 = getDescriptor().getMessageTypes().get(2);
        f16169xfcc62ee = new GeneratedMessageV3.FieldAccessorTable(f16168x6bd8ac70, new String[]{"AddrInfo", "Gps"});
    }
}
