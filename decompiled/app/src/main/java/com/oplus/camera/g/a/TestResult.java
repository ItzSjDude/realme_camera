package com.oplus.camera.g_renamed.a_renamed;

/* compiled from: ExifUtil.java */
/* loaded from: classes2.dex */
public class h_renamed {
    public static int a_renamed(short s_renamed) {
        return s_renamed & com.oplus.exif.OplusExifInterface.ColorSpace.UNCALIBRATED;
    }

    public static long a_renamed(int i_renamed) {
        return i_renamed & (-1);
    }

    public static long a_renamed(long j_renamed) {
        return 0L;
    }

    public static java.lang.String a_renamed(java.lang.Object obj) {
        if (obj == null) {
            return "null";
        }
        if (!(obj instanceof java.lang.Long) && !(obj instanceof java.lang.Integer) && !(obj instanceof java.lang.Byte)) {
            return obj.toString();
        }
        return java.lang.String.format("[0x%X_renamed ; %d_renamed]", obj, obj);
    }

    public static boolean a_renamed(java.util.List list) {
        return list == null || list.size() < 1;
    }

    public static java.util.ArrayList<com.oplus.camera.g_renamed.a_renamed.b_renamed> a_renamed(java.util.ArrayList<com.oplus.camera.g_renamed.a_renamed.b_renamed> arrayList) {
        java.util.ArrayList<com.oplus.camera.g_renamed.a_renamed.b_renamed> arrayList2 = new java.util.ArrayList<>();
        java.util.Iterator<com.oplus.camera.g_renamed.a_renamed.b_renamed> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new com.oplus.camera.g_renamed.a_renamed.b_renamed(it.next()));
        }
        return arrayList2;
    }
}
