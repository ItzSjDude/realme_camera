package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* loaded from: classes.dex */
public final class DurationProto {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\OplusGLSurfaceView_11\u001egoogle/protobuf/duration.proto\u0012\u000fgoogle.protobuf\"*\OplusGLSurfaceView_11\bDuration\u0012\u000f\OplusGLSurfaceView_11\u0007seconds\u0018\u0001 \u0001(\u0003\u0012\r\OplusGLSurfaceView_11\u0005nanos\u0018\u0002 \u0001(\u0005B|\OplusGLSurfaceView_11\u0013com.google.protobufB\rDurationProtoP\u0001Z*github.com/golang/protobuf/ptypes/durationø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* renamed from: internal_static_google_protobuf_Duration_descriptor */
    static final Descriptors.Descriptor f9268x370461dd = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_google_protobuf_Duration_fieldAccessorTable */
    static final GeneratedMessageV3.FieldAccessorTable f9269x3965b5b = new GeneratedMessageV3.FieldAccessorTable(f9268x370461dd, new String[]{"Seconds", "Nanos"});

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private DurationProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
