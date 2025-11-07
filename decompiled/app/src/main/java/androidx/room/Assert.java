package androidx.room;

/* compiled from: DatabaseConfiguration.java */
/* loaded from: classes.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public final androidx.f_renamed.a_renamed.c_renamed.SupportSQLiteOpenHelper_2 f1575a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public final android.content.Context f1576b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public final java.lang.String f1577c;
    public final androidx.room.g_renamed.d_renamed d_renamed;
    public final java.util.List<androidx.room.g_renamed.b_renamed> e_renamed;
    public final boolean f_renamed;
    public final androidx.room.g_renamed.c_renamed g_renamed;
    public final java.util.concurrent.Executor h_renamed;
    public final java.util.concurrent.Executor i_renamed;
    public final boolean j_renamed;
    public final boolean k_renamed;
    public final boolean l_renamed;
    public final java.lang.String m_renamed;
    public final java.io.File n_renamed;
    private final java.util.Set<java.lang.Integer> o_renamed;

    public a_renamed(android.content.Context context, java.lang.String str, androidx.f_renamed.a_renamed.c_renamed.SupportSQLiteOpenHelper_2 interfaceC0030c, androidx.room.g_renamed.d_renamed dVar, java.util.List<androidx.room.g_renamed.b_renamed> list, boolean z_renamed, androidx.room.g_renamed.c_renamed cVar, java.util.concurrent.Executor executor, java.util.concurrent.Executor executor2, boolean z2, boolean z3, boolean z4, java.util.Set<java.lang.Integer> set, java.lang.String str2, java.io.File file) {
        this.f1575a = interfaceC0030c;
        this.f1576b = context;
        this.f1577c = str;
        this.d_renamed = dVar;
        this.e_renamed = list;
        this.f_renamed = z_renamed;
        this.g_renamed = cVar;
        this.h_renamed = executor;
        this.i_renamed = executor2;
        this.j_renamed = z2;
        this.k_renamed = z3;
        this.l_renamed = z4;
        this.o_renamed = set;
        this.m_renamed = str2;
        this.n_renamed = file;
    }

    public boolean a_renamed(int i_renamed, int i2) {
        java.util.Set<java.lang.Integer> set;
        if ((i_renamed > i2) && this.l_renamed) {
            return false;
        }
        return this.k_renamed && ((set = this.o_renamed) == null || !set.contains(java.lang.Integer.valueOf(i_renamed)));
    }
}
