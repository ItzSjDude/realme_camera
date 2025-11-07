package com.oplus.compat.app;

/* loaded from: classes2.dex */
public class TaskSnapshotNative implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.compat.app.TaskSnapshotNative> CREATOR = new android.os.Parcelable.Creator<com.oplus.compat.app.TaskSnapshotNative>() { // from class: com.oplus.compat.app.TaskSnapshotNative.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.compat.app.TaskSnapshotNative createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.compat.app.TaskSnapshotNative(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.compat.app.TaskSnapshotNative[] newArray(int i_renamed) {
            return new com.oplus.compat.app.TaskSnapshotNative[i_renamed];
        }
    };
    private final android.graphics.ColorSpace mColorSpace;
    private final android.graphics.Rect mContentInsets;
    private final long mId;
    private final boolean mIsLowResolution;
    private final boolean mIsRealSnapshot;
    private final boolean mIsTranslucent;

    @android.content.res.Configuration.Orientation
    private final int mOrientation;
    private int mRotation;
    private final android.graphics.GraphicBuffer mSnapshot;
    private final int mSystemUiVisibility;
    private final android.graphics.Point mTaskSize;
    private final android.content.ComponentName mTopActivityComponent;
    private final int mWindowingMode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TaskSnapshotNative(long j_renamed, android.content.ComponentName componentName, android.graphics.GraphicBuffer graphicBuffer, android.graphics.ColorSpace colorSpace, int i_renamed, int i2, android.graphics.Point point, android.graphics.Rect rect, boolean z_renamed, boolean z2, int i3, int i4, boolean z3) {
        this.mId = j_renamed;
        this.mTopActivityComponent = componentName;
        this.mSnapshot = graphicBuffer;
        this.mColorSpace = colorSpace.getId() < 0 ? android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.SRGB) : colorSpace;
        this.mOrientation = i_renamed;
        this.mRotation = i2;
        this.mTaskSize = new android.graphics.Point(point);
        this.mContentInsets = new android.graphics.Rect(rect);
        this.mIsLowResolution = z_renamed;
        this.mIsRealSnapshot = z2;
        this.mWindowingMode = i3;
        this.mSystemUiVisibility = i4;
        this.mIsTranslucent = z3;
    }

    private TaskSnapshotNative(android.os.Parcel parcel) {
        android.graphics.ColorSpace colorSpace;
        this.mId = parcel.readLong();
        this.mTopActivityComponent = android.content.ComponentName.readFromParcel(parcel);
        this.mSnapshot = parcel.readParcelable(null);
        int i_renamed = parcel.readInt();
        if (i_renamed >= 0 && i_renamed < android.graphics.ColorSpace.Named.values().length) {
            colorSpace = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.values()[i_renamed]);
        } else {
            colorSpace = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.SRGB);
        }
        this.mColorSpace = colorSpace;
        this.mOrientation = parcel.readInt();
        this.mRotation = parcel.readInt();
        this.mTaskSize = (android.graphics.Point) parcel.readParcelable(null);
        this.mContentInsets = (android.graphics.Rect) parcel.readParcelable(null);
        this.mIsLowResolution = parcel.readBoolean();
        this.mIsRealSnapshot = parcel.readBoolean();
        this.mWindowingMode = parcel.readInt();
        this.mSystemUiVisibility = parcel.readInt();
        this.mIsTranslucent = parcel.readBoolean();
    }

    public long getId() {
        return this.mId;
    }

    public android.content.ComponentName getTopActivityComponent() {
        return this.mTopActivityComponent;
    }

    @android.compat.annotation.UnsupportedAppUsage
    public android.graphics.GraphicBuffer getSnapshot() {
        return this.mSnapshot;
    }

    public android.graphics.ColorSpace getColorSpace() {
        return this.mColorSpace;
    }

    @android.compat.annotation.UnsupportedAppUsage
    public int getOrientation() {
        return this.mOrientation;
    }

    public int getRotation() {
        return this.mRotation;
    }

    @android.compat.annotation.UnsupportedAppUsage
    public android.graphics.Point getTaskSize() {
        return this.mTaskSize;
    }

    @android.compat.annotation.UnsupportedAppUsage
    public android.graphics.Rect getContentInsets() {
        return this.mContentInsets;
    }

    @android.compat.annotation.UnsupportedAppUsage
    public boolean isLowResolution() {
        return this.mIsLowResolution;
    }

    @android.compat.annotation.UnsupportedAppUsage
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
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeLong(this.mId);
        android.content.ComponentName.writeToParcel(this.mTopActivityComponent, parcel);
        android.graphics.GraphicBuffer graphicBuffer = this.mSnapshot;
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

    public java.lang.String toString() {
        android.graphics.GraphicBuffer graphicBuffer = this.mSnapshot;
        int width = graphicBuffer != null ? graphicBuffer.getWidth() : 0;
        android.graphics.GraphicBuffer graphicBuffer2 = this.mSnapshot;
        return "TaskSnapshot{ mId=" + this.mId + " mTopActivityComponent=" + this.mTopActivityComponent.flattenToShortString() + " mSnapshot=" + this.mSnapshot + " (" + width + "x_renamed" + (graphicBuffer2 != null ? graphicBuffer2.getHeight() : 0) + ") mColorSpace=" + this.mColorSpace.toString() + " mOrientation=" + this.mOrientation + " mRotation=" + this.mRotation + " mTaskSize=" + this.mTaskSize.toString() + " mContentInsets=" + this.mContentInsets.toShortString() + " mIsLowResolution=" + this.mIsLowResolution + " mIsRealSnapshot=" + this.mIsRealSnapshot + " mWindowingMode=" + this.mWindowingMode + " mSystemUiVisibility=" + this.mSystemUiVisibility + " mIsTranslucent=" + this.mIsTranslucent;
    }
}
