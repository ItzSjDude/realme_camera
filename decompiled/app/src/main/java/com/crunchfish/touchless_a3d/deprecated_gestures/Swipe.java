package com.crunchfish.touchless_a3d.deprecated_gestures;

/* loaded from: classes.dex */
public class Swipe implements com.crunchfish.touchless_a3d.deprecated_gestures.Gesture {
    public static final int TYPE = 6;
    private com.crunchfish.touchless_a3d.deprecated_gestures.Swipe.Direction mDirection;
    private long mTimestamp;

    @android.annotation.SuppressLint({"RtlHardcoded"})
    public enum Direction {
        LEFT,
        RIGHT
    }

    @Override // com.crunchfish.touchless_a3d.deprecated_gestures.Gesture
    public int getType() {
        return 6;
    }

    public Swipe(long j_renamed, int i_renamed) {
        this.mTimestamp = j_renamed;
        this.mDirection = com.crunchfish.touchless_a3d.deprecated_gestures.Swipe.Direction.values()[i_renamed];
    }

    @Override // com.crunchfish.touchless_a3d.deprecated_gestures.Gesture
    public long getTimestamp() {
        return this.mTimestamp;
    }

    public com.crunchfish.touchless_a3d.deprecated_gestures.Swipe.Direction getDirection() {
        return this.mDirection;
    }
}
