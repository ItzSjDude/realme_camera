package com.oplus.camera.p172ui.menu.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.p027a.ContextCompat;
import androidx.core.p034f.TextUtilsCompat;
import com.oplus.camera.ZoomManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.p172ui.inverse.InverseImageView;
import com.oplus.camera.p172ui.menu.CameraMenuOptionInfo;
import com.oplus.camera.p172ui.menu.OptionItemInfo;
import com.oplus.camera.p172ui.menu.PopUpWindowManager;
import com.oplus.camera.p172ui.menu.OplusTextView;
import com.oplus.camera.p172ui.menu.RippleLayout;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: CameraMenuOptionDrawerItem.java */
/* renamed from: com.oplus.camera.ui.menu.setting.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class CameraMenuOptionDrawerItem extends CameraMenuOption implements View.OnClickListener, View.OnTouchListener, InverseAble {

    /* renamed from: A */
    private List<OptionItemInfo> f20131A;

    /* renamed from: r */
    private String f20132r;

    /* renamed from: s */
    private PopupWindow f20133s;

    /* renamed from: t */
    private String f20134t;

    /* renamed from: u */
    private int f20135u;

    /* renamed from: v */
    private View f20136v;

    /* renamed from: w */
    private OplusTextView f20137w;

    /* renamed from: x */
    private Context f20138x;

    /* renamed from: y */
    private List<View> f20139y;

    /* renamed from: z */
    private boolean f20140z;

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21114a(boolean z, int OplusGLSurfaceView_13, int i2) {
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo21149d(boolean z) {
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: z */
    public int mo21188z() {
        return 0;
    }

    public CameraMenuOptionDrawerItem(ComboPreferences comboPreferences, Context context, CameraMenuOptionInfo c3240b, CameraMenuOptionListener interfaceC3329i, CameraUIListener cameraUIListener, int OplusGLSurfaceView_13, String str) {
        super(comboPreferences, context, c3240b, interfaceC3329i, cameraUIListener, OplusGLSurfaceView_13, str);
        this.f20132r = null;
        this.f20133s = null;
        this.f20134t = null;
        this.f20135u = -1;
        this.f20136v = null;
        this.f20139y = new ArrayList();
        this.f20140z = false;
        this.f20131A = new ArrayList();
        this.f20138x = context;
        m21436aj();
        this.f19921d = true;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo21132b() throws Resources.NotFoundException {
        int OplusGLSurfaceView_13;
        CameraLog.m12959b("CameraMenuOptionDrawerItem", "initCameraMenuOptionView");
        this.f20139y.clear();
        this.f20136v = View.inflate(this.f20138x, R.layout.menu_option_image, null);
        this.f20136v.setOnClickListener(this);
        this.f20137w = (OplusTextView) this.f20136v.findViewById(R.id_renamed.tv_title);
        this.f20137w.setMatchParent(true);
        this.f20137w.setText(this.f20132r);
        this.f20137w.setOnClickListener(this);
        InverseManager.INS.registerInverse(this.f20136v.getContext(), this.f20137w);
        if (m21086O() == 0) {
            int iM21432a = 0;
            for (int i2 = 0; i2 < m21095X(); i2++) {
                iM21432a = m21432a(m21162h((m21095X() - i2) - 1), i2, false);
            }
            OplusGLSurfaceView_13 = iM21432a;
        } else if (1 == m21086O()) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < m21095X()) {
                OplusTextView oplusTextView = new OplusTextView(this.f20138x);
                oplusTextView.setTextSize(0, this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_text_size));
                int dimensionPixelSize = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_text_width);
                int dimensionPixelSize2 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_text_height);
                int dimensionPixelSize3 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_text_space);
                int dimensionPixelSize4 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_menu_text_last_space);
                int dimensionPixelSize5 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_text_padding);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
                layoutParams.gravity = 8388629;
                int i5 = (i3 * dimensionPixelSize) + (dimensionPixelSize3 * i3) + dimensionPixelSize4;
                layoutParams.setMarginEnd(i5);
                oplusTextView.setGravity(17);
                oplusTextView.setMaxWidth(this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_text_max_width));
                oplusTextView.setSingleLine(true);
                oplusTextView.setEllipsize(TextUtils.TruncateAt.END);
                oplusTextView.setMarqueeRepeatLimit(6);
                oplusTextView.setPadding(dimensionPixelSize5, 0, dimensionPixelSize5, 0);
                oplusTextView.setText(i3 == 0 ? R.string.camera_slogan_assignment_on : R.string.camera_slogan_assignment_off);
                oplusTextView.setTextColor(this.f20138x.getColorStateList(R.color.drawer_item_text_color_selector));
                InverseManager.INS.registerInverse(this.f20138x, oplusTextView);
                OptionItemInfo c3243eH = m21162h((m21095X() - i3) - 1);
                if (c3243eH != null) {
                    oplusTextView.setText(c3243eH.m20486e());
                }
                ((FrameLayout) this.f20136v).addView(oplusTextView, layoutParams);
                this.f20139y.add(oplusTextView);
                oplusTextView.setOnClickListener(this);
                i3++;
                i4 = dimensionPixelSize + i5;
            }
            OplusGLSurfaceView_13 = i4;
        } else if (2 == m21086O()) {
            FrameLayout frameLayout = (FrameLayout) this.f20136v;
            InverseImageView inverseImageView = new InverseImageView(this.f20138x);
            frameLayout.setBackgroundResource(R.drawable.bg_camera_setting_item);
            int dimensionPixelSize6 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.more_item_icon_w_h);
            int dimensionPixelSize7 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.more_item_icon_w_h);
            int dimensionPixelSize8 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_set_icon_last_space);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimensionPixelSize6, dimensionPixelSize7);
            layoutParams2.gravity = 8388629;
            layoutParams2.setMarginEnd(dimensionPixelSize8);
            inverseImageView.setImageResource(R.drawable.enter_camera_setting_selector);
            inverseImageView.setContentDescription(this.f20132r);
            if (1 == TextUtilsCompat.m2525a(Locale.getDefault())) {
                inverseImageView.setRotation(180.0f);
            }
            if (frameLayout instanceof RippleLayout) {
                ((RippleLayout) frameLayout).setNeedForbidEvent(true);
            }
            OplusGLSurfaceView_13 = dimensionPixelSize8 + dimensionPixelSize6;
            frameLayout.addView(inverseImageView, layoutParams2);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f20137w.getLayoutParams();
            layoutParams3.topMargin = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_line_margin_bottom) + this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_key_layout_margin_top);
            this.f20137w.setLayoutParams(layoutParams3);
            InverseManager.INS.registerInverse(this.f20138x, inverseImageView);
            inverseImageView.setOnClickListener(this);
        } else {
            OplusGLSurfaceView_13 = 0;
        }
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.f20137w.getLayoutParams();
        layoutParams4.width = ((Util.getScreenWidth() - OplusGLSurfaceView_13) - layoutParams4.leftMargin) - layoutParams4.rightMargin;
        this.f20137w.setLayoutParams(layoutParams4);
        super.mo21132b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m21432a(OptionItemInfo c3243e, int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        RotateImageView rotateImageView = new RotateImageView(this.f20138x);
        int dimensionPixelSize = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_width);
        int dimensionPixelSize2 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_height);
        int dimensionPixelSize3 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_menu_icon_space);
        int dimensionPixelSize4 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_last_space);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        layoutParams.gravity = 8388629;
        int i2 = (OplusGLSurfaceView_13 * dimensionPixelSize) + (dimensionPixelSize3 * OplusGLSurfaceView_13) + dimensionPixelSize4;
        layoutParams.setMarginEnd(i2);
        int dimensionPixelSize5 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_padding_left_right);
        int dimensionPixelSize6 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_padding_top_bottom);
        rotateImageView.setPadding(dimensionPixelSize5, dimensionPixelSize6, dimensionPixelSize5, dimensionPixelSize6);
        rotateImageView.setBackground(ContextCompat.m2248a(this.f20138x, R.drawable.drawer_item_iv_background).mutate());
        if (c3243e != null) {
            rotateImageView.setImageDrawable(c3243e.m20476a());
            rotateImageView.setContentDescription(c3243e.m20485d());
            rotateImageView.setTag(c3243e.m20483c());
        }
        ((FrameLayout) this.f20136v).addView(rotateImageView, layoutParams);
        if (z) {
            this.f20139y.add(OplusGLSurfaceView_13, rotateImageView);
        } else {
            this.f20139y.add(rotateImageView);
        }
        rotateImageView.setOnClickListener(this);
        rotateImageView.setOnTouchListener(this);
        return i2 + dimensionPixelSize;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21109a(String str, OptionItemInfo c3243e) {
        int size = this.f20139y.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            if (this.f20139y.get(OplusGLSurfaceView_13).getTag().equals(c3243e.m20483c())) {
                if (DcsMsgData.FULL.equals(c3243e.m20483c()) && Util.m24498u()) {
                    ((RotateImageView) this.f20139y.get(OplusGLSurfaceView_13)).setImageDrawable(this.f20138x.getDrawable(R.drawable.photo_ratio_14_15_selector));
                } else {
                    ((RotateImageView) this.f20139y.get(OplusGLSurfaceView_13)).setImageDrawable(c3243e.m20476a());
                }
            }
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: u */
    protected void mo21183u() {
        super.mo21183u();
        if (this.f19929l != null) {
            this.f19929l.mo21241c(mo20300a());
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21115a(boolean z, boolean z2) throws Resources.NotFoundException {
        if (!this.f19931n.mo10720aY()) {
            super.mo21115a(z, z2);
        }
        if (!this.f19922e && mo21181s()) {
            if (mo21081J() != null) {
                mo21081J().setClickable(z);
                if (mo21081J() instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) mo21081J();
                    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < viewGroup.getChildCount(); OplusGLSurfaceView_13++) {
                        viewGroup.getChildAt(OplusGLSurfaceView_13).setClickable(z);
                    }
                    if (z && CameraUIInterface.KEY_VIDEO_FPS.equals(mo20300a())) {
                        m21440n(null);
                    }
                }
            }
            this.f19934q = z;
            if (this.f19919b != null) {
                this.f19919b.m20284a(z, z2);
                return;
            }
            return;
        }
        if (mo21081J() != null) {
            mo21081J().setClickable(false);
            if (mo21081J() instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) mo21081J();
                for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                    viewGroup2.getChildAt(i2).setClickable(false);
                }
            }
        }
        this.f19934q = false;
        if (this.f19919b != null) {
            this.f19919b.m20284a(false, true);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21111a(String str, String str2, int OplusGLSurfaceView_13, int i2, int i3) {
        if (str2 == null || str2.isEmpty() || this.f20133s == null) {
            return;
        }
        mo21185w();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: w */
    public void mo21185w() {
        PopupWindow popupWindow = this.f20133s;
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                this.f20133s.dismiss();
            }
            this.f20133s = null;
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21105a(View view) {
        this.f20136v = view;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: J */
    public View mo21081J() {
        return this.f20136v;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21098a(float COUIBaseListPopupWindow_12) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < ((ViewGroup) this.f20136v).getChildCount(); OplusGLSurfaceView_13++) {
            ((ViewGroup) this.f20136v).getChildAt(OplusGLSurfaceView_13).setAlpha(COUIBaseListPopupWindow_12);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: q */
    public void mo21179q() {
        int color;
        int color2;
        CameraLog.m12959b("CameraMenuOptionDrawerItem", "updateMenuOptionView, index: " + m21128ad() + ", title: " + m21085N());
        if (m21095X() > 0) {
            if (m21089R() != null && m21125aa() && !TextUtils.isEmpty(m21093V()) && CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(mo20300a())) {
                if (TextUtils.isEmpty(CameraConfig.getConfigStringValue(ConfigDataBase.KEY_SUPER_RESOLUTION_PICTURE_SIZE))) {
                    int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE_NAME, this.f19931n.mo10653G()) / 100;
                    double dM24199a = configIntValue > 0 ? configIntValue : Util.m24199a(this.f20138x, CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.f19931n.mo10653G()));
                    if (Float.compare((float) dM24199a, 0.0f) != 0) {
                        this.f20134t = this.f20138x.getString(R.string.camera_picture_size_standard_high_hint, Double.valueOf(dM24199a));
                        this.f20135u = (int) dM24199a;
                    }
                } else {
                    this.f20134t = this.f20138x.getString(R.string.camera_setting_menu_high_resolution_item);
                }
                this.f20137w.setText(this.f20134t);
            }
            if (m21086O() == 0) {
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < m21095X(); OplusGLSurfaceView_13++) {
                    int iX = (m21095X() - OplusGLSurfaceView_13) - 1;
                    if (iX >= this.f20139y.size()) {
                        return;
                    }
                    RotateImageView rotateImageView = (RotateImageView) this.f20139y.get(iX);
                    if (rotateImageView.getDrawable() == null) {
                        return;
                    }
                    int i2 = this.f20135u;
                    if (-1 != i2) {
                        rotateImageView.setHighResolutionType(i2);
                    }
                    if (OplusGLSurfaceView_13 == m21128ad()) {
                        if (this.f20140z) {
                            color = this.f20138x.getColor(R.color.color_white_with_full_percent_transparency);
                            color2 = this.f20138x.getColor(R.color.color_black_with_85_percent_transparency);
                        } else {
                            color = this.f20138x.getColor(R.color.color_black_with_85_percent_transparency);
                            color2 = Util.m24164A(this.f20138x);
                        }
                    } else if (this.f20140z) {
                        color = this.f20138x.getColor(R.color.color_black_with_full_percent_transparency);
                        color2 = this.f20138x.getColor(R.color.color_black_with_15_percent_transparency);
                    } else {
                        color = this.f20138x.getColor(R.color.color_white_with_full_percent_transparency);
                        color2 = this.f20138x.getColor(R.color.color_white_with_15_percent_transparency);
                    }
                    OptionItemInfo c3243eH = m21162h(OplusGLSurfaceView_13);
                    if (c3243eH != null) {
                        if (c3243eH.m20487f()) {
                            rotateImageView.setEnabled(true);
                        } else {
                            rotateImageView.m23921a(false, false);
                            color = this.f20138x.getColor(R.color.color_white_with_30_percent_transparency);
                        }
                    }
                    rotateImageView.m18347a(color, color2);
                }
            } else if (1 == m21086O()) {
                for (int i3 = 0; i3 < this.f20139y.size(); i3++) {
                    int iX2 = (m21095X() - i3) - 1;
                    OptionItemInfo c3243eH2 = m21162h(iX2);
                    if (c3243eH2 == null) {
                        return;
                    }
                    TextView textView = (TextView) this.f20139y.get(i3);
                    textView.setEnabled(c3243eH2.m20487f());
                    if (iX2 == m21128ad() && !m21434ah()) {
                        textView.setSelected(true);
                        textView.setBackground(this.f20138x.getDrawable(CameraUIInterface.KEY_VIDEO_SIZE.equals(mo20300a()) ? R.drawable.drawer_item_round_bg_selected : R.drawable.drawer_item_tv_background));
                    } else {
                        boolean zM20487f = c3243eH2.m20487f();
                        int i4 = R.drawable.drawer_item_round_bg_unselected;
                        if (!zM20487f) {
                            CameraLog.m12959b("CameraMenuOptionDrawerItem", "updateMenuOptionView, key: " + mo20300a() + ", disabled.");
                            textView.setSelected(false);
                            Context context = this.f20138x;
                            if (!CameraUIInterface.KEY_VIDEO_SIZE.equals(mo20300a())) {
                                i4 = R.drawable.drawer_item_tv_background_grey;
                            }
                            textView.setBackground(context.getDrawable(i4));
                        } else {
                            textView.setSelected(false);
                            Context context2 = this.f20138x;
                            if (!CameraUIInterface.KEY_VIDEO_SIZE.equals(mo20300a())) {
                                i4 = R.drawable.drawer_item_tv_background_grey;
                            }
                            textView.setBackground(context2.getDrawable(i4));
                        }
                    }
                }
            }
        }
        View view = this.f20136v;
        if (view != null) {
            view.invalidate();
            View view2 = this.f20136v;
            StringBuilder sb = new StringBuilder();
            sb.append(mo20300a().equals(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION) ? this.f20134t : this.f20132r);
            sb.append(m21092U());
            view2.setContentDescription(sb.toString());
        }
        if (m21126ab()) {
            mo21149d(m21128ad() != 0);
        }
    }

    /* renamed from: ah */
    private boolean m21434ah() {
        if (this.f19918a == null || !CameraUIInterface.KEY_VIDEO_FPS.equals(mo20300a())) {
            return false;
        }
        return "on".equals(this.f19918a.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off")) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_EIS_FPS_SETTING_SUPPORT);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo21124a(List<String> list, String str) throws Resources.NotFoundException {
        OptionItemInfo c3243e = null;
        if (CameraUIInterface.KEY_VIDEO_SIZE.equals(mo20300a())) {
            boolean zM24392b = Util.m24392b("video_size_4kuhd", this.f19931n.mo10653G());
            Iterator<OptionItemInfo> it = this.f19933p.getOptionItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                OptionItemInfo next = it.next();
                if ("video_size_4kuhd".equals(next.m20483c())) {
                    CameraLog.m12959b("CameraMenuOptionDrawerItem", "updateSupportedItems, key: " + mo20300a() + ", enable 4k: " + zM24392b);
                    next.m20480a(zM24392b);
                    c3243e = next;
                    break;
                }
            }
            if (!zM24392b) {
                mo21168j("video_size_4kuhd");
            } else if (c3243e != null && !m21096Y().contains(c3243e)) {
                m21439a(c3243e);
            }
            return true;
        }
        if (CameraUIInterface.KEY_VIDEO_FPS.equals(mo20300a())) {
            m21440n(null);
            return true;
        }
        return super.mo21124a(list, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21439a(OptionItemInfo c3243e) throws Resources.NotFoundException {
        int iM21170k = super.m21170k(c3243e.m20483c());
        if (mo21188z() == 0) {
            m21432a(c3243e, (m21095X() - iM21170k) - 1, true);
            m21435ai();
        }
    }

    /* renamed from: o */
    private OptionItemInfo m21437o(String str) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f20131A.size(); OplusGLSurfaceView_13++) {
            OptionItemInfo c3243e = this.f20131A.get(OplusGLSurfaceView_13);
            if (c3243e != null && TextUtils.equals(c3243e.m20483c(), str)) {
                return c3243e;
            }
        }
        return null;
    }

    /* renamed from: p */
    private OptionItemInfo m21438p(String str) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < m21095X(); OplusGLSurfaceView_13++) {
            OptionItemInfo c3243eH = m21162h(OplusGLSurfaceView_13);
            if (c3243eH != null && TextUtils.equals(c3243eH.m20483c(), str)) {
                return c3243eH;
            }
        }
        return null;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: OplusGLSurfaceView_15 */
    public int mo21168j(String str) throws Resources.NotFoundException {
        String strM20485d;
        RotateImageView rotateImageView;
        if (!this.f19931n.mo10844g(mo20300a())) {
            return -1;
        }
        int iMo21168j = super.mo21168j(str);
        if (iMo21168j < 0) {
            CameraLog.m12966e("CameraMenuOptionDrawerItem", "removeOptionItem, itemValue: " + str + ", not found in current option items.");
            return iMo21168j;
        }
        if (mo21188z() == 0) {
            Iterator<OptionItemInfo> it = this.f19933p.getOptionItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    strM20485d = null;
                    break;
                }
                OptionItemInfo next = it.next();
                if (str.equals(next.m20483c())) {
                    strM20485d = next.m20485d();
                    break;
                }
            }
            if (strM20485d != null) {
                Iterator<View> it2 = this.f20139y.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        rotateImageView = null;
                        break;
                    }
                    rotateImageView = (RotateImageView) it2.next();
                    if (strM20485d.equals(rotateImageView.getContentDescription().toString())) {
                        ((FrameLayout) this.f20136v).removeView(rotateImageView);
                        break;
                    }
                }
                if (rotateImageView != null) {
                    this.f20139y.remove(rotateImageView);
                }
            }
            m21435ai();
        }
        return iMo21168j;
    }

    /* renamed from: ai */
    private void m21435ai() throws Resources.NotFoundException {
        int dimensionPixelSize = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_width);
        int dimensionPixelSize2 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_height);
        int dimensionPixelSize3 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_menu_icon_space);
        int dimensionPixelSize4 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_last_space);
        for (View view : this.f20139y) {
            int iIndexOf = this.f20139y.indexOf(view);
            if (-1 != iIndexOf) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
                layoutParams.gravity = 8388629;
                layoutParams.setMarginEnd((iIndexOf * dimensionPixelSize) + (iIndexOf * dimensionPixelSize3) + dimensionPixelSize4);
                int dimensionPixelSize5 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_padding_left_right);
                int dimensionPixelSize6 = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_padding_top_bottom);
                view.setPadding(dimensionPixelSize5, dimensionPixelSize6, dimensionPixelSize5, dimensionPixelSize6);
                view.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m21440n(String str) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(str)) {
            str = this.f19918a.getString(CameraUIInterface.KEY_VIDEO_SIZE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_VIDEO_SIZE, this.f19931n.mo10653G()));
        }
        OptionItemInfo c3243eM21438p = m21438p(String.valueOf(120));
        if (CameraCharacteristicsUtil.m12974a(this.f19931n.mo10653G())) {
            if (c3243eM21438p != null) {
                this.f20131A.add(c3243eM21438p);
                mo21168j(String.valueOf(120));
            }
        } else if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_120_FPS)) {
            mo21168j(String.valueOf(120));
        } else {
            boolean z = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_120_FPS) && "video_size_4kuhd".equals(str);
            if (c3243eM21438p != null) {
                c3243eM21438p.m20480a(z);
            } else {
                OptionItemInfo c3243eM21437o = m21437o(String.valueOf(120));
                if (c3243eM21437o != null) {
                    m21439a(c3243eM21437o);
                    this.f20131A.remove(c3243eM21437o);
                    c3243eM21437o.m20480a(z);
                }
            }
        }
        OptionItemInfo c3243eM21438p2 = m21438p(String.valueOf(24));
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_8K_24_FPS)) {
            OptionItemInfo c3243eM21438p3 = m21438p(String.valueOf(30));
            if ("video_size_8k".equals(str)) {
                if (c3243eM21438p2 != null) {
                    c3243eM21438p2.m20480a(true);
                } else {
                    OptionItemInfo c3243eM21437o2 = m21437o(String.valueOf(24));
                    if (c3243eM21437o2 != null) {
                        m21439a(c3243eM21437o2);
                        this.f20131A.remove(c3243eM21437o2);
                        c3243eM21437o2.m20480a(true);
                    }
                }
                if (c3243eM21438p3 != null) {
                    if (!this.f20131A.contains(c3243eM21438p3)) {
                        this.f20131A.add(c3243eM21438p3);
                    }
                    mo21168j(String.valueOf(30));
                }
            } else {
                OptionItemInfo c3243eM21437o3 = m21437o(String.valueOf(30));
                if (c3243eM21437o3 != null) {
                    m21439a(c3243eM21437o3);
                    this.f20131A.remove(c3243eM21437o3);
                    c3243eM21437o3.m20480a(true);
                }
                if (c3243eM21438p2 != null) {
                    if (!this.f20131A.contains(c3243eM21438p2)) {
                        this.f20131A.add(c3243eM21438p2);
                    }
                    mo21168j(String.valueOf(24));
                }
            }
        } else if (c3243eM21438p2 != null) {
            mo21168j(String.valueOf(24));
        }
        boolean z2 = Util.m24286a(this.f19931n.mo10653G(), str) && !m21434ah();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < m21095X(); OplusGLSurfaceView_13++) {
            OptionItemInfo c3243eH = m21162h(OplusGLSurfaceView_13);
            if (c3243eH != null && 60 == Integer.parseInt(c3243eH.m20483c())) {
                CameraLog.m12959b("CameraMenuOptionDrawerItem", "updateVideoFpsItemsAvailability, video resolution value: " + str + ", enable 60fps: " + z2);
                c3243eH.m20480a(z2);
                mo21179q();
            }
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo21123a(String str, String... strArr) {
        if (!mo20300a().equals(str)) {
            return false;
        }
        CameraLog.m12959b("CameraMenuOptionDrawerItem", "addMenuOptionItems, key: " + str);
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (String str2 : strArr) {
            m21170k(str2);
        }
        if (this.f19919b == null) {
            return true;
        }
        m21175m();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f19929l != null) {
            CameraLog.m12959b("CameraMenuOptionDrawerItem", "onClick, Key: " + mo20300a());
            if (mo21081J() == null || mo21081J().isClickable()) {
                if (this.f19919b == null) {
                    m21171k();
                }
                if (2 == m21127ac()) {
                    return;
                }
                if (m21097Z()) {
                    int iX = m21095X();
                    if (PopUpWindowManager.m20706a()) {
                        PopUpWindowManager.m20712d();
                    }
                    int iX2 = (m21095X() - this.f20139y.indexOf(view)) - 1;
                    if (2 == m21086O()) {
                        iX2 = this.f19932o;
                        if (2 <= iX) {
                            iX2 = iX2 < iX + (-1) ? iX2 + 1 : 0;
                        }
                    }
                    if (m21128ad() != iX2) {
                        m21165i(iX2);
                        CameraLog.m12959b("CameraMenuOptionDrawerItem", "onClick, length: " + iX + ", index: " + iX2);
                        if (!CameraUIInterface.KEY_FILTER_MENU.equals(mo20300a())) {
                            mo21179q();
                        }
                    } else {
                        CameraLog.m12966e("CameraMenuOptionDrawerItem", "onClick, cancel, index unchanged");
                        return;
                    }
                } else if (m21164h()) {
                    m21178p();
                } else {
                    m21177o();
                }
                boolean zMo21231a = this.f19929l.mo21231a(mo20300a(), false, true);
                View view2 = this.f20136v;
                StringBuilder sb = new StringBuilder();
                sb.append(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(mo20300a()) ? this.f20134t : this.f20132r);
                sb.append(m21092U());
                view2.setContentDescription(sb.toString());
                CameraLog.m12959b("CameraMenuOptionDrawerItem", "onClick, Key: " + mo20300a() + ", menuOptionClickResult: " + zMo21231a);
                mo21098a(1.0f);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21107a(ViewGroup viewGroup) {
        super.mo21107a(viewGroup);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: B */
    public int mo21073B() {
        View view = this.f20136v;
        if (view != null) {
            return view.getWidth();
        }
        return super.mo21073B();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: C */
    public int mo21074C() throws Resources.NotFoundException {
        if (this.f20136v != null) {
            int dimensionPixelSize = this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_height);
            return 2 == m21086O() ? dimensionPixelSize + this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_layout_arrow_height) + this.f20138x.getResources().getDimensionPixelSize(R.dimen.drawer_line_margin_bottom) : dimensionPixelSize;
        }
        return super.mo21074C();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo21163h(String str) {
        CameraLog.m12959b("CameraMenuOptionDrawerItem", "setOptionItemText, text: " + str);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21104a(Drawable drawable, boolean z) {
        CameraLog.m12959b("CameraMenuOptionDrawerItem", "setImageIcon, icon: " + drawable);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21103a(int OplusGLSurfaceView_13, boolean z) {
        super.mo21103a(OplusGLSurfaceView_13, z);
        for (int i2 = 0; i2 < this.f20139y.size(); i2++) {
            View view = this.f20139y.get(i2);
            if (view instanceof RotateImageView) {
                ((RotateImageView) view).m18348a(OplusGLSurfaceView_13, z);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: A */
    protected void mo21072A() {
        if (this.f20136v != null) {
            super.mo21072A();
            mo21105a((View) null);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo21155f(int OplusGLSurfaceView_13) {
        super.mo21155f(OplusGLSurfaceView_13);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0175  */
    /* renamed from: aj */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m21436aj() {
        /*
            Method dump skipped, instructions count: 1044
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.setting.CameraMenuOptionDrawerItem.m21436aj():void");
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption, com.oplus.camera.ui.menu.BasicOptionItemList.OptionItemListListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20301a(CameraMenuOption cameraMenuOption, int OplusGLSurfaceView_13) {
        super.mo20301a(cameraMenuOption, OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f20140z = z;
        if (this.f20139y.size() > 0) {
            mo21179q();
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo21148d(String str, boolean z) {
        String strA = mo20300a();
        if (CameraUIInterface.KEY_VIDEO_FPS.equals(strA)) {
            int iMo10653G = this.f19931n != null ? this.f19931n.mo10653G() : 0;
            m21157f(z);
            m21433a(iMo10653G, str);
            m21087P();
            return;
        }
        if (CameraUIInterface.KEY_MACRO_SWITCH.equals(strA)) {
            if (this.f19918a != null) {
                this.f19918a.edit().remove(CameraUIInterface.KEY_LAST_MACRO_SWITCH).apply();
            }
            super.mo21148d(str, z);
            return;
        }
        super.mo21148d(str, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21433a(int OplusGLSurfaceView_13, String str) {
        String string = this.f19918a.getString(CameraUIInterface.KEY_VIDEO_FPS, this.f20138x.getString(R.string.camera_video_default_fps));
        if (TextUtils.isEmpty(str) || str.equals(string)) {
            return;
        }
        boolean zG = m21161g(OplusGLSurfaceView_13);
        CameraLog.m12954a("CameraMenuOptionDrawerItem", "processVideoFpsChange, fpsType: " + str);
        SharedPreferences.Editor editorEdit = this.f19918a.edit();
        editorEdit.putString(CameraUIInterface.KEY_VIDEO_FPS, str);
        editorEdit.putString(CameraUIInterface.KEY_LASTED_VIDEO_FPS, "");
        boolean zEquals = String.valueOf(60).equals(str);
        if (30 != Integer.parseInt(str)) {
            editorEdit.putString(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off");
        }
        if (zEquals) {
            String string2 = this.f19918a.getString(CameraUIInterface.KEY_LASTED_VIDEO_SIZE, "");
            if (!TextUtils.isEmpty(string2) && !Util.m24286a(OplusGLSurfaceView_13, string2)) {
                editorEdit.putString(CameraUIInterface.KEY_LASTED_VIDEO_SIZE, "");
                editorEdit.apply();
            }
            if (m21118a(OplusGLSurfaceView_13, str, (String) null) && Float.compare(this.f19931n.mo10877s(), ZoomManager.f12334a) == 0 && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
                editorEdit.putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on");
            } else {
                editorEdit.putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off");
            }
            editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
            editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX);
            editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        } else if (zG) {
            editorEdit.putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off");
            this.f19931n.mo10876r();
        }
        if (CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13) && !String.valueOf(30).equals(str)) {
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
            editorEdit.putBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false).apply();
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE_60_FPS)) {
            boolean z = this.f19918a.getBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false);
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_EIS_FPS);
            if ((z && zEquals) || (!z && Integer.parseInt(str) != configIntValue)) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
                editorEdit.putBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false).apply();
            }
        } else if (!zEquals) {
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
            editorEdit.putBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false).apply();
        }
        editorEdit.apply();
        mo21110a(CameraUIInterface.KEY_VIDEO_FPS, str, 0);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraMenuOption
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo21110a(String str, String str2, int OplusGLSurfaceView_13) {
        if (this.f19931n != null) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.f20138x);
            menuClickMsgData.mCaptureType = !this.f19931n.mo10648B() ? 1 : 0;
            menuClickMsgData.mCaptureMode = this.f19931n.mo10736ao();
            menuClickMsgData.mCameraEnterType = String.valueOf(this.f19931n.mo10786bc().m13317J());
            menuClickMsgData.mCameraId = this.f19931n.mo10654H();
            menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f19931n.mo10654H()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            menuClickMsgData.buildTopMenuEvent(str, str2, OplusGLSurfaceView_13);
            menuClickMsgData.report();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        super.mo21106a(view, motionEvent);
        return false;
    }
}
