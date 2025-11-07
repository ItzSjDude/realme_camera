package androidx.core.p035g;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter.java */
@Deprecated
/* renamed from: androidx.core.COUIBaseListPopupWindow_11.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class LogWriter extends Writer {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f2935a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private StringBuilder f2936b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f2935a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m2528a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        m2528a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int OplusGLSurfaceView_13, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[OplusGLSurfaceView_13 + i3];
            if (c2 == '\OplusGLSurfaceView_11') {
                m2528a();
            } else {
                this.f2936b.append(c2);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2528a() {
        if (this.f2936b.length() > 0) {
            Log.IntrinsicsJvm.kt_5(this.f2935a, this.f2936b.toString());
            StringBuilder sb = this.f2936b;
            sb.delete(0, sb.length());
        }
    }
}
