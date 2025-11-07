package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.WrappedDrawable;

/* compiled from: AppCompatProgressBarHelper.java */
/* renamed from: androidx.appcompat.widget.p */
/* loaded from: classes.dex */
class AppCompatProgressBarHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int[] f1977a = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ProgressBar f1978b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Bitmap f1979c;

    AppCompatProgressBarHelper(ProgressBar progressBar) {
        this.f1978b = progressBar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo1696a(AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(this.f1978b.getContext(), attributeSet, f1977a, OplusGLSurfaceView_13, 0);
        Drawable drawableM1550b = c0322arM1541a.m1550b(0);
        if (drawableM1550b != null) {
            this.f1978b.setIndeterminateDrawable(m1692a(drawableM1550b));
        }
        Drawable drawableM1550b2 = c0322arM1541a.m1550b(1);
        if (drawableM1550b2 != null) {
            this.f1978b.setProgressDrawable(m1693a(drawableM1550b2, false));
        }
        c0322arM1541a.m1551b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    private Drawable m1693a(Drawable drawable, boolean z) {
        if (drawable instanceof WrappedDrawable) {
            WrappedDrawable interfaceC0466c = (WrappedDrawable) drawable;
            Drawable drawableMo2584a = interfaceC0466c.mo2584a();
            if (drawableMo2584a != null) {
                interfaceC0466c.mo2585a(m1693a(drawableMo2584a, z));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < numberOfLayers; OplusGLSurfaceView_13++) {
                    int id_renamed = layerDrawable.getId(OplusGLSurfaceView_13);
                    drawableArr[OplusGLSurfaceView_13] = m1693a(layerDrawable.getDrawable(OplusGLSurfaceView_13), id_renamed == 16908301 || id_renamed == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f1979c == null) {
                    this.f1979c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(m1694b());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Drawable m1692a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < numberOfFrames; OplusGLSurfaceView_13++) {
            Drawable drawableM1693a = m1693a(animationDrawable.getFrame(OplusGLSurfaceView_13), true);
            drawableM1693a.setLevel(10000);
            animationDrawable2.addFrame(drawableM1693a, animationDrawable.getDuration(OplusGLSurfaceView_13));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Shape m1694b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Bitmap m1695a() {
        return this.f1979c;
    }
}
