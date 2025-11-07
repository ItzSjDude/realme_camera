package androidx.preference;

/* loaded from: classes.dex */
public class UnPressableLinearLayout extends android.widget.LinearLayout {
    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z_renamed) {
    }

    public UnPressableLinearLayout(android.content.Context context) {
        this(context, null);
    }

    public UnPressableLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
