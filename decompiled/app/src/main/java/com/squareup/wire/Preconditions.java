package com.squareup.wire;

/* loaded from: classes2.dex */
final class Preconditions {
    private Preconditions() {
    }

    static void checkNotNull(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            throw new java.lang.NullPointerException(str);
        }
    }
}
