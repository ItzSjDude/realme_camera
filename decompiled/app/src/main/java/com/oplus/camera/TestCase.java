package com.oplus.camera;

/* compiled from: CameraLog.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Long f4408a = 1L;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f4409b = true;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static boolean f4410c = true;

    private static java.lang.String c_renamed(java.lang.String str) {
        return str == null ? "OplusCamera" : str;
    }

    public static void a_renamed(android.content.Context context) {
        try {
            f4409b = com.oplus.compat.os.SystemPropertiesNative.getBoolean("persist.sys.assert.panic", false);
        } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e_renamed) {
            e_renamed.printStackTrace();
        }
        f4410c = com.oplus.camera.sticker.c_renamed.d_renamed.e_renamed(context);
        com.oplus.ocs.camera.CameraUnitClient.initLog(context);
    }

    public static void a_renamed(java.lang.String str, java.lang.String str2) {
        if (f4409b) {
            android.util.Log.v_renamed(c_renamed(str), str2);
        }
    }

    public static void a_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (f4409b) {
            android.util.Log.v_renamed(c_renamed(str), str2, th);
        }
    }

    public static void b_renamed(java.lang.String str, java.lang.String str2) {
        if (f4409b) {
            android.util.Log.d_renamed(c_renamed(str), str2);
        }
    }

    public static void c_renamed(java.lang.String str, java.lang.String str2) {
        if (f4409b) {
            android.util.Log.i_renamed(c_renamed(str), str2);
        }
    }

    public static void b_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (f4409b) {
            android.util.Log.i_renamed(c_renamed(str), str2, th);
        }
    }

    public static void a_renamed(java.lang.String str) {
        if (f4410c) {
            a_renamed("OplusCamera_TRACE", "traceBeginSection, msg: " + str);
            try {
                com.oplus.compat.os.TraceNative.traceBegin(f4408a.longValue(), str);
            } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e_renamed) {
                e_renamed.printStackTrace();
            } catch (java.lang.Throwable unused) {
                f_renamed("OplusCamera", "reflect error");
            }
        }
    }

    public static void a_renamed(java.lang.String str, java.lang.String str2, long j_renamed) {
        if (f4410c) {
            a_renamed("OplusCamera_TRACE", "traceBeginSection, msg: " + str);
            try {
                java.lang.String str3 = "O_" + str2;
                if (j_renamed == 0) {
                    j_renamed = com.oplus.camera.d_renamed.d_renamed.longValue();
                }
                android.os.Trace.setCounter(str3, j_renamed);
                com.oplus.compat.os.TraceNative.traceBegin(f4408a.longValue(), str);
            } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e_renamed) {
                e_renamed.printStackTrace();
            } catch (java.lang.Throwable unused) {
                f_renamed("OplusCamera", "reflect error");
            }
        }
    }

    public static void b_renamed(java.lang.String str) {
        if (f4410c) {
            a_renamed("OplusCamera_TRACE", "traceEndSection, msg: " + str);
            try {
                com.oplus.compat.os.TraceNative.traceEnd(f4408a.longValue());
            } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e_renamed) {
                e_renamed.printStackTrace();
            } catch (java.lang.Throwable unused) {
                f_renamed("OplusCamera", "reflect error");
            }
        }
    }

    public static void d_renamed(java.lang.String str, java.lang.String str2) {
        if (f4410c) {
            a_renamed("OplusCamera_TRACE", "traceEndSection, msg: " + str);
            try {
                android.os.Trace.setCounter("O_" + str2, com.oplus.camera.d_renamed.f_renamed.longValue());
                com.oplus.compat.os.TraceNative.traceEnd(f4408a.longValue());
            } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e_renamed) {
                e_renamed.printStackTrace();
            } catch (java.lang.Throwable unused) {
                f_renamed("OplusCamera", "reflect error");
            }
        }
    }

    public static void a_renamed(java.lang.String str, android.os.Handler handler, java.lang.String str2) {
        if (f4409b) {
            if (handler == null) {
                android.util.Log.e_renamed(c_renamed(str), "dumpHandlerMsg, handler is_renamed null!");
            } else {
                handler.dump(new android.util.LogPrinter(6, "handler info"), str2);
            }
        }
    }

    public static void e_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.w_renamed(c_renamed(str), str2);
    }

    public static void c_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.w_renamed(c_renamed(str), str2, th);
    }

    public static void f_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.e_renamed(c_renamed(str), str2);
    }

    public static void d_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.e_renamed(c_renamed(str), str2, th);
    }

    public static boolean a_renamed() {
        return f4409b;
    }
}
