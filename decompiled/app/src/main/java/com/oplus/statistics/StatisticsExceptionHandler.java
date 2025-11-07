package com.oplus.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.statistics.p199a.ExceptionAgent;
import com.oplus.statistics.p200b.ExceptionBean;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.Supplier;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* compiled from: StatisticsExceptionHandler.java */
/* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class StatisticsExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f23879a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Thread.UncaughtExceptionHandler f23880b = Thread.getDefaultUncaughtExceptionHandler();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ String m25387b() {
        return "StatisticsExceptionHandler: get the uncaughtException.";
    }

    public StatisticsExceptionHandler(Context context) {
        this.f23879a = context.getApplicationContext();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25388a() {
        if (this == this.f23880b) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        LogUtil.m25433d("StatisticsExceptionHand", new Supplier() { // from class: com.oplus.statistics.-$$Lambda$COUIBaseListPopupWindow_8$o3HXV_hWOdKnGMykj9bFvTPhZ-A
            @Override // com.oplus.statistics.p204f.Supplier
            public final Object get() {
                return StatisticsExceptionHandler.m25387b();
            }
        });
        String strM25386a = m25386a(th);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(strM25386a)) {
            ExceptionBean c3727g = new ExceptionBean(this.f23879a);
            c3727g.m25291a(1);
            c3727g.m25292a(jCurrentTimeMillis);
            c3727g.m25293a(strM25386a);
            ExceptionAgent.m25223a(this.f23879a, c3727g);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f23880b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m25386a(Throwable th) {
        String string;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            try {
                th.printStackTrace(printWriter);
                string = stringWriter.toString();
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.getClass();
                LogUtil.m25428a("StatisticsExceptionHand", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
                printWriter.close();
                string = null;
            }
            return string;
        } finally {
            printWriter.close();
        }
    }
}
