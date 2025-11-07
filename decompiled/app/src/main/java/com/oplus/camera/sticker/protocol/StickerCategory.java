package com.oplus.camera.sticker.protocol;

/* loaded from: classes2.dex */
public final class StickerCategory extends com.squareup.wire.Message<com.oplus.camera.sticker.protocol.StickerCategory, com.oplus.camera.sticker.protocol.StickerCategory.Builder> {
    public static final java.lang.String DEFAULT_HIGHLIGHTICONMD5 = "";
    public static final java.lang.String DEFAULT_HIGHLIGHTICONPATH = "";
    public static final java.lang.String DEFAULT_ICONMD5 = "";
    public static final java.lang.String DEFAULT_ICONPATH = "";
    public static final java.lang.String DEFAULT_NAME = "";
    public static final java.lang.String DEFAULT_READABLEID = "";
    private static final long serialVersionUID = 0;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final java.lang.String highlightIconMd5;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final java.lang.String highlightIconPath;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final java.lang.String iconMd5;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final java.lang.String iconPath;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final java.lang.Long id_renamed;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    public final java.lang.Boolean isNew;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final java.lang.String name;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    public final java.lang.Integer position;

    @com.squareup.wire.WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final java.lang.String readableId;

    @com.squareup.wire.WireField(adapter = "com.oplus.providers.sticker.protocol.Sticker#ADAPTER", label = com.squareup.wire.WireField.Label.REPEATED, tag = 4)
    public final java.util.List<com.oplus.camera.sticker.protocol.Sticker> sticker;
    public static final com.squareup.wire.ProtoAdapter<com.oplus.camera.sticker.protocol.StickerCategory> ADAPTER = new com.oplus.camera.sticker.protocol.StickerCategory.ProtoAdapter_StickerCategory();
    public static final java.lang.Long DEFAULT_ID = 0L;
    public static final java.lang.Integer DEFAULT_POSITION = 0;
    public static final java.lang.Boolean DEFAULT_ISNEW = false;

    public StickerCategory(java.lang.Long l_renamed, java.lang.String str, java.lang.String str2, java.util.List<com.oplus.camera.sticker.protocol.Sticker> list, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.Integer num, java.lang.Boolean bool) {
        this(l_renamed, str, str2, list, str3, str4, str5, str6, num, bool, okio.ByteString.EMPTY);
    }

    public StickerCategory(java.lang.Long l_renamed, java.lang.String str, java.lang.String str2, java.util.List<com.oplus.camera.sticker.protocol.Sticker> list, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.Integer num, java.lang.Boolean bool, okio.ByteString byteString) {
        super(ADAPTER, byteString);
        this.id_renamed = l_renamed;
        this.readableId = str;
        this.name = str2;
        this.sticker = com.squareup.wire.internal.Internal.immutableCopyOf(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER, list);
        this.iconPath = str3;
        this.iconMd5 = str4;
        this.highlightIconPath = str5;
        this.highlightIconMd5 = str6;
        this.position = num;
        this.isNew = bool;
    }

    @Override // com.squareup.wire.Message
    public com.oplus.camera.sticker.protocol.StickerCategory.Builder newBuilder() {
        com.oplus.camera.sticker.protocol.StickerCategory.Builder builder = new com.oplus.camera.sticker.protocol.StickerCategory.Builder();
        builder.id_renamed = this.id_renamed;
        builder.readableId = this.readableId;
        builder.name = this.name;
        builder.sticker = com.squareup.wire.internal.Internal.copyOf(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER, this.sticker);
        builder.iconPath = this.iconPath;
        builder.iconMd5 = this.iconMd5;
        builder.highlightIconPath = this.highlightIconPath;
        builder.highlightIconMd5 = this.highlightIconMd5;
        builder.position = this.position;
        builder.isNew = this.isNew;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.oplus.camera.sticker.protocol.StickerCategory)) {
            return false;
        }
        com.oplus.camera.sticker.protocol.StickerCategory stickerCategory = (com.oplus.camera.sticker.protocol.StickerCategory) obj;
        return unknownFields().equals(stickerCategory.unknownFields()) && com.squareup.wire.internal.Internal.equals(this.id_renamed, stickerCategory.id_renamed) && com.squareup.wire.internal.Internal.equals(this.readableId, stickerCategory.readableId) && com.squareup.wire.internal.Internal.equals(this.name, stickerCategory.name) && this.sticker.equals(stickerCategory.sticker) && com.squareup.wire.internal.Internal.equals(this.iconPath, stickerCategory.iconPath) && com.squareup.wire.internal.Internal.equals(this.iconMd5, stickerCategory.iconMd5) && com.squareup.wire.internal.Internal.equals(this.highlightIconPath, stickerCategory.highlightIconPath) && com.squareup.wire.internal.Internal.equals(this.highlightIconMd5, stickerCategory.highlightIconMd5) && com.squareup.wire.internal.Internal.equals(this.position, stickerCategory.position) && com.squareup.wire.internal.Internal.equals(this.isNew, stickerCategory.isNew);
    }

    public int hashCode() {
        int i_renamed = this.hashCode;
        if (i_renamed != 0) {
            return i_renamed;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        java.lang.Long l_renamed = this.id_renamed;
        int iHashCode2 = (iHashCode + (l_renamed != null ? l_renamed.hashCode() : 0)) * 37;
        java.lang.String str = this.readableId;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        java.lang.String str2 = this.name;
        int iHashCode4 = (((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37) + this.sticker.hashCode()) * 37;
        java.lang.String str3 = this.iconPath;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        java.lang.String str4 = this.iconMd5;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        java.lang.String str5 = this.highlightIconPath;
        int iHashCode7 = (iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        java.lang.String str6 = this.highlightIconMd5;
        int iHashCode8 = (iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        java.lang.Integer num = this.position;
        int iHashCode9 = (iHashCode8 + (num != null ? num.hashCode() : 0)) * 37;
        java.lang.Boolean bool = this.isNew;
        int iHashCode10 = iHashCode9 + (bool != null ? bool.hashCode() : 0);
        this.hashCode = iHashCode10;
        return iHashCode10;
    }

    @Override // com.squareup.wire.Message
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.id_renamed != null) {
            sb.append(", id_renamed=");
            sb.append(this.id_renamed);
        }
        if (this.readableId != null) {
            sb.append(", readableId=");
            sb.append(this.readableId);
        }
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        if (!this.sticker.isEmpty()) {
            sb.append(", sticker=");
            sb.append(this.sticker);
        }
        if (this.iconPath != null) {
            sb.append(", iconPath=");
            sb.append(this.iconPath);
        }
        if (this.iconMd5 != null) {
            sb.append(", iconMd5=");
            sb.append(this.iconMd5);
        }
        if (this.highlightIconPath != null) {
            sb.append(", highlightIconPath=");
            sb.append(this.highlightIconPath);
        }
        if (this.highlightIconMd5 != null) {
            sb.append(", highlightIconMd5=");
            sb.append(this.highlightIconMd5);
        }
        if (this.position != null) {
            sb.append(", position=");
            sb.append(this.position);
        }
        if (this.isNew != null) {
            sb.append(", isNew=");
            sb.append(this.isNew);
        }
        java.lang.StringBuilder sbReplace = sb.replace(0, 2, "StickerCategory{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<com.oplus.camera.sticker.protocol.StickerCategory, com.oplus.camera.sticker.protocol.StickerCategory.Builder> {
        public java.lang.String highlightIconMd5;
        public java.lang.String highlightIconPath;
        public java.lang.String iconMd5;
        public java.lang.String iconPath;
        public java.lang.Long id_renamed;
        public java.lang.Boolean isNew;
        public java.lang.String name;
        public java.lang.Integer position;
        public java.lang.String readableId;
        public java.util.List<com.oplus.camera.sticker.protocol.Sticker> sticker = com.squareup.wire.internal.Internal.newMutableList();

        public com.oplus.camera.sticker.protocol.StickerCategory.Builder id_renamed(java.lang.Long l_renamed) {
            this.id_renamed = l_renamed;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerCategory.Builder readableId(java.lang.String str) {
            this.readableId = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerCategory.Builder name(java.lang.String str) {
            this.name = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerCategory.Builder sticker(java.util.List<com.oplus.camera.sticker.protocol.Sticker> list) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(list);
            this.sticker = list;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerCategory.Builder iconPath(java.lang.String str) {
            this.iconPath = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerCategory.Builder iconMd5(java.lang.String str) {
            this.iconMd5 = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerCategory.Builder highlightIconPath(java.lang.String str) {
            this.highlightIconPath = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerCategory.Builder highlightIconMd5(java.lang.String str) {
            this.highlightIconMd5 = str;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerCategory.Builder position(java.lang.Integer num) {
            this.position = num;
            return this;
        }

        public com.oplus.camera.sticker.protocol.StickerCategory.Builder isNew(java.lang.Boolean bool) {
            this.isNew = bool;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public com.oplus.camera.sticker.protocol.StickerCategory build() {
            return new com.oplus.camera.sticker.protocol.StickerCategory(this.id_renamed, this.readableId, this.name, this.sticker, this.iconPath, this.iconMd5, this.highlightIconPath, this.highlightIconMd5, this.position, this.isNew, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_StickerCategory extends com.squareup.wire.ProtoAdapter<com.oplus.camera.sticker.protocol.StickerCategory> {
        ProtoAdapter_StickerCategory() {
            super(com.squareup.wire.FieldEncoding.LENGTH_DELIMITED, com.oplus.camera.sticker.protocol.StickerCategory.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(com.oplus.camera.sticker.protocol.StickerCategory stickerCategory) {
            return (stickerCategory.id_renamed != null ? com.squareup.wire.ProtoAdapter.INT64.encodedSizeWithTag(1, stickerCategory.id_renamed) : 0) + (stickerCategory.readableId != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(2, stickerCategory.readableId) : 0) + (stickerCategory.name != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(3, stickerCategory.name) : 0) + com.oplus.camera.sticker.protocol.Sticker.ADAPTER.asRepeated().encodedSizeWithTag(4, stickerCategory.sticker) + (stickerCategory.iconPath != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(5, stickerCategory.iconPath) : 0) + (stickerCategory.iconMd5 != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(6, stickerCategory.iconMd5) : 0) + (stickerCategory.highlightIconPath != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(7, stickerCategory.highlightIconPath) : 0) + (stickerCategory.highlightIconMd5 != null ? com.squareup.wire.ProtoAdapter.STRING.encodedSizeWithTag(8, stickerCategory.highlightIconMd5) : 0) + (stickerCategory.position != null ? com.squareup.wire.ProtoAdapter.INT32.encodedSizeWithTag(9, stickerCategory.position) : 0) + (stickerCategory.isNew != null ? com.squareup.wire.ProtoAdapter.BOOL.encodedSizeWithTag(10, stickerCategory.isNew) : 0) + stickerCategory.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, com.oplus.camera.sticker.protocol.StickerCategory stickerCategory) throws java.io.IOException {
            if (stickerCategory.id_renamed != null) {
                com.squareup.wire.ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, stickerCategory.id_renamed);
            }
            if (stickerCategory.readableId != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, stickerCategory.readableId);
            }
            if (stickerCategory.name != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, stickerCategory.name);
            }
            com.oplus.camera.sticker.protocol.Sticker.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, stickerCategory.sticker);
            if (stickerCategory.iconPath != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, stickerCategory.iconPath);
            }
            if (stickerCategory.iconMd5 != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, stickerCategory.iconMd5);
            }
            if (stickerCategory.highlightIconPath != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, stickerCategory.highlightIconPath);
            }
            if (stickerCategory.highlightIconMd5 != null) {
                com.squareup.wire.ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, stickerCategory.highlightIconMd5);
            }
            if (stickerCategory.position != null) {
                com.squareup.wire.ProtoAdapter.INT32.encodeWithTag(protoWriter, 9, stickerCategory.position);
            }
            if (stickerCategory.isNew != null) {
                com.squareup.wire.ProtoAdapter.BOOL.encodeWithTag(protoWriter, 10, stickerCategory.isNew);
            }
            protoWriter.writeBytes(stickerCategory.unknownFields());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public com.oplus.camera.sticker.protocol.StickerCategory decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            com.oplus.camera.sticker.protocol.StickerCategory.Builder builder = new com.oplus.camera.sticker.protocol.StickerCategory.Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag != -1) {
                    switch (iNextTag) {
                        case 1:
                            builder.id_renamed(com.squareup.wire.ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 2:
                            builder.readableId(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.name(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.sticker.add(com.oplus.camera.sticker.protocol.Sticker.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            builder.iconPath(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.iconMd5(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.highlightIconPath(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            builder.highlightIconMd5(com.squareup.wire.ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.position(com.squareup.wire.ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 10:
                            builder.isNew(com.squareup.wire.ProtoAdapter.BOOL.decode(protoReader));
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
        public com.oplus.camera.sticker.protocol.StickerCategory redact(com.oplus.camera.sticker.protocol.StickerCategory stickerCategory) {
            com.oplus.camera.sticker.protocol.StickerCategory.Builder builderNewBuilder = stickerCategory.newBuilder();
            com.squareup.wire.internal.Internal.redactElements(builderNewBuilder.sticker, com.oplus.camera.sticker.protocol.Sticker.ADAPTER);
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }
}
