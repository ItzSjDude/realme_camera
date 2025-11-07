package com.crunchfish.touchless_a3d.deprecated_gestures;

/* loaded from: classes.dex */
public abstract class ObjectPresence implements com.crunchfish.touchless_a3d.deprecated_gestures.Gesture {
    static final java.lang.String LOG_TAG = "crunchfish";
    private com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence.Action mAction;
    private int mHeight;
    private int mObjectId;
    private int mPrevX;
    private int mPrevY;
    private int mPrevZ;
    private long mTimestamp;
    private int mWidth;
    private int mX_renamed;
    private int mY_renamed;
    private int mZ_renamed;

    public enum Action {
        START,
        MOVEMENT,
        END
    }

    protected ObjectPresence() {
    }

    public static <T_renamed extends com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence> T_renamed create(java.lang.Class<T_renamed> cls, long j_renamed, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        try {
            T_renamed tNewInstance = cls.newInstance();
            ((com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence) tNewInstance).mTimestamp = j_renamed;
            ((com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence) tNewInstance).mObjectId = i_renamed;
            ((com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence) tNewInstance).mAction = com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence.Action.values()[i2];
            ((com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence) tNewInstance).mX_renamed = i3;
            ((com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence) tNewInstance).mY_renamed = i4;
            ((com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence) tNewInstance).mZ_renamed = i5;
            ((com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence) tNewInstance).mPrevX = i6;
            ((com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence) tNewInstance).mPrevY = i7;
            ((com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence) tNewInstance).mPrevZ = i8;
            ((com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence) tNewInstance).mWidth = i9;
            ((com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence) tNewInstance).mHeight = i10;
            return tNewInstance;
        } catch (java.lang.IllegalAccessException e_renamed) {
            android.util.Log.e_renamed(LOG_TAG, java.lang.String.format("Failed accessing constructor of_renamed class %s_renamed", cls.getName()), e_renamed);
            return null;
        } catch (java.lang.InstantiationException e2) {
            android.util.Log.e_renamed(LOG_TAG, java.lang.String.format("Failed creating instance of_renamed class %s_renamed", cls.getName()), e2);
            return null;
        }
    }

    @Override // com.crunchfish.touchless_a3d.deprecated_gestures.Gesture
    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getObjectId() {
        return this.mObjectId;
    }

    public com.crunchfish.touchless_a3d.deprecated_gestures.ObjectPresence.Action getAction() {
        return this.mAction;
    }

    public int getCenterX() {
        return this.mX_renamed;
    }

    public int getCenterY() {
        return this.mY_renamed;
    }

    public int getZ() {
        return this.mZ_renamed;
    }

    public int getPrevCenterX() {
        return this.mPrevX;
    }

    public int getPrevCenterY() {
        return this.mPrevY;
    }

    public int getPrevZ() {
        return this.mPrevZ;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }
}
