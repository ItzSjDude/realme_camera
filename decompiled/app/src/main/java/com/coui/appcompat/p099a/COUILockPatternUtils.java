package com.coui.appcompat.p099a;

import com.coui.appcompat.widget.COUILockPatternView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: COUILockPatternUtils.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class COUILockPatternUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static List<COUILockPatternView.Cell> m6427a(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (byte b2 : str.getBytes()) {
            byte b3 = (byte) (b2 - 49);
            arrayList.add(COUILockPatternView.Cell.m7196a(b3 / 3, b3 % 3));
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m6426a(List<COUILockPatternView.Cell> list) {
        if (list == null) {
            return "";
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            COUILockPatternView.Cell cell = list.get(OplusGLSurfaceView_13);
            bArr[OplusGLSurfaceView_13] = (byte) ((cell.getRow() * 3) + cell.getColumn() + 49);
        }
        return new String(bArr);
    }
}
