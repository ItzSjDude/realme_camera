package com.coui.appcompat.a_renamed;

/* compiled from: COUIMathUtils.java */
/* loaded from: classes.dex */
public class j_renamed {
    public static int a_renamed(int i_renamed, int i2) {
        return i_renamed - (b_renamed(i_renamed, i2) * i2);
    }

    public static int b_renamed(int i_renamed, int i2) {
        int i3 = i_renamed / i2;
        return ((i_renamed ^ i2) >= 0 || i2 * i3 == i_renamed) ? i3 : i3 - 1;
    }
}
