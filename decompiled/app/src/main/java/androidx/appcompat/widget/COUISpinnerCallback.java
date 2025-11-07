package androidx.appcompat.widget;

/* compiled from: AppCompatProgressBarHelper.java */
/* loaded from: classes.dex */
class p_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int[] f631a = {android.R_renamed.attr.indeterminateDrawable, android.R_renamed.attr.progressDrawable};

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.widget.ProgressBar f632b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Bitmap f633c;

    p_renamed(android.widget.ProgressBar progressBar) {
        this.f632b = progressBar;
    }

    void a_renamed(android.util.AttributeSet attributeSet, int i_renamed) {
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(this.f632b.getContext(), attributeSet, f631a, i_renamed, 0);
        android.graphics.drawable.Drawable drawableB = arVarA.b_renamed(0);
        if (drawableB != null) {
            this.f632b.setIndeterminateDrawable(a_renamed(drawableB));
        }
        android.graphics.drawable.Drawable drawableB2 = arVarA.b_renamed(1);
        if (drawableB2 != null) {
            this.f632b.setProgressDrawable(a_renamed(drawableB2, false));
        }
        arVarA.b_renamed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private android.graphics.drawable.Drawable a_renamed(android.graphics.drawable.Drawable drawable, boolean z_renamed) {
        if (drawable instanceof androidx.core.graphics.drawable.c_renamed) {
            androidx.core.graphics.drawable.c_renamed cVar = (androidx.core.graphics.drawable.c_renamed) drawable;
            android.graphics.drawable.Drawable drawableA = cVar.a_renamed();
            if (drawableA != null) {
                cVar.a_renamed(a_renamed(drawableA, z_renamed));
            }
        } else {
            if (drawable instanceof android.graphics.drawable.LayerDrawable) {
                android.graphics.drawable.LayerDrawable layerDrawable = (android.graphics.drawable.LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                android.graphics.drawable.Drawable[] drawableArr = new android.graphics.drawable.Drawable[numberOfLayers];
                for (int i_renamed = 0; i_renamed < numberOfLayers; i_renamed++) {
                    int id_renamed = layerDrawable.getId(i_renamed);
                    drawableArr[i_renamed] = a_renamed(layerDrawable.getDrawable(i_renamed), id_renamed == 16908301 || id_renamed == 16908303);
                }
                android.graphics.drawable.LayerDrawable layerDrawable2 = new android.graphics.drawable.LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                }
                return layerDrawable2;
            }
            if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
                android.graphics.drawable.BitmapDrawable bitmapDrawable = (android.graphics.drawable.BitmapDrawable) drawable;
                android.graphics.Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f633c == null) {
                    this.f633c = bitmap;
                }
                android.graphics.drawable.ShapeDrawable shapeDrawable = new android.graphics.drawable.ShapeDrawable(b_renamed());
                shapeDrawable.getPaint().setShader(new android.graphics.BitmapShader(bitmap, android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z_renamed ? new android.graphics.drawable.ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    private android.graphics.drawable.Drawable a_renamed(android.graphics.drawable.Drawable drawable) {
        if (!(drawable instanceof android.graphics.drawable.AnimationDrawable)) {
            return drawable;
        }
        android.graphics.drawable.AnimationDrawable animationDrawable = (android.graphics.drawable.AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        android.graphics.drawable.AnimationDrawable animationDrawable2 = new android.graphics.drawable.AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i_renamed = 0; i_renamed < numberOfFrames; i_renamed++) {
            android.graphics.drawable.Drawable drawableA = a_renamed(animationDrawable.getFrame(i_renamed), true);
            drawableA.setLevel(10000);
            animationDrawable2.addFrame(drawableA, animationDrawable.getDuration(i_renamed));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    private android.graphics.drawable.shapes.Shape b_renamed() {
        return new android.graphics.drawable.shapes.RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    android.graphics.Bitmap a_renamed() {
        return this.f633c;
    }
}
