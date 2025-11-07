package com.oplus.camera.sticker.protocol;

/* loaded from: classes2.dex */
public final class Sticker extends com.squareup.wire.Message<com.oplus.camera.sticker.protocol.Sticker, com.oplus.camera.sticker.protocol.Sticker.Builder> {
    public static final java.lang.String DEFAULT_FILEMD5 = "";
    public static final java.lang.String DEFAULT_FILEPATH = "";
    public static final java.lang.String DEFAULT_LOGOMD5 = "";
    public static final java.lang.String DEFAULT_LOGOPATH = "";
    public static final java.lang.String DEFAULT_NAME = "";
    public static final java.lang.String DEFAULT_THUMBNAILMD5 = "";
    public static final java.lang.String DEFAULT_THUMBNAILPATH = "";
    public static final java.lang.String DEFAULT_UUID = "";
    private static final long serialVersionUID = 0;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 13)
    public final java.lang.Long compatibleApp;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final java.lang.String fileMd5;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final java.lang.String filePath;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 11)
    public final java.lang.Boolean hasMusic;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final java.lang.Long id_renamed;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 14)
    public final java.lang.Boolean isNew;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final java.lang.String logoMd5;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final java.lang.String logoPath;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 15)
    public final java.lang.Integer materialType;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final java.lang.String name;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 12)
    public final java.lang.Integer position;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final java.lang.String thumbnailMd5;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final java.lang.String thumbnailPath;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final java.lang.String uuid;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 8)
    public final java.lang.Long version;
    public static final com.squareup.wire.ProtoAdapter<com.oplus.camera.sticker.protocol.Sticker> ADAPTER = new com.oplus.camera.sticker.protocol.Sticker.ProtoAdapter_Sticker();
    public static final java.lang.Long DEFAULT_ID = 0L;
    public static final java.lang.Long DEFAULT_VERSION = 0L;
    public static final java.lang.Boolean DEFAULT_HASMUSIC = false;
    public static final java.lang.Integer DEFAULT_POSITION = 0;
    public static final java.lang.Long DEFAULT_COMPATIBLEAPP = 0L;
    public static final java.lang.Boolean DEFAULT_ISNEW = false;
    public static final java.lang.Integer DEFAULT_MATERIALTYPE = 0;

    public Sticker(java.lang.Long l_renamed, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.Long l2, java.lang.String str7, java.lang.String str8, java.lang.Boolean bool, java.lang.Integer num, java.lang.Long l3, java.lang.Boolean bool2, java.lang.Integer num2) {
        this(l_renamed, str, str2, str3, str4, str5, str6, l2, str7, str8, bool, num, l3, bool2, num2, okio.ByteString.EMPTY);
    }

    public Sticker(java.lang.Long l_renamed, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.Long l2, java.lang.String str7, java.lang.String str8, java.lang.Boolean bool, java.lang.Integer num, java.lang.Long l3, java.lang.Boolean bool2, java.lang.Integer num2, okio.ByteString byteString) {
        super(ADAPTER, byteString);
        this.id_renamed = l_renamed;
        this.uuid = str;
        this.name = str2;
        this.filePath = str3;
        this.fileMd5 = str4;
        this.thumbnailPath = str5;
        this.thumbnailMd5 = str6;
        this.version = l2;
        this.logoPath = str7;
        this.logoMd5 = str8;
        this.hasMusic = bool;
        this.position = num;
        this.compatibleApp = l3;
        this.isNew = bool2;
        this.materialType = num2;
    }

    @Override // com.squareup.wire.Message
    public com.oplus.camera.sticker.protocol.Sticker.Builder newBuilder() {
        com.oplus.camera.sticker.protocol.Sticker.Builder builder = new com.oplus.camera.sticker.protocol.Sticker.Builder();
        builder.id_renamed = this.id_renamed;
        builder.uuid = this.uuid;
        builder.name = this.name;
        builder.filePath = this.filePath;
        builder.fileMd5 = this.fileMd5;
        builder.thumbnailPath = this.thumbnailPath;
        builder.thumbnailMd5 = this.thumbnailMd5;
        builder.version = this.version;
        builder.logoPath = this.logoPath;
        builder.logoMd5 = this.logoMd5;
        builder.hasMusic = this.hasMusic;
        builder.position = this.position;
        builder.compatibleApp = this.compatibleApp;
        builder.isNew = this.isNew;
        builder.materialType = this.materialType;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.oplus.camera.sticker.protocol.Sticker)) {
            return false;
        }
        com.oplus.camera.sticker.protocol.Sticker sticker = (com.oplus.camera.sticker.protocol.Sticker) obj;
        return unknownFields().equals(sticker.unknownFields()) && com.squareup.wire.internal.Internal.equals(this.id_renamed, sticker.id_renamed) && com.squareup.wire.internal.Internal.equals(this.uuid, sticker.uuid) && com.squareup.wire.internal.Internal.equals(this.name, sticker.name) && com.squareup.wire.internal.Internal.equals(this.filePath, sticker.filePath) && com.squareup.wire.internal.Internal.equals(this.fileMd5, sticker.fileMd5) && com.squareup.wire.internal.Internal.equals(this.thumbnailPath, sticker.thumbnailPath) && com.squareup.wire.internal.Internal.equals(this.thumbnailMd5, sticker.thumbnailMd5) && com.squareup.wire.internal.Internal.equals(this.version, sticker.version) && com.squareup.wire.internal.Internal.equals(this.logoPath, sticker.logoPath) && com.squareup.wire.internal.Internal.equals(this.logoMd5, sticker.logoMd5) && com.squareup.wire.internal.Internal.equals(this.hasMusic, sticker.hasMusic) && com.squareup.wire.internal.Internal.equals(this.position, sticker.position) && com.squareup.wire.internal.Internal.equals(this.compatibleApp, sticker.compatibleApp) && com.squareup.wire.internal.Internal.equals(this.isNew, sticker.isNew) && com.squareup.wire.internal.Internal.equals(this.materialType, sticker.materialType);
    }

    public int hashCode() {
        int i_renamed = this.hashCode;
        if (i_renamed != 0) {
            return i_renamed;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        java.lang.Long l_renamed = this.id_renamed;
        int iHashCode2 = (iHashCode + (l_renamed != null ? l_renamed.hashCode() : 0)) * 37;
        java.lang.String str = this.uuid;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        java.lang.String str2 = this.name;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        java.lang.String str3 = this.filePath;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        java.lang.String str4 = this.fileMd5;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        java.lang.String str5 = this.thumbnailPath;
        int iHashCode7 = (iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        java.lang.String str6 = this.thumbnailMd5;
        int iHashCode8 = (iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        java.lang.Long l2 = this.version;
        int iHashCode9 = (iHashCode8 + (l2 != null ? l2.hashCode() : 0)) * 37;
        java.lang.String str7 = this.logoPath;
        int iHashCode10 = (iHashCode9 + (str7 != null ? str7.hashCode() : 0)) * 37;
        java.lang.String str8 = this.logoMd5;
        int iHashCode11 = (iHashCode10 + (str8 != null ? str8.hashCode() : 0)) * 37;
        java.lang.Boolean bool = this.hasMusic;
        int iHashCode12 = (iHashCode11 + (bool != null ? bool.hashCode() : 0)) * 37;
        java.lang.Integer num = this.position;
        int iHashCode13 = (iHashCode12 + (num != null ? num.hashCode() : 0)) * 37;
        java.lang.Long l3 = this.compatibleApp;
        int iHashCode14 = (iHashCode13 + (l3 != null ? l3.hashCode() : 0)) * 37;
        java.lang.Boolean bool2 = this.isNew;
        int iHashCode15 = (iHashCode14 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        java.lang.Integer num2 = this.materialType;
        int iHashCode16 = iHashCode15 + (num2 != null ? num2.hashCode() : 0);
        this.hashCode = iHashCode16;
        return iHashCode16;
    }

    @Override // com.squareup.wire.Message
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.id_renamed != null) {
            sb.append(", id_renamed=");
            sb.append(this.id_renamed);
        }
        if (this.uuid != null) {
            sb.append(", uuid=");
            sb.append(this.uuid);
        }
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        if (this.filePath != null) {
            sb.append(", filePath=");
            sb.append(this.filePath);
        }
        if (this.fileMd5 != null) {
            sb.append(", fileMd5=");
            sb.append(this.fileMd5);
        }
        if (this.thumbnailPath != null) {
            sb.append(", thumbnailPath=");
            sb.append(this.thumbnailPath);
        }
        if (this.thumbnailMd5 != null) {
            sb.append(", thumbnailMd5=");
            sb.append(this.thumbnailMd5);
        }
        if (this.version != null) {
            sb.append(", version=");
            sb.append(this.version);
        }
        if (this.logoPath != null) {
            sb.append(", logoPath=");
            sb.append(this.logoPath);
        }
        if (this.logoMd5 != null) {
            sb.append(", logoMd5=");
            sb.append(this.logoMd5);
        }
        if (this.hasMusic != null) {
            sb.append(", hasMusic=");
            sb.append(this.hasMusic);
        }
        if (this.position != null) {
            sb.append(", position=");
            sb.append(this.position);
        }
        if (this.compatibleApp != null) {
            sb.append(", compatibleApp=");
            sb.append(this.compatibleApp);
        }
        if (this.isNew != null) {
            sb.append(", isNew=");
            sb.append(this.isNew);
        }
        if (this.materialType != null) {
            sb.append(", materialType=");
            sb.append(this.materialType);
        }
        java.lang.StringBuilder sbReplace = sb.replace(0, 2, "Sticker{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<com.oplus.camera.sticker.protocol.Sticker, com.oplus.camera.sticker.protocol.Sticker.Builder> {
        public java.lang.Long compatibleApp;
        public java.lang.String fileMd5;
        public java.lang.String filePath;
        public java.lang.Boolean hasMusic;
        public java.lang.Long id_renamed;
        public java.lang.Boolean isNew;
        public java.lang.String logoMd5;
        public java.lang.String logoPath;
        public java.lang.Integer materialType;
        public java.lang.String name;
        public java.lang.Integer position;
        public java.lang.String thumbnailMd5;
        public java.lang.String thumbnailPath;
        public java.lang.String uuid;
        public java.lang.Long version;

        public com.oplus.camera.sticker.protocol.Sticker.Builder id_renamed(java.lang.Long l_renamed) {
            this.id_renamed = l_renamed;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder uuid(java.lang.String str) {
            this.uuid = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder name(java.lang.String str) {
            this.name = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder filePath(java.lang.String str) {
            this.filePath = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder fileMd5(java.lang.String str) {
            this.fileMd5 = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder thumbnailPath(java.lang.String str) {
            this.thumbnailPath = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder thumbnailMd5(java.lang.String str) {
            this.thumbnailMd5 = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder version(java.lang.Long l_renamed) {
            this.version = l_renamed;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder logoPath(java.lang.String str) {
            this.logoPath = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder logoMd5(java.lang.String str) {
            this.logoMd5 = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder hasMusic(java.lang.Boolean bool) {
            this.hasMusic = bool;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder position(java.lang.Integer num) {
            this.position = num;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder compatibleApp(java.lang.Long l_renamed) {
            this.compatibleApp = l_renamed;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder isNew(java.lang.Boolean bool) {
            this.isNew = bool;
            return this;
        }

        public com.oplus.camera.sticker.protocol.Sticker.Builder materialType(java.lang.Integer num) {
            this.materialType = num;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public com.oplus.camera.sticker.protocol.Sticker build() {
            return new com.oplus.camera.sticker.protocol.Sticker(this.id_renamed, this.uuid, this.name, this.filePath, this.fileMd5, this.thumbnailPath, this.thumbnailMd5, this.version, this.logoPath, this.logoMd5, this.hasMusic, this.position, this.compatibleApp, this.isNew, this.materialType, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_Sticker extends com.squareup.wire.ProtoAdapter<com.oplus.camera.sticker.protocol.Sticker> {
        ProtoAdapter_Sticker() {
            super(com.squareup.wire.FieldEncoding.LENGTH_DELIMITED, com.oplus.camera.sticker.protocol.Sticker.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(com.oplus.camera.sticker.protocol.Sticker sticker) {
            return (sticker.id_renamed != null ? com.squareup.wire.ProtoAdapter.INT64.encodedSizeWithTag(1, sticker.id_renamed) : 0) + (sticker.uuid != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(2, sticker.uuid) : 0) + (sticker.name != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(3, sticker.name) : 0) + (sticker.filePath != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(4, sticker.filePath) : 0) + (sticker.fileMd5 != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(5, sticker.fileMd5) : 0) + (sticker.thumbnailPath != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(6, sticker.thumbnailPath) : 0) + (sticker.thumbnailMd5 != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(7, sticker.thumbnailMd5) : 0) + (sticker.version != null ? com.squareup.wire.ProtoAdapter.INT64.encodedSizeWithTag(8, sticker.version) : 0) + (sticker.logoPath != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(9, sticker.logoPath) : 0) + (sticker.logoMd5 != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(10, sticker.logoMd5) : 0) + (sticker.hasMusic != null ? com.squareup.wire.ProtoAdapter.BOOL.encodedSizeWithTag(11, sticker.hasMusic) : 0) + (sticker.position != null ? com.squareup.wire.ProtoAdapter.INT32.encodedSizeWithTag(12, sticker.position) : 0) + (sticker.compatibleApp != null ? com.squareup.wire.ProtoAdapter.INT64.encodedSizeWithTag(13, sticker.compatibleApp) : 0) + (sticker.isNew != null ? com.squareup.wire.ProtoAdapter.BOOL.encodedSizeWithTag(14, sticker.isNew) : 0) + (sticker.materialType != null ? com.squareup.wire.ProtoAdapter.INT32.encodedSizeWithTag(15, sticker.materialType) : 0) + sticker.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, com.oplus.camera.sticker.protocol.Sticker sticker) throws java.io.IOException {
            if (sticker.id_renamed != null) {
                com.squareup.wire.ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, sticker.id_renamed);
            }
            if (sticker.uuid != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, sticker.uuid);
            }
            if (sticker.name != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, sticker.name);
            }
            if (sticker.filePath != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, sticker.filePath);
            }
            if (sticker.fileMd5 != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, sticker.fileMd5);
            }
            if (sticker.thumbnailPath != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, sticker.thumbnailPath);
            }
            if (sticker.thumbnailMd5 != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, sticker.thumbnailMd5);
            }
            if (sticker.version != null) {
                com.squareup.wire.ProtoAdapter.INT64.encodeWithTag(protoWriter, 8, sticker.version);
            }
            if (sticker.logoPath != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, sticker.logoPath);
            }
            if (sticker.logoMd5 != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, sticker.logoMd5);
            }
            if (sticker.hasMusic != null) {
                com.squareup.wire.ProtoAdapter.BOOL.encodeWithTag(protoWriter, 11, sticker.hasMusic);
            }
            if (sticker.position != null) {
                com.squareup.wire.ProtoAdapter.INT32.encodeWithTag(protoWriter, 12, sticker.position);
            }
            if (sticker.compatibleApp != null) {
                com.squareup.wire.ProtoAdapter.INT64.encodeWithTag(protoWriter, 13, sticker.compatibleApp);
            }
            if (sticker.isNew != null) {
                com.squareup.wire.ProtoAdapter.BOOL.encodeWithTag(protoWriter, 14, sticker.isNew);
            }
            if (sticker.materialType != null) {
                com.squareup.wire.ProtoAdapter.INT32.encodeWithTag(protoWriter, 15, sticker.materialType);
            }
            protoWriter.writeBytes(sticker.unknownFields());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public com.oplus.camera.sticker.protocol.Sticker decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            com.oplus.camera.sticker.protocol.Sticker.Builder builder = new com.oplus.camera.sticker.protocol.Sticker.Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag != -1) {
                    switch (iNextTag) {
                        case 1:
                            builder.id_renamed(com.squareup.wire.ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 2:
                            builder.uuid(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.name(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.filePath(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.fileMd5(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.thumbnailPath(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.thumbnailMd5(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            builder.version(com.squareup.wire.ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 9:
                            builder.logoPath(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.logoMd5(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.hasMusic(com.squareup.wire.ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 12:
                            builder.position(com.squareup.wire.ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 13:
                            builder.compatibleApp(com.squareup.wire.ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 14:
                            builder.isNew(com.squareup.wire.ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 15:
                            builder.materialType(com.squareup.wire.ProtoAdapter.INT32.decode(protoReader));
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
        public com.oplus.camera.sticker.protocol.Sticker redact(com.oplus.camera.sticker.protocol.Sticker sticker) {
            com.oplus.camera.sticker.protocol.Sticker.Builder builderNewBuilder = sticker.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }
}
