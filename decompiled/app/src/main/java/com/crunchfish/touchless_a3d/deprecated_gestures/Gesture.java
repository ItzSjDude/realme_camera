package com.crunchfish.touchless_a3d.deprecated_gestures;

/* loaded from: classes.dex */
public interface Gesture {

    public interface Listener {
        void onGesture(com.crunchfish.touchless_a3d.deprecated_gestures.Gesture gesture);
    }

    long getTimestamp();

    int getType();
}
