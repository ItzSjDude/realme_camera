package com.oplus.p123b.p124a;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AppFeatureCache.java */
/* renamed from: com.oplus.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AppFeatureCache {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final ArrayList<IntrinsicsJvm.kt_4> f10458c = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final Uri f10459d = Uri.parse("content://com.oplus.customize.coreapp.configmanager.configprovider.AppFeatureProvider").buildUpon().appendPath("app_feature").build();

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean f10456a = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static IntrinsicsJvm.kt_3 f10457b = IntrinsicsJvm.kt_3.CACHE_INVAILD;

    /* compiled from: AppFeatureCache.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final AppFeatureCache f10460a = new AppFeatureCache();
    }

    /* compiled from: AppFeatureCache.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public enum IntrinsicsJvm.kt_3 {
        CACHE_ONLY,
        CACHE_AND_DB,
        CACHE_INVAILD
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static AppFeatureCache m9358a() {
        return PlatformImplementations.kt_3.f10460a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Cursor m9361a(String str) {
        if (!f10456a) {
            return null;
        }
        ArrayList<IntrinsicsJvm.kt_4> arrayList = f10458c;
        if (arrayList == null || arrayList.size() != 0) {
            return m9359b(str);
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Cursor m9359b(String str) {
        MatrixCursor matrixCursorM9360b = m9360b();
        synchronized (AppFeatureCache.class) {
            Iterator<IntrinsicsJvm.kt_4> it = f10458c.iterator();
            while (it.hasNext()) {
                IntrinsicsJvm.kt_4 next = it.next();
                if (matrixCursorM9360b != null && next != null && next.m9362a() != null && next.m9362a().equals(str)) {
                    matrixCursorM9360b.addRow(new Object[]{next.m9365d(), next.m9362a(), next.m9363b(), next.m9364c()});
                }
            }
        }
        if (matrixCursorM9360b == null || matrixCursorM9360b.getCount() != 0) {
            return matrixCursorM9360b;
        }
        matrixCursorM9360b.close();
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private MatrixCursor m9360b() {
        return new MatrixCursor(new String[]{"_id", "featurename", "parameters", "lists"});
    }

    /* compiled from: AppFeatureCache.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        private Integer f10461a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private String f10462b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private String f10463c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private String f10464d;

        /* renamed from: PlatformImplementations.kt_3 */
        public String m9362a() {
            return this.f10462b;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public String m9363b() {
            return this.f10463c;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public String m9364c() {
            return this.f10464d;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public Integer m9365d() {
            return this.f10461a;
        }

        public String toString() {
            return "AppFeatureData{_id='" + this.f10461a + "'featureName='" + this.f10462b + "', parameters='" + this.f10463c + "', jasonStr='" + this.f10464d + "'}";
        }
    }
}
