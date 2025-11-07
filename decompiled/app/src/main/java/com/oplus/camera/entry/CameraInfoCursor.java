package com.oplus.camera.entry;

import android.database.AbstractCursor;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.statistics.model.DcsMsgData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: CameraInfoCursor.java */
/* renamed from: com.oplus.camera.entry.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class CameraInfoCursor extends AbstractCursor implements CameraCallConstant {

    /* renamed from: OplusGLSurfaceView_15 */
    private static Map<Integer, String> f13570j = new HashMap<Integer, String>() { // from class: com.oplus.camera.entry.IntrinsicsJvm.kt_3.1
        {
            put(0, ApsConstant.CAPTURE_MODE_COMMON);
            put(1, ApsConstant.CAPTURE_MODE_NIGHT);
            put(2, "portrait");
            put(3, ApsConstant.CAPTURE_MODE_PANORAMA);
            put(4, ApsConstant.CAPTURE_MODE_PROFESSIONAL);
            put(5, ApsConstant.CAPTURE_MODE_STICKER);
            put(6, ApsConstant.REC_MODE_COMMON);
            put(7, ApsConstant.REC_MODE_FAST_VIDEO);
            put(8, ApsConstant.REC_MODE_SLOW_VIDEO);
            put(11, "superText");
            put(12, ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION);
            put(24, ApsConstant.CAPTURE_MODE_HIGH_PIXEL);
            put(10, ApsConstant.CAPTURE_MODE_MACRO);
            put(9, ApsConstant.CAPTURE_MODE_HIGH_DEFINITION);
            put(13, ApsConstant.CAPTURE_MODE_ID_PHOTO);
            put(22, ApsConstant.CAPTURE_MODE_FISH_EYE);
            put(14, ApsConstant.CAPTURE_MODE_GROUP_SHOT);
            put(15, ApsConstant.CAPTURE_MODE_MULTI_VIDEO);
            put(17, ApsConstant.CAPTURE_MODE_MICROSCOPE);
            put(19, ApsConstant.REC_MODE_TIMELASPE_PRO);
            put(16, "movie");
            put(18, ApsConstant.CAPTURE_MODE_STARRY);
            put(20, ApsConstant.CAPTURE_MODE_STREET);
            put(21, ApsConstant.CAPTURE_MODE_XPAN);
            put(23, ApsConstant.CAPTURE_MODE_3D_PHOTO);
        }
    };

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int[] f13571h = new int[f13544g.length];

    /* renamed from: OplusGLSurfaceView_13 */
    private Map<String, Integer> f13572i = new HashMap();

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        return 1;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int OplusGLSurfaceView_13) {
        return 0.0d;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int OplusGLSurfaceView_13) {
        return 0.0f;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int OplusGLSurfaceView_13) {
        return (short) 0;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int OplusGLSurfaceView_13) {
        return null;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getType(int OplusGLSurfaceView_13) {
        return 1;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int OplusGLSurfaceView_13) {
        return false;
    }

    public CameraInfoCursor() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < f13544g.length; OplusGLSurfaceView_13++) {
            this.f13572i.put(f13544g[OplusGLSurfaceView_13], Integer.valueOf(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13364a() {
        this.f13571h[getColumnIndex("support")] = 15;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f0  */
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
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m13365b() {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.entry.CameraInfoCursor.m13365b():void");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13366c() {
        Iterator<Map.Entry<Integer, String>> it = f13570j.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= 1 << it.next().getKey().intValue();
        }
        this.f13571h[getColumnIndex(DcsMsgData.REAR)] = this.f13571h[getColumnIndex("mode")] & iIntValue;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m13367d() {
        int iIntValue = 0;
        for (Map.Entry<Integer, String> entry : f13570j.entrySet()) {
            if (CameraEntry.m13297a(entry.getValue())) {
                iIntValue |= 1 << entry.getKey().intValue();
            }
        }
        this.f13571h[getColumnIndex(DcsMsgData.FRONT)] = this.f13571h[getColumnIndex("mode")] & iIntValue;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m13368e() {
        int iIntValue = 0;
        for (Map.Entry<Integer, String> entry : f13570j.entrySet()) {
            if (CameraEntry.m13303b(entry.getValue())) {
                iIntValue |= 1 << entry.getKey().intValue();
            }
        }
        this.f13571h[getColumnIndex("beauty")] = this.f13571h[getColumnIndex("mode")] & iIntValue;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m13363a(int OplusGLSurfaceView_13) {
        return f13570j.get(Integer.valueOf(OplusGLSurfaceView_13));
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getColumnIndex(String str) {
        return this.f13572i.get(str).intValue();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return f13544g;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int OplusGLSurfaceView_13) {
        return this.f13571h[OplusGLSurfaceView_13];
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int OplusGLSurfaceView_13) {
        return this.f13571h[OplusGLSurfaceView_13];
    }
}
