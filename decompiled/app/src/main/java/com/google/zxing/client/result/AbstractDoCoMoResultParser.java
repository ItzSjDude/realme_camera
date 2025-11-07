package com.google.zxing.client.result;

/* loaded from: classes.dex */
abstract class AbstractDoCoMoResultParser extends com.google.zxing.client.result.ResultParser {
    AbstractDoCoMoResultParser() {
    }

    static java.lang.String[] matchDoCoMoPrefixedField(java.lang.String str, java.lang.String str2, boolean z_renamed) {
        return matchPrefixedField(str, str2, ';', z_renamed);
    }

    static java.lang.String matchSingleDoCoMoPrefixedField(java.lang.String str, java.lang.String str2, boolean z_renamed) {
        return matchSinglePrefixedField(str, str2, ';', z_renamed);
    }
}
