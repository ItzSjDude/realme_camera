package co.polarr.renderer.entities;

import co.polarr.renderer.entities.Context;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.p001a.p003b.p010f.C0109b;

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
    public String type;
    public boolean useRadius;
    public Context.LocalState adjustments = new Context.LocalState();
    public List<BrushItem> brush = new ArrayList();
    public String brush_mode = "paint";
    public int paintTextureId = 0;

    public static Adjustment fromDecodedHashMap(HashMap<String, Object> map) {
        return fromJSON(C0109b.m466a(map));
    }

    public static Adjustment fromJSON(String str) {
        return (Adjustment) C0109b.m465a(str, Adjustment.class);
    }

    public static Map<String, Object> getAdjustmentHashMap(Context.LocalState localState) {
        return (Map) C0109b.m465a(C0109b.m466a(localState), Map.class);
    }

    public void updateStates(HashMap<String, Object> map) {
        if (map.containsKey("brush_radius")) {
            Object obj = map.get("brush_radius");
            if (obj instanceof BigDecimal) {
                this.brush_radius = ((BigDecimal) obj).floatValue();
            }
        }
        if (map.containsKey("brush_opacity")) {
            Object obj2 = map.get("brush_opacity");
            if (obj2 instanceof BigDecimal) {
                this.brush_opacity = ((BigDecimal) obj2).floatValue();
            }
        }
        if (map.containsKey("brush_hardness")) {
            Object obj3 = map.get("brush_hardness");
            if (obj3 instanceof BigDecimal) {
                this.brush_hardness = ((BigDecimal) obj3).floatValue();
            }
        }
        if (map.containsKey("feather")) {
            Object obj4 = map.get("feather");
            if (obj4 instanceof BigDecimal) {
                this.feather = ((BigDecimal) obj4).floatValue();
            }
        }
        if (map.containsKey("angle")) {
            Object obj5 = map.get("angle");
            if (obj5 instanceof BigDecimal) {
                this.angle = ((BigDecimal) obj5).floatValue();
            }
        }
        if (map.containsKey("threshold")) {
            Object obj6 = map.get("threshold");
            if (obj6 instanceof BigDecimal) {
                this.threshold = ((BigDecimal) obj6).floatValue();
            }
        }
        if (map.containsKey("selectedColor")) {
            Object obj7 = map.get("selectedColor");
            if (obj7 instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj7;
                if (arrayList.size() == 3 && (arrayList.get(0) instanceof BigDecimal)) {
                    this.selectedColor = new float[3];
                    this.selectedColor[0] = ((BigDecimal) arrayList.get(0)).floatValue();
                    this.selectedColor[1] = ((BigDecimal) arrayList.get(1)).floatValue();
                    this.selectedColor[2] = ((BigDecimal) arrayList.get(2)).floatValue();
                }
            }
        }
        if (map.containsKey("invert")) {
            this.invert = ((Boolean) map.get("invert")).booleanValue();
        }
        if (map.containsKey("showOverlay")) {
            this.showOverlay = ((Boolean) map.get("showOverlay")).booleanValue();
        }
        if (map.containsKey("disabled")) {
            this.disabled = ((Boolean) map.get("disabled")).booleanValue();
        }
        if (map.containsKey("useRadius")) {
            this.useRadius = ((Boolean) map.get("useRadius")).booleanValue();
        }
        if (map.containsKey("reflect")) {
            this.reflect = ((Boolean) map.get("reflect")).booleanValue();
        }
    }
}
