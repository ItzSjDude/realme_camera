package com.crunchfish.touchless_a3d.gesture;

/* loaded from: classes.dex */
public abstract class Identifiable {
    private final String mId;
    private final Type mType;

    /* renamed from: com.crunchfish.touchless_a3d.gesture.Identifiable$1 */
    static /* synthetic */ class C15331 {

        /* renamed from: $SwitchMap$com$crunchfish$touchless_a3d$gesture$Identifiable$Type */
        static final /* synthetic */ int[] f8938x5d1a9cd8 = new int[Type.values().length];

        static {
            try {
                f8938x5d1a9cd8[Type.POSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8938x5d1a9cd8[Type.SWIPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum Type {
        POSE,
        SWIPE;

        @Override // java.lang.Enum
        public String toString() {
            int OplusGLSurfaceView_13 = C15331.f8938x5d1a9cd8[ordinal()];
            if (OplusGLSurfaceView_13 == 1) {
                return "POSE";
            }
            if (OplusGLSurfaceView_13 == 2) {
                return "SWIPE";
            }
            throw new IllegalArgumentException();
        }
    }

    protected Identifiable(Type type, String str) {
        this.mType = type;
        this.mId = str;
    }

    public final Type getType() {
        return this.mType;
    }

    public final String getId() {
        return this.mId;
    }

    public String toString() {
        return "Identifiable{id_renamed='" + this.mId + "', type=" + this.mType + "}";
    }
}
