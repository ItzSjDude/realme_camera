package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.core.p036h.WindowInsetsCompat;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.OnApplyWindowInsetsListener;
import com.google.android.material.C1694R;

/* loaded from: classes.dex */
public class ViewUtils {

    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat c0490ad, RelativePadding relativePadding);
    }

    private ViewUtils() {
    }

    public static PorterDuff.Mode parseTintMode(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
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

    public static boolean isLayoutRtl(View view) {
        return ViewCompat.m2885g(view) == 1;
    }

    public static float dpToPx(Context context, int OplusGLSurfaceView_13) {
        return TypedValue.applyDimension(1, OplusGLSurfaceView_13, context.getResources().getDisplayMetrics());
    }

    public static void requestFocusAndShowKeyboard(final View view) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.ViewUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
            }
        });
    }

    public static class RelativePadding {
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            this.start = OplusGLSurfaceView_13;
            this.top = i2;
            this.end = i3;
            this.bottom = i4;
        }

        public RelativePadding(RelativePadding relativePadding) {
            this.start = relativePadding.start;
            this.top = relativePadding.top;
            this.end = relativePadding.end;
            this.bottom = relativePadding.bottom;
        }

        public void applyToView(View view) {
            ViewCompat.m2868b(view, this.start, this.top, this.end, this.bottom);
        }
    }

    public static void doOnApplyWindowInsets(View view, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        doOnApplyWindowInsets(view, attributeSet, OplusGLSurfaceView_13, i2, null);
    }

    public static void doOnApplyWindowInsets(View view, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, C1694R.styleable.Insets, OplusGLSurfaceView_13, i2);
        final boolean z = typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        final boolean z2 = typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        final boolean z3 = typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.Insets_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        doOnApplyWindowInsets(view, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.internal.ViewUtils.2
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat c0490ad, RelativePadding relativePadding) {
                if (z) {
                    relativePadding.bottom += c0490ad.m2763d();
                }
                boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(view2);
                if (z2) {
                    if (zIsLayoutRtl) {
                        relativePadding.end += c0490ad.m2759a();
                    } else {
                        relativePadding.start += c0490ad.m2759a();
                    }
                }
                if (z3) {
                    if (zIsLayoutRtl) {
                        relativePadding.start += c0490ad.m2762c();
                    } else {
                        relativePadding.end += c0490ad.m2762c();
                    }
                }
                relativePadding.applyToView(view2);
                OnApplyWindowInsetsListener onApplyWindowInsetsListener2 = onApplyWindowInsetsListener;
                return onApplyWindowInsetsListener2 != null ? onApplyWindowInsetsListener2.onApplyWindowInsets(view2, c0490ad, relativePadding) : c0490ad;
            }
        });
    }

    public static void doOnApplyWindowInsets(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        final RelativePadding relativePadding = new RelativePadding(ViewCompat.m2891j(view), view.getPaddingTop(), ViewCompat.m2892k(view), view.getPaddingBottom());
        ViewCompat.m2855a(view, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.internal.ViewUtils.3
            @Override // androidx.core.p036h.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat c0490ad) {
                return onApplyWindowInsetsListener.onApplyWindowInsets(view2, c0490ad, new RelativePadding(relativePadding));
            }
        });
        requestApplyInsetsWhenAttached(view);
    }

    public static void requestApplyInsetsWhenAttached(View view) {
        if (ViewCompat.m2826D(view)) {
            ViewCompat.m2900s(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.internal.ViewUtils.4
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewCompat.m2900s(view2);
                }
            });
        }
    }

    public static float getParentAbsoluteElevation(View view) {
        float fM2896o = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fM2896o += ViewCompat.m2896o((View) parent);
        }
        return fM2896o;
    }

    public static ViewOverlayImpl getOverlay(View view) {
        if (view == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewOverlayApi18(view);
        }
        return ViewOverlayApi14.createFrom(view);
    }

    public static ViewGroup getContentView(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            } else if (view.getParent() == null) {
                break;
            }
        }
        return null;
    }

    public static ViewOverlayImpl getContentViewOverlay(View view) {
        return getOverlay(getContentView(view));
    }
}
