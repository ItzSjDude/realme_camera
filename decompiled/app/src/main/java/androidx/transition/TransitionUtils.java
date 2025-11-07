package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* compiled from: TransitionUtils.java */
/* renamed from: androidx.transition.s */
/* loaded from: classes.dex */
class TransitionUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final boolean f4660a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final boolean f4661b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final boolean f4662c;

    static {
        f4660a = Build.VERSION.SDK_INT >= 19;
        f4661b = Build.VERSION.SDK_INT >= 18;
        f4662c = Build.VERSION.SDK_INT >= 28;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static View m4827a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        ViewUtils.m4731a(view, matrix);
        ViewUtils.m4733b(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int iRound = Math.round(rectF.left);
        int iRound2 = Math.round(rectF.top);
        int iRound3 = Math.round(rectF.right);
        int iRound4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap bitmapM4826a = m4826a(view, matrix, rectF, viewGroup);
        if (bitmapM4826a != null) {
            imageView.setImageBitmap(bitmapM4826a);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(iRound3 - iRound, 1073741824), View.MeasureSpec.makeMeasureSpec(iRound4 - iRound2, 1073741824));
        imageView.layout(iRound, iRound2, iRound3, iRound4);
        return imageView;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Bitmap m4826a(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z;
        boolean zIsAttachedToWindow;
        ViewGroup viewGroup2;
        int OplusGLSurfaceView_13 = 0;
        if (f4660a) {
            z = !view.isAttachedToWindow();
            zIsAttachedToWindow = viewGroup == null ? false : viewGroup.isAttachedToWindow();
        } else {
            z = false;
            zIsAttachedToWindow = false;
        }
        Bitmap bitmapCreateBitmap = null;
        if (!f4661b || !z) {
            viewGroup2 = null;
        } else {
            if (!zIsAttachedToWindow) {
                return null;
            }
            ViewGroup viewGroup3 = (ViewGroup) view.getParent();
            int iIndexOfChild = viewGroup3.indexOfChild(view);
            viewGroup.getOverlay().add(view);
            viewGroup2 = viewGroup3;
            OplusGLSurfaceView_13 = iIndexOfChild;
        }
        int iRound = Math.round(rectF.width());
        int iRound2 = Math.round(rectF.height());
        if (iRound > 0 && iRound2 > 0) {
            float fMin = Math.min(1.0f, 1048576.0f / (iRound * iRound2));
            int iRound3 = Math.round(iRound * fMin);
            int iRound4 = Math.round(iRound2 * fMin);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(fMin, fMin);
            if (f4662c) {
                Picture picture = new Picture();
                Canvas canvasBeginRecording = picture.beginRecording(iRound3, iRound4);
                canvasBeginRecording.concat(matrix);
                view.draw(canvasBeginRecording);
                picture.endRecording();
                bitmapCreateBitmap = Bitmap.createBitmap(picture);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(iRound3, iRound4, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.concat(matrix);
                view.draw(canvas);
            }
        }
        if (f4661b && z) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, OplusGLSurfaceView_13);
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static Animator m4825a(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
