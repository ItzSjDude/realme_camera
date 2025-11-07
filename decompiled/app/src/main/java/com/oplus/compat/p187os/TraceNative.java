package com.oplus.compat.p187os;

import android.os.Trace;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;

/* loaded from: classes2.dex */
public class TraceNative {
    private TraceNative() {
    }

    public static void traceBegin(long OplusGLSurfaceView_15, String str) throws UnSupportedApiVersionException {
        if (VersionUtils.m24889e()) {
            Trace.traceBegin(OplusGLSurfaceView_15, str);
            return;
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public static void traceEnd(long OplusGLSurfaceView_15) throws UnSupportedApiVersionException {
        if (VersionUtils.m24889e()) {
            Trace.traceEnd(OplusGLSurfaceView_15);
            return;
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public static void asyncTraceBegin(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13) throws UnSupportedApiVersionException {
        if (VersionUtils.m24889e()) {
            Trace.asyncTraceBegin(OplusGLSurfaceView_15, str, OplusGLSurfaceView_13);
            return;
        }
        throw new UnSupportedApiVersionException();
    }

    public static void asyncTraceEnd(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13) throws UnSupportedApiVersionException {
        if (VersionUtils.m24889e()) {
            Trace.asyncTraceEnd(OplusGLSurfaceView_15, str, OplusGLSurfaceView_13);
            return;
        }
        throw new UnSupportedApiVersionException();
    }
}
