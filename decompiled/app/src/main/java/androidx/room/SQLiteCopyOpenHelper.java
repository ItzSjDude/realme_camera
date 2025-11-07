package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.p046f.p047a.SupportSQLiteDatabase;
import androidx.p046f.p047a.SupportSQLiteOpenHelper;
import androidx.room.p054b.CopyLock;
import androidx.room.p054b.DBUtil;
import androidx.room.p054b.FileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/* compiled from: SQLiteCopyOpenHelper.java */
/* renamed from: androidx.room.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f4465a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f4466b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final File f4467c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f4468d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final SupportSQLiteOpenHelper f4469e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private DatabaseConfiguration f4470f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f4471g;

    SQLiteCopyOpenHelper(Context context, String str, File file, int OplusGLSurfaceView_13, SupportSQLiteOpenHelper interfaceC0562c) {
        this.f4465a = context;
        this.f4466b = str;
        this.f4467c = file;
        this.f4468d = OplusGLSurfaceView_13;
        this.f4469e = interfaceC0562c;
    }

    @Override // androidx.p046f.p047a.SupportSQLiteOpenHelper
    /* renamed from: PlatformImplementations.kt_3 */
    public String mo3264a() {
        return this.f4469e.mo3264a();
    }

    @Override // androidx.p046f.p047a.SupportSQLiteOpenHelper
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3265a(boolean z) {
        this.f4469e.mo3265a(z);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteOpenHelper
    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized SupportSQLiteDatabase mo3266b() {
        if (!this.f4471g) {
            m4676c();
            this.f4471g = true;
        }
        return this.f4469e.mo3266b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4677a(DatabaseConfiguration c0738a) {
        this.f4470f = c0738a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m4676c() {
        String strMo3264a = mo3264a();
        File databasePath = this.f4465a.getDatabasePath(strMo3264a);
        DatabaseConfiguration c0738a = this.f4470f;
        CopyLock c0741a = new CopyLock(strMo3264a, this.f4465a.getFilesDir(), c0738a == null || c0738a.f4342j);
        try {
            c0741a.m4591a();
            if (!databasePath.exists()) {
                try {
                    m4675a(databasePath);
                    c0741a.m4592b();
                    return;
                } catch (IOException COUIBaseListPopupWindow_8) {
                    throw new RuntimeException("Unable to copy database file.", COUIBaseListPopupWindow_8);
                }
            }
            if (this.f4470f == null) {
                c0741a.m4592b();
                return;
            }
            try {
                int iM4595a = DBUtil.m4595a(databasePath);
                if (iM4595a == this.f4468d) {
                    c0741a.m4592b();
                    return;
                }
                if (this.f4470f.m4586a(iM4595a, this.f4468d)) {
                    c0741a.m4592b();
                    return;
                }
                if (this.f4465a.deleteDatabase(strMo3264a)) {
                    try {
                        m4675a(databasePath);
                    } catch (IOException e2) {
                        Log.w("ROOM", "Unable to copy database file.", e2);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + strMo3264a + ") for PlatformImplementations.kt_3 copy destructive migration.");
                }
                c0741a.m4592b();
                return;
            } catch (IOException e3) {
                Log.w("ROOM", "Unable to read database version.", e3);
                c0741a.m4592b();
                return;
            }
        } catch (Throwable th) {
            c0741a.m4592b();
            throw th;
        }
        c0741a.m4592b();
        throw th;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4675a(File file) throws IOException {
        ReadableByteChannel channel;
        if (this.f4466b != null) {
            channel = Channels.newChannel(this.f4465a.getAssets().open(this.f4466b));
        } else {
            File file2 = this.f4467c;
            if (file2 != null) {
                channel = new FileInputStream(file2).getChannel();
            } else {
                throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
            }
        }
        File fileCreateTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f4465a.getCacheDir());
        fileCreateTempFile.deleteOnExit();
        FileUtil.m4598a(channel, new FileOutputStream(fileCreateTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        if (fileCreateTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + fileCreateTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }
}
