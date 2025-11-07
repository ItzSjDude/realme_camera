package com.oplus.camera.p144g.p145a;

import com.oplus.exif.OplusExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ExifUtil.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class ExifUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m13767a(short s) {
        return s & OplusExifInterface.ColorSpace.UNCALIBRATED;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static long m13768a(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 & (-1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static long m13769a(long OplusGLSurfaceView_15) {
        return 0L;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m13770a(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (!(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Byte)) {
            return obj.toString();
        }
        return String.format("[0x%X ; %IntrinsicsJvm.kt_5]", obj, obj);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m13772a(List list) {
        return list == null || list.size() < 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ArrayList<ExifEntry> m13771a(ArrayList<ExifEntry> arrayList) {
        ArrayList<ExifEntry> arrayList2 = new ArrayList<>();
        Iterator<ExifEntry> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new ExifEntry(it.next()));
        }
        return arrayList2;
    }
}
