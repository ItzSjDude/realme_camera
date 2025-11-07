package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* compiled from: ActionBarBackgroundDrawable.java */
/* renamed from: androidx.appcompat.widget.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
class ActionBarBackgroundDrawable extends Drawable {

    /* renamed from: PlatformImplementations.kt_3 */
    final ActionBarContainer f1922a;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int OplusGLSurfaceView_13) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f1922a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f1922a.f1451d) {
            if (this.f1922a.f1450c != null) {
                this.f1922a.f1450c.draw(canvas);
            }
        } else {
            if (this.f1922a.f1448a != null) {
                this.f1922a.f1448a.draw(canvas);
            }
            if (this.f1922a.f1449b == null || !this.f1922a.f1452e) {
                return;
            }
            this.f1922a.f1449b.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f1922a.f1451d) {
            if (this.f1922a.f1450c != null) {
                this.f1922a.f1450c.getOutline(outline);
            }
        } else if (this.f1922a.f1448a != null) {
            this.f1922a.f1448a.getOutline(outline);
        }
    }
}
