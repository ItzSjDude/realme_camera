package com.oplus.camera.sticker;

/* compiled from: STStickerContainer.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static int f5438a = 131568;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static int f5439b = 852416;

    public static java.lang.String a_renamed(com.oplus.camera.sticker.data.MultiStickerExtendedInfo multiStickerExtendedInfo, int i_renamed) {
        java.lang.String fileContentUri4x3 = multiStickerExtendedInfo.getFileContentUri4x3();
        if (1 == i_renamed) {
            return multiStickerExtendedInfo.getFileContentUri16x9();
        }
        if (i_renamed == 0) {
            return multiStickerExtendedInfo.getFileContentUri4x3();
        }
        return 2 == i_renamed ? multiStickerExtendedInfo.getFileContentUri1x1() : fileContentUri4x3;
    }

    public static long a_renamed(java.util.Map<com.oplus.camera.sticker.b_renamed, java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo>> map) {
        java.util.Iterator<com.oplus.camera.sticker.b_renamed> it = map.keySet().iterator();
        long jB = 0;
        while (it.hasNext()) {
            jB |= it.next().b_renamed();
        }
        return jB;
    }

    public static android.graphics.RectF a_renamed(com.oplus.camera.sticker.data.MultiStickerExtendedInfo multiStickerExtendedInfo, int i_renamed, int i2) {
        java.lang.String[] strArrSplit;
        android.util.Size size;
        int iD = com.oplus.camera.util.Util.d_renamed(i2, i_renamed);
        if (iD == 0) {
            java.lang.String[] strArrSplit2 = multiStickerExtendedInfo.getBaseSize4x3().split("x_renamed");
            strArrSplit = multiStickerExtendedInfo.getDisplayRect4x3().split(",");
            size = new android.util.Size(java.lang.Integer.parseInt(strArrSplit2[0]), java.lang.Integer.parseInt(strArrSplit2[1]));
        } else if (2 == iD) {
            java.lang.String[] strArrSplit3 = multiStickerExtendedInfo.getBaseSize1x1().split("x_renamed");
            strArrSplit = multiStickerExtendedInfo.getDisplayRect1x1().split(",");
            size = new android.util.Size(java.lang.Integer.parseInt(strArrSplit3[0]), java.lang.Integer.parseInt(strArrSplit3[1]));
        } else {
            java.lang.String[] strArrSplit4 = multiStickerExtendedInfo.getBaseSize16x9().split("x_renamed");
            strArrSplit = multiStickerExtendedInfo.getDisplayRect16x9().split(",");
            size = new android.util.Size(java.lang.Integer.parseInt(strArrSplit4[0]), java.lang.Integer.parseInt(strArrSplit4[1]));
        }
        if (strArrSplit != null) {
            return new android.graphics.RectF(java.lang.Math.round(java.lang.Integer.parseInt(strArrSplit[0]) * (i2 / (size.getWidth() == 0 ? i2 : size.getWidth()))), java.lang.Math.round(java.lang.Integer.parseInt(strArrSplit[1]) * (i_renamed / (size.getHeight() == 0 ? i_renamed : size.getHeight()))), r0 + java.lang.Math.round(java.lang.Integer.parseInt(strArrSplit[2]) * r8), r2 + java.lang.Math.round(java.lang.Integer.parseInt(strArrSplit[3]) * r7));
        }
        return new android.graphics.RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public static android.graphics.RectF a_renamed(int i_renamed, int i2, android.graphics.RectF rectF) {
        int iRound;
        double d_renamed = i2;
        double d2 = i_renamed;
        double dHeight = rectF.height() / rectF.width();
        double dAbs = java.lang.Math.abs(d_renamed / d2) - dHeight;
        int iRound2 = 0;
        if (dAbs > 0.0d) {
            iRound = (i2 - ((int) java.lang.Math.round(d2 * dHeight))) / 2;
        } else if (dAbs < 0.0d) {
            iRound2 = (i_renamed - ((int) java.lang.Math.round(d_renamed / dHeight))) / 2;
            iRound = 0;
        } else {
            iRound = 0;
        }
        return new android.graphics.RectF(iRound2, iRound, i_renamed - iRound2, i2 - iRound);
    }
}
