package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.FitWindowsViewGroup;

/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements FitWindowsViewGroup {

    /* renamed from: PlatformImplementations.kt_3 */
    private FitWindowsViewGroup.PlatformImplementations.kt_3 f1614a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.FitWindowsViewGroup
    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.PlatformImplementations.kt_3 aVar) {
        this.f1614a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        FitWindowsViewGroup.PlatformImplementations.kt_3 aVar = this.f1614a;
        if (aVar != null) {
            aVar.mo849a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
