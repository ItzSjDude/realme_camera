package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* loaded from: classes.dex */
public final class StructProto {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\OplusGLSurfaceView_11\u001cgoogle/protobuf/struct.proto\u0012\u000fgoogle.protobuf\"\u0084\u0001\OplusGLSurfaceView_11\u0006Struct\u00123\OplusGLSurfaceView_11\u0006fields\u0018\u0001 \u0003(\u000b2#.google.protobuf.Struct.FieldsEntry\u001aE\OplusGLSurfaceView_11\u000bFieldsEntry\u0012\u000b\OplusGLSurfaceView_11\u0003key\u0018\u0001 \u0001(\t\u0012%\OplusGLSurfaceView_11\u0005value\u0018\u0002 \u0001(\u000b2\u0016.google.protobuf.Value:\u00028\u0001\"ê\u0001\OplusGLSurfaceView_11\u0005Value\u00120\OplusGLSurfaceView_11\nnull_value\u0018\u0001 \u0001(\u000e2\u001a.google.protobuf.NullValueH\u0000\u0012\u0016\OplusGLSurfaceView_11\fnumber_value\u0018\u0002 \u0001(\u0001H\u0000\u0012\u0016\OplusGLSurfaceView_11\fstring_value\u0018\u0003 \u0001(\tH\u0000\u0012\u0014\OplusGLSurfaceView_11\nbool_value\u0018\u0004 \u0001(\bH\u0000\u0012/\OplusGLSurfaceView_11\fstruct_value\u0018\u0005 \u0001(\u000b2\u0017.google.protobuf.StructH\u0000\u00120\OplusGLSurfaceView_11\nlist_value\u0018\u0006 \u0001(\u000b2\u001a.google.protobuf.ListValueH\u0000B\u0006\OplusGLSurfaceView_11\u0004kind\"3\OplusGLSurfaceView_11\tListValue\u0012&\OplusGLSurfaceView_11\u0006values\u0018\u0001 \u0003(\u000b2\u0016.google.protobuf.Value*\u001b\OplusGLSurfaceView_11\tNullValue\u0012\u000e\OplusGLSurfaceView_11\nNULL_VALUE\u0010\u0000B\u0081\u0001\OplusGLSurfaceView_11\u0013com.google.protobufB\u000bStructProtoP\u0001Z1github.com/golang/protobuf/ptypes/struct;structpbø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    static final Descriptors.Descriptor internal_static_google_protobuf_Struct_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_google_protobuf_Struct_fieldAccessorTable */
    static final GeneratedMessageV3.FieldAccessorTable f9290x86da683a = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Struct_descriptor, new String[]{"Fields"});

    /* renamed from: internal_static_google_protobuf_Struct_FieldsEntry_descriptor */
    static final Descriptors.Descriptor f9288xdbaa8122 = internal_static_google_protobuf_Struct_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_google_protobuf_Struct_FieldsEntry_fieldAccessorTable */
    static final GeneratedMessageV3.FieldAccessorTable f9289xe21f65a0 = new GeneratedMessageV3.FieldAccessorTable(f9288xdbaa8122, new String[]{"Key", "Value"});
    static final Descriptors.Descriptor internal_static_google_protobuf_Value_descriptor = getDescriptor().getMessageTypes().get(1);

    /* renamed from: internal_static_google_protobuf_Value_fieldAccessorTable */
    static final GeneratedMessageV3.FieldAccessorTable f9291xa4251b78 = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Value_descriptor, new String[]{"NullValue", "NumberValue", "StringValue", "BoolValue", "StructValue", "ListValue", "Kind"});

    /* renamed from: internal_static_google_protobuf_ListValue_descriptor */
    static final Descriptors.Descriptor f9286x4f074138 = getDescriptor().getMessageTypes().get(2);

    /* renamed from: internal_static_google_protobuf_ListValue_fieldAccessorTable */
    static final GeneratedMessageV3.FieldAccessorTable f9287x4a9dafb6 = new GeneratedMessageV3.FieldAccessorTable(f9286x4f074138, new String[]{"Values"});

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private StructProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
