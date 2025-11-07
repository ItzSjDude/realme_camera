package com.crunchfish.touchless_a3d.gesture;

/* loaded from: classes.dex */
public class Pose extends com.crunchfish.touchless_a3d.gesture.Identifiable {
    private final int mObjectType;
    private final android.graphics.Rect mRect;

    Pose(java.lang.String str, int i_renamed, int i2, int i3, int i4, int i5) {
        super(com.crunchfish.touchless_a3d.gesture.Identifiable.Type.POSE, str);
        this.mObjectType = i_renamed;
        this.mRect = new android.graphics.Rect(i2, i3, i4, i5);
    }

    public int getPoseType() {
        return this.mObjectType;
    }

    public android.graphics.Rect getBoundingArea() {
        return this.mRect;
    }

    @Override // com.crunchfish.touchless_a3d.gesture.Identifiable
    public java.lang.String toString() {
        return "Pose{id_renamed='" + getId() + "', objectType=" + this.mObjectType + ", bounds={" + this.mRect.toShortString() + "}}";
    }
}
