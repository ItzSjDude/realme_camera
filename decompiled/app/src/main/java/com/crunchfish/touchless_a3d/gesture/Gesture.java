package com.crunchfish.touchless_a3d.gesture;

/* loaded from: classes.dex */
public class Gesture {
    private java.util.ArrayList<com.crunchfish.touchless_a3d.gesture.Gesture.Listener> mListeners = new java.util.ArrayList<>();
    private long mNativeObj;

    public interface Listener {
        void onEvent(com.crunchfish.touchless_a3d.gesture.Event event);
    }

    private native long cCreateGesture(java.lang.String str);

    public Gesture(java.lang.String str) {
        this.mNativeObj = 0L;
        this.mNativeObj = cCreateGesture(str);
        if (this.mNativeObj == 0) {
            throw new java.lang.IllegalArgumentException("Could not parse json argument");
        }
    }

    public void registerListener(com.crunchfish.touchless_a3d.gesture.Gesture.Listener listener) {
        this.mListeners.add(listener);
    }

    public void unregisterListener(com.crunchfish.touchless_a3d.gesture.Gesture.Listener listener) {
        this.mListeners.remove(listener);
    }

    void dispatchEvent(com.crunchfish.touchless_a3d.gesture.Event event) {
        java.util.Iterator<com.crunchfish.touchless_a3d.gesture.Gesture.Listener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent(event);
        }
    }

    private long getNativeObject() {
        return this.mNativeObj;
    }
}
