package androidx.room;

/* compiled from: SQLiteCopyOpenHelper.java */
/* loaded from: classes.dex */
class k_renamed implements androidx.f_renamed.a_renamed.c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f1632a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.String f1633b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.io.File f1634c;
    private final int d_renamed;
    private final androidx.f_renamed.a_renamed.c_renamed e_renamed;
    private androidx.room.a_renamed f_renamed;
    private boolean g_renamed;

    k_renamed(android.content.Context context, java.lang.String str, java.io.File file, int i_renamed, androidx.f_renamed.a_renamed.c_renamed cVar) {
        this.f1632a = context;
        this.f1633b = str;
        this.f1634c = file;
        this.d_renamed = i_renamed;
        this.e_renamed = cVar;
    }

    @Override // androidx.f_renamed.a_renamed.c_renamed
    public java.lang.String a_renamed() {
        return this.e_renamed.a_renamed();
    }

    @Override // androidx.f_renamed.a_renamed.c_renamed
    public void a_renamed(boolean z_renamed) {
        this.e_renamed.a_renamed(z_renamed);
    }

    @Override // androidx.f_renamed.a_renamed.c_renamed
    public synchronized androidx.f_renamed.a_renamed.b_renamed b_renamed() {
        if (!this.g_renamed) {
            c_renamed();
            this.g_renamed = true;
        }
        return this.e_renamed.b_renamed();
    }

    void a_renamed(androidx.room.a_renamed aVar) {
        this.f_renamed = aVar;
    }

    private void c_renamed() {
        java.lang.String strA = a_renamed();
        java.io.File databasePath = this.f1632a.getDatabasePath(strA);
        androidx.room.a_renamed aVar = this.f_renamed;
        androidx.room.b_renamed.a_renamed aVar2 = new androidx.room.b_renamed.a_renamed(strA, this.f1632a.getFilesDir(), aVar == null || aVar.j_renamed);
        try {
            aVar2.a_renamed();
            if (!databasePath.exists()) {
                try {
                    a_renamed(databasePath);
                    aVar2.b_renamed();
                    return;
                } catch (java.io.IOException e_renamed) {
                    throw new java.lang.RuntimeException("Unable to copy database file.", e_renamed);
                }
            }
            if (this.f_renamed == null) {
                aVar2.b_renamed();
                return;
            }
            try {
                int iA = androidx.room.b_renamed.c_renamed.a_renamed(databasePath);
                if (iA == this.d_renamed) {
                    aVar2.b_renamed();
                    return;
                }
                if (this.f_renamed.a_renamed(iA, this.d_renamed)) {
                    aVar2.b_renamed();
                    return;
                }
                if (this.f1632a.deleteDatabase(strA)) {
                    try {
                        a_renamed(databasePath);
                    } catch (java.io.IOException e2) {
                        android.util.Log.w_renamed("ROOM", "Unable to copy database file.", e2);
                    }
                } else {
                    android.util.Log.w_renamed("ROOM", "Failed to delete database file (" + strA + ") for a_renamed copy destructive migration.");
                }
                aVar2.b_renamed();
                return;
            } catch (java.io.IOException e3) {
                android.util.Log.w_renamed("ROOM", "Unable to read database version.", e3);
                aVar2.b_renamed();
                return;
            }
        } catch (java.lang.Throwable th) {
            aVar2.b_renamed();
            throw th;
        }
        aVar2.b_renamed();
        throw th;
    }

    private void a_renamed(java.io.File file) throws java.io.IOException {
        java.nio.channels.ReadableByteChannel channel;
        if (this.f1633b != null) {
            channel = java.nio.channels.Channels.newChannel(this.f1632a.getAssets().open(this.f1633b));
        } else {
            java.io.File file2 = this.f1634c;
            if (file2 != null) {
                channel = new java.io.FileInputStream(file2).getChannel();
            } else {
                throw new java.lang.IllegalStateException("copyFromAssetPath and copyFromFile == null!");
            }
        }
        java.io.File fileCreateTempFile = java.io.File.createTempFile("room-copy-helper", ".tmp", this.f1632a.getCacheDir());
        fileCreateTempFile.deleteOnExit();
        androidx.room.b_renamed.d_renamed.a_renamed(channel, new java.io.FileOutputStream(fileCreateTempFile).getChannel());
        java.io.File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new java.io.IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        if (fileCreateTempFile.renameTo(file)) {
            return;
        }
        throw new java.io.IOException("Failed to move intermediate file (" + fileCreateTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }
}
