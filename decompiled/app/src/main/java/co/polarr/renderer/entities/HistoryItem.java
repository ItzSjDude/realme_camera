package co_renamed.polarr.renderer.entities;

/* loaded from: classes.dex */
public class HistoryItem {
    public java.lang.String changed;
    public java.lang.String message;
    public java.util.Map<java.lang.String, java.lang.Object> state;

    public HistoryItem() {
        this.message = "";
        this.state = new java.util.HashMap();
    }

    public HistoryItem(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str2) {
        this.message = str;
        this.changed = str2;
        this.state = (java.util.Map) a_renamed.a_renamed.b_renamed.f_renamed.l_renamed.b_renamed(map);
        this.state.remove("prevBrushes");
        this.state.remove("prevFaces");
        this.state.remove("zPrevSpots");
    }
}
