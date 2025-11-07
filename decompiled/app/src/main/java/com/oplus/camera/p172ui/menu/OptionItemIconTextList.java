package com.oplus.camera.p172ui.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import androidx.core.p027a.ContextCompat;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.OrientationAnimation;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.p172ui.menu.BasicOptionItemList;
import com.oplus.camera.p172ui.menu.setting.CameraMenuOption;
import com.oplus.camera.util.Util;
import java.util.Iterator;

/* compiled from: OptionItemIconTextList.java */
/* renamed from: com.oplus.camera.ui.menu.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class OptionItemIconTextList extends BasicOptionItemList implements InverseAble {

    /* renamed from: B */
    private RotateImageView f19135B;

    /* renamed from: C */
    private OrientationAnimation f19136C;

    /* renamed from: D */
    private CameraUIListener f19137D;

    /* renamed from: E */
    private SingleTextItemView f19138E;

    /* renamed from: F */
    private String f19139F;

    /* renamed from: G */
    private PathInterpolator f19140G;

    /* renamed from: H */
    private PathInterpolator f19141H;

    /* renamed from: I */
    private int f19142I;

    /* renamed from: J */
    private int f19143J;

    public OptionItemIconTextList(Context context, CameraUIListener cameraUIListener) {
        super(context);
        this.f19135B = null;
        this.f19136C = null;
        this.f19137D = null;
        this.f19138E = null;
        this.f19139F = "";
        this.f19140G = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f19141H = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f19142I = context.getResources().getDimensionPixelSize(R.dimen.sub_menu_fade_out_y);
        this.f19143J = context.getResources().getDimensionPixelSize(R.dimen.sub_menu_fade_out_x);
        this.f19137D = cameraUIListener;
        setClipChildren(false);
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20282a(View view, int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        super.mo20282a(view, OplusGLSurfaceView_13, i2);
        if (view == null || this.f18916v == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, Math.max(getItemsMeasureHeight(), m20472a(this.f18911q)));
        layoutParams.topMargin = i2;
        layoutParams.leftMargin = this.f18896b;
        mo20298i();
        this.f18916v.addView(this, layoutParams);
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo20298i() throws Resources.NotFoundException {
        int iMo21074C;
        int iMo21073B;
        CameraMenuOption cameraMenuOption;
        if (this.f19138E != null) {
            return;
        }
        int screenWidth = Util.getScreenWidth();
        if (Util.m24498u()) {
            screenWidth = this.f19137D.mo10769bL().m16505b();
        }
        int childCount = getChildCount();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.menu_item_second_space);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.menu_title_margin_right);
        if (4 == this.f19137D.mo10816ca()) {
            screenWidth = getResources().getDimensionPixelSize(R.dimen.rack_mode_tool_first_level_bar_width);
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.rack_mode_tool_second_level_item_space);
        }
        if (this.f18912r.isEmpty() || (cameraMenuOption = this.f18912r.get(0)) == null) {
            iMo21074C = 0;
            iMo21073B = 0;
        } else {
            iMo21073B = cameraMenuOption.mo21073B();
            iMo21074C = cameraMenuOption.mo21074C();
        }
        this.f19138E = new SingleTextItemView(getContext(), null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(((((screenWidth - (iMo21073B * childCount)) - ((childCount - 1) * dimensionPixelSize)) - dimensionPixelSize2) - this.f18909o) - this.f18910p, iMo21074C);
        this.f19138E.setGravity(16);
        this.f19138E.setLayoutParams(layoutParams);
        this.f19138E.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.menu_item_second_text_size));
        this.f19138E.setMaxLines(2);
        this.f19138E.setEllipsize(TextUtils.TruncateAt.END);
        this.f19138E.setTextColor(this.f18911q.getColorStateList(R.color.menu_item_text_color_selector));
        this.f19138E.setItemText(this.f19139F);
        this.f19138E.setContentDescription(this.f19139F);
        InverseManager.INS.registerInverse(this.f18911q, this.f19138E);
        if (1 != this.f19137D.mo10816ca()) {
            addView(this.f19138E);
        }
        this.f19138E.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.menu.IntrinsicsJvm.kt_5.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OptionItemIconTextList.this.m20294e();
            }
        });
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo20288b() throws Resources.NotFoundException {
        super.mo20288b();
        SingleTextItemView c3265j = this.f19138E;
        if (c3265j != null) {
            removeView(c3265j);
            this.f19138E = null;
        }
        mo20298i();
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    public void setTitleName(String str) {
        this.f19139F = str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m20472a(Context context) {
        if (context == null) {
            return 0;
        }
        return Util.getSettingMenuPanelHeight();
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo20292c() {
        this.f18917w = new AnimationSet(false);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(this.f19140G);
        alphaAnimation.setStartOffset(150L);
        this.f18917w.addAnimation(alphaAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, this.f19142I, 0.0f);
        if (1 == this.f19137D.mo10816ca()) {
            translateAnimation = new TranslateAnimation(this.f19143J, 0.0f, 0.0f, 0.0f);
        }
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(this.f19141H);
        translateAnimation.setStartOffset(150L);
        this.f18917w.addAnimation(translateAnimation);
        if (this.f18920z == null) {
            this.f18920z = new BasicOptionItemList.PopUpFadeInAnimationListener();
        }
        this.f18917w.setAnimationListener(this.f18920z);
        this.f18919y = new AnimationSet(false);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(250L);
        alphaAnimation2.setInterpolator(this.f19140G);
        this.f18919y.addAnimation(alphaAnimation2);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.f19142I);
        if (1 == this.f19137D.mo10816ca()) {
            translateAnimation2 = new TranslateAnimation(0.0f, this.f19143J, 0.0f, 0.0f);
        }
        translateAnimation2.setDuration(300L);
        translateAnimation2.setInterpolator(this.f19141H);
        this.f18919y.addAnimation(translateAnimation2);
        if (this.f18891A == null) {
            this.f18891A = new BasicOptionItemList.PopUpFadeOutAnimationListener();
        }
        this.f18919y.setAnimationListener(this.f18891A);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m20475j() {
        if (this.f19136C == null) {
            this.f19136C = new OrientationAnimation(1.0f, 0.0f);
            this.f19136C.m23903a(new PlatformImplementations.kt_3());
            this.f19136C.setDuration(300L);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo20286a(CameraMenuOption cameraMenuOption) {
        if (cameraMenuOption == null || this.f18912r == null || this.f18912r.contains(cameraMenuOption)) {
            return false;
        }
        cameraMenuOption.m21108a(this.f18913s);
        this.f18912r.add(cameraMenuOption);
        cameraMenuOption.mo21107a((ViewGroup) this);
        return true;
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
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

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo20295f() {
        clearAnimation();
        setVisibility(8);
        if (this.f18914t != null) {
            PopUpWindowManager.m20710c(this.f18914t.mo20300a());
        }
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    public void setOptionItemIcon(Bitmap bitmap) {
        RotateImageView rotateImageView = this.f19135B;
        if (rotateImageView != null) {
            rotateImageView.setImageBitmap(bitmap);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20280a(int OplusGLSurfaceView_13) {
        super.mo20280a(OplusGLSurfaceView_13);
        if (1 == this.f19137D.mo10816ca()) {
            if (InverseManager.INS.isInverseColor(this.f18911q.hashCode())) {
                setBackground(ContextCompat.m2248a(this.f18911q, R.drawable.bg_second_level_panel_black));
            } else if (OplusGLSurfaceView_13 == 0 || 1 == OplusGLSurfaceView_13) {
                setBackground(ContextCompat.m2248a(this.f18911q, R.drawable.bg_second_level_panel_white));
            } else {
                setBackground(ContextCompat.m2248a(this.f18911q, R.drawable.bg_second_level_panel_black));
            }
        }
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20285a(boolean z, boolean z2, int OplusGLSurfaceView_13) {
        mo20290b(m20474b(z), z2, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m20474b(boolean z) {
        if (Util.m24495t()) {
            if (2 == this.f19137D.mo10816ca()) {
                if ((5 == this.f19137D.mo10773bP() || 1 == this.f19137D.mo10773bP()) && !z) {
                    return false;
                }
            } else {
                if (3 != this.f19137D.mo10816ca()) {
                    return false;
                }
                if ((this.f19137D.mo10773bP() == 0 || 1 == this.f19137D.mo10773bP()) && !z) {
                    return false;
                }
            }
        } else if (5 == this.f19137D.mo10773bP() && !z) {
            return false;
        }
        return true;
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo20290b(boolean z, boolean z2, int OplusGLSurfaceView_13) {
        if (this.f18912r == null || this.f18912r.size() < 1) {
            return;
        }
        Iterator<CameraMenuOption> it = this.f18912r.iterator();
        while (it.hasNext()) {
            it.next().mo21117a(z, z2, OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    public void setSelectItemIndex(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 == this.f18905k) {
            return;
        }
        this.f18905k = OplusGLSurfaceView_13;
        if (this.f18912r == null || this.f18912r.size() <= 0) {
            return;
        }
        int i2 = 0;
        while (i2 < this.f18912r.size()) {
            CameraMenuOption cameraMenuOption = this.f18912r.get(i2);
            if (cameraMenuOption != null) {
                cameraMenuOption.mo21149d(i2 == this.f18905k);
            }
            i2++;
        }
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20281a(int OplusGLSurfaceView_13, boolean z) {
        if (this.f19136C == null) {
            m20475j();
        }
        Iterator<CameraMenuOption> it = this.f18912r.iterator();
        while (it.hasNext()) {
            it.next().mo21103a(OplusGLSurfaceView_13, z);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    public int getItemsMeasureWidth() {
        int iMo21073B = 0;
        if (this.f18912r == null || this.f18912r.size() <= 0) {
            return 0;
        }
        for (CameraMenuOption cameraMenuOption : this.f18912r) {
            if (cameraMenuOption != null) {
                iMo21073B += cameraMenuOption.mo21073B();
            }
        }
        RotateImageView rotateImageView = this.f19135B;
        return rotateImageView != null ? iMo21073B + rotateImageView.getMeasuredWidth() : iMo21073B;
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    public int getItemsMeasureHeight() {
        int iMo21074C;
        int OplusGLSurfaceView_13 = 0;
        if (this.f18912r == null || this.f18912r.size() <= 0) {
            return 0;
        }
        for (CameraMenuOption cameraMenuOption : this.f18912r) {
            if (cameraMenuOption != null && OplusGLSurfaceView_13 <= (iMo21074C = cameraMenuOption.mo21074C())) {
                OplusGLSurfaceView_13 = iMo21074C;
            }
        }
        RotateImageView rotateImageView = this.f19135B;
        return (rotateImageView == null || OplusGLSurfaceView_13 > rotateImageView.getMeasuredHeight()) ? OplusGLSurfaceView_13 : this.f19135B.getMeasuredHeight();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        try {
            super.onMeasure(OplusGLSurfaceView_13, i2);
            if (this.f19135B != null) {
                this.f19135B.measure(Util.getScreenWidth(), Util.m24193U());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) throws Resources.NotFoundException {
        if (1 == this.f19137D.mo10816ca() && this.f18912r != null && this.f18912r.size() > 0) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fold_tool_second_level_item_space_full);
            int i5 = 0;
            for (int i6 = 0; i6 <= this.f18912r.size() - 1; i6++) {
                CameraMenuOption cameraMenuOption = this.f18912r.get(i6);
                if (cameraMenuOption != null) {
                    int iMo21073B = cameraMenuOption.mo21073B();
                    cameraMenuOption.m21102a(0, i5, iMo21073B, cameraMenuOption.mo21074C() + i5);
                    i5 += iMo21073B + dimensionPixelSize;
                }
            }
            return;
        }
        if (4 == this.f19137D.mo10816ca() && this.f18912r != null && this.f18912r.size() > 0 && this.f19138E != null) {
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.rack_mode_tool_second_level_item_space);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.rack_mode_tool_second_level_item_textview_left);
            int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.rack_mode_tool_second_level_item_top);
            int i7 = (i3 - OplusGLSurfaceView_13) - dimensionPixelSize3;
            SingleTextItemView c3265j = this.f19138E;
            c3265j.layout(dimensionPixelSize3, dimensionPixelSize4, c3265j.getMeasuredWidth() + dimensionPixelSize3, this.f19138E.getMeasuredHeight() + dimensionPixelSize4);
            for (int size = this.f18912r.size() - 1; size >= 0; size--) {
                CameraMenuOption cameraMenuOption2 = this.f18912r.get(size);
                if (cameraMenuOption2 != null) {
                    int iMo21073B2 = cameraMenuOption2.mo21073B();
                    cameraMenuOption2.m21102a(i7 - iMo21073B2, dimensionPixelSize4, i7, cameraMenuOption2.mo21074C() + dimensionPixelSize4);
                    i7 -= iMo21073B2 + dimensionPixelSize2;
                }
            }
            return;
        }
        if (this.f18912r == null || this.f18912r.size() <= 0 || this.f19138E == null) {
            return;
        }
        int i8 = i4 - i2;
        int i9 = i3 - OplusGLSurfaceView_13;
        int dimensionPixelSize5 = Util.m24346ai() ? this.f18911q.getResources().getDimensionPixelSize(R.dimen.ear_screen_menu_item_offset) : 0;
        int dimensionPixelSize6 = getResources().getDimensionPixelSize(R.dimen.menu_item_second_space);
        SingleTextItemView c3265j2 = this.f19138E;
        c3265j2.layout(0, ((i8 - c3265j2.getMeasuredHeight()) / 2) + dimensionPixelSize5, this.f19138E.getMeasuredWidth() + 0, ((this.f19138E.getMeasuredHeight() + i8) / 2) + dimensionPixelSize5);
        for (int size2 = this.f18912r.size() - 1; size2 >= 0; size2--) {
            CameraMenuOption cameraMenuOption3 = this.f18912r.get(size2);
            if (cameraMenuOption3 != null) {
                int iMo21073B3 = cameraMenuOption3.mo21073B();
                int iMo21074C = cameraMenuOption3.mo21074C();
                int i10 = ((i8 - iMo21074C) / 2) + dimensionPixelSize5;
                cameraMenuOption3.m21102a(i9 - iMo21073B3, i10, i9, iMo21074C + i10);
                i9 -= iMo21073B3 + dimensionPixelSize6;
            }
        }
    }

    @Override // com.oplus.camera.p172ui.menu.BasicOptionItemList
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo20297h() {
        RotateImageView rotateImageView = this.f19135B;
        if (rotateImageView != null) {
            removeView(rotateImageView);
            this.f19135B = null;
        }
        this.f19136C = null;
        super.mo20297h();
    }

    /* compiled from: OptionItemIconTextList.java */
    /* renamed from: com.oplus.camera.ui.menu.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements OrientationAnimation.PlatformImplementations.kt_3 {
        private PlatformImplementations.kt_3() {
        }

        @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18006a(float COUIBaseListPopupWindow_12) {
            if (OptionItemIconTextList.this.f19135B != null) {
                OptionItemIconTextList.this.f19135B.setAlpha(COUIBaseListPopupWindow_12);
            }
            if (OptionItemIconTextList.this.f18912r == null || OptionItemIconTextList.this.f18912r.size() <= 0) {
                return;
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < OptionItemIconTextList.this.f18912r.size(); OplusGLSurfaceView_13++) {
                CameraMenuOption cameraMenuOption = OptionItemIconTextList.this.f18912r.get(OplusGLSurfaceView_13);
                if (cameraMenuOption != null) {
                    cameraMenuOption.mo21098a(COUIBaseListPopupWindow_12);
                }
            }
        }

        @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18007a(int OplusGLSurfaceView_13) {
            if (OptionItemIconTextList.this.f19135B != null) {
                OptionItemIconTextList.this.f19135B.m18348a(OplusGLSurfaceView_13, false);
            }
            if (OptionItemIconTextList.this.f18912r != null && OptionItemIconTextList.this.f18912r.size() > 0) {
                for (int i2 = 0; i2 < OptionItemIconTextList.this.f18912r.size(); i2++) {
                    CameraMenuOption cameraMenuOption = OptionItemIconTextList.this.f18912r.get(i2);
                    if (cameraMenuOption != null) {
                        cameraMenuOption.mo21103a(OplusGLSurfaceView_13, false);
                    }
                }
            }
            OptionItemIconTextList c3242d = OptionItemIconTextList.this;
            c3242d.f18906l = OplusGLSurfaceView_13;
            c3242d.requestLayout();
        }

        @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo18008a() {
            return OptionItemIconTextList.this.isShown();
        }
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        if (z) {
            setBackground(ContextCompat.m2248a(this.f18911q, R.drawable.bg_second_level_panel_black));
        } else {
            mo20280a(this.f18908n);
        }
    }
}
