package com.google.android.material.snackbar;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends android.widget.LinearLayout implements com.google.android.material.snackbar.ContentViewCallback {
    private android.widget.Button actionView;
    private int maxInlineActionWidth;
    private int maxWidth;
    private android.widget.TextView messageView;

    public SnackbarContentLayout(android.content.Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.SnackbarLayout);
        this.maxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.SnackbarLayout_android_maxWidth, -1);
        this.maxInlineActionWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (android.widget.TextView) findViewById(com.google.android.material.R_renamed.id_renamed.snackbar_text);
        this.actionView = (android.widget.Button) findViewById(com.google.android.material.R_renamed.id_renamed.snackbar_action);
    }

    public android.widget.TextView getMessageView() {
        return this.messageView;
    }

    public android.widget.Button getActionView() {
        return this.actionView;
    }

    void updateActionTextColorAlphaIfNeeded(float f_renamed) {
        if (f_renamed != 1.0f) {
            this.actionView.setTextColor(com.google.android.material.color.MaterialColors.layer(com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R_renamed.attr.colorSurface), this.actionView.getCurrentTextColor(), f_renamed));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x0061  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r8, int r9) throws android.content.res.Resources.NotFoundException {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.maxWidth
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.maxWidth
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.google.android.material.R_renamed.dimen.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.google.android.material.R_renamed.dimen.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.messageView
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3c
            r2 = r4
            goto L3d
        L3c:
            r2 = r3
        L3d:
            if (r2 == 0) goto L56
            int r5 = r7.maxInlineActionWidth
            if (r5 <= 0) goto L56
            android.widget.Button r5 = r7.actionView
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.maxInlineActionWidth
            if (r5 <= r6) goto L56
            int r1 = r0 - r1
            boolean r0 = r7.updateViewsWithinLayout(r4, r0, r1)
            if (r0 == 0) goto L61
            goto L62
        L56:
            if (r2 == 0) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            boolean r0 = r7.updateViewsWithinLayout(r3, r0, r0)
            if (r0 == 0) goto L61
            goto L62
        L61:
            r4 = r3
        L62:
            if (r4 == 0) goto L67
            super.onMeasure(r8, r9)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    private boolean updateViewsWithinLayout(int i_renamed, int i2, int i3) {
        boolean z_renamed;
        if (i_renamed != getOrientation()) {
            setOrientation(i_renamed);
            z_renamed = true;
        } else {
            z_renamed = false;
        }
        if (this.messageView.getPaddingTop() == i2 && this.messageView.getPaddingBottom() == i3) {
            return z_renamed;
        }
        updateTopBottomPadding(this.messageView, i2, i3);
        return true;
    }

    private static void updateTopBottomPadding(android.view.View view, int i_renamed, int i2) {
        if (androidx.core.h_renamed.v_renamed.v_renamed(view)) {
            androidx.core.h_renamed.v_renamed.b_renamed(view, androidx.core.h_renamed.v_renamed.j_renamed(view), i_renamed, androidx.core.h_renamed.v_renamed.k_renamed(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i_renamed, view.getPaddingRight(), i2);
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int i_renamed, int i2) {
        this.messageView.setAlpha(0.0f);
        long j_renamed = i2;
        long j2 = i_renamed;
        this.messageView.animate().alpha(1.0f).setDuration(j_renamed).setStartDelay(j2).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(0.0f);
            this.actionView.animate().alpha(1.0f).setDuration(j_renamed).setStartDelay(j2).start();
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int i_renamed, int i2) {
        this.messageView.setAlpha(1.0f);
        long j_renamed = i2;
        long j2 = i_renamed;
        this.messageView.animate().alpha(0.0f).setDuration(j_renamed).setStartDelay(j2).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(1.0f);
            this.actionView.animate().alpha(0.0f).setDuration(j_renamed).setStartDelay(j2).start();
        }
    }

    public void setMaxInlineActionWidth(int i_renamed) {
        this.maxInlineActionWidth = i_renamed;
    }
}
