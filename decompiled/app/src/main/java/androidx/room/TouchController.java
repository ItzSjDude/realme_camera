package androidx.room;

/* compiled from: SQLiteCopyOpenHelperFactory.java */
/* loaded from: classes.dex */
class l_renamed implements androidx.f_renamed.a_renamed.c_renamed.SupportSQLiteOpenHelper_2 {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f1635a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.io.File f1636b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final androidx.f_renamed.a_renamed.c_renamed.SupportSQLiteOpenHelper_2 f1637c;

    l_renamed(java.lang.String str, java.io.File file, androidx.f_renamed.a_renamed.c_renamed.SupportSQLiteOpenHelper_2 interfaceC0030c) {
        this.f1635a = str;
        this.f1636b = file;
        this.f1637c = interfaceC0030c;
    }

    @Override // androidx.f_renamed.a_renamed.c_renamed.SupportSQLiteOpenHelper_2
    public androidx.f_renamed.a_renamed.c_renamed a_renamed(androidx.f_renamed.a_renamed.c_renamed.b_renamed bVar) {
        return new androidx.room.k_renamed(bVar.f1111a, this.f1635a, this.f1636b, bVar.f1113c.f1110a, this.f1637c.a_renamed(bVar));
    }
}
