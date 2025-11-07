package com.oplus.camera.p153l;

import android.content.ContentResolver;
import com.oplus.camera.MyApplication;
import com.oplus.p123b.p124a.AppFeatureProviderUtils;

/* compiled from: MyRegionFeatureUtils.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_14.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class MyRegionFeatureUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f14503a = "IntrinsicsJvm.kt_4";

    /* renamed from: PlatformImplementations.kt_3 */
    private static ContentResolver m14518a() {
        return MyApplication.m11092d().getContentResolver();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m14520a(String str) {
        return AppFeatureProviderUtils.m9367a(m14518a(), str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m14519a(String str, String str2) {
        return AppFeatureProviderUtils.m9366a(m14518a(), str, str2);
    }
}
