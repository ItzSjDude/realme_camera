package androidx.room.p054b;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.p046f.p047a.SupportSQLiteDatabase;
import androidx.p046f.p047a.SupportSQLiteQuery;
import androidx.room.RoomDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/* compiled from: DBUtil.java */
/* renamed from: androidx.room.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class DBUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static Cursor m4596a(RoomDatabase abstractC0750g, SupportSQLiteQuery interfaceC0564e, boolean z, CancellationSignal cancellationSignal) {
        Cursor cursorM4634a = abstractC0750g.m4634a(interfaceC0564e, cancellationSignal);
        if (!z || !(cursorM4634a instanceof AbstractWindowedCursor)) {
            return cursorM4634a;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorM4634a;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? CursorUtil.m4594a(abstractWindowedCursor) : cursorM4634a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m4597a(SupportSQLiteDatabase interfaceC0561b) throws SQLException {
        ArrayList<String> arrayList = new ArrayList();
        Cursor cursorMo3255b = interfaceC0561b.mo3255b("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorMo3255b.moveToNext()) {
            try {
                arrayList.add(cursorMo3255b.getString(0));
            } catch (Throwable th) {
                cursorMo3255b.close();
                throw th;
            }
        }
        cursorMo3255b.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                interfaceC0561b.mo3258c("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m4595a(File file) throws Throwable {
        FileChannel channel;
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel = new FileInputStream(file).getChannel();
            try {
                channel.tryLock(60L, 4L, true);
                channel.position(60L);
                if (channel.read(byteBufferAllocate) != 4) {
                    throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
                }
                byteBufferAllocate.rewind();
                int OplusGLSurfaceView_13 = byteBufferAllocate.getInt();
                if (channel != null) {
                    channel.close();
                }
                return OplusGLSurfaceView_13;
            } catch (Throwable th) {
                th = th;
                if (channel != null) {
                    channel.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            channel = null;
        }
    }
}
