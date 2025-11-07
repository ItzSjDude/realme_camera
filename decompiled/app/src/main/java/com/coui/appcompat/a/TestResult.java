package com.coui.appcompat.a_renamed;

/* compiled from: COUILockPatternUtils.java */
/* loaded from: classes.dex */
public class h_renamed {
    public static java.util.List<com.coui.appcompat.widget.COUILockPatternView.Cell> a_renamed(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (byte b2 : str.getBytes()) {
            byte b3 = (byte) (b2 - 49);
            arrayList.add(com.coui.appcompat.widget.COUILockPatternView.Cell.a_renamed(b3 / 3, b3 % 3));
        }
        return arrayList;
    }

    public static java.lang.String a_renamed(java.util.List<com.coui.appcompat.widget.COUILockPatternView.Cell> list) {
        if (list == null) {
            return "";
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.coui.appcompat.widget.COUILockPatternView.Cell cell = list.get(i_renamed);
            bArr[i_renamed] = (byte) ((cell.getRow() * 3) + cell.getColumn() + 49);
        }
        return new java.lang.String(bArr);
    }
}
