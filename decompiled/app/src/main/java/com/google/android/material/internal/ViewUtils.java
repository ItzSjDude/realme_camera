package com.google.android.material.internal;

/* loaded from: classes.dex */
public class ViewUtils {

    public interface OnApplyWindowInsetsListener {
        androidx.core.h_renamed.ad_renamed onApplyWindowInsets(android.view.View view, androidx.core.h_renamed.ad_renamed adVar, com.google.android.material.internal.ViewUtils.RelativePadding relativePadding);
    }

    private ViewUtils() {
    }

    public static android.graphics.PorterDuff.Mode parseTintMode(int i_renamed, android.graphics.PorterDuff.Mode mode) {
        if (i_renamed == 3) {
            return android.graphics.PorterDuff.Mode.SRC_OVER;
        }
        if (i_renamed == 5) {
            return android.graphics.PorterDuff.Mode.SRC_IN;
        }
        if (i_renamed == 9) {
            return android.graphics.PorterDuff.Mode.SRC_ATOP;
        }
        switch (i_renamed) {
            case 14:
                return android.graphics.PorterDuff.Mode.MULTIPLY;
            case 15:
                return android.graphics.PorterDuff.Mode.SCREEN;
            case 16:
                return android.graphics.PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static boolean isLayoutRtl(android.view.View view) {
        return androidx.core.h_renamed.v_renamed.g_renamed(view) == 1;
    }

    public static float dpToPx(android.content.Context context, int i_renamed) {
        return android.util.TypedValue.applyDimension(1, i_renamed, context.getResources().getDisplayMetrics());
    }

    public static void requestFocusAndShowKeyboard(final android.view.View view) {
        view.requestFocus();
        view.post(new java.lang.Runnable() { // from class: com.google.android.material.internal.ViewUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ((android.view.inputmethod.InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
            }
        });
    }

    public static class RelativePadding {
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int i_renamed, int i2, int i3, int i4) {
            this.start = i_renamed;
            this.top = i2;
            this.end = i3;
            this.bottom = i4;
        }

        public RelativePadding(com.google.android.material.internal.ViewUtils.RelativePadding relativePadding) {
            this.start = relativePadding.start;
            this.top = relativePadding.top;
            this.end = relativePadding.end;
            this.bottom = relativePadding.bottom;
        }

        public void applyToView(android.view.View view) {
            androidx.core.h_renamed.v_renamed.b_renamed(view, this.start, this.top, this.end, this.bottom);
        }
    }

    public static void doOnApplyWindowInsets(android.view.View view, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        doOnApplyWindowInsets(view, attributeSet, i_renamed, i2, null);
    }

    public static void doOnApplyWindowInsets(android.view.View view, android.util.AttributeSet attributeSet, int i_renamed, int i2, final com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.Insets, i_renamed, i2);
        final boolean z_renamed = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.Insets_paddingBottomSystemWindowInsets, false);
        final boolean z2 = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.Insets_paddingLeftSystemWindowInsets, false);
        final boolean z3 = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.Insets_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        doOnApplyWindowInsets(view, new com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.internal.ViewUtils.2
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public androidx.core.h_renamed.ad_renamed onApplyWindowInsets(android.view.View view2, androidx.core.h_renamed.ad_renamed adVar, com.google.android.material.internal.ViewUtils.RelativePadding relativePadding) {
                if (z_renamed) {
                    relativePadding.bottom += adVar.d_renamed();
                }
                boolean zIsLayoutRtl = com.google.android.material.internal.ViewUtils.isLayoutRtl(view2);
                if (z2) {
                    if (zIsLayoutRtl) {
                        relativePadding.end += adVar.a_renamed();
                    } else {
                        relativePadding.start += adVar.a_renamed();
                    }
                }
                if (z3) {
                    if (zIsLayoutRtl) {
                        relativePadding.start += adVar.c_renamed();
                    } else {
                        relativePadding.end += adVar.c_renamed();
                    }
                }
                relativePadding.applyToView(view2);
                com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener onApplyWindowInsetsListener2 = onApplyWindowInsetsListener;
                return onApplyWindowInsetsListener2 != null ? onApplyWindowInsetsListener2.onApplyWindowInsets(view2, adVar, relativePadding) : adVar;
            }
        });
    }

    public static void doOnApplyWindowInsets(android.view.View view, final com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        final com.google.android.material.internal.ViewUtils.RelativePadding relativePadding = new com.google.android.material.internal.ViewUtils.RelativePadding(androidx.core.h_renamed.v_renamed.j_renamed(view), view.getPaddingTop(), androidx.core.h_renamed.v_renamed.k_renamed(view), view.getPaddingBottom());
        androidx.core.h_renamed.v_renamed.a_renamed(view, new androidx.core.h_renamed.q_renamed() { // from class: com.google.android.material.internal.ViewUtils.3
            @Override // androidx.core.h_renamed.q_renamed
            public androidx.core.h_renamed.ad_renamed onApplyWindowInsets(android.view.View view2, androidx.core.h_renamed.ad_renamed adVar) {
                return onApplyWindowInsetsListener.onApplyWindowInsets(view2, adVar, new com.google.android.material.internal.ViewUtils.RelativePadding(relativePadding));
            }
        });
        requestApplyInsetsWhenAttached(view);
    }

    public static void requestApplyInsetsWhenAttached(android.view.View view) {
        if (androidx.core.h_renamed.v_renamed.D_renamed(view)) {
            androidx.core.h_renamed.v_renamed.s_renamed(view);
        } else {
            view.addOnAttachStateChangeListener(new android.view.View.OnAttachStateChangeListener() { // from class: com.google.android.material.internal.ViewUtils.4
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(android.view.View view2) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(android.view.View view2) {
                    view2.removeOnAttachStateChangeListener(this);
                    androidx.core.h_renamed.v_renamed.s_renamed(view2);
                }
            });
        }
    }

    public static float getParentAbsoluteElevation(android.view.View view) {
        float fO_renamed = 0.0f;
        for (android.view.ViewParent parent = view.getParent(); parent instanceof android.view.View; parent = parent.getParent()) {
            fO_renamed += androidx.core.h_renamed.v_renamed.o_renamed((android.view.View) parent);
        }
        return fO_renamed;
    }

    public static com.google.android.material.internal.ViewOverlayImpl getOverlay(android.view.View view) {
        if (view == null) {
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            return new com.google.android.material.internal.ViewOverlayApi18(view);
        }
        return com.google.android.material.internal.ViewOverlayApi14.createFrom(view);
    }

    public static android.view.ViewGroup getContentView(android.view.View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof android.view.ViewGroup)) {
                return (android.view.ViewGroup) view;
            }
            if (view.getParent() instanceof android.view.ViewGroup) {
                view = (android.view.ViewGroup) view.getParent();
            } else if (view.getParent() == null) {
                break;
            }
        }
        return null;
    }

    public static com.google.android.material.internal.ViewOverlayImpl getContentViewOverlay(android.view.View view) {
        return getOverlay(getContentView(view));
    }
}
