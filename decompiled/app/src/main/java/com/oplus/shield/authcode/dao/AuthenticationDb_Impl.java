package com.oplus.shield.authcode.dao;

import android.database.SQLException;
import androidx.p046f.p047a.SupportSQLiteDatabase;
import androidx.p046f.p047a.SupportSQLiteOpenHelper;
import androidx.room.RoomDatabase;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.p054b.DBUtil;
import androidx.room.p054b.TableInfo;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.camera.statistics.model.EnterExitDcsMsgData;
import com.oplus.tblplayer.misc.MediaInfo;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class AuthenticationDb_Impl extends AuthenticationDb {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private volatile AuthenticationDao f23748d;

    @Override // androidx.room.RoomDatabase
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected SupportSQLiteOpenHelper mo4640b(DatabaseConfiguration c0738a) {
        return c0738a.f4333a.mo3270a(SupportSQLiteOpenHelper.IntrinsicsJvm.kt_4.m3285a(c0738a.f4334b).m3287a(c0738a.f4335c).m3286a(new RoomOpenHelper(c0738a, new RoomOpenHelper.PlatformImplementations.kt_3(1) { // from class: com.oplus.shield.authcode.dao.AuthenticationDb_Impl.1
            @Override // androidx.room.RoomOpenHelper.PlatformImplementations.kt_3
            /* renamed from: COUIBaseListPopupWindow_10 */
            public void mo4670h(SupportSQLiteDatabase interfaceC0561b) {
            }

            @Override // androidx.room.RoomOpenHelper.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo4664b(SupportSQLiteDatabase interfaceC0561b) throws SQLException {
                interfaceC0561b.mo3258c("CREATE TABLE IF NOT EXISTS `a_e` (`id_renamed` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `auth_code` TEXT, `is_enable` INTEGER NOT NULL, `uid` INTEGER NOT NULL, `packageName` TEXT, `capability_name` TEXT, `expiration` INTEGER NOT NULL, `permission` BLOB, `last_update_time` INTEGER NOT NULL, `cache_time` INTEGER NOT NULL)");
                interfaceC0561b.mo3258c("CREATE TABLE IF NOT EXISTS room_master_table (id_renamed INTEGER PRIMARY KEY,identity_hash TEXT)");
                interfaceC0561b.mo3258c("INSERT OR REPLACE INTO room_master_table (id_renamed,identity_hash) VALUES(42, '4900734c010240a846af4887983ab420')");
            }

            @Override // androidx.room.RoomOpenHelper.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4663a(SupportSQLiteDatabase interfaceC0561b) throws SQLException {
                interfaceC0561b.mo3258c("DROP TABLE IF EXISTS `a_e`");
                if (AuthenticationDb_Impl.this.f4422c != null) {
                    int size = AuthenticationDb_Impl.this.f4422c.size();
                    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                        ((RoomDatabase.IntrinsicsJvm.kt_4) AuthenticationDb_Impl.this.f4422c.get(OplusGLSurfaceView_13)).m4654c(interfaceC0561b);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_5 */
            protected void mo4666d(SupportSQLiteDatabase interfaceC0561b) {
                if (AuthenticationDb_Impl.this.f4422c != null) {
                    int size = AuthenticationDb_Impl.this.f4422c.size();
                    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                        ((RoomDatabase.IntrinsicsJvm.kt_4) AuthenticationDb_Impl.this.f4422c.get(OplusGLSurfaceView_13)).m4652a(interfaceC0561b);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo4665c(SupportSQLiteDatabase interfaceC0561b) {
                AuthenticationDb_Impl.this.f4420a = interfaceC0561b;
                AuthenticationDb_Impl.this.m4637a(interfaceC0561b);
                if (AuthenticationDb_Impl.this.f4422c != null) {
                    int size = AuthenticationDb_Impl.this.f4422c.size();
                    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                        ((RoomDatabase.IntrinsicsJvm.kt_4) AuthenticationDb_Impl.this.f4422c.get(OplusGLSurfaceView_13)).m4653b(interfaceC0561b);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.PlatformImplementations.kt_3
            /* renamed from: COUIBaseListPopupWindow_11 */
            public void mo4669g(SupportSQLiteDatabase interfaceC0561b) throws SQLException {
                DBUtil.m4597a(interfaceC0561b);
            }

            @Override // androidx.room.RoomOpenHelper.PlatformImplementations.kt_3
            /* renamed from: COUIBaseListPopupWindow_12 */
            protected RoomOpenHelper.IntrinsicsJvm.kt_4 mo4668f(SupportSQLiteDatabase interfaceC0561b) {
                HashMap map = new HashMap(10);
                map.put(TtmlNode.ATTR_ID, new TableInfo.PlatformImplementations.kt_3(TtmlNode.ATTR_ID, "INTEGER", true, 1, null, 1));
                map.put("auth_code", new TableInfo.PlatformImplementations.kt_3("auth_code", MediaInfo.RENDERER_TYPE_TEXT, false, 0, null, 1));
                map.put("is_enable", new TableInfo.PlatformImplementations.kt_3("is_enable", "INTEGER", true, 0, null, 1));
                map.put("uid", new TableInfo.PlatformImplementations.kt_3("uid", "INTEGER", true, 0, null, 1));
                map.put(AFConstants.EXTRA_PACKAGE_NAME, new TableInfo.PlatformImplementations.kt_3(AFConstants.EXTRA_PACKAGE_NAME, MediaInfo.RENDERER_TYPE_TEXT, false, 0, null, 1));
                map.put("capability_name", new TableInfo.PlatformImplementations.kt_3("capability_name", MediaInfo.RENDERER_TYPE_TEXT, false, 0, null, 1));
                map.put("expiration", new TableInfo.PlatformImplementations.kt_3("expiration", "INTEGER", true, 0, null, 1));
                map.put(EnterExitDcsMsgData.EVENT_PERMISSION, new TableInfo.PlatformImplementations.kt_3(EnterExitDcsMsgData.EVENT_PERMISSION, "BLOB", false, 0, null, 1));
                map.put("last_update_time", new TableInfo.PlatformImplementations.kt_3("last_update_time", "INTEGER", true, 0, null, 1));
                map.put("cache_time", new TableInfo.PlatformImplementations.kt_3("cache_time", "INTEGER", true, 0, null, 1));
                TableInfo c0745e = new TableInfo("a_e", map, new HashSet(0), new HashSet(0));
                TableInfo c0745eM4600a = TableInfo.m4600a(interfaceC0561b, "a_e");
                if (!c0745e.equals(c0745eM4600a)) {
                    return new RoomOpenHelper.IntrinsicsJvm.kt_4(false, "a_e(com.oplus.shield.authcode.dao.AuthenticationDbBean).\OplusGLSurfaceView_11 Expected:\OplusGLSurfaceView_11" + c0745e + "\OplusGLSurfaceView_11 Found:\OplusGLSurfaceView_11" + c0745eM4600a);
                }
                return new RoomOpenHelper.IntrinsicsJvm.kt_4(true, null);
            }
        }, "4900734c010240a846af4887983ab420", "bcb6b006fd96cb6cf4245dc2a4b99c48")).m3288a());
    }

    @Override // androidx.room.RoomDatabase
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected InvalidationTracker mo4641c() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "a_e");
    }

    @Override // com.oplus.shield.authcode.dao.AuthenticationDb
    /* renamed from: OplusGLSurfaceView_14 */
    public AuthenticationDao mo25154l() {
        AuthenticationDao interfaceC3697a;
        if (this.f23748d != null) {
            return this.f23748d;
        }
        synchronized (this) {
            if (this.f23748d == null) {
                this.f23748d = new AuthenticationDao_Impl(this);
            }
            interfaceC3697a = this.f23748d;
        }
        return interfaceC3697a;
    }
}
