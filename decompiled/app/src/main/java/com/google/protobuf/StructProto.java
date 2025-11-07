package com.google.protobuf;

/* loaded from: classes.dex */
public final class StructProto {
    private static com.google.protobuf.Descriptors.FileDescriptor descriptor = com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new java.lang.String[]{"\n_renamed\u001cgoogle/protobuf/struct.proto\u0012\u000fgoogle.protobuf\"\u0084\u0001\n_renamed\u0006Struct\u00123\n_renamed\u0006fields\u0018\u0001 \u0003(\u000b2#.google.protobuf.Struct.FieldsEntry\u001aE\n_renamed\u000bFieldsEntry\u0012\u000b\n_renamed\u0003key\u0018\u0001 \u0001(\t_renamed\u0012%\n_renamed\u0005value\u0018\u0002 \u0001(\u000b2\u0016.google.protobuf.Value:\u00028\u0001\"ê\u0001\n_renamed\u0005Value\u00120\n_renamed\nnull_value\u0018\u0001 \u0001(\u000e2\u001a.google.protobuf.NullValueH\u0000\u0012\u0016\n_renamed\fnumber_value\u0018\u0002 \u0001(\u0001H\u0000\u0012\u0016\n_renamed\fstring_value\u0018\u0003 \u0001(\tH\u0000\u0012\u0014\n_renamed\nbool_value\u0018\u0004 \u0001(\bH_renamed\u0000\u0012/\n_renamed\fstruct_value\u0018\u0005 \u0001(\u000b2\u0017.google.protobuf.StructH\u0000\u00120\n_renamed\nlist_value\u0018\u0006 \u0001(\u000b2\u001a.google.protobuf.ListValueH\u0000B\u0006\n_renamed\u0004kind\"3\n_renamed\tListValue\u0012&\n_renamed\u0006values\u0018\u0001 \u0003(\u000b2\u0016.google.protobuf.Value*\u001b\n_renamed\tNullValue\u0012\u000e\n_renamed\nNULL_VALUE\u0010\u0000B\u0081\u0001\n_renamed\u0013com.google.protobufB\u000bStructProtoP\u0001Z1github.com/golang/protobuf/ptypes/struct;structpbø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new com.google.protobuf.Descriptors.FileDescriptor[0]);
    static final com.google.protobuf.Descriptors.Descriptor internal_static_google_protobuf_Struct_descriptor = getDescriptor().getMessageTypes().get(0);
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Struct_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Struct_descriptor, new java.lang.String[]{"Fields"});
    static final com.google.protobuf.Descriptors.Descriptor internal_static_google_protobuf_Struct_FieldsEntry_descriptor = internal_static_google_protobuf_Struct_descriptor.getNestedTypes().get(0);
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Struct_FieldsEntry_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Struct_FieldsEntry_descriptor, new java.lang.String[]{"Key", "Value"});
    static final com.google.protobuf.Descriptors.Descriptor internal_static_google_protobuf_Value_descriptor = getDescriptor().getMessageTypes().get(1);
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Value_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Value_descriptor, new java.lang.String[]{"NullValue", "NumberValue", "StringValue", "BoolValue", "StructValue", "ListValue", "Kind"});
    static final com.google.protobuf.Descriptors.Descriptor internal_static_google_protobuf_ListValue_descriptor = getDescriptor().getMessageTypes().get(2);
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_ListValue_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_ListValue_descriptor, new java.lang.String[]{"Values"});

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) {
    }

    private StructProto() {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry extensionRegistry) {
        registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) extensionRegistry);
    }

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
