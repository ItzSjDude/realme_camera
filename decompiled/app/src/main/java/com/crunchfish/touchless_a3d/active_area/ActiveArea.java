package com.crunchfish.touchless_a3d.active_area;

import android.graphics.Rect;
import android.graphics.Region;

/* loaded from: classes.dex */
public final class ActiveArea {
    private static final int COORDINATES_PER_CORNER = 2;
    private static final int COORDINATES_PER_RECTANGLE = 4;
    private static final int CORNERS_PER_RECTANGLE = 2;
    private final Region mRegion = new Region();

    public interface Listener {
        void onActiveArea(ActiveArea activeArea);
    }

    private void addSubAreas(int[] iArr) throws IllegalArgumentException {
        if (iArr.length % 4 != 0) {
            throw new IllegalArgumentException("Missing coordinates from array");
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr.length; OplusGLSurfaceView_13 += 4) {
            addSubArea(iArr[OplusGLSurfaceView_13], iArr[OplusGLSurfaceView_13 + 1], iArr[OplusGLSurfaceView_13 + 2], iArr[OplusGLSurfaceView_13 + 3]);
        }
    }

    private void addSubArea(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.mRegion.union(new Rect(OplusGLSurfaceView_13, i2, i3 + 1, i4 + 1));
    }

    public Region getRegion() {
        return this.mRegion;
    }
}
