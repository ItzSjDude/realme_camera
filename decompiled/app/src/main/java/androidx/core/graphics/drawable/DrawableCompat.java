package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: DrawableCompat.java */
/* renamed from: androidx.core.graphics.drawable.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class DrawableCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Method f2954a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f2955b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Method f2956c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static boolean f2957d;

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2566a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2574a(Drawable drawable, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m2575b(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2567a(Drawable drawable, float COUIBaseListPopupWindow_12, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(COUIBaseListPopupWindow_12, f2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2569a(Drawable drawable, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2568a(Drawable drawable, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(OplusGLSurfaceView_13);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTint(OplusGLSurfaceView_13);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2570a(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2573a(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintMode(mode);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m2577c(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2571a(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static boolean m2578d(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static ColorFilter m2579e(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public static void m2580f(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                m2580f(((InsetDrawable) drawable).getDrawable());
                return;
            }
            if (drawable instanceof WrappedDrawable) {
                m2580f(((WrappedDrawable) drawable).mo2584a());
                return;
            }
            if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
                return;
            }
            int childCount = drawableContainerState.getChildCount();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                Drawable child = drawableContainerState.getChild(OplusGLSurfaceView_13);
                if (child != null) {
                    m2580f(child);
                }
            }
            return;
        }
        drawable.clearColorFilter();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2572a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static Drawable m2581g(Drawable drawable) {
        return Build.VERSION.SDK_INT >= 23 ? drawable : Build.VERSION.SDK_INT >= 21 ? !(drawable instanceof TintAwareDrawable) ? new WrappedDrawableApi21(drawable) : drawable : !(drawable instanceof TintAwareDrawable) ? new WrappedDrawableApi14(drawable) : drawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public static <T extends Drawable> T m2582h(Drawable drawable) {
        return drawable instanceof WrappedDrawable ? (T) ((WrappedDrawable) drawable).mo2584a() : drawable;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m2576b(Drawable drawable, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(OplusGLSurfaceView_13);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (!f2955b) {
                try {
                    f2954a = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    f2954a.setAccessible(true);
                } catch (NoSuchMethodException COUIBaseListPopupWindow_8) {
                    Log.OplusGLSurfaceView_13("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", COUIBaseListPopupWindow_8);
                }
                f2955b = true;
            }
            Method method = f2954a;
            if (method != null) {
                try {
                    method.invoke(drawable, Integer.valueOf(OplusGLSurfaceView_13));
                    return true;
                } catch (Exception e2) {
                    Log.OplusGLSurfaceView_13("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    f2954a = null;
                }
            }
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static int m2583i(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (!f2957d) {
                try {
                    f2956c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f2956c.setAccessible(true);
                } catch (NoSuchMethodException COUIBaseListPopupWindow_8) {
                    Log.OplusGLSurfaceView_13("DrawableCompat", "Failed to retrieve getLayoutDirection() method", COUIBaseListPopupWindow_8);
                }
                f2957d = true;
            }
            Method method = f2956c;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e2) {
                    Log.OplusGLSurfaceView_13("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e2);
                    f2956c = null;
                }
            }
        }
        return 0;
    }
}
