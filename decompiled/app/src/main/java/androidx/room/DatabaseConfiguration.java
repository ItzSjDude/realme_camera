package androidx.room;

import android.content.Context;
import androidx.p046f.p047a.SupportSQLiteOpenHelper;
import androidx.room.RoomDatabase;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: DatabaseConfiguration.java */
/* renamed from: androidx.room.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class DatabaseConfiguration {

    /* renamed from: PlatformImplementations.kt_3 */
    public final SupportSQLiteOpenHelper.IntrinsicsJvm.kt_3 f4333a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final Context f4334b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final String f4335c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final RoomDatabase.IntrinsicsJvm.kt_5 f4336d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final List<RoomDatabase.IntrinsicsJvm.kt_4> f4337e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public final boolean f4338f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public final RoomDatabase.IntrinsicsJvm.kt_3 f4339g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public final Executor f4340h;

    /* renamed from: OplusGLSurfaceView_13 */
    public final Executor f4341i;

    /* renamed from: OplusGLSurfaceView_15 */
    public final boolean f4342j;

    /* renamed from: OplusGLSurfaceView_5 */
    public final boolean f4343k;

    /* renamed from: OplusGLSurfaceView_14 */
    public final boolean f4344l;

    /* renamed from: OplusGLSurfaceView_6 */
    public final String f4345m;

    /* renamed from: OplusGLSurfaceView_11 */
    public final File f4346n;

    /* renamed from: o */
    private final Set<Integer> f4347o;

    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.IntrinsicsJvm.kt_3 cVar, RoomDatabase.IntrinsicsJvm.kt_5 dVar, List<RoomDatabase.IntrinsicsJvm.kt_4> list, boolean z, RoomDatabase.IntrinsicsJvm.kt_3 cVar2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
        this.f4333a = cVar;
        this.f4334b = context;
        this.f4335c = str;
        this.f4336d = dVar;
        this.f4337e = list;
        this.f4338f = z;
        this.f4339g = cVar2;
        this.f4340h = executor;
        this.f4341i = executor2;
        this.f4342j = z2;
        this.f4343k = z3;
        this.f4344l = z4;
        this.f4347o = set;
        this.f4345m = str2;
        this.f4346n = file;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m4586a(int OplusGLSurfaceView_13, int i2) {
        Set<Integer> set;
        if ((OplusGLSurfaceView_13 > i2) && this.f4344l) {
            return false;
        }
        return this.f4343k && ((set = this.f4347o) == null || !set.contains(Integer.valueOf(OplusGLSurfaceView_13)));
    }
}
