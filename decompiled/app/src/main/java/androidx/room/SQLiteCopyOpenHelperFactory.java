package androidx.room;

import androidx.p046f.p047a.SupportSQLiteOpenHelper;
import java.io.File;

/* compiled from: SQLiteCopyOpenHelperFactory.java */
/* renamed from: androidx.room.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper.IntrinsicsJvm.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f4472a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final File f4473b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final SupportSQLiteOpenHelper.IntrinsicsJvm.kt_3 f4474c;

    SQLiteCopyOpenHelperFactory(String str, File file, SupportSQLiteOpenHelper.IntrinsicsJvm.kt_3 cVar) {
        this.f4472a = str;
        this.f4473b = file;
        this.f4474c = cVar;
    }

    @Override // androidx.p046f.p047a.SupportSQLiteOpenHelper.IntrinsicsJvm.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public SupportSQLiteOpenHelper mo3270a(SupportSQLiteOpenHelper.IntrinsicsJvm.kt_4 bVar) {
        return new SQLiteCopyOpenHelper(bVar.f3372a, this.f4472a, this.f4473b, bVar.f3374c.f3371a, this.f4474c.mo3270a(bVar));
    }
}
