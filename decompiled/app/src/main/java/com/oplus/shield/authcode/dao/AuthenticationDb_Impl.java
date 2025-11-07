package com.oplus.shield.authcode.dao;

/* loaded from: classes2.dex */
public final class AuthenticationDb_Impl extends com.oplus.shield.authcode.dao.AuthenticationDb {
    private volatile com.oplus.shield.authcode.dao.a_renamed d_renamed;

    @Override // androidx.room.g_renamed
    protected androidx.f_renamed.a_renamed.c_renamed b_renamed(androidx.room.a_renamed aVar) {
        return aVar.f1575a.a_renamed(androidx.f_renamed.a_renamed.c_renamed.b_renamed.a_renamed(aVar.f1576b).a_renamed(aVar.f1577c).a_renamed(new androidx.room.i_renamed(aVar, new androidx.room.i_renamed.a_renamed(1) { // from class: com.oplus.shield.authcode.dao.AuthenticationDb_Impl.1
            @Override // androidx.room.i_renamed.a_renamed
            public void h_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
            }

            @Override // androidx.room.i_renamed.a_renamed
            public void b_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) throws android.database.SQLException {
                bVar.c_renamed("CREATE TABLE IF NOT EXISTS `a_e` (`id_renamed` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `auth_code` TEXT, `is_enable` INTEGER NOT NULL, `uid` INTEGER NOT NULL, `packageName` TEXT, `capability_name` TEXT, `expiration` INTEGER NOT NULL, `permission` BLOB, `last_update_time` INTEGER NOT NULL, `cache_time` INTEGER NOT NULL)");
                bVar.c_renamed("CREATE TABLE IF NOT EXISTS room_master_table (id_renamed INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c_renamed("INSERT OR REPLACE INTO room_master_table (id_renamed,identity_hash) VALUES(42, '4900734c010240a846af4887983ab420')");
            }

            @Override // androidx.room.i_renamed.a_renamed
            public void a_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) throws android.database.SQLException {
                bVar.c_renamed("DROP TABLE IF EXISTS `a_e`");
                if (com.oplus.shield.authcode.dao.AuthenticationDb_Impl.this.f1619c != null) {
                    int size = com.oplus.shield.authcode.dao.AuthenticationDb_Impl.this.f1619c.size();
                    for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                        ((androidx.room.g_renamed.b_renamed) com.oplus.shield.authcode.dao.AuthenticationDb_Impl.this.f1619c.get(i_renamed)).c_renamed(bVar);
                    }
                }
            }

            @Override // androidx.room.i_renamed.a_renamed
            protected void d_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
                if (com.oplus.shield.authcode.dao.AuthenticationDb_Impl.this.f1619c != null) {
                    int size = com.oplus.shield.authcode.dao.AuthenticationDb_Impl.this.f1619c.size();
                    for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                        ((androidx.room.g_renamed.b_renamed) com.oplus.shield.authcode.dao.AuthenticationDb_Impl.this.f1619c.get(i_renamed)).a_renamed(bVar);
                    }
                }
            }

            @Override // androidx.room.i_renamed.a_renamed
            public void c_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
                com.oplus.shield.authcode.dao.AuthenticationDb_Impl.this.f1617a = bVar;
                com.oplus.shield.authcode.dao.AuthenticationDb_Impl.this.a_renamed(bVar);
                if (com.oplus.shield.authcode.dao.AuthenticationDb_Impl.this.f1619c != null) {
                    int size = com.oplus.shield.authcode.dao.AuthenticationDb_Impl.this.f1619c.size();
                    for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                        ((androidx.room.g_renamed.b_renamed) com.oplus.shield.authcode.dao.AuthenticationDb_Impl.this.f1619c.get(i_renamed)).b_renamed(bVar);
                    }
                }
            }

            @Override // androidx.room.i_renamed.a_renamed
            public void g_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) throws android.database.SQLException {
                androidx.room.b_renamed.c_renamed.a_renamed(bVar);
            }

            @Override // androidx.room.i_renamed.a_renamed
            protected androidx.room.i_renamed.b_renamed f_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
                java.util.HashMap map = new java.util.HashMap(10);
                map.put(com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID, new androidx.room.b_renamed.e_renamed.a_renamed(com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID, "INTEGER", true, 1, null, 1));
                map.put("auth_code", new androidx.room.b_renamed.e_renamed.a_renamed("auth_code", com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_TEXT, false, 0, null, 1));
                map.put("is_enable", new androidx.room.b_renamed.e_renamed.a_renamed("is_enable", "INTEGER", true, 0, null, 1));
                map.put("uid", new androidx.room.b_renamed.e_renamed.a_renamed("uid", "INTEGER", true, 0, null, 1));
                map.put(com.heytap.accessory.constant.AFConstants.EXTRA_PACKAGE_NAME, new androidx.room.b_renamed.e_renamed.a_renamed(com.heytap.accessory.constant.AFConstants.EXTRA_PACKAGE_NAME, com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_TEXT, false, 0, null, 1));
                map.put("capability_name", new androidx.room.b_renamed.e_renamed.a_renamed("capability_name", com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_TEXT, false, 0, null, 1));
                map.put("expiration", new androidx.room.b_renamed.e_renamed.a_renamed("expiration", "INTEGER", true, 0, null, 1));
                map.put(com.oplus.camera.statistics.model.EnterExitDcsMsgData.EVENT_PERMISSION, new androidx.room.b_renamed.e_renamed.a_renamed(com.oplus.camera.statistics.model.EnterExitDcsMsgData.EVENT_PERMISSION, "BLOB", false, 0, null, 1));
                map.put("last_update_time", new androidx.room.b_renamed.e_renamed.a_renamed("last_update_time", "INTEGER", true, 0, null, 1));
                map.put("cache_time", new androidx.room.b_renamed.e_renamed.a_renamed("cache_time", "INTEGER", true, 0, null, 1));
                androidx.room.b_renamed.e_renamed eVar = new androidx.room.b_renamed.e_renamed("a_e", map, new java.util.HashSet(0), new java.util.HashSet(0));
                androidx.room.b_renamed.e_renamed eVarA = androidx.room.b_renamed.e_renamed.a_renamed(bVar, "a_e");
                if (!eVar.equals(eVarA)) {
                    return new androidx.room.i_renamed.b_renamed(false, "a_e(com.oplus.shield.authcode.dao.AuthenticationDbBean).\n_renamed Expected:\n_renamed" + eVar + "\n_renamed Found:\n_renamed" + eVarA);
                }
                return new androidx.room.i_renamed.b_renamed(true, null);
            }
        }, "4900734c010240a846af4887983ab420", "bcb6b006fd96cb6cf4245dc2a4b99c48")).a_renamed());
    }

    @Override // androidx.room.g_renamed
    protected androidx.room.d_renamed c_renamed() {
        return new androidx.room.d_renamed(this, new java.util.HashMap(0), new java.util.HashMap(0), "a_e");
    }

    @Override // com.oplus.shield.authcode.dao.AuthenticationDb
    public com.oplus.shield.authcode.dao.a_renamed l_renamed() {
        com.oplus.shield.authcode.dao.a_renamed aVar;
        if (this.d_renamed != null) {
            return this.d_renamed;
        }
        synchronized (this) {
            if (this.d_renamed == null) {
                this.d_renamed = new com.oplus.shield.authcode.dao.b_renamed(this);
            }
            aVar = this.d_renamed;
        }
        return aVar;
    }
}
