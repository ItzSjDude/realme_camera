package com.crunchfish.touchless_a3d.deprecated_gestures;

/* loaded from: classes.dex */
public interface Gesture {

    public interface Listener {
        void onGesture(Gesture gesture);
    }

    long getTimestamp();

    int getType();
}
