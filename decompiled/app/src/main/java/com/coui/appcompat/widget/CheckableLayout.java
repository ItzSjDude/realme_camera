package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class CheckableLayout extends android.widget.RelativeLayout implements android.widget.Checkable {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.widget.Checkable f2852a;

    public CheckableLayout(android.content.Context context) {
        super(context);
    }

    public CheckableLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CheckableLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                android.view.KeyEvent.Callback childAt = getChildAt(i_renamed);
                if (childAt instanceof android.widget.Checkable) {
                    this.f2852a = (android.widget.Checkable) childAt;
                    return;
                }
            }
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z_renamed) {
        android.widget.Checkable checkable = this.f2852a;
        if (checkable != null) {
            checkable.setChecked(z_renamed);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        android.widget.Checkable checkable = this.f2852a;
        return checkable != null && checkable.isChecked();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        android.widget.Checkable checkable = this.f2852a;
        if (checkable != null) {
            checkable.toggle();
        }
    }
}
