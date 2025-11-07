package androidx.p046f.p047a.p048a;

import android.database.sqlite.SQLiteStatement;
import androidx.p046f.p047a.SupportSQLiteStatement;

/* compiled from: FrameworkSQLiteStatement.java */
/* renamed from: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {

    /* renamed from: PlatformImplementations.kt_3 */
    private final SQLiteStatement f3370a;

    FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f3370a = sQLiteStatement;
    }

    @Override // androidx.p046f.p047a.SupportSQLiteStatement
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo3276a() {
        return this.f3370a.executeUpdateDelete();
    }

    @Override // androidx.p046f.p047a.SupportSQLiteStatement
    /* renamed from: IntrinsicsJvm.kt_4 */
    public long mo3277b() {
        return this.f3370a.executeInsert();
    }
}
