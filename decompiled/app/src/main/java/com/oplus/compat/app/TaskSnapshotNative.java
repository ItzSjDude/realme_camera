package com.oplus.compat.app;

import android.compat.annotation.UnsupportedAppUsage;
import android.content.ComponentName;
import android.content.res.Configuration;
import android.graphics.ColorSpace;
import android.graphics.GraphicBuffer;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class TaskSnapshotNative implements Parcelable {
    public static final Parcelable.Creator<TaskSnapshotNative> CREATOR = new Parcelable.Creator<TaskSnapshotNative>() { // from class: com.oplus.compat.app.TaskSnapshotNative.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public TaskSnapshotNative createFromParcel(Parcel parcel) {
            return new TaskSnapshotNative(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public TaskSnapshotNative[] newArray(int OplusGLSurfaceView_13) {
            return new TaskSnapshotNative[OplusGLSurfaceView_13];
        }
    };
    private final ColorSpace mColorSpace;
    private final Rect mContentInsets;
    private final long mId;
    private final boolean mIsLowResolution;
    private final boolean mIsRealSnapshot;
    private final boolean mIsTranslucent;

    @Configuration.Orientation
    private final int mOrientation;
    private int mRotation;
    private final GraphicBuffer mSnapshot;
    private final int mSystemUiVisibility;
    private final Point mTaskSize;
    private final ComponentName mTopActivityComponent;
    private final int mWindowingMode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TaskSnapshotNative(long OplusGLSurfaceView_15, ComponentName componentName, GraphicBuffer graphicBuffer, ColorSpace colorSpace, int OplusGLSurfaceView_13, int i2, Point point, Rect rect, boolean z, boolean z2, int i3, int i4, boolean z3) {
        this.mId = OplusGLSurfaceView_15;
        this.mTopActivityComponent = componentName;
        this.mSnapshot = graphicBuffer;
        this.mColorSpace = colorSpace.getId() < 0 ? ColorSpace.get(ColorSpace.Named.SRGB) : colorSpace;
        this.mOrientation = OplusGLSurfaceView_13;
        this.mRotation = i2;
        this.mTaskSize = new Point(point);
        this.mContentInsets = new Rect(rect);
        this.mIsLowResolution = z;
        this.mIsRealSnapshot = z2;
        this.mWindowingMode = i3;
        this.mSystemUiVisibility = i4;
        this.mIsTranslucent = z3;
    }

    private TaskSnapshotNative(Parcel parcel) {
        ColorSpace colorSpace;
        this.mId = parcel.readLong();
        this.mTopActivityComponent = ComponentName.readFromParcel(parcel);
        this.mSnapshot = parcel.readParcelable(null);
        int OplusGLSurfaceView_13 = parcel.readInt();
        if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < ColorSpace.Named.values().length) {
            colorSpace = ColorSpace.get(ColorSpace.Named.values()[OplusGLSurfaceView_13]);
        } else {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        this.mColorSpace = colorSpace;
        this.mOrientation = parcel.readInt();
        this.mRotation = parcel.readInt();
        this.mTaskSize = (Point) parcel.readParcelable(null);
        this.mContentInsets = (Rect) parcel.readParcelable(null);
        this.mIsLowResolution = parcel.readBoolean();
        this.mIsRealSnapshot = parcel.readBoolean();
        this.mWindowingMode = parcel.readInt();
        this.mSystemUiVisibility = parcel.readInt();
        this.mIsTranslucent = parcel.readBoolean();
    }

    public long getId() {
        return this.mId;
    }

    public ComponentName getTopActivityComponent() {
        return this.mTopActivityComponent;
    }

    @UnsupportedAppUsage
    public GraphicBuffer getSnapshot() {
        return this.mSnapshot;
    }

    public ColorSpace getColorSpace() {
        return this.mColorSpace;
    }

    @UnsupportedAppUsage
    public int getOrientation() {
        return this.mOrientation;
    }

    public int getRotation() {
        return this.mRotation;
    }

    @UnsupportedAppUsage
    public Point getTaskSize() {
        return this.mTaskSize;
    }

    @UnsupportedAppUsage
    public Rect getContentInsets() {
        return this.mContentInsets;
    }

    @UnsupportedAppUsage
    public boolean isLowResolution() {
        return this.mIsLowResolution;
    }

    @UnsupportedAppUsage
    public boolean isRealSnapshot() {
        return this.mIsRealSnapshot;
    }

    public boolean isTranslucent() {
        return this.mIsTranslucent;
    }

    public int getWindowingMode() {
        return this.mWindowingMode;
    }

    public int getSystemUiVisibility() {
        return this.mSystemUiVisibility;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeLong(this.mId);
        ComponentName.writeToParcel(this.mTopActivityComponent, parcel);
        GraphicBuffer graphicBuffer = this.mSnapshot;
        parcel.writeParcelable((graphicBuffer == null || graphicBuffer.isDestroyed()) ? null : this.mSnapshot, 0);
        parcel.writeInt(this.mColorSpace.getId());
        parcel.writeInt(this.mOrientation);
        parcel.writeInt(this.mRotation);
        parcel.writeParcelable(this.mTaskSize, 0);
        parcel.writeParcelable(this.mContentInsets, 0);
        parcel.writeBoolean(this.mIsLowResolution);
        parcel.writeBoolean(this.mIsRealSnapshot);
        parcel.writeInt(this.mWindowingMode);
        parcel.writeInt(this.mSystemUiVisibility);
        parcel.writeBoolean(this.mIsTranslucent);
    }

    public String toString() {
        GraphicBuffer graphicBuffer = this.mSnapshot;
        int width = graphicBuffer != null ? graphicBuffer.getWidth() : 0;
        GraphicBuffer graphicBuffer2 = this.mSnapshot;
        return "TaskSnapshot{ mId=" + this.mId + " mTopActivityComponent=" + this.mTopActivityComponent.flattenToShortString() + " mSnapshot=" + this.mSnapshot + " (" + width + "x" + (graphicBuffer2 != null ? graphicBuffer2.getHeight() : 0) + ") mColorSpace=" + this.mColorSpace.toString() + " mOrientation=" + this.mOrientation + " mRotation=" + this.mRotation + " mTaskSize=" + this.mTaskSize.toString() + " mContentInsets=" + this.mContentInsets.toShortString() + " mIsLowResolution=" + this.mIsLowResolution + " mIsRealSnapshot=" + this.mIsRealSnapshot + " mWindowingMode=" + this.mWindowingMode + " mSystemUiVisibility=" + this.mSystemUiVisibility + " mIsTranslucent=" + this.mIsTranslucent;
    }
}
