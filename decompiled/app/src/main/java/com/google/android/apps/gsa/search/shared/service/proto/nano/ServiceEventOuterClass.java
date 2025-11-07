package com.google.android.apps.gsa.search.shared.service.proto.nano;

import com.google.protobuf.nano.NanoEnumValue;

/* loaded from: classes.dex */
public abstract class ServiceEventOuterClass {
    private ServiceEventOuterClass() {
    }

    @NanoEnumValue(legacy = false, value = ServiceEventId.class)
    public static int checkServiceEventIdOrThrow(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 >= 1 && OplusGLSurfaceView_13 <= 10) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 12 && OplusGLSurfaceView_13 <= 18) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 20 && OplusGLSurfaceView_13 <= 22) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 24 && OplusGLSurfaceView_13 <= 27) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 29 && OplusGLSurfaceView_13 <= 39) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 42 && OplusGLSurfaceView_13 <= 51) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 56 && OplusGLSurfaceView_13 <= 85) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 87 && OplusGLSurfaceView_13 <= 89) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 91 && OplusGLSurfaceView_13 <= 91) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 94 && OplusGLSurfaceView_13 <= 108) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 110 && OplusGLSurfaceView_13 <= 111) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 113 && OplusGLSurfaceView_13 <= 113) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 115 && OplusGLSurfaceView_13 <= 123) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 126 && OplusGLSurfaceView_13 <= 146) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 148 && OplusGLSurfaceView_13 <= 158) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 160 && OplusGLSurfaceView_13 <= 160) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 162 && OplusGLSurfaceView_13 <= 168) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 170 && OplusGLSurfaceView_13 <= 172) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 174 && OplusGLSurfaceView_13 <= 174) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 176 && OplusGLSurfaceView_13 <= 176) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 178 && OplusGLSurfaceView_13 <= 189) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 191 && OplusGLSurfaceView_13 <= 207) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 210 && OplusGLSurfaceView_13 <= 240) {
            return OplusGLSurfaceView_13;
        }
        StringBuilder sb = new StringBuilder(46);
        sb.append(OplusGLSurfaceView_13);
        sb.append(" is not PlatformImplementations.kt_3 valid enum ServiceEventId");
        throw new IllegalArgumentException(sb.toString());
    }

    @NanoEnumValue(legacy = false, value = ServiceEventId.class)
    public static int[] checkServiceEventIdOrThrow(int[] iArr) {
        int[] iArr2 = (int[]) iArr.clone();
        for (int OplusGLSurfaceView_13 : iArr2) {
            checkServiceEventIdOrThrow(OplusGLSurfaceView_13);
        }
        return iArr2;
    }
}
