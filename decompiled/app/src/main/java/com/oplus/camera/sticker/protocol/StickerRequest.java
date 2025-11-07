package com.oplus.camera.sticker.protocol;

/* loaded from: classes2.dex */
public final class StickerRequest extends com.squareup.wire.Message<com.oplus.camera.sticker.protocol.StickerRequest, com.oplus.camera.sticker.protocol.StickerRequest.Builder> {
    public static final java.lang.String DEFAULT_ANDROIDVERSION = "";
    public static final java.lang.String DEFAULT_CLIENTVERSION = "";
    public static final java.lang.String DEFAULT_IMEI = "";
    public static final java.lang.String DEFAULT_LOCALE = "";
    public static final java.lang.String DEFAULT_MODEL = "";
    public static final java.lang.String DEFAULT_OPLUSOSVERSION = "";
    public static final java.lang.String DEFAULT_OTAVERSION = "";
    public static final java.lang.String DEFAULT_PROTOCOLVERSION = "";
    public static final java.lang.String DEFAULT_RESRESOLUTION = "";
    private static final long serialVersionUID = 0;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final java.lang.String androidVersion;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final java.lang.String clientVersion;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 11)
    public final java.lang.Long compatibleApp;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final java.lang.String imei;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 10)
    public final java.lang.Long localDataVersion;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final java.lang.String locale;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final java.lang.String model;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final java.lang.String oplusosVersion;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final java.lang.String otaVersion;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final java.lang.String protocolVersion;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final java.lang.String resResolution;
    public static final com.squareup.wire.ProtoAdapter<com.oplus.camera.sticker.protocol.StickerRequest> ADAPTER = new com.oplus.camera.sticker.protocol.StickerRequest.ProtoAdapter_StickerRequest();
    public static final java.lang.Long DEFAULT_LOCALDATAVERSION = 0L;
    public static final java.lang.Long DEFAULT_COMPATIBLEAPP = 0L;

    public StickerRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.Long l_renamed, java.lang.Long l2) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, l_renamed, l2, okio.ByteString.EMPTY);
    }

    public StickerRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.Long l_renamed, java.lang.Long l2, okio.ByteString byteString) {
        super(ADAPTER, byteString);
        this.imei = str;
        this.model = str2;
        this.resResolution = str3;
        this.protocolVersion = str4;
        this.clientVersion = str5;
        this.oplusosVersion = str6;
        this.androidVersion = str7;
        this.otaVersion = str8;
        this.locale = str9;
        this.localDataVersion = l_renamed;
        this.compatibleApp = l2;
    }

    @Override // com.squareup.wire.Message
    public com.oplus.camera.sticker.protocol.StickerRequest.Builder newBuilder() {
        com.oplus.camera.sticker.protocol.StickerRequest.Builder builder = new com.oplus.camera.sticker.protocol.StickerRequest.Builder();
        builder.imei = this.imei;
        builder.model = this.model;
        builder.resResolution = this.resResolution;
        builder.protocolVersion = this.protocolVersion;
        builder.clientVersion = this.clientVersion;
        builder.oplusosVersion = this.oplusosVersion;
        builder.androidVersion = this.androidVersion;
        builder.otaVersion = this.otaVersion;
        builder.locale = this.locale;
        builder.localDataVersion = this.localDataVersion;
        builder.compatibleApp = this.compatibleApp;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.oplus.camera.sticker.protocol.StickerRequest)) {
            return false;
        }
        com.oplus.camera.sticker.protocol.StickerRequest stickerRequest = (com.oplus.camera.sticker.protocol.StickerRequest) obj;
        return unknownFields().equals(stickerRequest.unknownFields()) && com.squareup.wire.internal.Internal.equals(this.imei, stickerRequest.imei) && com.squareup.wire.internal.Internal.equals(this.model, stickerRequest.model) && com.squareup.wire.internal.Internal.equals(this.resResolution, stickerRequest.resResolution) && com.squareup.wire.internal.Internal.equals(this.protocolVersion, stickerRequest.protocolVersion) && com.squareup.wire.internal.Internal.equals(this.clientVersion, stickerRequest.clientVersion) && com.squareup.wire.internal.Internal.equals(this.oplusosVersion, stickerRequest.oplusosVersion) && com.squareup.wire.internal.Internal.equals(this.androidVersion, stickerRequest.androidVersion) && com.squareup.wire.internal.Internal.equals(this.otaVersion, stickerRequest.otaVersion) && com.squareup.wire.internal.Internal.equals(this.locale, stickerRequest.locale) && com.squareup.wire.internal.Internal.equals(this.localDataVersion, stickerRequest.localDataVersion) && com.squareup.wire.internal.Internal.equals(this.compatibleApp, stickerRequest.compatibleApp);
    }

    public int hashCode() {
        int i_renamed = this.hashCode;
        if (i_renamed != 0) {
            return i_renamed;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        java.lang.String str = this.imei;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        java.lang.String str2 = this.model;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        java.lang.String str3 = this.resResolution;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        java.lang.String str4 = this.protocolVersion;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        java.lang.String str5 = this.clientVersion;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        java.lang.String str6 = this.oplusosVersion;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        java.lang.String str7 = this.androidVersion;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        java.lang.String str8 = this.otaVersion;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        java.lang.String str9 = this.locale;
        int iHashCode10 = (iHashCode9 + (str9 != null ? str9.hashCode() : 0)) * 37;
        java.lang.Long l_renamed = this.localDataVersion;
        int iHashCode11 = (iHashCode10 + (l_renamed != null ? l_renamed.hashCode() : 0)) * 37;
        java.lang.Long l2 = this.compatibleApp;
        int iHashCode12 = iHashCode11 + (l2 != null ? l2.hashCode() : 0);
        this.hashCode = iHashCode12;
        return iHashCode12;
    }

    @Override // com.squareup.wire.Message
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.imei != null) {
            sb.append(", imei=");
            sb.append(this.imei);
        }
        if (this.model != null) {
            sb.append(", model=");
            sb.append(this.model);
        }
        if (this.resResolution != null) {
            sb.append(", resResolution=");
            sb.append(this.resResolution);
        }
        if (this.protocolVersion != null) {
            sb.append(", protocolVersion=");
            sb.append(this.protocolVersion);
        }
        if (this.clientVersion != null) {
            sb.append(", clientVersion=");
            sb.append(this.clientVersion);
        }
        if (this.oplusosVersion != null) {
            sb.append(", oplusosVersion=");
            sb.append(this.oplusosVersion);
        }
        if (this.androidVersion != null) {
            sb.append(", androidVersion=");
            sb.append(this.androidVersion);
        }
        if (this.otaVersion != null) {
            sb.append(", otaVersion=");
            sb.append(this.otaVersion);
        }
        if (this.locale != null) {
            sb.append(", locale=");
            sb.append(this.locale);
        }
        if (this.localDataVersion != null) {
            sb.append(", localDataVersion=");
            sb.append(this.localDataVersion);
        }
        if (this.compatibleApp != null) {
            sb.append(", compatibleApp=");
            sb.append(this.compatibleApp);
        }
        java.lang.StringBuilder sbReplace = sb.replace(0, 2, "StickerRequest{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<com.oplus.camera.sticker.protocol.StickerRequest, com.oplus.camera.sticker.protocol.StickerRequest.Builder> {
        public java.lang.String androidVersion;
        public java.lang.String clientVersion;
        public java.lang.Long compatibleApp;
        public java.lang.String imei;
        public java.lang.Long localDataVersion;
        public java.lang.String locale;
        public java.lang.String model;
        public java.lang.String oplusosVersion;
        public java.lang.String otaVersion;
        public java.lang.String protocolVersion;
        public java.lang.String resResolution;

        public com.oplus.camera.sticker.protocol.StickerRequest.Builder imei(java.lang.String str) {
            this.imei = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerRequest.Builder model(java.lang.String str) {
            this.model = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerRequest.Builder resResolution(java.lang.String str) {
            this.resResolution = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerRequest.Builder protocolVersion(java.lang.String str) {
            this.protocolVersion = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerRequest.Builder clientVersion(java.lang.String str) {
            this.clientVersion = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerRequest.Builder oplusosVersion(java.lang.String str) {
            this.oplusosVersion = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerRequest.Builder androidVersion(java.lang.String str) {
            this.androidVersion = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerRequest.Builder otaVersion(java.lang.String str) {
            this.otaVersion = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerRequest.Builder locale(java.lang.String str) {
            this.locale = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerRequest.Builder localDataVersion(java.lang.Long l_renamed) {
            this.localDataVersion = l_renamed;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerRequest.Builder compatibleApp(java.lang.Long l_renamed) {
            this.compatibleApp = l_renamed;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public com.oplus.camera.sticker.protocol.StickerRequest build() {
            return new com.oplus.camera.sticker.protocol.StickerRequest(this.imei, this.model, this.resResolution, this.protocolVersion, this.clientVersion, this.oplusosVersion, this.androidVersion, this.otaVersion, this.locale, this.localDataVersion, this.compatibleApp, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_StickerRequest extends com.squareup.wire.ProtoAdapter<com.oplus.camera.sticker.protocol.StickerRequest> {
        ProtoAdapter_StickerRequest() {
            super(com.squareup.wire.FieldEncoding.LENGTH_DELIMITED, com.oplus.camera.sticker.protocol.StickerRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(com.oplus.camera.sticker.protocol.StickerRequest stickerRequest) {
            return (stickerRequest.imei != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(1, stickerRequest.imei) : 0) + (stickerRequest.model != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(2, stickerRequest.model) : 0) + (stickerRequest.resResolution != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(3, stickerRequest.resResolution) : 0) + (stickerRequest.protocolVersion != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(4, stickerRequest.protocolVersion) : 0) + (stickerRequest.clientVersion != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(5, stickerRequest.clientVersion) : 0) + (stickerRequest.oplusosVersion != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(6, stickerRequest.oplusosVersion) : 0) + (stickerRequest.androidVersion != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(7, stickerRequest.androidVersion) : 0) + (stickerRequest.otaVersion != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(8, stickerRequest.otaVersion) : 0) + (stickerRequest.locale != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(9, stickerRequest.locale) : 0) + (stickerRequest.localDataVersion != null ? com.squareup.wire.ProtoAdapter.INT64.encodedSizeWithTag(10, stickerRequest.localDataVersion) : 0) + (stickerRequest.compatibleApp != null ? com.squareup.wire.ProtoAdapter.INT64.encodedSizeWithTag(11, stickerRequest.compatibleApp) : 0) + stickerRequest.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, com.oplus.camera.sticker.protocol.StickerRequest stickerRequest) throws java.io.IOException {
            if (stickerRequest.imei != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, stickerRequest.imei);
            }
            if (stickerRequest.model != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, stickerRequest.model);
            }
            if (stickerRequest.resResolution != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, stickerRequest.resResolution);
            }
            if (stickerRequest.protocolVersion != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, stickerRequest.protocolVersion);
            }
            if (stickerRequest.clientVersion != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, stickerRequest.clientVersion);
            }
            if (stickerRequest.oplusosVersion != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, stickerRequest.oplusosVersion);
            }
            if (stickerRequest.androidVersion != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, stickerRequest.androidVersion);
            }
            if (stickerRequest.otaVersion != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, stickerRequest.otaVersion);
            }
            if (stickerRequest.locale != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, stickerRequest.locale);
            }
            if (stickerRequest.localDataVersion != null) {
                com.squareup.wire.ProtoAdapter.INT64.encodeWithTag(protoWriter, 10, stickerRequest.localDataVersion);
            }
            if (stickerRequest.compatibleApp != null) {
                com.squareup.wire.ProtoAdapter.INT64.encodeWithTag(protoWriter, 11, stickerRequest.compatibleApp);
            }
            protoWriter.writeBytes(stickerRequest.unknownFields());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public com.oplus.camera.sticker.protocol.StickerRequest decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            com.oplus.camera.sticker.protocol.StickerRequest.Builder builder = new com.oplus.camera.sticker.protocol.StickerRequest.Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag != -1) {
                    switch (iNextTag) {
                        case 1:
                            builder.imei(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.model(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.resResolution(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.protocolVersion(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.clientVersion(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.oplusosVersion(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.androidVersion(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            builder.otaVersion(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.locale(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.localDataVersion(com.squareup.wire.ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 11:
                            builder.compatibleApp(com.squareup.wire.ProtoAdapter.INT64.decode(protoReader));
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
        public com.oplus.camera.sticker.protocol.StickerRequest redact(com.oplus.camera.sticker.protocol.StickerRequest stickerRequest) {
            com.oplus.camera.sticker.protocol.StickerRequest.Builder builderNewBuilder = stickerRequest.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }
}
