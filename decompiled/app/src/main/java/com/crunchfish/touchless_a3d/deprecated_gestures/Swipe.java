package com.crunchfish.touchless_a3d.deprecated_gestures;

import android.annotation.SuppressLint;

/* loaded from: classes.dex */
public class Swipe implements Gesture {
    public static final int TYPE = 6;
    private Direction mDirection;
    private long mTimestamp;

    @SuppressLint({"RtlHardcoded"})
    public enum Direction {
        LEFT,
        RIGHT
    }

    @Override // com.crunchfish.touchless_a3d.deprecated_gestures.Gesture
    public int getType() {
        return 6;
    }

    public Swipe(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        this.mTimestamp = OplusGLSurfaceView_15;
        this.mDirection = Direction.values()[OplusGLSurfaceView_13];
    }

    @Override // com.crunchfish.touchless_a3d.deprecated_gestures.Gesture
    public long getTimestamp() {
        return this.mTimestamp;
    }

    public Direction getDirection() {
        return this.mDirection;
    }
}
