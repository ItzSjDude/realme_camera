package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsBase.java */
/* renamed from: androidx.transition.aj */
/* loaded from: classes.dex */
class ViewUtilsBase {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Method f4538a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f4539b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Field f4540c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static boolean f4541d;

    ViewUtilsBase() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4742a(View view, float COUIBaseListPopupWindow_12) {
        Float f2 = (Float) view.getTag(R.id_renamed.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * COUIBaseListPopupWindow_12);
        } else {
            view.setAlpha(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float mo4741a(View view) {
        Float COUIBaseListPopupWindow_12 = (Float) view.getTag(R.id_renamed.save_non_transition_alpha);
        if (COUIBaseListPopupWindow_12 != null) {
            return view.getAlpha() / COUIBaseListPopupWindow_12.floatValue();
        }
        return view.getAlpha();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4743b(View view) {
        if (view.getTag(R.id_renamed.save_non_transition_alpha) == null) {
            view.setTag(R.id_renamed.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo4744c(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id_renamed.save_non_transition_alpha, null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4745a(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            mo4745a((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4746b(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            mo4746b((View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4747a(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m4749a();
        Method method = f4538a;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException COUIBaseListPopupWindow_8) {
                throw new RuntimeException(COUIBaseListPopupWindow_8.getCause());
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4748a(View view, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException {
        if (!f4541d) {
            try {
                f4540c = View.class.getDeclaredField("mViewFlags");
                f4540c.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.OplusGLSurfaceView_13("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f4541d = true;
        }
        Field field = f4540c;
        if (field != null) {
            try {
                f4540c.setInt(view, (field.getInt(view) & (-13)) | OplusGLSurfaceView_13);
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: PlatformImplementations.kt_3 */
    private void m4749a() {
        if (f4539b) {
            return;
        }
        try {
            f4538a = View.class.getDeclaredMethod("setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            f4538a.setAccessible(true);
        } catch (NoSuchMethodException COUIBaseListPopupWindow_8) {
            Log.OplusGLSurfaceView_13("ViewUtilsBase", "Failed to retrieve setFrame method", COUIBaseListPopupWindow_8);
        }
        f4539b = true;
    }
}
