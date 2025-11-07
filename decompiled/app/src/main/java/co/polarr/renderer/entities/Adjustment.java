package co_renamed.polarr.renderer.entities;

/* loaded from: classes.dex */
public class Adjustment {
    public float angle;
    public float brush_hardness;
    public float brush_opacity;
    public float brush_radius;
    public float[] channel;
    public boolean disabled;
    public float[] endPoint;
    public float feather;
    public boolean invert;
    public float[] position;
    public float range;
    public boolean reflect;
    public float[] selectedColor;
    public boolean showOverlay;
    public float[] size;
    public float smoothness;
    public float[] startPoint;
    public float target;
    public float threshold;
    public java.lang.String type;
    public boolean useRadius;
    public co_renamed.polarr.renderer.entities.Context.LocalState adjustments = new co_renamed.polarr.renderer.entities.Context.LocalState();
    public java.util.List<co_renamed.polarr.renderer.entities.BrushItem> brush = new java.util.ArrayList();
    public java.lang.String brush_mode = "paint";
    public int paintTextureId = 0;

    public static co_renamed.polarr.renderer.entities.Adjustment fromDecodedHashMap(java.util.HashMap<java.lang.String, java.lang.Object> map) {
        return fromJSON(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(map));
    }

    public static co_renamed.polarr.renderer.entities.Adjustment fromJSON(java.lang.String str) {
        return (co_renamed.polarr.renderer.entities.Adjustment) a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(str, co_renamed.polarr.renderer.entities.Adjustment.class);
    }

    public static java.util.Map<java.lang.String, java.lang.Object> getAdjustmentHashMap(co_renamed.polarr.renderer.entities.Context.LocalState localState) {
        return (java.util.Map) a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(localState), java.util.Map.class);
    }

    public void updateStates(java.util.HashMap<java.lang.String, java.lang.Object> map) {
        if (map.containsKey("brush_radius")) {
            java.lang.Object obj = map.get("brush_radius");
            if (obj instanceof java.math.BigDecimal) {
                this.brush_radius = ((java.math.BigDecimal) obj).floatValue();
            }
        }
        if (map.containsKey("brush_opacity")) {
            java.lang.Object obj2 = map.get("brush_opacity");
            if (obj2 instanceof java.math.BigDecimal) {
                this.brush_opacity = ((java.math.BigDecimal) obj2).floatValue();
            }
        }
        if (map.containsKey("brush_hardness")) {
            java.lang.Object obj3 = map.get("brush_hardness");
            if (obj3 instanceof java.math.BigDecimal) {
                this.brush_hardness = ((java.math.BigDecimal) obj3).floatValue();
            }
        }
        if (map.containsKey("feather")) {
            java.lang.Object obj4 = map.get("feather");
            if (obj4 instanceof java.math.BigDecimal) {
                this.feather = ((java.math.BigDecimal) obj4).floatValue();
            }
        }
        if (map.containsKey("angle")) {
            java.lang.Object obj5 = map.get("angle");
            if (obj5 instanceof java.math.BigDecimal) {
                this.angle = ((java.math.BigDecimal) obj5).floatValue();
            }
        }
        if (map.containsKey("threshold")) {
            java.lang.Object obj6 = map.get("threshold");
            if (obj6 instanceof java.math.BigDecimal) {
                this.threshold = ((java.math.BigDecimal) obj6).floatValue();
            }
        }
        if (map.containsKey("selectedColor")) {
            java.lang.Object obj7 = map.get("selectedColor");
            if (obj7 instanceof java.util.ArrayList) {
                java.util.ArrayList arrayList = (java.util.ArrayList) obj7;
                if (arrayList.size() == 3 && (arrayList.get(0) instanceof java.math.BigDecimal)) {
                    this.selectedColor = new float[3];
                    this.selectedColor[0] = ((java.math.BigDecimal) arrayList.get(0)).floatValue();
                    this.selectedColor[1] = ((java.math.BigDecimal) arrayList.get(1)).floatValue();
                    this.selectedColor[2] = ((java.math.BigDecimal) arrayList.get(2)).floatValue();
                }
            }
        }
        if (map.containsKey("invert")) {
            this.invert = ((java.lang.Boolean) map.get("invert")).booleanValue();
        }
        if (map.containsKey("showOverlay")) {
            this.showOverlay = ((java.lang.Boolean) map.get("showOverlay")).booleanValue();
        }
        if (map.containsKey("disabled")) {
            this.disabled = ((java.lang.Boolean) map.get("disabled")).booleanValue();
        }
        if (map.containsKey("useRadius")) {
            this.useRadius = ((java.lang.Boolean) map.get("useRadius")).booleanValue();
        }
        if (map.containsKey("reflect")) {
            this.reflect = ((java.lang.Boolean) map.get("reflect")).booleanValue();
        }
    }
}
