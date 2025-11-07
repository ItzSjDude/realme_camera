package androidx.p046f.p047a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: SupportSQLiteOpenHelper.java */
/* renamed from: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public interface SupportSQLiteOpenHelper {

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* renamed from: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        SupportSQLiteOpenHelper mo3270a(IntrinsicsJvm.kt_4 bVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    String mo3264a();

    /* renamed from: PlatformImplementations.kt_3 */
    void mo3265a(boolean z);

    /* renamed from: IntrinsicsJvm.kt_4 */
    SupportSQLiteDatabase mo3266b();

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* renamed from: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public static abstract class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final int f3371a;

        /* renamed from: PlatformImplementations.kt_3 */
        public void mo3279a(SupportSQLiteDatabase interfaceC0561b) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract void mo3280a(SupportSQLiteDatabase interfaceC0561b, int OplusGLSurfaceView_13, int i2);

        /* renamed from: IntrinsicsJvm.kt_4 */
        public abstract void mo3281b(SupportSQLiteDatabase interfaceC0561b);

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo3283c(SupportSQLiteDatabase interfaceC0561b) {
        }

        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13) {
            this.f3371a = OplusGLSurfaceView_13;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo3282b(SupportSQLiteDatabase interfaceC0561b, int OplusGLSurfaceView_13, int i2) {
            throw new SQLiteException("Can't downgrade database from version " + OplusGLSurfaceView_13 + " to " + i2);
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m3284d(SupportSQLiteDatabase interfaceC0561b) {
            Log.COUIBaseListPopupWindow_8("SupportSQLite", "Corruption reported by sqlite on database: " + interfaceC0561b.mo3261f());
            if (!interfaceC0561b.mo3260e()) {
                m3278a(interfaceC0561b.mo3261f());
                return;
            }
            List<Pair<String, String>> listMo3262g = null;
            try {
                try {
                    listMo3262g = interfaceC0561b.mo3262g();
                } catch (SQLiteException unused) {
                }
                try {
                    interfaceC0561b.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (listMo3262g != null) {
                    Iterator<Pair<String, String>> it = listMo3262g.iterator();
                    while (it.hasNext()) {
                        m3278a((String) it.next().second);
                    }
                } else {
                    m3278a(interfaceC0561b.mo3261f());
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m3278a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } else {
                    try {
                        if (!new File(str).delete()) {
                            Log.COUIBaseListPopupWindow_8("SupportSQLite", "Could not delete the database file " + str);
                        }
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        Log.COUIBaseListPopupWindow_8("SupportSQLite", "error while deleting corrupted database file", COUIBaseListPopupWindow_8);
                    }
                }
            } catch (Exception e2) {
                Log.w("SupportSQLite", "delete failed: ", e2);
            }
        }
    }

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* renamed from: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final Context f3372a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final String f3373b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public final PlatformImplementations.kt_3 f3374c;

        IntrinsicsJvm.kt_4(Context context, String str, PlatformImplementations.kt_3 aVar) {
            this.f3372a = context;
            this.f3373b = str;
            this.f3374c = aVar;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static PlatformImplementations.kt_3 m3285a(Context context) {
            return new PlatformImplementations.kt_3(context);
        }

        /* compiled from: SupportSQLiteOpenHelper.java */
        /* renamed from: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
        public static class PlatformImplementations.kt_3 {

            /* renamed from: PlatformImplementations.kt_3 */
            Context f3375a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            String f3376b;

            /* renamed from: IntrinsicsJvm.kt_3 */
            PlatformImplementations.kt_3 f3377c;

            /* renamed from: PlatformImplementations.kt_3 */
            public IntrinsicsJvm.kt_4 m3288a() {
                PlatformImplementations.kt_3 aVar = this.f3377c;
                if (aVar == null) {
                    throw new IllegalArgumentException("Must set PlatformImplementations.kt_3 callback to create the configuration.");
                }
                Context context = this.f3375a;
                if (context == null) {
                    throw new IllegalArgumentException("Must set PlatformImplementations.kt_3 non-null context to create the configuration.");
                }
                return new IntrinsicsJvm.kt_4(context, this.f3376b, aVar);
            }

            PlatformImplementations.kt_3(Context context) {
                this.f3375a = context;
            }

            /* renamed from: PlatformImplementations.kt_3 */
            public PlatformImplementations.kt_3 m3287a(String str) {
                this.f3376b = str;
                return this;
            }

            /* renamed from: PlatformImplementations.kt_3 */
            public PlatformImplementations.kt_3 m3286a(PlatformImplementations.kt_3 aVar) {
                this.f3377c = aVar;
                return this;
            }
        }
    }
}
