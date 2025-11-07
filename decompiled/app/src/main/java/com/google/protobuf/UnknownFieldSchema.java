package com.google.protobuf;

/* loaded from: classes.dex */
abstract class UnknownFieldSchema<T_renamed, B_renamed> {
    abstract void addFixed32(B_renamed b2, int i_renamed, int i2);

    abstract void addFixed64(B_renamed b2, int i_renamed, long j_renamed);

    abstract void addGroup(B_renamed b2, int i_renamed, T_renamed t_renamed);

    abstract void addLengthDelimited(B_renamed b2, int i_renamed, com.google.protobuf.ByteString byteString);

    abstract void addVarint(B_renamed b2, int i_renamed, long j_renamed);

    abstract B_renamed getBuilderFromMessage(java.lang.Object obj);

    abstract T_renamed getFromMessage(java.lang.Object obj);

    abstract int getSerializedSize(T_renamed t_renamed);

    abstract int getSerializedSizeAsMessageSet(T_renamed t_renamed);

    abstract void makeImmutable(java.lang.Object obj);

    abstract T_renamed merge(T_renamed t_renamed, T_renamed t2);

    abstract B_renamed newBuilder();

    abstract void setBuilderToMessage(java.lang.Object obj, B_renamed b2);

    abstract void setToMessage(java.lang.Object obj, T_renamed t_renamed);

    abstract boolean shouldDiscardUnknownFields(com.google.protobuf.Reader reader);

    abstract T_renamed toImmutable(B_renamed b2);

    abstract void writeAsMessageSetTo(T_renamed t_renamed, com.google.protobuf.Writer writer) throws java.io.IOException;

    abstract void writeTo(T_renamed t_renamed, com.google.protobuf.Writer writer) throws java.io.IOException;

    UnknownFieldSchema() {
    }

    final boolean mergeOneFieldFrom(B_renamed b2, com.google.protobuf.Reader reader) throws java.io.IOException {
        int tag = reader.getTag();
        int tagFieldNumber = com.google.protobuf.WireFormat.getTagFieldNumber(tag);
        int tagWireType = com.google.protobuf.WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            addVarint(b2, tagFieldNumber, reader.readInt64());
            return true;
        }
        if (tagWireType == 1) {
            addFixed64(b2, tagFieldNumber, reader.readFixed64());
            return true;
        }
        if (tagWireType == 2) {
            addLengthDelimited(b2, tagFieldNumber, reader.readBytes());
            return true;
        }
        if (tagWireType != 3) {
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                addFixed32(b2, tagFieldNumber, reader.readFixed32());
                return true;
            }
            throw com.google.protobuf.InvalidProtocolBufferException.invalidWireType();
        }
        B_renamed bNewBuilder = newBuilder();
        int iMakeTag = com.google.protobuf.WireFormat.makeTag(tagFieldNumber, 4);
        mergeFrom(bNewBuilder, reader);
        if (iMakeTag != reader.getTag()) {
            throw com.google.protobuf.InvalidProtocolBufferException.invalidEndTag();
        }
        addGroup(b2, tagFieldNumber, toImmutable(bNewBuilder));
        return true;
    }

    final void mergeFrom(B_renamed b2, com.google.protobuf.Reader reader) throws java.io.IOException {
        while (reader.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(b2, reader)) {
        }
    }
}
