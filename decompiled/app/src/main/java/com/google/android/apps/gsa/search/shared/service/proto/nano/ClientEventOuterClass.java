package com.google.android.apps.gsa.search.shared.service.proto.nano;

import com.google.protobuf.nano.NanoEnumValue;

/* loaded from: classes.dex */
public abstract class ClientEventOuterClass {
    private ClientEventOuterClass() {
    }

    @NanoEnumValue(legacy = false, value = ClientEventId.class)
    public static int checkClientEventIdOrThrow(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 7) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 9 && OplusGLSurfaceView_13 <= 12) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 14 && OplusGLSurfaceView_13 <= 18) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 23 && OplusGLSurfaceView_13 <= 25) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 27 && OplusGLSurfaceView_13 <= 27) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 29 && OplusGLSurfaceView_13 <= 29) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 31 && OplusGLSurfaceView_13 <= 49) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 51 && OplusGLSurfaceView_13 <= 55) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 57 && OplusGLSurfaceView_13 <= 90) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 92 && OplusGLSurfaceView_13 <= 100) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 103 && OplusGLSurfaceView_13 <= 103) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 105 && OplusGLSurfaceView_13 <= 108) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 110 && OplusGLSurfaceView_13 <= 158) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 160 && OplusGLSurfaceView_13 <= 163) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 166 && OplusGLSurfaceView_13 <= 171) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 173 && OplusGLSurfaceView_13 <= 175) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 178 && OplusGLSurfaceView_13 <= 192) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 194 && OplusGLSurfaceView_13 <= 200) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 203 && OplusGLSurfaceView_13 <= 216) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 218 && OplusGLSurfaceView_13 <= 228) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 230 && OplusGLSurfaceView_13 <= 233) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 235 && OplusGLSurfaceView_13 <= 251) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 253 && OplusGLSurfaceView_13 <= 265) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 267 && OplusGLSurfaceView_13 <= 309) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 >= 311 && OplusGLSurfaceView_13 <= 348) {
            return OplusGLSurfaceView_13;
        }
        StringBuilder sb = new StringBuilder(45);
        sb.append(OplusGLSurfaceView_13);
        sb.append(" is not PlatformImplementations.kt_3 valid enum ClientEventId");
        throw new IllegalArgumentException(sb.toString());
    }

    @NanoEnumValue(legacy = false, value = ClientEventId.class)
    public static int[] checkClientEventIdOrThrow(int[] iArr) {
        int[] iArr2 = (int[]) iArr.clone();
        for (int OplusGLSurfaceView_13 : iArr2) {
            checkClientEventIdOrThrow(OplusGLSurfaceView_13);
        }
        return iArr2;
    }
}
