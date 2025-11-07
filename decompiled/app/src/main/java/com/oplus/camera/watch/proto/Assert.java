package com.oplus.camera.watch.proto;

/* loaded from: classes2.dex */
public final class WatchAgentProto {
    private static com.google.protobuf.Descriptors.FileDescriptor q_renamed = com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new java.lang.String[]{"\n_renamed\u0015WatchAgentProto.proto\u0012\u001ccom.oplus.camera.watch.proto\"ñ\u0001\n_renamed\u001aWatchConnectPreviewMessage\u0012\u0014\n_renamed\fpreviewWidth\u0018\u0001 \u0001(\u0005\u0012\u0015\n_renamed\rpreviewHeight\u0018\u0002 \u0001(\u0005\u0012\u000f\n_renamed\u0007bitRate\u0018\u0003 \u0001(\u0005\u0012\u0015\n_renamed\rframeInterval\u0018\u0004 \u0001(\u0005\u0012\u0011\n_renamed\tframeRate\u0018\u0005 \u0001(\u0005\u0012\u001c\n_renamed\u0014isNeedLauncherCamera\u0018\u0006 \u0001(\b_renamed\u0012\u0016\n_renamed\u000ecaptureQuality\u0018\u0007 \u0001(\u0005\u0012\u0019\n_renamed\u0011singlePackageSize\u0018\b_renamed \u0001(\u0005\u0012\u001a\n_renamed\u0012singlePackageDelay\u0018\t_renamed \u0001(\u0005\" \u0001\n_renamed\u001bCameraConnectPreviewMessage\u0012\u0013\n_renamed\u000bcurrentMode\u0018\u0001 \u0001(\t_renamed\u0012\u0017\n_renamed\u000fcurrentModeName\u0018\u0002 \u0001(\t_renamed\u0012\u0015\n_renamed\rphotoModeList\u0018\u0003 \u0003(\t_renamed\u0012\u0012\n_renamed\ncodecWidth\u0018\u0004 \u0001(\u0005\u0012\u0013\n_renamed\u000bcodecHeight\u0018\u0005 \u0001(\u0005\u0012\u0013\n_renamed\u000borientation\u0018\u0006 \u0001(\u0005\"(\n_renamed\u0013WatchCaptureMessage\u0012\u0011\n_renamed\tcountDown\u0018\u0001 \u0001(\u0005\"'\n_renamed\u0014CameraCaptureMessage\u0012\u000f\n_renamed\u0007isReady\u0018\u0001 \u0001(\b_renamed\"\u0094\u0001\n_renamed\u0018CameraCaptureDataMessage\u0012\u001a\n_renamed\u0012subPackageIdentify\u0018\u0001 \u0001(\u0003\u0012\u0017\n_renamed\u000fsubPackageTotal\u0018\u0002 \u0001(\u0005\u0012\u0017\n_renamed\u000fsubPackageIndex\u0018\u0003 \u0001(\u0005\u0012\u0013\n_renamed\u000bpictureData\u0018\u0004 \u0001(\f_renamed\u0012\u0015\n_renamed\rpackageLength\u0018\u0005 \u0001(\u0005\"=\n_renamed\u0013CameraRecordMessage\u0012\u0012\n_renamed\nvideoState\u0018\u0001 \u0001(\u0005\u0012\u0012\n_renamed\nrecordTime\u0018\u0002 \u0001(\u0003\"*\n_renamed\u0015CameraOAFStateMessage\u0012\u0011\n_renamed\treconnect\u0018\u0001 \u0001(\b_renamed\"Z_renamed\n_renamed\u001aCameraConfigurationMessage\u0012\u0013\n_renamed\u000borientation\u0018\u0001 \u0001(\u0005\u0012\u0012\n_renamed\ncodecWidth\u0018\u0002 \u0001(\u0005\u0012\u0013\n_renamed\u000bcodecHeight\u0018\u0003 \u0001(\u0005b\u0006proto3"}, new com.google.protobuf.Descriptors.FileDescriptor[0]);

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.google.protobuf.Descriptors.Descriptor f7426a = a_renamed().getMessageTypes().get(0);

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable f7427b = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(f7426a, new java.lang.String[]{"PreviewWidth", "PreviewHeight", "BitRate", "FrameInterval", "FrameRate", "IsNeedLauncherCamera", "CaptureQuality", "SinglePackageSize", "SinglePackageDelay"});

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final com.google.protobuf.Descriptors.Descriptor f7428c = a_renamed().getMessageTypes().get(1);
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable d_renamed = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(f7428c, new java.lang.String[]{"CurrentMode", "CurrentModeName", "PhotoModeList", "CodecWidth", "CodecHeight", "Orientation"});
    private static final com.google.protobuf.Descriptors.Descriptor e_renamed = a_renamed().getMessageTypes().get(2);
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable f_renamed = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(e_renamed, new java.lang.String[]{"CountDown"});
    private static final com.google.protobuf.Descriptors.Descriptor g_renamed = a_renamed().getMessageTypes().get(3);
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable h_renamed = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(g_renamed, new java.lang.String[]{"IsReady"});
    private static final com.google.protobuf.Descriptors.Descriptor i_renamed = a_renamed().getMessageTypes().get(4);
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable j_renamed = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(i_renamed, new java.lang.String[]{"SubPackageIdentify", "SubPackageTotal", "SubPackageIndex", "PictureData", "PackageLength"});
    private static final com.google.protobuf.Descriptors.Descriptor k_renamed = a_renamed().getMessageTypes().get(5);
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable l_renamed = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(k_renamed, new java.lang.String[]{"VideoState", "RecordTime"});
    private static final com.google.protobuf.Descriptors.Descriptor m_renamed = a_renamed().getMessageTypes().get(6);
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable n_renamed = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(m_renamed, new java.lang.String[]{"Reconnect"});
    private static final com.google.protobuf.Descriptors.Descriptor o_renamed = a_renamed().getMessageTypes().get(7);
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable p_renamed = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(o_renamed, new java.lang.String[]{"Orientation", "CodecWidth", "CodecHeight"});

    public interface a_renamed extends com.google.protobuf.MessageOrBuilder {
    }

    public interface b_renamed extends com.google.protobuf.MessageOrBuilder {
    }

    public interface c_renamed extends com.google.protobuf.MessageOrBuilder {
    }

    public interface d_renamed extends com.google.protobuf.MessageOrBuilder {
    }

    public interface e_renamed extends com.google.protobuf.MessageOrBuilder {
    }

    public interface f_renamed extends com.google.protobuf.MessageOrBuilder {
    }

    public interface g_renamed extends com.google.protobuf.MessageOrBuilder {
    }

    public interface h_renamed extends com.google.protobuf.MessageOrBuilder {
    }

    public static final class WatchConnectPreviewMessage extends com.google.protobuf.GeneratedMessageV3 implements com.oplus.camera.watch.proto.WatchAgentProto.h_renamed {
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
        private static final com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage DEFAULT_INSTANCE = new com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage();
        private static final com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage> PARSER = new com.google.protobuf.AbstractParser<com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage(codedInputStream, extensionRegistryLite);
            }
        };

        private WatchConnectPreviewMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private WatchConnectPreviewMessage() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WatchConnectPreviewMessage(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            boolean z_renamed = false;
            while (!z_renamed) {
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
            return com.oplus.camera.watch.proto.WatchAgentProto.f7426a;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.oplus.camera.watch.proto.WatchAgentProto.f7427b.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder.class);
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
        public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            int i_renamed = this.previewWidth_;
            if (i_renamed != 0) {
                codedOutputStream.writeInt32(1, i_renamed);
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
            boolean z_renamed = this.isNeedLauncherCamera_;
            if (z_renamed) {
                codedOutputStream.writeBool(6, z_renamed);
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
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            int i2 = this.previewWidth_;
            int iComputeInt32Size = i2 != 0 ? 0 + com.google.protobuf.CodedOutputStream.computeInt32Size(1, i2) : 0;
            int i3 = this.previewHeight_;
            if (i3 != 0) {
                iComputeInt32Size += com.google.protobuf.CodedOutputStream.computeInt32Size(2, i3);
            }
            int i4 = this.bitRate_;
            if (i4 != 0) {
                iComputeInt32Size += com.google.protobuf.CodedOutputStream.computeInt32Size(3, i4);
            }
            int i5 = this.frameInterval_;
            if (i5 != 0) {
                iComputeInt32Size += com.google.protobuf.CodedOutputStream.computeInt32Size(4, i5);
            }
            int i6 = this.frameRate_;
            if (i6 != 0) {
                iComputeInt32Size += com.google.protobuf.CodedOutputStream.computeInt32Size(5, i6);
            }
            boolean z_renamed = this.isNeedLauncherCamera_;
            if (z_renamed) {
                iComputeInt32Size += com.google.protobuf.CodedOutputStream.computeBoolSize(6, z_renamed);
            }
            int i7 = this.captureQuality_;
            if (i7 != 0) {
                iComputeInt32Size += com.google.protobuf.CodedOutputStream.computeInt32Size(7, i7);
            }
            int i8 = this.singlePackageSize_;
            if (i8 != 0) {
                iComputeInt32Size += com.google.protobuf.CodedOutputStream.computeInt32Size(8, i8);
            }
            int i9 = this.singlePackageDelay_;
            if (i9 != 0) {
                iComputeInt32Size += com.google.protobuf.CodedOutputStream.computeInt32Size(9, i9);
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage)) {
                return super.equals(obj);
            }
            com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage watchConnectPreviewMessage = (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage) obj;
            return getPreviewWidth() == watchConnectPreviewMessage.getPreviewWidth() && getPreviewHeight() == watchConnectPreviewMessage.getPreviewHeight() && getBitRate() == watchConnectPreviewMessage.getBitRate() && getFrameInterval() == watchConnectPreviewMessage.getFrameInterval() && getFrameRate() == watchConnectPreviewMessage.getFrameRate() && getIsNeedLauncherCamera() == watchConnectPreviewMessage.getIsNeedLauncherCamera() && getCaptureQuality() == watchConnectPreviewMessage.getCaptureQuality() && getSinglePackageSize() == watchConnectPreviewMessage.getSinglePackageSize() && getSinglePackageDelay() == watchConnectPreviewMessage.getSinglePackageDelay() && this.unknownFields.equals(watchConnectPreviewMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getPreviewWidth()) * 37) + 2) * 53) + getPreviewHeight()) * 37) + 3) * 53) + getBitRate()) * 37) + 4) * 53) + getFrameInterval()) * 37) + 5) * 53) + getFrameRate()) * 37) + 6) * 53) + com.google.protobuf.Internal.hashBoolean(getIsNeedLauncherCamera())) * 37) + 7) * 53) + getCaptureQuality()) * 37) + 8) * 53) + getSinglePackageSize()) * 37) + 9) * 53) + getSinglePackageDelay()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder newBuilder(com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage watchConnectPreviewMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(watchConnectPreviewMessage);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder() : new com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder> implements com.oplus.camera.watch.proto.WatchAgentProto.h_renamed {
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

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.oplus.camera.watch.proto.WatchAgentProto.f7426a;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.oplus.camera.watch.proto.WatchAgentProto.f7427b.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder clear() {
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
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.f7426a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage getDefaultInstanceForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage build() {
                com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage watchConnectPreviewMessageBuildPartial = buildPartial();
                if (watchConnectPreviewMessageBuildPartial.isInitialized()) {
                    return watchConnectPreviewMessageBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) watchConnectPreviewMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage buildPartial() {
                com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage watchConnectPreviewMessage = new com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage(this);
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
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder mo23clone() {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage) {
                    return mergeFrom((com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder mergeFrom(com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage watchConnectPreviewMessage) {
                if (watchConnectPreviewMessage == com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.getDefaultInstance()) {
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

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
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

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder setPreviewWidth(int i_renamed) {
                this.previewWidth_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder clearPreviewWidth() {
                this.previewWidth_ = 0;
                onChanged();
                return this;
            }

            public int getPreviewHeight() {
                return this.previewHeight_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder setPreviewHeight(int i_renamed) {
                this.previewHeight_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder clearPreviewHeight() {
                this.previewHeight_ = 0;
                onChanged();
                return this;
            }

            public int getBitRate() {
                return this.bitRate_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder setBitRate(int i_renamed) {
                this.bitRate_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder clearBitRate() {
                this.bitRate_ = 0;
                onChanged();
                return this;
            }

            public int getFrameInterval() {
                return this.frameInterval_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder setFrameInterval(int i_renamed) {
                this.frameInterval_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder clearFrameInterval() {
                this.frameInterval_ = 0;
                onChanged();
                return this;
            }

            public int getFrameRate() {
                return this.frameRate_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder setFrameRate(int i_renamed) {
                this.frameRate_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder clearFrameRate() {
                this.frameRate_ = 0;
                onChanged();
                return this;
            }

            public boolean getIsNeedLauncherCamera() {
                return this.isNeedLauncherCamera_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder setIsNeedLauncherCamera(boolean z_renamed) {
                this.isNeedLauncherCamera_ = z_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder clearIsNeedLauncherCamera() {
                this.isNeedLauncherCamera_ = false;
                onChanged();
                return this;
            }

            public int getCaptureQuality() {
                return this.captureQuality_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder setCaptureQuality(int i_renamed) {
                this.captureQuality_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder clearCaptureQuality() {
                this.captureQuality_ = 0;
                onChanged();
                return this;
            }

            public int getSinglePackageSize() {
                return this.singlePackageSize_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder setSinglePackageSize(int i_renamed) {
                this.singlePackageSize_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder clearSinglePackageSize() {
                this.singlePackageSize_ = 0;
                onChanged();
                return this;
            }

            public int getSinglePackageDelay() {
                return this.singlePackageDelay_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder setSinglePackageDelay(int i_renamed) {
                this.singlePackageDelay_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder clearSinglePackageDelay() {
                this.singlePackageDelay_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CameraConnectPreviewMessage extends com.google.protobuf.GeneratedMessageV3 implements com.oplus.camera.watch.proto.WatchAgentProto.d_renamed {
        public static final int CODECHEIGHT_FIELD_NUMBER = 5;
        public static final int CODECWIDTH_FIELD_NUMBER = 4;
        public static final int CURRENTMODENAME_FIELD_NUMBER = 2;
        public static final int CURRENTMODE_FIELD_NUMBER = 1;
        public static final int ORIENTATION_FIELD_NUMBER = 6;
        public static final int PHOTOMODELIST_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int codecHeight_;
        private int codecWidth_;
        private volatile java.lang.Object currentModeName_;
        private volatile java.lang.Object currentMode_;
        private byte memoizedIsInitialized;
        private int orientation_;
        private com.google.protobuf.LazyStringList photoModeList_;
        private static final com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage DEFAULT_INSTANCE = new com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage();
        private static final com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage> PARSER = new com.google.protobuf.AbstractParser<com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage(codedInputStream, extensionRegistryLite);
            }
        };

        private CameraConnectPreviewMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CameraConnectPreviewMessage() {
            this.memoizedIsInitialized = (byte) -1;
            this.currentMode_ = "";
            this.currentModeName_ = "";
            this.photoModeList_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CameraConnectPreviewMessage(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            boolean z_renamed = false;
            boolean z2 = false;
            while (!z_renamed) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                this.currentMode_ = codedInputStream.readStringRequireUtf8();
                            } else if (tag == 18) {
                                this.currentModeName_ = codedInputStream.readStringRequireUtf8();
                            } else if (tag == 26) {
                                java.lang.String stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                if (!(z2 & true)) {
                                    this.photoModeList_ = new com.google.protobuf.LazyStringArrayList();
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
                        z_renamed = true;
                    } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                        throw e_renamed.setUnfinishedMessage(this);
                    } catch (java.io.IOException e2) {
                        throw new com.google.protobuf.InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
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

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.oplus.camera.watch.proto.WatchAgentProto.f7428c;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.oplus.camera.watch.proto.WatchAgentProto.d_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder.class);
        }

        public java.lang.String getCurrentMode() {
            java.lang.Object obj = this.currentMode_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
            this.currentMode_ = stringUtf8;
            return stringUtf8;
        }

        public com.google.protobuf.ByteString getCurrentModeBytes() {
            java.lang.Object obj = this.currentMode_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.currentMode_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public java.lang.String getCurrentModeName() {
            java.lang.Object obj = this.currentModeName_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
            this.currentModeName_ = stringUtf8;
            return stringUtf8;
        }

        public com.google.protobuf.ByteString getCurrentModeNameBytes() {
            java.lang.Object obj = this.currentModeName_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.currentModeName_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        /* renamed from: getPhotoModeListList, reason: merged with bridge method [inline-methods] */
        public com.google.protobuf.ProtocolStringList m146getPhotoModeListList() {
            return this.photoModeList_;
        }

        public int getPhotoModeListCount() {
            return this.photoModeList_.size();
        }

        public java.lang.String getPhotoModeList(int i_renamed) {
            return (java.lang.String) this.photoModeList_.get(i_renamed);
        }

        public com.google.protobuf.ByteString getPhotoModeListBytes(int i_renamed) {
            return this.photoModeList_.getByteString(i_renamed);
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
        public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            if (!getCurrentModeBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 1, this.currentMode_);
            }
            if (!getCurrentModeNameBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 2, this.currentModeName_);
            }
            for (int i_renamed = 0; i_renamed < this.photoModeList_.size(); i_renamed++) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 3, this.photoModeList_.getRaw(i_renamed));
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
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            int iComputeStringSize = !getCurrentModeBytes().isEmpty() ? com.google.protobuf.GeneratedMessageV3.computeStringSize(1, this.currentMode_) + 0 : 0;
            if (!getCurrentModeNameBytes().isEmpty()) {
                iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, this.currentModeName_);
            }
            int iComputeStringSizeNoTag = 0;
            for (int i2 = 0; i2 < this.photoModeList_.size(); i2++) {
                iComputeStringSizeNoTag += computeStringSizeNoTag(this.photoModeList_.getRaw(i2));
            }
            int size = iComputeStringSize + iComputeStringSizeNoTag + (m146getPhotoModeListList().size() * 1);
            int i3 = this.codecWidth_;
            if (i3 != 0) {
                size += com.google.protobuf.CodedOutputStream.computeInt32Size(4, i3);
            }
            int i4 = this.codecHeight_;
            if (i4 != 0) {
                size += com.google.protobuf.CodedOutputStream.computeInt32Size(5, i4);
            }
            int i5 = this.orientation_;
            if (i5 != 0) {
                size += com.google.protobuf.CodedOutputStream.computeInt32Size(6, i5);
            }
            int serializedSize = size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage)) {
                return super.equals(obj);
            }
            com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage cameraConnectPreviewMessage = (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage) obj;
            return getCurrentMode().equals(cameraConnectPreviewMessage.getCurrentMode()) && getCurrentModeName().equals(cameraConnectPreviewMessage.getCurrentModeName()) && m146getPhotoModeListList().equals(cameraConnectPreviewMessage.m146getPhotoModeListList()) && getCodecWidth() == cameraConnectPreviewMessage.getCodecWidth() && getCodecHeight() == cameraConnectPreviewMessage.getCodecHeight() && getOrientation() == cameraConnectPreviewMessage.getOrientation() && this.unknownFields.equals(cameraConnectPreviewMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCurrentMode().hashCode()) * 37) + 2) * 53) + getCurrentModeName().hashCode();
            if (getPhotoModeListCount() > 0) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + m146getPhotoModeListList().hashCode();
            }
            int codecWidth = (((((((((((((iHashCode * 37) + 4) * 53) + getCodecWidth()) * 37) + 5) * 53) + getCodecHeight()) * 37) + 6) * 53) + getOrientation()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = codecWidth;
            return codecWidth;
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder newBuilder(com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage cameraConnectPreviewMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cameraConnectPreviewMessage);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder() : new com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder> implements com.oplus.camera.watch.proto.WatchAgentProto.d_renamed {
            private int bitField0_;
            private int codecHeight_;
            private int codecWidth_;
            private java.lang.Object currentModeName_;
            private java.lang.Object currentMode_;
            private int orientation_;
            private com.google.protobuf.LazyStringList photoModeList_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.oplus.camera.watch.proto.WatchAgentProto.f7428c;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.oplus.camera.watch.proto.WatchAgentProto.d_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder.class);
            }

            private Builder() {
                this.currentMode_ = "";
                this.currentModeName_ = "";
                this.photoModeList_ = com.google.protobuf.LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.currentMode_ = "";
                this.currentModeName_ = "";
                this.photoModeList_ = com.google.protobuf.LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder clear() {
                super.clear();
                this.currentMode_ = "";
                this.currentModeName_ = "";
                this.photoModeList_ = com.google.protobuf.LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                this.codecWidth_ = 0;
                this.codecHeight_ = 0;
                this.orientation_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.f7428c;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage getDefaultInstanceForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage build() {
                com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage cameraConnectPreviewMessageBuildPartial = buildPartial();
                if (cameraConnectPreviewMessageBuildPartial.isInitialized()) {
                    return cameraConnectPreviewMessageBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) cameraConnectPreviewMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage buildPartial() {
                com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage cameraConnectPreviewMessage = new com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage(this);
                int i_renamed = this.bitField0_;
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
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder mo23clone() {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage) {
                    return mergeFrom((com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder mergeFrom(com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage cameraConnectPreviewMessage) {
                if (cameraConnectPreviewMessage == com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.getDefaultInstance()) {
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

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
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

            public java.lang.String getCurrentMode() {
                java.lang.Object obj = this.currentMode_;
                if (!(obj instanceof java.lang.String)) {
                    java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                    this.currentMode_ = stringUtf8;
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            public com.google.protobuf.ByteString getCurrentModeBytes() {
                java.lang.Object obj = this.currentMode_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.currentMode_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder setCurrentMode(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.currentMode_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder clearCurrentMode() {
                this.currentMode_ = com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.getDefaultInstance().getCurrentMode();
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder setCurrentModeBytes(com.google.protobuf.ByteString byteString) {
                if (byteString != null) {
                    com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.checkByteStringIsUtf8(byteString);
                    this.currentMode_ = byteString;
                    onChanged();
                    return this;
                }
                throw new java.lang.NullPointerException();
            }

            public java.lang.String getCurrentModeName() {
                java.lang.Object obj = this.currentModeName_;
                if (!(obj instanceof java.lang.String)) {
                    java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                    this.currentModeName_ = stringUtf8;
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            public com.google.protobuf.ByteString getCurrentModeNameBytes() {
                java.lang.Object obj = this.currentModeName_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.currentModeName_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder setCurrentModeName(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.currentModeName_ = str;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder clearCurrentModeName() {
                this.currentModeName_ = com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.getDefaultInstance().getCurrentModeName();
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder setCurrentModeNameBytes(com.google.protobuf.ByteString byteString) {
                if (byteString != null) {
                    com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.checkByteStringIsUtf8(byteString);
                    this.currentModeName_ = byteString;
                    onChanged();
                    return this;
                }
                throw new java.lang.NullPointerException();
            }

            private void ensurePhotoModeListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.photoModeList_ = new com.google.protobuf.LazyStringArrayList(this.photoModeList_);
                    this.bitField0_ |= 1;
                }
            }

            /* renamed from: getPhotoModeListList, reason: merged with bridge method [inline-methods] */
            public com.google.protobuf.ProtocolStringList m147getPhotoModeListList() {
                return this.photoModeList_.getUnmodifiableView();
            }

            public int getPhotoModeListCount() {
                return this.photoModeList_.size();
            }

            public java.lang.String getPhotoModeList(int i_renamed) {
                return (java.lang.String) this.photoModeList_.get(i_renamed);
            }

            public com.google.protobuf.ByteString getPhotoModeListBytes(int i_renamed) {
                return this.photoModeList_.getByteString(i_renamed);
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder setPhotoModeList(int i_renamed, java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                ensurePhotoModeListIsMutable();
                this.photoModeList_.set(i_renamed, str);
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder addPhotoModeList(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                ensurePhotoModeListIsMutable();
                this.photoModeList_.add(str);
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder addAllPhotoModeList(java.lang.Iterable<java.lang.String> iterable) {
                ensurePhotoModeListIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) this.photoModeList_);
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder clearPhotoModeList() {
                this.photoModeList_ = com.google.protobuf.LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder addPhotoModeListBytes(com.google.protobuf.ByteString byteString) {
                if (byteString != null) {
                    com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.checkByteStringIsUtf8(byteString);
                    ensurePhotoModeListIsMutable();
                    this.photoModeList_.add(byteString);
                    onChanged();
                    return this;
                }
                throw new java.lang.NullPointerException();
            }

            public int getCodecWidth() {
                return this.codecWidth_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder setCodecWidth(int i_renamed) {
                this.codecWidth_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder clearCodecWidth() {
                this.codecWidth_ = 0;
                onChanged();
                return this;
            }

            public int getCodecHeight() {
                return this.codecHeight_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder setCodecHeight(int i_renamed) {
                this.codecHeight_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder clearCodecHeight() {
                this.codecHeight_ = 0;
                onChanged();
                return this;
            }

            public int getOrientation() {
                return this.orientation_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder setOrientation(int i_renamed) {
                this.orientation_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder clearOrientation() {
                this.orientation_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class WatchCaptureMessage extends com.google.protobuf.GeneratedMessageV3 implements com.oplus.camera.watch.proto.WatchAgentProto.g_renamed {
        public static final int COUNTDOWN_FIELD_NUMBER = 1;
        private static final com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage DEFAULT_INSTANCE = new com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage();
        private static final com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage> PARSER = new com.google.protobuf.AbstractParser<com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        private int countDown_;
        private byte memoizedIsInitialized;

        private WatchCaptureMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private WatchCaptureMessage() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WatchCaptureMessage(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            boolean z_renamed = false;
            while (!z_renamed) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.countDown_ = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
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
            return com.oplus.camera.watch.proto.WatchAgentProto.e_renamed;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.oplus.camera.watch.proto.WatchAgentProto.f_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder.class);
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
        public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            int i_renamed = this.countDown_;
            if (i_renamed != 0) {
                codedOutputStream.writeInt32(1, i_renamed);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            int i2 = this.countDown_;
            int iComputeInt32Size = (i2 != 0 ? 0 + com.google.protobuf.CodedOutputStream.computeInt32Size(1, i2) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSize = iComputeInt32Size;
            return iComputeInt32Size;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage)) {
                return super.equals(obj);
            }
            com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage watchCaptureMessage = (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage) obj;
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

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder newBuilder(com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage watchCaptureMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(watchCaptureMessage);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder() : new com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder> implements com.oplus.camera.watch.proto.WatchAgentProto.g_renamed {
            private int countDown_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.oplus.camera.watch.proto.WatchAgentProto.e_renamed;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.oplus.camera.watch.proto.WatchAgentProto.f_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder clear() {
                super.clear();
                this.countDown_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.e_renamed;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage getDefaultInstanceForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage build() {
                com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage watchCaptureMessageBuildPartial = buildPartial();
                if (watchCaptureMessageBuildPartial.isInitialized()) {
                    return watchCaptureMessageBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) watchCaptureMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage buildPartial() {
                com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage watchCaptureMessage = new com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage(this);
                watchCaptureMessage.countDown_ = this.countDown_;
                onBuilt();
                return watchCaptureMessage;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder mo23clone() {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage) {
                    return mergeFrom((com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder mergeFrom(com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage watchCaptureMessage) {
                if (watchCaptureMessage == com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.getDefaultInstance()) {
                    return this;
                }
                if (watchCaptureMessage.getCountDown() != 0) {
                    setCountDown(watchCaptureMessage.getCountDown());
                }
                mergeUnknownFields(watchCaptureMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
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

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder setCountDown(int i_renamed) {
                this.countDown_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder clearCountDown() {
                this.countDown_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CameraCaptureMessage extends com.google.protobuf.GeneratedMessageV3 implements com.oplus.camera.watch.proto.WatchAgentProto.b_renamed {
        public static final int ISREADY_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private boolean isReady_;
        private byte memoizedIsInitialized;
        private static final com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage DEFAULT_INSTANCE = new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage();
        private static final com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage> PARSER = new com.google.protobuf.AbstractParser<com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage(codedInputStream, extensionRegistryLite);
            }
        };

        private CameraCaptureMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CameraCaptureMessage() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CameraCaptureMessage(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            boolean z_renamed = false;
            while (!z_renamed) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.isReady_ = codedInputStream.readBool();
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
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
            return com.oplus.camera.watch.proto.WatchAgentProto.g_renamed;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.oplus.camera.watch.proto.WatchAgentProto.h_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder.class);
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
        public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            boolean z_renamed = this.isReady_;
            if (z_renamed) {
                codedOutputStream.writeBool(1, z_renamed);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            boolean z_renamed = this.isReady_;
            int iComputeBoolSize = (z_renamed ? 0 + com.google.protobuf.CodedOutputStream.computeBoolSize(1, z_renamed) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSize = iComputeBoolSize;
            return iComputeBoolSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage)) {
                return super.equals(obj);
            }
            com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage cameraCaptureMessage = (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage) obj;
            return getIsReady() == cameraCaptureMessage.getIsReady() && this.unknownFields.equals(cameraCaptureMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + com.google.protobuf.Internal.hashBoolean(getIsReady())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder newBuilder(com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage cameraCaptureMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cameraCaptureMessage);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder() : new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder> implements com.oplus.camera.watch.proto.WatchAgentProto.b_renamed {
            private boolean isReady_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.oplus.camera.watch.proto.WatchAgentProto.g_renamed;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.oplus.camera.watch.proto.WatchAgentProto.h_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder clear() {
                super.clear();
                this.isReady_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.g_renamed;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage getDefaultInstanceForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage build() {
                com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage cameraCaptureMessageBuildPartial = buildPartial();
                if (cameraCaptureMessageBuildPartial.isInitialized()) {
                    return cameraCaptureMessageBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) cameraCaptureMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage buildPartial() {
                com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage cameraCaptureMessage = new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage(this);
                cameraCaptureMessage.isReady_ = this.isReady_;
                onBuilt();
                return cameraCaptureMessage;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder mo23clone() {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage) {
                    return mergeFrom((com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder mergeFrom(com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage cameraCaptureMessage) {
                if (cameraCaptureMessage == com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.getDefaultInstance()) {
                    return this;
                }
                if (cameraCaptureMessage.getIsReady()) {
                    setIsReady(cameraCaptureMessage.getIsReady());
                }
                mergeUnknownFields(cameraCaptureMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
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

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder setIsReady(boolean z_renamed) {
                this.isReady_ = z_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder clearIsReady() {
                this.isReady_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CameraCaptureDataMessage extends com.google.protobuf.GeneratedMessageV3 implements com.oplus.camera.watch.proto.WatchAgentProto.a_renamed {
        public static final int PACKAGELENGTH_FIELD_NUMBER = 5;
        public static final int PICTUREDATA_FIELD_NUMBER = 4;
        public static final int SUBPACKAGEIDENTIFY_FIELD_NUMBER = 1;
        public static final int SUBPACKAGEINDEX_FIELD_NUMBER = 3;
        public static final int SUBPACKAGETOTAL_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int packageLength_;
        private com.google.protobuf.ByteString pictureData_;
        private long subPackageIdentify_;
        private int subPackageIndex_;
        private int subPackageTotal_;
        private static final com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage DEFAULT_INSTANCE = new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage();
        private static final com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage> PARSER = new com.google.protobuf.AbstractParser<com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage(codedInputStream, extensionRegistryLite);
            }
        };

        private CameraCaptureDataMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CameraCaptureDataMessage() {
            this.memoizedIsInitialized = (byte) -1;
            this.pictureData_ = com.google.protobuf.ByteString.EMPTY;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CameraCaptureDataMessage(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            boolean z_renamed = false;
            while (!z_renamed) {
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
                            z_renamed = true;
                        } catch (java.io.IOException e_renamed) {
                            throw new com.google.protobuf.InvalidProtocolBufferException(e_renamed).setUnfinishedMessage(this);
                        }
                    } catch (com.google.protobuf.InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.oplus.camera.watch.proto.WatchAgentProto.i_renamed;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.oplus.camera.watch.proto.WatchAgentProto.j_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder.class);
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

        public com.google.protobuf.ByteString getPictureData() {
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
        public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            long j_renamed = this.subPackageIdentify_;
            if (j_renamed != 0) {
                codedOutputStream.writeInt64(1, j_renamed);
            }
            int i_renamed = this.subPackageTotal_;
            if (i_renamed != 0) {
                codedOutputStream.writeInt32(2, i_renamed);
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
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            long j_renamed = this.subPackageIdentify_;
            int iComputeInt64Size = j_renamed != 0 ? 0 + com.google.protobuf.CodedOutputStream.computeInt64Size(1, j_renamed) : 0;
            int i2 = this.subPackageTotal_;
            if (i2 != 0) {
                iComputeInt64Size += com.google.protobuf.CodedOutputStream.computeInt32Size(2, i2);
            }
            int i3 = this.subPackageIndex_;
            if (i3 != 0) {
                iComputeInt64Size += com.google.protobuf.CodedOutputStream.computeInt32Size(3, i3);
            }
            if (!this.pictureData_.isEmpty()) {
                iComputeInt64Size += com.google.protobuf.CodedOutputStream.computeBytesSize(4, this.pictureData_);
            }
            int i4 = this.packageLength_;
            if (i4 != 0) {
                iComputeInt64Size += com.google.protobuf.CodedOutputStream.computeInt32Size(5, i4);
            }
            int serializedSize = iComputeInt64Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage)) {
                return super.equals(obj);
            }
            com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage cameraCaptureDataMessage = (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage) obj;
            return getSubPackageIdentify() == cameraCaptureDataMessage.getSubPackageIdentify() && getSubPackageTotal() == cameraCaptureDataMessage.getSubPackageTotal() && getSubPackageIndex() == cameraCaptureDataMessage.getSubPackageIndex() && getPictureData().equals(cameraCaptureDataMessage.getPictureData()) && getPackageLength() == cameraCaptureDataMessage.getPackageLength() && this.unknownFields.equals(cameraCaptureDataMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + com.google.protobuf.Internal.hashLong(getSubPackageIdentify())) * 37) + 2) * 53) + getSubPackageTotal()) * 37) + 3) * 53) + getSubPackageIndex()) * 37) + 4) * 53) + getPictureData().hashCode()) * 37) + 5) * 53) + getPackageLength()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder newBuilder(com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage cameraCaptureDataMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cameraCaptureDataMessage);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder() : new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder> implements com.oplus.camera.watch.proto.WatchAgentProto.a_renamed {
            private int packageLength_;
            private com.google.protobuf.ByteString pictureData_;
            private long subPackageIdentify_;
            private int subPackageIndex_;
            private int subPackageTotal_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.oplus.camera.watch.proto.WatchAgentProto.i_renamed;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.oplus.camera.watch.proto.WatchAgentProto.j_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder.class);
            }

            private Builder() {
                this.pictureData_ = com.google.protobuf.ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.pictureData_ = com.google.protobuf.ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder clear() {
                super.clear();
                this.subPackageIdentify_ = 0L;
                this.subPackageTotal_ = 0;
                this.subPackageIndex_ = 0;
                this.pictureData_ = com.google.protobuf.ByteString.EMPTY;
                this.packageLength_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.i_renamed;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage getDefaultInstanceForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage build() {
                com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage cameraCaptureDataMessageBuildPartial = buildPartial();
                if (cameraCaptureDataMessageBuildPartial.isInitialized()) {
                    return cameraCaptureDataMessageBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) cameraCaptureDataMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage buildPartial() {
                com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage cameraCaptureDataMessage = new com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage(this);
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
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder mo23clone() {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage) {
                    return mergeFrom((com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder mergeFrom(com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage cameraCaptureDataMessage) {
                if (cameraCaptureDataMessage == com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.getDefaultInstance()) {
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
                if (cameraCaptureDataMessage.getPictureData() != com.google.protobuf.ByteString.EMPTY) {
                    setPictureData(cameraCaptureDataMessage.getPictureData());
                }
                if (cameraCaptureDataMessage.getPackageLength() != 0) {
                    setPackageLength(cameraCaptureDataMessage.getPackageLength());
                }
                mergeUnknownFields(cameraCaptureDataMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
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

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder setSubPackageIdentify(long j_renamed) {
                this.subPackageIdentify_ = j_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder clearSubPackageIdentify() {
                this.subPackageIdentify_ = 0L;
                onChanged();
                return this;
            }

            public int getSubPackageTotal() {
                return this.subPackageTotal_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder setSubPackageTotal(int i_renamed) {
                this.subPackageTotal_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder clearSubPackageTotal() {
                this.subPackageTotal_ = 0;
                onChanged();
                return this;
            }

            public int getSubPackageIndex() {
                return this.subPackageIndex_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder setSubPackageIndex(int i_renamed) {
                this.subPackageIndex_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder clearSubPackageIndex() {
                this.subPackageIndex_ = 0;
                onChanged();
                return this;
            }

            public com.google.protobuf.ByteString getPictureData() {
                return this.pictureData_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder setPictureData(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.pictureData_ = byteString;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder clearPictureData() {
                this.pictureData_ = com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.getDefaultInstance().getPictureData();
                onChanged();
                return this;
            }

            public int getPackageLength() {
                return this.packageLength_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder setPackageLength(int i_renamed) {
                this.packageLength_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder clearPackageLength() {
                this.packageLength_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CameraRecordMessage extends com.google.protobuf.GeneratedMessageV3 implements com.oplus.camera.watch.proto.WatchAgentProto.f_renamed {
        private static final com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage DEFAULT_INSTANCE = new com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage();
        private static final com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage> PARSER = new com.google.protobuf.AbstractParser<com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RECORDTIME_FIELD_NUMBER = 2;
        public static final int VIDEOSTATE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private long recordTime_;
        private int videoState_;

        private CameraRecordMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CameraRecordMessage() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CameraRecordMessage(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            boolean z_renamed = false;
            while (!z_renamed) {
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
                            z_renamed = true;
                        } catch (java.io.IOException e_renamed) {
                            throw new com.google.protobuf.InvalidProtocolBufferException(e_renamed).setUnfinishedMessage(this);
                        }
                    } catch (com.google.protobuf.InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.oplus.camera.watch.proto.WatchAgentProto.k_renamed;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.oplus.camera.watch.proto.WatchAgentProto.l_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder.class);
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
        public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            int i_renamed = this.videoState_;
            if (i_renamed != 0) {
                codedOutputStream.writeInt32(1, i_renamed);
            }
            long j_renamed = this.recordTime_;
            if (j_renamed != 0) {
                codedOutputStream.writeInt64(2, j_renamed);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            int i2 = this.videoState_;
            int iComputeInt32Size = i2 != 0 ? 0 + com.google.protobuf.CodedOutputStream.computeInt32Size(1, i2) : 0;
            long j_renamed = this.recordTime_;
            if (j_renamed != 0) {
                iComputeInt32Size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, j_renamed);
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage)) {
                return super.equals(obj);
            }
            com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage cameraRecordMessage = (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage) obj;
            return getVideoState() == cameraRecordMessage.getVideoState() && getRecordTime() == cameraRecordMessage.getRecordTime() && this.unknownFields.equals(cameraRecordMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getVideoState()) * 37) + 2) * 53) + com.google.protobuf.Internal.hashLong(getRecordTime())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder newBuilder(com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage cameraRecordMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cameraRecordMessage);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder() : new com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder> implements com.oplus.camera.watch.proto.WatchAgentProto.f_renamed {
            private long recordTime_;
            private int videoState_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.oplus.camera.watch.proto.WatchAgentProto.k_renamed;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.oplus.camera.watch.proto.WatchAgentProto.l_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder clear() {
                super.clear();
                this.videoState_ = 0;
                this.recordTime_ = 0L;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.k_renamed;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage getDefaultInstanceForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage build() {
                com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage cameraRecordMessageBuildPartial = buildPartial();
                if (cameraRecordMessageBuildPartial.isInitialized()) {
                    return cameraRecordMessageBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) cameraRecordMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage buildPartial() {
                com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage cameraRecordMessage = new com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage(this);
                cameraRecordMessage.videoState_ = this.videoState_;
                cameraRecordMessage.recordTime_ = this.recordTime_;
                onBuilt();
                return cameraRecordMessage;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder mo23clone() {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage) {
                    return mergeFrom((com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder mergeFrom(com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage cameraRecordMessage) {
                if (cameraRecordMessage == com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.getDefaultInstance()) {
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

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
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

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder setVideoState(int i_renamed) {
                this.videoState_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder clearVideoState() {
                this.videoState_ = 0;
                onChanged();
                return this;
            }

            public long getRecordTime() {
                return this.recordTime_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder setRecordTime(long j_renamed) {
                this.recordTime_ = j_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder clearRecordTime() {
                this.recordTime_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CameraOAFStateMessage extends com.google.protobuf.GeneratedMessageV3 implements com.oplus.camera.watch.proto.WatchAgentProto.e_renamed {
        private static final com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage DEFAULT_INSTANCE = new com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage();
        private static final com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage> PARSER = new com.google.protobuf.AbstractParser<com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RECONNECT_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private boolean reconnect_;

        private CameraOAFStateMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CameraOAFStateMessage() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CameraOAFStateMessage(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            boolean z_renamed = false;
            while (!z_renamed) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.reconnect_ = codedInputStream.readBool();
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
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
            return com.oplus.camera.watch.proto.WatchAgentProto.m_renamed;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.oplus.camera.watch.proto.WatchAgentProto.n_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder.class);
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
        public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            boolean z_renamed = this.reconnect_;
            if (z_renamed) {
                codedOutputStream.writeBool(1, z_renamed);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            boolean z_renamed = this.reconnect_;
            int iComputeBoolSize = (z_renamed ? 0 + com.google.protobuf.CodedOutputStream.computeBoolSize(1, z_renamed) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSize = iComputeBoolSize;
            return iComputeBoolSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage)) {
                return super.equals(obj);
            }
            com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage cameraOAFStateMessage = (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage) obj;
            return getReconnect() == cameraOAFStateMessage.getReconnect() && this.unknownFields.equals(cameraOAFStateMessage.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + com.google.protobuf.Internal.hashBoolean(getReconnect())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder newBuilder(com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage cameraOAFStateMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cameraOAFStateMessage);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder() : new com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder> implements com.oplus.camera.watch.proto.WatchAgentProto.e_renamed {
            private boolean reconnect_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.oplus.camera.watch.proto.WatchAgentProto.m_renamed;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.oplus.camera.watch.proto.WatchAgentProto.n_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder clear() {
                super.clear();
                this.reconnect_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.m_renamed;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage getDefaultInstanceForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage build() {
                com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage cameraOAFStateMessageBuildPartial = buildPartial();
                if (cameraOAFStateMessageBuildPartial.isInitialized()) {
                    return cameraOAFStateMessageBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) cameraOAFStateMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage buildPartial() {
                com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage cameraOAFStateMessage = new com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage(this);
                cameraOAFStateMessage.reconnect_ = this.reconnect_;
                onBuilt();
                return cameraOAFStateMessage;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder mo23clone() {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage) {
                    return mergeFrom((com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder mergeFrom(com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage cameraOAFStateMessage) {
                if (cameraOAFStateMessage == com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.getDefaultInstance()) {
                    return this;
                }
                if (cameraOAFStateMessage.getReconnect()) {
                    setReconnect(cameraOAFStateMessage.getReconnect());
                }
                mergeUnknownFields(cameraOAFStateMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
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

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder setReconnect(boolean z_renamed) {
                this.reconnect_ = z_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder clearReconnect() {
                this.reconnect_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CameraConfigurationMessage extends com.google.protobuf.GeneratedMessageV3 implements com.oplus.camera.watch.proto.WatchAgentProto.c_renamed {
        public static final int CODECHEIGHT_FIELD_NUMBER = 3;
        public static final int CODECWIDTH_FIELD_NUMBER = 2;
        public static final int ORIENTATION_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int codecHeight_;
        private int codecWidth_;
        private byte memoizedIsInitialized;
        private int orientation_;
        private static final com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage DEFAULT_INSTANCE = new com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage();
        private static final com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage> PARSER = new com.google.protobuf.AbstractParser<com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage>() { // from class: com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.1
            @Override // com.google.protobuf.Parser
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage(codedInputStream, extensionRegistryLite);
            }
        };

        private CameraConfigurationMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CameraConfigurationMessage() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CameraConfigurationMessage(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            boolean z_renamed = false;
            while (!z_renamed) {
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
            return com.oplus.camera.watch.proto.WatchAgentProto.o_renamed;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.oplus.camera.watch.proto.WatchAgentProto.p_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder.class);
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
        public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            int i_renamed = this.orientation_;
            if (i_renamed != 0) {
                codedOutputStream.writeInt32(1, i_renamed);
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
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            int i2 = this.orientation_;
            int iComputeInt32Size = i2 != 0 ? 0 + com.google.protobuf.CodedOutputStream.computeInt32Size(1, i2) : 0;
            int i3 = this.codecWidth_;
            if (i3 != 0) {
                iComputeInt32Size += com.google.protobuf.CodedOutputStream.computeInt32Size(2, i3);
            }
            int i4 = this.codecHeight_;
            if (i4 != 0) {
                iComputeInt32Size += com.google.protobuf.CodedOutputStream.computeInt32Size(3, i4);
            }
            int serializedSize = iComputeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage)) {
                return super.equals(obj);
            }
            com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage cameraConfigurationMessage = (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage) obj;
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

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder newBuilder(com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage cameraConfigurationMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cameraConfigurationMessage);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder() : new com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder> implements com.oplus.camera.watch.proto.WatchAgentProto.c_renamed {
            private int codecHeight_;
            private int codecWidth_;
            private int orientation_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.oplus.camera.watch.proto.WatchAgentProto.o_renamed;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.oplus.camera.watch.proto.WatchAgentProto.p_renamed.ensureFieldAccessorsInitialized(com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.class, com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder clear() {
                super.clear();
                this.orientation_ = 0;
                this.codecWidth_ = 0;
                this.codecHeight_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.o_renamed;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage getDefaultInstanceForType() {
                return com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage build() {
                com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage cameraConfigurationMessageBuildPartial = buildPartial();
                if (cameraConfigurationMessageBuildPartial.isInitialized()) {
                    return cameraConfigurationMessageBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) cameraConfigurationMessageBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage buildPartial() {
                com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage cameraConfigurationMessage = new com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage(this);
                cameraConfigurationMessage.orientation_ = this.orientation_;
                cameraConfigurationMessage.codecWidth_ = this.codecWidth_;
                cameraConfigurationMessage.codecHeight_ = this.codecHeight_;
                onBuilt();
                return cameraConfigurationMessage;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder mo23clone() {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage) {
                    return mergeFrom((com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder mergeFrom(com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage cameraConfigurationMessage) {
                if (cameraConfigurationMessage == com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.getDefaultInstance()) {
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

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
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

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder setOrientation(int i_renamed) {
                this.orientation_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder clearOrientation() {
                this.orientation_ = 0;
                onChanged();
                return this;
            }

            public int getCodecWidth() {
                return this.codecWidth_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder setCodecWidth(int i_renamed) {
                this.codecWidth_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder clearCodecWidth() {
                this.codecWidth_ = 0;
                onChanged();
                return this;
            }

            public int getCodecHeight() {
                return this.codecHeight_;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder setCodecHeight(int i_renamed) {
                this.codecHeight_ = i_renamed;
                onChanged();
                return this;
            }

            public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder clearCodecHeight() {
                this.codecHeight_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static com.google.protobuf.Descriptors.FileDescriptor a_renamed() {
        return q_renamed;
    }
}
