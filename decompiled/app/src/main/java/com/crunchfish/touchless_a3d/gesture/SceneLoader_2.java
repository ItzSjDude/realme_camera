package com.crunchfish.touchless_a3d.gesture;

/* loaded from: classes.dex */
public abstract class Identifiable {
    private final java.lang.String mId;
    private final com.crunchfish.touchless_a3d.gesture.Identifiable.Type mType;

    /* renamed from: com.crunchfish.touchless_a3d.gesture.Identifiable$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {
        static final /* synthetic */ int[] $SwitchMap$com$crunchfish$touchless_a3d$gesture$Identifiable$Type = new int[com.crunchfish.touchless_a3d.gesture.Identifiable.Type.values().length];

        static {
            try {
                $SwitchMap$com$crunchfish$touchless_a3d$gesture$Identifiable$Type[com.crunchfish.touchless_a3d.gesture.Identifiable.Type.POSE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$crunchfish$touchless_a3d$gesture$Identifiable$Type[com.crunchfish.touchless_a3d.gesture.Identifiable.Type.SWIPE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public enum Type {
        POSE,
        SWIPE;

        @Override // java.lang.Enum
        public java.lang.String toString() {
            int i_renamed = com.crunchfish.touchless_a3d.gesture.Identifiable.SceneLoader_2.$SwitchMap$com$crunchfish$touchless_a3d$gesture$Identifiable$Type[ordinal()];
            if (i_renamed == 1) {
                return "POSE";
            }
            if (i_renamed == 2) {
                return "SWIPE";
            }
            throw new java.lang.IllegalArgumentException();
        }
    }

    protected Identifiable(com.crunchfish.touchless_a3d.gesture.Identifiable.Type type, java.lang.String str) {
        this.mType = type;
        this.mId = str;
    }

    public final com.crunchfish.touchless_a3d.gesture.Identifiable.Type getType() {
        return this.mType;
    }

    public final java.lang.String getId() {
        return this.mId;
    }

    public java.lang.String toString() {
        return "Identifiable{id_renamed='" + this.mId + "', type=" + this.mType + "}";
    }
}
