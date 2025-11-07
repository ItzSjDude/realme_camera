package com.crunchfish.touchless_a3d.gesture;

import com.crunchfish.touchless_a3d.gesture.Identifiable;

/* loaded from: classes.dex */
public class Swipe extends Identifiable {
    private final Direction mDirection;

    /* renamed from: com.crunchfish.touchless_a3d.gesture.Swipe$1 */
    static /* synthetic */ class C15341 {

        /* renamed from: $SwitchMap$com$crunchfish$touchless_a3d$gesture$Swipe$Direction */
        static final /* synthetic */ int[] f8939xe0473665 = new int[Direction.values().length];

        static {
            try {
                f8939xe0473665[Direction.SWIPE_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8939xe0473665[Direction.SWIPE_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum Direction {
        SWIPE_LEFT,
        SWIPE_RIGHT;

        @Override // java.lang.Enum
        public String toString() {
            int OplusGLSurfaceView_13 = C15341.f8939xe0473665[ordinal()];
            if (OplusGLSurfaceView_13 == 1) {
                return "LEFT";
            }
            if (OplusGLSurfaceView_13 == 2) {
                return "RIGHT";
            }
            throw new IllegalArgumentException();
        }
    }

    Swipe(String str, Direction direction) {
        super(Identifiable.Type.SWIPE, str);
        this.mDirection = direction;
    }

    public Direction getDirection() {
        return this.mDirection;
    }

    @Override // com.crunchfish.touchless_a3d.gesture.Identifiable
    public String toString() {
        return "Swipe{id_renamed='" + getId() + "', direction=" + this.mDirection + "}";
    }
}
