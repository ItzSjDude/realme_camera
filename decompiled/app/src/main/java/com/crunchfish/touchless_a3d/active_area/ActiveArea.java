package com.crunchfish.touchless_a3d.active_area;

/* loaded from: classes.dex */
public final class ActiveArea {
    private static final int COORDINATES_PER_CORNER = 2;
    private static final int COORDINATES_PER_RECTANGLE = 4;
    private static final int CORNERS_PER_RECTANGLE = 2;
    private final android.graphics.Region mRegion = new android.graphics.Region();

    public interface Listener {
        void onActiveArea(com.crunchfish.touchless_a3d.active_area.ActiveArea activeArea);
    }

    private void addSubAreas(int[] iArr) throws java.lang.IllegalArgumentException {
        if (iArr.length % 4 != 0) {
            throw new java.lang.IllegalArgumentException("Missing coordinates from array");
        }
        for (int i_renamed = 0; i_renamed < iArr.length; i_renamed += 4) {
            addSubArea(iArr[i_renamed], iArr[i_renamed + 1], iArr[i_renamed + 2], iArr[i_renamed + 3]);
        }
    }

    private void addSubArea(int i_renamed, int i2, int i3, int i4) {
        this.mRegion.union(new android.graphics.Rect(i_renamed, i2, i3 + 1, i4 + 1));
    }

    public android.graphics.Region getRegion() {
        return this.mRegion;
    }
}
