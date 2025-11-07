package com.oplus.statistics;

/* compiled from: StatisticsExceptionHandler.java */
/* loaded from: classes2.dex */
public class e_renamed implements java.lang.Thread.UncaughtExceptionHandler {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f7718a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.Thread.UncaughtExceptionHandler f7719b = java.lang.Thread.getDefaultUncaughtExceptionHandler();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String b_renamed() {
        return "StatisticsExceptionHandler: get the uncaughtException.";
    }

    public e_renamed(android.content.Context context) {
        this.f7718a = context.getApplicationContext();
    }

    public void a_renamed() {
        if (this == this.f7719b) {
            return;
        }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        com.oplus.statistics.f_renamed.d_renamed.d_renamed("StatisticsExceptionHand", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$e_renamed$o3HXV_hWOdKnGMykj9bFvTPhZ-A_renamed
            @Override // com.oplus.statistics.f_renamed.e_renamed
            public final java.lang.Object get() {
                return com.oplus.statistics.e_renamed.b_renamed();
            }
        });
        java.lang.String strA = a_renamed(th);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (!android.text.TextUtils.isEmpty(strA)) {
            com.oplus.statistics.b_renamed.g_renamed gVar = new com.oplus.statistics.b_renamed.g_renamed(this.f7718a);
            gVar.a_renamed(1);
            gVar.a_renamed(jCurrentTimeMillis);
            gVar.a_renamed(strA);
            com.oplus.statistics.a_renamed.f_renamed.a_renamed(this.f7718a, gVar);
        }
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7719b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private java.lang.String a_renamed(java.lang.Throwable th) {
        java.lang.String string;
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);
        try {
            try {
                th.printStackTrace(printWriter);
                string = stringWriter.toString();
            } catch (java.lang.Exception e_renamed) {
                e_renamed.getClass();
                com.oplus.statistics.f_renamed.d_renamed.a_renamed("StatisticsExceptionHand", new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
                printWriter.close();
                string = null;
            }
            return string;
        } finally {
            printWriter.close();
        }
    }
}
