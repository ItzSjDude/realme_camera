package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* loaded from: classes.dex */
public final class ApiProto {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\OplusGLSurfaceView_11\u0019google/protobuf/api.proto\u0012\u000fgoogle.protobuf\u001a$google/protobuf/source_context.proto\u001a\u001agoogle/protobuf/type.proto\"\u0081\u0002\OplusGLSurfaceView_11\u0003Api\u0012\COUIBaseListPopupWindow_12\OplusGLSurfaceView_11\u0004name\u0018\u0001 \u0001(\t\u0012(\OplusGLSurfaceView_11\u0007methods\u0018\u0002 \u0003(\u000b2\u0017.google.protobuf.Method\u0012(\OplusGLSurfaceView_11\u0007options\u0018\u0003 \u0003(\u000b2\u0017.google.protobuf.Option\u0012\u000f\OplusGLSurfaceView_11\u0007version\u0018\u0004 \u0001(\t\u00126\OplusGLSurfaceView_11\u000esource_context\u0018\u0005 \u0001(\u000b2\u001e.google.protobuf.SourceContext\u0012&\OplusGLSurfaceView_11\u0006mixins\u0018\u0006 \u0003(\u000b2\u0016.google.protobuf.Mixin\u0012'\OplusGLSurfaceView_11\u0006syntax\u0018\u0007 \u0001(\u000e2\u0017.google.protobuf.Syntax\"Õ\u0001\OplusGLSurfaceView_11\u0006Method\u0012\COUIBaseListPopupWindow_12\OplusGLSurfaceView_11\u0004name\u0018\u0001 \u0001(\t\u0012\u0018\OplusGLSurfaceView_11\u0010request_type_url\u0018\u0002 \u0001(\t\u0012\u0019\OplusGLSurfaceView_11\u0011request_streaming\u0018\u0003 \u0001(\IntrinsicsJvm.kt_4\u0012\u0019\OplusGLSurfaceView_11\u0011response_type_url\u0018\u0004 \u0001(\t\u0012\u001a\OplusGLSurfaceView_11\u0012response_streaming\u0018\u0005 \u0001(\IntrinsicsJvm.kt_4\u0012(\OplusGLSurfaceView_11\u0007options\u0018\u0006 \u0003(\u000b2\u0017.google.protobuf.Option\u0012'\OplusGLSurfaceView_11\u0006syntax\u0018\u0007 \u0001(\u000e2\u0017.google.protobuf.Syntax\"#\OplusGLSurfaceView_11\u0005Mixin\u0012\COUIBaseListPopupWindow_12\OplusGLSurfaceView_11\u0004name\u0018\u0001 \u0001(\t\u0012\COUIBaseListPopupWindow_12\OplusGLSurfaceView_11\u0004root\u0018\u0002 \u0001(\tBu\OplusGLSurfaceView_11\u0013com.google.protobufB\bApiProtoP\u0001Z+google.golang.org/genproto/protobuf/api;api¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[]{SourceContextProto.getDescriptor(), TypeProto.getDescriptor()});
    static final Descriptors.Descriptor internal_static_google_protobuf_Api_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_google_protobuf_Api_fieldAccessorTable */
    static final GeneratedMessageV3.FieldAccessorTable f9202x528e536f = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Api_descriptor, new String[]{"Name", "Methods", "Options", "Version", "SourceContext", "Mixins", "Syntax"});
    static final Descriptors.Descriptor internal_static_google_protobuf_Method_descriptor = getDescriptor().getMessageTypes().get(1);

    /* renamed from: internal_static_google_protobuf_Method_fieldAccessorTable */
    static final GeneratedMessageV3.FieldAccessorTable f9203x86480fae = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Method_descriptor, new String[]{"Name", "RequestTypeUrl", "RequestStreaming", "ResponseTypeUrl", "ResponseStreaming", "Options", "Syntax"});
    static final Descriptors.Descriptor internal_static_google_protobuf_Mixin_descriptor = getDescriptor().getMessageTypes().get(2);

    /* renamed from: internal_static_google_protobuf_Mixin_fieldAccessorTable */
    static final GeneratedMessageV3.FieldAccessorTable f9204xf56da668 = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Mixin_descriptor, new String[]{"Name", "Root"});

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private ApiProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SourceContextProto.getDescriptor();
        TypeProto.getDescriptor();
    }
}
