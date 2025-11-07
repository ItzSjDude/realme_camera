package com.google.android.material.transition;

/* loaded from: classes.dex */
public class MaterialContainerTransform extends android.transition.Transition {
    private static final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS;
    private static final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS_ARC;
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    private com.google.android.material.shape.ShapeAppearanceModel endShapeAppearanceModel;
    private android.view.View endView;
    private com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds fadeProgressThresholds;
    private com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds scaleMaskProgressThresholds;
    private com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds scaleProgressThresholds;
    private com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds shapeMaskProgressThresholds;
    private com.google.android.material.shape.ShapeAppearanceModel startShapeAppearanceModel;
    private android.view.View startView;
    private static final java.lang.String PROP_BOUNDS = "materialContainerTransition:bounds";
    private static final java.lang.String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
    private static final java.lang.String[] TRANSITION_PROPS = {PROP_BOUNDS, PROP_SHAPE_APPEARANCE};
    private static final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS = new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup(new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 0.25f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 1.0f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 1.0f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 0.75f));
    private static final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS_ARC = new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup(new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.1f, 0.4f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.1f, 1.0f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.1f, 1.0f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.1f, 0.9f));
    private boolean drawDebugEnabled = false;
    private boolean holdAtEndEnabled = false;
    private int drawingViewId = android.R_renamed.id_renamed.content;
    private int startViewId = -1;
    private int endViewId = -1;
    private int containerColor = 0;
    private int scrimColor = -1;
    private int transitionDirection = 0;
    private int fadeMode = 0;
    private int fitMode = 0;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FadeMode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FitMode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface TransitionDirection {
    }

    static {
        DEFAULT_RETURN_THRESHOLDS = new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup(new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.6f, 0.9f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 1.0f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 0.9f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.3f, 0.9f));
        DEFAULT_RETURN_THRESHOLDS_ARC = new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup(new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.6f, 0.9f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 0.9f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.0f, 0.9f), new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds(0.2f, 0.9f));
    }

    public MaterialContainerTransform() {
        setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    public int getStartViewId() {
        return this.startViewId;
    }

    public void setStartViewId(int i_renamed) {
        this.startViewId = i_renamed;
    }

    public int getEndViewId() {
        return this.endViewId;
    }

    public void setEndViewId(int i_renamed) {
        this.endViewId = i_renamed;
    }

    public android.view.View getStartView() {
        return this.startView;
    }

    public void setStartView(android.view.View view) {
        this.startView = view;
    }

    public android.view.View getEndView() {
        return this.endView;
    }

    public void setEndView(android.view.View view) {
        this.endView = view;
    }

    public com.google.android.material.shape.ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    public void setStartShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.startShapeAppearanceModel = shapeAppearanceModel;
    }

    public com.google.android.material.shape.ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    public void setEndShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.endShapeAppearanceModel = shapeAppearanceModel;
    }

    public int getDrawingViewId() {
        return this.drawingViewId;
    }

    public void setDrawingViewId(int i_renamed) {
        this.drawingViewId = i_renamed;
    }

    public int getContainerColor() {
        return this.containerColor;
    }

    public void setContainerColor(int i_renamed) {
        this.containerColor = i_renamed;
    }

    public int getScrimColor() {
        return this.scrimColor;
    }

    public void setScrimColor(int i_renamed) {
        this.scrimColor = i_renamed;
    }

    public int getTransitionDirection() {
        return this.transitionDirection;
    }

    public void setTransitionDirection(int i_renamed) {
        this.transitionDirection = i_renamed;
    }

    public int getFadeMode() {
        return this.fadeMode;
    }

    public void setFadeMode(int i_renamed) {
        this.fadeMode = i_renamed;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    public void setFitMode(int i_renamed) {
        this.fitMode = i_renamed;
    }

    public com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public void setFadeProgressThresholds(com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds) {
        this.fadeProgressThresholds = progressThresholds;
    }

    public com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    public void setScaleProgressThresholds(com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds) {
        this.scaleProgressThresholds = progressThresholds;
    }

    public com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    public void setScaleMaskProgressThresholds(com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds) {
        this.scaleMaskProgressThresholds = progressThresholds;
    }

    public com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    public void setShapeMaskProgressThresholds(com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds) {
        this.shapeMaskProgressThresholds = progressThresholds;
    }

    public boolean isHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    public void setHoldAtEndEnabled(boolean z_renamed) {
        this.holdAtEndEnabled = z_renamed;
    }

    public boolean isDrawDebugEnabled() {
        return this.drawDebugEnabled;
    }

    public void setDrawDebugEnabled(boolean z_renamed) {
        this.drawDebugEnabled = z_renamed;
    }

    @Override // android.transition.Transition
    public java.lang.String[] getTransitionProperties() {
        return TRANSITION_PROPS;
    }

    @Override // android.transition.Transition
    public void captureStartValues(android.transition.TransitionValues transitionValues) {
        captureValues(transitionValues, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    @Override // android.transition.Transition
    public void captureEndValues(android.transition.TransitionValues transitionValues) {
        captureValues(transitionValues, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    private static void captureValues(android.transition.TransitionValues transitionValues, android.view.View view, int i_renamed, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        if (i_renamed != -1) {
            transitionValues.view = com.google.android.material.transition.TransitionUtils.findDescendantOrAncestorById(transitionValues.view, i_renamed);
        } else if (view != null) {
            transitionValues.view = view;
        } else if (transitionValues.view.getTag() instanceof android.view.View) {
            android.view.View view2 = (android.view.View) transitionValues.view.getTag();
            transitionValues.view.setTag(null);
            transitionValues.view = view2;
        }
        android.view.View view3 = transitionValues.view;
        if (!androidx.core.h_renamed.v_renamed.A_renamed(view3) && view3.getWidth() == 0 && view3.getHeight() == 0) {
            return;
        }
        android.graphics.RectF relativeBounds = view3.getParent() == null ? com.google.android.material.transition.TransitionUtils.getRelativeBounds(view3) : com.google.android.material.transition.TransitionUtils.getLocationOnScreen(view3);
        transitionValues.values.put(PROP_BOUNDS, relativeBounds);
        transitionValues.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(view3, relativeBounds, shapeAppearanceModel));
    }

    private static com.google.android.material.shape.ShapeAppearanceModel captureShapeAppearance(android.view.View view, android.graphics.RectF rectF, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        return com.google.android.material.transition.TransitionUtils.convertToRelativeCornerSizes(getShapeAppearance(view, shapeAppearanceModel), rectF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.google.android.material.shape.ShapeAppearanceModel getShapeAppearance(android.view.View view, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel != null) {
            return shapeAppearanceModel;
        }
        if (view.getTag() instanceof com.google.android.material.shape.ShapeAppearanceModel) {
            return (com.google.android.material.shape.ShapeAppearanceModel) view.getTag();
        }
        android.content.Context context = view.getContext();
        int transitionShapeAppearanceResId = getTransitionShapeAppearanceResId(context);
        if (transitionShapeAppearanceResId != -1) {
            return com.google.android.material.shape.ShapeAppearanceModel.builder(context, transitionShapeAppearanceResId, 0).build();
        }
        if (view instanceof com.google.android.material.shape.Shapeable) {
            return ((com.google.android.material.shape.Shapeable) view).getShapeAppearanceModel();
        }
        return com.google.android.material.shape.ShapeAppearanceModel.builder().build();
    }

    private static int getTransitionShapeAppearanceResId(android.content.Context context) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.R_renamed.attr.transitionShapeAppearance});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    @Override // android.transition.Transition
    public android.animation.Animator createAnimator(android.view.ViewGroup viewGroup, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) throws android.content.res.Resources.NotFoundException {
        android.view.View view;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        final android.view.View view2 = transitionValues.view;
        final android.view.View view3 = transitionValues2.view;
        android.view.View view4 = view3.getParent() != null ? view3 : view2;
        if (this.drawingViewId == view4.getId()) {
            view = (android.view.View) view4.getParent();
        } else {
            android.view.View viewFindAncestorById = com.google.android.material.transition.TransitionUtils.findAncestorById(view4, this.drawingViewId);
            view4 = null;
            view = viewFindAncestorById;
        }
        android.graphics.RectF rectF = (android.graphics.RectF) androidx.core.g_renamed.f_renamed.a_renamed(transitionValues.values.get(PROP_BOUNDS));
        android.graphics.RectF rectF2 = (android.graphics.RectF) androidx.core.g_renamed.f_renamed.a_renamed(transitionValues2.values.get(PROP_BOUNDS));
        com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel = (com.google.android.material.shape.ShapeAppearanceModel) transitionValues.values.get(PROP_SHAPE_APPEARANCE);
        com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel2 = (com.google.android.material.shape.ShapeAppearanceModel) transitionValues2.values.get(PROP_SHAPE_APPEARANCE);
        android.graphics.RectF locationOnScreen = com.google.android.material.transition.TransitionUtils.getLocationOnScreen(view);
        float f_renamed = -locationOnScreen.left;
        float f2 = -locationOnScreen.top;
        android.graphics.RectF rectFCalculateDrawableBounds = calculateDrawableBounds(view, view4, f_renamed, f2);
        rectF.offset(f_renamed, f2);
        rectF2.offset(f_renamed, f2);
        boolean zIsEntering = isEntering(rectF, rectF2);
        final android.view.View view5 = view;
        final com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable transitionDrawable = new com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable(getPathMotion(), view2, rectF, shapeAppearanceModel, view3, rectF2, shapeAppearanceModel2, this.containerColor, getScrimColorOrDefault(view2.getContext()), zIsEntering, com.google.android.material.transition.FadeModeEvaluators.get(this.fadeMode, zIsEntering), com.google.android.material.transition.FitModeEvaluators.get(this.fitMode, zIsEntering, rectF, rectF2), buildThresholdsGroup(zIsEntering), this.drawDebugEnabled);
        transitionDrawable.setBounds(java.lang.Math.round(rectFCalculateDrawableBounds.left), java.lang.Math.round(rectFCalculateDrawableBounds.top), java.lang.Math.round(rectFCalculateDrawableBounds.right), java.lang.Math.round(rectFCalculateDrawableBounds.bottom));
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transition.MaterialContainerTransform.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                transitionDrawable.setProgress(valueAnimator.getAnimatedFraction());
            }
        });
        valueAnimatorOfFloat.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.transition.MaterialContainerTransform.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                view5.getOverlay().add(transitionDrawable);
                view2.setAlpha(0.0f);
                view3.setAlpha(0.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (com.google.android.material.transition.MaterialContainerTransform.this.holdAtEndEnabled) {
                    return;
                }
                view2.setAlpha(1.0f);
                view3.setAlpha(1.0f);
                view5.getOverlay().remove(transitionDrawable);
            }
        });
        return valueAnimatorOfFloat;
    }

    private int getScrimColorOrDefault(android.content.Context context) {
        int i_renamed = this.scrimColor;
        return i_renamed == -1 ? com.google.android.material.color.MaterialColors.getColor(context, com.google.android.material.R_renamed.attr.scrimBackground, androidx.core.a_renamed.a_renamed.c_renamed(context, com.google.android.material.R_renamed.color.mtrl_scrim_color)) : i_renamed;
    }

    private static android.graphics.RectF calculateDrawableBounds(android.view.View view, android.view.View view2, float f_renamed, float f2) {
        if (view2 != null) {
            android.graphics.RectF locationOnScreen = com.google.android.material.transition.TransitionUtils.getLocationOnScreen(view2);
            locationOnScreen.offset(f_renamed, f2);
            return locationOnScreen;
        }
        return new android.graphics.RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
    }

    private boolean isEntering(android.graphics.RectF rectF, android.graphics.RectF rectF2) {
        int i_renamed = this.transitionDirection;
        if (i_renamed == 0) {
            return com.google.android.material.transition.TransitionUtils.calculateArea(rectF2) > com.google.android.material.transition.TransitionUtils.calculateArea(rectF);
        }
        if (i_renamed == 1) {
            return true;
        }
        if (i_renamed == 2) {
            return false;
        }
        throw new java.lang.IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
    }

    private com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup buildThresholdsGroup(boolean z_renamed) {
        android.transition.PathMotion pathMotion = getPathMotion();
        if ((pathMotion instanceof android.transition.ArcMotion) || (pathMotion instanceof com.google.android.material.transition.MaterialArcMotion)) {
            return getThresholdsOrDefault(z_renamed, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC);
        }
        return getThresholdsOrDefault(z_renamed, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    }

    private com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup getThresholdsOrDefault(boolean z_renamed, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup progressThresholdsGroup, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup progressThresholdsGroup2) {
        if (!z_renamed) {
            progressThresholdsGroup = progressThresholdsGroup2;
        }
        return new com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup((com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds) com.google.android.material.transition.TransitionUtils.defaultIfNull(this.fadeProgressThresholds, progressThresholdsGroup.fade), (com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds) com.google.android.material.transition.TransitionUtils.defaultIfNull(this.scaleProgressThresholds, progressThresholdsGroup.scale), (com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds) com.google.android.material.transition.TransitionUtils.defaultIfNull(this.scaleMaskProgressThresholds, progressThresholdsGroup.scaleMask), (com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds) com.google.android.material.transition.TransitionUtils.defaultIfNull(this.shapeMaskProgressThresholds, progressThresholdsGroup.shapeMask));
    }

    private static final class TransitionDrawable extends android.graphics.drawable.Drawable {
        private final android.graphics.Paint containerPaint;
        private final android.graphics.RectF currentEndBounds;
        private final android.graphics.RectF currentEndBoundsMasked;
        private final android.graphics.RectF currentStartBounds;
        private final android.graphics.RectF currentStartBoundsMasked;
        private final android.graphics.Paint debugPaint;
        private final android.graphics.Path debugPath;
        private final boolean drawDebugEnabled;
        private final android.graphics.RectF endBounds;
        private final com.google.android.material.shape.ShapeAppearanceModel endShapeAppearanceModel;
        private final android.view.View endView;
        private final boolean entering;
        private final com.google.android.material.transition.FadeModeEvaluator fadeModeEvaluator;
        private com.google.android.material.transition.FadeModeResult fadeModeResult;
        private final com.google.android.material.transition.FitModeEvaluator fitModeEvaluator;
        private com.google.android.material.transition.FitModeResult fitModeResult;
        private final com.google.android.material.transition.MaskEvaluator maskEvaluator;
        private final float motionPathLength;
        private final android.graphics.PathMeasure motionPathMeasure;
        private final float[] motionPathPosition;
        private float progress;
        private final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup progressThresholds;
        private final android.graphics.Paint scrimPaint;
        private final android.graphics.RectF startBounds;
        private final com.google.android.material.shape.ShapeAppearanceModel startShapeAppearanceModel;
        private final android.view.View startView;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        private TransitionDrawable(android.transition.PathMotion pathMotion, android.view.View view, android.graphics.RectF rectF, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, android.view.View view2, android.graphics.RectF rectF2, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel2, int i_renamed, int i2, boolean z_renamed, com.google.android.material.transition.FadeModeEvaluator fadeModeEvaluator, com.google.android.material.transition.FitModeEvaluator fitModeEvaluator, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholdsGroup progressThresholdsGroup, boolean z2) {
            this.maskEvaluator = new com.google.android.material.transition.MaskEvaluator();
            this.motionPathPosition = new float[2];
            this.containerPaint = new android.graphics.Paint();
            this.scrimPaint = new android.graphics.Paint();
            this.debugPaint = new android.graphics.Paint();
            this.debugPath = new android.graphics.Path();
            this.progress = 0.0f;
            this.startView = view;
            this.startBounds = rectF;
            this.startShapeAppearanceModel = shapeAppearanceModel;
            this.endView = view2;
            this.endBounds = rectF2;
            this.endShapeAppearanceModel = shapeAppearanceModel2;
            this.entering = z_renamed;
            this.fadeModeEvaluator = fadeModeEvaluator;
            this.fitModeEvaluator = fitModeEvaluator;
            this.progressThresholds = progressThresholdsGroup;
            this.drawDebugEnabled = z2;
            this.containerPaint.setColor(i_renamed);
            this.currentStartBounds = new android.graphics.RectF(rectF);
            this.currentStartBoundsMasked = new android.graphics.RectF(this.currentStartBounds);
            this.currentEndBounds = new android.graphics.RectF(this.currentStartBounds);
            this.currentEndBoundsMasked = new android.graphics.RectF(this.currentEndBounds);
            android.graphics.PointF motionPathPoint = getMotionPathPoint(rectF);
            android.graphics.PointF motionPathPoint2 = getMotionPathPoint(rectF2);
            this.motionPathMeasure = new android.graphics.PathMeasure(pathMotion.getPath(motionPathPoint.x_renamed, motionPathPoint.y_renamed, motionPathPoint2.x_renamed, motionPathPoint2.y_renamed), false);
            this.motionPathLength = this.motionPathMeasure.getLength();
            this.scrimPaint.setStyle(android.graphics.Paint.Style.FILL);
            this.scrimPaint.setShader(com.google.android.material.transition.TransitionUtils.createColorShader(i2));
            this.debugPaint.setStyle(android.graphics.Paint.Style.STROKE);
            this.debugPaint.setStrokeWidth(10.0f);
            updateProgress(0.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            if (this.scrimPaint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.scrimPaint);
            }
            int iSave = this.drawDebugEnabled ? canvas.save() : -1;
            this.maskEvaluator.clip(canvas);
            if (this.containerPaint.getColor() != 0) {
                canvas.drawRect(getBounds(), this.containerPaint);
            }
            if (this.fadeModeResult.endOnTop) {
                drawStartView(canvas);
                drawEndView(canvas);
            } else {
                drawEndView(canvas);
                drawStartView(canvas);
            }
            if (this.drawDebugEnabled) {
                canvas.restoreToCount(iSave);
                drawDebugCumulativePath(canvas, this.currentStartBounds, this.debugPath, -65281);
                drawDebugRect(canvas, this.currentStartBoundsMasked, -256);
                drawDebugRect(canvas, this.currentStartBounds, -16711936);
                drawDebugRect(canvas, this.currentEndBoundsMasked, -16711681);
                drawDebugRect(canvas, this.currentEndBounds, -16776961);
            }
        }

        private void drawStartView(android.graphics.Canvas canvas) {
            com.google.android.material.transition.TransitionUtils.transform(canvas, getBounds(), this.currentStartBounds.left, this.currentStartBounds.top, this.fitModeResult.startScale, this.fadeModeResult.startAlpha, new com.google.android.material.transition.TransitionUtils.CanvasOperation() { // from class: com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.1
                @Override // com.google.android.material.transition.TransitionUtils.CanvasOperation
                public void run(android.graphics.Canvas canvas2) {
                    com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.this.startView.draw(canvas2);
                }
            });
        }

        private void drawEndView(android.graphics.Canvas canvas) {
            com.google.android.material.transition.TransitionUtils.transform(canvas, getBounds(), this.currentEndBounds.left, this.currentEndBounds.top, this.fitModeResult.endScale, this.fadeModeResult.endAlpha, new com.google.android.material.transition.TransitionUtils.CanvasOperation() { // from class: com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.2
                @Override // com.google.android.material.transition.TransitionUtils.CanvasOperation
                public void run(android.graphics.Canvas canvas2) {
                    com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.this.endView.draw(canvas2);
                }
            });
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i_renamed) {
            throw new java.lang.UnsupportedOperationException("Setting alpha on_renamed is_renamed not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
            throw new java.lang.UnsupportedOperationException("Setting a_renamed color filter is_renamed not supported");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProgress(float f_renamed) {
            if (this.progress != f_renamed) {
                updateProgress(f_renamed);
            }
        }

        private void updateProgress(float f_renamed) {
            this.progress = f_renamed;
            this.scrimPaint.setAlpha((int) (this.entering ? com.google.android.material.transition.TransitionUtils.lerp(0.0f, 255.0f, f_renamed) : com.google.android.material.transition.TransitionUtils.lerp(255.0f, 0.0f, f_renamed)));
            this.motionPathMeasure.getPosTan(this.motionPathLength * f_renamed, this.motionPathPosition, null);
            float[] fArr = this.motionPathPosition;
            float f2 = fArr[0];
            float f3 = fArr[1];
            this.fitModeResult = this.fitModeEvaluator.evaluate(f_renamed, ((java.lang.Float) androidx.core.g_renamed.f_renamed.a_renamed(java.lang.Float.valueOf(this.progressThresholds.scale.start))).floatValue(), ((java.lang.Float) androidx.core.g_renamed.f_renamed.a_renamed(java.lang.Float.valueOf(this.progressThresholds.scale.end))).floatValue(), this.startBounds.width(), this.startBounds.height(), this.endBounds.width(), this.endBounds.height());
            this.currentStartBounds.set(f2 - (this.fitModeResult.currentStartWidth / 2.0f), f3, (this.fitModeResult.currentStartWidth / 2.0f) + f2, this.fitModeResult.currentStartHeight + f3);
            this.currentEndBounds.set(f2 - (this.fitModeResult.currentEndWidth / 2.0f), f3, f2 + (this.fitModeResult.currentEndWidth / 2.0f), this.fitModeResult.currentEndHeight + f3);
            this.currentStartBoundsMasked.set(this.currentStartBounds);
            this.currentEndBoundsMasked.set(this.currentEndBounds);
            float fFloatValue = ((java.lang.Float) androidx.core.g_renamed.f_renamed.a_renamed(java.lang.Float.valueOf(this.progressThresholds.scaleMask.start))).floatValue();
            float fFloatValue2 = ((java.lang.Float) androidx.core.g_renamed.f_renamed.a_renamed(java.lang.Float.valueOf(this.progressThresholds.scaleMask.end))).floatValue();
            boolean zShouldMaskStartBounds = this.fitModeEvaluator.shouldMaskStartBounds(this.fitModeResult);
            android.graphics.RectF rectF = zShouldMaskStartBounds ? this.currentStartBoundsMasked : this.currentEndBoundsMasked;
            float fLerp = com.google.android.material.transition.TransitionUtils.lerp(0.0f, 1.0f, fFloatValue, fFloatValue2, f_renamed);
            if (!zShouldMaskStartBounds) {
                fLerp = 1.0f - fLerp;
            }
            this.fitModeEvaluator.applyMask(rectF, fLerp, this.fitModeResult);
            this.maskEvaluator.evaluate(f_renamed, this.startShapeAppearanceModel, this.endShapeAppearanceModel, this.currentStartBounds, this.currentStartBoundsMasked, this.currentEndBoundsMasked, this.progressThresholds.shapeMask);
            this.fadeModeResult = this.fadeModeEvaluator.evaluate(f_renamed, ((java.lang.Float) androidx.core.g_renamed.f_renamed.a_renamed(java.lang.Float.valueOf(this.progressThresholds.fade.start))).floatValue(), ((java.lang.Float) androidx.core.g_renamed.f_renamed.a_renamed(java.lang.Float.valueOf(this.progressThresholds.fade.end))).floatValue());
            invalidateSelf();
        }

        private static android.graphics.PointF getMotionPathPoint(android.graphics.RectF rectF) {
            return new android.graphics.PointF(rectF.centerX(), rectF.top);
        }

        private void drawDebugCumulativePath(android.graphics.Canvas canvas, android.graphics.RectF rectF, android.graphics.Path path, int i_renamed) {
            android.graphics.PointF motionPathPoint = getMotionPathPoint(rectF);
            if (this.progress == 0.0f) {
                path.reset();
                path.moveTo(motionPathPoint.x_renamed, motionPathPoint.y_renamed);
            } else {
                path.lineTo(motionPathPoint.x_renamed, motionPathPoint.y_renamed);
                this.debugPaint.setColor(i_renamed);
                canvas.drawPath(path, this.debugPaint);
            }
        }

        private void drawDebugRect(android.graphics.Canvas canvas, android.graphics.RectF rectF, int i_renamed) {
            this.debugPaint.setColor(i_renamed);
            canvas.drawRect(rectF, this.debugPaint);
        }
    }

    public static class ProgressThresholds {
        final float end;
        final float start;

        public ProgressThresholds(float f_renamed, float f2) {
            this.start = f_renamed;
            this.end = f2;
        }
    }

    private static class ProgressThresholdsGroup {
        private final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds fade;
        private final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds scale;
        private final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds scaleMask;
        private final com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds shapeMask;

        private ProgressThresholdsGroup(com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds2, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds3, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds4) {
            this.fade = progressThresholds;
            this.scale = progressThresholds2;
            this.scaleMask = progressThresholds3;
            this.shapeMask = progressThresholds4;
        }
    }
}
