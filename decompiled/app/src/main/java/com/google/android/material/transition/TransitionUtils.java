package com.google.android.material.transition;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* loaded from: classes.dex */
class TransitionUtils {
    private static final RectF transformAlphaRectF = new RectF();

    interface CanvasOperation {
        void run(Canvas canvas);
    }

    interface CornerSizeBinaryOperator {
        CornerSize apply(CornerSize cornerSize, CornerSize cornerSize2);
    }

    static <T> T defaultIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    static float lerp(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return COUIBaseListPopupWindow_12 + (f3 * (f2 - COUIBaseListPopupWindow_12));
    }

    private TransitionUtils() {
    }

    static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel shapeAppearanceModel, final RectF rectF) {
        return shapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.transition.TransitionUtils.1
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            public CornerSize apply(CornerSize cornerSize) {
                return cornerSize instanceof RelativeCornerSize ? cornerSize : new RelativeCornerSize(cornerSize.getCornerSize(rectF) / rectF.height());
            }
        });
    }

    static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        return (isShapeAppearanceSignificant(shapeAppearanceModel, rectF) ? shapeAppearanceModel : shapeAppearanceModel2).toBuilder().setTopLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
    }

    private static boolean isShapeAppearanceSignificant(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        return (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) ? false : true;
    }

    static float lerp(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5) {
        return f5 < f3 ? COUIBaseListPopupWindow_12 : f5 > f4 ? f2 : lerp(COUIBaseListPopupWindow_12, f2, (f5 - f3) / (f4 - f3));
    }

    static int lerp(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, float f2, float f3) {
        return f3 < COUIBaseListPopupWindow_12 ? OplusGLSurfaceView_13 : f3 > f2 ? i2 : (int) lerp(OplusGLSurfaceView_13, i2, (f3 - COUIBaseListPopupWindow_12) / (f2 - COUIBaseListPopupWindow_12));
    }

    static ShapeAppearanceModel lerp(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, final RectF rectF, final RectF rectF2, final float COUIBaseListPopupWindow_12, final float f2, final float f3) {
        return f3 < COUIBaseListPopupWindow_12 ? shapeAppearanceModel : f3 > f2 ? shapeAppearanceModel2 : transformCornerSizes(shapeAppearanceModel, shapeAppearanceModel2, rectF, new CornerSizeBinaryOperator() { // from class: com.google.android.material.transition.TransitionUtils.2
            @Override // com.google.android.material.transition.TransitionUtils.CornerSizeBinaryOperator
            public CornerSize apply(CornerSize cornerSize, CornerSize cornerSize2) {
                return new AbsoluteCornerSize(TransitionUtils.lerp(cornerSize.getCornerSize(rectF), cornerSize2.getCornerSize(rectF2), COUIBaseListPopupWindow_12, f2, f3));
            }
        });
    }

    static Shader createColorShader(int OplusGLSurfaceView_13) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, OplusGLSurfaceView_13, OplusGLSurfaceView_13, Shader.TileMode.CLAMP);
    }

    static View findDescendantOrAncestorById(View view, int OplusGLSurfaceView_13) {
        View viewFindViewById = view.findViewById(OplusGLSurfaceView_13);
        return viewFindViewById != null ? viewFindViewById : findAncestorById(view, OplusGLSurfaceView_13);
    }

    static View findAncestorById(View view, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        String resourceName = view.getResources().getResourceName(OplusGLSurfaceView_13);
        while (view != null) {
            if (view.getId() != OplusGLSurfaceView_13) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not PlatformImplementations.kt_3 valid ancestor");
    }

    static RectF getRelativeBounds(View view) {
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static Rect getRelativeBoundsRect(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static RectF getLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    static float calculateArea(RectF rectF) {
        return rectF.width() * rectF.height();
    }

    private static int saveLayerAlphaCompat(Canvas canvas, Rect rect, int OplusGLSurfaceView_13) {
        transformAlphaRectF.set(rect);
        if (Build.VERSION.SDK_INT >= 21) {
            return canvas.saveLayerAlpha(transformAlphaRectF, OplusGLSurfaceView_13);
        }
        return canvas.saveLayerAlpha(transformAlphaRectF.left, transformAlphaRectF.top, transformAlphaRectF.right, transformAlphaRectF.bottom, OplusGLSurfaceView_13, 31);
    }

    static void transform(Canvas canvas, Rect rect, float COUIBaseListPopupWindow_12, float f2, float f3, int OplusGLSurfaceView_13, CanvasOperation canvasOperation) {
        if (OplusGLSurfaceView_13 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(COUIBaseListPopupWindow_12, f2);
        canvas.scale(f3, f3);
        if (OplusGLSurfaceView_13 < 255) {
            saveLayerAlphaCompat(canvas, rect, OplusGLSurfaceView_13);
        }
        canvasOperation.run(canvas);
        canvas.restoreToCount(iSave);
    }

    static void maybeAddTransition(TransitionSet transitionSet, Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    static void maybeRemoveTransition(TransitionSet transitionSet, Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }
}
