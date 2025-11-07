package com.google.android.apps.gsa.search.shared.service.proto.nano;

/* loaded from: classes.dex */
public abstract class ClientEventOuterClass {
    private ClientEventOuterClass() {
    }

    @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.gsa.search.shared.service.proto.nano.ClientEventId.class)
    public static int checkClientEventIdOrThrow(int i_renamed) {
        if (i_renamed >= 0 && i_renamed <= 7) {
            return i_renamed;
        }
        if (i_renamed >= 9 && i_renamed <= 12) {
            return i_renamed;
        }
        if (i_renamed >= 14 && i_renamed <= 18) {
            return i_renamed;
        }
        if (i_renamed >= 23 && i_renamed <= 25) {
            return i_renamed;
        }
        if (i_renamed >= 27 && i_renamed <= 27) {
            return i_renamed;
        }
        if (i_renamed >= 29 && i_renamed <= 29) {
            return i_renamed;
        }
        if (i_renamed >= 31 && i_renamed <= 49) {
            return i_renamed;
        }
        if (i_renamed >= 51 && i_renamed <= 55) {
            return i_renamed;
        }
        if (i_renamed >= 57 && i_renamed <= 90) {
            return i_renamed;
        }
        if (i_renamed >= 92 && i_renamed <= 100) {
            return i_renamed;
        }
        if (i_renamed >= 103 && i_renamed <= 103) {
            return i_renamed;
        }
        if (i_renamed >= 105 && i_renamed <= 108) {
            return i_renamed;
        }
        if (i_renamed >= 110 && i_renamed <= 158) {
            return i_renamed;
        }
        if (i_renamed >= 160 && i_renamed <= 163) {
            return i_renamed;
        }
        if (i_renamed >= 166 && i_renamed <= 171) {
            return i_renamed;
        }
        if (i_renamed >= 173 && i_renamed <= 175) {
            return i_renamed;
        }
        if (i_renamed >= 178 && i_renamed <= 192) {
            return i_renamed;
        }
        if (i_renamed >= 194 && i_renamed <= 200) {
            return i_renamed;
        }
        if (i_renamed >= 203 && i_renamed <= 216) {
            return i_renamed;
        }
        if (i_renamed >= 218 && i_renamed <= 228) {
            return i_renamed;
        }
        if (i_renamed >= 230 && i_renamed <= 233) {
            return i_renamed;
        }
        if (i_renamed >= 235 && i_renamed <= 251) {
            return i_renamed;
        }
        if (i_renamed >= 253 && i_renamed <= 265) {
            return i_renamed;
        }
        if (i_renamed >= 267 && i_renamed <= 309) {
            return i_renamed;
        }
        if (i_renamed >= 311 && i_renamed <= 348) {
            return i_renamed;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(45);
        sb.append(i_renamed);
        sb.append(" is_renamed not a_renamed valid enum ClientEventId");
        throw new java.lang.IllegalArgumentException(sb.toString());
    }

    @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.android.apps.gsa.search.shared.service.proto.nano.ClientEventId.class)
    public static int[] checkClientEventIdOrThrow(int[] iArr) {
        int[] iArr2 = (int[]) iArr.clone();
        for (int i_renamed : iArr2) {
            checkClientEventIdOrThrow(i_renamed);
        }
        return iArr2;
    }
}
