package androidx.transition;

/* compiled from: TransitionUtils.java */
/* loaded from: classes.dex */
class s_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final boolean f1751a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final boolean f1752b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final boolean f1753c;

    static {
        f1751a = android.os.Build.VERSION.SDK_INT >= 19;
        f1752b = android.os.Build.VERSION.SDK_INT >= 18;
        f1753c = android.os.Build.VERSION.SDK_INT >= 28;
    }

    static android.view.View a_renamed(android.view.ViewGroup viewGroup, android.view.View view, android.view.View view2) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        androidx.transition.ad_renamed.a_renamed(view, matrix);
        androidx.transition.ad_renamed.b_renamed(viewGroup, matrix);
        android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int iRound = java.lang.Math.round(rectF.left);
        int iRound2 = java.lang.Math.round(rectF.top);
        int iRound3 = java.lang.Math.round(rectF.right);
        int iRound4 = java.lang.Math.round(rectF.bottom);
        android.widget.ImageView imageView = new android.widget.ImageView(view.getContext());
        imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        android.graphics.Bitmap bitmapA = a_renamed(view, matrix, rectF, viewGroup);
        if (bitmapA != null) {
            imageView.setImageBitmap(bitmapA);
        }
        imageView.measure(android.view.View.MeasureSpec.makeMeasureSpec(iRound3 - iRound, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(iRound4 - iRound2, 1073741824));
        imageView.layout(iRound, iRound2, iRound3, iRound4);
        return imageView;
    }

    private static android.graphics.Bitmap a_renamed(android.view.View view, android.graphics.Matrix matrix, android.graphics.RectF rectF, android.view.ViewGroup viewGroup) {
        boolean z_renamed;
        boolean zIsAttachedToWindow;
        android.view.ViewGroup viewGroup2;
        int i_renamed = 0;
        if (f1751a) {
            z_renamed = !view.isAttachedToWindow();
            zIsAttachedToWindow = viewGroup == null ? false : viewGroup.isAttachedToWindow();
        } else {
            z_renamed = false;
            zIsAttachedToWindow = false;
        }
        android.graphics.Bitmap bitmapCreateBitmap = null;
        if (!f1752b || !z_renamed) {
            viewGroup2 = null;
        } else {
            if (!zIsAttachedToWindow) {
                return null;
            }
            android.view.ViewGroup viewGroup3 = (android.view.ViewGroup) view.getParent();
            int iIndexOfChild = viewGroup3.indexOfChild(view);
            viewGroup.getOverlay().add(view);
            viewGroup2 = viewGroup3;
            i_renamed = iIndexOfChild;
        }
        int iRound = java.lang.Math.round(rectF.width());
        int iRound2 = java.lang.Math.round(rectF.height());
        if (iRound > 0 && iRound2 > 0) {
            float fMin = java.lang.Math.min(1.0f, 1048576.0f / (iRound * iRound2));
            int iRound3 = java.lang.Math.round(iRound * fMin);
            int iRound4 = java.lang.Math.round(iRound2 * fMin);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(fMin, fMin);
            if (f1753c) {
                android.graphics.Picture picture = new android.graphics.Picture();
                android.graphics.Canvas canvasBeginRecording = picture.beginRecording(iRound3, iRound4);
                canvasBeginRecording.concat(matrix);
                view.draw(canvasBeginRecording);
                picture.endRecording();
                bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(picture);
            } else {
                bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(iRound3, iRound4, android.graphics.Bitmap.Config.ARGB_8888);
                android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
                canvas.concat(matrix);
                view.draw(canvas);
            }
        }
        if (f1752b && z_renamed) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, i_renamed);
        }
        return bitmapCreateBitmap;
    }

    static android.animation.Animator a_renamed(android.animation.Animator animator, android.animation.Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
