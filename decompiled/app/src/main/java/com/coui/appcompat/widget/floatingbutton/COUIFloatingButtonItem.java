package com.coui.appcompat.widget.floatingbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.p016a.p017a.AppCompatResources;

/* loaded from: classes.dex */
public class COUIFloatingButtonItem implements Parcelable {
    public static final Parcelable.Creator<COUIFloatingButtonItem> CREATOR = new Parcelable.Creator<COUIFloatingButtonItem>() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public COUIFloatingButtonItem createFromParcel(Parcel parcel) {
            return new COUIFloatingButtonItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public COUIFloatingButtonItem[] newArray(int OplusGLSurfaceView_13) {
            return new COUIFloatingButtonItem[OplusGLSurfaceView_13];
        }
    };
    public static final int RESOURCE_NOT_SET = Integer.MIN_VALUE;
    private boolean mCOUIFloatingButtonExpandEnable;
    private final int mCOUIFloatingButtonItemLocation;
    private ColorStateList mFabBackgroundColor;
    private final Drawable mFabImageDrawable;
    private final int mFabImageResource;
    private final String mLabel;
    private ColorStateList mLabelBackgroundColor;
    private ColorStateList mLabelColor;
    private final int mLabelRes;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private COUIFloatingButtonItem(C1469a c1469a) {
        this.mFabBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mCOUIFloatingButtonExpandEnable = true;
        this.mLabel = c1469a.f8076d;
        this.mLabelRes = c1469a.f8077e;
        this.mFabImageResource = c1469a.f8074b;
        this.mFabImageDrawable = c1469a.f8075c;
        this.mFabBackgroundColor = c1469a.f8078f;
        this.mLabelColor = c1469a.f8079g;
        this.mLabelBackgroundColor = c1469a.f8080h;
        this.mCOUIFloatingButtonExpandEnable = c1469a.f8081i;
        this.mCOUIFloatingButtonItemLocation = c1469a.f8073a;
    }

    public int getFloatingButtonItemLocation() {
        return this.mCOUIFloatingButtonItemLocation;
    }

    public String getLabel(Context context) {
        String str = this.mLabel;
        if (str != null) {
            return str;
        }
        int OplusGLSurfaceView_13 = this.mLabelRes;
        if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
            return context.getString(OplusGLSurfaceView_13);
        }
        return null;
    }

    public Drawable getFabImageDrawable(Context context) {
        Drawable drawable = this.mFabImageDrawable;
        if (drawable != null) {
            return drawable;
        }
        int OplusGLSurfaceView_13 = this.mFabImageResource;
        if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
            return AppCompatResources.m732b(context, OplusGLSurfaceView_13);
        }
        return null;
    }

    public ColorStateList getFabBackgroundColor() {
        return this.mFabBackgroundColor;
    }

    public ColorStateList getLabelColor() {
        return this.mLabelColor;
    }

    public ColorStateList getLabelBackgroundColor() {
        return this.mLabelBackgroundColor;
    }

    public boolean isCOUIFloatingButtonExpandEnable() {
        return this.mCOUIFloatingButtonExpandEnable;
    }

    public COUIFloatingButtonLabel createFabWithLabelView(Context context) {
        COUIFloatingButtonLabel c1470a = new COUIFloatingButtonLabel(context);
        c1470a.setFloatingButtonItem(this);
        return c1470a;
    }

    /* renamed from: com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem$PlatformImplementations.kt_3 */
    public static class C1469a {

        /* renamed from: PlatformImplementations.kt_3 */
        private final int f8073a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f8074b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Drawable f8075c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private String f8076d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f8077e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private ColorStateList f8078f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private ColorStateList f8079g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private ColorStateList f8080h;

        /* renamed from: OplusGLSurfaceView_13 */
        private boolean f8081i;

        public C1469a(int OplusGLSurfaceView_13, int i2) {
            this.f8077e = Integer.MIN_VALUE;
            this.f8078f = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.f8079g = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.f8080h = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.f8081i = true;
            this.f8073a = OplusGLSurfaceView_13;
            this.f8074b = i2;
            this.f8075c = null;
        }

        public C1469a(COUIFloatingButtonItem cOUIFloatingButtonItem) {
            this.f8077e = Integer.MIN_VALUE;
            this.f8078f = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.f8079g = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.f8080h = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.f8081i = true;
            this.f8076d = cOUIFloatingButtonItem.mLabel;
            this.f8077e = cOUIFloatingButtonItem.mLabelRes;
            this.f8074b = cOUIFloatingButtonItem.mFabImageResource;
            this.f8075c = cOUIFloatingButtonItem.mFabImageDrawable;
            this.f8078f = cOUIFloatingButtonItem.mFabBackgroundColor;
            this.f8079g = cOUIFloatingButtonItem.mLabelColor;
            this.f8080h = cOUIFloatingButtonItem.mLabelBackgroundColor;
            this.f8081i = cOUIFloatingButtonItem.mCOUIFloatingButtonExpandEnable;
            this.f8073a = cOUIFloatingButtonItem.mCOUIFloatingButtonItemLocation;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public C1469a m7742a(String str) {
            this.f8076d = str;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public C1469a m7741a(ColorStateList colorStateList) {
            this.f8078f = colorStateList;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public C1469a m7744b(ColorStateList colorStateList) {
            this.f8079g = colorStateList;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public C1469a m7745c(ColorStateList colorStateList) {
            this.f8080h = colorStateList;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public COUIFloatingButtonItem m7743a() {
            return new COUIFloatingButtonItem(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeString(this.mLabel);
        parcel.writeInt(this.mLabelRes);
        parcel.writeInt(this.mFabImageResource);
        parcel.writeInt(this.mCOUIFloatingButtonItemLocation);
    }

    protected COUIFloatingButtonItem(Parcel parcel) {
        this.mFabBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mCOUIFloatingButtonExpandEnable = true;
        this.mLabel = parcel.readString();
        this.mLabelRes = parcel.readInt();
        this.mFabImageResource = parcel.readInt();
        this.mFabImageDrawable = null;
        this.mCOUIFloatingButtonItemLocation = parcel.readInt();
    }
}
