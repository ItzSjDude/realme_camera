package androidx.core.graphics;

/* compiled from: TypefaceCompatUtil.java */
/* loaded from: classes.dex */
public class m_renamed {
    public static java.io.File a_renamed(android.content.Context context) {
        java.io.File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        java.lang.String str = ".font" + android.os.Process.myPid() + "-" + android.os.Process.myTid() + "-";
        for (int i_renamed = 0; i_renamed < 100; i_renamed++) {
            java.io.File file = new java.io.File(cacheDir, str + i_renamed);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:18:0x002e A_renamed[Catch: IOException -> 0x0032, TryCatch #1 {IOException -> 0x0032, blocks: (B_renamed:3:0x0001, B_renamed:5:0x0016, B_renamed:14:0x0025, B_renamed:19:0x0031, B_renamed:18:0x002e, B_renamed:17:0x002a), top: B_renamed:21:0x0001, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:22:0x0025 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.nio.ByteBuffer a_renamed(java.io.File r9) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.IOException -> L32
            r1.<init>(r9)     // Catch: java.io.IOException -> L32
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            long r6 = r2.size()     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            r4 = 0
            java.nio.MappedByteBuffer r9 = r2.map(r3, r4, r6)     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            r1.close()     // Catch: java.io.IOException -> L32
            return r9
        L1a:
            r9 = move-exception
            r2 = r0
            goto L23
        L1d:
            r9 = move-exception
            throw r9     // Catch: java.lang.Throwable -> L1f
        L1f:
            r2 = move-exception
            r8 = r2
            r2 = r9
            r9 = r8
        L23:
            if (r2 == 0) goto L2e
            r1.close()     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L32
            goto L31
        L29:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch: java.io.IOException -> L32
            goto L31
        L2e:
            r1.close()     // Catch: java.io.IOException -> L32
        L31:
            throw r9     // Catch: java.io.IOException -> L32
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.m_renamed.a_renamed(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x0049 A_renamed[Catch: all -> 0x004d, Throwable -> 0x0050, TryCatch #4 {Throwable -> 0x0050, blocks: (B_renamed:8:0x0013, B_renamed:10:0x002c, B_renamed:26:0x004c, B_renamed:25:0x0049, B_renamed:24:0x0045), top: B_renamed:47:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:50:0x0040 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:56:? A_renamed[Catch: IOException -> 0x0067, SYNTHETIC, TRY_LEAVE, TryCatch #1 {IOException -> 0x0067, blocks: (B_renamed:3:0x0005, B_renamed:6:0x000f, B_renamed:12:0x0031, B_renamed:35:0x005a, B_renamed:39:0x0063, B_renamed:38:0x005f, B_renamed:40:0x0066), top: B_renamed:44:0x0005, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.nio.ByteBuffer a_renamed(android.content.Context r8, android.os.CancellationSignal r9, android.net.Uri r10) throws java.lang.Throwable {
        /*
            android.content.ContentResolver r8 = r8.getContentResolver()
            r0 = 0
            java.lang.String r1 = "r_renamed"
            android.os.ParcelFileDescriptor r8 = r8.openFileDescriptor(r10, r1, r9)     // Catch: java.io.IOException -> L67
            if (r8 != 0) goto L13
            if (r8 == 0) goto L12
            r8.close()     // Catch: java.io.IOException -> L67
        L12:
            return r0
        L13:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L50
            java.io.FileDescriptor r10 = r8.getFileDescriptor()     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L50
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L50
            java.nio.channels.FileChannel r1 = r9.getChannel()     // Catch: java.lang.Throwable -> L35 java.lang.Throwable -> L38
            long r5 = r1.size()     // Catch: java.lang.Throwable -> L35 java.lang.Throwable -> L38
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L35 java.lang.Throwable -> L38
            r3 = 0
            java.nio.MappedByteBuffer r10 = r1.map(r2, r3, r5)     // Catch: java.lang.Throwable -> L35 java.lang.Throwable -> L38
            r9.close()     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L50
            if (r8 == 0) goto L34
            r8.close()     // Catch: java.io.IOException -> L67
        L34:
            return r10
        L35:
            r10 = move-exception
            r1 = r0
            goto L3e
        L38:
            r10 = move-exception
            throw r10     // Catch: java.lang.Throwable -> L3a
        L3a:
            r1 = move-exception
            r7 = r1
            r1 = r10
            r10 = r7
        L3e:
            if (r1 == 0) goto L49
            r9.close()     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4d
            goto L4c
        L44:
            r9 = move-exception
            r1.addSuppressed(r9)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L50
            goto L4c
        L49:
            r9.close()     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L50
        L4c:
            throw r10     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L50
        L4d:
            r9 = move-exception
            r10 = r0
            goto L56
        L50:
            r9 = move-exception
            throw r9     // Catch: java.lang.Throwable -> L52
        L52:
            r10 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L56:
            if (r8 == 0) goto L66
            if (r10 == 0) goto L63
            r8.close()     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L67
            goto L66
        L5e:
            r8 = move-exception
            r10.addSuppressed(r8)     // Catch: java.io.IOException -> L67
            goto L66
        L63:
            r8.close()     // Catch: java.io.IOException -> L67
        L66:
            throw r9     // Catch: java.io.IOException -> L67
        L67:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.m_renamed.a_renamed(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    public static java.nio.ByteBuffer a_renamed(android.content.Context context, android.content.res.Resources resources, int i_renamed) {
        java.io.File fileA = a_renamed(context);
        if (fileA == null) {
            return null;
        }
        try {
            if (a_renamed(fileA, resources, i_renamed)) {
                return a_renamed(fileA);
            }
            return null;
        } finally {
            fileA.delete();
        }
    }

    public static boolean a_renamed(java.io.File file, java.io.InputStream inputStream) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        android.os.StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = android.os.StrictMode.allowThreadDiskWrites();
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(file, false);
            } catch (java.io.IOException e_renamed) {
                e_renamed = e_renamed;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i_renamed = inputStream.read(bArr);
                if (i_renamed != -1) {
                    fileOutputStream.write(bArr, 0, i_renamed);
                } else {
                    a_renamed(fileOutputStream);
                    android.os.StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return true;
                }
            }
        } catch (java.io.IOException e2) {
            e_renamed = e2;
            fileOutputStream2 = fileOutputStream;
            android.util.Log.e_renamed("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e_renamed.getMessage());
            a_renamed(fileOutputStream2);
            android.os.StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return false;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            a_renamed(fileOutputStream2);
            android.os.StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    public static boolean a_renamed(java.io.File file, android.content.res.Resources resources, int i_renamed) throws java.lang.Throwable {
        java.io.InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i_renamed);
            try {
                boolean zA = a_renamed(file, inputStreamOpenRawResource);
                a_renamed(inputStreamOpenRawResource);
                return zA;
            } catch (java.lang.Throwable th) {
                th = th;
                a_renamed(inputStreamOpenRawResource);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    public static void a_renamed(java.io.Closeable closeable) throws java.io.IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }
}
