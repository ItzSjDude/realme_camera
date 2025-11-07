package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* loaded from: classes.dex */
public final class TimestampProto {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\OplusGLSurfaceView_11\u001fgoogle/protobuf/timestamp.proto\u0012\u000fgoogle.protobuf\"+\OplusGLSurfaceView_11\tTimestamp\u0012\u000f\OplusGLSurfaceView_11\u0007seconds\u0018\u0001 \u0001(\u0003\u0012\r\OplusGLSurfaceView_11\u0005nanos\u0018\u0002 \u0001(\u0005B~\OplusGLSurfaceView_11\u0013com.google.protobufB\u000eTimestampProtoP\u0001Z+github.com/golang/protobuf/ptypes/timestampø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* renamed from: internal_static_google_protobuf_Timestamp_descriptor */
    static final Descriptors.Descriptor f9293x9b87e7b5 = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_google_protobuf_Timestamp_fieldAccessorTable */
    static final GeneratedMessageV3.FieldAccessorTable f9294xdc828933 = new GeneratedMessageV3.FieldAccessorTable(f9293x9b87e7b5, new String[]{"Seconds", "Nanos"});

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private TimestampProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
