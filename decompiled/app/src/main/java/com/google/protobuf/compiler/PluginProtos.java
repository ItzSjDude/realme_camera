package com.google.protobuf.compiler;

/* loaded from: classes.dex */
public final class PluginProtos {
    private static com.google.protobuf.Descriptors.FileDescriptor descriptor = com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new java.lang.String[]{"\n_renamed%google/protobuf/compiler/plugin.proto\u0012\u0018google.protobuf.compiler\u001a google/protobuf/descriptor.proto\"F_renamed\n_renamed\u0007Version\u0012\r_renamed\n_renamed\u0005major\u0018\u0001 \u0001(\u0005\u0012\r_renamed\n_renamed\u0005minor\u0018\u0002 \u0001(\u0005\u0012\r_renamed\n_renamed\u0005patch\u0018\u0003 \u0001(\u0005\u0012\u000e\n_renamed\u0006suffix\u0018\u0004 \u0001(\t_renamed\"º\u0001\n_renamed\u0014CodeGeneratorRequest\u0012\u0018\n_renamed\u0010file_to_generate\u0018\u0001 \u0003(\t_renamed\u0012\u0011\n_renamed\tparameter\u0018\u0002 \u0001(\t_renamed\u00128\n_renamed\nproto_file\u0018\u000f \u0003(\u000b2$.google.protobuf.FileDescriptorProto\u0012;\n_renamed\u0010compiler_version\u0018\u0003 \u0001(\u000b2!.google.protobuf.compiler.Version\"ª\u0001\n_renamed\u0015CodeGeneratorResponse\u0012\r_renamed\n_renamed\u0005error\u0018\u0001 \u0001(\t_renamed\u0012B\n_renamed\u0004file\u0018\u000f \u0003(\u000b24.google.protobuf.compiler.CodeGeneratorResponse.File\u001a>\n_renamed\u0004File\u0012\f_renamed\n_renamed\u0004name\u0018\u0001 \u0001(\t_renamed\u0012\u0017\n_renamed\u000finsertion_point\u0018\u0002 \u0001(\t_renamed\u0012\u000f\n_renamed\u0007content\u0018\u000f \u0001(\tBg\n_renamed\u001ccom.google.protobuf.compilerB\fPluginProtosZ9github.com/golang/protobuf/protoc-gen-go_renamed/plugin;plugin_go"}, new com.google.protobuf.Descriptors.FileDescriptor[]{com.google.protobuf.DescriptorProtos.getDescriptor()});
    private static final com.google.protobuf.Descriptors.Descriptor internal_static_google_protobuf_compiler_Version_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_Version_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_compiler_Version_descriptor, new java.lang.String[]{"Major", "Minor", "Patch", "Suffix"});
    private static final com.google.protobuf.Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor, new java.lang.String[]{"FileToGenerate", "Parameter", "ProtoFile", "CompilerVersion"});
    private static final com.google.protobuf.Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor, new java.lang.String[]{"Error", "File"});
    private static final com.google.protobuf.Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor = internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor.getNestedTypes().get(0);
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor, new java.lang.String[]{"Name", "InsertionPoint", "Content"});

    public interface CodeGeneratorRequestOrBuilder extends com.google.protobuf.MessageOrBuilder {
        com.google.protobuf.compiler.PluginProtos.Version getCompilerVersion();

        com.google.protobuf.compiler.PluginProtos.VersionOrBuilder getCompilerVersionOrBuilder();

        java.lang.String getFileToGenerate(int i_renamed);

        com.google.protobuf.ByteString getFileToGenerateBytes(int i_renamed);

        int getFileToGenerateCount();

        java.util.List<java.lang.String> getFileToGenerateList();

        java.lang.String getParameter();

        com.google.protobuf.ByteString getParameterBytes();

        com.google.protobuf.DescriptorProtos.FileDescriptorProto getProtoFile(int i_renamed);

        int getProtoFileCount();

        java.util.List<com.google.protobuf.DescriptorProtos.FileDescriptorProto> getProtoFileList();

        com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int i_renamed);

        java.util.List<? extends com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList();

        boolean hasCompilerVersion();

        boolean hasParameter();
    }

    public interface CodeGeneratorResponseOrBuilder extends com.google.protobuf.MessageOrBuilder {
        java.lang.String getError();

        com.google.protobuf.ByteString getErrorBytes();

        com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File getFile(int i_renamed);

        int getFileCount();

        java.util.List<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File> getFileList();

        com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int i_renamed);

        java.util.List<? extends com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> getFileOrBuilderList();

        boolean hasError();
    }

    public interface VersionOrBuilder extends com.google.protobuf.MessageOrBuilder {
        int getMajor();

        int getMinor();

        int getPatch();

        java.lang.String getSuffix();

        com.google.protobuf.ByteString getSuffixBytes();

        boolean hasMajor();

        boolean hasMinor();

        boolean hasPatch();

        boolean hasSuffix();
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) {
    }

    private PluginProtos() {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry extensionRegistry) {
        registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) extensionRegistry);
    }

    public static final class Version extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.compiler.PluginProtos.VersionOrBuilder {
        public static final int MAJOR_FIELD_NUMBER = 1;
        public static final int MINOR_FIELD_NUMBER = 2;
        public static final int PATCH_FIELD_NUMBER = 3;
        public static final int SUFFIX_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int major_;
        private byte memoizedIsInitialized;
        private int minor_;
        private int patch_;
        private volatile java.lang.Object suffix_;
        private static final com.google.protobuf.compiler.PluginProtos.Version DEFAULT_INSTANCE = new com.google.protobuf.compiler.PluginProtos.Version();

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos.Version> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.compiler.PluginProtos.Version>() { // from class: com.google.protobuf.compiler.PluginProtos.Version.1
            @Override // com.google.protobuf.Parser
            public com.google.protobuf.compiler.PluginProtos.Version parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.google.protobuf.compiler.PluginProtos.Version(codedInputStream, extensionRegistryLite);
            }
        };

        private Version(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Version() {
            this.memoizedIsInitialized = (byte) -1;
            this.suffix_ = "";
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new com.google.protobuf.compiler.PluginProtos.Version();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Version(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
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
                                this.bitField0_ |= 1;
                                this.major_ = codedInputStream.readInt32();
                            } else if (tag == 16) {
                                this.bitField0_ |= 2;
                                this.minor_ = codedInputStream.readInt32();
                            } else if (tag == 24) {
                                this.bitField0_ |= 4;
                                this.patch_ = codedInputStream.readInt32();
                            } else if (tag == 34) {
                                com.google.protobuf.ByteString bytes = codedInputStream.readBytes();
                                this.bitField0_ |= 8;
                                this.suffix_ = bytes;
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
            return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_Version_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.compiler.PluginProtos.Version.class, com.google.protobuf.compiler.PluginProtos.Version.Builder.class);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasMajor() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getMajor() {
            return this.major_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasMinor() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getMinor() {
            return this.minor_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasPatch() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getPatch() {
            return this.patch_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasSuffix() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public java.lang.String getSuffix() {
            java.lang.Object obj = this.suffix_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.suffix_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public com.google.protobuf.ByteString getSuffixBytes() {
            java.lang.Object obj = this.suffix_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.suffix_ = byteStringCopyFromUtf8;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputStream.writeInt32(1, this.major_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeInt32(2, this.minor_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeInt32(3, this.patch_);
            }
            if ((this.bitField0_ & 8) != 0) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 4, this.suffix_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            int iComputeInt32Size = (this.bitField0_ & 1) != 0 ? 0 + com.google.protobuf.CodedOutputStream.computeInt32Size(1, this.major_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                iComputeInt32Size += com.google.protobuf.CodedOutputStream.computeInt32Size(2, this.minor_);
            }
            if ((this.bitField0_ & 4) != 0) {
                iComputeInt32Size += com.google.protobuf.CodedOutputStream.computeInt32Size(3, this.patch_);
            }
            if ((this.bitField0_ & 8) != 0) {
                iComputeInt32Size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, this.suffix_);
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
            if (!(obj instanceof com.google.protobuf.compiler.PluginProtos.Version)) {
                return super.equals(obj);
            }
            com.google.protobuf.compiler.PluginProtos.Version version = (com.google.protobuf.compiler.PluginProtos.Version) obj;
            if (hasMajor() != version.hasMajor()) {
                return false;
            }
            if ((hasMajor() && getMajor() != version.getMajor()) || hasMinor() != version.hasMinor()) {
                return false;
            }
            if ((hasMinor() && getMinor() != version.getMinor()) || hasPatch() != version.hasPatch()) {
                return false;
            }
            if ((!hasPatch() || getPatch() == version.getPatch()) && hasSuffix() == version.hasSuffix()) {
                return (!hasSuffix() || getSuffix().equals(version.getSuffix())) && this.unknownFields.equals(version.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptor().hashCode();
            if (hasMajor()) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getMajor();
            }
            if (hasMinor()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getMinor();
            }
            if (hasPatch()) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + getPatch();
            }
            if (hasSuffix()) {
                iHashCode = (((iHashCode * 37) + 4) * 53) + getSuffix().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static com.google.protobuf.compiler.PluginProtos.Version parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static com.google.protobuf.compiler.PluginProtos.Version parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.Version parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.google.protobuf.compiler.PluginProtos.Version parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.Version parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.google.protobuf.compiler.PluginProtos.Version parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.Version parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.Version) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.google.protobuf.compiler.PluginProtos.Version parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.Version) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.Version parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.Version) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.google.protobuf.compiler.PluginProtos.Version parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.Version) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.Version parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.Version) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.google.protobuf.compiler.PluginProtos.Version parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.Version) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.compiler.PluginProtos.Version.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.google.protobuf.compiler.PluginProtos.Version.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.google.protobuf.compiler.PluginProtos.Version.Builder newBuilder(com.google.protobuf.compiler.PluginProtos.Version version) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(version);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.compiler.PluginProtos.Version.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.google.protobuf.compiler.PluginProtos.Version.Builder() : new com.google.protobuf.compiler.PluginProtos.Version.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.google.protobuf.compiler.PluginProtos.Version.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.google.protobuf.compiler.PluginProtos.Version.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.compiler.PluginProtos.Version.Builder> implements com.google.protobuf.compiler.PluginProtos.VersionOrBuilder {
            private int bitField0_;
            private int major_;
            private int minor_;
            private int patch_;
            private java.lang.Object suffix_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_Version_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.compiler.PluginProtos.Version.class, com.google.protobuf.compiler.PluginProtos.Version.Builder.class);
            }

            private Builder() {
                this.suffix_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.suffix_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = com.google.protobuf.compiler.PluginProtos.Version.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.Version.Builder clear() {
                super.clear();
                this.major_ = 0;
                this.bitField0_ &= -2;
                this.minor_ = 0;
                this.bitField0_ &= -3;
                this.patch_ = 0;
                this.bitField0_ &= -5;
                this.suffix_ = "";
                this.bitField0_ &= -9;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.compiler.PluginProtos.Version getDefaultInstanceForType() {
                return com.google.protobuf.compiler.PluginProtos.Version.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.Version build() {
                com.google.protobuf.compiler.PluginProtos.Version versionBuildPartial = buildPartial();
                if (versionBuildPartial.isInitialized()) {
                    return versionBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) versionBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.Version buildPartial() {
                int i_renamed;
                com.google.protobuf.compiler.PluginProtos.Version version = new com.google.protobuf.compiler.PluginProtos.Version(this);
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    version.major_ = this.major_;
                    i_renamed = 1;
                } else {
                    i_renamed = 0;
                }
                if ((i2 & 2) != 0) {
                    version.minor_ = this.minor_;
                    i_renamed |= 2;
                }
                if ((i2 & 4) != 0) {
                    version.patch_ = this.patch_;
                    i_renamed |= 4;
                }
                if ((i2 & 8) != 0) {
                    i_renamed |= 8;
                }
                version.suffix_ = this.suffix_;
                version.bitField0_ = i_renamed;
                onBuilt();
                return version;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public com.google.protobuf.compiler.PluginProtos.Version.Builder mo23clone() {
                return (com.google.protobuf.compiler.PluginProtos.Version.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.Version.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.google.protobuf.compiler.PluginProtos.Version.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.Version.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.google.protobuf.compiler.PluginProtos.Version.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.Version.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.google.protobuf.compiler.PluginProtos.Version.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.Version.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.google.protobuf.compiler.PluginProtos.Version.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.Version.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.google.protobuf.compiler.PluginProtos.Version.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.Version.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.google.protobuf.compiler.PluginProtos.Version) {
                    return mergeFrom((com.google.protobuf.compiler.PluginProtos.Version) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.Version.Builder mergeFrom(com.google.protobuf.compiler.PluginProtos.Version version) {
                if (version == com.google.protobuf.compiler.PluginProtos.Version.getDefaultInstance()) {
                    return this;
                }
                if (version.hasMajor()) {
                    setMajor(version.getMajor());
                }
                if (version.hasMinor()) {
                    setMinor(version.getMinor());
                }
                if (version.hasPatch()) {
                    setPatch(version.getPatch());
                }
                if (version.hasSuffix()) {
                    this.bitField0_ |= 8;
                    this.suffix_ = version.suffix_;
                    onChanged();
                }
                mergeUnknownFields(version.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0021  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.google.protobuf.compiler.PluginProtos.Version.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos$Version> r1 = com.google.protobuf.compiler.PluginProtos.Version.PARSER     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    com.google.protobuf.compiler.PluginProtos$Version r3 = (com.google.protobuf.compiler.PluginProtos.Version) r3     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
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
                    com.google.protobuf.compiler.PluginProtos$Version r4 = (com.google.protobuf.compiler.PluginProtos.Version) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.compiler.PluginProtos.Version.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.compiler.PluginProtos$Version$Builder");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasMajor() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getMajor() {
                return this.major_;
            }

            public com.google.protobuf.compiler.PluginProtos.Version.Builder setMajor(int i_renamed) {
                this.bitField0_ |= 1;
                this.major_ = i_renamed;
                onChanged();
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.Version.Builder clearMajor() {
                this.bitField0_ &= -2;
                this.major_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasMinor() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getMinor() {
                return this.minor_;
            }

            public com.google.protobuf.compiler.PluginProtos.Version.Builder setMinor(int i_renamed) {
                this.bitField0_ |= 2;
                this.minor_ = i_renamed;
                onChanged();
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.Version.Builder clearMinor() {
                this.bitField0_ &= -3;
                this.minor_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasPatch() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getPatch() {
                return this.patch_;
            }

            public com.google.protobuf.compiler.PluginProtos.Version.Builder setPatch(int i_renamed) {
                this.bitField0_ |= 4;
                this.patch_ = i_renamed;
                onChanged();
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.Version.Builder clearPatch() {
                this.bitField0_ &= -5;
                this.patch_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasSuffix() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public java.lang.String getSuffix() {
                java.lang.Object obj = this.suffix_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.suffix_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public com.google.protobuf.ByteString getSuffixBytes() {
                java.lang.Object obj = this.suffix_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.suffix_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.google.protobuf.compiler.PluginProtos.Version.Builder setSuffix(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 8;
                this.suffix_ = str;
                onChanged();
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.Version.Builder clearSuffix() {
                this.bitField0_ &= -9;
                this.suffix_ = com.google.protobuf.compiler.PluginProtos.Version.getDefaultInstance().getSuffix();
                onChanged();
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.Version.Builder setSuffixBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 8;
                this.suffix_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.google.protobuf.compiler.PluginProtos.Version.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.google.protobuf.compiler.PluginProtos.Version.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.google.protobuf.compiler.PluginProtos.Version.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.google.protobuf.compiler.PluginProtos.Version.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.google.protobuf.compiler.PluginProtos.Version getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos.Version> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos.Version> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.compiler.PluginProtos.Version getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CodeGeneratorRequest extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder {
        public static final int COMPILER_VERSION_FIELD_NUMBER = 3;
        public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
        public static final int PARAMETER_FIELD_NUMBER = 2;
        public static final int PROTO_FILE_FIELD_NUMBER = 15;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private com.google.protobuf.compiler.PluginProtos.Version compilerVersion_;
        private com.google.protobuf.LazyStringList fileToGenerate_;
        private byte memoizedIsInitialized;
        private volatile java.lang.Object parameter_;
        private java.util.List<com.google.protobuf.DescriptorProtos.FileDescriptorProto> protoFile_;
        private static final com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest DEFAULT_INSTANCE = new com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest();

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest>() { // from class: com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.1
            @Override // com.google.protobuf.Parser
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest(codedInputStream, extensionRegistryLite);
            }
        };

        private CodeGeneratorRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CodeGeneratorRequest() {
            this.memoizedIsInitialized = (byte) -1;
            this.fileToGenerate_ = com.google.protobuf.LazyStringArrayList.EMPTY;
            this.parameter_ = "";
            this.protoFile_ = java.util.Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private CodeGeneratorRequest(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            boolean z_renamed = false;
            int i_renamed = 0;
            while (!z_renamed) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                com.google.protobuf.ByteString bytes = codedInputStream.readBytes();
                                if ((i_renamed & 1) == 0) {
                                    this.fileToGenerate_ = new com.google.protobuf.LazyStringArrayList();
                                    i_renamed |= 1;
                                }
                                this.fileToGenerate_.add(bytes);
                            } else if (tag == 18) {
                                com.google.protobuf.ByteString bytes2 = codedInputStream.readBytes();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.parameter_ = bytes2;
                            } else if (tag == 26) {
                                com.google.protobuf.compiler.PluginProtos.Version.Builder builder = (this.bitField0_ & 2) != 0 ? this.compilerVersion_.toBuilder() : null;
                                this.compilerVersion_ = (com.google.protobuf.compiler.PluginProtos.Version) codedInputStream.readMessage(com.google.protobuf.compiler.PluginProtos.Version.PARSER, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.compilerVersion_);
                                    this.compilerVersion_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (tag == 122) {
                                if ((i_renamed & 4) == 0) {
                                    this.protoFile_ = new java.util.ArrayList();
                                    i_renamed |= 4;
                                }
                                this.protoFile_.add(codedInputStream.readMessage(com.google.protobuf.DescriptorProtos.FileDescriptorProto.PARSER, extensionRegistryLite));
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
                    if ((i_renamed & 1) != 0) {
                        this.fileToGenerate_ = this.fileToGenerate_.getUnmodifiableView();
                    }
                    if ((i_renamed & 4) != 0) {
                        this.protoFile_ = java.util.Collections.unmodifiableList(this.protoFile_);
                    }
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.class, com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder.class);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public com.google.protobuf.ProtocolStringList getFileToGenerateList() {
            return this.fileToGenerate_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getFileToGenerateCount() {
            return this.fileToGenerate_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public java.lang.String getFileToGenerate(int i_renamed) {
            return (java.lang.String) this.fileToGenerate_.get(i_renamed);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public com.google.protobuf.ByteString getFileToGenerateBytes(int i_renamed) {
            return this.fileToGenerate_.getByteString(i_renamed);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public boolean hasParameter() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public java.lang.String getParameter() {
            java.lang.Object obj = this.parameter_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.parameter_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public com.google.protobuf.ByteString getParameterBytes() {
            java.lang.Object obj = this.parameter_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.parameter_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public java.util.List<com.google.protobuf.DescriptorProtos.FileDescriptorProto> getProtoFileList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public java.util.List<? extends com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getProtoFileCount() {
            return this.protoFile_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public com.google.protobuf.DescriptorProtos.FileDescriptorProto getProtoFile(int i_renamed) {
            return this.protoFile_.get(i_renamed);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int i_renamed) {
            return this.protoFile_.get(i_renamed);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public boolean hasCompilerVersion() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public com.google.protobuf.compiler.PluginProtos.Version getCompilerVersion() {
            com.google.protobuf.compiler.PluginProtos.Version version = this.compilerVersion_;
            return version == null ? com.google.protobuf.compiler.PluginProtos.Version.getDefaultInstance() : version;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public com.google.protobuf.compiler.PluginProtos.VersionOrBuilder getCompilerVersionOrBuilder() {
            com.google.protobuf.compiler.PluginProtos.Version version = this.compilerVersion_;
            return version == null ? com.google.protobuf.compiler.PluginProtos.Version.getDefaultInstance() : version;
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
            for (int i_renamed = 0; i_renamed < getProtoFileCount(); i_renamed++) {
                if (!getProtoFile(i_renamed).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            for (int i_renamed = 0; i_renamed < this.fileToGenerate_.size(); i_renamed++) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 1, this.fileToGenerate_.getRaw(i_renamed));
            }
            if ((this.bitField0_ & 1) != 0) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 2, this.parameter_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeMessage(3, getCompilerVersion());
            }
            for (int i2 = 0; i2 < this.protoFile_.size(); i2++) {
                codedOutputStream.writeMessage(15, this.protoFile_.get(i2));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            int iComputeStringSizeNoTag = 0;
            for (int i2 = 0; i2 < this.fileToGenerate_.size(); i2++) {
                iComputeStringSizeNoTag += computeStringSizeNoTag(this.fileToGenerate_.getRaw(i2));
            }
            int size = iComputeStringSizeNoTag + 0 + (getFileToGenerateList().size() * 1);
            if ((this.bitField0_ & 1) != 0) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, this.parameter_);
            }
            if ((this.bitField0_ & 2) != 0) {
                size += com.google.protobuf.CodedOutputStream.computeMessageSize(3, getCompilerVersion());
            }
            for (int i3 = 0; i3 < this.protoFile_.size(); i3++) {
                size += com.google.protobuf.CodedOutputStream.computeMessageSize(15, this.protoFile_.get(i3));
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
            if (!(obj instanceof com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest)) {
                return super.equals(obj);
            }
            com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest codeGeneratorRequest = (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest) obj;
            if (!getFileToGenerateList().equals(codeGeneratorRequest.getFileToGenerateList()) || hasParameter() != codeGeneratorRequest.hasParameter()) {
                return false;
            }
            if ((!hasParameter() || getParameter().equals(codeGeneratorRequest.getParameter())) && getProtoFileList().equals(codeGeneratorRequest.getProtoFileList()) && hasCompilerVersion() == codeGeneratorRequest.hasCompilerVersion()) {
                return (!hasCompilerVersion() || getCompilerVersion().equals(codeGeneratorRequest.getCompilerVersion())) && this.unknownFields.equals(codeGeneratorRequest.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptor().hashCode();
            if (getFileToGenerateCount() > 0) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getFileToGenerateList().hashCode();
            }
            if (hasParameter()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getParameter().hashCode();
            }
            if (getProtoFileCount() > 0) {
                iHashCode = (((iHashCode * 37) + 15) * 53) + getProtoFileList().hashCode();
            }
            if (hasCompilerVersion()) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + getCompilerVersion().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder newBuilder(com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest codeGeneratorRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(codeGeneratorRequest);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder() : new com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder> implements com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder {
            private int bitField0_;
            private com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.Version, com.google.protobuf.compiler.PluginProtos.Version.Builder, com.google.protobuf.compiler.PluginProtos.VersionOrBuilder> compilerVersionBuilder_;
            private com.google.protobuf.compiler.PluginProtos.Version compilerVersion_;
            private com.google.protobuf.LazyStringList fileToGenerate_;
            private java.lang.Object parameter_;
            private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> protoFileBuilder_;
            private java.util.List<com.google.protobuf.DescriptorProtos.FileDescriptorProto> protoFile_;

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.class, com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder.class);
            }

            private Builder() {
                this.fileToGenerate_ = com.google.protobuf.LazyStringArrayList.EMPTY;
                this.parameter_ = "";
                this.protoFile_ = java.util.Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.fileToGenerate_ = com.google.protobuf.LazyStringArrayList.EMPTY;
                this.parameter_ = "";
                this.protoFile_ = java.util.Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.alwaysUseFieldBuilders) {
                    getProtoFileFieldBuilder();
                    getCompilerVersionFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder clear() {
                super.clear();
                this.fileToGenerate_ = com.google.protobuf.LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                this.parameter_ = "";
                this.bitField0_ &= -3;
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.protoFile_ = java.util.Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.Version, com.google.protobuf.compiler.PluginProtos.Version.Builder, com.google.protobuf.compiler.PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.compilerVersion_ = null;
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -9;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest getDefaultInstanceForType() {
                return com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest build() {
                com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest codeGeneratorRequestBuildPartial = buildPartial();
                if (codeGeneratorRequestBuildPartial.isInitialized()) {
                    return codeGeneratorRequestBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) codeGeneratorRequestBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest buildPartial() {
                com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest codeGeneratorRequest = new com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest(this);
                int i_renamed = this.bitField0_;
                if ((i_renamed & 1) != 0) {
                    this.fileToGenerate_ = this.fileToGenerate_.getUnmodifiableView();
                    this.bitField0_ &= -2;
                }
                codeGeneratorRequest.fileToGenerate_ = this.fileToGenerate_;
                int i2 = (i_renamed & 2) != 0 ? 1 : 0;
                codeGeneratorRequest.parameter_ = this.parameter_;
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    codeGeneratorRequest.protoFile_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 4) != 0) {
                        this.protoFile_ = java.util.Collections.unmodifiableList(this.protoFile_);
                        this.bitField0_ &= -5;
                    }
                    codeGeneratorRequest.protoFile_ = this.protoFile_;
                }
                if ((i_renamed & 8) != 0) {
                    com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.Version, com.google.protobuf.compiler.PluginProtos.Version.Builder, com.google.protobuf.compiler.PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        codeGeneratorRequest.compilerVersion_ = this.compilerVersion_;
                    } else {
                        codeGeneratorRequest.compilerVersion_ = (com.google.protobuf.compiler.PluginProtos.Version) singleFieldBuilderV3.build();
                    }
                    i2 |= 2;
                }
                codeGeneratorRequest.bitField0_ = i2;
                onBuilt();
                return codeGeneratorRequest;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder mo23clone() {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest) {
                    return mergeFrom((com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder mergeFrom(com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest codeGeneratorRequest) {
                if (codeGeneratorRequest == com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.getDefaultInstance()) {
                    return this;
                }
                if (!codeGeneratorRequest.fileToGenerate_.isEmpty()) {
                    if (this.fileToGenerate_.isEmpty()) {
                        this.fileToGenerate_ = codeGeneratorRequest.fileToGenerate_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFileToGenerateIsMutable();
                        this.fileToGenerate_.addAll(codeGeneratorRequest.fileToGenerate_);
                    }
                    onChanged();
                }
                if (codeGeneratorRequest.hasParameter()) {
                    this.bitField0_ |= 2;
                    this.parameter_ = codeGeneratorRequest.parameter_;
                    onChanged();
                }
                if (this.protoFileBuilder_ == null) {
                    if (!codeGeneratorRequest.protoFile_.isEmpty()) {
                        if (this.protoFile_.isEmpty()) {
                            this.protoFile_ = codeGeneratorRequest.protoFile_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureProtoFileIsMutable();
                            this.protoFile_.addAll(codeGeneratorRequest.protoFile_);
                        }
                        onChanged();
                    }
                } else if (!codeGeneratorRequest.protoFile_.isEmpty()) {
                    if (!this.protoFileBuilder_.isEmpty()) {
                        this.protoFileBuilder_.addAllMessages(codeGeneratorRequest.protoFile_);
                    } else {
                        this.protoFileBuilder_.dispose();
                        this.protoFileBuilder_ = null;
                        this.protoFile_ = codeGeneratorRequest.protoFile_;
                        this.bitField0_ &= -5;
                        this.protoFileBuilder_ = com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.alwaysUseFieldBuilders ? getProtoFileFieldBuilder() : null;
                    }
                }
                if (codeGeneratorRequest.hasCompilerVersion()) {
                    mergeCompilerVersion(codeGeneratorRequest.getCompilerVersion());
                }
                mergeUnknownFields(codeGeneratorRequest.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i_renamed = 0; i_renamed < getProtoFileCount(); i_renamed++) {
                    if (!getProtoFile(i_renamed).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0021  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequest> r1 = com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.PARSER     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequest r3 = (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest) r3     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
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
                    com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequest r4 = (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequest$Builder");
            }

            private void ensureFileToGenerateIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.fileToGenerate_ = new com.google.protobuf.LazyStringArrayList(this.fileToGenerate_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public com.google.protobuf.ProtocolStringList getFileToGenerateList() {
                return this.fileToGenerate_.getUnmodifiableView();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getFileToGenerateCount() {
                return this.fileToGenerate_.size();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public java.lang.String getFileToGenerate(int i_renamed) {
                return (java.lang.String) this.fileToGenerate_.get(i_renamed);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public com.google.protobuf.ByteString getFileToGenerateBytes(int i_renamed) {
                return this.fileToGenerate_.getByteString(i_renamed);
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder setFileToGenerate(int i_renamed, java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.set(i_renamed, str);
                onChanged();
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder addFileToGenerate(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(str);
                onChanged();
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder addAllFileToGenerate(java.lang.Iterable<java.lang.String> iterable) {
                ensureFileToGenerateIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) this.fileToGenerate_);
                onChanged();
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder clearFileToGenerate() {
                this.fileToGenerate_ = com.google.protobuf.LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder addFileToGenerateBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(byteString);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public boolean hasParameter() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public java.lang.String getParameter() {
                java.lang.Object obj = this.parameter_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.parameter_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public com.google.protobuf.ByteString getParameterBytes() {
                java.lang.Object obj = this.parameter_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.parameter_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder setParameter(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 2;
                this.parameter_ = str;
                onChanged();
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder clearParameter() {
                this.bitField0_ &= -3;
                this.parameter_ = com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.getDefaultInstance().getParameter();
                onChanged();
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder setParameterBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 2;
                this.parameter_ = byteString;
                onChanged();
                return this;
            }

            private void ensureProtoFileIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.protoFile_ = new java.util.ArrayList(this.protoFile_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public java.util.List<com.google.protobuf.DescriptorProtos.FileDescriptorProto> getProtoFileList() {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return java.util.Collections.unmodifiableList(this.protoFile_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getProtoFileCount() {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.protoFile_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public com.google.protobuf.DescriptorProtos.FileDescriptorProto getProtoFile(int i_renamed) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.protoFile_.get(i_renamed);
                }
                return (com.google.protobuf.DescriptorProtos.FileDescriptorProto) repeatedFieldBuilderV3.getMessage(i_renamed);
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder setProtoFile(int i_renamed, com.google.protobuf.DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i_renamed, fileDescriptorProto);
                } else {
                    if (fileDescriptorProto == null) {
                        throw new java.lang.NullPointerException();
                    }
                    ensureProtoFileIsMutable();
                    this.protoFile_.set(i_renamed, fileDescriptorProto);
                    onChanged();
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder setProtoFile(int i_renamed, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder builder) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.set(i_renamed, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i_renamed, builder.build());
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder addProtoFile(com.google.protobuf.DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(fileDescriptorProto);
                } else {
                    if (fileDescriptorProto == null) {
                        throw new java.lang.NullPointerException();
                    }
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(fileDescriptorProto);
                    onChanged();
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder addProtoFile(int i_renamed, com.google.protobuf.DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i_renamed, fileDescriptorProto);
                } else {
                    if (fileDescriptorProto == null) {
                        throw new java.lang.NullPointerException();
                    }
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(i_renamed, fileDescriptorProto);
                    onChanged();
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder addProtoFile(com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder builder) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder addProtoFile(int i_renamed, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder builder) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(i_renamed, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i_renamed, builder.build());
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder addAllProtoFile(java.lang.Iterable<? extends com.google.protobuf.DescriptorProtos.FileDescriptorProto> iterable) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) this.protoFile_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder clearProtoFile() {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.protoFile_ = java.util.Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder removeProtoFile(int i_renamed) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.remove(i_renamed);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i_renamed);
                }
                return this;
            }

            public com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder getProtoFileBuilder(int i_renamed) {
                return (com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder) getProtoFileFieldBuilder().getBuilder(i_renamed);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int i_renamed) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.protoFile_.get(i_renamed);
                }
                return (com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i_renamed);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public java.util.List<? extends com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return java.util.Collections.unmodifiableList(this.protoFile_);
            }

            public com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder() {
                return (com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder) getProtoFileFieldBuilder().addBuilder(com.google.protobuf.DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder(int i_renamed) {
                return (com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder) getProtoFileFieldBuilder().addBuilder(i_renamed, com.google.protobuf.DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public java.util.List<com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder> getProtoFileBuilderList() {
                return getProtoFileFieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.DescriptorProtos.FileDescriptorProto, com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder, com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileFieldBuilder() {
                if (this.protoFileBuilder_ == null) {
                    this.protoFileBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<>(this.protoFile_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.protoFile_ = null;
                }
                return this.protoFileBuilder_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public boolean hasCompilerVersion() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public com.google.protobuf.compiler.PluginProtos.Version getCompilerVersion() {
                com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.Version, com.google.protobuf.compiler.PluginProtos.Version.Builder, com.google.protobuf.compiler.PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    com.google.protobuf.compiler.PluginProtos.Version version = this.compilerVersion_;
                    return version == null ? com.google.protobuf.compiler.PluginProtos.Version.getDefaultInstance() : version;
                }
                return (com.google.protobuf.compiler.PluginProtos.Version) singleFieldBuilderV3.getMessage();
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder setCompilerVersion(com.google.protobuf.compiler.PluginProtos.Version version) {
                com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.Version, com.google.protobuf.compiler.PluginProtos.Version.Builder, com.google.protobuf.compiler.PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(version);
                } else {
                    if (version == null) {
                        throw new java.lang.NullPointerException();
                    }
                    this.compilerVersion_ = version;
                    onChanged();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder setCompilerVersion(com.google.protobuf.compiler.PluginProtos.Version.Builder builder) {
                com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.Version, com.google.protobuf.compiler.PluginProtos.Version.Builder, com.google.protobuf.compiler.PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.compilerVersion_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 8;
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder mergeCompilerVersion(com.google.protobuf.compiler.PluginProtos.Version version) {
                com.google.protobuf.compiler.PluginProtos.Version version2;
                com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.Version, com.google.protobuf.compiler.PluginProtos.Version.Builder, com.google.protobuf.compiler.PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 8) != 0 && (version2 = this.compilerVersion_) != null && version2 != com.google.protobuf.compiler.PluginProtos.Version.getDefaultInstance()) {
                        this.compilerVersion_ = com.google.protobuf.compiler.PluginProtos.Version.newBuilder(this.compilerVersion_).mergeFrom(version).buildPartial();
                    } else {
                        this.compilerVersion_ = version;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(version);
                }
                this.bitField0_ |= 8;
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder clearCompilerVersion() {
                com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.Version, com.google.protobuf.compiler.PluginProtos.Version.Builder, com.google.protobuf.compiler.PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.compilerVersion_ = null;
                    onChanged();
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -9;
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.Version.Builder getCompilerVersionBuilder() {
                this.bitField0_ |= 8;
                onChanged();
                return (com.google.protobuf.compiler.PluginProtos.Version.Builder) getCompilerVersionFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public com.google.protobuf.compiler.PluginProtos.VersionOrBuilder getCompilerVersionOrBuilder() {
                com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.Version, com.google.protobuf.compiler.PluginProtos.Version.Builder, com.google.protobuf.compiler.PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (com.google.protobuf.compiler.PluginProtos.VersionOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                com.google.protobuf.compiler.PluginProtos.Version version = this.compilerVersion_;
                return version == null ? com.google.protobuf.compiler.PluginProtos.Version.getDefaultInstance() : version;
            }

            private com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.Version, com.google.protobuf.compiler.PluginProtos.Version.Builder, com.google.protobuf.compiler.PluginProtos.VersionOrBuilder> getCompilerVersionFieldBuilder() {
                if (this.compilerVersionBuilder_ == null) {
                    this.compilerVersionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<>(getCompilerVersion(), getParentForChildren(), isClean());
                    this.compilerVersion_ = null;
                }
                return this.compilerVersionBuilder_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class CodeGeneratorResponse extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int FILE_FIELD_NUMBER = 15;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile java.lang.Object error_;
        private java.util.List<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File> file_;
        private byte memoizedIsInitialized;
        private static final com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse DEFAULT_INSTANCE = new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse();

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse>() { // from class: com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.1
            @Override // com.google.protobuf.Parser
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse(codedInputStream, extensionRegistryLite);
            }
        };

        public interface FileOrBuilder extends com.google.protobuf.MessageOrBuilder {
            java.lang.String getContent();

            com.google.protobuf.ByteString getContentBytes();

            java.lang.String getInsertionPoint();

            com.google.protobuf.ByteString getInsertionPointBytes();

            java.lang.String getName();

            com.google.protobuf.ByteString getNameBytes();

            boolean hasContent();

            boolean hasInsertionPoint();

            boolean hasName();
        }

        private CodeGeneratorResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private CodeGeneratorResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.error_ = "";
            this.file_ = java.util.Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private CodeGeneratorResponse(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
            boolean z_renamed = false;
            int i_renamed = 0;
            while (!z_renamed) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                com.google.protobuf.ByteString bytes = codedInputStream.readBytes();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.error_ = bytes;
                            } else if (tag == 122) {
                                if ((i_renamed & 2) == 0) {
                                    this.file_ = new java.util.ArrayList();
                                    i_renamed |= 2;
                                }
                                this.file_.add(codedInputStream.readMessage(com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.PARSER, extensionRegistryLite));
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
                    if ((i_renamed & 2) != 0) {
                        this.file_ = java.util.Collections.unmodifiableList(this.file_);
                    }
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.class, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder.class);
        }

        public static final class File extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder {
            public static final int CONTENT_FIELD_NUMBER = 15;
            public static final int INSERTION_POINT_FIELD_NUMBER = 2;
            public static final int NAME_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private volatile java.lang.Object content_;
            private volatile java.lang.Object insertionPoint_;
            private byte memoizedIsInitialized;
            private volatile java.lang.Object name_;
            private static final com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File DEFAULT_INSTANCE = new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File();

            @java.lang.Deprecated
            public static final com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File>() { // from class: com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.1
                @Override // com.google.protobuf.Parser
                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                    return new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File(codedInputStream, extensionRegistryLite);
                }
            };

            private File(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private File() {
                this.memoizedIsInitialized = (byte) -1;
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private File(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
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
                                if (tag == 10) {
                                    com.google.protobuf.ByteString bytes = codedInputStream.readBytes();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.name_ = bytes;
                                } else if (tag == 18) {
                                    com.google.protobuf.ByteString bytes2 = codedInputStream.readBytes();
                                    this.bitField0_ |= 2;
                                    this.insertionPoint_ = bytes2;
                                } else if (tag == 122) {
                                    com.google.protobuf.ByteString bytes3 = codedInputStream.readBytes();
                                    this.bitField0_ |= 4;
                                    this.content_ = bytes3;
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
                return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.class, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder.class);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public java.lang.String getName() {
                java.lang.Object obj = this.name_;
                if (obj instanceof java.lang.String) {
                    return (java.lang.String) obj;
                }
                com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                java.lang.String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.name_ = stringUtf8;
                }
                return stringUtf8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public com.google.protobuf.ByteString getNameBytes() {
                java.lang.Object obj = this.name_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.name_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasInsertionPoint() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public java.lang.String getInsertionPoint() {
                java.lang.Object obj = this.insertionPoint_;
                if (obj instanceof java.lang.String) {
                    return (java.lang.String) obj;
                }
                com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                java.lang.String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.insertionPoint_ = stringUtf8;
                }
                return stringUtf8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public com.google.protobuf.ByteString getInsertionPointBytes() {
                java.lang.Object obj = this.insertionPoint_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.insertionPoint_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasContent() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public java.lang.String getContent() {
                java.lang.Object obj = this.content_;
                if (obj instanceof java.lang.String) {
                    return (java.lang.String) obj;
                }
                com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                java.lang.String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.content_ = stringUtf8;
                }
                return stringUtf8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public com.google.protobuf.ByteString getContentBytes() {
                java.lang.Object obj = this.content_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.content_ = byteStringCopyFromUtf8;
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
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
                if ((this.bitField0_ & 1) != 0) {
                    com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 2, this.insertionPoint_);
                }
                if ((this.bitField0_ & 4) != 0) {
                    com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 15, this.content_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i_renamed = this.memoizedSize;
                if (i_renamed != -1) {
                    return i_renamed;
                }
                int iComputeStringSize = (this.bitField0_ & 1) != 0 ? 0 + com.google.protobuf.GeneratedMessageV3.computeStringSize(1, this.name_) : 0;
                if ((this.bitField0_ & 2) != 0) {
                    iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, this.insertionPoint_);
                }
                if ((this.bitField0_ & 4) != 0) {
                    iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(15, this.content_);
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
                if (!(obj instanceof com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File)) {
                    return super.equals(obj);
                }
                com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File file = (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File) obj;
                if (hasName() != file.hasName()) {
                    return false;
                }
                if ((hasName() && !getName().equals(file.getName())) || hasInsertionPoint() != file.hasInsertionPoint()) {
                    return false;
                }
                if ((!hasInsertionPoint() || getInsertionPoint().equals(file.getInsertionPoint())) && hasContent() == file.hasContent()) {
                    return (!hasContent() || getContent().equals(file.getContent())) && this.unknownFields.equals(file.unknownFields);
                }
                return false;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int iHashCode = 779 + getDescriptor().hashCode();
                if (hasName()) {
                    iHashCode = (((iHashCode * 37) + 1) * 53) + getName().hashCode();
                }
                if (hasInsertionPoint()) {
                    iHashCode = (((iHashCode * 37) + 2) * 53) + getInsertionPoint().hashCode();
                }
                if (hasContent()) {
                    iHashCode = (((iHashCode * 37) + 15) * 53) + getContent().hashCode();
                }
                int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = iHashCode2;
                return iHashCode2;
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder newBuilderForType() {
                return newBuilder();
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder newBuilder(com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File file) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(file);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder toBuilder() {
                return this == DEFAULT_INSTANCE ? new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder() : new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder().mergeFrom(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                return new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder(builderParent);
            }

            public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder> implements com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder {
                private int bitField0_;
                private java.lang.Object content_;
                private java.lang.Object insertionPoint_;
                private java.lang.Object name_;

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                    return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.class, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder.class);
                }

                private Builder() {
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.alwaysUseFieldBuilders;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder clear() {
                    super.clear();
                    this.name_ = "";
                    this.bitField0_ &= -2;
                    this.insertionPoint_ = "";
                    this.bitField0_ &= -3;
                    this.content_ = "";
                    this.bitField0_ &= -5;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                    return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File getDefaultInstanceForType() {
                    return com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File build() {
                    com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File fileBuildPartial = buildPartial();
                    if (fileBuildPartial.isInitialized()) {
                        return fileBuildPartial;
                    }
                    throw newUninitializedMessageException((com.google.protobuf.Message) fileBuildPartial);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File buildPartial() {
                    com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File file = new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File(this);
                    int i_renamed = this.bitField0_;
                    int i2 = (i_renamed & 1) != 0 ? 1 : 0;
                    file.name_ = this.name_;
                    if ((i_renamed & 2) != 0) {
                        i2 |= 2;
                    }
                    file.insertionPoint_ = this.insertionPoint_;
                    if ((i_renamed & 4) != 0) {
                        i2 |= 4;
                    }
                    file.content_ = this.content_;
                    file.bitField0_ = i2;
                    onBuilt();
                    return file;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder mo23clone() {
                    return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder) super.mo23clone();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                    return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder) super.setField(fieldDescriptor, obj);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                    return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder) super.clearField(fieldDescriptor);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                    return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder) super.clearOneof(oneofDescriptor);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                    return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                    return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder) super.addRepeatedField(fieldDescriptor, obj);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder mergeFrom(com.google.protobuf.Message message) {
                    if (message instanceof com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File) {
                        return mergeFrom((com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder mergeFrom(com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File file) {
                    if (file == com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.getDefaultInstance()) {
                        return this;
                    }
                    if (file.hasName()) {
                        this.bitField0_ |= 1;
                        this.name_ = file.name_;
                        onChanged();
                    }
                    if (file.hasInsertionPoint()) {
                        this.bitField0_ |= 2;
                        this.insertionPoint_ = file.insertionPoint_;
                        onChanged();
                    }
                    if (file.hasContent()) {
                        this.bitField0_ |= 4;
                        this.content_ = file.content_;
                        onChanged();
                    }
                    mergeUnknownFields(file.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0021  */
                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                    /*
                        r2 = this;
                        r0 = 0
                        com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File> r1 = com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.PARSER     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                        com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File r3 = (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File) r3     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
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
                        com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File r4 = (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File$Builder");
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasName() {
                    return (this.bitField0_ & 1) != 0;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public java.lang.String getName() {
                    java.lang.Object obj = this.name_;
                    if (!(obj instanceof java.lang.String)) {
                        com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                        java.lang.String stringUtf8 = byteString.toStringUtf8();
                        if (byteString.isValidUtf8()) {
                            this.name_ = stringUtf8;
                        }
                        return stringUtf8;
                    }
                    return (java.lang.String) obj;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public com.google.protobuf.ByteString getNameBytes() {
                    java.lang.Object obj = this.name_;
                    if (obj instanceof java.lang.String) {
                        com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                        this.name_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (com.google.protobuf.ByteString) obj;
                }

                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder setName(java.lang.String str) {
                    if (str == null) {
                        throw new java.lang.NullPointerException();
                    }
                    this.bitField0_ |= 1;
                    this.name_ = str;
                    onChanged();
                    return this;
                }

                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder clearName() {
                    this.bitField0_ &= -2;
                    this.name_ = com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getName();
                    onChanged();
                    return this;
                }

                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder setNameBytes(com.google.protobuf.ByteString byteString) {
                    if (byteString == null) {
                        throw new java.lang.NullPointerException();
                    }
                    this.bitField0_ |= 1;
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasInsertionPoint() {
                    return (this.bitField0_ & 2) != 0;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public java.lang.String getInsertionPoint() {
                    java.lang.Object obj = this.insertionPoint_;
                    if (!(obj instanceof java.lang.String)) {
                        com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                        java.lang.String stringUtf8 = byteString.toStringUtf8();
                        if (byteString.isValidUtf8()) {
                            this.insertionPoint_ = stringUtf8;
                        }
                        return stringUtf8;
                    }
                    return (java.lang.String) obj;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public com.google.protobuf.ByteString getInsertionPointBytes() {
                    java.lang.Object obj = this.insertionPoint_;
                    if (obj instanceof java.lang.String) {
                        com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                        this.insertionPoint_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (com.google.protobuf.ByteString) obj;
                }

                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder setInsertionPoint(java.lang.String str) {
                    if (str == null) {
                        throw new java.lang.NullPointerException();
                    }
                    this.bitField0_ |= 2;
                    this.insertionPoint_ = str;
                    onChanged();
                    return this;
                }

                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder clearInsertionPoint() {
                    this.bitField0_ &= -3;
                    this.insertionPoint_ = com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getInsertionPoint();
                    onChanged();
                    return this;
                }

                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder setInsertionPointBytes(com.google.protobuf.ByteString byteString) {
                    if (byteString == null) {
                        throw new java.lang.NullPointerException();
                    }
                    this.bitField0_ |= 2;
                    this.insertionPoint_ = byteString;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasContent() {
                    return (this.bitField0_ & 4) != 0;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public java.lang.String getContent() {
                    java.lang.Object obj = this.content_;
                    if (!(obj instanceof java.lang.String)) {
                        com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                        java.lang.String stringUtf8 = byteString.toStringUtf8();
                        if (byteString.isValidUtf8()) {
                            this.content_ = stringUtf8;
                        }
                        return stringUtf8;
                    }
                    return (java.lang.String) obj;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public com.google.protobuf.ByteString getContentBytes() {
                    java.lang.Object obj = this.content_;
                    if (obj instanceof java.lang.String) {
                        com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                        this.content_ = byteStringCopyFromUtf8;
                        return byteStringCopyFromUtf8;
                    }
                    return (com.google.protobuf.ByteString) obj;
                }

                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder setContent(java.lang.String str) {
                    if (str == null) {
                        throw new java.lang.NullPointerException();
                    }
                    this.bitField0_ |= 4;
                    this.content_ = str;
                    onChanged();
                    return this;
                }

                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder clearContent() {
                    this.bitField0_ &= -5;
                    this.content_ = com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getContent();
                    onChanged();
                    return this;
                }

                public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder setContentBytes(com.google.protobuf.ByteString byteString) {
                    if (byteString == null) {
                        throw new java.lang.NullPointerException();
                    }
                    this.bitField0_ |= 4;
                    this.content_ = byteString;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public final com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                    return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder) super.setUnknownFields(unknownFieldSet);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public final com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                    return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder) super.mergeUnknownFields(unknownFieldSet);
                }
            }

            public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasError() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public java.lang.String getError() {
            java.lang.Object obj = this.error_;
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
            java.lang.String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.error_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public com.google.protobuf.ByteString getErrorBytes() {
            java.lang.Object obj = this.error_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.error_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public java.util.List<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File> getFileList() {
            return this.file_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public java.util.List<? extends com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public int getFileCount() {
            return this.file_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File getFile(int i_renamed) {
            return this.file_.get(i_renamed);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int i_renamed) {
            return this.file_.get(i_renamed);
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
            if ((this.bitField0_ & 1) != 0) {
                com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 1, this.error_);
            }
            for (int i_renamed = 0; i_renamed < this.file_.size(); i_renamed++) {
                codedOutputStream.writeMessage(15, this.file_.get(i_renamed));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i_renamed = this.memoizedSize;
            if (i_renamed != -1) {
                return i_renamed;
            }
            int iComputeStringSize = (this.bitField0_ & 1) != 0 ? com.google.protobuf.GeneratedMessageV3.computeStringSize(1, this.error_) + 0 : 0;
            for (int i2 = 0; i2 < this.file_.size(); i2++) {
                iComputeStringSize += com.google.protobuf.CodedOutputStream.computeMessageSize(15, this.file_.get(i2));
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
            if (!(obj instanceof com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse)) {
                return super.equals(obj);
            }
            com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse codeGeneratorResponse = (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse) obj;
            if (hasError() != codeGeneratorResponse.hasError()) {
                return false;
            }
            return (!hasError() || getError().equals(codeGeneratorResponse.getError())) && getFileList().equals(codeGeneratorResponse.getFileList()) && this.unknownFields.equals(codeGeneratorResponse.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptor().hashCode();
            if (hasError()) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getError().hashCode();
            }
            if (getFileCount() > 0) {
                iHashCode = (((iHashCode * 37) + 15) * 53) + getFileList().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder newBuilderForType() {
            return newBuilder();
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder newBuilder(com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse codeGeneratorResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(codeGeneratorResponse);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder() : new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            return new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder(builderParent);
        }

        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder> implements com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder {
            private int bitField0_;
            private java.lang.Object error_;
            private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> fileBuilder_;
            private java.util.List<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File> file_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.class, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder.class);
            }

            private Builder() {
                this.error_ = "";
                this.file_ = java.util.Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.error_ = "";
                this.file_ = java.util.Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.alwaysUseFieldBuilders) {
                    getFileFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder clear() {
                super.clear();
                this.error_ = "";
                this.bitField0_ &= -2;
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.file_ = java.util.Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.google.protobuf.compiler.PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse getDefaultInstanceForType() {
                return com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse build() {
                com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse codeGeneratorResponseBuildPartial = buildPartial();
                if (codeGeneratorResponseBuildPartial.isInitialized()) {
                    return codeGeneratorResponseBuildPartial;
                }
                throw newUninitializedMessageException((com.google.protobuf.Message) codeGeneratorResponseBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse buildPartial() {
                com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse codeGeneratorResponse = new com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse(this);
                int i_renamed = (this.bitField0_ & 1) == 0 ? 0 : 1;
                codeGeneratorResponse.error_ = this.error_;
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    codeGeneratorResponse.file_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 2) != 0) {
                        this.file_ = java.util.Collections.unmodifiableList(this.file_);
                        this.bitField0_ &= -3;
                    }
                    codeGeneratorResponse.file_ = this.file_;
                }
                codeGeneratorResponse.bitField0_ = i_renamed;
                onBuilt();
                return codeGeneratorResponse;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder mo23clone() {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder) super.mo23clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder mergeFrom(com.google.protobuf.Message message) {
                if (message instanceof com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse) {
                    return mergeFrom((com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder mergeFrom(com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse codeGeneratorResponse) {
                if (codeGeneratorResponse == com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.getDefaultInstance()) {
                    return this;
                }
                if (codeGeneratorResponse.hasError()) {
                    this.bitField0_ |= 1;
                    this.error_ = codeGeneratorResponse.error_;
                    onChanged();
                }
                if (this.fileBuilder_ == null) {
                    if (!codeGeneratorResponse.file_.isEmpty()) {
                        if (this.file_.isEmpty()) {
                            this.file_ = codeGeneratorResponse.file_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureFileIsMutable();
                            this.file_.addAll(codeGeneratorResponse.file_);
                        }
                        onChanged();
                    }
                } else if (!codeGeneratorResponse.file_.isEmpty()) {
                    if (!this.fileBuilder_.isEmpty()) {
                        this.fileBuilder_.addAllMessages(codeGeneratorResponse.file_);
                    } else {
                        this.fileBuilder_.dispose();
                        this.fileBuilder_ = null;
                        this.file_ = codeGeneratorResponse.file_;
                        this.bitField0_ &= -3;
                        this.fileBuilder_ = com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.alwaysUseFieldBuilders ? getFileFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(codeGeneratorResponse.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0021  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse> r1 = com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.PARSER     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse r3 = (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse) r3     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
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
                    com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse r4 = (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$Builder");
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasError() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public java.lang.String getError() {
                java.lang.Object obj = this.error_;
                if (!(obj instanceof java.lang.String)) {
                    com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
                    java.lang.String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.error_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (java.lang.String) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public com.google.protobuf.ByteString getErrorBytes() {
                java.lang.Object obj = this.error_;
                if (obj instanceof java.lang.String) {
                    com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                    this.error_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (com.google.protobuf.ByteString) obj;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder setError(java.lang.String str) {
                if (str == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 1;
                this.error_ = str;
                onChanged();
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder clearError() {
                this.bitField0_ &= -2;
                this.error_ = com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.getDefaultInstance().getError();
                onChanged();
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder setErrorBytes(com.google.protobuf.ByteString byteString) {
                if (byteString == null) {
                    throw new java.lang.NullPointerException();
                }
                this.bitField0_ |= 1;
                this.error_ = byteString;
                onChanged();
                return this;
            }

            private void ensureFileIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.file_ = new java.util.ArrayList(this.file_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public java.util.List<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File> getFileList() {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return java.util.Collections.unmodifiableList(this.file_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getFileCount() {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.file_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File getFile(int i_renamed) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.file_.get(i_renamed);
                }
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File) repeatedFieldBuilderV3.getMessage(i_renamed);
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder setFile(int i_renamed, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File file) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i_renamed, file);
                } else {
                    if (file == null) {
                        throw new java.lang.NullPointerException();
                    }
                    ensureFileIsMutable();
                    this.file_.set(i_renamed, file);
                    onChanged();
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder setFile(int i_renamed, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder builder) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    this.file_.set(i_renamed, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i_renamed, builder.build());
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder addFile(com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File file) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(file);
                } else {
                    if (file == null) {
                        throw new java.lang.NullPointerException();
                    }
                    ensureFileIsMutable();
                    this.file_.add(file);
                    onChanged();
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder addFile(int i_renamed, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File file) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i_renamed, file);
                } else {
                    if (file == null) {
                        throw new java.lang.NullPointerException();
                    }
                    ensureFileIsMutable();
                    this.file_.add(i_renamed, file);
                    onChanged();
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder addFile(com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder builder) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    this.file_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder addFile(int i_renamed, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder builder) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    this.file_.add(i_renamed, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i_renamed, builder.build());
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder addAllFile(java.lang.Iterable<? extends com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File> iterable) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) this.file_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder clearFile() {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.file_ = java.util.Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder removeFile(int i_renamed) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    this.file_.remove(i_renamed);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i_renamed);
                }
                return this;
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder getFileBuilder(int i_renamed) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder) getFileFieldBuilder().getBuilder(i_renamed);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int i_renamed) {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.file_.get(i_renamed);
                }
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i_renamed);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public java.util.List<? extends com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> getFileOrBuilderList() {
                com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return java.util.Collections.unmodifiableList(this.file_);
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder addFileBuilder() {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder) getFileFieldBuilder().addBuilder(com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.getDefaultInstance());
            }

            public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder addFileBuilder(int i_renamed) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder) getFileFieldBuilder().addBuilder(i_renamed, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.getDefaultInstance());
            }

            public java.util.List<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder> getFileBuilderList() {
                return getFileFieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder, com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder> getFileFieldBuilder() {
                if (this.fileBuilder_ == null) {
                    this.fileBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<>(this.file_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.file_ = null;
                }
                return this.fileBuilder_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
                return (com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public com.google.protobuf.Parser<com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        com.google.protobuf.DescriptorProtos.getDescriptor();
    }
}
