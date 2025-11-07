package com.google.protobuf;

/* loaded from: classes.dex */
public final class ApiProto {
    private static com.google.protobuf.Descriptors.FileDescriptor descriptor = com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new java.lang.String[]{"\n_renamed\u0019google/protobuf/api.proto\u0012\u000fgoogle.protobuf\u001a$google/protobuf/source_context.proto\u001a\u001agoogle/protobuf/type.proto\"\u0081\u0002\n_renamed\u0003Api\u0012\f_renamed\n_renamed\u0004name\u0018\u0001 \u0001(\t_renamed\u0012(\n_renamed\u0007methods\u0018\u0002 \u0003(\u000b2\u0017.google.protobuf.Method\u0012(\n_renamed\u0007options\u0018\u0003 \u0003(\u000b2\u0017.google.protobuf.Option\u0012\u000f\n_renamed\u0007version\u0018\u0004 \u0001(\t_renamed\u00126\n_renamed\u000esource_context\u0018\u0005 \u0001(\u000b2\u001e.google.protobuf.SourceContext\u0012&\n_renamed\u0006mixins\u0018\u0006 \u0003(\u000b2\u0016.google.protobuf.Mixin\u0012'\n_renamed\u0006syntax\u0018\u0007 \u0001(\u000e2\u0017.google.protobuf.Syntax\"Õ\u0001\n_renamed\u0006Method\u0012\f_renamed\n_renamed\u0004name\u0018\u0001 \u0001(\t_renamed\u0012\u0018\n_renamed\u0010request_type_url\u0018\u0002 \u0001(\t_renamed\u0012\u0019\n_renamed\u0011request_streaming\u0018\u0003 \u0001(\b_renamed\u0012\u0019\n_renamed\u0011response_type_url\u0018\u0004 \u0001(\t_renamed\u0012\u001a\n_renamed\u0012response_streaming\u0018\u0005 \u0001(\b_renamed\u0012(\n_renamed\u0007options\u0018\u0006 \u0003(\u000b2\u0017.google.protobuf.Option\u0012'\n_renamed\u0006syntax\u0018\u0007 \u0001(\u000e2\u0017.google.protobuf.Syntax\"#\n_renamed\u0005Mixin\u0012\f_renamed\n_renamed\u0004name\u0018\u0001 \u0001(\t_renamed\u0012\f_renamed\n_renamed\u0004root\u0018\u0002 \u0001(\tBu\n_renamed\u0013com.google.protobufB\bApiProtoP\u0001Z+google.golang.org/genproto/protobuf/api;api¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new com.google.protobuf.Descriptors.FileDescriptor[]{com.google.protobuf.SourceContextProto.getDescriptor(), com.google.protobuf.TypeProto.getDescriptor()});
    static final com.google.protobuf.Descriptors.Descriptor internal_static_google_protobuf_Api_descriptor = getDescriptor().getMessageTypes().get(0);
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Api_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Api_descriptor, new java.lang.String[]{"Name", "Methods", "Options", "Version", "SourceContext", "Mixins", "Syntax"});
    static final com.google.protobuf.Descriptors.Descriptor internal_static_google_protobuf_Method_descriptor = getDescriptor().getMessageTypes().get(1);
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Method_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Method_descriptor, new java.lang.String[]{"Name", "RequestTypeUrl", "RequestStreaming", "ResponseTypeUrl", "ResponseStreaming", "Options", "Syntax"});
    static final com.google.protobuf.Descriptors.Descriptor internal_static_google_protobuf_Mixin_descriptor = getDescriptor().getMessageTypes().get(2);
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Mixin_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Mixin_descriptor, new java.lang.String[]{"Name", "Root"});

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) {
    }

    private ApiProto() {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry extensionRegistry) {
        registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) extensionRegistry);
    }

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        com.google.protobuf.SourceContextProto.getDescriptor();
        com.google.protobuf.TypeProto.getDescriptor();
    }
}
