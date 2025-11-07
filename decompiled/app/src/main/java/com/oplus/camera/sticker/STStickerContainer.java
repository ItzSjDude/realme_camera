package com.oplus.camera.sticker;

import android.graphics.RectF;
import android.util.Size;
import com.oplus.camera.sticker.data.MultiStickerExtendedInfo;
import com.oplus.camera.util.Util;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: STStickerContainer.java */
/* renamed from: com.oplus.camera.sticker.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class STStickerContainer {

    /* renamed from: PlatformImplementations.kt_3 */
    public static int f16204a = 131568;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int f16205b = 852416;

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16800a(MultiStickerExtendedInfo multiStickerExtendedInfo, int OplusGLSurfaceView_13) {
        String fileContentUri4x3 = multiStickerExtendedInfo.getFileContentUri4x3();
        if (1 == OplusGLSurfaceView_13) {
            return multiStickerExtendedInfo.getFileContentUri16x9();
        }
        if (OplusGLSurfaceView_13 == 0) {
            return multiStickerExtendedInfo.getFileContentUri4x3();
        }
        return 2 == OplusGLSurfaceView_13 ? multiStickerExtendedInfo.getFileContentUri1x1() : fileContentUri4x3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static long m16797a(Map<MaterailInfo, List<MultiStickerExtendedInfo>> map) {
        Iterator<MaterailInfo> it = map.keySet().iterator();
        long jM16778b = 0;
        while (it.hasNext()) {
            jM16778b |= it.next().m16778b();
        }
        return jM16778b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static RectF m16799a(MultiStickerExtendedInfo multiStickerExtendedInfo, int OplusGLSurfaceView_13, int i2) {
        String[] strArrSplit;
        Size size;
        int iM24426d = Util.m24426d(i2, OplusGLSurfaceView_13);
        if (iM24426d == 0) {
            String[] strArrSplit2 = multiStickerExtendedInfo.getBaseSize4x3().split("x");
            strArrSplit = multiStickerExtendedInfo.getDisplayRect4x3().split(",");
            size = new Size(Integer.parseInt(strArrSplit2[0]), Integer.parseInt(strArrSplit2[1]));
        } else if (2 == iM24426d) {
            String[] strArrSplit3 = multiStickerExtendedInfo.getBaseSize1x1().split("x");
            strArrSplit = multiStickerExtendedInfo.getDisplayRect1x1().split(",");
            size = new Size(Integer.parseInt(strArrSplit3[0]), Integer.parseInt(strArrSplit3[1]));
        } else {
            String[] strArrSplit4 = multiStickerExtendedInfo.getBaseSize16x9().split("x");
            strArrSplit = multiStickerExtendedInfo.getDisplayRect16x9().split(",");
            size = new Size(Integer.parseInt(strArrSplit4[0]), Integer.parseInt(strArrSplit4[1]));
        }
        if (strArrSplit != null) {
            return new RectF(Math.round(Integer.parseInt(strArrSplit[0]) * (i2 / (size.getWidth() == 0 ? i2 : size.getWidth()))), Math.round(Integer.parseInt(strArrSplit[1]) * (OplusGLSurfaceView_13 / (size.getHeight() == 0 ? OplusGLSurfaceView_13 : size.getHeight()))), r0 + Math.round(Integer.parseInt(strArrSplit[2]) * r8), r2 + Math.round(Integer.parseInt(strArrSplit[3]) * r7));
        }
        return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static RectF m16798a(int OplusGLSurfaceView_13, int i2, RectF rectF) {
        int iRound;
        double IntrinsicsJvm.kt_5 = i2;
        double d2 = OplusGLSurfaceView_13;
        double dHeight = rectF.height() / rectF.width();
        double dAbs = Math.abs(IntrinsicsJvm.kt_5 / d2) - dHeight;
        int iRound2 = 0;
        if (dAbs > 0.0d) {
            iRound = (i2 - ((int) Math.round(d2 * dHeight))) / 2;
        } else if (dAbs < 0.0d) {
            iRound2 = (OplusGLSurfaceView_13 - ((int) Math.round(IntrinsicsJvm.kt_5 / dHeight))) / 2;
            iRound = 0;
        } else {
            iRound = 0;
        }
        return new RectF(iRound2, iRound, OplusGLSurfaceView_13 - iRound2, i2 - iRound);
    }
}
