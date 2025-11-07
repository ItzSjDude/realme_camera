package com.oplus.camera.entry;

/* compiled from: CameraInfoCursor.java */
/* loaded from: classes2.dex */
public class c_renamed extends android.database.AbstractCursor implements com.oplus.camera.entry.a_renamed {
    private static java.util.Map<java.lang.Integer, java.lang.String> j_renamed = new java.util.HashMap<java.lang.Integer, java.lang.String>() { // from class: com.oplus.camera.entry.c_renamed.1
        {
            put(0, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON);
            put(1, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_NIGHT);
            put(2, "portrait");
            put(3, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA);
            put(4, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL);
            put(5, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER);
            put(6, com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON);
            put(7, com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO);
            put(8, com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO);
            put(11, "superText");
            put(12, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION);
            put(24, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_PIXEL);
            put(10, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MACRO);
            put(9, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_DEFINITION);
            put(13, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ID_PHOTO);
            put(22, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_FISH_EYE);
            put(14, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_GROUP_SHOT);
            put(15, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO);
            put(17, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MICROSCOPE);
            put(19, com.oplus.camera.aps.constant.ApsConstant.REC_MODE_TIMELASPE_PRO);
            put(16, "movie");
            put(18, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STARRY);
            put(20, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STREET);
            put(21, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_XPAN);
            put(23, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_3D_PHOTO);
        }
    };
    private int[] h_renamed = new int[g_renamed.length];
    private java.util.Map<java.lang.String, java.lang.Integer> i_renamed = new java.util.HashMap();

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        return 1;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int i_renamed) {
        return 0.0d;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int i_renamed) {
        return 0.0f;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int i_renamed) {
        return (short) 0;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public java.lang.String getString(int i_renamed) {
        return null;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getType(int i_renamed) {
        return 1;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int i_renamed) {
        return false;
    }

    public c_renamed() {
        for (int i_renamed = 0; i_renamed < g_renamed.length; i_renamed++) {
            this.i_renamed.put(g_renamed[i_renamed], java.lang.Integer.valueOf(i_renamed));
        }
    }

    public void a_renamed() {
        this.h_renamed[getColumnIndex("support")] = 15;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:62:0x00f0  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v9, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b_renamed() {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.entry.c_renamed.b_renamed():void");
    }

    public void c_renamed() {
        java.util.Iterator<java.util.Map.Entry<java.lang.Integer, java.lang.String>> it = j_renamed.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= 1 << it.next().getKey().intValue();
        }
        this.h_renamed[getColumnIndex(com.oplus.camera.statistics.model.DcsMsgData.REAR)] = this.h_renamed[getColumnIndex("mode")] & iIntValue;
    }

    public void d_renamed() {
        int iIntValue = 0;
        for (java.util.Map.Entry<java.lang.Integer, java.lang.String> entry : j_renamed.entrySet()) {
            if (com.oplus.camera.entry.b_renamed.a_renamed(entry.getValue())) {
                iIntValue |= 1 << entry.getKey().intValue();
            }
        }
        this.h_renamed[getColumnIndex(com.oplus.camera.statistics.model.DcsMsgData.FRONT)] = this.h_renamed[getColumnIndex("mode")] & iIntValue;
    }

    public void e_renamed() {
        int iIntValue = 0;
        for (java.util.Map.Entry<java.lang.Integer, java.lang.String> entry : j_renamed.entrySet()) {
            if (com.oplus.camera.entry.b_renamed.b_renamed(entry.getValue())) {
                iIntValue |= 1 << entry.getKey().intValue();
            }
        }
        this.h_renamed[getColumnIndex("beauty")] = this.h_renamed[getColumnIndex("mode")] & iIntValue;
    }

    public static java.lang.String a_renamed(int i_renamed) {
        return j_renamed.get(java.lang.Integer.valueOf(i_renamed));
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getColumnIndex(java.lang.String str) {
        return this.i_renamed.get(str).intValue();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public java.lang.String[] getColumnNames() {
        return g_renamed;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int i_renamed) {
        return this.h_renamed[i_renamed];
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int i_renamed) {
        return this.h_renamed[i_renamed];
    }
}
