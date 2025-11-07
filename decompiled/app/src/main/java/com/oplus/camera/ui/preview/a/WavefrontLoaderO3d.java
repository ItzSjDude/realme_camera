package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: ImageBeautyTools.java */
/* loaded from: classes2.dex */
public class o_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.io.File f6924a;

    public static int a_renamed(android.content.Context context) {
        if (f6924a == null) {
            f6924a = new java.io.File(context.getFilesDir() + java.io.File.separator + "register.info");
        }
        return f6924a.exists() ? 1 : 0;
    }

    public static boolean b_renamed(android.content.Context context) {
        if (f6924a == null) {
            f6924a = new java.io.File(context.getFilesDir() + java.io.File.separator + "register.info");
        }
        if (f6924a.exists()) {
            return f6924a.delete();
        }
        return true;
    }

    public static boolean c_renamed(android.content.Context context) {
        if (f6924a == null) {
            f6924a = new java.io.File(context.getFilesDir() + java.io.File.separator + "register.info");
        }
        if (f6924a.exists()) {
            return true;
        }
        try {
            return f6924a.createNewFile();
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
            return false;
        }
    }
}
