package com.oplus.camera.p172ui.menu;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CameraMenuOptionInfo.java */
/* renamed from: com.oplus.camera.ui.menu.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class CameraMenuOptionInfo {
    public static final int GROUP_TYPE_IMAGE_MENU = 3;
    public static final int GROUP_TYPE_MENU_EXPANDABLE = 2;
    public static final int GROUP_TYPE_NOMAL = 0;
    public static final int GROUP_TYPE_SHARE_RESOURCE = 1;
    public static final int GROUP_TYPE_TIME_LAPSE_SPEED = 4;
    private int mDrawerType;
    private String mOptionDefaultValue;
    private ArrayList<OptionItemInfo> mOptionItems;
    private String mOptionKey;
    private String mOptionTitle;
    private boolean mbOptionOnOff;
    private Bitmap mOptionSingleIcon = null;
    private Drawable mOptionExpandIcon = null;
    private Bitmap mOffAnimationIcon = null;
    private Bitmap mOnAnimationIcon = null;
    private boolean mbSwitchIconNeedAnim = false;
    private boolean mbLottieIconNeedAnim = false;
    private int mGroupType = 0;
    private boolean mImageTitleMode = false;
    private boolean mImageTitleColorChangeable = false;
    private int mIconsId = 0;
    private CameraUIListener mCameraUIListener = null;

    public CameraMenuOptionInfo() {
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

    public void setCameraUIListener(CameraUIListener cameraUIListener) {
        this.mCameraUIListener = cameraUIListener;
    }

    public int getOptionType() {
        return this.mDrawerType;
    }

    public void setOptionType(int OplusGLSurfaceView_13) {
        this.mDrawerType = OplusGLSurfaceView_13;
    }

    public String getOptionKey() {
        return this.mOptionKey;
    }

    public void setOptionKey(String str) {
        this.mOptionKey = str;
    }

    public String getOptionTitle() {
        return this.mOptionTitle;
    }

    public void setOptionTitle(String str) {
        this.mOptionTitle = str;
    }

    public String getOptionDefaultValue() {
        if (CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(getOptionKey())) {
            return getAIEnhancementVideoDefaultValue();
        }
        return this.mOptionDefaultValue;
    }

    public void setOptionDefaultValue(String str) {
        this.mOptionDefaultValue = str;
    }

    private String getAIEnhancementVideoDefaultValue() {
        CameraUIListener cameraUIListener = this.mCameraUIListener;
        return Util.m24438e(CameraCharacteristicsUtil.m12974a(cameraUIListener != null ? cameraUIListener.mo10653G() : 0));
    }

    public boolean getOptionOnOff() {
        return this.mbOptionOnOff;
    }

    public void setGroupType(int OplusGLSurfaceView_13) {
        this.mGroupType = OplusGLSurfaceView_13;
    }

    public int getGroupType() {
        return this.mGroupType;
    }

    public void setOptionOnOff(boolean z) {
        this.mbOptionOnOff = z;
    }

    public void setImageTitleMode(boolean z) {
        this.mImageTitleMode = z;
    }

    public void setImageTitleColorChangeable(boolean z) {
        this.mImageTitleColorChangeable = z;
    }

    public boolean getImageTitleMode() {
        return this.mImageTitleMode;
    }

    public boolean getImageTitleColorChangeable() {
        return this.mImageTitleColorChangeable;
    }

    public Bitmap getOptionSingleIcon() {
        return this.mOptionSingleIcon;
    }

    public void setOptionSingleIcon(Bitmap bitmap) {
        this.mOptionSingleIcon = bitmap;
    }

    public Drawable getOptionExpandIcon() {
        return this.mOptionExpandIcon;
    }

    public void setOptionExpandIcon(Drawable drawable) {
        this.mOptionExpandIcon = drawable;
    }

    public ArrayList<OptionItemInfo> getOptionItems() {
        return this.mOptionItems;
    }

    public void setOptionItems(ArrayList<OptionItemInfo> arrayList) {
        this.mOptionItems = arrayList;
    }

    public Bitmap getOnAnimationIcon() {
        return this.mOnAnimationIcon;
    }

    public void setOpenAnimationIcon(Bitmap bitmap) {
        this.mOnAnimationIcon = bitmap;
    }

    public void setSwitchIconNeedAnim(boolean z) {
        this.mbSwitchIconNeedAnim = z;
    }

    public boolean getSwitchIconNeedAnim() {
        return this.mbSwitchIconNeedAnim;
    }

    public Bitmap getOffAnimationIcon() {
        return this.mOffAnimationIcon;
    }

    public void setCloseAnimationIcon(Bitmap bitmap) {
        this.mOffAnimationIcon = bitmap;
    }

    public void setIconsId(int OplusGLSurfaceView_13) {
        this.mIconsId = OplusGLSurfaceView_13;
    }

    public int getIconsId() {
        return this.mIconsId;
    }

    public void setLottieIconNeedAnim(boolean z) {
        this.mbLottieIconNeedAnim = z;
    }

    public boolean getLottieIconNeedAnim() {
        return this.mbLottieIconNeedAnim;
    }

    public void release() {
        ArrayList<OptionItemInfo> arrayList = this.mOptionItems;
        if (arrayList != null) {
            Iterator<OptionItemInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                OptionItemInfo next = it.next();
                if (next != null) {
                    next.m20488g();
                }
            }
            this.mOptionItems.clear();
            this.mOptionItems = null;
        }
        Bitmap bitmap = this.mOptionSingleIcon;
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
