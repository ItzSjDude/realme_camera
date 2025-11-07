package androidx.p046f.p047a.p048a;

import android.database.sqlite.SQLiteProgram;
import androidx.p046f.p047a.SupportSQLiteProgram;

/* compiled from: FrameworkSQLiteProgram.java */
/* renamed from: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
class FrameworkSQLiteProgram implements SupportSQLiteProgram {

    /* renamed from: PlatformImplementations.kt_3 */
    private final SQLiteProgram f3369a;

    FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.f3369a = sQLiteProgram;
    }

    @Override // androidx.p046f.p047a.SupportSQLiteProgram
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3271a(int OplusGLSurfaceView_13) {
        this.f3369a.bindNull(OplusGLSurfaceView_13);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteProgram
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3273a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        this.f3369a.bindLong(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteProgram
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3272a(int OplusGLSurfaceView_13, double IntrinsicsJvm.kt_5) {
        this.f3369a.bindDouble(OplusGLSurfaceView_13, IntrinsicsJvm.kt_5);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteProgram
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3274a(int OplusGLSurfaceView_13, String str) {
        this.f3369a.bindString(OplusGLSurfaceView_13, str);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteProgram
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3275a(int OplusGLSurfaceView_13, byte[] bArr) {
        this.f3369a.bindBlob(OplusGLSurfaceView_13, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3369a.close();
    }
}
