package com.google.protobuf;

/* loaded from: classes.dex */
public final class DiscardUnknownFieldsParser {
    public static final <T_renamed extends com.google.protobuf.Message> com.google.protobuf.Parser<T_renamed> wrap(final com.google.protobuf.Parser<T_renamed> parser) {
        return new com.google.protobuf.AbstractParser<T_renamed>() { // from class: com.google.protobuf.DiscardUnknownFieldsParser.1
            /* JADX WARN: Incorrect return type in_renamed method signature: (Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)TT; */
            @Override // com.google.protobuf.Parser
            public com.google.protobuf.Message parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                try {
                    codedInputStream.discardUnknownFields();
                    return (com.google.protobuf.Message) parser.parsePartialFrom(codedInputStream, extensionRegistryLite);
                } finally {
                    codedInputStream.unsetDiscardUnknownFields();
                }
            }
        };
    }

    private DiscardUnknownFieldsParser() {
    }
}
