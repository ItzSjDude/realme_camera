package com.oplus.shield.authcode.dao;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.Room;

/* loaded from: classes2.dex */
public abstract class AuthenticationDb extends RoomDatabase {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static volatile AuthenticationDb f23747d;

    /* renamed from: OplusGLSurfaceView_14 */
    public abstract AuthenticationDao mo25154l();

    /* renamed from: PlatformImplementations.kt_3 */
    public static AuthenticationDb m25153a(Context context) {
        if (f23747d == null) {
            synchronized (AuthenticationDb.class) {
                if (f23747d == null) {
                    f23747d = (AuthenticationDb) Room.m4630a(context.getApplicationContext(), AuthenticationDb.class, "authentication.db").m4650a().m4651b();
                }
            }
        }
        return f23747d;
    }
}
