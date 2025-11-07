package com.google.android.apps.gsa.search.shared.service.proto.nano;

/* loaded from: classes.dex */
public abstract class ServiceEventOuterClass {
    private ServiceEventOuterClass() {
    }

    @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventId.class)
    public static int checkServiceEventIdOrThrow(int i_renamed) {
        if (i_renamed >= 1 && i_renamed <= 10) {
            return i_renamed;
        }
        if (i_renamed >= 12 && i_renamed <= 18) {
            return i_renamed;
        }
        if (i_renamed >= 20 && i_renamed <= 22) {
            return i_renamed;
        }
        if (i_renamed >= 24 && i_renamed <= 27) {
            return i_renamed;
        }
        if (i_renamed >= 29 && i_renamed <= 39) {
            return i_renamed;
        }
        if (i_renamed >= 42 && i_renamed <= 51) {
            return i_renamed;
        }
        if (i_renamed >= 56 && i_renamed <= 85) {
            return i_renamed;
        }
        if (i_renamed >= 87 && i_renamed <= 89) {
            return i_renamed;
        }
        if (i_renamed >= 91 && i_renamed <= 91) {
            return i_renamed;
        }
        if (i_renamed >= 94 && i_renamed <= 108) {
            return i_renamed;
        }
        if (i_renamed >= 110 && i_renamed <= 111) {
            return i_renamed;
        }
        if (i_renamed >= 113 && i_renamed <= 113) {
            return i_renamed;
        }
        if (i_renamed >= 115 && i_renamed <= 123) {
            return i_renamed;
        }
        if (i_renamed >= 126 && i_renamed <= 146) {
            return i_renamed;
        }
        if (i_renamed >= 148 && i_renamed <= 158) {
            return i_renamed;
        }
        if (i_renamed >= 160 && i_renamed <= 160) {
            return i_renamed;
        }
        if (i_renamed >= 162 && i_renamed <= 168) {
            return i_renamed;
        }
        if (i_renamed >= 170 && i_renamed <= 172) {
            return i_renamed;
        }
        if (i_renamed >= 174 && i_renamed <= 174) {
            return i_renamed;
        }
        if (i_renamed >= 176 && i_renamed <= 176) {
            return i_renamed;
        }
        if (i_renamed >= 178 && i_renamed <= 189) {
            return i_renamed;
        }
        if (i_renamed >= 191 && i_renamed <= 207) {
            return i_renamed;
        }
        if (i_renamed >= 210 && i_renamed <= 240) {
            return i_renamed;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(46);
        sb.append(i_renamed);
        sb.append(" is_renamed not a_renamed valid enum ServiceEventId");
        throw new java.lang.IllegalArgumentException(sb.toString());
    }

    @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.gsa.search.shared.service.proto.nano.ServiceEventId.class)
    public static int[] checkServiceEventIdOrThrow(int[] iArr) {
        int[] iArr2 = (int[]) iArr.clone();
        for (int i_renamed : iArr2) {
            checkServiceEventIdOrThrow(i_renamed);
        }
        return iArr2;
    }
}
