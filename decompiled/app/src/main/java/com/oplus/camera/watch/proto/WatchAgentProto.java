package com.oplus.camera.watch.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public final class WatchAgentProto {

    /* renamed from: q */
    private static Descriptors.FileDescriptor f23233q = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\OplusGLSurfaceView_11\u0015WatchAgentProto.proto\u0012\u001ccom.oplus.camera.watch.proto\"ñ\u0001\OplusGLSurfaceView_11\u001aWatchConnectPreviewMessage\u0012\u0014\OplusGLSurfaceView_11\fpreviewWidth\u0018\u0001 \u0001(\u0005\u0012\u0015\OplusGLSurfaceView_11\rpreviewHeight\u0018\u0002 \u0001(\u0005\u0012\u000f\OplusGLSurfaceView_11\u0007bitRate\u0018\u0003 \u0001(\u0005\u0012\u0015\OplusGLSurfaceView_11\rframeInterval\u0018\u0004 \u0001(\u0005\u0012\u0011\OplusGLSurfaceView_11\tframeRate\u0018\u0005 \u0001(\u0005\u0012\u001c\OplusGLSurfaceView_11\u0014isNeedLauncherCamera\u0018\u0006 \u0001(\IntrinsicsJvm.kt_4\u0012\u0016\OplusGLSurfaceView_11\u000ecaptureQuality\u0018\u0007 \u0001(\u0005\u0012\u0019\OplusGLSurfaceView_11\u0011singlePackageSize\u0018\IntrinsicsJvm.kt_4 \u0001(\u0005\u0012\u001a\OplusGLSurfaceView_11\u0012singlePackageDelay\u0018\t \u0001(\u0005\" \u0001\OplusGLSurfaceView_11\u001bCameraConnectPreviewMessage\u0012\u0013\OplusGLSurfaceView_11\u000bcurrentMode\u0018\u0001 \u0001(\t\u0012\u0017\OplusGLSurfaceView_11\u000fcurrentModeName\u0018\u0002 \u0001(\t\u0012\u0015\OplusGLSurfaceView_11\rphotoModeList\u0018\u0003 \u0003(\t\u0012\u0012\OplusGLSurfaceView_11\ncodecWidth\u0018\u0004 \u0001(\u0005\u0012\u0013\OplusGLSurfaceView_11\u000bcodecHeight\u0018\u0005 \u0001(\u0005\u0012\u0013\OplusGLSurfaceView_11\u000borientation\u0018\u0006 \u0001(\u0005\"(\OplusGLSurfaceView_11\u0013WatchCaptureMessage\u0012\u0011\OplusGLSurfaceView_11\tcountDown\u0018\u0001 \u0001(\u0005\"'\OplusGLSurfaceView_11\u0014CameraCaptureMessage\u0012\u000f\OplusGLSurfaceView_11\u0007isReady\u0018\u0001 \u0001(\IntrinsicsJvm.kt_4\"\u0094\u0001\OplusGLSurfaceView_11\u0018CameraCaptureDataMessage\u0012\u001a\OplusGLSurfaceView_11\u0012subPackageIdentify\u0018\u0001 \u0001(\u0003\u0012\u0017\OplusGLSurfaceView_11\u000fsubPackageTotal\u0018\u0002 \u0001(\u0005\u0012\u0017\OplusGLSurfaceView_11\u000fsubPackageIndex\u0018\u0003 \u0001(\u0005\u0012\u0013\OplusGLSurfaceView_11\u000bpictureData\u0018\u0004 \u0001(\COUIBaseListPopupWindow_12\u0012\u0015\OplusGLSurfaceView_11\rpackageLength\u0018\u0005 \u0001(\u0005\"=\OplusGLSurfaceView_11\u0013CameraRecordMessage\u0012\u0012\OplusGLSurfaceView_11\nvideoState\u0018\u0001 \u0001(\u0005\u0012\u0012\OplusGLSurfaceView_11\nrecordTime\u0018\u0002 \u0001(\u0003\"*\OplusGLSurfaceView_11\u0015CameraOAFStateMessage\u0012\u0011\OplusGLSurfaceView_11\treconnect\u0018\u0001 \u0001(\IntrinsicsJvm.kt_4\"Z\OplusGLSurfaceView_11\u001aCameraConfigurationMessage\u0012\u0013\OplusGLSurfaceView_11\u000borientation\u0018\u0001 \u0001(\u0005\u0012\u0012\OplusGLSurfaceView_11\ncodecWidth\u0018\u0002 \u0001(\u0005\u0012\u0013\OplusGLSurfaceView_11\u000bcodecHeight\u0018\u0003 \u0001(\u0005b\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Descriptors.Descriptor f23217a = m24799a().getMessageTypes().get(0);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final GeneratedMessageV3.FieldAccessorTable f23218b = new GeneratedMessageV3.FieldAccessorTable(f23217a, new String[]{"PreviewWidth", "PreviewHeight", "BitRate", "FrameInterval", "FrameRate", "IsNeedLauncherCamera", "CaptureQuality", "SinglePackageSize", "SinglePackageDelay"});

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final Descriptors.Descriptor f23219c = m24799a().getMessageTypes().get(1);

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final GeneratedMessageV3.FieldAccessorTable f23220d = new GeneratedMessageV3.FieldAccessorTable(f23219c, new String[]{"CurrentMode", "CurrentModeName", "PhotoModeList", "CodecWidth", "CodecHeight", "Orientation"});

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final Descriptors.Descriptor f23221e = m24799a().getMessageTypes().get(2);

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final GeneratedMessageV3.FieldAccessorTable f23222f = new GeneratedMessageV3.FieldAccessorTable(f23221e, new String[]{"CountDown"});

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final Descriptors.Descriptor f23223g = m24799a().getMessageTypes().get(3);

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static final GeneratedMessageV3.FieldAccessorTable f23224h = new GeneratedMessageV3.FieldAccessorTable(f23223g, new String[]{"IsReady"});

    /* renamed from: OplusGLSurfaceView_13 */
    private static final Descriptors.Descriptor f23225i = m24799a().getMessageTypes().get(4);

    /* renamed from: OplusGLSurfaceView_15 */
    private static final GeneratedMessageV3.FieldAccessorTable f23226j = new GeneratedMessageV3.FieldAccessorTable(f23225i, new String[]{"SubPackageIdentify", "SubPackageTotal", "SubPackageIndex", "PictureData", "PackageLength"});

    /* renamed from: OplusGLSurfaceView_5 */
    private static final Descriptors.Descriptor f23227k = m24799a().getMessageTypes().get(5);

    /* renamed from: OplusGLSurfaceView_14 */
    private static final GeneratedMessageV3.FieldAccessorTable f23228l = new GeneratedMessageV3.FieldAccessorTable(f23227k, new String[]{"VideoState", "RecordTime"});

    /* renamed from: OplusGLSurfaceView_6 */
    private static final Descriptors.Descriptor f23229m = m24799a().getMessageTypes().get(6);

    /* renamed from: OplusGLSurfaceView_11 */
    private static final GeneratedMessageV3.FieldAccessorTable f23230n = new GeneratedMessageV3.FieldAccessorTable(f23229m, new String[]{"Reconnect"});

    /* renamed from: o */
    private static final Descriptors.Descriptor f23231o = m24799a().getMessageTypes().get(7);

    /* renamed from: p */
    private static final GeneratedMessageV3.FieldAccessorTable f23232p = new GeneratedMessageV3.FieldAccessorTable(f23231o, new String[]{"Orientation", "CodecWidth", "CodecHeight"});

    /* renamed from: com.oplus.camera.watch.proto.WatchAgentProto$PlatformImplementations.kt_3 */
    public interface InterfaceC3581a extends MessageOrBuilder {
    }

    /* renamed from: com.oplus.camera.watch.proto.WatchAgentProto$IntrinsicsJvm.kt_4 */
    public interface InterfaceC3582b extends MessageOrBuilder {
    }

    /* renamed from: com.oplus.camera.watch.proto.WatchAgentProto$IntrinsicsJvm.kt_3 */
    public interface InterfaceC3583c extends MessageOrBuilder {
    }

    /* renamed from: com.oplus.camera.watch.proto.WatchAgentProto$IntrinsicsJvm.kt_5 */
    public interface InterfaceC3584d extends MessageOrBuilder {
    }

    /* renamed from: com.oplus.camera.watch.proto.WatchAgentProto$COUIBaseListPopupWindow_8 */
    public interface InterfaceC3585e extends MessageOrBuilder {
    }

    /* renamed from: com.oplus.camera.watch.proto.WatchAgentProto$COUIBaseListPopupWindow_12 */
    public interface InterfaceC3586f extends MessageOrBuilder {
    }

    /* renamed from: com.oplus.camera.watch.proto.WatchAgentProto$COUIBaseListPopupWindow_11 */
    public interface InterfaceC3587g extends MessageOrBuilder {
    }

    /* renamed from: com.oplus.camera.watch.proto.WatchAgentProto$COUIBaseListPopupWindow_10 */
    public interface InterfaceC3588h extends MessageOrBuilder {
    }

    public static final class WatchConnectPreviewMessage extends GeneratedMessageV3 implements InterfaceC3588h {
        public static final int BITRATE_FIELD_NUMBER = 3;
        public static final int CAPTUREQUALITY_FIELD_NUMBER = 7;
        public static final int FRAMEINTERVAL_FIELD_NUMBER = 4;
        public static final int FRAMERATE_FIELD_NUMBER = 5;
        public static final int ISNEEDLAUNCHERCAMERA_FIELD_NUMBER = 6;
        public static final int PREVIEWHEIGHT_FIELD_NUMBER = 2;
        public static final int PREVIEWWIDTH_FIELD_NUMBER = 1;
        public static final int SINGLEPACKAGEDELAY_FIELD_NUMBER = 9;
        public static final int SINGLEPACKAGESIZE_FIELD_NUMBER = 8;
        private static final long serialVersionUID = 0;
        private int bitRate_;
        private int captureQuality_;
        private int frameInterval_;
        private int frameRate_;
        private boolean isNeedLauncherCamera_;
        private byte memoizedIsInitialized;
        private int previewHeight_;
        private int previewWidth_;
        private int singlePackageDelay_;
        private int singlePackageSize_;
        private static final WatchConnectPreviewMessage DEFAULT_INSTANCE = new WatchConnectPreviewMessage();
        private static final Parser<WatchConnectPreviewMessage> PARSER = new AbstractParser<WatchConnectPreviewMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public WatchConnectPreviewMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WatchConnectPreviewMessage(codedInputStream, extensionRegistryLite);
            }
        };

        private WatchConnectPreviewMessage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private WatchConnectPreviewMessage() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new WatchConnectPreviewMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WatchConnectPreviewMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.previewWidth_ = codedInputStream.readInt32();
                            } else if (tag == 16) {
                                this.previewHeight_ = codedInputStream.readInt32();
                            } else if (tag == 24) {
                                this.bitRate_ = codedInputStream.readInt32();
                            } else if (tag == 32) {
                                this.frameInterval_ = codedInputStream.readInt32();
                            } else if (tag == 40) {
                                this.frameRate_ = codedInputStream.readInt32();
                            } else if (tag == 48) {
                                this.isNeedLauncherCamera_ = codedInputStream.readBool();
                            } else if (tag == 56) {
                                this.captureQuality_ = codedInputStream.readInt32();
                            } else if (tag == 64) {
                                this.singlePackageSize_ = codedInputStream.readInt32();
                            } else if (tag == 72) {
                                this.singlePackageDelay_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
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
            return WatchAgentProto.f23217a;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WatchAgentProto.f23218b.ensureFieldAccessorsInitialized(WatchConnectPreviewMessage.class, Builder.class);
        }

        public int getPreviewWidth() {
            return this.previewWidth_;
        }

        public int getPreviewHeight() {
            return this.previewHeight_;
        }

        public int getBitRate() {
            return this.bitRate_;
        }

        public int getFrameInterval() {
            return this.frameInterval_;
        }

        public int getFrameRate() {
            return this.frameRate_;
        }

        public boolean getIsNeedLauncherCamera() {
            return this.isNeedLauncherCamera_;
        }

        public int getCaptureQuality() {
            return this.captureQuality_;
        }

        public int getSinglePackageSize() {
            return this.singlePackageSize_;
        }

        public int getSinglePackageDelay() {
            return this.singlePackageDelay_;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int OplusGLSurfaceView_13 = this.previewWidth_;
            if (OplusGLSurfaceView_13 != 0) {
                codedOutputStream.writeInt32(1, OplusGLSurfaceView_13);
            }
            int i2 = this.previewHeight_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(2, i2);
            }
            int i3 = this.bitRate_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(3, i3);
            }
            int i4 = this.frameInterval_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(4, i4);
            }
            int i5 = this.frameRate_;
            if (i5 != 0) {
                codedOutputStream.writeInt32(5, i5);
            }
            boolean z = this.isNeedLauncherCamera_;
            if (z) {
                codedOutputStream.writeBool(6, z);
            }
            int i6 = this.captureQuality_;
            if (i6 != 0) {
                codedOutputStream.writeInt32(7, i6);
            }
            int i7 = this.singlePackageSize_;
            if (i7 != 0) {
                codedOutputStream.writeInt32(8, i7);
            }
            int i8 = this.singlePackageDelay_;
            if (i8 != 0) {
                codedOutputStream.writeInt32(9, i8);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int OplusGLSurfaceView_13 = this.memoizedSize;
            if (OplusGLSurfaceView_13 != -1) {
                return OplusGLSurfaceView_13;
            }
            int i2 = this.previewWidth_;
            int iComputeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
            int i3 = this.previewHeight_;
            if (i3 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
            }
            int i4 = this.bitRate_;
            if (i4 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, i4);
            }
            int i5 = this.frameInterval_;
            if (i5 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(4, i5);
            }
            int i6 = this.frameRate_;
            if (i6 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(5, i6);
            }
            boolean z = this.isNeedLauncherCamera_;
            if (z) {
                iComputeInt32Size += CodedOutputStream.computeBoolSize(6, z);
            }
            int i7 = this.captureQuality_;
            if (i7 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(7, i7);
            }
            int i8 = this.singlePackageSize_;
            if (i8 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(8, i8);
            }
            int i9 = this.singlePackageDelay_;
            if (i9 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(9, i9);
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WatchConnectPreviewMessage)) {
                return super.equals(obj);
            }
            WatchConnectPreviewMessage watchConnectPreviewMessage = (WatchConnectPreviewMessage) obj;
            return getPreviewWidth() == watchConnectPreviewMessage.getPreviewWidth() && getPreviewHeight() == watchConnectPreviewMessage.getPreviewHeight() && getBitRate() == watchConnectPreviewMessage.getBitRate() && getFrameInterval() == watchConnectPreviewMessage.getFrameInterval() && getFrameRate() == watchConnectPreviewMessage.getFrameRate() && getIsNeedLauncherCamera() == watchConnectPreviewMessage.getIsNeedLauncherCamera() && getCaptureQuality() == watchConnectPreviewMessage.getCaptureQuality() && getSinglePackageSize() == watchConnectPreviewMessage.getSinglePackageSize() && getSinglePackageDelay() == watchConnectPreviewMessage.getSinglePackageDelay() && this.unknownFields.equals(watchConnectPreviewMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getPreviewWidth()) * 37) + 2) * 53) + getPreviewHeight()) * 37) + 3) * 53) + getBitRate()) * 37) + 4) * 53) + getFrameInterval()) * 37) + 5) * 53) + getFrameRate()) * 37) + 6) * 53) + Internal.hashBoolean(getIsNeedLauncherCamera())) * 37) + 7) * 53) + getCaptureQuality()) * 37) + 8) * 53) + getSinglePackageSize()) * 37) + 9) * 53) + getSinglePackageDelay()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static WatchConnectPreviewMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static WatchConnectPreviewMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static WatchConnectPreviewMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static WatchConnectPreviewMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static WatchConnectPreviewMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static WatchConnectPreviewMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static WatchConnectPreviewMessage parseFrom(InputStream inputStream) throws IOException {
            return (WatchConnectPreviewMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static WatchConnectPreviewMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WatchConnectPreviewMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WatchConnectPreviewMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WatchConnectPreviewMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WatchConnectPreviewMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WatchConnectPreviewMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WatchConnectPreviewMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WatchConnectPreviewMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WatchConnectPreviewMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WatchConnectPreviewMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WatchConnectPreviewMessage watchConnectPreviewMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(watchConnectPreviewMessage);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InterfaceC3588h {
            private int bitRate_;
            private int captureQuality_;
            private int frameInterval_;
            private int frameRate_;
            private boolean isNeedLauncherCamera_;
            private int previewHeight_;
            private int previewWidth_;
            private int singlePackageDelay_;
            private int singlePackageSize_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return WatchAgentProto.f23217a;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WatchAgentProto.f23218b.ensureFieldAccessorsInitialized(WatchConnectPreviewMessage.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = WatchConnectPreviewMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.previewWidth_ = 0;
                this.previewHeight_ = 0;
                this.bitRate_ = 0;
                this.frameInterval_ = 0;
                this.frameRate_ = 0;
                this.isNeedLauncherCamera_ = false;
                this.captureQuality_ = 0;
                this.singlePackageSize_ = 0;
                this.singlePackageDelay_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WatchAgentProto.f23217a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WatchConnectPreviewMessage getDefaultInstanceForType() {
                return WatchConnectPreviewMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WatchConnectPreviewMessage build() {
                WatchConnectPreviewMessage watchConnectPreviewMessageBuildPartial = buildPartial();
                if (watchConnectPreviewMessageBuildPartial.isInitialized()) {
                    return watchConnectPreviewMessageBuildPartial;
                }
                throw newUninitializedMessageException((Message) watchConnectPreviewMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WatchConnectPreviewMessage buildPartial() {
                WatchConnectPreviewMessage watchConnectPreviewMessage = new WatchConnectPreviewMessage(this);
                watchConnectPreviewMessage.previewWidth_ = this.previewWidth_;
                watchConnectPreviewMessage.previewHeight_ = this.previewHeight_;
                watchConnectPreviewMessage.bitRate_ = this.bitRate_;
                watchConnectPreviewMessage.frameInterval_ = this.frameInterval_;
                watchConnectPreviewMessage.frameRate_ = this.frameRate_;
                watchConnectPreviewMessage.isNeedLauncherCamera_ = this.isNeedLauncherCamera_;
                watchConnectPreviewMessage.captureQuality_ = this.captureQuality_;
                watchConnectPreviewMessage.singlePackageSize_ = this.singlePackageSize_;
                watchConnectPreviewMessage.singlePackageDelay_ = this.singlePackageDelay_;
                onBuilt();
                return watchConnectPreviewMessage;
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
                if (message instanceof WatchConnectPreviewMessage) {
                    return mergeFrom((WatchConnectPreviewMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(WatchConnectPreviewMessage watchConnectPreviewMessage) {
                if (watchConnectPreviewMessage == WatchConnectPreviewMessage.getDefaultInstance()) {
                    return this;
                }
                if (watchConnectPreviewMessage.getPreviewWidth() != 0) {
                    setPreviewWidth(watchConnectPreviewMessage.getPreviewWidth());
                }
                if (watchConnectPreviewMessage.getPreviewHeight() != 0) {
                    setPreviewHeight(watchConnectPreviewMessage.getPreviewHeight());
                }
                if (watchConnectPreviewMessage.getBitRate() != 0) {
                    setBitRate(watchConnectPreviewMessage.getBitRate());
                }
                if (watchConnectPreviewMessage.getFrameInterval() != 0) {
                    setFrameInterval(watchConnectPreviewMessage.getFrameInterval());
                }
                if (watchConnectPreviewMessage.getFrameRate() != 0) {
                    setFrameRate(watchConnectPreviewMessage.getFrameRate());
                }
                if (watchConnectPreviewMessage.getIsNeedLauncherCamera()) {
                    setIsNeedLauncherCamera(watchConnectPreviewMessage.getIsNeedLauncherCamera());
                }
                if (watchConnectPreviewMessage.getCaptureQuality() != 0) {
                    setCaptureQuality(watchConnectPreviewMessage.getCaptureQuality());
                }
                if (watchConnectPreviewMessage.getSinglePackageSize() != 0) {
                    setSinglePackageSize(watchConnectPreviewMessage.getSinglePackageSize());
                }
                if (watchConnectPreviewMessage.getSinglePackageDelay() != 0) {
                    setSinglePackageDelay(watchConnectPreviewMessage.getSinglePackageDelay());
                }
                mergeUnknownFields(watchConnectPreviewMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.access$1600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.oplus.camera.watch.proto.WatchAgentProto$WatchConnectPreviewMessage r3 = (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.oplus.camera.watch.proto.WatchAgentProto$WatchConnectPreviewMessage r4 = (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oplus.camera.watch.proto.WatchAgentProto$WatchConnectPreviewMessage$Builder");
            }

            public int getPreviewWidth() {
                return this.previewWidth_;
            }

            public Builder setPreviewWidth(int OplusGLSurfaceView_13) {
                this.previewWidth_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearPreviewWidth() {
                this.previewWidth_ = 0;
                onChanged();
                return this;
            }

            public int getPreviewHeight() {
                return this.previewHeight_;
            }

            public Builder setPreviewHeight(int OplusGLSurfaceView_13) {
                this.previewHeight_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearPreviewHeight() {
                this.previewHeight_ = 0;
                onChanged();
                return this;
            }

            public int getBitRate() {
                return this.bitRate_;
            }

            public Builder setBitRate(int OplusGLSurfaceView_13) {
                this.bitRate_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearBitRate() {
                this.bitRate_ = 0;
                onChanged();
                return this;
            }

            public int getFrameInterval() {
                return this.frameInterval_;
            }

            public Builder setFrameInterval(int OplusGLSurfaceView_13) {
                this.frameInterval_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearFrameInterval() {
                this.frameInterval_ = 0;
                onChanged();
                return this;
            }

            public int getFrameRate() {
                return this.frameRate_;
            }

            public Builder setFrameRate(int OplusGLSurfaceView_13) {
                this.frameRate_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearFrameRate() {
                this.frameRate_ = 0;
                onChanged();
                return this;
            }

            public boolean getIsNeedLauncherCamera() {
                return this.isNeedLauncherCamera_;
            }

            public Builder setIsNeedLauncherCamera(boolean z) {
                this.isNeedLauncherCamera_ = z;
                onChanged();
                return this;
            }

            public Builder clearIsNeedLauncherCamera() {
                this.isNeedLauncherCamera_ = false;
                onChanged();
                return this;
            }

            public int getCaptureQuality() {
                return this.captureQuality_;
            }

            public Builder setCaptureQuality(int OplusGLSurfaceView_13) {
                this.captureQuality_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearCaptureQuality() {
                this.captureQuality_ = 0;
                onChanged();
                return this;
            }

            public int getSinglePackageSize() {
                return this.singlePackageSize_;
            }

            public Builder setSinglePackageSize(int OplusGLSurfaceView_13) {
                this.singlePackageSize_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearSinglePackageSize() {
                this.singlePackageSize_ = 0;
                onChanged();
                return this;
            }

            public int getSinglePackageDelay() {
                return this.singlePackageDelay_;
            }

            public Builder setSinglePackageDelay(int OplusGLSurfaceView_13) {
                this.singlePackageDelay_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearSinglePackageDelay() {
                this.singlePackageDelay_ = 0;
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

        public static WatchConnectPreviewMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WatchConnectPreviewMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WatchConnectPreviewMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WatchConnectPreviewMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CameraConnectPreviewMessage extends GeneratedMessageV3 implements InterfaceC3584d {
        public static final int CODECHEIGHT_FIELD_NUMBER = 5;
        public static final int CODECWIDTH_FIELD_NUMBER = 4;
        public static final int CURRENTMODENAME_FIELD_NUMBER = 2;
        public static final int CURRENTMODE_FIELD_NUMBER = 1;
        public static final int ORIENTATION_FIELD_NUMBER = 6;
        public static final int PHOTOMODELIST_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int codecHeight_;
        private int codecWidth_;
        private volatile Object currentModeName_;
        private volatile Object currentMode_;
        private byte memoizedIsInitialized;
        private int orientation_;
        private LazyStringList photoModeList_;
        private static final CameraConnectPreviewMessage DEFAULT_INSTANCE = new CameraConnectPreviewMessage();
        private static final Parser<CameraConnectPreviewMessage> PARSER = new AbstractParser<CameraConnectPreviewMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public CameraConnectPreviewMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CameraConnectPreviewMessage(codedInputStream, extensionRegistryLite);
            }
        };

        private CameraConnectPreviewMessage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CameraConnectPreviewMessage() {
            this.memoizedIsInitialized = (byte) -1;
            this.currentMode_ = "";
            this.currentModeName_ = "";
            this.photoModeList_ = LazyStringArrayList.EMPTY;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new CameraConnectPreviewMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CameraConnectPreviewMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                this.currentMode_ = codedInputStream.readStringRequireUtf8();
                            } else if (tag == 18) {
                                this.currentModeName_ = codedInputStream.readStringRequireUtf8();
                            } else if (tag == 26) {
                                String stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                if (!(z2 & true)) {
                                    this.photoModeList_ = new LazyStringArrayList();
                                    z2 |= true;
                                }
                                this.photoModeList_.add(stringRequireUtf8);
                            } else if (tag == 32) {
                                this.codecWidth_ = codedInputStream.readInt32();
                            } else if (tag == 40) {
                                this.codecHeight_ = codedInputStream.readInt32();
                            } else if (tag == 48) {
                                this.orientation_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException COUIBaseListPopupWindow_8) {
                        throw COUIBaseListPopupWindow_8.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.photoModeList_ = this.photoModeList_.getUnmodifiableView();
                    }
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WatchAgentProto.f23219c;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WatchAgentProto.f23220d.ensureFieldAccessorsInitialized(CameraConnectPreviewMessage.class, Builder.class);
        }

        public String getCurrentMode() {
            Object obj = this.currentMode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.currentMode_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getCurrentModeBytes() {
            Object obj = this.currentMode_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.currentMode_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getCurrentModeName() {
            Object obj = this.currentModeName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.currentModeName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getCurrentModeNameBytes() {
            Object obj = this.currentModeName_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.currentModeName_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* renamed from: getPhotoModeListList, reason: merged with bridge method [inline-methods] */
        public ProtocolStringList m26408getPhotoModeListList() {
            return this.photoModeList_;
        }

        public int getPhotoModeListCount() {
            return this.photoModeList_.size();
        }

        public String getPhotoModeList(int OplusGLSurfaceView_13) {
            return (String) this.photoModeList_.get(OplusGLSurfaceView_13);
        }

        public ByteString getPhotoModeListBytes(int OplusGLSurfaceView_13) {
            return this.photoModeList_.getByteString(OplusGLSurfaceView_13);
        }

        public int getCodecWidth() {
            return this.codecWidth_;
        }

        public int getCodecHeight() {
            return this.codecHeight_;
        }

        public int getOrientation() {
            return this.orientation_;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getCurrentModeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.currentMode_);
            }
            if (!getCurrentModeNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.currentModeName_);
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.photoModeList_.size(); OplusGLSurfaceView_13++) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.photoModeList_.getRaw(OplusGLSurfaceView_13));
            }
            int i2 = this.codecWidth_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(4, i2);
            }
            int i3 = this.codecHeight_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(5, i3);
            }
            int i4 = this.orientation_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(6, i4);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int OplusGLSurfaceView_13 = this.memoizedSize;
            if (OplusGLSurfaceView_13 != -1) {
                return OplusGLSurfaceView_13;
            }
            int iComputeStringSize = !getCurrentModeBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.currentMode_) + 0 : 0;
            if (!getCurrentModeNameBytes().isEmpty()) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(2, this.currentModeName_);
            }
            int iComputeStringSizeNoTag = 0;
            for (int i2 = 0; i2 < this.photoModeList_.size(); i2++) {
                iComputeStringSizeNoTag += computeStringSizeNoTag(this.photoModeList_.getRaw(i2));
            }
            int size = iComputeStringSize + iComputeStringSizeNoTag + (m26408getPhotoModeListList().size() * 1);
            int i3 = this.codecWidth_;
            if (i3 != 0) {
                size += CodedOutputStream.computeInt32Size(4, i3);
            }
            int i4 = this.codecHeight_;
            if (i4 != 0) {
                size += CodedOutputStream.computeInt32Size(5, i4);
            }
            int i5 = this.orientation_;
            if (i5 != 0) {
                size += CodedOutputStream.computeInt32Size(6, i5);
            }
            int serializedSize = size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CameraConnectPreviewMessage)) {
                return super.equals(obj);
            }
            CameraConnectPreviewMessage cameraConnectPreviewMessage = (CameraConnectPreviewMessage) obj;
            return getCurrentMode().equals(cameraConnectPreviewMessage.getCurrentMode()) && getCurrentModeName().equals(cameraConnectPreviewMessage.getCurrentModeName()) && m26408getPhotoModeListList().equals(cameraConnectPreviewMessage.m26408getPhotoModeListList()) && getCodecWidth() == cameraConnectPreviewMessage.getCodecWidth() && getCodecHeight() == cameraConnectPreviewMessage.getCodecHeight() && getOrientation() == cameraConnectPreviewMessage.getOrientation() && this.unknownFields.equals(cameraConnectPreviewMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCurrentMode().hashCode()) * 37) + 2) * 53) + getCurrentModeName().hashCode();
            if (getPhotoModeListCount() > 0) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + m26408getPhotoModeListList().hashCode();
            }
            int codecWidth = (((((((((((((iHashCode * 37) + 4) * 53) + getCodecWidth()) * 37) + 5) * 53) + getCodecHeight()) * 37) + 6) * 53) + getOrientation()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = codecWidth;
            return codecWidth;
        }

        public static CameraConnectPreviewMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static CameraConnectPreviewMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static CameraConnectPreviewMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CameraConnectPreviewMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CameraConnectPreviewMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CameraConnectPreviewMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static CameraConnectPreviewMessage parseFrom(InputStream inputStream) throws IOException {
            return (CameraConnectPreviewMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CameraConnectPreviewMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraConnectPreviewMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CameraConnectPreviewMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CameraConnectPreviewMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CameraConnectPreviewMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraConnectPreviewMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CameraConnectPreviewMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CameraConnectPreviewMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static CameraConnectPreviewMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraConnectPreviewMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CameraConnectPreviewMessage cameraConnectPreviewMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cameraConnectPreviewMessage);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InterfaceC3584d {
            private int bitField0_;
            private int codecHeight_;
            private int codecWidth_;
            private Object currentModeName_;
            private Object currentMode_;
            private int orientation_;
            private LazyStringList photoModeList_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return WatchAgentProto.f23219c;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WatchAgentProto.f23220d.ensureFieldAccessorsInitialized(CameraConnectPreviewMessage.class, Builder.class);
            }

            private Builder() {
                this.currentMode_ = "";
                this.currentModeName_ = "";
                this.photoModeList_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.currentMode_ = "";
                this.currentModeName_ = "";
                this.photoModeList_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CameraConnectPreviewMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.currentMode_ = "";
                this.currentModeName_ = "";
                this.photoModeList_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                this.codecWidth_ = 0;
                this.codecHeight_ = 0;
                this.orientation_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WatchAgentProto.f23219c;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CameraConnectPreviewMessage getDefaultInstanceForType() {
                return CameraConnectPreviewMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CameraConnectPreviewMessage build() {
                CameraConnectPreviewMessage cameraConnectPreviewMessageBuildPartial = buildPartial();
                if (cameraConnectPreviewMessageBuildPartial.isInitialized()) {
                    return cameraConnectPreviewMessageBuildPartial;
                }
                throw newUninitializedMessageException((Message) cameraConnectPreviewMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CameraConnectPreviewMessage buildPartial() {
                CameraConnectPreviewMessage cameraConnectPreviewMessage = new CameraConnectPreviewMessage(this);
                int OplusGLSurfaceView_13 = this.bitField0_;
                cameraConnectPreviewMessage.currentMode_ = this.currentMode_;
                cameraConnectPreviewMessage.currentModeName_ = this.currentModeName_;
                if ((this.bitField0_ & 1) != 0) {
                    this.photoModeList_ = this.photoModeList_.getUnmodifiableView();
                    this.bitField0_ &= -2;
                }
                cameraConnectPreviewMessage.photoModeList_ = this.photoModeList_;
                cameraConnectPreviewMessage.codecWidth_ = this.codecWidth_;
                cameraConnectPreviewMessage.codecHeight_ = this.codecHeight_;
                cameraConnectPreviewMessage.orientation_ = this.orientation_;
                onBuilt();
                return cameraConnectPreviewMessage;
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
                if (message instanceof CameraConnectPreviewMessage) {
                    return mergeFrom((CameraConnectPreviewMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(CameraConnectPreviewMessage cameraConnectPreviewMessage) {
                if (cameraConnectPreviewMessage == CameraConnectPreviewMessage.getDefaultInstance()) {
                    return this;
                }
                if (!cameraConnectPreviewMessage.getCurrentMode().isEmpty()) {
                    this.currentMode_ = cameraConnectPreviewMessage.currentMode_;
                    onChanged();
                }
                if (!cameraConnectPreviewMessage.getCurrentModeName().isEmpty()) {
                    this.currentModeName_ = cameraConnectPreviewMessage.currentModeName_;
                    onChanged();
                }
                if (!cameraConnectPreviewMessage.photoModeList_.isEmpty()) {
                    if (this.photoModeList_.isEmpty()) {
                        this.photoModeList_ = cameraConnectPreviewMessage.photoModeList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensurePhotoModeListIsMutable();
                        this.photoModeList_.addAll(cameraConnectPreviewMessage.photoModeList_);
                    }
                    onChanged();
                }
                if (cameraConnectPreviewMessage.getCodecWidth() != 0) {
                    setCodecWidth(cameraConnectPreviewMessage.getCodecWidth());
                }
                if (cameraConnectPreviewMessage.getCodecHeight() != 0) {
                    setCodecHeight(cameraConnectPreviewMessage.getCodecHeight());
                }
                if (cameraConnectPreviewMessage.getOrientation() != 0) {
                    setOrientation(cameraConnectPreviewMessage.getOrientation());
                }
                mergeUnknownFields(cameraConnectPreviewMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.access$3100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.oplus.camera.watch.proto.WatchAgentProto$CameraConnectPreviewMessage r3 = (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.oplus.camera.watch.proto.WatchAgentProto$CameraConnectPreviewMessage r4 = (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oplus.camera.watch.proto.WatchAgentProto$CameraConnectPreviewMessage$Builder");
            }

            public String getCurrentMode() {
                Object obj = this.currentMode_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.currentMode_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            public ByteString getCurrentModeBytes() {
                Object obj = this.currentMode_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.currentMode_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setCurrentMode(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.currentMode_ = str;
                onChanged();
                return this;
            }

            public Builder clearCurrentMode() {
                this.currentMode_ = CameraConnectPreviewMessage.getDefaultInstance().getCurrentMode();
                onChanged();
                return this;
            }

            public Builder setCurrentModeBytes(ByteString byteString) {
                if (byteString != null) {
                    CameraConnectPreviewMessage.checkByteStringIsUtf8(byteString);
                    this.currentMode_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public String getCurrentModeName() {
                Object obj = this.currentModeName_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.currentModeName_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            public ByteString getCurrentModeNameBytes() {
                Object obj = this.currentModeName_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.currentModeName_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setCurrentModeName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.currentModeName_ = str;
                onChanged();
                return this;
            }

            public Builder clearCurrentModeName() {
                this.currentModeName_ = CameraConnectPreviewMessage.getDefaultInstance().getCurrentModeName();
                onChanged();
                return this;
            }

            public Builder setCurrentModeNameBytes(ByteString byteString) {
                if (byteString != null) {
                    CameraConnectPreviewMessage.checkByteStringIsUtf8(byteString);
                    this.currentModeName_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            private void ensurePhotoModeListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.photoModeList_ = new LazyStringArrayList(this.photoModeList_);
                    this.bitField0_ |= 1;
                }
            }

            /* renamed from: getPhotoModeListList, reason: merged with bridge method [inline-methods] */
            public ProtocolStringList m26409getPhotoModeListList() {
                return this.photoModeList_.getUnmodifiableView();
            }

            public int getPhotoModeListCount() {
                return this.photoModeList_.size();
            }

            public String getPhotoModeList(int OplusGLSurfaceView_13) {
                return (String) this.photoModeList_.get(OplusGLSurfaceView_13);
            }

            public ByteString getPhotoModeListBytes(int OplusGLSurfaceView_13) {
                return this.photoModeList_.getByteString(OplusGLSurfaceView_13);
            }

            public Builder setPhotoModeList(int OplusGLSurfaceView_13, String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensurePhotoModeListIsMutable();
                this.photoModeList_.set(OplusGLSurfaceView_13, str);
                onChanged();
                return this;
            }

            public Builder addPhotoModeList(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensurePhotoModeListIsMutable();
                this.photoModeList_.add(str);
                onChanged();
                return this;
            }

            public Builder addAllPhotoModeList(Iterable<String> iterable) {
                ensurePhotoModeListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.photoModeList_);
                onChanged();
                return this;
            }

            public Builder clearPhotoModeList() {
                this.photoModeList_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder addPhotoModeListBytes(ByteString byteString) {
                if (byteString != null) {
                    CameraConnectPreviewMessage.checkByteStringIsUtf8(byteString);
                    ensurePhotoModeListIsMutable();
                    this.photoModeList_.add(byteString);
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            public int getCodecWidth() {
                return this.codecWidth_;
            }

            public Builder setCodecWidth(int OplusGLSurfaceView_13) {
                this.codecWidth_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearCodecWidth() {
                this.codecWidth_ = 0;
                onChanged();
                return this;
            }

            public int getCodecHeight() {
                return this.codecHeight_;
            }

            public Builder setCodecHeight(int OplusGLSurfaceView_13) {
                this.codecHeight_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearCodecHeight() {
                this.codecHeight_ = 0;
                onChanged();
                return this;
            }

            public int getOrientation() {
                return this.orientation_;
            }

            public Builder setOrientation(int OplusGLSurfaceView_13) {
                this.orientation_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearOrientation() {
                this.orientation_ = 0;
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

        public static CameraConnectPreviewMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CameraConnectPreviewMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CameraConnectPreviewMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CameraConnectPreviewMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class WatchCaptureMessage extends GeneratedMessageV3 implements InterfaceC3587g {
        public static final int COUNTDOWN_FIELD_NUMBER = 1;
        private static final WatchCaptureMessage DEFAULT_INSTANCE = new WatchCaptureMessage();
        private static final Parser<WatchCaptureMessage> PARSER = new AbstractParser<WatchCaptureMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public WatchCaptureMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WatchCaptureMessage(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        private int countDown_;
        private byte memoizedIsInitialized;

        private WatchCaptureMessage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private WatchCaptureMessage() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new WatchCaptureMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WatchCaptureMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.countDown_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
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
            return WatchAgentProto.f23221e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WatchAgentProto.f23222f.ensureFieldAccessorsInitialized(WatchCaptureMessage.class, Builder.class);
        }

        public int getCountDown() {
            return this.countDown_;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int OplusGLSurfaceView_13 = this.countDown_;
            if (OplusGLSurfaceView_13 != 0) {
                codedOutputStream.writeInt32(1, OplusGLSurfaceView_13);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int OplusGLSurfaceView_13 = this.memoizedSize;
            if (OplusGLSurfaceView_13 != -1) {
                return OplusGLSurfaceView_13;
            }
            int i2 = this.countDown_;
            int iComputeInt32Size = (i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSize = iComputeInt32Size;
            return iComputeInt32Size;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WatchCaptureMessage)) {
                return super.equals(obj);
            }
            WatchCaptureMessage watchCaptureMessage = (WatchCaptureMessage) obj;
            return getCountDown() == watchCaptureMessage.getCountDown() && this.unknownFields.equals(watchCaptureMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCountDown()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static WatchCaptureMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static WatchCaptureMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static WatchCaptureMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static WatchCaptureMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static WatchCaptureMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static WatchCaptureMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static WatchCaptureMessage parseFrom(InputStream inputStream) throws IOException {
            return (WatchCaptureMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static WatchCaptureMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WatchCaptureMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WatchCaptureMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WatchCaptureMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WatchCaptureMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WatchCaptureMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WatchCaptureMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WatchCaptureMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WatchCaptureMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WatchCaptureMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WatchCaptureMessage watchCaptureMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(watchCaptureMessage);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InterfaceC3587g {
            private int countDown_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return WatchAgentProto.f23221e;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WatchAgentProto.f23222f.ensureFieldAccessorsInitialized(WatchCaptureMessage.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = WatchCaptureMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.countDown_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WatchAgentProto.f23221e;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WatchCaptureMessage getDefaultInstanceForType() {
                return WatchCaptureMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WatchCaptureMessage build() {
                WatchCaptureMessage watchCaptureMessageBuildPartial = buildPartial();
                if (watchCaptureMessageBuildPartial.isInitialized()) {
                    return watchCaptureMessageBuildPartial;
                }
                throw newUninitializedMessageException((Message) watchCaptureMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WatchCaptureMessage buildPartial() {
                WatchCaptureMessage watchCaptureMessage = new WatchCaptureMessage(this);
                watchCaptureMessage.countDown_ = this.countDown_;
                onBuilt();
                return watchCaptureMessage;
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
                if (message instanceof WatchCaptureMessage) {
                    return mergeFrom((WatchCaptureMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(WatchCaptureMessage watchCaptureMessage) {
                if (watchCaptureMessage == WatchCaptureMessage.getDefaultInstance()) {
                    return this;
                }
                if (watchCaptureMessage.getCountDown() != 0) {
                    setCountDown(watchCaptureMessage.getCountDown());
                }
                mergeUnknownFields(watchCaptureMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.access$4400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.oplus.camera.watch.proto.WatchAgentProto$WatchCaptureMessage r3 = (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.oplus.camera.watch.proto.WatchAgentProto$WatchCaptureMessage r4 = (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oplus.camera.watch.proto.WatchAgentProto$WatchCaptureMessage$Builder");
            }

            public int getCountDown() {
                return this.countDown_;
            }

            public Builder setCountDown(int OplusGLSurfaceView_13) {
                this.countDown_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearCountDown() {
                this.countDown_ = 0;
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

        public static WatchCaptureMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WatchCaptureMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WatchCaptureMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WatchCaptureMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CameraCaptureMessage extends GeneratedMessageV3 implements InterfaceC3582b {
        public static final int ISREADY_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private boolean isReady_;
        private byte memoizedIsInitialized;
        private static final CameraCaptureMessage DEFAULT_INSTANCE = new CameraCaptureMessage();
        private static final Parser<CameraCaptureMessage> PARSER = new AbstractParser<CameraCaptureMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public CameraCaptureMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CameraCaptureMessage(codedInputStream, extensionRegistryLite);
            }
        };

        private CameraCaptureMessage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CameraCaptureMessage() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new CameraCaptureMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CameraCaptureMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.isReady_ = codedInputStream.readBool();
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
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
            return WatchAgentProto.f23223g;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WatchAgentProto.f23224h.ensureFieldAccessorsInitialized(CameraCaptureMessage.class, Builder.class);
        }

        public boolean getIsReady() {
            return this.isReady_;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            boolean z = this.isReady_;
            if (z) {
                codedOutputStream.writeBool(1, z);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int OplusGLSurfaceView_13 = this.memoizedSize;
            if (OplusGLSurfaceView_13 != -1) {
                return OplusGLSurfaceView_13;
            }
            boolean z = this.isReady_;
            int iComputeBoolSize = (z ? 0 + CodedOutputStream.computeBoolSize(1, z) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSize = iComputeBoolSize;
            return iComputeBoolSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CameraCaptureMessage)) {
                return super.equals(obj);
            }
            CameraCaptureMessage cameraCaptureMessage = (CameraCaptureMessage) obj;
            return getIsReady() == cameraCaptureMessage.getIsReady() && this.unknownFields.equals(cameraCaptureMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashBoolean(getIsReady())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static CameraCaptureMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static CameraCaptureMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static CameraCaptureMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CameraCaptureMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CameraCaptureMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CameraCaptureMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static CameraCaptureMessage parseFrom(InputStream inputStream) throws IOException {
            return (CameraCaptureMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CameraCaptureMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraCaptureMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CameraCaptureMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CameraCaptureMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CameraCaptureMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraCaptureMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CameraCaptureMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CameraCaptureMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static CameraCaptureMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraCaptureMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CameraCaptureMessage cameraCaptureMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cameraCaptureMessage);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InterfaceC3582b {
            private boolean isReady_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return WatchAgentProto.f23223g;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WatchAgentProto.f23224h.ensureFieldAccessorsInitialized(CameraCaptureMessage.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CameraCaptureMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.isReady_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WatchAgentProto.f23223g;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CameraCaptureMessage getDefaultInstanceForType() {
                return CameraCaptureMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CameraCaptureMessage build() {
                CameraCaptureMessage cameraCaptureMessageBuildPartial = buildPartial();
                if (cameraCaptureMessageBuildPartial.isInitialized()) {
                    return cameraCaptureMessageBuildPartial;
                }
                throw newUninitializedMessageException((Message) cameraCaptureMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CameraCaptureMessage buildPartial() {
                CameraCaptureMessage cameraCaptureMessage = new CameraCaptureMessage(this);
                cameraCaptureMessage.isReady_ = this.isReady_;
                onBuilt();
                return cameraCaptureMessage;
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
                if (message instanceof CameraCaptureMessage) {
                    return mergeFrom((CameraCaptureMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(CameraCaptureMessage cameraCaptureMessage) {
                if (cameraCaptureMessage == CameraCaptureMessage.getDefaultInstance()) {
                    return this;
                }
                if (cameraCaptureMessage.getIsReady()) {
                    setIsReady(cameraCaptureMessage.getIsReady());
                }
                mergeUnknownFields(cameraCaptureMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.access$5400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.oplus.camera.watch.proto.WatchAgentProto$CameraCaptureMessage r3 = (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.oplus.camera.watch.proto.WatchAgentProto$CameraCaptureMessage r4 = (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oplus.camera.watch.proto.WatchAgentProto$CameraCaptureMessage$Builder");
            }

            public boolean getIsReady() {
                return this.isReady_;
            }

            public Builder setIsReady(boolean z) {
                this.isReady_ = z;
                onChanged();
                return this;
            }

            public Builder clearIsReady() {
                this.isReady_ = false;
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

        public static CameraCaptureMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CameraCaptureMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CameraCaptureMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CameraCaptureMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CameraCaptureDataMessage extends GeneratedMessageV3 implements InterfaceC3581a {
        public static final int PACKAGELENGTH_FIELD_NUMBER = 5;
        public static final int PICTUREDATA_FIELD_NUMBER = 4;
        public static final int SUBPACKAGEIDENTIFY_FIELD_NUMBER = 1;
        public static final int SUBPACKAGEINDEX_FIELD_NUMBER = 3;
        public static final int SUBPACKAGETOTAL_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int packageLength_;
        private ByteString pictureData_;
        private long subPackageIdentify_;
        private int subPackageIndex_;
        private int subPackageTotal_;
        private static final CameraCaptureDataMessage DEFAULT_INSTANCE = new CameraCaptureDataMessage();
        private static final Parser<CameraCaptureDataMessage> PARSER = new AbstractParser<CameraCaptureDataMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public CameraCaptureDataMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CameraCaptureDataMessage(codedInputStream, extensionRegistryLite);
            }
        };

        private CameraCaptureDataMessage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CameraCaptureDataMessage() {
            this.memoizedIsInitialized = (byte) -1;
            this.pictureData_ = ByteString.EMPTY;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new CameraCaptureDataMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CameraCaptureDataMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.subPackageIdentify_ = codedInputStream.readInt64();
                                } else if (tag == 16) {
                                    this.subPackageTotal_ = codedInputStream.readInt32();
                                } else if (tag == 24) {
                                    this.subPackageIndex_ = codedInputStream.readInt32();
                                } else if (tag == 34) {
                                    this.pictureData_ = codedInputStream.readBytes();
                                } else if (tag == 40) {
                                    this.packageLength_ = codedInputStream.readInt32();
                                } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                }
                            }
                            z = true;
                        } catch (IOException COUIBaseListPopupWindow_8) {
                            throw new InvalidProtocolBufferException(COUIBaseListPopupWindow_8).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WatchAgentProto.f23225i;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WatchAgentProto.f23226j.ensureFieldAccessorsInitialized(CameraCaptureDataMessage.class, Builder.class);
        }

        public long getSubPackageIdentify() {
            return this.subPackageIdentify_;
        }

        public int getSubPackageTotal() {
            return this.subPackageTotal_;
        }

        public int getSubPackageIndex() {
            return this.subPackageIndex_;
        }

        public ByteString getPictureData() {
            return this.pictureData_;
        }

        public int getPackageLength() {
            return this.packageLength_;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long OplusGLSurfaceView_15 = this.subPackageIdentify_;
            if (OplusGLSurfaceView_15 != 0) {
                codedOutputStream.writeInt64(1, OplusGLSurfaceView_15);
            }
            int OplusGLSurfaceView_13 = this.subPackageTotal_;
            if (OplusGLSurfaceView_13 != 0) {
                codedOutputStream.writeInt32(2, OplusGLSurfaceView_13);
            }
            int i2 = this.subPackageIndex_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(3, i2);
            }
            if (!this.pictureData_.isEmpty()) {
                codedOutputStream.writeBytes(4, this.pictureData_);
            }
            int i3 = this.packageLength_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(5, i3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int OplusGLSurfaceView_13 = this.memoizedSize;
            if (OplusGLSurfaceView_13 != -1) {
                return OplusGLSurfaceView_13;
            }
            long OplusGLSurfaceView_15 = this.subPackageIdentify_;
            int iComputeInt64Size = OplusGLSurfaceView_15 != 0 ? 0 + CodedOutputStream.computeInt64Size(1, OplusGLSurfaceView_15) : 0;
            int i2 = this.subPackageTotal_;
            if (i2 != 0) {
                iComputeInt64Size += CodedOutputStream.computeInt32Size(2, i2);
            }
            int i3 = this.subPackageIndex_;
            if (i3 != 0) {
                iComputeInt64Size += CodedOutputStream.computeInt32Size(3, i3);
            }
            if (!this.pictureData_.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, this.pictureData_);
            }
            int i4 = this.packageLength_;
            if (i4 != 0) {
                iComputeInt64Size += CodedOutputStream.computeInt32Size(5, i4);
            }
            int serializedSize = iComputeInt64Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CameraCaptureDataMessage)) {
                return super.equals(obj);
            }
            CameraCaptureDataMessage cameraCaptureDataMessage = (CameraCaptureDataMessage) obj;
            return getSubPackageIdentify() == cameraCaptureDataMessage.getSubPackageIdentify() && getSubPackageTotal() == cameraCaptureDataMessage.getSubPackageTotal() && getSubPackageIndex() == cameraCaptureDataMessage.getSubPackageIndex() && getPictureData().equals(cameraCaptureDataMessage.getPictureData()) && getPackageLength() == cameraCaptureDataMessage.getPackageLength() && this.unknownFields.equals(cameraCaptureDataMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getSubPackageIdentify())) * 37) + 2) * 53) + getSubPackageTotal()) * 37) + 3) * 53) + getSubPackageIndex()) * 37) + 4) * 53) + getPictureData().hashCode()) * 37) + 5) * 53) + getPackageLength()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static CameraCaptureDataMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static CameraCaptureDataMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static CameraCaptureDataMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CameraCaptureDataMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CameraCaptureDataMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CameraCaptureDataMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static CameraCaptureDataMessage parseFrom(InputStream inputStream) throws IOException {
            return (CameraCaptureDataMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CameraCaptureDataMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraCaptureDataMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CameraCaptureDataMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CameraCaptureDataMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CameraCaptureDataMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraCaptureDataMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CameraCaptureDataMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CameraCaptureDataMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static CameraCaptureDataMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraCaptureDataMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CameraCaptureDataMessage cameraCaptureDataMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cameraCaptureDataMessage);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InterfaceC3581a {
            private int packageLength_;
            private ByteString pictureData_;
            private long subPackageIdentify_;
            private int subPackageIndex_;
            private int subPackageTotal_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return WatchAgentProto.f23225i;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WatchAgentProto.f23226j.ensureFieldAccessorsInitialized(CameraCaptureDataMessage.class, Builder.class);
            }

            private Builder() {
                this.pictureData_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.pictureData_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CameraCaptureDataMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.subPackageIdentify_ = 0L;
                this.subPackageTotal_ = 0;
                this.subPackageIndex_ = 0;
                this.pictureData_ = ByteString.EMPTY;
                this.packageLength_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WatchAgentProto.f23225i;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CameraCaptureDataMessage getDefaultInstanceForType() {
                return CameraCaptureDataMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CameraCaptureDataMessage build() {
                CameraCaptureDataMessage cameraCaptureDataMessageBuildPartial = buildPartial();
                if (cameraCaptureDataMessageBuildPartial.isInitialized()) {
                    return cameraCaptureDataMessageBuildPartial;
                }
                throw newUninitializedMessageException((Message) cameraCaptureDataMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CameraCaptureDataMessage buildPartial() {
                CameraCaptureDataMessage cameraCaptureDataMessage = new CameraCaptureDataMessage(this);
                cameraCaptureDataMessage.subPackageIdentify_ = this.subPackageIdentify_;
                cameraCaptureDataMessage.subPackageTotal_ = this.subPackageTotal_;
                cameraCaptureDataMessage.subPackageIndex_ = this.subPackageIndex_;
                cameraCaptureDataMessage.pictureData_ = this.pictureData_;
                cameraCaptureDataMessage.packageLength_ = this.packageLength_;
                onBuilt();
                return cameraCaptureDataMessage;
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
                if (message instanceof CameraCaptureDataMessage) {
                    return mergeFrom((CameraCaptureDataMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(CameraCaptureDataMessage cameraCaptureDataMessage) {
                if (cameraCaptureDataMessage == CameraCaptureDataMessage.getDefaultInstance()) {
                    return this;
                }
                if (cameraCaptureDataMessage.getSubPackageIdentify() != 0) {
                    setSubPackageIdentify(cameraCaptureDataMessage.getSubPackageIdentify());
                }
                if (cameraCaptureDataMessage.getSubPackageTotal() != 0) {
                    setSubPackageTotal(cameraCaptureDataMessage.getSubPackageTotal());
                }
                if (cameraCaptureDataMessage.getSubPackageIndex() != 0) {
                    setSubPackageIndex(cameraCaptureDataMessage.getSubPackageIndex());
                }
                if (cameraCaptureDataMessage.getPictureData() != ByteString.EMPTY) {
                    setPictureData(cameraCaptureDataMessage.getPictureData());
                }
                if (cameraCaptureDataMessage.getPackageLength() != 0) {
                    setPackageLength(cameraCaptureDataMessage.getPackageLength());
                }
                mergeUnknownFields(cameraCaptureDataMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.access$6800()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.oplus.camera.watch.proto.WatchAgentProto$CameraCaptureDataMessage r3 = (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.oplus.camera.watch.proto.WatchAgentProto$CameraCaptureDataMessage r4 = (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oplus.camera.watch.proto.WatchAgentProto$CameraCaptureDataMessage$Builder");
            }

            public long getSubPackageIdentify() {
                return this.subPackageIdentify_;
            }

            public Builder setSubPackageIdentify(long OplusGLSurfaceView_15) {
                this.subPackageIdentify_ = OplusGLSurfaceView_15;
                onChanged();
                return this;
            }

            public Builder clearSubPackageIdentify() {
                this.subPackageIdentify_ = 0L;
                onChanged();
                return this;
            }

            public int getSubPackageTotal() {
                return this.subPackageTotal_;
            }

            public Builder setSubPackageTotal(int OplusGLSurfaceView_13) {
                this.subPackageTotal_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearSubPackageTotal() {
                this.subPackageTotal_ = 0;
                onChanged();
                return this;
            }

            public int getSubPackageIndex() {
                return this.subPackageIndex_;
            }

            public Builder setSubPackageIndex(int OplusGLSurfaceView_13) {
                this.subPackageIndex_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearSubPackageIndex() {
                this.subPackageIndex_ = 0;
                onChanged();
                return this;
            }

            public ByteString getPictureData() {
                return this.pictureData_;
            }

            public Builder setPictureData(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.pictureData_ = byteString;
                onChanged();
                return this;
            }

            public Builder clearPictureData() {
                this.pictureData_ = CameraCaptureDataMessage.getDefaultInstance().getPictureData();
                onChanged();
                return this;
            }

            public int getPackageLength() {
                return this.packageLength_;
            }

            public Builder setPackageLength(int OplusGLSurfaceView_13) {
                this.packageLength_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearPackageLength() {
                this.packageLength_ = 0;
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

        public static CameraCaptureDataMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CameraCaptureDataMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CameraCaptureDataMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CameraCaptureDataMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CameraRecordMessage extends GeneratedMessageV3 implements InterfaceC3586f {
        private static final CameraRecordMessage DEFAULT_INSTANCE = new CameraRecordMessage();
        private static final Parser<CameraRecordMessage> PARSER = new AbstractParser<CameraRecordMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public CameraRecordMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CameraRecordMessage(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RECORDTIME_FIELD_NUMBER = 2;
        public static final int VIDEOSTATE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private long recordTime_;
        private int videoState_;

        private CameraRecordMessage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CameraRecordMessage() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new CameraRecordMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CameraRecordMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.videoState_ = codedInputStream.readInt32();
                                } else if (tag == 16) {
                                    this.recordTime_ = codedInputStream.readInt64();
                                } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                }
                            }
                            z = true;
                        } catch (IOException COUIBaseListPopupWindow_8) {
                            throw new InvalidProtocolBufferException(COUIBaseListPopupWindow_8).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WatchAgentProto.f23227k;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WatchAgentProto.f23228l.ensureFieldAccessorsInitialized(CameraRecordMessage.class, Builder.class);
        }

        public int getVideoState() {
            return this.videoState_;
        }

        public long getRecordTime() {
            return this.recordTime_;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int OplusGLSurfaceView_13 = this.videoState_;
            if (OplusGLSurfaceView_13 != 0) {
                codedOutputStream.writeInt32(1, OplusGLSurfaceView_13);
            }
            long OplusGLSurfaceView_15 = this.recordTime_;
            if (OplusGLSurfaceView_15 != 0) {
                codedOutputStream.writeInt64(2, OplusGLSurfaceView_15);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int OplusGLSurfaceView_13 = this.memoizedSize;
            if (OplusGLSurfaceView_13 != -1) {
                return OplusGLSurfaceView_13;
            }
            int i2 = this.videoState_;
            int iComputeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
            long OplusGLSurfaceView_15 = this.recordTime_;
            if (OplusGLSurfaceView_15 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt64Size(2, OplusGLSurfaceView_15);
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CameraRecordMessage)) {
                return super.equals(obj);
            }
            CameraRecordMessage cameraRecordMessage = (CameraRecordMessage) obj;
            return getVideoState() == cameraRecordMessage.getVideoState() && getRecordTime() == cameraRecordMessage.getRecordTime() && this.unknownFields.equals(cameraRecordMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getVideoState()) * 37) + 2) * 53) + Internal.hashLong(getRecordTime())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static CameraRecordMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static CameraRecordMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static CameraRecordMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CameraRecordMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CameraRecordMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CameraRecordMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static CameraRecordMessage parseFrom(InputStream inputStream) throws IOException {
            return (CameraRecordMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CameraRecordMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraRecordMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CameraRecordMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CameraRecordMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CameraRecordMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraRecordMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CameraRecordMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CameraRecordMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static CameraRecordMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraRecordMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CameraRecordMessage cameraRecordMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cameraRecordMessage);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InterfaceC3586f {
            private long recordTime_;
            private int videoState_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return WatchAgentProto.f23227k;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WatchAgentProto.f23228l.ensureFieldAccessorsInitialized(CameraRecordMessage.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CameraRecordMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.videoState_ = 0;
                this.recordTime_ = 0L;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WatchAgentProto.f23227k;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CameraRecordMessage getDefaultInstanceForType() {
                return CameraRecordMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CameraRecordMessage build() {
                CameraRecordMessage cameraRecordMessageBuildPartial = buildPartial();
                if (cameraRecordMessageBuildPartial.isInitialized()) {
                    return cameraRecordMessageBuildPartial;
                }
                throw newUninitializedMessageException((Message) cameraRecordMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CameraRecordMessage buildPartial() {
                CameraRecordMessage cameraRecordMessage = new CameraRecordMessage(this);
                cameraRecordMessage.videoState_ = this.videoState_;
                cameraRecordMessage.recordTime_ = this.recordTime_;
                onBuilt();
                return cameraRecordMessage;
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
                if (message instanceof CameraRecordMessage) {
                    return mergeFrom((CameraRecordMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(CameraRecordMessage cameraRecordMessage) {
                if (cameraRecordMessage == CameraRecordMessage.getDefaultInstance()) {
                    return this;
                }
                if (cameraRecordMessage.getVideoState() != 0) {
                    setVideoState(cameraRecordMessage.getVideoState());
                }
                if (cameraRecordMessage.getRecordTime() != 0) {
                    setRecordTime(cameraRecordMessage.getRecordTime());
                }
                mergeUnknownFields(cameraRecordMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.access$7900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.oplus.camera.watch.proto.WatchAgentProto$CameraRecordMessage r3 = (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.oplus.camera.watch.proto.WatchAgentProto$CameraRecordMessage r4 = (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oplus.camera.watch.proto.WatchAgentProto$CameraRecordMessage$Builder");
            }

            public int getVideoState() {
                return this.videoState_;
            }

            public Builder setVideoState(int OplusGLSurfaceView_13) {
                this.videoState_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearVideoState() {
                this.videoState_ = 0;
                onChanged();
                return this;
            }

            public long getRecordTime() {
                return this.recordTime_;
            }

            public Builder setRecordTime(long OplusGLSurfaceView_15) {
                this.recordTime_ = OplusGLSurfaceView_15;
                onChanged();
                return this;
            }

            public Builder clearRecordTime() {
                this.recordTime_ = 0L;
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

        public static CameraRecordMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CameraRecordMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CameraRecordMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CameraRecordMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CameraOAFStateMessage extends GeneratedMessageV3 implements InterfaceC3585e {
        private static final CameraOAFStateMessage DEFAULT_INSTANCE = new CameraOAFStateMessage();
        private static final Parser<CameraOAFStateMessage> PARSER = new AbstractParser<CameraOAFStateMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public CameraOAFStateMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CameraOAFStateMessage(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RECONNECT_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private boolean reconnect_;

        private CameraOAFStateMessage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CameraOAFStateMessage() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new CameraOAFStateMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CameraOAFStateMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.reconnect_ = codedInputStream.readBool();
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
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
            return WatchAgentProto.f23229m;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WatchAgentProto.f23230n.ensureFieldAccessorsInitialized(CameraOAFStateMessage.class, Builder.class);
        }

        public boolean getReconnect() {
            return this.reconnect_;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            boolean z = this.reconnect_;
            if (z) {
                codedOutputStream.writeBool(1, z);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int OplusGLSurfaceView_13 = this.memoizedSize;
            if (OplusGLSurfaceView_13 != -1) {
                return OplusGLSurfaceView_13;
            }
            boolean z = this.reconnect_;
            int iComputeBoolSize = (z ? 0 + CodedOutputStream.computeBoolSize(1, z) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSize = iComputeBoolSize;
            return iComputeBoolSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CameraOAFStateMessage)) {
                return super.equals(obj);
            }
            CameraOAFStateMessage cameraOAFStateMessage = (CameraOAFStateMessage) obj;
            return getReconnect() == cameraOAFStateMessage.getReconnect() && this.unknownFields.equals(cameraOAFStateMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashBoolean(getReconnect())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static CameraOAFStateMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static CameraOAFStateMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static CameraOAFStateMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CameraOAFStateMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CameraOAFStateMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CameraOAFStateMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static CameraOAFStateMessage parseFrom(InputStream inputStream) throws IOException {
            return (CameraOAFStateMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CameraOAFStateMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraOAFStateMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CameraOAFStateMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CameraOAFStateMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CameraOAFStateMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraOAFStateMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CameraOAFStateMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CameraOAFStateMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static CameraOAFStateMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraOAFStateMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CameraOAFStateMessage cameraOAFStateMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cameraOAFStateMessage);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InterfaceC3585e {
            private boolean reconnect_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return WatchAgentProto.f23229m;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WatchAgentProto.f23230n.ensureFieldAccessorsInitialized(CameraOAFStateMessage.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CameraOAFStateMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.reconnect_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WatchAgentProto.f23229m;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CameraOAFStateMessage getDefaultInstanceForType() {
                return CameraOAFStateMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CameraOAFStateMessage build() {
                CameraOAFStateMessage cameraOAFStateMessageBuildPartial = buildPartial();
                if (cameraOAFStateMessageBuildPartial.isInitialized()) {
                    return cameraOAFStateMessageBuildPartial;
                }
                throw newUninitializedMessageException((Message) cameraOAFStateMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CameraOAFStateMessage buildPartial() {
                CameraOAFStateMessage cameraOAFStateMessage = new CameraOAFStateMessage(this);
                cameraOAFStateMessage.reconnect_ = this.reconnect_;
                onBuilt();
                return cameraOAFStateMessage;
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
                if (message instanceof CameraOAFStateMessage) {
                    return mergeFrom((CameraOAFStateMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(CameraOAFStateMessage cameraOAFStateMessage) {
                if (cameraOAFStateMessage == CameraOAFStateMessage.getDefaultInstance()) {
                    return this;
                }
                if (cameraOAFStateMessage.getReconnect()) {
                    setReconnect(cameraOAFStateMessage.getReconnect());
                }
                mergeUnknownFields(cameraOAFStateMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.access$8900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.oplus.camera.watch.proto.WatchAgentProto$CameraOAFStateMessage r3 = (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.oplus.camera.watch.proto.WatchAgentProto$CameraOAFStateMessage r4 = (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oplus.camera.watch.proto.WatchAgentProto$CameraOAFStateMessage$Builder");
            }

            public boolean getReconnect() {
                return this.reconnect_;
            }

            public Builder setReconnect(boolean z) {
                this.reconnect_ = z;
                onChanged();
                return this;
            }

            public Builder clearReconnect() {
                this.reconnect_ = false;
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

        public static CameraOAFStateMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CameraOAFStateMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CameraOAFStateMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CameraOAFStateMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CameraConfigurationMessage extends GeneratedMessageV3 implements InterfaceC3583c {
        public static final int CODECHEIGHT_FIELD_NUMBER = 3;
        public static final int CODECWIDTH_FIELD_NUMBER = 2;
        public static final int ORIENTATION_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int codecHeight_;
        private int codecWidth_;
        private byte memoizedIsInitialized;
        private int orientation_;
        private static final CameraConfigurationMessage DEFAULT_INSTANCE = new CameraConfigurationMessage();
        private static final Parser<CameraConfigurationMessage> PARSER = new AbstractParser<CameraConfigurationMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public CameraConfigurationMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CameraConfigurationMessage(codedInputStream, extensionRegistryLite);
            }
        };

        private CameraConfigurationMessage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CameraConfigurationMessage() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new CameraConfigurationMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CameraConfigurationMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.orientation_ = codedInputStream.readInt32();
                            } else if (tag == 16) {
                                this.codecWidth_ = codedInputStream.readInt32();
                            } else if (tag == 24) {
                                this.codecHeight_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
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
            return WatchAgentProto.f23231o;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WatchAgentProto.f23232p.ensureFieldAccessorsInitialized(CameraConfigurationMessage.class, Builder.class);
        }

        public int getOrientation() {
            return this.orientation_;
        }

        public int getCodecWidth() {
            return this.codecWidth_;
        }

        public int getCodecHeight() {
            return this.codecHeight_;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int OplusGLSurfaceView_13 = this.orientation_;
            if (OplusGLSurfaceView_13 != 0) {
                codedOutputStream.writeInt32(1, OplusGLSurfaceView_13);
            }
            int i2 = this.codecWidth_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(2, i2);
            }
            int i3 = this.codecHeight_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(3, i3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int OplusGLSurfaceView_13 = this.memoizedSize;
            if (OplusGLSurfaceView_13 != -1) {
                return OplusGLSurfaceView_13;
            }
            int i2 = this.orientation_;
            int iComputeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
            int i3 = this.codecWidth_;
            if (i3 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
            }
            int i4 = this.codecHeight_;
            if (i4 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, i4);
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CameraConfigurationMessage)) {
                return super.equals(obj);
            }
            CameraConfigurationMessage cameraConfigurationMessage = (CameraConfigurationMessage) obj;
            return getOrientation() == cameraConfigurationMessage.getOrientation() && getCodecWidth() == cameraConfigurationMessage.getCodecWidth() && getCodecHeight() == cameraConfigurationMessage.getCodecHeight() && this.unknownFields.equals(cameraConfigurationMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getOrientation()) * 37) + 2) * 53) + getCodecWidth()) * 37) + 3) * 53) + getCodecHeight()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static CameraConfigurationMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static CameraConfigurationMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static CameraConfigurationMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CameraConfigurationMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CameraConfigurationMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CameraConfigurationMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static CameraConfigurationMessage parseFrom(InputStream inputStream) throws IOException {
            return (CameraConfigurationMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CameraConfigurationMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraConfigurationMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CameraConfigurationMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CameraConfigurationMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CameraConfigurationMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraConfigurationMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CameraConfigurationMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CameraConfigurationMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static CameraConfigurationMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CameraConfigurationMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CameraConfigurationMessage cameraConfigurationMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cameraConfigurationMessage);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InterfaceC3583c {
            private int codecHeight_;
            private int codecWidth_;
            private int orientation_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return WatchAgentProto.f23231o;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WatchAgentProto.f23232p.ensureFieldAccessorsInitialized(CameraConfigurationMessage.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CameraConfigurationMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.orientation_ = 0;
                this.codecWidth_ = 0;
                this.codecHeight_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WatchAgentProto.f23231o;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CameraConfigurationMessage getDefaultInstanceForType() {
                return CameraConfigurationMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CameraConfigurationMessage build() {
                CameraConfigurationMessage cameraConfigurationMessageBuildPartial = buildPartial();
                if (cameraConfigurationMessageBuildPartial.isInitialized()) {
                    return cameraConfigurationMessageBuildPartial;
                }
                throw newUninitializedMessageException((Message) cameraConfigurationMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CameraConfigurationMessage buildPartial() {
                CameraConfigurationMessage cameraConfigurationMessage = new CameraConfigurationMessage(this);
                cameraConfigurationMessage.orientation_ = this.orientation_;
                cameraConfigurationMessage.codecWidth_ = this.codecWidth_;
                cameraConfigurationMessage.codecHeight_ = this.codecHeight_;
                onBuilt();
                return cameraConfigurationMessage;
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
                if (message instanceof CameraConfigurationMessage) {
                    return mergeFrom((CameraConfigurationMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(CameraConfigurationMessage cameraConfigurationMessage) {
                if (cameraConfigurationMessage == CameraConfigurationMessage.getDefaultInstance()) {
                    return this;
                }
                if (cameraConfigurationMessage.getOrientation() != 0) {
                    setOrientation(cameraConfigurationMessage.getOrientation());
                }
                if (cameraConfigurationMessage.getCodecWidth() != 0) {
                    setCodecWidth(cameraConfigurationMessage.getCodecWidth());
                }
                if (cameraConfigurationMessage.getCodecHeight() != 0) {
                    setCodecHeight(cameraConfigurationMessage.getCodecHeight());
                }
                mergeUnknownFields(cameraConfigurationMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.access$10100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.oplus.camera.watch.proto.WatchAgentProto$CameraConfigurationMessage r3 = (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.oplus.camera.watch.proto.WatchAgentProto$CameraConfigurationMessage r4 = (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.oplus.camera.watch.proto.WatchAgentProto$CameraConfigurationMessage$Builder");
            }

            public int getOrientation() {
                return this.orientation_;
            }

            public Builder setOrientation(int OplusGLSurfaceView_13) {
                this.orientation_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearOrientation() {
                this.orientation_ = 0;
                onChanged();
                return this;
            }

            public int getCodecWidth() {
                return this.codecWidth_;
            }

            public Builder setCodecWidth(int OplusGLSurfaceView_13) {
                this.codecWidth_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearCodecWidth() {
                this.codecWidth_ = 0;
                onChanged();
                return this;
            }

            public int getCodecHeight() {
                return this.codecHeight_;
            }

            public Builder setCodecHeight(int OplusGLSurfaceView_13) {
                this.codecHeight_ = OplusGLSurfaceView_13;
                onChanged();
                return this;
            }

            public Builder clearCodecHeight() {
                this.codecHeight_ = 0;
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

        public static CameraConfigurationMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CameraConfigurationMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CameraConfigurationMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CameraConfigurationMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Descriptors.FileDescriptor m24799a() {
        return f23233q;
    }
}
