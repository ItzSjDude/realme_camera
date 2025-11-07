package com.google.android.material.transformation;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class FabTransformationSheetBehavior extends com.google.android.material.transformation.FabTransformationBehavior {
    private java.util.Map<android.view.View, java.lang.Integer> importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    protected com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(android.content.Context context, boolean z_renamed) {
        int i_renamed;
        if (z_renamed) {
            i_renamed = com.google.android.material.R_renamed.animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i_renamed = com.google.android.material.R_renamed.animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec fabTransformationSpec = new com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec();
        fabTransformationSpec.timings = com.google.android.material.animation.MotionSpec.createFromResource(context, i_renamed);
        fabTransformationSpec.positioning = new com.google.android.material.animation.Positioning(17, 0.0f, 0.0f);
        return fabTransformationSpec;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    protected boolean onExpandedStateChange(android.view.View view, android.view.View view2, boolean z_renamed, boolean z2) {
        updateImportantForAccessibility(view2, z_renamed);
        return super.onExpandedStateChange(view, view2, z_renamed, z2);
    }

    private void updateImportantForAccessibility(android.view.View view, boolean z_renamed) {
        android.view.ViewParent parent = view.getParent();
        if (parent instanceof androidx.coordinatorlayout.widget.CoordinatorLayout) {
            androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout = (androidx.coordinatorlayout.widget.CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (android.os.Build.VERSION.SDK_INT >= 16 && z_renamed) {
                this.importantForAccessibilityMap = new java.util.HashMap(childCount);
            }
            for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                android.view.View childAt = coordinatorLayout.getChildAt(i_renamed);
                boolean z2 = (childAt.getLayoutParams() instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) && (((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) childAt.getLayoutParams()).b_renamed() instanceof com.google.android.material.transformation.FabTransformationScrimBehavior);
                if (childAt != view && !z2) {
                    if (!z_renamed) {
                        java.util.Map<android.view.View, java.lang.Integer> map = this.importantForAccessibilityMap;
                        if (map != null && map.containsKey(childAt)) {
                            androidx.core.h_renamed.v_renamed.b_renamed(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                        }
                    } else {
                        if (android.os.Build.VERSION.SDK_INT >= 16) {
                            this.importantForAccessibilityMap.put(childAt, java.lang.Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        androidx.core.h_renamed.v_renamed.b_renamed(childAt, 4);
                    }
                }
            }
            if (z_renamed) {
                return;
            }
            this.importantForAccessibilityMap = null;
        }
    }
}
