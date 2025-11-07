package com.oplus.camera.sticker.protocol;

/* loaded from: classes2.dex */
public final class StickerResponse extends com.squareup.wire.Message<com.oplus.camera.sticker.protocol.StickerResponse, com.oplus.camera.sticker.protocol.StickerResponse.Builder> {
    public static final java.lang.String DEFAULT_FILESERVERHOST = "";
    public static final java.lang.String DEFAULT_RESULTDESC = "";
    private static final long serialVersionUID = 0;

    @com.squareup.wire.WireField(adapter = "com.oplus.camera.sticker.protocol.StickerCategory#ADAPTER", label = com.squareup.wire.WireField.Label.REPEATED, tag = 2)
    public final java.util.List<com.oplus.camera.sticker.protocol.StickerCategory> category;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final java.lang.Integer checkInterval;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final java.lang.Long dataVersion;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final java.lang.String fileServerHost;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final java.lang.Integer resultCode;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final java.lang.String resultDesc;
    public static final com.squareup.wire.ProtoAdapter<com.oplus.camera.sticker.protocol.StickerResponse> ADAPTER = new com.oplus.camera.sticker.protocol.StickerResponse.ProtoAdapter_StickerResponse();
    public static final java.lang.Long DEFAULT_DATAVERSION = 0L;
    public static final java.lang.Integer DEFAULT_CHECKINTERVAL = 0;
    public static final java.lang.Integer DEFAULT_RESULTCODE = 0;

    public StickerResponse(java.lang.Long l_renamed, java.util.List<com.oplus.camera.sticker.protocol.StickerCategory> list, java.lang.String str, java.lang.Integer num, java.lang.Integer num2, java.lang.String str2) {
        this(l_renamed, list, str, num, num2, str2, okio.ByteString.EMPTY);
    }

    public StickerResponse(java.lang.Long l_renamed, java.util.List<com.oplus.camera.sticker.protocol.StickerCategory> list, java.lang.String str, java.lang.Integer num, java.lang.Integer num2, java.lang.String str2, okio.ByteString byteString) {
        super(ADAPTER, byteString);
        this.dataVersion = l_renamed;
        this.category = com.squareup.wire.internal.Internal.immutableCopyOf("category", list);
        this.fileServerHost = str;
        this.checkInterval = num;
        this.resultCode = num2;
        this.resultDesc = str2;
    }

    @Override // com.squareup.wire.Message
    public com.oplus.camera.sticker.protocol.StickerResponse.Builder newBuilder() {
        com.oplus.camera.sticker.protocol.StickerResponse.Builder builder = new com.oplus.camera.sticker.protocol.StickerResponse.Builder();
        builder.dataVersion = this.dataVersion;
        builder.category = com.squareup.wire.internal.Internal.copyOf("category", this.category);
        builder.fileServerHost = this.fileServerHost;
        builder.checkInterval = this.checkInterval;
        builder.resultCode = this.resultCode;
        builder.resultDesc = this.resultDesc;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.oplus.camera.sticker.protocol.StickerResponse)) {
            return false;
        }
        com.oplus.camera.sticker.protocol.StickerResponse stickerResponse = (com.oplus.camera.sticker.protocol.StickerResponse) obj;
        return unknownFields().equals(stickerResponse.unknownFields()) && com.squareup.wire.internal.Internal.equals(this.dataVersion, stickerResponse.dataVersion) && this.category.equals(stickerResponse.category) && com.squareup.wire.internal.Internal.equals(this.fileServerHost, stickerResponse.fileServerHost) && com.squareup.wire.internal.Internal.equals(this.checkInterval, stickerResponse.checkInterval) && com.squareup.wire.internal.Internal.equals(this.resultCode, stickerResponse.resultCode) && com.squareup.wire.internal.Internal.equals(this.resultDesc, stickerResponse.resultDesc);
    }

    public int hashCode() {
        int i_renamed = this.hashCode;
        if (i_renamed != 0) {
            return i_renamed;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        java.lang.Long l_renamed = this.dataVersion;
        int iHashCode2 = (((iHashCode + (l_renamed != null ? l_renamed.hashCode() : 0)) * 37) + this.category.hashCode()) * 37;
        java.lang.String str = this.fileServerHost;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        java.lang.Integer num = this.checkInterval;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        java.lang.Integer num2 = this.resultCode;
        int iHashCode5 = (iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        java.lang.String str2 = this.resultDesc;
        int iHashCode6 = iHashCode5 + (str2 != null ? str2.hashCode() : 0);
        this.hashCode = iHashCode6;
        return iHashCode6;
    }

    @Override // com.squareup.wire.Message
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.dataVersion != null) {
            sb.append(", dataVersion=");
            sb.append(this.dataVersion);
        }
        if (!this.category.isEmpty()) {
            sb.append(", category=");
            sb.append(this.category);
        }
        if (this.fileServerHost != null) {
            sb.append(", fileServerHost=");
            sb.append(this.fileServerHost);
        }
        if (this.checkInterval != null) {
            sb.append(", checkInterval=");
            sb.append(this.checkInterval);
        }
        if (this.resultCode != null) {
            sb.append(", resultCode=");
            sb.append(this.resultCode);
        }
        if (this.resultDesc != null) {
            sb.append(", resultDesc=");
            sb.append(this.resultDesc);
        }
        java.lang.StringBuilder sbReplace = sb.replace(0, 2, "StickerResponse{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<com.oplus.camera.sticker.protocol.StickerResponse, com.oplus.camera.sticker.protocol.StickerResponse.Builder> {
        public java.util.List<com.oplus.camera.sticker.protocol.StickerCategory> category = com.squareup.wire.internal.Internal.newMutableList();
        public java.lang.Integer checkInterval;
        public java.lang.Long dataVersion;
        public java.lang.String fileServerHost;
        public java.lang.Integer resultCode;
        public java.lang.String resultDesc;

        public com.oplus.camera.sticker.protocol.StickerResponse.Builder dataVersion(java.lang.Long l_renamed) {
            this.dataVersion = l_renamed;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerResponse.Builder category(java.util.List<com.oplus.camera.sticker.protocol.StickerCategory> list) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(list);
            this.category = list;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerResponse.Builder fileServerHost(java.lang.String str) {
            this.fileServerHost = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerResponse.Builder checkInterval(java.lang.Integer num) {
            this.checkInterval = num;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerResponse.Builder resultCode(java.lang.Integer num) {
            this.resultCode = num;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerResponse.Builder resultDesc(java.lang.String str) {
            this.resultDesc = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public com.oplus.camera.sticker.protocol.StickerResponse build() {
            return new com.oplus.camera.sticker.protocol.StickerResponse(this.dataVersion, this.category, this.fileServerHost, this.checkInterval, this.resultCode, this.resultDesc, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_StickerResponse extends com.squareup.wire.ProtoAdapter<com.oplus.camera.sticker.protocol.StickerResponse> {
        ProtoAdapter_StickerResponse() {
            super(com.squareup.wire.FieldEncoding.LENGTH_DELIMITED, com.oplus.camera.sticker.protocol.StickerResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(com.oplus.camera.sticker.protocol.StickerResponse stickerResponse) {
            return (stickerResponse.dataVersion != null ? com.squareup.wire.ProtoAdapter.INT64.encodedSizeWithTag(1, stickerResponse.dataVersion) : 0) + com.oplus.camera.sticker.protocol.StickerCategory.ADAPTER.asRepeated().encodedSizeWithTag(2, stickerResponse.category) + (stickerResponse.fileServerHost != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(3, stickerResponse.fileServerHost) : 0) + (stickerResponse.checkInterval != null ? com.squareup.wire.ProtoAdapter.INT32.encodedSizeWithTag(4, stickerResponse.checkInterval) : 0) + (stickerResponse.resultCode != null ? com.squareup.wire.ProtoAdapter.INT32.encodedSizeWithTag(5, stickerResponse.resultCode) : 0) + (stickerResponse.resultDesc != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(6, stickerResponse.resultDesc) : 0) + stickerResponse.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, com.oplus.camera.sticker.protocol.StickerResponse stickerResponse) throws java.io.IOException {
            if (stickerResponse.dataVersion != null) {
                com.squareup.wire.ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, stickerResponse.dataVersion);
            }
            com.oplus.camera.sticker.protocol.StickerCategory.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, stickerResponse.category);
            if (stickerResponse.fileServerHost != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, stickerResponse.fileServerHost);
            }
            if (stickerResponse.checkInterval != null) {
                com.squareup.wire.ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, stickerResponse.checkInterval);
            }
            if (stickerResponse.resultCode != null) {
                com.squareup.wire.ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, stickerResponse.resultCode);
            }
            if (stickerResponse.resultDesc != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, stickerResponse.resultDesc);
            }
            protoWriter.writeBytes(stickerResponse.unknownFields());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public com.oplus.camera.sticker.protocol.StickerResponse decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            com.oplus.camera.sticker.protocol.StickerResponse.Builder builder = new com.oplus.camera.sticker.protocol.StickerResponse.Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag != -1) {
                    switch (iNextTag) {
                        case 1:
                            builder.dataVersion(com.squareup.wire.ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 2:
                            builder.category.add(com.oplus.camera.sticker.protocol.StickerCategory.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            builder.fileServerHost(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.checkInterval(com.squareup.wire.ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 5:
                            builder.resultCode(com.squareup.wire.ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 6:
                            builder.resultDesc(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            com.squareup.wire.FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        public com.oplus.camera.sticker.protocol.StickerResponse redact(com.oplus.camera.sticker.protocol.StickerResponse stickerResponse) {
            com.oplus.camera.sticker.protocol.StickerResponse.Builder builderNewBuilder = stickerResponse.newBuilder();
            com.squareup.wire.internal.Internal.redactElements(builderNewBuilder.category, com.oplus.camera.sticker.protocol.StickerCategory.ADAPTER);
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }
}
