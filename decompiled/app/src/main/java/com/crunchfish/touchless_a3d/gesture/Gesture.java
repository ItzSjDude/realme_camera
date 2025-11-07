package com.crunchfish.touchless_a3d.gesture;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Gesture {
    private ArrayList<Listener> mListeners = new ArrayList<>();
    private long mNativeObj;

    public interface Listener {
        void onEvent(Event event);
    }

    private native long cCreateGesture(String str);

    public Gesture(String str) {
        this.mNativeObj = 0L;
        this.mNativeObj = cCreateGesture(str);
        if (this.mNativeObj == 0) {
            throw new IllegalArgumentException("Could not parse json argument");
        }
    }

    public void registerListener(Listener listener) {
        this.mListeners.add(listener);
    }

    public void unregisterListener(Listener listener) {
        this.mListeners.remove(listener);
    }

    void dispatchEvent(Event event) {
        Iterator<Listener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent(event);
        }
    }

    private long getNativeObject() {
        return this.mNativeObj;
    }
}
