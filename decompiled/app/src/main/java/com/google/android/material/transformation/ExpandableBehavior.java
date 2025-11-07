package com.google.android.material.transformation;

@java.lang.Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed<android.view.View> {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED = 0;
    private int currentState;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public abstract boolean layoutDependsOn(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2);

    protected abstract boolean onExpandedStateChange(android.view.View view, android.view.View view2, boolean z_renamed, boolean z2);

    public ExpandableBehavior() {
        this.currentState = 0;
    }

    public ExpandableBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentState = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, final android.view.View view, int i_renamed) {
        final com.google.android.material.expandable.ExpandableWidget expandableWidgetFindExpandableWidget;
        if (androidx.core.h_renamed.v_renamed.A_renamed(view) || (expandableWidgetFindExpandableWidget = findExpandableWidget(coordinatorLayout, view)) == null || !didStateChange(expandableWidgetFindExpandableWidget.isExpanded())) {
            return false;
        }
        this.currentState = expandableWidgetFindExpandableWidget.isExpanded() ? 1 : 2;
        final int i2 = this.currentState;
        view.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.transformation.ExpandableBehavior.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                if (com.google.android.material.transformation.ExpandableBehavior.this.currentState == i2) {
                    com.google.android.material.transformation.ExpandableBehavior expandableBehavior = com.google.android.material.transformation.ExpandableBehavior.this;
                    com.google.android.material.expandable.ExpandableWidget expandableWidget = expandableWidgetFindExpandableWidget;
                    expandableBehavior.onExpandedStateChange((android.view.View) expandableWidget, view, expandableWidget.isExpanded(), false);
                }
                return false;
            }
        });
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onDependentViewChanged(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2) {
        com.google.android.material.expandable.ExpandableWidget expandableWidget = (com.google.android.material.expandable.ExpandableWidget) view2;
        if (!didStateChange(expandableWidget.isExpanded())) {
            return false;
        }
        this.currentState = expandableWidget.isExpanded() ? 1 : 2;
        return onExpandedStateChange((android.view.View) expandableWidget, view, expandableWidget.isExpanded(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected com.google.android.material.expandable.ExpandableWidget findExpandableWidget(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view) {
        java.util.List<android.view.View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            android.view.View view2 = dependencies.get(i_renamed);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (com.google.android.material.expandable.ExpandableWidget) view2;
            }
        }
        return null;
    }

    private boolean didStateChange(boolean z_renamed) {
        if (!z_renamed) {
            return this.currentState == 1;
        }
        int i_renamed = this.currentState;
        return i_renamed == 0 || i_renamed == 2;
    }

    public static <T_renamed extends com.google.android.material.transformation.ExpandableBehavior> T_renamed from(android.view.View view, java.lang.Class<T_renamed> cls) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed)) {
            throw new java.lang.IllegalArgumentException("The view is_renamed not a_renamed child of_renamed CoordinatorLayout");
        }
        androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed bVarB = ((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) layoutParams).b_renamed();
        if (!(bVarB instanceof com.google.android.material.transformation.ExpandableBehavior)) {
            throw new java.lang.IllegalArgumentException("The view is_renamed not associated with ExpandableBehavior");
        }
        return cls.cast(bVarB);
    }
}
