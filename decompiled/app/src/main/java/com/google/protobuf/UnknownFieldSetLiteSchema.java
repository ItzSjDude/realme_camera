package com.google.protobuf;

/* loaded from: classes.dex */
class UnknownFieldSetLiteSchema extends com.google.protobuf.UnknownFieldSchema<com.google.protobuf.UnknownFieldSetLite, com.google.protobuf.UnknownFieldSetLite> {
    @Override // com.google.protobuf.UnknownFieldSchema
    boolean shouldDiscardUnknownFields(com.google.protobuf.Reader reader) {
        return false;
    }

    UnknownFieldSetLiteSchema() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public com.google.protobuf.UnknownFieldSetLite newBuilder() {
        return com.google.protobuf.UnknownFieldSetLite.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addVarint(com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite, int i_renamed, long j_renamed) {
        unknownFieldSetLite.storeField(com.google.protobuf.WireFormat.makeTag(i_renamed, 0), java.lang.Long.valueOf(j_renamed));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addFixed32(com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite, int i_renamed, int i2) {
        unknownFieldSetLite.storeField(com.google.protobuf.WireFormat.makeTag(i_renamed, 5), java.lang.Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addFixed64(com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite, int i_renamed, long j_renamed) {
        unknownFieldSetLite.storeField(com.google.protobuf.WireFormat.makeTag(i_renamed, 1), java.lang.Long.valueOf(j_renamed));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addLengthDelimited(com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite, int i_renamed, com.google.protobuf.ByteString byteString) {
        unknownFieldSetLite.storeField(com.google.protobuf.WireFormat.makeTag(i_renamed, 2), byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addGroup(com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite, int i_renamed, com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.storeField(com.google.protobuf.WireFormat.makeTag(i_renamed, 3), unknownFieldSetLite2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public com.google.protobuf.UnknownFieldSetLite toImmutable(com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite) {
        unknownFieldSetLite.makeImmutable();
        return unknownFieldSetLite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void setToMessage(java.lang.Object obj, com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite) {
        ((com.google.protobuf.GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public com.google.protobuf.UnknownFieldSetLite getFromMessage(java.lang.Object obj) {
        return ((com.google.protobuf.GeneratedMessageLite) obj).unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public com.google.protobuf.UnknownFieldSetLite getBuilderFromMessage(java.lang.Object obj) {
        com.google.protobuf.UnknownFieldSetLite fromMessage = getFromMessage(obj);
        if (fromMessage != com.google.protobuf.UnknownFieldSetLite.getDefaultInstance()) {
            return fromMessage;
        }
        com.google.protobuf.UnknownFieldSetLite unknownFieldSetLiteNewInstance = com.google.protobuf.UnknownFieldSetLite.newInstance();
        setToMessage(obj, unknownFieldSetLiteNewInstance);
        return unknownFieldSetLiteNewInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void setBuilderToMessage(java.lang.Object obj, com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite) {
        setToMessage(obj, unknownFieldSetLite);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    void makeImmutable(java.lang.Object obj) {
        getFromMessage(obj).makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void writeTo(com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite, com.google.protobuf.Writer writer) throws java.io.IOException {
        unknownFieldSetLite.writeTo(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void writeAsMessageSetTo(com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite, com.google.protobuf.Writer writer) throws java.io.IOException {
        unknownFieldSetLite.writeAsMessageSetTo(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public com.google.protobuf.UnknownFieldSetLite merge(com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite, com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite2) {
        return unknownFieldSetLite2.equals(com.google.protobuf.UnknownFieldSetLite.getDefaultInstance()) ? unknownFieldSetLite : com.google.protobuf.UnknownFieldSetLite.mutableCopyOf(unknownFieldSetLite, unknownFieldSetLite2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public int getSerializedSize(com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public int getSerializedSizeAsMessageSet(com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSizeAsMessageSet();
    }
}
