package androidx.core.widget;

/* compiled from: ImageViewCompat.java */
/* loaded from: classes.dex */
public class e_renamed {
    /* JADX WARN: Multi-variable type inference failed */
    public static android.content.res.ColorStateList a_renamed(android.widget.ImageView imageView) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintList();
        }
        if (imageView instanceof androidx.core.widget.l_renamed) {
            return ((androidx.core.widget.l_renamed) imageView).getSupportImageTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a_renamed(android.widget.ImageView imageView, android.content.res.ColorStateList colorStateList) {
        android.graphics.drawable.Drawable drawable;
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintList(colorStateList);
            if (android.os.Build.VERSION.SDK_INT != 21 || (drawable = imageView.getDrawable()) == null || imageView.getImageTintList() == null) {
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
            return;
        }
        if (imageView instanceof androidx.core.widget.l_renamed) {
            ((androidx.core.widget.l_renamed) imageView).setSupportImageTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static android.graphics.PorterDuff.Mode b_renamed(android.widget.ImageView imageView) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintMode();
        }
        if (imageView instanceof androidx.core.widget.l_renamed) {
            return ((androidx.core.widget.l_renamed) imageView).getSupportImageTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a_renamed(android.widget.ImageView imageView, android.graphics.PorterDuff.Mode mode) {
        android.graphics.drawable.Drawable drawable;
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintMode(mode);
            if (android.os.Build.VERSION.SDK_INT != 21 || (drawable = imageView.getDrawable()) == null || imageView.getImageTintList() == null) {
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
            return;
        }
        if (imageView instanceof androidx.core.widget.l_renamed) {
            ((androidx.core.widget.l_renamed) imageView).setSupportImageTintMode(mode);
        }
    }
}
