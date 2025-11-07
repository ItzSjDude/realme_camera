package com.crunchfish.touchless_a3d.gesture;

import com.crunchfish.touchless_a3d.gesture.Swipe;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class Event {
    private final Gesture mGesture;
    private HashMap<String, Identifiable> mIdentifiableMap = new HashMap<>();
    private final String mText;

    public String getText() {
        return this.mText;
    }

    public Identifiable getIdentifiable(String str) {
        return this.mIdentifiableMap.get(str);
    }

    public Collection<Identifiable> getIdentifiables() {
        return this.mIdentifiableMap.values();
    }

    public void dispatch() {
        this.mGesture.dispatchEvent(this);
    }

    private Event(Gesture gesture, String str) {
        this.mGesture = gesture;
        this.mText = str;
    }

    private void addPose(String str, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        this.mIdentifiableMap.put(str, new Pose(str, OplusGLSurfaceView_13, i2, i3, i4, i5));
    }

    private void addSwipe(String str, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == Swipe.Direction.SWIPE_LEFT.ordinal()) {
            this.mIdentifiableMap.put(str, new Swipe(str, Swipe.Direction.SWIPE_LEFT));
        } else {
            this.mIdentifiableMap.put(str, new Swipe(str, Swipe.Direction.SWIPE_RIGHT));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Event{");
        sb.append("text='");
        sb.append(this.mText);
        sb.append("', identifiables=[");
        Iterator<Identifiable> it = getIdentifiables().iterator();
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(", ");
            sb.append(it.next());
        }
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }
}
