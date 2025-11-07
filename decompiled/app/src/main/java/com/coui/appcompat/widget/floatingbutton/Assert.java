package com.coui.appcompat.widget.floatingbutton;

/* loaded from: classes.dex */
public class COUIFloatingButtonItem implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem> CREATOR = new android.os.Parcelable.Creator<com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem>() { // from class: com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem createFromParcel(android.os.Parcel parcel) {
            return new com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem[] newArray(int i_renamed) {
            return new com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem[i_renamed];
        }
    };
    public static final int RESOURCE_NOT_SET = Integer.MIN_VALUE;
    private boolean mCOUIFloatingButtonExpandEnable;
    private final int mCOUIFloatingButtonItemLocation;
    private android.content.res.ColorStateList mFabBackgroundColor;
    private final android.graphics.drawable.Drawable mFabImageDrawable;
    private final int mFabImageResource;
    private final java.lang.String mLabel;
    private android.content.res.ColorStateList mLabelBackgroundColor;
    private android.content.res.ColorStateList mLabelColor;
    private final int mLabelRes;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private COUIFloatingButtonItem(com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem.a_renamed aVar) {
        this.mFabBackgroundColor = android.content.res.ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelColor = android.content.res.ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelBackgroundColor = android.content.res.ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mCOUIFloatingButtonExpandEnable = true;
        this.mLabel = aVar.d_renamed;
        this.mLabelRes = aVar.e_renamed;
        this.mFabImageResource = aVar.f2934b;
        this.mFabImageDrawable = aVar.f2935c;
        this.mFabBackgroundColor = aVar.f_renamed;
        this.mLabelColor = aVar.g_renamed;
        this.mLabelBackgroundColor = aVar.h_renamed;
        this.mCOUIFloatingButtonExpandEnable = aVar.i_renamed;
        this.mCOUIFloatingButtonItemLocation = aVar.f2933a;
    }

    public int getFloatingButtonItemLocation() {
        return this.mCOUIFloatingButtonItemLocation;
    }

    public java.lang.String getLabel(android.content.Context context) {
        java.lang.String str = this.mLabel;
        if (str != null) {
            return str;
        }
        int i_renamed = this.mLabelRes;
        if (i_renamed != Integer.MIN_VALUE) {
            return context.getString(i_renamed);
        }
        return null;
    }

    public android.graphics.drawable.Drawable getFabImageDrawable(android.content.Context context) {
        android.graphics.drawable.Drawable drawable = this.mFabImageDrawable;
        if (drawable != null) {
            return drawable;
        }
        int i_renamed = this.mFabImageResource;
        if (i_renamed != Integer.MIN_VALUE) {
            return androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(context, i_renamed);
        }
        return null;
    }

    public android.content.res.ColorStateList getFabBackgroundColor() {
        return this.mFabBackgroundColor;
    }

    public android.content.res.ColorStateList getLabelColor() {
        return this.mLabelColor;
    }

    public android.content.res.ColorStateList getLabelBackgroundColor() {
        return this.mLabelBackgroundColor;
    }

    public boolean isCOUIFloatingButtonExpandEnable() {
        return this.mCOUIFloatingButtonExpandEnable;
    }

    public com.coui.appcompat.widget.floatingbutton.a_renamed createFabWithLabelView(android.content.Context context) {
        com.coui.appcompat.widget.floatingbutton.a_renamed aVar = new com.coui.appcompat.widget.floatingbutton.a_renamed(context);
        aVar.setFloatingButtonItem(this);
        return aVar;
    }

    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final int f2933a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int f2934b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private android.graphics.drawable.Drawable f2935c;
        private java.lang.String d_renamed;
        private int e_renamed;
        private android.content.res.ColorStateList f_renamed;
        private android.content.res.ColorStateList g_renamed;
        private android.content.res.ColorStateList h_renamed;
        private boolean i_renamed;

        public a_renamed(int i_renamed, int i2) {
            this.e_renamed = Integer.MIN_VALUE;
            this.f_renamed = android.content.res.ColorStateList.valueOf(Integer.MIN_VALUE);
            this.g_renamed = android.content.res.ColorStateList.valueOf(Integer.MIN_VALUE);
            this.h_renamed = android.content.res.ColorStateList.valueOf(Integer.MIN_VALUE);
            this.i_renamed = true;
            this.f2933a = i_renamed;
            this.f2934b = i2;
            this.f2935c = null;
        }

        public a_renamed(com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem cOUIFloatingButtonItem) {
            this.e_renamed = Integer.MIN_VALUE;
            this.f_renamed = android.content.res.ColorStateList.valueOf(Integer.MIN_VALUE);
            this.g_renamed = android.content.res.ColorStateList.valueOf(Integer.MIN_VALUE);
            this.h_renamed = android.content.res.ColorStateList.valueOf(Integer.MIN_VALUE);
            this.i_renamed = true;
            this.d_renamed = cOUIFloatingButtonItem.mLabel;
            this.e_renamed = cOUIFloatingButtonItem.mLabelRes;
            this.f2934b = cOUIFloatingButtonItem.mFabImageResource;
            this.f2935c = cOUIFloatingButtonItem.mFabImageDrawable;
            this.f_renamed = cOUIFloatingButtonItem.mFabBackgroundColor;
            this.g_renamed = cOUIFloatingButtonItem.mLabelColor;
            this.h_renamed = cOUIFloatingButtonItem.mLabelBackgroundColor;
            this.i_renamed = cOUIFloatingButtonItem.mCOUIFloatingButtonExpandEnable;
            this.f2933a = cOUIFloatingButtonItem.mCOUIFloatingButtonItemLocation;
        }

        public com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem.a_renamed a_renamed(java.lang.String str) {
            this.d_renamed = str;
            return this;
        }

        public com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem.a_renamed a_renamed(android.content.res.ColorStateList colorStateList) {
            this.f_renamed = colorStateList;
            return this;
        }

        public com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem.a_renamed b_renamed(android.content.res.ColorStateList colorStateList) {
            this.g_renamed = colorStateList;
            return this;
        }

        public com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem.a_renamed c_renamed(android.content.res.ColorStateList colorStateList) {
            this.h_renamed = colorStateList;
            return this;
        }

        public com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem a_renamed() {
            return new com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonItem(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mLabel);
        parcel.writeInt(this.mLabelRes);
        parcel.writeInt(this.mFabImageResource);
        parcel.writeInt(this.mCOUIFloatingButtonItemLocation);
    }

    protected COUIFloatingButtonItem(android.os.Parcel parcel) {
        this.mFabBackgroundColor = android.content.res.ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelColor = android.content.res.ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelBackgroundColor = android.content.res.ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mCOUIFloatingButtonExpandEnable = true;
        this.mLabel = parcel.readString();
        this.mLabelRes = parcel.readInt();
        this.mFabImageResource = parcel.readInt();
        this.mFabImageDrawable = null;
        this.mCOUIFloatingButtonItemLocation = parcel.readInt();
    }
}
