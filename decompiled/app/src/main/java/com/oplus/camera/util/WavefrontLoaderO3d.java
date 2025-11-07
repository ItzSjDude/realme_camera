package com.oplus.camera.util;

/* compiled from: ToastUtil.java */
/* loaded from: classes2.dex */
public class o_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static android.widget.Toast f7365a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static android.widget.Toast f7366b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static int f7367c;
    private static int d_renamed;

    private static void a_renamed(android.content.Context context) {
        if (f7367c != context.getResources().getConfiguration().uiMode) {
            f7367c = context.getResources().getConfiguration().uiMode;
            f7365a = null;
        }
        if (f7365a == null) {
            f7365a = android.widget.Toast.makeText(context, "", 0);
        }
    }

    public static void a_renamed(android.content.Context context, java.lang.CharSequence charSequence) {
        a_renamed(context.getApplicationContext(), charSequence, 0);
    }

    public static void a_renamed(android.content.Context context, int i_renamed) {
        a_renamed(context.getApplicationContext(), i_renamed, 0);
    }

    public static void b_renamed(android.content.Context context, int i_renamed) {
        a_renamed(context.getApplicationContext(), i_renamed, 1);
    }

    private static void a_renamed(android.content.Context context, java.lang.CharSequence charSequence, int i_renamed) {
        try {
            a_renamed(context);
            f7365a.setText(charSequence);
            f7365a.setDuration(i_renamed);
            f7365a.show();
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.b_renamed("ToastUtil", "showToast, e_renamed: " + e_renamed);
        }
    }

    private static void a_renamed(android.content.Context context, int i_renamed, int i2) {
        if (i_renamed <= 0) {
            return;
        }
        try {
            a_renamed(context);
            f7365a.setText(i_renamed);
            f7365a.setDuration(i2);
            f7365a.show();
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.b_renamed("ToastUtil", "showToast, e_renamed: " + e_renamed);
        }
    }

    public static void c_renamed(android.content.Context context, int i_renamed) {
        if (i_renamed <= 0) {
            return;
        }
        try {
            a_renamed(context);
            if (f7366b != null) {
                f7366b.cancel();
            }
            f7366b = android.widget.Toast.makeText(context, "", 0);
            f7366b.setText(i_renamed);
            f7366b.setDuration(1);
            int i2 = d_renamed;
            if (i2 == 90) {
                f7366b.setGravity(8388627, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.toast_offset_x_in_landscape_screen_mode), 0);
                android.view.View view = f7366b.getView();
                view.setRotation(90.0f);
                view.setElevation(133.0f);
            } else if (i2 == 270) {
                f7366b.setGravity(8388629, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.toast_offset_x_in_landscape_screen_mode), 0);
                android.view.View view2 = f7366b.getView();
                view2.setRotation(270.0f);
                view2.setElevation(133.0f);
            } else {
                f7366b.setGravity(f7365a.getGravity(), f7365a.getXOffset(), f7365a.getYOffset());
                android.view.View view3 = f7366b.getView();
                view3.setRotation(0.0f);
                view3.setElevation(133.0f);
            }
            f7366b.show();
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.b_renamed("ToastUtil", "showToast, e_renamed: " + e_renamed);
        }
    }

    public static void a_renamed(int i_renamed) {
        d_renamed = i_renamed;
    }
}
