package com.google.zxing.client.result;

/* loaded from: classes.dex */
public abstract class ParsedResult {
    private final com.google.zxing.client.result.ParsedResultType type;

    public abstract java.lang.String getDisplayResult();

    protected ParsedResult(com.google.zxing.client.result.ParsedResultType parsedResultType) {
        this.type = parsedResultType;
    }

    public final com.google.zxing.client.result.ParsedResultType getType() {
        return this.type;
    }

    public final java.lang.String toString() {
        return getDisplayResult();
    }

    public static void maybeAppend(java.lang.String str, java.lang.StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n_renamed');
        }
        sb.append(str);
    }

    public static void maybeAppend(java.lang.String[] strArr, java.lang.StringBuilder sb) {
        if (strArr != null) {
            for (java.lang.String str : strArr) {
                maybeAppend(str, sb);
            }
        }
    }
}
