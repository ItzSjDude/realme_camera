package com.oplus.shield.b_renamed;

/* compiled from: TimeUtils.java */
/* loaded from: classes2.dex */
public class i_renamed {
    public static java.util.Calendar a_renamed(byte[] bArr) {
        int i_renamed = (bArr[3] & 255) | ((bArr[0] << 24) & (-16777216)) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280);
        java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar();
        gregorianCalendar.setTimeInMillis(i_renamed * 1000);
        return gregorianCalendar;
    }
}
