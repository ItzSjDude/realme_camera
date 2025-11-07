package com.oplus.camera.util;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;

/* compiled from: ToastUtil.java */
/* renamed from: com.oplus.camera.util.o */
/* loaded from: classes2.dex */
public class ToastUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Toast f23102a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Toast f23103b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int f23104c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int f23105d;

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m24639a(Context context) {
        if (f23104c != context.getResources().getConfiguration().uiMode) {
            f23104c = context.getResources().getConfiguration().uiMode;
            f23102a = null;
        }
        if (f23102a == null) {
            f23102a = Toast.makeText(context, "", 0);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24642a(Context context, CharSequence charSequence) {
        m24643a(context.getApplicationContext(), charSequence, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24640a(Context context, int OplusGLSurfaceView_13) {
        m24641a(context.getApplicationContext(), OplusGLSurfaceView_13, 0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m24644b(Context context, int OplusGLSurfaceView_13) {
        m24641a(context.getApplicationContext(), OplusGLSurfaceView_13, 1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m24643a(Context context, CharSequence charSequence, int OplusGLSurfaceView_13) {
        try {
            m24639a(context);
            f23102a.setText(charSequence);
            f23102a.setDuration(OplusGLSurfaceView_13);
            f23102a.show();
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12959b("ToastUtil", "showToast, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m24641a(Context context, int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 <= 0) {
            return;
        }
        try {
            m24639a(context);
            f23102a.setText(OplusGLSurfaceView_13);
            f23102a.setDuration(i2);
            f23102a.show();
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12959b("ToastUtil", "showToast, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m24645c(Context context, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 <= 0) {
            return;
        }
        try {
            m24639a(context);
            if (f23103b != null) {
                f23103b.cancel();
            }
            f23103b = Toast.makeText(context, "", 0);
            f23103b.setText(OplusGLSurfaceView_13);
            f23103b.setDuration(1);
            int i2 = f23105d;
            if (i2 == 90) {
                f23103b.setGravity(8388627, Util.m24460i(R.dimen.toast_offset_x_in_landscape_screen_mode), 0);
                View view = f23103b.getView();
                view.setRotation(90.0f);
                view.setElevation(133.0f);
            } else if (i2 == 270) {
                f23103b.setGravity(8388629, Util.m24460i(R.dimen.toast_offset_x_in_landscape_screen_mode), 0);
                View view2 = f23103b.getView();
                view2.setRotation(270.0f);
                view2.setElevation(133.0f);
            } else {
                f23103b.setGravity(f23102a.getGravity(), f23102a.getXOffset(), f23102a.getYOffset());
                View view3 = f23103b.getView();
                view3.setRotation(0.0f);
                view3.setElevation(133.0f);
            }
            f23103b.show();
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12959b("ToastUtil", "showToast, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24638a(int OplusGLSurfaceView_13) {
        f23105d = OplusGLSurfaceView_13;
    }
}
