package com.google.android.material.bottomsheet;

/* loaded from: classes.dex */
public class BottomSheetDialog extends androidx.appcompat.app.f_renamed {
    private com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> behavior;
    private com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private android.widget.FrameLayout container;
    boolean dismissWithAnimation;

    public BottomSheetDialog(android.content.Context context) {
        this(context, 0);
    }

    public BottomSheetDialog(android.content.Context context, int i_renamed) {
        super(context, getThemeResId(context, i_renamed));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.4
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(android.view.View view, float f_renamed) {
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(android.view.View view, int i2) {
                if (i2 == 5) {
                    com.google.android.material.bottomsheet.BottomSheetDialog.this.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
    }

    protected BottomSheetDialog(android.content.Context context, boolean z_renamed, android.content.DialogInterface.OnCancelListener onCancelListener) {
        super(context, z_renamed, onCancelListener);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.4
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(android.view.View view, float f_renamed) {
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(android.view.View view, int i2) {
                if (i2 == 5) {
                    com.google.android.material.bottomsheet.BottomSheetDialog.this.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
        this.cancelable = z_renamed;
    }

    @Override // androidx.appcompat.app.f_renamed, android.app.Dialog
    public void setContentView(int i_renamed) {
        super.setContentView(wrapInBottomSheet(i_renamed, null, null));
    }

    @Override // androidx.appcompat.app.f_renamed, android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        android.view.Window window = getWindow();
        if (window != null) {
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // androidx.appcompat.app.f_renamed, android.app.Dialog
    public void setContentView(android.view.View view) {
        super.setContentView(wrapInBottomSheet(0, view, null));
    }

    @Override // androidx.appcompat.app.f_renamed, android.app.Dialog
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams));
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z_renamed) {
        super.setCancelable(z_renamed);
        if (this.cancelable != z_renamed) {
            this.cancelable = z_renamed;
            com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z_renamed);
            }
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior == null || bottomSheetBehavior.getState() != 5) {
            return;
        }
        this.behavior.setState(4);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> behavior = getBehavior();
        if (!this.dismissWithAnimation || behavior.getState() == 5) {
            super.cancel();
        } else {
            behavior.setState(5);
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z_renamed) {
        super.setCanceledOnTouchOutside(z_renamed);
        if (z_renamed && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z_renamed;
        this.canceledOnTouchOutsideSet = true;
    }

    public com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> getBehavior() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        return this.behavior;
    }

    public void setDismissWithAnimation(boolean z_renamed) {
        this.dismissWithAnimation = z_renamed;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    private android.widget.FrameLayout ensureContainerAndBehavior() {
        if (this.container == null) {
            this.container = (android.widget.FrameLayout) android.view.View.inflate(getContext(), com.google.android.material.R_renamed.layout.design_bottom_sheet_dialog, null);
            this.behavior = com.google.android.material.bottomsheet.BottomSheetBehavior.from((android.widget.FrameLayout) this.container.findViewById(com.google.android.material.R_renamed.id_renamed.design_bottom_sheet));
            this.behavior.addBottomSheetCallback(this.bottomSheetCallback);
            this.behavior.setHideable(this.cancelable);
        }
        return this.container;
    }

    private android.view.View wrapInBottomSheet(int i_renamed, android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout = (androidx.coordinatorlayout.widget.CoordinatorLayout) this.container.findViewById(com.google.android.material.R_renamed.id_renamed.coordinator);
        if (i_renamed != 0 && view == null) {
            view = getLayoutInflater().inflate(i_renamed, (android.view.ViewGroup) coordinatorLayout, false);
        }
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) this.container.findViewById(com.google.android.material.R_renamed.id_renamed.design_bottom_sheet);
        frameLayout.removeAllViews();
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(com.google.android.material.R_renamed.id_renamed.touch_outside).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view2) {
                if (com.google.android.material.bottomsheet.BottomSheetDialog.this.cancelable && com.google.android.material.bottomsheet.BottomSheetDialog.this.isShowing() && com.google.android.material.bottomsheet.BottomSheetDialog.this.shouldWindowCloseOnTouchOutside()) {
                    com.google.android.material.bottomsheet.BottomSheetDialog.this.cancel();
                }
            }
        });
        androidx.core.h_renamed.v_renamed.a_renamed(frameLayout, new androidx.core.h_renamed.a_renamed() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.2
            @Override // androidx.core.h_renamed.a_renamed
            public void onInitializeAccessibilityNodeInfo(android.view.View view2, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
                super.onInitializeAccessibilityNodeInfo(view2, dVar);
                if (com.google.android.material.bottomsheet.BottomSheetDialog.this.cancelable) {
                    dVar.a_renamed(com.google.android.exoplayer2.source.ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
                    dVar.j_renamed(true);
                } else {
                    dVar.j_renamed(false);
                }
            }

            @Override // androidx.core.h_renamed.a_renamed
            public boolean performAccessibilityAction(android.view.View view2, int i2, android.os.Bundle bundle) {
                if (i2 == 1048576 && com.google.android.material.bottomsheet.BottomSheetDialog.this.cancelable) {
                    com.google.android.material.bottomsheet.BottomSheetDialog.this.cancel();
                    return true;
                }
                return super.performAccessibilityAction(view2, i2, bundle);
            }
        });
        frameLayout.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view2, android.view.MotionEvent motionEvent) {
                return true;
            }
        });
        return this.container;
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R_renamed.attr.windowCloseOnTouchOutside});
            this.canceledOnTouchOutside = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }

    private static int getThemeResId(android.content.Context context, int i_renamed) {
        if (i_renamed != 0) {
            return i_renamed;
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (context.getTheme().resolveAttribute(com.google.android.material.R_renamed.attr.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return com.google.android.material.R_renamed.style.Theme_Design_Light_BottomSheetDialog;
    }

    void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }
}
