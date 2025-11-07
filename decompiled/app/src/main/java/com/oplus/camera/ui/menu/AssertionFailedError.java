package com.oplus.camera.ui.menu;

/* compiled from: CameraMenuOptionInfo.java */
/* loaded from: classes2.dex */
public class b_renamed {
    public static final int GROUP_TYPE_IMAGE_MENU = 3;
    public static final int GROUP_TYPE_MENU_EXPANDABLE = 2;
    public static final int GROUP_TYPE_NOMAL = 0;
    public static final int GROUP_TYPE_SHARE_RESOURCE = 1;
    public static final int GROUP_TYPE_TIME_LAPSE_SPEED = 4;
    private int mDrawerType;
    private java.lang.String mOptionDefaultValue;
    private java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> mOptionItems;
    private java.lang.String mOptionKey;
    private java.lang.String mOptionTitle;
    private boolean mbOptionOnOff;
    private android.graphics.Bitmap mOptionSingleIcon = null;
    private android.graphics.drawable.Drawable mOptionExpandIcon = null;
    private android.graphics.Bitmap mOffAnimationIcon = null;
    private android.graphics.Bitmap mOnAnimationIcon = null;
    private boolean mbSwitchIconNeedAnim = false;
    private boolean mbLottieIconNeedAnim = false;
    private int mGroupType = 0;
    private boolean mImageTitleMode = false;
    private boolean mImageTitleColorChangeable = false;
    private int mIconsId = 0;
    private com.oplus.camera.ui.CameraUIListener mCameraUIListener = null;

    public b_renamed() {
        this.mOptionKey = null;
        this.mOptionTitle = null;
        this.mOptionDefaultValue = null;
        this.mOptionItems = null;
        this.mbOptionOnOff = false;
        this.mDrawerType = 0;
        this.mOptionKey = null;
        this.mOptionTitle = null;
        this.mOptionDefaultValue = null;
        this.mOptionItems = null;
        this.mbOptionOnOff = false;
        this.mDrawerType = -1;
    }

    public void setCameraUIListener(com.oplus.camera.ui.CameraUIListener cameraUIListener) {
        this.mCameraUIListener = cameraUIListener;
    }

    public int getOptionType() {
        return this.mDrawerType;
    }

    public void setOptionType(int i_renamed) {
        this.mDrawerType = i_renamed;
    }

    public java.lang.String getOptionKey() {
        return this.mOptionKey;
    }

    public void setOptionKey(java.lang.String str) {
        this.mOptionKey = str;
    }

    public java.lang.String getOptionTitle() {
        return this.mOptionTitle;
    }

    public void setOptionTitle(java.lang.String str) {
        this.mOptionTitle = str;
    }

    public java.lang.String getOptionDefaultValue() {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(getOptionKey())) {
            return getAIEnhancementVideoDefaultValue();
        }
        return this.mOptionDefaultValue;
    }

    public void setOptionDefaultValue(java.lang.String str) {
        this.mOptionDefaultValue = str;
    }

    private java.lang.String getAIEnhancementVideoDefaultValue() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.mCameraUIListener;
        return com.oplus.camera.util.Util.e_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(cameraUIListener != null ? cameraUIListener.G_renamed() : 0));
    }

    public boolean getOptionOnOff() {
        return this.mbOptionOnOff;
    }

    public void setGroupType(int i_renamed) {
        this.mGroupType = i_renamed;
    }

    public int getGroupType() {
        return this.mGroupType;
    }

    public void setOptionOnOff(boolean z_renamed) {
        this.mbOptionOnOff = z_renamed;
    }

    public void setImageTitleMode(boolean z_renamed) {
        this.mImageTitleMode = z_renamed;
    }

    public void setImageTitleColorChangeable(boolean z_renamed) {
        this.mImageTitleColorChangeable = z_renamed;
    }

    public boolean getImageTitleMode() {
        return this.mImageTitleMode;
    }

    public boolean getImageTitleColorChangeable() {
        return this.mImageTitleColorChangeable;
    }

    public android.graphics.Bitmap getOptionSingleIcon() {
        return this.mOptionSingleIcon;
    }

    public void setOptionSingleIcon(android.graphics.Bitmap bitmap) {
        this.mOptionSingleIcon = bitmap;
    }

    public android.graphics.drawable.Drawable getOptionExpandIcon() {
        return this.mOptionExpandIcon;
    }

    public void setOptionExpandIcon(android.graphics.drawable.Drawable drawable) {
        this.mOptionExpandIcon = drawable;
    }

    public java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> getOptionItems() {
        return this.mOptionItems;
    }

    public void setOptionItems(java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList) {
        this.mOptionItems = arrayList;
    }

    public android.graphics.Bitmap getOnAnimationIcon() {
        return this.mOnAnimationIcon;
    }

    public void setOpenAnimationIcon(android.graphics.Bitmap bitmap) {
        this.mOnAnimationIcon = bitmap;
    }

    public void setSwitchIconNeedAnim(boolean z_renamed) {
        this.mbSwitchIconNeedAnim = z_renamed;
    }

    public boolean getSwitchIconNeedAnim() {
        return this.mbSwitchIconNeedAnim;
    }

    public android.graphics.Bitmap getOffAnimationIcon() {
        return this.mOffAnimationIcon;
    }

    public void setCloseAnimationIcon(android.graphics.Bitmap bitmap) {
        this.mOffAnimationIcon = bitmap;
    }

    public void setIconsId(int i_renamed) {
        this.mIconsId = i_renamed;
    }

    public int getIconsId() {
        return this.mIconsId;
    }

    public void setLottieIconNeedAnim(boolean z_renamed) {
        this.mbLottieIconNeedAnim = z_renamed;
    }

    public boolean getLottieIconNeedAnim() {
        return this.mbLottieIconNeedAnim;
    }

    public void release() {
        java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList = this.mOptionItems;
        if (arrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.e_renamed> it = arrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.e_renamed next = it.next();
                if (next != null) {
                    next.g_renamed();
                }
            }
            this.mOptionItems.clear();
            this.mOptionItems = null;
        }
        android.graphics.Bitmap bitmap = this.mOptionSingleIcon;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mOptionSingleIcon.recycle();
            this.mOptionSingleIcon = null;
        }
        this.mOptionDefaultValue = null;
        this.mOptionKey = null;
        this.mOptionTitle = null;
        this.mCameraUIListener = null;
    }
}
