package androidx.room.b_renamed;

/* compiled from: DBUtil.java */
/* loaded from: classes.dex */
public class c_renamed {
    public static android.database.Cursor a_renamed(androidx.room.g_renamed gVar, androidx.f_renamed.a_renamed.e_renamed eVar, boolean z_renamed, android.os.CancellationSignal cancellationSignal) {
        android.database.Cursor cursorA = gVar.a_renamed(eVar, cancellationSignal);
        if (!z_renamed || !(cursorA instanceof android.database.AbstractWindowedCursor)) {
            return cursorA;
        }
        android.database.AbstractWindowedCursor abstractWindowedCursor = (android.database.AbstractWindowedCursor) cursorA;
        int count = abstractWindowedCursor.getCount();
        return (android.os.Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? androidx.room.b_renamed.b_renamed.a_renamed(abstractWindowedCursor) : cursorA;
    }

    public static void a_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) throws android.database.SQLException {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList();
        android.database.Cursor cursorB = bVar.b_renamed("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorB.moveToNext()) {
            try {
                arrayList.add(cursorB.getString(0));
            } catch (java.lang.Throwable th) {
                cursorB.close();
                throw th;
            }
        }
        cursorB.close();
        for (java.lang.String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                bVar.c_renamed("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static int a_renamed(java.io.File file) throws java.lang.Throwable {
        java.nio.channels.FileChannel channel;
        try {
            java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(4);
            channel = new java.io.FileInputStream(file).getChannel();
            try {
                channel.tryLock(60L, 4L, true);
                channel.position(60L);
                if (channel.read(byteBufferAllocate) != 4) {
                    throw new java.io.IOException("Bad database header, unable to read 4 bytes at_renamed offset 60");
                }
                byteBufferAllocate.rewind();
                int i_renamed = byteBufferAllocate.getInt();
                if (channel != null) {
                    channel.close();
                }
                return i_renamed;
            } catch (java.lang.Throwable th) {
                th = th;
                if (channel != null) {
                    channel.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            channel = null;
        }
    }
}
