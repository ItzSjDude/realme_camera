package com.google.android.apps.lens.library.base.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldType;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtoField;
import com.google.protobuf.ProtoMessage;
import com.google.protobuf.ProtoPresenceBits;
import com.google.protobuf.ProtoPresenceCheckedField;
import com.google.protobuf.ProtoSyntax;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class LensSdkParamsProto {

    public interface LensSdkParamsOrBuilder extends MessageLiteOrBuilder {
        String getAgsaVersionName();

        ByteString getAgsaVersionNameBytes();

        LensSdkParams.LensAvailabilityStatus getArStickersAvailabilityStatus();

        LensSdkParams.LensAvailabilityStatus getLensAvailabilityStatus();

        String getLensSdkVersion();

        ByteString getLensSdkVersionBytes();

        boolean hasAgsaVersionName();

        boolean hasArStickersAvailabilityStatus();

        boolean hasLensAvailabilityStatus();

        boolean hasLensSdkVersion();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private LensSdkParamsProto() {
    }

    @ProtoMessage(checkInitialized = {}, messageSetWireFormat = false, protoSyntax = ProtoSyntax.PROTO2)
    public static final class LensSdkParams extends GeneratedMessageLite<LensSdkParams, Builder> implements LensSdkParamsOrBuilder {
        public static final int AGSA_VERSION_NAME_FIELD_NUMBER = 2;
        public static final int AR_STICKERS_AVAILABILITY_STATUS_FIELD_NUMBER = 4;
        private static final LensSdkParams DEFAULT_INSTANCE = new LensSdkParams();
        public static final int LENS_AVAILABILITY_STATUS_FIELD_NUMBER = 3;
        public static final int LENS_SDK_VERSION_FIELD_NUMBER = 1;
        private static volatile Parser<LensSdkParams> PARSER;

        @ProtoPresenceBits(id_renamed = 0)
        private int bitField0_;

        @ProtoField(fieldNumber = 1, isEnforceUtf8 = false, isRequired = false, type = FieldType.STRING)
        @ProtoPresenceCheckedField(mask = 1, presenceBitsId = 0)
        private String lensSdkVersion_ = "";

        @ProtoField(fieldNumber = 2, isEnforceUtf8 = false, isRequired = false, type = FieldType.STRING)
        @ProtoPresenceCheckedField(mask = 2, presenceBitsId = 0)
        private String agsaVersionName_ = "";

        @ProtoField(fieldNumber = 3, isRequired = false, type = FieldType.ENUM)
        @ProtoPresenceCheckedField(mask = 4, presenceBitsId = 0)
        private int lensAvailabilityStatus_ = -1;

        @ProtoField(fieldNumber = 4, isRequired = false, type = FieldType.ENUM)
        @ProtoPresenceCheckedField(mask = 8, presenceBitsId = 0)
        private int arStickersAvailabilityStatus_ = -1;

        private LensSdkParams() {
        }

        public enum LensAvailabilityStatus implements Internal.EnumLite {
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
            private static final Internal.EnumLiteMap<LensAvailabilityStatus> internalValueMap = new Internal.EnumLiteMap<LensAvailabilityStatus>() { // from class: com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParams.LensAvailabilityStatus.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public LensAvailabilityStatus findValueByNumber(int OplusGLSurfaceView_13) {
                    return LensAvailabilityStatus.forNumber(OplusGLSurfaceView_13);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static LensAvailabilityStatus forNumber(int OplusGLSurfaceView_13) {
                switch (OplusGLSurfaceView_13) {
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

            public static Internal.EnumLiteMap<LensAvailabilityStatus> internalGetValueMap() {
                return internalValueMap;
            }

            LensAvailabilityStatus(int OplusGLSurfaceView_13) {
                this.value = OplusGLSurfaceView_13;
            }
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public boolean hasLensSdkVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public String getLensSdkVersion() {
            return this.lensSdkVersion_;
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public ByteString getLensSdkVersionBytes() {
            return ByteString.copyFromUtf8(this.lensSdkVersion_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLensSdkVersion(String str) {
            if (str == null) {
                throw new NullPointerException();
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
        public void setLensSdkVersionBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.lensSdkVersion_ = byteString.toStringUtf8();
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public boolean hasAgsaVersionName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public String getAgsaVersionName() {
            return this.agsaVersionName_;
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public ByteString getAgsaVersionNameBytes() {
            return ByteString.copyFromUtf8(this.agsaVersionName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAgsaVersionName(String str) {
            if (str == null) {
                throw new NullPointerException();
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
        public void setAgsaVersionNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.agsaVersionName_ = byteString.toStringUtf8();
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public boolean hasLensAvailabilityStatus() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
        public LensAvailabilityStatus getLensAvailabilityStatus() {
            LensAvailabilityStatus lensAvailabilityStatusForNumber = LensAvailabilityStatus.forNumber(this.lensAvailabilityStatus_);
            return lensAvailabilityStatusForNumber == null ? LensAvailabilityStatus.LENS_AVAILABILITY_UNKNOWN : lensAvailabilityStatusForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLensAvailabilityStatus(LensAvailabilityStatus lensAvailabilityStatus) {
            if (lensAvailabilityStatus == null) {
                throw new NullPointerException();
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
        public LensAvailabilityStatus getArStickersAvailabilityStatus() {
            LensAvailabilityStatus lensAvailabilityStatusForNumber = LensAvailabilityStatus.forNumber(this.arStickersAvailabilityStatus_);
            return lensAvailabilityStatusForNumber == null ? LensAvailabilityStatus.LENS_AVAILABILITY_UNKNOWN : lensAvailabilityStatusForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setArStickersAvailabilityStatus(LensAvailabilityStatus lensAvailabilityStatus) {
            if (lensAvailabilityStatus == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.arStickersAvailabilityStatus_ = lensAvailabilityStatus.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearArStickersAvailabilityStatus() {
            this.bitField0_ &= -9;
            this.arStickersAvailabilityStatus_ = -1;
        }

        public static LensSdkParams parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static LensSdkParams parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static LensSdkParams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static LensSdkParams parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LensSdkParams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static LensSdkParams parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LensSdkParams parseFrom(InputStream inputStream) throws IOException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LensSdkParams parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LensSdkParams parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LensSdkParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LensSdkParams parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LensSdkParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LensSdkParams parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LensSdkParams parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LensSdkParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(LensSdkParams lensSdkParams) {
            return DEFAULT_INSTANCE.createBuilder(lensSdkParams);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<LensSdkParams, Builder> implements LensSdkParamsOrBuilder {
            private Builder() {
                super(LensSdkParams.DEFAULT_INSTANCE);
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public boolean hasLensSdkVersion() {
                return ((LensSdkParams) this.instance).hasLensSdkVersion();
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public String getLensSdkVersion() {
                return ((LensSdkParams) this.instance).getLensSdkVersion();
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public ByteString getLensSdkVersionBytes() {
                return ((LensSdkParams) this.instance).getLensSdkVersionBytes();
            }

            public Builder setLensSdkVersion(String str) {
                copyOnWrite();
                ((LensSdkParams) this.instance).setLensSdkVersion(str);
                return this;
            }

            public Builder clearLensSdkVersion() {
                copyOnWrite();
                ((LensSdkParams) this.instance).clearLensSdkVersion();
                return this;
            }

            public Builder setLensSdkVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((LensSdkParams) this.instance).setLensSdkVersionBytes(byteString);
                return this;
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public boolean hasAgsaVersionName() {
                return ((LensSdkParams) this.instance).hasAgsaVersionName();
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public String getAgsaVersionName() {
                return ((LensSdkParams) this.instance).getAgsaVersionName();
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public ByteString getAgsaVersionNameBytes() {
                return ((LensSdkParams) this.instance).getAgsaVersionNameBytes();
            }

            public Builder setAgsaVersionName(String str) {
                copyOnWrite();
                ((LensSdkParams) this.instance).setAgsaVersionName(str);
                return this;
            }

            public Builder clearAgsaVersionName() {
                copyOnWrite();
                ((LensSdkParams) this.instance).clearAgsaVersionName();
                return this;
            }

            public Builder setAgsaVersionNameBytes(ByteString byteString) {
                copyOnWrite();
                ((LensSdkParams) this.instance).setAgsaVersionNameBytes(byteString);
                return this;
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public boolean hasLensAvailabilityStatus() {
                return ((LensSdkParams) this.instance).hasLensAvailabilityStatus();
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public LensAvailabilityStatus getLensAvailabilityStatus() {
                return ((LensSdkParams) this.instance).getLensAvailabilityStatus();
            }

            public Builder setLensAvailabilityStatus(LensAvailabilityStatus lensAvailabilityStatus) {
                copyOnWrite();
                ((LensSdkParams) this.instance).setLensAvailabilityStatus(lensAvailabilityStatus);
                return this;
            }

            public Builder clearLensAvailabilityStatus() {
                copyOnWrite();
                ((LensSdkParams) this.instance).clearLensAvailabilityStatus();
                return this;
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public boolean hasArStickersAvailabilityStatus() {
                return ((LensSdkParams) this.instance).hasArStickersAvailabilityStatus();
            }

            @Override // com.google.android.apps.lens.library.base.proto.LensSdkParamsProto.LensSdkParamsOrBuilder
            public LensAvailabilityStatus getArStickersAvailabilityStatus() {
                return ((LensSdkParams) this.instance).getArStickersAvailabilityStatus();
            }

            public Builder setArStickersAvailabilityStatus(LensAvailabilityStatus lensAvailabilityStatus) {
                copyOnWrite();
                ((LensSdkParams) this.instance).setArStickersAvailabilityStatus(lensAvailabilityStatus);
                return this;
            }

            public Builder clearArStickersAvailabilityStatus() {
                copyOnWrite();
                ((LensSdkParams) this.instance).clearArStickersAvailabilityStatus();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new LensSdkParams();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\IntrinsicsJvm.kt_4\u0000\u0002\IntrinsicsJvm.kt_4\u0001\u0003\COUIBaseListPopupWindow_12\u0002\u0004\COUIBaseListPopupWindow_12\u0003", new Object[]{"bitField0_", "lensSdkVersion_", "agsaVersionName_", "lensAvailabilityStatus_", LensAvailabilityStatus.internalGetValueMap(), "arStickersAvailabilityStatus_", LensAvailabilityStatus.internalGetValueMap()});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<LensSdkParams> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (LensSdkParams.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
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
                    throw new UnsupportedOperationException();
            }
        }

        static {
            GeneratedMessageLite.registerDefaultInstance(LensSdkParams.class, DEFAULT_INSTANCE);
        }

        public static LensSdkParams getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LensSdkParams> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
