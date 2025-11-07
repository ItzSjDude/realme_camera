package com.oplus.camera.ui.preview;

/* loaded from: classes2.dex */
public class PreviewFrameLayout extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.preview.PreviewFrameLayout.OnSizeChangedListener f6814a;

    public interface OnSizeChangedListener {
        void a_renamed(int i_renamed, int i2, int i3, int i4);
    }

    public PreviewFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSizeChangedListener(com.oplus.camera.ui.preview.PreviewFrameLayout.OnSizeChangedListener onSizeChangedListener) {
        this.f6814a = onSizeChangedListener;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        com.oplus.camera.ui.preview.PreviewFrameLayout.OnSizeChangedListener onSizeChangedListener = this.f6814a;
        if (onSizeChangedListener != null) {
            onSizeChangedListener.a_renamed(i_renamed, i2, i3, i4);
        }
    }
}
