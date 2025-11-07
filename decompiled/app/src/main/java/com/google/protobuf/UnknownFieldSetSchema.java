package com.google.protobuf;

/* loaded from: classes.dex */
class UnknownFieldSetSchema extends com.google.protobuf.UnknownFieldSchema<com.google.protobuf.UnknownFieldSet, com.google.protobuf.UnknownFieldSet.Builder> {
    private final boolean proto3;

    @Override // com.google.protobuf.UnknownFieldSchema
    void makeImmutable(java.lang.Object obj) {
    }

    public UnknownFieldSetSchema(boolean z_renamed) {
        this.proto3 = z_renamed;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    boolean shouldDiscardUnknownFields(com.google.protobuf.Reader reader) {
        return reader.shouldDiscardUnknownFields();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public com.google.protobuf.UnknownFieldSet.Builder newBuilder() {
        return com.google.protobuf.UnknownFieldSet.newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addVarint(com.google.protobuf.UnknownFieldSet.Builder builder, int i_renamed, long j_renamed) {
        builder.mergeField(i_renamed, com.google.protobuf.UnknownFieldSet.Field.newBuilder().addVarint(j_renamed).build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addFixed32(com.google.protobuf.UnknownFieldSet.Builder builder, int i_renamed, int i2) {
        builder.mergeField(i_renamed, com.google.protobuf.UnknownFieldSet.Field.newBuilder().addFixed32(i2).build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addFixed64(com.google.protobuf.UnknownFieldSet.Builder builder, int i_renamed, long j_renamed) {
        builder.mergeField(i_renamed, com.google.protobuf.UnknownFieldSet.Field.newBuilder().addFixed64(j_renamed).build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addLengthDelimited(com.google.protobuf.UnknownFieldSet.Builder builder, int i_renamed, com.google.protobuf.ByteString byteString) {
        builder.mergeField(i_renamed, com.google.protobuf.UnknownFieldSet.Field.newBuilder().addLengthDelimited(byteString).build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addGroup(com.google.protobuf.UnknownFieldSet.Builder builder, int i_renamed, com.google.protobuf.UnknownFieldSet unknownFieldSet) {
        builder.mergeField(i_renamed, com.google.protobuf.UnknownFieldSet.Field.newBuilder().addGroup(unknownFieldSet).build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public com.google.protobuf.UnknownFieldSet toImmutable(com.google.protobuf.UnknownFieldSet.Builder builder) {
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void writeTo(com.google.protobuf.UnknownFieldSet unknownFieldSet, com.google.protobuf.Writer writer) throws java.io.IOException {
        unknownFieldSet.writeTo(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void writeAsMessageSetTo(com.google.protobuf.UnknownFieldSet unknownFieldSet, com.google.protobuf.Writer writer) throws java.io.IOException {
        unknownFieldSet.writeAsMessageSetTo(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public com.google.protobuf.UnknownFieldSet getFromMessage(java.lang.Object obj) {
        return ((com.google.protobuf.GeneratedMessageV3) obj).unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void setToMessage(java.lang.Object obj, com.google.protobuf.UnknownFieldSet unknownFieldSet) {
        ((com.google.protobuf.GeneratedMessageV3) obj).unknownFields = unknownFieldSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public com.google.protobuf.UnknownFieldSet.Builder getBuilderFromMessage(java.lang.Object obj) {
        return ((com.google.protobuf.GeneratedMessageV3) obj).unknownFields.toBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void setBuilderToMessage(java.lang.Object obj, com.google.protobuf.UnknownFieldSet.Builder builder) {
        ((com.google.protobuf.GeneratedMessageV3) obj).unknownFields = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public com.google.protobuf.UnknownFieldSet merge(com.google.protobuf.UnknownFieldSet unknownFieldSet, com.google.protobuf.UnknownFieldSet unknownFieldSet2) {
        return unknownFieldSet.toBuilder().mergeFrom(unknownFieldSet2).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public int getSerializedSize(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.getSerializedSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public int getSerializedSizeAsMessageSet(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.getSerializedSizeAsMessageSet();
    }
}
