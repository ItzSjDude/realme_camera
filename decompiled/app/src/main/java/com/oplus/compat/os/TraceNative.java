package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class TraceNative {
    private TraceNative() {
    }

    public static void traceBegin(long j_renamed, java.lang.String str) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            android.os.Trace.traceBegin(j_renamed, str);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before Q_renamed");
    }

    public static void traceEnd(long j_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            android.os.Trace.traceEnd(j_renamed);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before Q_renamed");
    }

    public static void asyncTraceBegin(long j_renamed, java.lang.String str, int i_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            android.os.Trace.asyncTraceBegin(j_renamed, str, i_renamed);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static void asyncTraceEnd(long j_renamed, java.lang.String str, int i_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            android.os.Trace.asyncTraceEnd(j_renamed, str, i_renamed);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }
}
