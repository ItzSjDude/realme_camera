package com.oplus.camera.p172ui.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.menu.setting.CameraMenuOption;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class BasicOptionItemList extends RelativeLayout {

    /* renamed from: A */
    protected Animation.AnimationListener f18891A;

    /* renamed from: B */
    private boolean f18892B;

    /* renamed from: C */
    private boolean f18893C;

    /* renamed from: D */
    private boolean f18894D;

    /* renamed from: PlatformImplementations.kt_3 */
    protected int f18895a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected int f18896b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected int f18897c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected int f18898d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected int f18899e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected int f18900f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected int f18901g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected int f18902h;

    /* renamed from: OplusGLSurfaceView_13 */
    protected int f18903i;

    /* renamed from: OplusGLSurfaceView_15 */
    protected int f18904j;

    /* renamed from: OplusGLSurfaceView_5 */
    protected int f18905k;

    /* renamed from: OplusGLSurfaceView_14 */
    protected int f18906l;

    /* renamed from: OplusGLSurfaceView_6 */
    protected int f18907m;

    /* renamed from: OplusGLSurfaceView_11 */
    protected int f18908n;

    /* renamed from: o */
    protected int f18909o;

    /* renamed from: p */
    protected int f18910p;

    /* renamed from: q */
    protected Context f18911q;

    /* renamed from: r */
    protected List<CameraMenuOption> f18912r;

    /* renamed from: s */
    protected ItemClickListener f18913s;

    /* renamed from: t */
    protected OptionItemListListener f18914t;

    /* renamed from: u */
    protected OnPopUpFadeOutAnimationStartListener f18915u;

    /* renamed from: v */
    protected ViewGroup f18916v;

    /* renamed from: w */
    protected AnimationSet f18917w;

    /* renamed from: x */
    protected AnimationSet f18918x;

    /* renamed from: y */
    protected AnimationSet f18919y;

    /* renamed from: z */
    protected Animation.AnimationListener f18920z;

    public interface OnPopUpFadeOutAnimationStartListener {
        void onPopUpFadeOutAnimationEnd();
    }

    public interface OptionItemListListener {
        /* renamed from: PlatformImplementations.kt_3 */
        String mo20300a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo20301a(CameraMenuOption cameraMenuOption, int OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20285a(boolean z, boolean z2, int OplusGLSurfaceView_13) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo20288b() {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo20290b(boolean z, boolean z2, int OplusGLSurfaceView_13) {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo20292c() {
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void mo20298i() {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setOptionItemIcon(Bitmap bitmap) {
    }

    public void setTitleName(String str) {
    }

    public BasicOptionItemList(Context context) {
        super(context);
        this.f18895a = 0;
        this.f18896b = 0;
        this.f18897c = 0;
        this.f18898d = 0;
        this.f18899e = 0;
        this.f18900f = 0;
        this.f18901g = 0;
        this.f18902h = 0;
        this.f18903i = 0;
        this.f18904j = 0;
        this.f18905k = -1;
        this.f18906l = 0;
        this.f18907m = 0;
        this.f18908n = 0;
        this.f18909o = 0;
        this.f18910p = 0;
        this.f18911q = null;
        this.f18912r = null;
        this.f18913s = null;
        this.f18914t = null;
        this.f18916v = null;
        this.f18917w = null;
        this.f18918x = null;
        this.f18919y = null;
        this.f18920z = new PopUpFadeInAnimationListener();
        this.f18891A = new PopUpFadeOutAnimationListener();
        this.f18892B = false;
        this.f18893C = false;
        this.f18894D = false;
        this.f18911q = context;
        this.f18912r = new ArrayList();
        this.f18913s = new ItemClickListener();
        this.f18895a = this.f18911q.getResources().getDimensionPixelSize(R.dimen.menu_setting_width);
        this.f18899e = this.f18911q.getResources().getDimensionPixelSize(R.dimen.itemlist_less_than_three_items_margin_left);
        this.f18900f = this.f18911q.getResources().getDimensionPixelSize(R.dimen.itemlist_less_than_two_items_margin_left);
        this.f18901g = this.f18911q.getResources().getDimensionPixelSize(R.dimen.itemlist_more_than_three_items_margin_left);
        this.f18902h = this.f18911q.getResources().getDimensionPixelSize(R.dimen.itemlist_less_than_three_items_padding_right);
        this.f18903i = this.f18911q.getResources().getDimensionPixelSize(R.dimen.itemlist_more_than_three_items_padding_right);
        this.f18904j = this.f18911q.getResources().getDimensionPixelSize(R.dimen.itemlist_min_items_margin);
        this.f18892B = false;
        this.f18893C = false;
        this.f18909o = this.f18911q.getResources().getDimensionPixelSize(R.dimen.itemlist_left_margin);
        this.f18910p = this.f18911q.getResources().getDimensionPixelSize(R.dimen.itemlist_right_margin);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20282a(View view, int OplusGLSurfaceView_13, int i2) {
        if (view != null) {
            this.f18916v = (ViewGroup) view.getRootView().findViewById(R.id_renamed.camera);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20279a() {
        int OplusGLSurfaceView_13;
        List<CameraMenuOption> list = this.f18912r;
        if (list != null) {
            if (list.size() == 3 && getItemsMeasureWidth() <= ((Util.getScreenWidth() - this.f18899e) - this.f18902h) - (this.f18904j * (this.f18912r.size() - 1))) {
                this.f18896b = this.f18899e;
                this.f18898d = this.f18902h;
            } else if (this.f18912r.size() == 2 && getItemsMeasureWidth() <= ((Util.getScreenWidth() - this.f18900f) - this.f18902h) - (this.f18904j * (this.f18912r.size() - 1))) {
                this.f18896b = this.f18900f;
                this.f18898d = this.f18902h;
            } else {
                this.f18896b = this.f18901g;
                this.f18898d = this.f18903i;
            }
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams == null || 4 == (OplusGLSurfaceView_13 = this.f18907m) || 1 == OplusGLSurfaceView_13) {
            return;
        }
        layoutParams.leftMargin = this.f18909o;
        layoutParams.rightMargin = this.f18910p;
        setLayoutParams(layoutParams);
    }

    public int getMarginLeft() throws Resources.NotFoundException {
        int dimensionPixelSize = this.f18911q.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_width);
        return (this.f18911q.getResources().getDimensionPixelSize(R.dimen.fold_tool_first_level_bar_width) - ((this.f18912r.size() - 1) * (this.f18911q.getResources().getDimensionPixelSize(R.dimen.menu_item_second_space) + dimensionPixelSize))) - dimensionPixelSize;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20280a(int OplusGLSurfaceView_13) {
        this.f18908n = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo20286a(CameraMenuOption cameraMenuOption) {
        List<CameraMenuOption> list;
        if (cameraMenuOption == null || (list = this.f18912r) == null || list.contains(cameraMenuOption)) {
            return false;
        }
        cameraMenuOption.m21108a(this.f18913s);
        this.f18912r.add(cameraMenuOption);
        cameraMenuOption.mo21107a((ViewGroup) this);
        return true;
    }

    public void setDrawShadow(boolean z) {
        List<CameraMenuOption> list = this.f18912r;
        if (list != null) {
            Iterator<CameraMenuOption> it = list.iterator();
            while (it.hasNext()) {
                it.next().mo21135b(z);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo20287a(CameraMenuOption cameraMenuOption, int OplusGLSurfaceView_13) {
        if (cameraMenuOption == null || this.f18912r.contains(cameraMenuOption)) {
            return false;
        }
        if (OplusGLSurfaceView_13 < 0) {
            OplusGLSurfaceView_13 = 0;
        }
        if (OplusGLSurfaceView_13 >= this.f18912r.size()) {
            OplusGLSurfaceView_13 = this.f18912r.size();
        }
        this.f18912r.add(OplusGLSurfaceView_13, cameraMenuOption);
        cameraMenuOption.m21108a(this.f18913s);
        cameraMenuOption.mo21107a((ViewGroup) this);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20289b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f18912r.size()) {
            CameraLog.m12954a("BasicOptionItemList", "removeOptionItem(), exception: the index is error, index: " + OplusGLSurfaceView_13);
            return;
        }
        CameraMenuOption cameraMenuOption = this.f18912r.get(OplusGLSurfaceView_13);
        this.f18912r.remove(OplusGLSurfaceView_13);
        cameraMenuOption.m21176n();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public CameraMenuOption m20291c(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f18912r.size()) {
            CameraLog.m12954a("BasicOptionItemList", "getOptionItem(), exception: the index is error, index: " + OplusGLSurfaceView_13);
            return null;
        }
        return this.f18912r.get(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20284a(boolean z, boolean z2) {
        List<CameraMenuOption> list = this.f18912r;
        if (list == null || list.size() < 1) {
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f18912r.size(); OplusGLSurfaceView_13++) {
            this.f18912r.get(OplusGLSurfaceView_13).mo21115a(z, z2);
        }
    }

    public void setSelectItemIndex(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 == this.f18905k) {
            return;
        }
        this.f18905k = OplusGLSurfaceView_13;
    }

    public void setOptionItemListListener(OptionItemListListener optionItemListListener) {
        this.f18914t = optionItemListListener;
    }

    public void setOnPopUpFadeOutAnimationStartListener(OnPopUpFadeOutAnimationStartListener onPopUpFadeOutAnimationStartListener) {
        this.f18915u = onPopUpFadeOutAnimationStartListener;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20281a(int OplusGLSurfaceView_13, boolean z) {
        if (this.f18906l != OplusGLSurfaceView_13) {
            this.f18906l = OplusGLSurfaceView_13;
            List<CameraMenuOption> list = this.f18912r;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (CameraMenuOption cameraMenuOption : this.f18912r) {
                if (cameraMenuOption != null) {
                    cameraMenuOption.mo21103a(OplusGLSurfaceView_13, z);
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m20293d() {
        m20279a();
        setVisibility(0);
        clearAnimation();
        if (this.f18917w == null) {
            mo20292c();
        }
        AnimationSet animationSet = this.f18917w;
        if (animationSet != null) {
            startAnimation(animationSet);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m20294e() {
        m20283a(true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20283a(boolean z) {
        if (isShown()) {
            if (this.f18919y == null) {
                mo20292c();
            }
            AnimationSet animationSet = this.f18919y;
            if (animationSet != null) {
                if (!animationSet.hasStarted() || this.f18919y.hasEnded()) {
                    this.f18894D = z;
                    clearAnimation();
                    startAnimation(this.f18919y);
                }
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo20295f() {
        clearAnimation();
        setVisibility(8);
        OptionItemListListener optionItemListListener = this.f18914t;
        if (optionItemListListener != null) {
            PopUpWindowManager.m20710c(optionItemListListener.mo20300a());
        }
        this.f18892B = false;
        this.f18893C = false;
    }

    public boolean getPopUpWindowState() {
        return isShown();
    }

    public int getItemsMeasureWidth() {
        List<CameraMenuOption> list = this.f18912r;
        int iMo21073B = 0;
        if (list != null && list.size() > 0) {
            for (CameraMenuOption cameraMenuOption : this.f18912r) {
                if (cameraMenuOption != null) {
                    iMo21073B += cameraMenuOption.mo21073B();
                }
            }
        }
        return iMo21073B;
    }

    public int getItemsMeasureHeight() {
        int iMo21074C;
        List<CameraMenuOption> list = this.f18912r;
        int OplusGLSurfaceView_13 = 0;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        for (CameraMenuOption cameraMenuOption : this.f18912r) {
            if (cameraMenuOption != null && OplusGLSurfaceView_13 < (iMo21074C = cameraMenuOption.mo21074C())) {
                OplusGLSurfaceView_13 = iMo21074C;
            }
        }
        return OplusGLSurfaceView_13 * this.f18912r.size();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        List<CameraMenuOption> list = this.f18912r;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i5 = 0;
        for (CameraMenuOption cameraMenuOption : this.f18912r) {
            if (cameraMenuOption != null) {
                int iMo21073B = cameraMenuOption.mo21073B();
                int iMo21074C = cameraMenuOption.mo21074C() + i5;
                cameraMenuOption.m21102a(0, i5, iMo21073B, iMo21074C);
                i5 = iMo21074C;
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m20296g() {
        if (isShown()) {
            clearAnimation();
            setVisibility(8);
        }
        this.f18892B = false;
        this.f18893C = false;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo20297h() {
        CameraLog.m12954a("BasicOptionItemList", "release()");
        if (this.f18912r != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f18912r.size(); OplusGLSurfaceView_13++) {
                CameraMenuOption cameraMenuOption = this.f18912r.get(OplusGLSurfaceView_13);
                if (cameraMenuOption != null) {
                    cameraMenuOption.m21176n();
                }
            }
            this.f18912r.clear();
            this.f18912r = null;
        }
        removeAllViews();
        ViewGroup viewGroup = this.f18916v;
        if (viewGroup != null) {
            viewGroup.removeView(this);
            this.f18916v = null;
        }
        this.f18911q = null;
        this.f18914t = null;
        this.f18913s = null;
        this.f18920z = null;
        this.f18891A = null;
    }

    public void setScreenLayoutMode(int OplusGLSurfaceView_13) {
        this.f18907m = OplusGLSurfaceView_13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ItemClickListener implements CameraMenuOption.OnItemClickListener {
        private ItemClickListener() {
        }

        @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption.OnItemClickListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20299a(CameraMenuOption cameraMenuOption) {
            if (BasicOptionItemList.this.f18912r == null || BasicOptionItemList.this.f18912r.size() <= 0 || BasicOptionItemList.this.f18893C || BasicOptionItemList.this.f18914t == null) {
                return;
            }
            int iIndexOf = BasicOptionItemList.this.f18912r.indexOf(cameraMenuOption);
            CameraLog.m12954a("BasicOptionItemList", "onItemClick, index: " + iIndexOf);
            BasicOptionItemList.this.f18914t.mo20301a(cameraMenuOption, iIndexOf);
        }
    }

    protected final class PopUpFadeInAnimationListener implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        protected PopUpFadeInAnimationListener() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BasicOptionItemList.this.m20284a(true, false);
            if (BasicOptionItemList.this.isShown()) {
                if (BasicOptionItemList.this.f18914t != null) {
                    PopUpWindowManager.m20709b(BasicOptionItemList.this.f18914t.mo20300a());
                }
                if (BasicOptionItemList.this.f18918x == null || BasicOptionItemList.this.f18892B) {
                    return;
                }
                BasicOptionItemList basicOptionItemList = BasicOptionItemList.this;
                basicOptionItemList.startAnimation(basicOptionItemList.f18918x);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            BasicOptionItemList.this.m20284a(false, false);
            BasicOptionItemList.this.f18893C = false;
            if (BasicOptionItemList.this.f18914t == null || BasicOptionItemList.this.f18892B) {
                return;
            }
            PopUpWindowManager.m20702a(BasicOptionItemList.this.f18914t.mo20300a());
        }
    }

    protected final class PopUpFadeOutAnimationListener implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        protected PopUpFadeOutAnimationListener() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BasicOptionItemList.this.m20284a(true, false);
            BasicOptionItemList.this.setVisibility(8);
            BasicOptionItemList.this.f18892B = false;
            if (BasicOptionItemList.this.f18914t != null) {
                PopUpWindowManager.m20710c(BasicOptionItemList.this.f18914t.mo20300a());
            }
            if (BasicOptionItemList.this.f18915u != null) {
                BasicOptionItemList.this.f18915u.onPopUpFadeOutAnimationEnd();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            BasicOptionItemList.this.m20284a(false, false);
            BasicOptionItemList.this.f18892B = true;
            BasicOptionItemList.this.f18893C = true;
            if (BasicOptionItemList.this.f18914t != null) {
                PopUpWindowManager.m20703a(BasicOptionItemList.this.f18914t.mo20300a(), BasicOptionItemList.this.f18894D);
            }
        }
    }
}
