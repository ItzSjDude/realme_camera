package com.google.android.material.transition;

/* loaded from: classes.dex */
public class MaterialContainerTransformSharedElementCallback extends android.app.SharedElementCallback {
    private static java.lang.ref.WeakReference<android.view.View> capturedSharedElement;
    private android.graphics.Rect returnEndBounds;
    private boolean entering = true;
    private boolean transparentWindowBackgroundEnabled = true;

    @Override // android.app.SharedElementCallback
    public android.os.Parcelable onCaptureSharedElementSnapshot(android.view.View view, android.graphics.Matrix matrix, android.graphics.RectF rectF) {
        capturedSharedElement = new java.lang.ref.WeakReference<>(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    public android.view.View onCreateSnapshotView(android.content.Context context, android.os.Parcelable parcelable) {
        android.view.View viewOnCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        java.lang.ref.WeakReference<android.view.View> weakReference = capturedSharedElement;
        if (weakReference != null && (weakReference.get() instanceof com.google.android.material.shape.Shapeable)) {
            viewOnCreateSnapshotView.setTag(((com.google.android.material.shape.Shapeable) capturedSharedElement.get()).getShapeAppearanceModel());
        }
        return viewOnCreateSnapshotView;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(java.util.List<java.lang.String> list, java.util.Map<java.lang.String, android.view.View> map) {
        android.view.View view;
        android.app.Activity activity;
        if (list.isEmpty() || map.isEmpty() || (view = map.get(list.get(0))) == null || (activity = com.google.android.material.internal.ContextUtils.getActivity(view.getContext())) == null) {
            return;
        }
        android.view.Window window = activity.getWindow();
        if (this.entering) {
            setUpEnterTransform(window);
        } else {
            setUpReturnTransform(activity, window);
        }
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(java.util.List<java.lang.String> list, java.util.List<android.view.View> list2, java.util.List<android.view.View> list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            list2.get(0).setTag(list3.get(0));
        }
        if (this.entering || list2.isEmpty() || this.returnEndBounds == null) {
            return;
        }
        android.view.View view = list2.get(0);
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), 1073741824));
        view.layout(this.returnEndBounds.left, this.returnEndBounds.top, this.returnEndBounds.right, this.returnEndBounds.bottom);
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(java.util.List<java.lang.String> list, java.util.List<android.view.View> list2, java.util.List<android.view.View> list3) {
        if (!list2.isEmpty() && (list2.get(0).getTag() instanceof android.view.View)) {
            list2.get(0).setTag(null);
        }
        if (!this.entering && !list2.isEmpty()) {
            this.returnEndBounds = com.google.android.material.transition.TransitionUtils.getRelativeBoundsRect(list2.get(0));
        }
        this.entering = false;
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        return this.transparentWindowBackgroundEnabled;
    }

    public void setTransparentWindowBackgroundEnabled(boolean z_renamed) {
        this.transparentWindowBackgroundEnabled = z_renamed;
    }

    private void setUpEnterTransform(final android.view.Window window) {
        android.transition.Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
        if (sharedElementEnterTransition instanceof com.google.android.material.transition.MaterialContainerTransform) {
            com.google.android.material.transition.MaterialContainerTransform materialContainerTransform = (com.google.android.material.transition.MaterialContainerTransform) sharedElementEnterTransition;
            if (this.transparentWindowBackgroundEnabled) {
                updateBackgroundFadeDuration(window, materialContainerTransform);
                materialContainerTransform.addListener(new com.google.android.material.transition.TransitionListenerAdapter() { // from class: com.google.android.material.transition.MaterialContainerTransformSharedElementCallback.1
                    @Override // com.google.android.material.transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionStart(android.transition.Transition transition) {
                        com.google.android.material.transition.MaterialContainerTransformSharedElementCallback.removeWindowBackground(window);
                    }

                    @Override // com.google.android.material.transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionEnd(android.transition.Transition transition) {
                        com.google.android.material.transition.MaterialContainerTransformSharedElementCallback.restoreWindowBackground(window);
                    }
                });
            }
        }
    }

    private void setUpReturnTransform(final android.app.Activity activity, final android.view.Window window) {
        android.transition.Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
        if (sharedElementReturnTransition instanceof com.google.android.material.transition.MaterialContainerTransform) {
            com.google.android.material.transition.MaterialContainerTransform materialContainerTransform = (com.google.android.material.transition.MaterialContainerTransform) sharedElementReturnTransition;
            materialContainerTransform.setHoldAtEndEnabled(true);
            materialContainerTransform.addListener(new com.google.android.material.transition.TransitionListenerAdapter() { // from class: com.google.android.material.transition.MaterialContainerTransformSharedElementCallback.2
                @Override // com.google.android.material.transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                public void onTransitionEnd(android.transition.Transition transition) {
                    if (com.google.android.material.transition.MaterialContainerTransformSharedElementCallback.capturedSharedElement != null && com.google.android.material.transition.MaterialContainerTransformSharedElementCallback.capturedSharedElement.get() != null) {
                        ((android.view.View) com.google.android.material.transition.MaterialContainerTransformSharedElementCallback.capturedSharedElement.get()).setAlpha(1.0f);
                        java.lang.ref.WeakReference unused = com.google.android.material.transition.MaterialContainerTransformSharedElementCallback.capturedSharedElement = null;
                    }
                    activity.finish();
                    activity.overridePendingTransition(0, 0);
                }
            });
            if (this.transparentWindowBackgroundEnabled) {
                updateBackgroundFadeDuration(window, materialContainerTransform);
                materialContainerTransform.addListener(new com.google.android.material.transition.TransitionListenerAdapter() { // from class: com.google.android.material.transition.MaterialContainerTransformSharedElementCallback.3
                    @Override // com.google.android.material.transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionStart(android.transition.Transition transition) {
                        com.google.android.material.transition.MaterialContainerTransformSharedElementCallback.removeWindowBackground(window);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void removeWindowBackground(android.view.Window window) {
        window.getDecorView().getBackground().mutate().setColorFilter(androidx.core.graphics.a_renamed.a_renamed(0, androidx.core.graphics.b_renamed.CLEAR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void restoreWindowBackground(android.view.Window window) {
        window.getDecorView().getBackground().mutate().clearColorFilter();
    }

    private static void updateBackgroundFadeDuration(android.view.Window window, com.google.android.material.transition.MaterialContainerTransform materialContainerTransform) {
        window.setTransitionBackgroundFadeDuration(materialContainerTransform.getDuration() * 2);
    }
}
