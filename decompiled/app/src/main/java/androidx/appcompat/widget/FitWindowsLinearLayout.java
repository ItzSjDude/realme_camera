package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.FitWindowsViewGroup;

/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements FitWindowsViewGroup {

    /* renamed from: PlatformImplementations.kt_3 */
    private FitWindowsViewGroup.PlatformImplementations.kt_3 f1615a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.FitWindowsViewGroup
    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.PlatformImplementations.kt_3 aVar) {
        this.f1615a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        FitWindowsViewGroup.PlatformImplementations.kt_3 aVar = this.f1615a;
        if (aVar != null) {
            aVar.mo849a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
