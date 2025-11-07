package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends android.widget.FrameLayout implements androidx.appcompat.widget.ac_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.appcompat.widget.ac_renamed.a_renamed f479a;

    public FitWindowsFrameLayout(android.content.Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.ac_renamed
    public void setOnFitSystemWindowsListener(androidx.appcompat.widget.ac_renamed.a_renamed aVar) {
        this.f479a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(android.graphics.Rect rect) {
        androidx.appcompat.widget.ac_renamed.a_renamed aVar = this.f479a;
        if (aVar != null) {
            aVar.a_renamed(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
