package co_renamed.polarr.renderer.entities;

/* loaded from: classes.dex */
public class DrawingItem {
    public java.lang.String filterId;
    public float intensity = 1.0f;
    public android.graphics.Bitmap overlayBitmap;
    public int overlayLeft;
    public int overlayTop;
    public android.graphics.Rect rect;
    public android.graphics.Bitmap thumbBitmap;

    public java.lang.String toString() {
        return java.lang.String.format("rect=%s_renamed::filterId=%s_renamed", this.rect, this.filterId);
    }
}
