package com.oplus.camera.algovisualization;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: AuthenticationUtils.java */
/* renamed from: com.oplus.camera.algovisualization.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class AuthenticationUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m11617a(String str) throws Exception {
        return InetAddress.getByName(m11619c(str)).isReachable(3000);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m11616a(long OplusGLSurfaceView_15) {
        return ((int) ((m11618b(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS").format(new Date())) - OplusGLSurfaceView_15) / 3600000)) > 6;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static long m11618b(String str) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS").parse(str);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            date = null;
        }
        if (date != null) {
            return date.getTime();
        }
        return 0L;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static String m11619c(String str) {
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit = str.split("#");
        sb.append(strArrSplit[0]);
        sb.append(strArrSplit[1]);
        sb.append("t");
        sb.append(".");
        sb.append(strArrSplit[2]);
        sb.append(strArrSplit[3]);
        sb.append("s");
        sb.append(".");
        sb.append(strArrSplit[4]);
        sb.append("OplusGLSurfaceView_6");
        return sb.toString();
    }
}
