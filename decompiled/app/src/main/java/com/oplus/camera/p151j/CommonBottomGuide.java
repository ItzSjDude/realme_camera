package com.oplus.camera.p151j;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.p034f.BidiFormatter;
import androidx.core.p034f.TextDirectionHeuristicsCompat;
import androidx.core.p034f.TextUtilsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.coui.appcompat.widget.COUIPageIndicator;
import com.coui.appcompat.widget.popupwindow.COUIBasePopupWindow;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.EffectiveAnimationTask;
import com.oplus.anim.EffectiveCompositionFactory;
import com.oplus.anim.EffectiveAnimationView;
import com.oplus.anim.RenderMode;
import com.oplus.anim.EffectiveAnimationListener;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.doubleexposure.DoubleExposureVideoView;
import com.oplus.camera.longexposure.LongExposureBottomGuideAdapter;
import com.oplus.camera.longexposure.LongExposureBottomGuideItem;
import com.oplus.camera.p172ui.PageGuideDialogFragment;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.widget.TextureVideoView;
import com.oplus.camera.photo3d.p159ui.GuideRecyclerViewAdapter;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.statistics.model.DoubleExposureMsgData;
import com.oplus.camera.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: CommonBottomGuide.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class CommonBottomGuide {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int[] f14386a = {R.string.camera_id_photo_mode_tips_background, R.string.camera_id_photo_mode_tips_distance, R.string.camera_id_photo_mode_tips_align};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final int[] f14387b = {R.drawable.id_photo_tips_background, R.drawable.id_photo_tips_distance, R.drawable.id_photo_tips_align};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final int[] f14388c = {R.string.camera_double_exposure_guide_hint, R.string.camera_double_exposure_guide_hint_secord, R.string.camera_double_exposure_guide_hint_third};

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final Uri[] f14389d = new Uri[3];

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static String f14390e = "CommonBottomGuide";

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ComboPreferences f14396f;

    /* renamed from: x */
    private COUIBasePopupWindow.PlatformImplementations.kt_3 f14414x;

    /* renamed from: y */
    private CameraUIListener f14415y;

    /* renamed from: z */
    private Handler f14416z;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PageGuideDialogFragment f14397g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private PageGuideDialogFragment f14398h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private PageGuideDialogFragment f14399i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private PageGuideDialogFragment f14400j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private PageGuideDialogFragment f14401k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private PageGuideDialogFragment f14402l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private Dialog f14403m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private Dialog f14404n = null;

    /* renamed from: o */
    private Dialog f14405o = null;

    /* renamed from: p */
    private RecyclerView f14406p = null;

    /* renamed from: q */
    private LongExposureBottomGuideAdapter f14407q = null;

    /* renamed from: r */
    private ViewPager2 f14408r = null;

    /* renamed from: s */
    private COUIPageIndicator f14409s = null;

    /* renamed from: t */
    private TextureVideoView f14410t = null;

    /* renamed from: u */
    private DoubleExposureVideoView f14411u = null;

    /* renamed from: v */
    private ImageView f14412v = null;

    /* renamed from: w */
    private Thread f14413w = null;

    /* renamed from: A */
    private long f14391A = 0;

    /* renamed from: B */
    private int f14392B = 0;

    /* renamed from: C */
    private boolean f14393C = false;

    /* renamed from: D */
    private boolean f14394D = false;

    /* renamed from: E */
    private boolean f14395E = false;

    public CommonBottomGuide(ComboPreferences comboPreferences, COUIBasePopupWindow.PlatformImplementations.kt_3 aVar, CameraUIListener cameraUIListener) {
        this.f14396f = null;
        this.f14414x = null;
        this.f14415y = null;
        this.f14416z = null;
        this.f14396f = comboPreferences;
        this.f14414x = aVar;
        this.f14415y = cameraUIListener;
        if (this.f14416z == null) {
            this.f14416z = new Handler(Looper.getMainLooper());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14454a(Activity activity) {
        Dialog dialog = this.f14403m;
        if (dialog != null && dialog.isShowing()) {
            m14453a(3, false);
        } else {
            m14455a(activity, 3);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14458b(Activity activity) {
        Dialog dialog = this.f14404n;
        if (dialog != null && dialog.isShowing()) {
            m14453a(8, false);
        } else {
            m14455a(activity, 8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14455a(Activity activity, int OplusGLSurfaceView_13) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        CameraLog.m12959b(f14390e, "showCommonBottomGuide, start show type: " + OplusGLSurfaceView_13);
        switch (OplusGLSurfaceView_13) {
            case 1:
                m14437l(activity);
                break;
            case 2:
                m14417e(activity);
                break;
            case 3:
                m14414d(activity);
                break;
            case 4:
                m14423g(activity);
                break;
            case 5:
                m14441m(activity);
                break;
            case 6:
                m14449p(activity);
                break;
            case 7:
                m14420f(activity);
                break;
            case 8:
                m14426h(activity);
                break;
            case 9:
                m14450q(activity);
                break;
        }
        CameraLog.m12959b(f14390e, "showCommonBottomGuide, finish show type: " + OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14453a(int OplusGLSurfaceView_13, boolean z) {
        ComboPreferences comboPreferences;
        ComboPreferences comboPreferences2;
        CameraLog.m12959b(f14390e, "hideCommonBottomGuide, start hide type: " + OplusGLSurfaceView_13 + ", remove: " + z);
        boolean z2 = false;
        switch (OplusGLSurfaceView_13) {
            case 1:
                PageGuideDialogFragment c3466s = this.f14397g;
                if (c3466s != null) {
                    m14402a(c3466s);
                    if (z && (comboPreferences = this.f14396f) != null) {
                        comboPreferences.edit().putBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, false).apply();
                        break;
                    }
                }
                break;
            case 2:
                PageGuideDialogFragment c3466s2 = this.f14398h;
                if (c3466s2 != null) {
                    m14402a(c3466s2);
                    if (z && (comboPreferences2 = this.f14396f) != null) {
                        comboPreferences2.edit().putBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_NIGHT_TRIPOD, false).apply();
                        break;
                    }
                }
                break;
            case 3:
                m14407b(this.f14403m);
                break;
            case 4:
                m14402a(this.f14399i);
                break;
            case 5:
                PageGuideDialogFragment c3466s3 = this.f14401k;
                if (c3466s3 != null && !c3466s3.m23912b()) {
                    z2 = true;
                }
                this.f14395E = z2;
                m14402a(this.f14401k);
                break;
            case 6:
                m14402a(this.f14402l);
                break;
            case 7:
                m14402a(this.f14400j);
                break;
            case 8:
                m14407b(this.f14404n);
                break;
            case 9:
                m14407b(this.f14405o);
                break;
        }
        CameraLog.m12959b(f14390e, "hideCommonBottomGuide, finish hide type: " + OplusGLSurfaceView_13 + ", remove: " + z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14452a() {
        m14402a(this.f14397g);
        m14402a(this.f14398h);
        m14407b(this.f14403m);
        m14402a(this.f14399i);
        m14407b(this.f14404n);
        m14402a(this.f14401k);
        m14402a(this.f14400j);
        m14407b(this.f14405o);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14402a(DialogFragment dialogInterfaceOnCancelListenerC0580b) {
        if (dialogInterfaceOnCancelListenerC0580b == null || dialogInterfaceOnCancelListenerC0580b.getDialog() == null || !dialogInterfaceOnCancelListenerC0580b.getDialog().isShowing()) {
            return;
        }
        dialogInterfaceOnCancelListenerC0580b.getDialog().hide();
        dialogInterfaceOnCancelListenerC0580b.dismiss();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14407b(Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.hide();
        dialog.dismiss();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean m14428i() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW);
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m14414d(Activity activity) {
        this.f14403m = new Dialog(activity, R.style.ProfessionalModeGuideTheme);
        this.f14403m.setContentView(R.layout.common_bottom_guide_professional_parameter_layout);
        this.f14403m.setCanceledOnTouchOutside(true);
        this.f14403m.setCancelable(true);
        Window window = this.f14403m.getWindow();
        int iK = this.f14415y.mo10769bL().mo16570k();
        if (Util.m24498u()) {
            iK = this.f14415y.mo10770bM();
            if (iK % 180 != 0) {
                iK = 360 - iK;
            }
            View viewFindViewById = this.f14403m.findViewById(R.id_renamed.professional_parameter_layout);
            viewFindViewById.setRotation(iK);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewFindViewById.getLayoutParams();
            int screenWidth = (Util.getScreenWidth() - Util.getScreenHeight()) / 2;
            if (iK != 0) {
                layoutParams.leftMargin += screenWidth;
                layoutParams.rightMargin += screenWidth;
                layoutParams.topMargin -= screenWidth;
                layoutParams.bottomMargin -= screenWidth;
            }
        }
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
        }
        this.f14403m.findViewById(R.id_renamed.ivCancel).setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonBottomGuide.this.f14403m == null || !CommonBottomGuide.this.f14403m.isShowing()) {
                    return;
                }
                CommonBottomGuide.this.f14403m.dismiss();
                CommonBottomGuide.this.f14403m = null;
            }
        });
        m14401a((TextView) this.f14403m.findViewById(R.id_renamed.tvIsoTitle));
        m14401a((TextView) this.f14403m.findViewById(R.id_renamed.tvShutterTitle));
        m14401a((TextView) this.f14403m.findViewById(R.id_renamed.tvWhiteBalanceTitle));
        m14401a((TextView) this.f14403m.findViewById(R.id_renamed.tvWhiteAmfTitle));
        m14401a((TextView) this.f14403m.findViewById(R.id_renamed.tvWhiteEvfTitle));
        if (m14428i()) {
            m14401a((TextView) this.f14403m.findViewById(R.id_renamed.tvRawTitle));
        }
        int OplusGLSurfaceView_13 = m14428i() ? 0 : 8;
        this.f14403m.findViewById(R.id_renamed.tvRawTitle).setVisibility(OplusGLSurfaceView_13);
        this.f14403m.findViewById(R.id_renamed.tvRawDescription).setVisibility(OplusGLSurfaceView_13);
        View viewFindViewById2 = this.f14403m.findViewById(R.id_renamed.svContent);
        viewFindViewById2.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.12
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view, int i2, int i3, int i4, int i5) {
                View viewFindViewById3;
                if (CommonBottomGuide.this.f14403m == null || !CommonBottomGuide.this.f14403m.isShowing() || (viewFindViewById3 = CommonBottomGuide.this.f14403m.findViewById(R.id_renamed.vDivider)) == null) {
                    return;
                }
                viewFindViewById3.setVisibility(!((NestedScrollView) view).canScrollVertically(-1) ? 4 : 0);
            }
        });
        if (Util.m24338aa()) {
            LinearLayoutCompat.C0277a c0277a = (LinearLayoutCompat.C0277a) viewFindViewById2.getLayoutParams();
            if (90 == iK) {
                c0277a.rightMargin = Util.m24198Z();
            } else if (270 == iK) {
                c0277a.leftMargin = Util.m24198Z();
                View viewFindViewById3 = this.f14403m.findViewById(R.id_renamed.ivCancel);
                LinearLayoutCompat.C0277a c0277a2 = (LinearLayoutCompat.C0277a) viewFindViewById3.getLayoutParams();
                c0277a2.leftMargin += Util.m24198Z();
                viewFindViewById3.setLayoutParams(c0277a2);
            } else {
                c0277a.bottomMargin = Util.m24198Z();
            }
        }
        if (this.f14403m.isShowing()) {
            return;
        }
        try {
            m14456a(this.f14403m);
        } catch (WindowManager.BadTokenException COUIBaseListPopupWindow_8) {
            if (this.f14403m.isShowing()) {
                this.f14403m.dismiss();
                this.f14403m = null;
            }
            CameraLog.m12966e(f14390e, "showProfessionalParameterBottomGuide, exception: " + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14401a(TextView textView) {
        String string;
        int iIndexOf;
        try {
            if (1 != TextUtilsCompat.m2525a(Locale.getDefault()) || textView == null || textView.getText() == null || (iIndexOf = (string = textView.getText().toString()).indexOf(40)) <= 0 || iIndexOf >= string.length()) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            String strSubstring = string.substring(0, iIndexOf);
            String strSubstring2 = string.substring(iIndexOf);
            stringBuffer.append(strSubstring);
            stringBuffer.append(strSubstring2);
            textView.setText(BidiFormatter.m2481a(true).m2488a(stringBuffer, TextDirectionHeuristicsCompat.f2926e));
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            CameraLog.m12967f(f14390e, " setRtlProfessionalTitleText error : " + COUIBaseListPopupWindow_8.toString());
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m14417e(Activity activity) {
        if (this.f14398h == null) {
            this.f14398h = m14393a(activity, R.layout.common_bottom_guide_night_tripod_layout, R.string.tripod_night_guide_title, R.string.night_tripod_guide_description_new);
            ((ImageView) this.f14398h.m23908a().findViewById(R.id_renamed.imageView)).setOutlineProvider(new PlatformImplementations.kt_3());
            this.f14398h.m23911a(new PageGuideDialogFragment.PlatformImplementations.kt_3() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$-6t9oV8odGoNwtWwnveaxwn1wlQ
                @Override // com.oplus.camera.p172ui.PageGuideDialogFragment.PlatformImplementations.kt_3
                public final void onGuideDialogShowAction() {
                    this.COUIBaseListPopupWindow_12$0.m14447o();
                }
            });
            this.f14398h.m23909a(new DialogInterface.OnDismissListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.17
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (CommonBottomGuide.this.f14396f != null) {
                        CommonBottomGuide.this.f14396f.edit().putBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_NIGHT_TRIPOD, false).apply();
                    }
                }
            });
        }
        if (this.f14398h.isAdded()) {
            return;
        }
        this.f14398h.show(((AppCompatActivity) activity).m3341j(), "showNightTripodBottomGuide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void m14447o() {
        this.f14398h.m23908a().findViewById(R.id_renamed.guide_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$ql4HwBFRIQZZ8Jq4CT11fqaDzAk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m14421f(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public /* synthetic */ void m14421f(View view) {
        m14402a(this.f14398h);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m14420f(Activity activity) {
        if (this.f14400j == null) {
            this.f14400j = m14445o(activity);
            this.f14400j.m23911a(new PageGuideDialogFragment.PlatformImplementations.kt_3() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$1M7jQtsmqnjbSz_U4xrvfeoYtUk
                @Override // com.oplus.camera.p172ui.PageGuideDialogFragment.PlatformImplementations.kt_3
                public final void onGuideDialogShowAction() {
                    this.COUIBaseListPopupWindow_12$0.m14444n();
                }
            });
            this.f14400j.m23909a(new DialogInterface.OnDismissListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.18
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (CommonBottomGuide.this.f14396f != null) {
                        CommonBottomGuide.this.f14396f.edit().putBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_MAKEUP_TIPS_SHOWED, false).apply();
                    }
                }
            });
        }
        if (this.f14400j.isAdded()) {
            return;
        }
        this.f14400j.show(((AppCompatActivity) activity).m3341j(), "showMakeupBottomGuide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public /* synthetic */ void m14444n() {
        this.f14400j.m23908a().findViewById(R.id_renamed.guide_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$3OmpZ2qhqPLhLksDR0qjSSJ9ig4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m14418e(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public /* synthetic */ void m14418e(View view) {
        m14402a(this.f14400j);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m14423g(Activity activity) {
        if (this.f14399i == null) {
            this.f14399i = m14394a(activity, R.layout.common_bottom_guide_id_photo_layout, f14386a, f14387b);
            this.f14399i.m23911a(new PageGuideDialogFragment.PlatformImplementations.kt_3() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$VtXUHbd8H7d2BwCsP8oKrhE7SLU
                @Override // com.oplus.camera.p172ui.PageGuideDialogFragment.PlatformImplementations.kt_3
                public final void onGuideDialogShowAction() {
                    this.COUIBaseListPopupWindow_12$0.m14440m();
                }
            });
            this.f14399i.m23909a(new DialogInterface.OnDismissListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.19
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (CommonBottomGuide.this.f14396f != null) {
                        CommonBottomGuide.this.f14396f.edit().putBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_ID_PHOTO_FIRST_TIPS_SHOWED, true).apply();
                    }
                }
            });
        }
        if (this.f14399i.isAdded()) {
            return;
        }
        this.f14399i.show(((AppCompatActivity) activity).m3341j(), "showIdPhotoBottomGuide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public /* synthetic */ void m14440m() {
        this.f14399i.m23908a().findViewById(R.id_renamed.guide_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$iSU3WfyJKlfazsV4Ws9aMQrRlVU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m14415d(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m14415d(View view) {
        m14402a(this.f14399i);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m14426h(Activity activity) {
        this.f14404n = new Dialog(activity, R.style.ProfessionalModeGuideTheme);
        this.f14404n.setContentView(R.layout.common_bottom_guide_longexposure_parameter_layout);
        this.f14404n.setCanceledOnTouchOutside(true);
        this.f14404n.setCancelable(true);
        Window window = this.f14404n.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            attributes.windowAnimations = R.style.ProfessionalModeGuideDialog;
            window.setAttributes(attributes);
        }
        m14427i(activity);
        this.f14404n.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.20
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                CommonBottomGuide.this.f14406p = null;
            }
        });
        this.f14404n.findViewById(R.id_renamed.ivCancel).setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonBottomGuide.this.f14404n == null || !CommonBottomGuide.this.f14404n.isShowing()) {
                    return;
                }
                CommonBottomGuide.this.f14404n.dismiss();
                CommonBottomGuide.this.f14404n = null;
            }
        });
        View viewFindViewById = this.f14404n.findViewById(R.id_renamed.svContent);
        viewFindViewById.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.22
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
                View viewFindViewById2;
                if (CommonBottomGuide.this.f14404n == null || !CommonBottomGuide.this.f14404n.isShowing() || (viewFindViewById2 = CommonBottomGuide.this.f14404n.findViewById(R.id_renamed.vDivider)) == null) {
                    return;
                }
                viewFindViewById2.setVisibility(!((NestedScrollView) view).canScrollVertically(-1) ? 4 : 0);
            }
        });
        if (Util.m24338aa()) {
            ((LinearLayoutCompat.C0277a) viewFindViewById.getLayoutParams()).bottomMargin = Util.m24198Z();
        }
        if (this.f14404n.isShowing()) {
            return;
        }
        try {
            m14456a(this.f14404n);
        } catch (WindowManager.BadTokenException COUIBaseListPopupWindow_8) {
            if (this.f14404n.isShowing()) {
                this.f14404n.dismiss();
                this.f14404n = null;
            }
            CameraLog.m12966e(f14390e, "showLongExposureParameterBottomGuide, exception: " + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m14427i(Activity activity) {
        this.f14406p = (RecyclerView) this.f14404n.findViewById(R.id_renamed.long_exposure_options_rv);
        this.f14406p.setOverScrollMode(2);
        this.f14406p.setClipChildren(false);
        this.f14406p.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        List<LongExposureBottomGuideItem> listM14434k = m14434k(activity);
        if (this.f14407q == null) {
            this.f14407q = new LongExposureBottomGuideAdapter(listM14434k);
        }
        this.f14406p.setAdapter(this.f14407q);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private List<LongExposureBottomGuideItem> m14431j(Activity activity) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LongExposureBottomGuideItem(2, activity.getString(Util.m24445f(R.string.camera_long_exposure_type_busy_traffic)), activity.getString(R.string.long_exposure_mode_guide_busy_traffic_description), activity.getDrawable(R.drawable.guide_long_exposure_busy_traffic)));
        arrayList.add(new LongExposureBottomGuideItem(3, activity.getString(R.string.camera_long_exposure_type_flowing_clouds_and_water), activity.getString(R.string.long_exposure_mode_guide_flowing_clouds_and_water_desc), activity.getDrawable(R.drawable.guide_long_exposure_flowing_clouds_and_water)));
        arrayList.add(new LongExposureBottomGuideItem(4, activity.getString(Util.m24445f(R.string.camera_long_exposure_type_light_painting)), activity.getString(R.string.long_exposure_mode_guide_light_painting_description), activity.getDrawable(R.drawable.guide_long_exposure_light_painting)));
        return arrayList;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private List<LongExposureBottomGuideItem> m14434k(Activity activity) {
        List<LongExposureBottomGuideItem> listM14431j = m14431j(activity);
        int[] configIntArrayValue = CameraConfig.getConfigIntArrayValue(ConfigDataBase.KEY_LONG_EXPOSURE_SCENE_TYPE_ARRAY);
        if (configIntArrayValue != null && configIntArrayValue.length > 0) {
            if (listM14431j != null && !listM14431j.isEmpty()) {
                listM14431j.clear();
            }
            for (int OplusGLSurfaceView_13 : configIntArrayValue) {
                if (OplusGLSurfaceView_13 == 1) {
                    listM14431j.add(new LongExposureBottomGuideItem(1, activity.getString(Util.m24445f(R.string.camera_long_exposure_type_light_rail_portrait)), activity.getString(R.string.long_exposure_mode_guide_light_rail_portrait_description), activity.getDrawable(R.drawable.guide_long_exposure_streamer_portrait)));
                } else if (OplusGLSurfaceView_13 == 2) {
                    listM14431j.add(new LongExposureBottomGuideItem(2, activity.getString(Util.m24445f(R.string.camera_long_exposure_type_busy_traffic)), activity.getString(R.string.long_exposure_mode_guide_busy_traffic_description), activity.getDrawable(R.drawable.guide_long_exposure_busy_traffic)));
                } else if (OplusGLSurfaceView_13 == 3) {
                    listM14431j.add(new LongExposureBottomGuideItem(3, activity.getString(R.string.camera_long_exposure_type_flowing_clouds_and_water), activity.getString(R.string.long_exposure_mode_guide_flowing_clouds_and_water_desc), activity.getDrawable(R.drawable.guide_long_exposure_flowing_clouds_and_water)));
                } else if (OplusGLSurfaceView_13 == 4) {
                    listM14431j.add(new LongExposureBottomGuideItem(4, activity.getString(Util.m24445f(R.string.camera_long_exposure_type_light_painting)), activity.getString(R.string.long_exposure_mode_guide_light_painting_description), activity.getDrawable(R.drawable.guide_long_exposure_light_painting)));
                } else if (OplusGLSurfaceView_13 == 5) {
                    listM14431j.add(new LongExposureBottomGuideItem(5, activity.getString(R.string.camera_long_exposure_type_moving_crowd), activity.getString(R.string.long_exposure_mode_guide_moving_crowd_description), activity.getDrawable(R.drawable.guide_long_exposure_moving_crowd)));
                }
            }
        }
        return listM14431j;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m14437l(final Activity activity) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.f14397g = m14393a(activity, R.layout.common_bottom_guide_fast_video_layout, R.string.camera_video_hyper_lapse_title, R.string.hyper_lapse_guide_description);
        this.f14410t = (TextureVideoView) this.f14397g.m23908a().findViewById(R.id_renamed.videoView);
        this.f14412v = (ImageView) this.f14397g.m23908a().findViewById(R.id_renamed.iv_video_thumb);
        Uri uri = Uri.parse("android.resource://" + activity.getPackageName() + "/" + R.raw.fastvideo_guide);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final Runnable runnable = new Runnable() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.23
            @Override // java.lang.Runnable
            public void run() throws IllegalStateException {
                if (CommonBottomGuide.this.f14410t != null) {
                    CommonBottomGuide.this.f14410t.start();
                    CommonBottomGuide.this.f14410t.requestFocus();
                }
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.2
            @Override // java.lang.Runnable
            public void run() {
                if (CommonBottomGuide.this.f14397g.isAdded()) {
                    return;
                }
                CommonBottomGuide.this.f14397g.show(((AppCompatActivity) activity).m3341j(), "showFastVideoBottomGuide");
            }
        };
        final Runnable runnable3 = new Runnable() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.3
            @Override // java.lang.Runnable
            public void run() {
                if (CommonBottomGuide.this.f14414x != null) {
                    CommonBottomGuide.this.f14414x.mo6984a();
                }
                if (CommonBottomGuide.this.f14416z != null) {
                    CommonBottomGuide.this.f14416z.removeCallbacksAndMessages(null);
                }
            }
        };
        this.f14412v.setClipToOutline(true);
        this.f14412v.setOutlineProvider(new PlatformImplementations.kt_3());
        this.f14412v.setOutlineSpotShadowColor(activity.getResources().getColor(android.R.color.transparent));
        this.f14410t.setEnabled(false);
        this.f14410t.setOutlineProvider(new PlatformImplementations.kt_3());
        this.f14410t.setClipToOutline(true);
        this.f14410t.setVideoURI(uri);
        this.f14410t.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                CameraLog.m12959b(CommonBottomGuide.f14390e, "videoView onPrepared");
                mediaPlayer.setLooping(true);
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (0 <= jCurrentTimeMillis2) {
                    CommonBottomGuide.this.f14416z.post(runnable);
                } else {
                    CommonBottomGuide.this.f14416z.postDelayed(runnable, 0 - jCurrentTimeMillis2);
                }
            }
        });
        this.f14410t.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.5
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int OplusGLSurfaceView_13, int i2) {
                if (3 != OplusGLSurfaceView_13 || CommonBottomGuide.this.f14412v == null) {
                    return true;
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(CommonBottomGuide.this.f14412v, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setDuration(100L);
                objectAnimatorOfFloat.setRepeatCount(0);
                objectAnimatorOfFloat.start();
                return true;
            }
        });
        this.f14410t.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.6
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int OplusGLSurfaceView_13, int i2) {
                CameraLog.m12967f(CommonBottomGuide.f14390e, "videoView onError, what: " + OplusGLSurfaceView_13 + ", extra: " + i2);
                return false;
            }
        });
        this.f14397g.m23911a(new PageGuideDialogFragment.PlatformImplementations.kt_3() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$0iMX4jyKt8eDfyBKgkPVyYxlhb4
            @Override // com.oplus.camera.p172ui.PageGuideDialogFragment.PlatformImplementations.kt_3
            public final void onGuideDialogShowAction() {
                this.COUIBaseListPopupWindow_12$0.m14436l();
            }
        });
        this.f14394D = false;
        this.f14397g.m23909a(new DialogInterface.OnDismissListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) throws IllegalStateException {
                if (CommonBottomGuide.this.f14394D) {
                    CommonBottomGuide.this.f14394D = false;
                    return;
                }
                if (CommonBottomGuide.this.f14412v != null) {
                    CommonBottomGuide.this.f14412v.setAlpha(1.0f);
                    CommonBottomGuide.this.f14412v = null;
                }
                if (CommonBottomGuide.this.f14410t != null) {
                    CommonBottomGuide.this.f14410t.pause();
                    CommonBottomGuide.this.f14410t.setOnPreparedListener(null);
                    CommonBottomGuide.this.f14410t.setOnCompletionListener(null);
                    CommonBottomGuide.this.f14410t.setOnErrorListener(null);
                }
                if (CommonBottomGuide.this.f14396f != null) {
                    CommonBottomGuide.this.f14396f.edit().putBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, false).apply();
                }
                CommonBottomGuide.this.f14416z.postDelayed(runnable3, 200L);
            }
        });
        m14400a(this.f14412v, activity, uri, this.f14416z, runnable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public /* synthetic */ void m14436l() {
        this.f14397g.m23908a().findViewById(R.id_renamed.guide_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$ZxjjRibKgFaoVG__GBJcVj6MNHo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m14412c(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m14412c(View view) {
        m14402a(this.f14397g);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m14441m(Activity activity) {
        ViewPager2 viewPager2;
        this.f14391A = SystemClock.uptimeMillis();
        this.f14393C = true;
        this.f14395E = false;
        PageGuideDialogFragment c3466s = this.f14401k;
        if (c3466s == null) {
            this.f14401k = m14443n(activity);
            this.f14401k.m23911a(new PageGuideDialogFragment.PlatformImplementations.kt_3() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$RZhUdy5W-PUipRCC-bAInUltETc
                @Override // com.oplus.camera.p172ui.PageGuideDialogFragment.PlatformImplementations.kt_3
                public final void onGuideDialogShowAction() {
                    this.COUIBaseListPopupWindow_12$0.m14435k();
                }
            });
            this.f14401k.m23909a(new DialogInterface.OnDismissListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.8
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) throws IllegalStateException {
                    if (CommonBottomGuide.this.f14396f != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(CommonBottomGuide.this.f14408r.getCurrentItem());
                        stringBuffer.append(":");
                        stringBuffer.append(SystemClock.uptimeMillis() - CommonBottomGuide.this.f14391A);
                        stringBuffer.append(":");
                        stringBuffer.append(CommonBottomGuide.this.f14393C ? DoubleExposureMsgData.KEY_VIDEO_EXIT_TYPE_VALUE_GLIDE : DoubleExposureMsgData.KEY_VIDEO_EXIT_TYPE_VALUE_CLICK);
                        CommonBottomGuide.this.f14396f.edit().putString(CameraUIInterface.KEY_DOUBLE_EXPOSURE_GUID_PAGE_AND_DURATION, stringBuffer.toString()).apply();
                    }
                    if (CommonBottomGuide.this.f14396f != null) {
                        CommonBottomGuide.this.f14396f.edit().putBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE, false).apply();
                    }
                    if (CommonBottomGuide.this.f14411u != null) {
                        CommonBottomGuide.this.f14411u.m12889b();
                    }
                    CommonBottomGuide.this.f14391A = 0L;
                }
            });
            this.f14401k.m23910a(new DialogInterface.OnShowListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.9
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) throws IllegalStateException {
                    DoubleExposureVideoView doubleExposureVideoView = (DoubleExposureVideoView) CommonBottomGuide.this.f14408r.getChildAt(0).findViewById(R.id_renamed.videoView);
                    if (doubleExposureVideoView != null) {
                        doubleExposureVideoView.m12888a();
                    }
                }
            });
            return;
        }
        if (c3466s.m23912b() || (viewPager2 = this.f14408r) == null) {
            return;
        }
        viewPager2.m5042a(0, false);
        this.f14409s.setCurrentPosition(0);
        if (this.f14401k.isAdded()) {
            return;
        }
        this.f14401k.show(((AppCompatActivity) activity).m3341j(), "showDoubleExposureBottomGuide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_5 */
    public /* synthetic */ void m14435k() {
        this.f14401k.m23908a().findViewById(R.id_renamed.guide_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$Hs4ow8r9eePT0cm43rzkak4YVYQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m14408b(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m14408b(View view) {
        m14402a(this.f14401k);
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: OplusGLSurfaceView_11 */
    private PageGuideDialogFragment m14443n(final Activity activity) {
        f14389d[0] = Uri.parse("android.resource://" + activity.getPackageName() + "/" + R.raw.double_exposure_guide1);
        f14389d[1] = Uri.parse("android.resource://" + activity.getPackageName() + "/" + R.raw.double_exposure_guide2);
        f14389d[2] = Uri.parse("android.resource://" + activity.getPackageName() + "/" + R.raw.double_exposure_guide3);
        final VideoViewPagerAdapter c2786b = new VideoViewPagerAdapter(activity, f14388c, f14389d);
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.common_bottom_guide_double_exposure_layout, (ViewGroup) null);
        this.f14408r = (ViewPager2) viewInflate.findViewById(R.id_renamed.guide_content_container);
        this.f14408r.setAdapter(c2786b);
        this.f14408r.setOffscreenPageLimit(3);
        this.f14409s = (COUIPageIndicator) viewInflate.findViewById(R.id_renamed.guide_content_indicator);
        this.f14409s.setDotsCount(c2786b.getItemCount());
        this.f14408r.m5044a(new ViewPager2.AbstractC0845e() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.10
            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
            public void onPageScrolled(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2) {
                super.onPageScrolled(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, i2);
                CommonBottomGuide.this.f14409s.m7404a(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, i2);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
            public void onPageSelected(int OplusGLSurfaceView_13) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                super.onPageSelected(OplusGLSurfaceView_13);
                CommonBottomGuide c2785a = CommonBottomGuide.this;
                c2785a.f14411u = c2785a.m14389a(c2785a.f14408r, OplusGLSurfaceView_13);
                if (CommonBottomGuide.this.f14411u != null) {
                    CommonBottomGuide.this.f14411u.m12890c();
                    CommonBottomGuide.this.f14411u.m12888a();
                }
                CommonBottomGuide c2785a2 = CommonBottomGuide.this;
                DoubleExposureVideoView doubleExposureVideoViewM14389a = c2785a2.m14389a(c2785a2.f14408r, c2786b.m14472a());
                if (doubleExposureVideoViewM14389a != null) {
                    doubleExposureVideoViewM14389a.m12889b();
                }
                c2786b.m14474a(OplusGLSurfaceView_13);
                CommonBottomGuide.this.f14409s.m7403a(OplusGLSurfaceView_13);
                if (CommonBottomGuide.this.f14396f != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(OplusGLSurfaceView_13);
                    stringBuffer.append(":");
                    stringBuffer.append(SystemClock.uptimeMillis() - CommonBottomGuide.this.f14391A);
                    stringBuffer.append(":");
                    stringBuffer.append(DoubleExposureMsgData.KEY_VIDEO_EXIT_TYPE_VALUE_CHANGE);
                    CommonBottomGuide.this.f14396f.edit().putString(CameraUIInterface.KEY_DOUBLE_EXPOSURE_GUID_PAGE_AND_DURATION, stringBuffer.toString()).apply();
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
            public void onPageScrollStateChanged(int OplusGLSurfaceView_13) {
                super.onPageScrollStateChanged(OplusGLSurfaceView_13);
                CommonBottomGuide.this.f14409s.m7405b(OplusGLSurfaceView_13);
            }
        });
        this.f14409s.setOnDotClickListener(new COUIPageIndicator.InterfaceC1419a() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$TbfY8TVF90n85sFBRpBVSCX_KEU
            @Override // com.coui.appcompat.widget.COUIPageIndicator.InterfaceC1419a
            public final void onClick(int OplusGLSurfaceView_13) {
                this.COUIBaseListPopupWindow_12$0.m14395a(OplusGLSurfaceView_13);
            }
        });
        c2786b.m14476a(new DoubleExposureVideoView.InterfaceC2681a() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.11
            @Override // com.oplus.camera.doubleexposure.DoubleExposureVideoView.InterfaceC2681a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12892a(Bitmap bitmap) {
                if (CommonBottomGuide.this.f14401k.m23912b()) {
                    return;
                }
                c2786b.m14475a(bitmap);
                FragmentManager abstractC0586hJ = ((AppCompatActivity) activity).m3341j();
                if (CommonBottomGuide.this.f14401k.isAdded() || abstractC0586hJ.mo3400g()) {
                    return;
                }
                CommonBottomGuide.this.f14401k.show(abstractC0586hJ, "showDoubleExposureBottomGuide");
            }

            @Override // com.oplus.camera.doubleexposure.DoubleExposureVideoView.InterfaceC2681a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12891a() {
                CameraLog.m12967f(CommonBottomGuide.f14390e, "VideoViewPagerAdapter onLoadVideoThumbFail ");
            }
        });
        return new PageGuideDialogFragment(viewInflate, this.f14415y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m14395a(int OplusGLSurfaceView_13) {
        this.f14408r.setCurrentItem(OplusGLSurfaceView_13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public DoubleExposureVideoView m14389a(ViewPager2 viewPager2, int OplusGLSurfaceView_13) {
        View childAt;
        ViewGroup viewGroup = viewPager2.getChildCount() > 0 ? (ViewGroup) viewPager2.getChildAt(0) : null;
        if (viewGroup == null || OplusGLSurfaceView_13 > viewGroup.getChildCount() || (childAt = viewGroup.getChildAt(OplusGLSurfaceView_13)) == null) {
            return null;
        }
        return (DoubleExposureVideoView) childAt.findViewById(R.id_renamed.videoView);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14400a(ImageView imageView, Activity activity, Uri uri, Handler handler, Runnable runnable) {
        this.f14413w = new Thread(new IntrinsicsJvm.kt_4(activity, handler, uri, imageView, runnable));
        this.f14413w.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PageGuideDialogFragment m14393a(Activity activity, int OplusGLSurfaceView_13, int i2, int i3) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.common_full_page_guide_layout, (ViewGroup) null);
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id_renamed.guide_image_content);
        ((TextView) viewInflate.findViewById(R.id_renamed.bottom_guide_title)).setText(i2);
        TextView textView = (TextView) viewInflate.findViewById(R.id_renamed.bottom_guide_description);
        if (-1 != i3) {
            textView.setVisibility(0);
            textView.setText(i3);
        } else {
            textView.setVisibility(8);
        }
        viewGroup.addView(LayoutInflater.from(activity).inflate(OplusGLSurfaceView_13, viewGroup, false));
        return new PageGuideDialogFragment(viewInflate, this.f14415y);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PageGuideDialogFragment m14394a(Activity activity, int OplusGLSurfaceView_13, int[] iArr, int[] iArr2) {
        IntrinsicsJvm.kt_3 cVar = new IntrinsicsJvm.kt_3(iArr, iArr2);
        View viewInflate = LayoutInflater.from(activity).inflate(OplusGLSurfaceView_13, (ViewGroup) null);
        PageGuideDialogFragment c3466s = new PageGuideDialogFragment(viewInflate, this.f14415y);
        final ViewPager2 viewPager2 = (ViewPager2) viewInflate.findViewById(R.id_renamed.guide_content_container);
        viewPager2.setOverScrollMode(2);
        viewPager2.setAdapter(cVar);
        final COUIPageIndicator cOUIPageIndicator = (COUIPageIndicator) viewInflate.findViewById(R.id_renamed.guide_content_indicator);
        cOUIPageIndicator.setDotsCount(cVar.getItemCount());
        viewPager2.m5044a(new ViewPager2.AbstractC0845e() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.13
            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
            public void onPageScrolled(int i2, float COUIBaseListPopupWindow_12, int i3) {
                super.onPageScrolled(i2, COUIBaseListPopupWindow_12, i3);
                cOUIPageIndicator.m7404a(i2, COUIBaseListPopupWindow_12, i3);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
            public void onPageSelected(int i2) {
                super.onPageSelected(i2);
                cOUIPageIndicator.m7403a(i2);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
            public void onPageScrollStateChanged(int i2) {
                super.onPageScrollStateChanged(i2);
                cOUIPageIndicator.m7405b(i2);
            }
        });
        cOUIPageIndicator.setOnDotClickListener(new COUIPageIndicator.InterfaceC1419a() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$FACW_vYi5yynUMHixE2LrkteMFU
            @Override // com.coui.appcompat.widget.COUIPageIndicator.InterfaceC1419a
            public final void onClick(int i2) {
                viewPager2.setCurrentItem(i2);
            }
        });
        return c3466s;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PageGuideDialogFragment m14392a(Activity activity, int OplusGLSurfaceView_13, int i2) {
        CameraUIListener cameraUIListener;
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.common_bottom_guide_mode_arrange, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id_renamed.guide_tips_tv)).setText(OplusGLSurfaceView_13);
        ((TextView) viewInflate.findViewById(R.id_renamed.bottom_guide_description)).setText(i2);
        final EffectiveAnimationView effectiveAnimationView = (EffectiveAnimationView) viewInflate.findViewById(R.id_renamed.bottom_guide_effective_view);
        effectiveAnimationView.setRenderMode(RenderMode.HARDWARE);
        EffectiveAnimationTask<EffectiveAnimationComposition> c2402fM9314b = EffectiveCompositionFactory.m9314b(activity, "mode_arrage_guide.json");
        if (Util.m24498u() && (cameraUIListener = this.f14415y) != null) {
            int iMo10816ca = cameraUIListener.mo10816ca();
            if (iMo10816ca == 1) {
                c2402fM9314b = EffectiveCompositionFactory.m9314b(activity, "mode_arrange_guide_full.json");
            } else if (iMo10816ca == 3) {
                c2402fM9314b = EffectiveCompositionFactory.m9314b(activity, "mode_arrange_guide_split.json");
            } else if (iMo10816ca == 4) {
                c2402fM9314b = EffectiveCompositionFactory.m9314b(activity, "mode_arrange_guide_rack.json");
            }
            m14396a(iMo10816ca, viewInflate, activity);
        }
        c2402fM9314b.m9238a(new EffectiveAnimationListener<EffectiveAnimationComposition>() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.14
            @Override // com.oplus.anim.EffectiveAnimationListener
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo8781a(EffectiveAnimationComposition c2272a) {
                effectiveAnimationView.setComposition(c2272a);
            }
        });
        return new PageGuideDialogFragment(viewInflate, this.f14415y);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14396a(int OplusGLSurfaceView_13, View view, Activity activity) {
        if (OplusGLSurfaceView_13 == 1) {
            if (this.f14415y.mo10769bL().mo16570k() == 0) {
                return;
            }
            int i2 = ScreenModeConst.f16035b;
            int i3 = ScreenModeConst.f16034a;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i3);
            int i4 = i3 - i2;
            int i5 = (-i4) / 2;
            layoutParams.topMargin = i5;
            layoutParams.bottomMargin = i5;
            int i6 = i4 / 2;
            layoutParams.leftMargin = i6;
            layoutParams.rightMargin = i6;
            if (90 == this.f14415y.mo10769bL().mo16570k()) {
                view.setRotation(90.0f);
                view.setLayoutParams(layoutParams);
                return;
            } else {
                if (270 == this.f14415y.mo10769bL().mo16570k()) {
                    view.setRotation(270.0f);
                    view.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
        }
        if (OplusGLSurfaceView_13 != 4) {
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(Util.getScreenWidth(), -1);
        if (this.f14415y.mo10769bL().mo16570k() == 90) {
            view.setRotation(90.0f);
            layoutParams2.gravity = 3;
        } else {
            view.setRotation(270.0f);
            layoutParams2.gravity = 5;
        }
        view.setLayoutParams(layoutParams2);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id_renamed.guide_tips_container);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams3.addRule(12);
        layoutParams3.addRule(14);
        layoutParams3.bottomMargin = activity.getResources().getDimensionPixelSize(R.dimen.rack_mode_common_bottom_guide_tips_container_margin_bottom);
        linearLayout.setLayoutParams(layoutParams3);
        View viewFindViewById = view.findViewById(R.id_renamed.bottom_guide_effective_view);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams4.height = activity.getResources().getDimensionPixelSize(R.dimen.rack_mode_mode_edit_guide_webview_height);
        layoutParams4.addRule(12);
        layoutParams4.bottomMargin = activity.getResources().getDimensionPixelSize(R.dimen.rack_mode_common_bottom_guide_arrange_image_margin_bottom);
        viewFindViewById.setLayoutParams(layoutParams4);
    }

    /* renamed from: o */
    private PageGuideDialogFragment m14445o(Activity activity) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.common_bottom_guide_makeup_layout, (ViewGroup) null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id_renamed.makeup_compare);
        appCompatImageView.setOutlineProvider(new PlatformImplementations.kt_3());
        if (Util.m24494s(activity)) {
            appCompatImageView.setImageResource(R.drawable.guide_makeup_cn);
        } else {
            appCompatImageView.setImageResource(R.drawable.guide_makeup_exp);
        }
        return new PageGuideDialogFragment(viewInflate, this.f14415y);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14456a(Dialog dialog) {
        Window window = dialog.getWindow();
        window.setFlags(8, 8);
        if (30 < Build.VERSION.SDK_INT && Util.m24339ab()) {
            window.clearFlags(134217728);
            window.setFlags(1024, 1024);
            window.getDecorView().setSystemUiVisibility(5892);
            window.setNavigationBarContrastEnforced(false);
            window.setNavigationBarColor(0);
        } else {
            window.getDecorView().setSystemUiVisibility(1284);
            window.clearFlags(8);
        }
        dialog.show();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14457b() {
        m14403a(this.f14397g, 0);
        m14403a(this.f14398h, 0);
        m14398a(this.f14403m, 0);
        m14403a(this.f14399i, 0);
        m14403a(this.f14400j, 0);
        m14398a(this.f14404n, 0);
        m14398a(this.f14405o, 0);
        this.f14414x = null;
        m14460c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m14460c() {
        boolean z;
        PageGuideDialogFragment c3466s = this.f14397g;
        if (c3466s == null || !c3466s.m23912b()) {
            z = false;
        } else {
            this.f14397g.dismiss();
            z = true;
        }
        PageGuideDialogFragment c3466s2 = this.f14398h;
        if (c3466s2 != null && c3466s2.m23912b()) {
            this.f14398h.dismiss();
            z = true;
        }
        Dialog dialog = this.f14403m;
        if (dialog != null && dialog.isShowing()) {
            this.f14403m.dismiss();
            this.f14403m = null;
            z = true;
        }
        PageGuideDialogFragment c3466s3 = this.f14399i;
        if (c3466s3 != null && c3466s3.m23912b()) {
            this.f14399i.dismiss();
            this.f14399i = null;
            z = true;
        }
        PageGuideDialogFragment c3466s4 = this.f14402l;
        if (c3466s4 != null && c3466s4.m23912b()) {
            this.f14402l.dismiss();
            this.f14402l = null;
            z = true;
        }
        PageGuideDialogFragment c3466s5 = this.f14400j;
        if (c3466s5 != null && c3466s5.m23912b()) {
            this.f14400j.dismiss();
            this.f14400j = null;
            z = true;
        }
        Dialog dialog2 = this.f14404n;
        if (dialog2 != null && dialog2.isShowing()) {
            this.f14404n.dismiss();
            this.f14404n = null;
            z = true;
        }
        Dialog dialog3 = this.f14405o;
        if (dialog3 != null && dialog3.isShowing()) {
            this.f14405o.dismiss();
            this.f14405o = null;
            z = true;
        }
        CameraLog.m12959b(f14390e, "hideAllPopupWindow, isHide: " + z);
        return z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14398a(Dialog dialog, int OplusGLSurfaceView_13) {
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        dialog.getWindow().getDecorView().setAlpha(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14403a(DialogFragment dialogInterfaceOnCancelListenerC0580b, int OplusGLSurfaceView_13) {
        Dialog dialog;
        if (dialogInterfaceOnCancelListenerC0580b == null || (dialog = dialogInterfaceOnCancelListenerC0580b.getDialog()) == null || dialog.getWindow() == null) {
            return;
        }
        dialog.getWindow().getDecorView().setAlpha(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m14461d() {
        PageGuideDialogFragment c3466s = this.f14397g;
        if (c3466s != null) {
            return c3466s.m23912b();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14459c(Activity activity) {
        this.f14394D = true;
        PageGuideDialogFragment c3466s = this.f14397g;
        if (c3466s != null && c3466s.m23912b()) {
            this.f14397g.dismiss();
            this.f14397g = null;
            m14455a(activity, 1);
        } else {
            this.f14397g = null;
        }
        PageGuideDialogFragment c3466s2 = this.f14398h;
        if (c3466s2 != null && c3466s2.m23912b()) {
            this.f14398h.dismiss();
            this.f14398h = null;
            m14455a(activity, 2);
        }
        Dialog dialog = this.f14403m;
        if (dialog != null && dialog.isShowing()) {
            this.f14403m.dismiss();
            this.f14403m = null;
            m14455a(activity, 3);
        }
        PageGuideDialogFragment c3466s3 = this.f14399i;
        if (c3466s3 != null && c3466s3.m23912b()) {
            this.f14399i.dismiss();
            this.f14399i = null;
            m14455a(activity, 4);
        }
        PageGuideDialogFragment c3466s4 = this.f14401k;
        if (c3466s4 != null && c3466s4.m23912b()) {
            this.f14401k.dismiss();
            this.f14401k = null;
            m14455a(activity, 5);
        } else {
            this.f14401k = null;
        }
        Dialog dialog2 = this.f14404n;
        if (dialog2 != null && dialog2.isShowing()) {
            this.f14404n.dismiss();
            this.f14404n = null;
            m14455a(activity, 8);
        }
        PageGuideDialogFragment c3466s5 = this.f14400j;
        if (c3466s5 != null && c3466s5.m23912b()) {
            this.f14400j.dismiss();
            this.f14400j = null;
            m14455a(activity, 7);
        }
        Dialog dialog3 = this.f14405o;
        if (dialog3 == null || !dialog3.isShowing()) {
            return;
        }
        this.f14405o.dismiss();
        this.f14405o = null;
        m14455a(activity, 9);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m14462e() {
        PageGuideDialogFragment c3466s;
        TextureVideoView textureVideoView;
        PageGuideDialogFragment c3466s2 = this.f14397g;
        if (c3466s2 != null && c3466s2.m23912b() && (textureVideoView = this.f14410t) != null) {
            textureVideoView.start();
            this.f14410t.requestFocus();
        }
        if (this.f14411u == null || (c3466s = this.f14401k) == null || !c3466s.m23912b()) {
            return;
        }
        this.f14411u.m12890c();
        this.f14411u.m12888a();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m14463f() {
        PageGuideDialogFragment c3466s;
        CameraLog.m12959b(f14390e, "onPause");
        TextureVideoView textureVideoView = this.f14410t;
        if (textureVideoView != null) {
            textureVideoView.pause();
        }
        if (this.f14411u != null && (c3466s = this.f14401k) != null && c3466s.m23912b()) {
            this.f14411u.m12889b();
        }
        PageGuideDialogFragment c3466s2 = this.f14402l;
        if (c3466s2 == null || !c3466s2.m23912b()) {
            return;
        }
        this.f14402l.dismiss();
        this.f14402l = null;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m14464g() {
        CameraLog.m12959b(f14390e, "onDestroy");
        Handler handler = this.f14416z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Thread thread = this.f14413w;
        if (thread != null && thread.isAlive()) {
            this.f14413w.interrupt();
            this.f14413w = null;
        }
        this.f14414x = null;
        this.f14410t = null;
        this.f14397g = null;
        this.f14398h = null;
        this.f14403m = null;
        this.f14399i = null;
        this.f14402l = null;
        this.f14396f = null;
        this.f14401k = null;
        this.f14411u = null;
        this.f14406p = null;
        this.f14404n = null;
        this.f14405o = null;
    }

    /* renamed from: p */
    private void m14449p(final Activity activity) {
        if (this.f14402l == null) {
            this.f14402l = m14392a(activity, R.string.camera_mode_arrange_guide_title, R.string.camera_mode_drag_description);
            this.f14402l.m23911a(new PageGuideDialogFragment.PlatformImplementations.kt_3() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$i6OrcszzdMsv4IRziDTLrV1rg-COUIBaseListPopupWindow_11
                @Override // com.oplus.camera.p172ui.PageGuideDialogFragment.PlatformImplementations.kt_3
                public final void onGuideDialogShowAction() {
                    this.COUIBaseListPopupWindow_12$0.m14432j();
                }
            });
            this.f14402l.m23909a(new DialogInterface.OnDismissListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$FcTA2FNmiiB6Yf8tAVsnh5yy-Nc
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    CommonBottomGuide.m14397a(activity, dialogInterface);
                }
            });
        }
        if (this.f14402l.isAdded()) {
            return;
        }
        this.f14402l.show(((AppCompatActivity) activity).m3341j(), "showModeArrangeGuide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public /* synthetic */ void m14432j() {
        this.f14402l.m23908a().findViewById(R.id_renamed.guide_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.-$$Lambda$PlatformImplementations.kt_3$0GIqP9J_wosn9_UMppyDJMDLmbs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m14399a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m14399a(View view) {
        m14402a(this.f14402l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m14397a(Activity activity, DialogInterface dialogInterface) {
        PreferenceManager.m3981a(activity).edit().putBoolean("mode_arrange_reddot_show", false).apply();
    }

    /* renamed from: q */
    private void m14450q(Activity activity) {
        this.f14405o = m14451r(activity);
        if (this.f14405o.isShowing()) {
            return;
        }
        try {
            m14456a(this.f14405o);
        } catch (WindowManager.BadTokenException COUIBaseListPopupWindow_8) {
            if (this.f14405o.isShowing()) {
                this.f14405o.dismiss();
                this.f14405o = null;
            }
            CameraLog.m12966e(f14390e, "show3DPhotoGuide, exception: " + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    /* renamed from: r */
    private Dialog m14451r(Activity activity) {
        if (this.f14405o == null) {
            this.f14405o = new Dialog(activity, R.style.ProfessionalModeGuideTheme);
            this.f14405o.setContentView(R.layout.common_bottom_guide_3d_photo_layout);
            this.f14405o.setCanceledOnTouchOutside(true);
            this.f14405o.setCancelable(true);
            Window window = this.f14405o.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -1;
                attributes.windowAnimations = R.style.ProfessionalModeGuideDialog;
                window.setAttributes(attributes);
            }
            this.f14405o.findViewById(R.id_renamed.guide_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CommonBottomGuide.this.f14405o == null || !CommonBottomGuide.this.f14405o.isShowing()) {
                        return;
                    }
                    CommonBottomGuide.this.f14405o.dismiss();
                    CommonBottomGuide.this.f14405o = null;
                }
            });
            this.f14405o.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.16
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    CommonBottomGuide.this.f14405o = null;
                }
            });
            RecyclerView recyclerView = (RecyclerView) this.f14405o.findViewById(R.id_renamed.guide_content);
            recyclerView.setLayoutManager(new LinearLayoutManager(activity, 1, false));
            recyclerView.setAdapter(new GuideRecyclerViewAdapter(activity));
            if (Util.m24338aa()) {
                ((LinearLayoutCompat.C0277a) recyclerView.getLayoutParams()).bottomMargin = Util.m24198Z();
            }
        }
        return this.f14405o;
    }

    /* compiled from: CommonBottomGuide.java */
    /* renamed from: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        private Context f14449a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Handler f14450b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Uri f14451c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private ImageView f14452d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private Runnable f14453e;

        public IntrinsicsJvm.kt_4(Context context, Handler handler, Uri uri, ImageView imageView, Runnable runnable) {
            this.f14449a = context;
            this.f14450b = handler;
            this.f14451c = uri;
            this.f14452d = imageView;
            this.f14453e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() throws SecurityException, IOException, IllegalArgumentException {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f14449a, this.f14451c);
            try {
                try {
                    final Bitmap frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(2);
                    if (frameAtIndex != null && this.f14450b != null) {
                        this.f14450b.post(new Runnable() { // from class: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (IntrinsicsJvm.kt_4.this.f14452d != null) {
                                    IntrinsicsJvm.kt_4.this.f14452d.setVisibility(0);
                                    IntrinsicsJvm.kt_4.this.f14452d.setImageBitmap(frameAtIndex);
                                }
                            }
                        });
                        this.f14450b.post(this.f14453e);
                    }
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    CameraLog.m12967f(CommonBottomGuide.f14390e, "LoadThumbTask error " + COUIBaseListPopupWindow_8.toString());
                }
            } finally {
                mediaMetadataRetriever.close();
            }
        }
    }

    /* compiled from: CommonBottomGuide.java */
    /* renamed from: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public static class IntrinsicsJvm.kt_3 extends RecyclerView.AbstractC0685a<PlatformImplementations.kt_3> {

        /* renamed from: PlatformImplementations.kt_3 */
        private int[] f14456a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int[] f14457b;

        public IntrinsicsJvm.kt_3(int[] iArr, int[] iArr2) {
            this.f14456a = null;
            this.f14457b = null;
            this.f14456a = iArr;
            this.f14457b = iArr2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
            return new PlatformImplementations.kt_3(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.panel_guides_pager_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13) {
            Resources resources = aVar.m14468a().getContext().getResources();
            aVar.m14468a().setImageResource(this.f14457b[OplusGLSurfaceView_13]);
            aVar.m14468a().setContentDescription(resources.getString(this.f14456a[OplusGLSurfaceView_13]));
            aVar.m14469b().setText(this.f14456a[OplusGLSurfaceView_13]);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
        public int getItemCount() {
            return this.f14456a.length;
        }

        /* compiled from: CommonBottomGuide.java */
        /* renamed from: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
        public final class PlatformImplementations.kt_3 extends RecyclerView.AbstractC0707w {

            /* renamed from: IntrinsicsJvm.kt_4 */
            private final ImageView f14459b;

            /* renamed from: IntrinsicsJvm.kt_3 */
            private final AppCompatTextView f14460c;

            /* renamed from: PlatformImplementations.kt_3 */
            public final ImageView m14468a() {
                return this.f14459b;
            }

            /* renamed from: IntrinsicsJvm.kt_4 */
            public final AppCompatTextView m14469b() {
                return this.f14460c;
            }

            public PlatformImplementations.kt_3(View view) {
                super(view);
                this.f14459b = (ImageView) view.findViewById(R.id_renamed.pager_item_im);
                this.f14459b.setOutlineProvider(new PlatformImplementations.kt_3());
                this.f14460c = (AppCompatTextView) view.findViewById(R.id_renamed.guide_tips_tv);
            }
        }
    }

    /* compiled from: CommonBottomGuide.java */
    /* renamed from: com.oplus.camera.OplusGLSurfaceView_15.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends ViewOutlineProvider {
        private PlatformImplementations.kt_3() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int OplusGLSurfaceView_13 = marginLayoutParams.leftMargin;
            int i2 = marginLayoutParams.topMargin;
            rect.set(OplusGLSurfaceView_13, i2, (rect.right - rect.left) - OplusGLSurfaceView_13, (rect.bottom - rect.top) - i2);
            outline.setAlpha(0.93f);
            outline.setRoundRect(rect, view.getContext().getResources().getDimension(R.dimen.common_bottom_guide_background_radius));
            view.setClipToOutline(true);
        }
    }
}
