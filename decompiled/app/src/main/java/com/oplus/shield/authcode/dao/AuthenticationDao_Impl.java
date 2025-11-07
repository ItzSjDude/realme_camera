package com.oplus.shield.authcode.dao;

import android.database.Cursor;
import androidx.p046f.p047a.SupportSQLiteStatement;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.RoomSQLiteQuery;
import androidx.room.p054b.CursorUtil;
import androidx.room.p054b.DBUtil;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.camera.statistics.model.EnterExitDcsMsgData;

/* compiled from: AuthenticationDao_Impl.java */
/* renamed from: com.oplus.shield.authcode.dao.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public final class AuthenticationDao_Impl implements AuthenticationDao {

    /* renamed from: PlatformImplementations.kt_3 */
    private final RoomDatabase f23750a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final EntityInsertionAdapter<AuthenticationDbBean> f23751b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final SharedSQLiteStatement f23752c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final SharedSQLiteStatement f23753d;

    public AuthenticationDao_Impl(RoomDatabase abstractC0750g) {
        this.f23750a = abstractC0750g;
        this.f23751b = new EntityInsertionAdapter<AuthenticationDbBean>(abstractC0750g) { // from class: com.oplus.shield.authcode.dao.IntrinsicsJvm.kt_4.1
            @Override // androidx.room.SharedSQLiteStatement
            /* renamed from: PlatformImplementations.kt_3 */
            public String mo4680a() {
                return "INSERT OR REPLACE INTO `a_e` (`id_renamed`,`auth_code`,`is_enable`,`uid`,`packageName`,`capability_name`,`expiration`,`permission`,`last_update_time`,`cache_time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo4588a(SupportSQLiteStatement interfaceC0565f, AuthenticationDbBean c3699c) {
                interfaceC0565f.mo3273a(1, c3699c.m25168a());
                if (c3699c.m25170b() == null) {
                    interfaceC0565f.mo3271a(2);
                } else {
                    interfaceC0565f.mo3274a(2, c3699c.m25170b());
                }
                interfaceC0565f.mo3273a(3, c3699c.m25171c() ? 1L : 0L);
                interfaceC0565f.mo3273a(4, c3699c.m25172d());
                if (c3699c.m25173e() == null) {
                    interfaceC0565f.mo3271a(5);
                } else {
                    interfaceC0565f.mo3274a(5, c3699c.m25173e());
                }
                if (c3699c.m25174f() == null) {
                    interfaceC0565f.mo3271a(6);
                } else {
                    interfaceC0565f.mo3274a(6, c3699c.m25174f());
                }
                interfaceC0565f.mo3273a(7, c3699c.m25175g());
                if (c3699c.m25176h() == null) {
                    interfaceC0565f.mo3271a(8);
                } else {
                    interfaceC0565f.mo3275a(8, c3699c.m25176h());
                }
                interfaceC0565f.mo3273a(9, c3699c.m25177i());
                interfaceC0565f.mo3273a(10, c3699c.m25178j());
            }
        };
        this.f23752c = new SharedSQLiteStatement(abstractC0750g) { // from class: com.oplus.shield.authcode.dao.IntrinsicsJvm.kt_4.2
            @Override // androidx.room.SharedSQLiteStatement
            /* renamed from: PlatformImplementations.kt_3 */
            public String mo4680a() {
                return "DELETE from a_e WHERE a_e.uid = (?)AND a_e.capability_name = (?)AND a_e.auth_code = (?)";
            }
        };
        this.f23753d = new SharedSQLiteStatement(abstractC0750g) { // from class: com.oplus.shield.authcode.dao.IntrinsicsJvm.kt_4.3
            @Override // androidx.room.SharedSQLiteStatement
            /* renamed from: PlatformImplementations.kt_3 */
            public String mo4680a() {
                return "DELETE from a_e";
            }
        };
    }

    @Override // com.oplus.shield.authcode.dao.AuthenticationDao
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25167a(AuthenticationDbBean c3699c) {
        this.f23750a.m4644f();
        this.f23750a.m4645g();
        try {
            this.f23751b.m4589a((EntityInsertionAdapter<AuthenticationDbBean>) c3699c);
            this.f23750a.m4648j();
        } finally {
            this.f23750a.m4646h();
        }
    }

    @Override // com.oplus.shield.authcode.dao.AuthenticationDao
    /* renamed from: PlatformImplementations.kt_3 */
    public AuthenticationDbBean mo25166a(int OplusGLSurfaceView_13, String str, String str2, String str3) {
        RoomSQLiteQuery c0753jM4671a = RoomSQLiteQuery.m4671a("SELECT * FROM a_e WHERE a_e.uid = (?)AND a_e.packageName = (?)AND a_e.capability_name = (?)AND a_e.auth_code = (?)", 4);
        c0753jM4671a.mo3273a(1, OplusGLSurfaceView_13);
        if (str == null) {
            c0753jM4671a.mo3271a(2);
        } else {
            c0753jM4671a.mo3274a(2, str);
        }
        if (str2 == null) {
            c0753jM4671a.mo3271a(3);
        } else {
            c0753jM4671a.mo3274a(3, str2);
        }
        if (str3 == null) {
            c0753jM4671a.mo3271a(4);
        } else {
            c0753jM4671a.mo3274a(4, str3);
        }
        this.f23750a.m4644f();
        AuthenticationDbBean c3699c = null;
        Cursor cursorM4596a = DBUtil.m4596a(this.f23750a, c0753jM4671a, false, null);
        try {
            int iM4593a = CursorUtil.m4593a(cursorM4596a, TtmlNode.ATTR_ID);
            int iM4593a2 = CursorUtil.m4593a(cursorM4596a, "auth_code");
            int iM4593a3 = CursorUtil.m4593a(cursorM4596a, "is_enable");
            int iM4593a4 = CursorUtil.m4593a(cursorM4596a, "uid");
            int iM4593a5 = CursorUtil.m4593a(cursorM4596a, AFConstants.EXTRA_PACKAGE_NAME);
            int iM4593a6 = CursorUtil.m4593a(cursorM4596a, "capability_name");
            int iM4593a7 = CursorUtil.m4593a(cursorM4596a, "expiration");
            int iM4593a8 = CursorUtil.m4593a(cursorM4596a, EnterExitDcsMsgData.EVENT_PERMISSION);
            int iM4593a9 = CursorUtil.m4593a(cursorM4596a, "last_update_time");
            int iM4593a10 = CursorUtil.m4593a(cursorM4596a, "cache_time");
            if (cursorM4596a.moveToFirst()) {
                c3699c = new AuthenticationDbBean(cursorM4596a.getString(iM4593a2), cursorM4596a.getInt(iM4593a3) != 0, cursorM4596a.getInt(iM4593a4), cursorM4596a.getString(iM4593a5), cursorM4596a.getString(iM4593a6), cursorM4596a.getLong(iM4593a7), cursorM4596a.getBlob(iM4593a8), cursorM4596a.getLong(iM4593a9), cursorM4596a.getLong(iM4593a10));
                c3699c.m25169a(cursorM4596a.getInt(iM4593a));
            }
            return c3699c;
        } finally {
            cursorM4596a.close();
            c0753jM4671a.m4673a();
        }
    }
}
