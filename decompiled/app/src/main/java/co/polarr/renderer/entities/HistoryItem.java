package co.polarr.renderer.entities;

import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p003b.p010f.C0119l;

/* loaded from: classes.dex */
public class HistoryItem {
    public String changed;
    public String message;
    public Map<String, Object> state;

    public HistoryItem() {
        this.message = "";
        this.state = new HashMap();
    }

    public HistoryItem(String str, Map<String, Object> map, String str2) {
        this.message = str;
        this.changed = str2;
        this.state = (Map) C0119l.m520b(map);
        this.state.remove("prevBrushes");
        this.state.remove("prevFaces");
        this.state.remove("zPrevSpots");
    }
}
