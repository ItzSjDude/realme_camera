package com.oplus.tingle.ipc.a_renamed;

/* compiled from: ProviderCursor.java */
/* loaded from: classes2.dex */
public class a_renamed extends android.database.MatrixCursor {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.lang.String[] f7743a = {"col"};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static volatile com.oplus.tingle.ipc.a_renamed.a_renamed f7744b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.os.Bundle f7745c;

    @Override // android.database.AbstractCursor, android.database.Cursor
    public android.os.Bundle getExtras() {
        return this.f7745c;
    }

    public static android.os.IBinder a_renamed(android.database.Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        android.os.Bundle extras = cursor.getExtras();
        if (extras != null) {
            return extras.getBinder("IBinder");
        }
        com.oplus.tingle.ipc.c_renamed.a_renamed.b_renamed(com.oplus.epona.ipc.cursor.ProviderCursor.TAG, "Get cursor bundle null.", new java.lang.Object[0]);
        return null;
    }
}
