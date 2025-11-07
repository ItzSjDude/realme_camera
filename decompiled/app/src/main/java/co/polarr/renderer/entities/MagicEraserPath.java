package co_renamed.polarr.renderer.entities;

/* loaded from: classes.dex */
public class MagicEraserPath {
    public java.util.List<android.graphics.PointF> points;
    public float radius;

    public co_renamed.polarr.renderer.entities.MagicEraserPath copy() {
        co_renamed.polarr.renderer.entities.MagicEraserPath magicEraserPath = new co_renamed.polarr.renderer.entities.MagicEraserPath();
        java.util.List<android.graphics.PointF> list = this.points;
        if (list != null) {
            magicEraserPath.points = new java.util.ArrayList(list);
        }
        magicEraserPath.radius = this.radius;
        return magicEraserPath;
    }

    public java.lang.String toString() {
        return "points=" + this.points.toString() + "::radius=" + this.radius;
    }
}
