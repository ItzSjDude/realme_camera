package com.oplus.camera.p172ui.menu.setting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseImageView;
import com.oplus.camera.p172ui.menu.CameraMenuOptionInfo;
import com.oplus.camera.p172ui.menu.PreferenceMenuOptionGroup;
import com.oplus.camera.p172ui.menu.setting.down.DrawerLayout;
import com.oplus.camera.util.Util;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class CameraDrawerSettingMenuPanel extends CameraSettingMenuPanel implements DrawerLayout.InterfaceC3324c {

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f19896h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f19897i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f19898j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f19899k;

    /* renamed from: OplusGLSurfaceView_14 */
    private InverseImageView f19900l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f19901m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f19902n;

    /* renamed from: o */
    private int f19903o;

    /* renamed from: p */
    private int f19904p;

    public CameraDrawerSettingMenuPanel(Context context) {
        this(context, null);
    }

    public CameraDrawerSettingMenuPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19896h = 0;
        this.f19897i = 0;
        this.f19898j = false;
        this.f19899k = false;
        this.f19900l = null;
        this.f19901m = 0.0f;
        this.f19902n = 0.0f;
        this.f19903o = 0;
        this.f19904p = 0;
        m21047p();
    }

    /* renamed from: p */
    private void m21047p() {
        this.f19896h = getResources().getDimensionPixelSize(R.dimen.submenu_threshold_level_one);
        this.f19897i = getResources().getDimensionPixelSize(R.dimen.submenu_threshold_level_two);
        this.f19903o = getResources().getDimensionPixelSize(R.dimen.submenu_layout_offset);
        this.f19902n = getResources().getDimension(R.dimen.drawer_layout_space);
        setClipChildren(false);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21051a(ComboPreferences comboPreferences, CameraUIListener cameraUIListener, PreferenceMenuOptionGroup c3263h, int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        this.f19963e = comboPreferences;
        m21266n();
        this.f19961c = new CopyOnWriteArrayList<>();
        this.f19962d = cameraUIListener;
        this.f19965g = OplusGLSurfaceView_13;
        setMotionEventSplittingEnabled(false);
        List<String> menuPanelOptionList = CameraConfig.getMenuPanelOptionList();
        if (menuPanelOptionList != null && menuPanelOptionList.size() > 0) {
            for (String str : menuPanelOptionList) {
                CameraMenuOptionInfo c3240bM20718a = c3263h.m20718a(CameraEntry.m13299b(str, this.f19962d.mo10786bc().m13317J()));
                if (c3240bM20718a != null) {
                    CameraMenuOptionDrawerItem viewOnClickListenerC3327g = new CameraMenuOptionDrawerItem(this.f19963e, this.f19964f, c3240bM20718a, this, this.f19962d, this.f19965g, CameraConfig.getOptionKeyDefaultValue(str, getCameraId()));
                    InverseManager.INS.registerInverse(this.f19964f, viewOnClickListenerC3327g);
                    viewOnClickListenerC3327g.mo21132b();
                    viewOnClickListenerC3327g.m21099a(8);
                    this.f19961c.add(viewOnClickListenerC3327g);
                    viewOnClickListenerC3327g.mo21107a((ViewGroup) this);
                    viewOnClickListenerC3327g.mo21081J().setContentDescription(c3240bM20718a.getOptionTitle());
                    if (CameraUIInterface.KEY_SETTING.equals(c3240bM20718a.getOptionKey())) {
                        m21048q();
                    }
                }
            }
        }
        this.f19898j = true;
    }

    /* renamed from: q */
    private void m21048q() {
        this.f19900l = new InverseImageView(getContext());
        this.f19900l.setId(R.id_renamed.drawer_setting_divider);
        InverseManager.INS.registerInverse(this.f19964f, this.f19900l);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.drawer_line_width), getContext().getResources().getDimensionPixelSize(R.dimen.drawer_line_height));
        layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.drawer_line_margin_top);
        this.f19900l.setImageResource(R.drawable.drawer_line_color_selector);
        this.f19900l.setLayoutParams(layoutParams);
        addView(this.f19900l);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21050a() {
        if (this.f19961c == null || this.f19961c.size() <= 0) {
            return;
        }
        Iterator<CameraMenuOption> it = this.f19961c.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && !next.m21166i()) {
                next.mo21115a(false, false);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel, android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        CameraMenuOption cameraMenuOption;
        InverseImageView inverseImageView;
        if (this.f19961c == null || !this.f19898j || this.f19961c.size() <= 0 || !this.f19960b) {
            return;
        }
        int i5 = i3 - OplusGLSurfaceView_13;
        float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.drawer_layout_space_top) + 0.0f;
        for (int i6 = 0; i6 < this.f19961c.size() && (cameraMenuOption = this.f19961c.get(i6)) != null; i6++) {
            if (8 != cameraMenuOption.m21078G()) {
                int iMo21074C = cameraMenuOption.mo21074C();
                if (CameraUIInterface.KEY_SETTING.equals(cameraMenuOption.mo20300a()) && (inverseImageView = this.f19900l) != null) {
                    float COUIBaseListPopupWindow_12 = dimensionPixelSize + ((LinearLayout.LayoutParams) inverseImageView.getLayoutParams()).topMargin;
                    InverseImageView inverseImageView2 = this.f19900l;
                    int i7 = (int) COUIBaseListPopupWindow_12;
                    inverseImageView2.layout((i5 - inverseImageView2.getMeasuredWidth()) / 2, i7, (this.f19900l.getMeasuredWidth() + i5) / 2, this.f19900l.getMeasuredHeight() + i7);
                    dimensionPixelSize = COUIBaseListPopupWindow_12 + this.f19900l.getMeasuredHeight() + ((LinearLayout.LayoutParams) this.f19900l.getLayoutParams()).bottomMargin;
                }
                float f2 = iMo21074C;
                cameraMenuOption.m21102a(0, (int) dimensionPixelSize, i5, (int) (dimensionPixelSize + f2));
                dimensionPixelSize += f2 + this.f19902n;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        this.f19904p = 0;
        if (this.f19961c != null && this.f19961c.size() > 0) {
            size = 0;
            for (int i3 = 0; i3 < this.f19961c.size(); i3++) {
                CameraMenuOption cameraMenuOption = this.f19961c.get(i3);
                if (cameraMenuOption != null && 8 != cameraMenuOption.m21078G()) {
                    size = (int) (size + cameraMenuOption.mo21074C() + this.f19902n);
                    this.f19904p++;
                }
            }
            InverseImageView inverseImageView = this.f19900l;
            if (inverseImageView != null) {
                measureChild(inverseImageView, OplusGLSurfaceView_13, i2);
                size = size + this.f19900l.getMeasuredHeight() + ((LinearLayout.LayoutParams) this.f19900l.getLayoutParams()).topMargin + ((LinearLayout.LayoutParams) this.f19900l.getLayoutParams()).bottomMargin;
            }
            if (size != 0) {
                size = (int) (((int) (size + getResources().getDimension(R.dimen.drawer_layout_space_top))) - this.f19902n);
            }
            this.f19904p--;
        }
        super.onMeasure(OplusGLSurfaceView_13, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel, com.oplus.camera.p172ui.menu.setting.CameraMenuOptionListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21052a(String str, String str2) throws Resources.NotFoundException {
        if (CameraUIInterface.KEY_VIDEO_SIZE.equals(str)) {
            Iterator<CameraMenuOption> it = this.f19961c.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (CameraUIInterface.KEY_VIDEO_FPS.equals(next.mo20300a())) {
                    ((CameraMenuOptionDrawerItem) next).m21440n(str2);
                }
            }
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel
    public void setPendingDrawerGuideAni(final Runnable runnable) {
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.oplus.camera.ui.menu.setting.CameraDrawerSettingMenuPanel.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (!CameraDrawerSettingMenuPanel.this.f19898j || i3 - OplusGLSurfaceView_13 <= 0 || i4 - i2 <= 0) {
                    return;
                }
                runnable.run();
                CameraDrawerSettingMenuPanel.this.removeOnLayoutChangeListener(this);
            }
        });
    }

    @Override // com.oplus.camera.p172ui.menu.setting.down.DrawerLayout.InterfaceC3324c
    public void setOffset(float COUIBaseListPopupWindow_12) throws Resources.NotFoundException {
        int OplusGLSurfaceView_13;
        InverseImageView inverseImageView;
        this.f19901m = COUIBaseListPopupWindow_12;
        if (this.f19961c == null || !this.f19898j || this.f19961c.size() <= 0) {
            return;
        }
        float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.drawer_layout_space_top) + 0.0f;
        int i2 = (int) (0 + dimensionPixelSize);
        int i3 = 1;
        float f2 = dimensionPixelSize - this.f19903o;
        for (int i4 = 0; i4 < this.f19961c.size(); i4++) {
            CameraMenuOption cameraMenuOption = this.f19961c.get(i4);
            if (cameraMenuOption == null) {
                return;
            }
            if (8 != cameraMenuOption.m21078G()) {
                int iMo21074C = cameraMenuOption.mo21074C();
                if (CameraUIInterface.KEY_SETTING.equals(cameraMenuOption.mo20300a()) && (inverseImageView = this.f19900l) != null) {
                    int i5 = i2 + ((LinearLayout.LayoutParams) this.f19900l.getLayoutParams()).topMargin;
                    this.f19900l.setAlpha(Util.m24201a(COUIBaseListPopupWindow_12, 0.0f, 1.0f));
                    i2 = i5 + ((LinearLayout.LayoutParams) this.f19900l.getLayoutParams()).bottomMargin;
                    f2 = f2 + (((LinearLayout.LayoutParams) inverseImageView.getLayoutParams()).topMargin * COUIBaseListPopupWindow_12) + (((LinearLayout.LayoutParams) this.f19900l.getLayoutParams()).bottomMargin * COUIBaseListPopupWindow_12);
                    this.f19900l.scrollTo(0, (int) ((i2 - f2) - (this.f19903o * COUIBaseListPopupWindow_12)));
                }
                if (i4 == this.f19961c.size() - 1 || !this.f19899k) {
                    cameraMenuOption.mo21098a(Util.m24201a(COUIBaseListPopupWindow_12, 0.0f, 1.0f));
                } else {
                    if (3 == this.f19904p && 2 == i3) {
                        OplusGLSurfaceView_13 = this.f19897i;
                    } else {
                        OplusGLSurfaceView_13 = this.f19896h;
                    }
                    float f3 = ((this.f19903o + i2) - r0) - OplusGLSurfaceView_13;
                    cameraMenuOption.mo21098a((f3 - cameraMenuOption.mo21081J().getScrollY()) / f3);
                }
                cameraMenuOption.mo21081J().scrollTo(0, (int) ((i2 - f2) - (this.f19903o * COUIBaseListPopupWindow_12)));
                if (Float.compare(1.0f, COUIBaseListPopupWindow_12) == 0 && (cameraMenuOption.mo21081J() instanceof ViewGroup) && ((ViewGroup) cameraMenuOption.mo21081J()).getChildCount() > 0 && Float.compare(((ViewGroup) cameraMenuOption.mo21081J()).getChildAt(0).getAlpha(), 1.0f) < 0) {
                    CameraLog.m12959b("CameraDrawerSettingMenuPanel", "setOffset, reSetOffset: " + this.f19901m);
                    cameraMenuOption.mo21081J().post(new Runnable() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$CameraDrawerSettingMenuPanel$CS8_kezgfoN5lpFJV38UVGY2s6A
                        @Override // java.lang.Runnable
                        public final void run() throws Resources.NotFoundException {
                            this.COUIBaseListPopupWindow_12$0.m21049r();
                        }
                    });
                }
                float f4 = this.f19902n;
                f2 += (iMo21074C + f4) * COUIBaseListPopupWindow_12;
                i2 = (int) (i2 + iMo21074C + f4);
                i3++;
            }
        }
        this.f19899k = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m21049r() throws Resources.NotFoundException {
        if (Float.compare(this.f19901m, 1.0f) == 0) {
            setOffset(1.0f);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (1.0f != this.f19901m) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
