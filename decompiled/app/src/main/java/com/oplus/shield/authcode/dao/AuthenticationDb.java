package com.oplus.shield.authcode.dao;

/* loaded from: classes2.dex */
public abstract class AuthenticationDb extends androidx.room.g_renamed {
    private static volatile com.oplus.shield.authcode.dao.AuthenticationDb d_renamed;

    public abstract com.oplus.shield.authcode.dao.a_renamed l_renamed();

    public static com.oplus.shield.authcode.dao.AuthenticationDb a_renamed(android.content.Context context) {
        if (d_renamed == null) {
            synchronized (com.oplus.shield.authcode.dao.AuthenticationDb.class) {
                if (d_renamed == null) {
                    d_renamed = (com.oplus.shield.authcode.dao.AuthenticationDb) androidx.room.f_renamed.a_renamed(context.getApplicationContext(), com.oplus.shield.authcode.dao.AuthenticationDb.class, "authentication.db_renamed").a_renamed().b_renamed();
                }
            }
        }
        return d_renamed;
    }
}
