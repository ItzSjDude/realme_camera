package com.oplus.p123b.p124a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.oplus.p123b.p124a.AppFeatureCache;

/* compiled from: AppFeatureProviderUtils.java */
/* renamed from: com.oplus.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class AppFeatureProviderUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Uri f10465a = Uri.parse("content://com.oplus.customize.coreapp.configmanager.configprovider.AppFeatureProvider").buildUpon().appendPath("app_feature").build();

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m9366a(ContentResolver contentResolver, String str, String str2) {
        String strM9369b = m9369b(contentResolver, str, "String");
        return strM9369b != null ? strM9369b : str2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m9367a(ContentResolver contentResolver, String str) {
        Cursor cursorM9368b = m9368b(contentResolver, str);
        boolean z = cursorM9368b != null && cursorM9368b.getCount() > 0;
        if (cursorM9368b != null) {
            cursorM9368b.close();
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0064 A[PHI: r0
      0x0064: PHI (r0v4 java.lang.String) = 
      (r0v3 java.lang.String)
      (r0v3 java.lang.String)
      (r0v3 java.lang.String)
      (r0v3 java.lang.String)
      (r0v5 java.lang.String)
     binds: [B:12:0x0021, B:14:0x0027, B:16:0x002f, B:18:0x0032, B:33:0x0061] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String m9369b(android.content.ContentResolver r7, java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r7 == 0) goto L6f
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 != 0) goto L6f
            if (r9 == 0) goto L6f
            android.database.Cursor r7 = m9368b(r7, r8)
            if (r7 == 0) goto L6a
            boolean r8 = r7.moveToFirst()
            if (r8 == 0) goto L6a
        L17:
            java.lang.String r8 = "parameters"
            int r8 = r7.getColumnIndex(r8)
            java.lang.String r8 = r7.getString(r8)
            if (r8 == 0) goto L64
            boolean r1 = r8.isEmpty()
            if (r1 != 0) goto L64
            java.lang.String r1 = ";"
            java.lang.String[] r8 = r8.split(r1)
            if (r8 == 0) goto L64
            int r1 = r8.length
            if (r1 <= 0) goto L64
            int r1 = r8.length
            r2 = 0
            r3 = r2
        L37:
            if (r3 >= r1) goto L61
            r4 = r8[r3]
            if (r4 == 0) goto L5e
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L5e
            java.lang.String r5 = ":"
            int r5 = r4.indexOf(r5)
            if (r5 <= 0) goto L5e
            java.lang.String r6 = r4.substring(r2, r5)
            if (r6 == 0) goto L5e
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L5e
            int r5 = r5 + 1
            java.lang.String r0 = r4.substring(r5)
            goto L61
        L5e:
            int r3 = r3 + 1
            goto L37
        L61:
            if (r0 == 0) goto L64
            goto L6a
        L64:
            boolean r8 = r7.moveToNext()
            if (r8 != 0) goto L17
        L6a:
            if (r7 == 0) goto L6f
            r7.close()
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.p123b.p124a.AppFeatureProviderUtils.m9369b(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Cursor m9368b(ContentResolver contentResolver, String str) {
        Cursor cursorM9361a = AppFeatureCache.f10456a ? AppFeatureCache.m9358a().m9361a(str) : null;
        return (cursorM9361a != null || AppFeatureCache.f10457b == AppFeatureCache.IntrinsicsJvm.kt_3.CACHE_ONLY) ? cursorM9361a : contentResolver.query(f10465a, null, "featurename=?", new String[]{str}, null);
    }
}
