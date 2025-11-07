package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* compiled from: ImageBeautyTools.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.o */
/* loaded from: classes2.dex */
public class ImageBeautyTools {

    /* renamed from: PlatformImplementations.kt_3 */
    private static File f21404a;

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m22674a(Context context) {
        if (f21404a == null) {
            f21404a = new File(context.getFilesDir() + File.separator + "register.info");
        }
        return f21404a.exists() ? 1 : 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m22675b(Context context) {
        if (f21404a == null) {
            f21404a = new File(context.getFilesDir() + File.separator + "register.info");
        }
        if (f21404a.exists()) {
            return f21404a.delete();
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m22676c(Context context) {
        if (f21404a == null) {
            f21404a = new File(context.getFilesDir() + File.separator + "register.info");
        }
        if (f21404a.exists()) {
            return true;
        }
        try {
            return f21404a.createNewFile();
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }
}
