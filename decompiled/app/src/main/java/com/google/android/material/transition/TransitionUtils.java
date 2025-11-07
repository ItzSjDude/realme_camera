package com.google.android.material.transition;

/* loaded from: classes.dex */
class TransitionUtils {
    private static final android.graphics.RectF transformAlphaRectF = new android.graphics.RectF();

    interface CanvasOperation {
        void run(android.graphics.Canvas canvas);
    }

    interface CornerSizeBinaryOperator {
        com.google.android.material.shape.CornerSize apply(com.google.android.material.shape.CornerSize cornerSize, com.google.android.material.shape.CornerSize cornerSize2);
    }

    static <T_renamed> T_renamed defaultIfNull(T_renamed t_renamed, T_renamed t2) {
        return t_renamed != null ? t_renamed : t2;
    }

    static float lerp(float f_renamed, float f2, float f3) {
        return f_renamed + (f3 * (f2 - f_renamed));
    }

    private TransitionUtils() {
    }

    static com.google.android.material.shape.ShapeAppearanceModel convertToRelativeCornerSizes(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, final android.graphics.RectF rectF) {
        return shapeAppearanceModel.withTransformedCornerSizes(new com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.transition.TransitionUtils.1
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            public com.google.android.material.shape.CornerSize apply(com.google.android.material.shape.CornerSize cornerSize) {
                return cornerSize instanceof com.google.android.material.shape.RelativeCornerSize ? cornerSize : new com.google.android.material.shape.RelativeCornerSize(cornerSize.getCornerSize(rectF) / rectF.height());
            }
        });
    }

    static com.google.android.material.shape.ShapeAppearanceModel transformCornerSizes(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel2, android.graphics.RectF rectF, com.google.android.material.transition.TransitionUtils.CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        return (isShapeAppearanceSignificant(shapeAppearanceModel, rectF) ? shapeAppearanceModel : shapeAppearanceModel2).toBuilder().setTopLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
    }

    private static boolean isShapeAppearanceSignificant(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, android.graphics.RectF rectF) {
        return (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) ? false : true;
    }

    static float lerp(float f_renamed, float f2, float f3, float f4, float f5) {
        return f5 < f3 ? f_renamed : f5 > f4 ? f2 : lerp(f_renamed, f2, (f5 - f3) / (f4 - f3));
    }

    static int lerp(int i_renamed, int i2, float f_renamed, float f2, float f3) {
        return f3 < f_renamed ? i_renamed : f3 > f2 ? i2 : (int) lerp(i_renamed, i2, (f3 - f_renamed) / (f2 - f_renamed));
    }

    static com.google.android.material.shape.ShapeAppearanceModel lerp(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel2, final android.graphics.RectF rectF, final android.graphics.RectF rectF2, final float f_renamed, final float f2, final float f3) {
        return f3 < f_renamed ? shapeAppearanceModel : f3 > f2 ? shapeAppearanceModel2 : transformCornerSizes(shapeAppearanceModel, shapeAppearanceModel2, rectF, new com.google.android.material.transition.TransitionUtils.CornerSizeBinaryOperator() { // from class: com.google.android.material.transition.TransitionUtils.2
            @Override // com.google.android.material.transition.TransitionUtils.CornerSizeBinaryOperator
            public com.google.android.material.shape.CornerSize apply(com.google.android.material.shape.CornerSize cornerSize, com.google.android.material.shape.CornerSize cornerSize2) {
                return new com.google.android.material.shape.AbsoluteCornerSize(com.google.android.material.transition.TransitionUtils.lerp(cornerSize.getCornerSize(rectF), cornerSize2.getCornerSize(rectF2), f_renamed, f2, f3));
            }
        });
    }

    static android.graphics.Shader createColorShader(int i_renamed) {
        return new android.graphics.LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i_renamed, i_renamed, android.graphics.Shader.TileMode.CLAMP);
    }

    static android.view.View findDescendantOrAncestorById(android.view.View view, int i_renamed) {
        android.view.View viewFindViewById = view.findViewById(i_renamed);
        return viewFindViewById != null ? viewFindViewById : findAncestorById(view, i_renamed);
    }

    static android.view.View findAncestorById(android.view.View view, int i_renamed) throws android.content.res.Resources.NotFoundException {
        java.lang.String resourceName = view.getResources().getResourceName(i_renamed);
        while (view != null) {
            if (view.getId() != i_renamed) {
                java.lang.Object parent = view.getParent();
                if (!(parent instanceof android.view.View)) {
                    break;
                }
                view = (android.view.View) parent;
            } else {
                return view;
            }
        }
        throw new java.lang.IllegalArgumentException(resourceName + " is_renamed not a_renamed valid ancestor");
    }

    static android.graphics.RectF getRelativeBounds(android.view.View view) {
        return new android.graphics.RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static android.graphics.Rect getRelativeBoundsRect(android.view.View view) {
        return new android.graphics.Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static android.graphics.RectF getLocationOnScreen(android.view.View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new android.graphics.RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    static float calculateArea(android.graphics.RectF rectF) {
        return rectF.width() * rectF.height();
    }

    private static int saveLayerAlphaCompat(android.graphics.Canvas canvas, android.graphics.Rect rect, int i_renamed) {
        transformAlphaRectF.set(rect);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return canvas.saveLayerAlpha(transformAlphaRectF, i_renamed);
        }
        return canvas.saveLayerAlpha(transformAlphaRectF.left, transformAlphaRectF.top, transformAlphaRectF.right, transformAlphaRectF.bottom, i_renamed, 31);
    }

    static void transform(android.graphics.Canvas canvas, android.graphics.Rect rect, float f_renamed, float f2, float f3, int i_renamed, com.google.android.material.transition.TransitionUtils.CanvasOperation canvasOperation) {
        if (i_renamed <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(f_renamed, f2);
        canvas.scale(f3, f3);
        if (i_renamed < 255) {
            saveLayerAlphaCompat(canvas, rect, i_renamed);
        }
        canvasOperation.run(canvas);
        canvas.restoreToCount(iSave);
    }

    static void maybeAddTransition(android.transition.TransitionSet transitionSet, android.transition.Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    static void maybeRemoveTransition(android.transition.TransitionSet transitionSet, android.transition.Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }
}
