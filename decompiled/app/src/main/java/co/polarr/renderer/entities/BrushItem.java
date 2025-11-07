package co_renamed.polarr.renderer.entities;

/* loaded from: classes.dex */
public class BrushItem {
    public static final float MAX_MOSAIC_SIZE = 3.0f;
    public java.lang.String pointId;
    public float[] prevPoint;
    public java.util.List<java.lang.Float> points = new java.util.ArrayList();
    public java.util.List<android.graphics.PointF> touchPoints = new java.util.ArrayList();
    public float size = 0.5f;
    public float mosaicSize = 1.0f;
    public float spacing = 0.25f;
    public float randomize = 0.0f;
    public float flow = 0.5f;
    public double hardness = 0.0d;
    public float[] channel = {1.0f, 0.0f, 0.0f, 0.0f};
    public boolean erase = false;
    public boolean interpolate = true;
    public java.lang.String mode = "paint";
    public java.lang.String texture = "stroke_1";
    public boolean blend = false;

    public co_renamed.polarr.renderer.entities.BrushItem copy() {
        co_renamed.polarr.renderer.entities.BrushItem brushItem = new co_renamed.polarr.renderer.entities.BrushItem();
        brushItem.points.addAll(this.points);
        brushItem.touchPoints.addAll(this.touchPoints);
        float[] fArr = this.prevPoint;
        if (fArr != null) {
            brushItem.prevPoint = java.util.Arrays.copyOf(fArr, fArr.length);
        }
        float[] fArr2 = this.channel;
        brushItem.channel = java.util.Arrays.copyOf(fArr2, fArr2.length);
        brushItem.pointId = this.pointId;
        brushItem.size = this.size;
        brushItem.mosaicSize = this.mosaicSize;
        brushItem.spacing = this.spacing;
        brushItem.randomize = this.randomize;
        brushItem.flow = this.flow;
        brushItem.hardness = this.hardness;
        brushItem.erase = this.erase;
        brushItem.interpolate = this.interpolate;
        brushItem.mode = this.mode;
        brushItem.texture = this.texture;
        brushItem.blend = this.blend;
        return brushItem;
    }
}
