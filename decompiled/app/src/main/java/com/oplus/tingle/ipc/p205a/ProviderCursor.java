package com.oplus.tingle.ipc.p205a;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.IBinder;
import com.oplus.epona.ipc.cursor.ProviderCursor;
import com.oplus.tingle.ipc.p213c.Logger;

/* compiled from: ProviderCursor.java */
/* renamed from: com.oplus.tingle.ipc.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class ProviderCursor extends MatrixCursor {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String[] f24135a = {"col"};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static volatile ProviderCursor f24136b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Bundle f24137c;

    @Override // android.database.AbstractCursor, android.database.Cursor
    public Bundle getExtras() {
        return this.f24137c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static IBinder m25475a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        Bundle extras = cursor.getExtras();
        if (extras != null) {
            return extras.getBinder("IBinder");
        }
        Logger.m25514b(ProviderCursor.TAG, "Get cursor bundle null.", new Object[0]);
        return null;
    }
}
