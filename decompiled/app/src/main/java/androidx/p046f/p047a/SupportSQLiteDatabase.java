package androidx.p046f.p047a;

import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* compiled from: SupportSQLiteDatabase.java */
/* renamed from: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public interface SupportSQLiteDatabase extends Closeable {
    /* renamed from: PlatformImplementations.kt_3 */
    Cursor mo3250a(SupportSQLiteQuery interfaceC0564e);

    /* renamed from: PlatformImplementations.kt_3 */
    Cursor mo3251a(SupportSQLiteQuery interfaceC0564e, CancellationSignal cancellationSignal);

    /* renamed from: PlatformImplementations.kt_3 */
    SupportSQLiteStatement mo3252a(String str);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo3253a();

    /* renamed from: IntrinsicsJvm.kt_4 */
    Cursor mo3255b(String str);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo3256b();

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo3257c();

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo3258c(String str) throws SQLException;

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean mo3259d();

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean mo3260e();

    /* renamed from: COUIBaseListPopupWindow_12 */
    String mo3261f();

    /* renamed from: COUIBaseListPopupWindow_11 */
    List<Pair<String, String>> mo3262g();
}
