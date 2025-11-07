package com.crunchfish.touchless_a3d.deprecated_gestures;

import android.util.Log;

/* loaded from: classes.dex */
public abstract class ObjectPresence implements Gesture {
    static final String LOG_TAG = "crunchfish";
    private Action mAction;
    private int mHeight;
    private int mObjectId;
    private int mPrevX;
    private int mPrevY;
    private int mPrevZ;
    private long mTimestamp;
    private int mWidth;

    /* renamed from: mX */
    private int f8935mX;

    /* renamed from: mY */
    private int f8936mY;

    /* renamed from: mZ */
    private int f8937mZ;

    public enum Action {
        START,
        MOVEMENT,
        END
    }

    protected ObjectPresence() {
    }

    public static <T extends ObjectPresence> T create(Class<T> cls, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) throws IllegalAccessException, InstantiationException {
        try {
            T tNewInstance = cls.newInstance();
            ((ObjectPresence) tNewInstance).mTimestamp = OplusGLSurfaceView_15;
            ((ObjectPresence) tNewInstance).mObjectId = OplusGLSurfaceView_13;
            ((ObjectPresence) tNewInstance).mAction = Action.values()[i2];
            ((ObjectPresence) tNewInstance).f8935mX = i3;
            ((ObjectPresence) tNewInstance).f8936mY = i4;
            ((ObjectPresence) tNewInstance).f8937mZ = i5;
            ((ObjectPresence) tNewInstance).mPrevX = i6;
            ((ObjectPresence) tNewInstance).mPrevY = i7;
            ((ObjectPresence) tNewInstance).mPrevZ = i8;
            ((ObjectPresence) tNewInstance).mWidth = i9;
            ((ObjectPresence) tNewInstance).mHeight = i10;
            return tNewInstance;
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(LOG_TAG, String.format("Failed accessing constructor of class %s", cls.getName()), COUIBaseListPopupWindow_8);
            return null;
        } catch (InstantiationException e2) {
            Log.COUIBaseListPopupWindow_8(LOG_TAG, String.format("Failed creating instance of class %s", cls.getName()), e2);
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

    public Action getAction() {
        return this.mAction;
    }

    public int getCenterX() {
        return this.f8935mX;
    }

    public int getCenterY() {
        return this.f8936mY;
    }

    public int getZ() {
        return this.f8937mZ;
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
