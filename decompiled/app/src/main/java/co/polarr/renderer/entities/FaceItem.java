package co.polarr.renderer.entities;

import co.polarr.renderer.entities.Context;
import java.util.HashMap;
import p000a.p001a.p003b.p010f.C0109b;

/* loaded from: classes.dex */
public class FaceItem {
    public Context.FaceState adjustments = new Context.FaceState();
    public float[] boundaries;
    public float[][] markers;

    public static FaceItem fromDecodedHashMap(HashMap<String, Object> map) {
        return fromJSON(C0109b.m466a(map));
    }

    public static FaceItem fromJSON(String str) {
        return (FaceItem) C0109b.m465a(str, FaceItem.class);
    }
}
