package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.p018b.p019a.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: DrawableUtils.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.widget.aa */
/* loaded from: classes.dex */
public class DrawableUtils {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Class<?> f1719d;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final int[] f1717b = {R.attr.state_checked};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final int[] f1718c = new int[0];

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Rect f1716a = new Rect();

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f1719d = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* renamed from: PlatformImplementations.kt_3 */
    public static Rect m1395a(Drawable drawable) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            Insets opticalInsets = drawable.getOpticalInsets();
            Rect rect = new Rect();
            rect.left = opticalInsets.left;
            rect.right = opticalInsets.right;
            rect.top = opticalInsets.top;
            rect.bottom = opticalInsets.bottom;
            return rect;
        }
        if (f1719d != null) {
            try {
                Drawable drawableM2582h = DrawableCompat.m2582h(drawable);
                Object objInvoke = drawableM2582h.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(drawableM2582h, new Object[0]);
                if (objInvoke != null) {
                    Rect rect2 = new Rect();
                    for (Field field : f1719d.getFields()) {
                        String name = field.getName();
                        char c2 = 65535;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals(TtmlNode.LEFT)) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals(TtmlNode.RIGHT)) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                        }
                        if (c2 == 0) {
                            rect2.left = field.getInt(objInvoke);
                        } else if (c2 == 1) {
                            rect2.top = field.getInt(objInvoke);
                        } else if (c2 == 2) {
                            rect2.right = field.getInt(objInvoke);
                        } else if (c2 == 3) {
                            rect2.bottom = field.getInt(objInvoke);
                        }
                    }
                    return rect2;
                }
            } catch (Exception unused) {
                Log.COUIBaseListPopupWindow_8("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f1716a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static void m1396b(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m1398d(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m1397c(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!m1397c(drawable2)) {
                    return false;
                }
            }
            return true;
        }
        if (drawable instanceof WrappedDrawable) {
            return m1397c(((WrappedDrawable) drawable).mo2584a());
        }
        if (drawable instanceof DrawableWrapper) {
            return m1397c(((DrawableWrapper) drawable).getWrappedDrawable());
        }
        if (drawable instanceof ScaleDrawable) {
            return m1397c(((ScaleDrawable) drawable).getDrawable());
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static void m1398d(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1717b);
        } else {
            drawable.setState(f1718c);
        }
        drawable.setState(state);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static PorterDuff.Mode m1394a(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
        if (OplusGLSurfaceView_13 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (OplusGLSurfaceView_13 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (OplusGLSurfaceView_13 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (OplusGLSurfaceView_13) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
