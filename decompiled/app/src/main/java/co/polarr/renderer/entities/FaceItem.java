package co_renamed.polarr.renderer.entities;

/* loaded from: classes.dex */
public class FaceItem {
    public co_renamed.polarr.renderer.entities.Context.FaceState adjustments = new co_renamed.polarr.renderer.entities.Context.FaceState();
    public float[] boundaries;
    public float[][] markers;

    public static co_renamed.polarr.renderer.entities.FaceItem fromDecodedHashMap(java.util.HashMap<java.lang.String, java.lang.Object> map) {
        return fromJSON(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(map));
    }

    public static co_renamed.polarr.renderer.entities.FaceItem fromJSON(java.lang.String str) {
        return (co_renamed.polarr.renderer.entities.FaceItem) a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(str, co_renamed.polarr.renderer.entities.FaceItem.class);
    }
}
