package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.p036h.ViewCompat;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ViewUtils.java */
/* renamed from: androidx.transition.ad */
/* loaded from: classes.dex */
class ViewUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    static final Property<View, Float> f4529a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    static final Property<View, Rect> f4530b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final ViewUtilsBase f4531c;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f4531c = new ViewUtilsApi29();
        } else if (Build.VERSION.SDK_INT >= 23) {
            f4531c = new ViewUtilsApi23();
        } else if (Build.VERSION.SDK_INT >= 22) {
            f4531c = new ViewUtilsApi22();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f4531c = new ViewUtilsApi21();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f4531c = new ViewUtilsApi19();
        } else {
            f4531c = new ViewUtilsBase();
        }
        f4529a = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.transition.ad.1
            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public Float get(View view) {
                return Float.valueOf(ViewUtils.m4734c(view));
            }

            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public void set(View view, Float COUIBaseListPopupWindow_12) {
                ViewUtils.m4728a(view, COUIBaseListPopupWindow_12.floatValue());
            }
        };
        f4530b = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.transition.ad.2
            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public Rect get(View view) {
                return ViewCompat.m2825C(view);
            }

            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public void set(View view, Rect rect) {
                ViewCompat.m2849a(view, rect);
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static ViewOverlayImpl m4727a(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewOverlayApi18(view);
        }
        return ViewOverlayApi14.m4717d(view);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static WindowIdImpl m4732b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new WindowIdApi18(view);
        }
        return new WindowIdApi14(view.getWindowToken());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m4728a(View view, float COUIBaseListPopupWindow_12) {
        f4531c.mo4742a(view, COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    static float m4734c(View view) {
        return f4531c.mo4741a(view);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    static void m4735d(View view) {
        f4531c.mo4743b(view);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    static void m4736e(View view) {
        f4531c.mo4744c(view);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m4729a(View view, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException {
        f4531c.mo4748a(view, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m4731a(View view, Matrix matrix) {
        f4531c.mo4745a(view, matrix);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static void m4733b(View view, Matrix matrix) {
        f4531c.mo4746b(view, matrix);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m4730a(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        f4531c.mo4747a(view, OplusGLSurfaceView_13, i2, i3, i4);
    }
}
