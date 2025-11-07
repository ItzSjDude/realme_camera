package com.crunchfish.touchless_a3d.gesture;

/* loaded from: classes.dex */
public final class Event {
    private final com.crunchfish.touchless_a3d.gesture.Gesture mGesture;
    private java.util.HashMap<java.lang.String, com.crunchfish.touchless_a3d.gesture.Identifiable> mIdentifiableMap = new java.util.HashMap<>();
    private final java.lang.String mText;

    public java.lang.String getText() {
        return this.mText;
    }

    public com.crunchfish.touchless_a3d.gesture.Identifiable getIdentifiable(java.lang.String str) {
        return this.mIdentifiableMap.get(str);
    }

    public java.util.Collection<com.crunchfish.touchless_a3d.gesture.Identifiable> getIdentifiables() {
        return this.mIdentifiableMap.values();
    }

    public void dispatch() {
        this.mGesture.dispatchEvent(this);
    }

    private Event(com.crunchfish.touchless_a3d.gesture.Gesture gesture, java.lang.String str) {
        this.mGesture = gesture;
        this.mText = str;
    }

    private void addPose(java.lang.String str, int i_renamed, int i2, int i3, int i4, int i5) {
        this.mIdentifiableMap.put(str, new com.crunchfish.touchless_a3d.gesture.Pose(str, i_renamed, i2, i3, i4, i5));
    }

    private void addSwipe(java.lang.String str, int i_renamed) {
        if (i_renamed == com.crunchfish.touchless_a3d.gesture.Swipe.Direction.SWIPE_LEFT.ordinal()) {
            this.mIdentifiableMap.put(str, new com.crunchfish.touchless_a3d.gesture.Swipe(str, com.crunchfish.touchless_a3d.gesture.Swipe.Direction.SWIPE_LEFT));
        } else {
            this.mIdentifiableMap.put(str, new com.crunchfish.touchless_a3d.gesture.Swipe(str, com.crunchfish.touchless_a3d.gesture.Swipe.Direction.SWIPE_RIGHT));
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Event{");
        sb.append("text='");
        sb.append(this.mText);
        sb.append("', identifiables=[");
        java.util.Iterator<com.crunchfish.touchless_a3d.gesture.Identifiable> it = getIdentifiables().iterator();
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
