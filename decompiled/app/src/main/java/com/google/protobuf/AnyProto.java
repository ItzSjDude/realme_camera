package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* loaded from: classes.dex */
public final class AnyProto {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\OplusGLSurfaceView_11\u0019google/protobuf/any.proto\u0012\u000fgoogle.protobuf\"&\OplusGLSurfaceView_11\u0003Any\u0012\u0010\OplusGLSurfaceView_11\btype_url\u0018\u0001 \u0001(\t\u0012\r\OplusGLSurfaceView_11\u0005value\u0018\u0002 \u0001(\fBo\OplusGLSurfaceView_11\u0013com.google.protobufB\bAnyProtoP\u0001Z%github.com/golang/protobuf/ptypes/any¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    static final Descriptors.Descriptor internal_static_google_protobuf_Any_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_google_protobuf_Any_fieldAccessorTable */
    static final GeneratedMessageV3.FieldAccessorTable f9201xb379ce5d = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Any_descriptor, new String[]{"TypeUrl", "Value"});

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private AnyProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
