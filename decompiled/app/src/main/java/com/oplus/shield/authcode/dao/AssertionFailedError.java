package com.oplus.shield.authcode.dao;

/* compiled from: AuthenticationDao_Impl.java */
/* loaded from: classes2.dex */
public final class b_renamed implements com.oplus.shield.authcode.dao.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.room.g_renamed f7618a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.room.b_renamed<com.oplus.shield.authcode.dao.c_renamed> f7619b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final androidx.room.m_renamed f7620c;
    private final androidx.room.m_renamed d_renamed;

    public b_renamed(androidx.room.g_renamed gVar) {
        this.f7618a = gVar;
        this.f7619b = new androidx.room.b_renamed<com.oplus.shield.authcode.dao.c_renamed>(gVar) { // from class: com.oplus.shield.authcode.dao.b_renamed.1
            @Override // androidx.room.m_renamed
            public java.lang.String a_renamed() {
                return "INSERT OR REPLACE INTO `a_e` (`id_renamed`,`auth_code`,`is_enable`,`uid`,`packageName`,`capability_name`,`expiration`,`permission`,`last_update_time`,`cache_time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.b_renamed
            public void a_renamed(androidx.f_renamed.a_renamed.f_renamed fVar, com.oplus.shield.authcode.dao.c_renamed cVar) {
                fVar.a_renamed(1, cVar.a_renamed());
                if (cVar.b_renamed() == null) {
                    fVar.a_renamed(2);
                } else {
                    fVar.a_renamed(2, cVar.b_renamed());
                }
                fVar.a_renamed(3, cVar.c_renamed() ? 1L : 0L);
                fVar.a_renamed(4, cVar.d_renamed());
                if (cVar.e_renamed() == null) {
                    fVar.a_renamed(5);
                } else {
                    fVar.a_renamed(5, cVar.e_renamed());
                }
                if (cVar.f_renamed() == null) {
                    fVar.a_renamed(6);
                } else {
                    fVar.a_renamed(6, cVar.f_renamed());
                }
                fVar.a_renamed(7, cVar.g_renamed());
                if (cVar.h_renamed() == null) {
                    fVar.a_renamed(8);
                } else {
                    fVar.a_renamed(8, cVar.h_renamed());
                }
                fVar.a_renamed(9, cVar.i_renamed());
                fVar.a_renamed(10, cVar.j_renamed());
            }
        };
        this.f7620c = new androidx.room.m_renamed(gVar) { // from class: com.oplus.shield.authcode.dao.b_renamed.2
            @Override // androidx.room.m_renamed
            public java.lang.String a_renamed() {
                return "DELETE from a_e WHERE a_e.uid = (?)AND a_e.capability_name = (?)AND a_e.auth_code = (?)";
            }
        };
        this.d_renamed = new androidx.room.m_renamed(gVar) { // from class: com.oplus.shield.authcode.dao.b_renamed.3
            @Override // androidx.room.m_renamed
            public java.lang.String a_renamed() {
                return "DELETE from a_e";
            }
        };
    }

    @Override // com.oplus.shield.authcode.dao.a_renamed
    public void a_renamed(com.oplus.shield.authcode.dao.c_renamed cVar) {
        this.f7618a.f_renamed();
        this.f7618a.g_renamed();
        try {
            this.f7619b.a_renamed((androidx.room.b_renamed<com.oplus.shield.authcode.dao.c_renamed>) cVar);
            this.f7618a.j_renamed();
        } finally {
            this.f7618a.h_renamed();
        }
    }

    @Override // com.oplus.shield.authcode.dao.a_renamed
    public com.oplus.shield.authcode.dao.c_renamed a_renamed(int i_renamed, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        androidx.room.j_renamed jVarA = androidx.room.j_renamed.a_renamed("SELECT * FROM a_e WHERE a_e.uid = (?)AND a_e.packageName = (?)AND a_e.capability_name = (?)AND a_e.auth_code = (?)", 4);
        jVarA.a_renamed(1, i_renamed);
        if (str == null) {
            jVarA.a_renamed(2);
        } else {
            jVarA.a_renamed(2, str);
        }
        if (str2 == null) {
            jVarA.a_renamed(3);
        } else {
            jVarA.a_renamed(3, str2);
        }
        if (str3 == null) {
            jVarA.a_renamed(4);
        } else {
            jVarA.a_renamed(4, str3);
        }
        this.f7618a.f_renamed();
        com.oplus.shield.authcode.dao.c_renamed cVar = null;
        android.database.Cursor cursorA = androidx.room.b_renamed.c_renamed.a_renamed(this.f7618a, jVarA, false, null);
        try {
            int iA = androidx.room.b_renamed.b_renamed.a_renamed(cursorA, com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID);
            int iA2 = androidx.room.b_renamed.b_renamed.a_renamed(cursorA, "auth_code");
            int iA3 = androidx.room.b_renamed.b_renamed.a_renamed(cursorA, "is_enable");
            int iA4 = androidx.room.b_renamed.b_renamed.a_renamed(cursorA, "uid");
            int iA5 = androidx.room.b_renamed.b_renamed.a_renamed(cursorA, com.heytap.accessory.constant.AFConstants.EXTRA_PACKAGE_NAME);
            int iA6 = androidx.room.b_renamed.b_renamed.a_renamed(cursorA, "capability_name");
            int iA7 = androidx.room.b_renamed.b_renamed.a_renamed(cursorA, "expiration");
            int iA8 = androidx.room.b_renamed.b_renamed.a_renamed(cursorA, com.oplus.camera.statistics.model.EnterExitDcsMsgData.EVENT_PERMISSION);
            int iA9 = androidx.room.b_renamed.b_renamed.a_renamed(cursorA, "last_update_time");
            int iA10 = androidx.room.b_renamed.b_renamed.a_renamed(cursorA, "cache_time");
            if (cursorA.moveToFirst()) {
                cVar = new com.oplus.shield.authcode.dao.c_renamed(cursorA.getString(iA2), cursorA.getInt(iA3) != 0, cursorA.getInt(iA4), cursorA.getString(iA5), cursorA.getString(iA6), cursorA.getLong(iA7), cursorA.getBlob(iA8), cursorA.getLong(iA9), cursorA.getLong(iA10));
                cVar.a_renamed(cursorA.getInt(iA));
            }
            return cVar;
        } finally {
            cursorA.close();
            jVarA.a_renamed();
        }
    }
}
