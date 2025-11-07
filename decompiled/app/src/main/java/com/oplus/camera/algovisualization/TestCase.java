package com.oplus.camera.algovisualization;

/* compiled from: AuthenticationUtils.java */
/* loaded from: classes2.dex */
public class e_renamed {
    public static boolean a_renamed(java.lang.String str) throws java.lang.Exception {
        return java.net.InetAddress.getByName(c_renamed(str)).isReachable(3000);
    }

    public static boolean a_renamed(long j_renamed) {
        return ((int) ((b_renamed(new java.text.SimpleDateFormat("yyyy-MM-dd_renamed hh:mm:ss:SSS").format(new java.util.Date())) - j_renamed) / 3600000)) > 6;
    }

    public static long b_renamed(java.lang.String str) {
        java.util.Date date;
        try {
            date = new java.text.SimpleDateFormat("yyyy-MM-dd_renamed hh:mm:ss:SSS").parse(str);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            date = null;
        }
        if (date != null) {
            return date.getTime();
        }
        return 0L;
    }

    public static java.lang.String c_renamed(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String[] strArrSplit = str.split("#");
        sb.append(strArrSplit[0]);
        sb.append(strArrSplit[1]);
        sb.append("t_renamed");
        sb.append(".");
        sb.append(strArrSplit[2]);
        sb.append(strArrSplit[3]);
        sb.append("s_renamed");
        sb.append(".");
        sb.append(strArrSplit[4]);
        sb.append("m_renamed");
        return sb.toString();
    }
}
