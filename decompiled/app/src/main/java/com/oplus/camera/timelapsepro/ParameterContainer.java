package com.oplus.camera.timelapsepro;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseTextView;
import com.oplus.camera.professional.ProfessionalAnimConstant;
import com.oplus.camera.professional.ProfessionalAnimUtil;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.statistics.model.TimeLapseProMsgData;
import com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar;
import com.oplus.camera.timelapsepro.adapter.ParamsAdapter;
import com.oplus.camera.timelapsepro.p170a.ProParameter;
import com.oplus.camera.util.Util;
import com.p078a.p079a.Spring;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ParameterContainer.java */
/* renamed from: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ParameterContainer extends RelativeLayout {

    /* renamed from: A */
    private PlatformImplementations.kt_3 f16756A;

    /* renamed from: B */
    private int f16757B;

    /* renamed from: C */
    private int f16758C;

    /* renamed from: D */
    private int f16759D;

    /* renamed from: E */
    private int f16760E;

    /* renamed from: F */
    private List<ProParameter> f16761F;

    /* renamed from: G */
    private Handler f16762G;

    /* renamed from: H */
    private boolean f16763H;

    /* renamed from: I */
    private boolean f16764I;

    /* renamed from: J */
    private boolean f16765J;

    /* renamed from: K */
    private ProParameter f16766K;

    /* renamed from: L */
    private ProParameter f16767L;

    /* renamed from: M */
    private ProParameter f16768M;

    /* renamed from: N */
    private ProParameter f16769N;

    /* renamed from: O */
    private ProParameter f16770O;

    /* renamed from: P */
    private ProParameter f16771P;

    /* renamed from: Q */
    private Map<String, String> f16772Q;

    /* renamed from: R */
    private boolean f16773R;

    /* renamed from: S */
    private View.OnTouchListener f16774S;

    /* renamed from: PlatformImplementations.kt_3 */
    private final ComboPreferences f16775a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f16776b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Spring f16777c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ParamsAdapter f16778d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Context f16779e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private COUIRecyclerView f16780f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private LinearLayoutManager f16781g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private RelativeLayout f16782h;

    /* renamed from: OplusGLSurfaceView_13 */
    private RelativeLayout f16783i;

    /* renamed from: OplusGLSurfaceView_15 */
    private RelativeLayout f16784j;

    /* renamed from: OplusGLSurfaceView_5 */
    private RelativeLayout f16785k;

    /* renamed from: OplusGLSurfaceView_14 */
    private RelativeLayout f16786l;

    /* renamed from: OplusGLSurfaceView_6 */
    private TimeLapseProParamScaleBar f16787m;

    /* renamed from: OplusGLSurfaceView_11 */
    private TimeLapseProParamScaleBar f16788n;

    /* renamed from: o */
    private TimeLapseProParamScaleBar f16789o;

    /* renamed from: p */
    private TimeLapseProParamScaleBar f16790p;

    /* renamed from: q */
    private TimeLapseProParamScaleBar f16791q;

    /* renamed from: r */
    private int f16792r;

    /* renamed from: s */
    private int f16793s;

    /* renamed from: t */
    private int f16794t;

    /* renamed from: u */
    private int f16795u;

    /* renamed from: v */
    private int f16796v;

    /* renamed from: w */
    private InverseTextView f16797w;

    /* renamed from: x */
    private InverseTextView f16798x;

    /* renamed from: y */
    private InverseTextView f16799y;

    /* renamed from: z */
    private InverseTextView f16800z;

    /* compiled from: ParameterContainer.java */
    /* renamed from: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17585a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17586a(String str, String str2);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17587a(String str, boolean z, String str2);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo17588b(String str, String str2);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo17589c(String str, String str2);

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo17590d(String str, String str2);
    }

    public ParameterContainer(Context context, ComboPreferences comboPreferences) {
        super(context);
        this.f16777c = ProfessionalAnimUtil.m15923a();
        this.f16792r = -1;
        this.f16793s = -1;
        this.f16794t = 0;
        this.f16795u = -1;
        this.f16796v = -1;
        this.f16757B = 0;
        this.f16759D = 2;
        this.f16760E = 0;
        this.f16761F = null;
        this.f16762G = null;
        this.f16763H = false;
        this.f16764I = false;
        this.f16765J = false;
        this.f16766K = null;
        this.f16767L = null;
        this.f16768M = null;
        this.f16769N = null;
        this.f16770O = null;
        this.f16771P = null;
        this.f16772Q = new HashMap();
        this.f16773R = false;
        this.f16774S = new View.OnTouchListener() { // from class: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    ProfessionalAnimUtil.m15924a(view, ParameterContainer.this.f16777c, true);
                } else if (action == 1 || action == 3) {
                    ProfessionalAnimUtil.m15924a(view, ParameterContainer.this.f16777c, false);
                }
                return false;
            }
        };
        this.f16779e = context;
        this.f16775a = comboPreferences;
        this.f16764I = false;
        View viewInflate = LayoutInflater.from(this.f16779e).inflate(R.layout.time_lapse_pro_param_container, this);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        m17548h();
        this.f16776b = getResources().getDimensionPixelOffset(R.dimen.blur_menu_animation_translation_y);
        this.f16780f = (COUIRecyclerView) viewInflate.findViewById(R.id_renamed.param_rv);
        this.f16780f.setItemViewCacheSize(-1);
        this.f16781g = new LinearLayoutManager(this.f16779e) { // from class: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4.7
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
            public boolean canScrollVertically() {
                return super.canScrollVertically();
            }
        };
        this.f16778d = new ParamsAdapter(this.f16779e);
        this.f16781g.setOrientation(0);
        this.f16780f.setLayoutManager(this.f16781g);
        this.f16778d.m17475a(new ParamsAdapter.InterfaceC3061a() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$IntrinsicsJvm.kt_4$8Eg7xdIZuFH1gRwibIbSBSXdYWc
            @Override // com.oplus.camera.timelapsepro.adapter.ParamsAdapter.InterfaceC3061a
            public final void clickItem(int OplusGLSurfaceView_13, ProParameter abstractC3051e) throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m17503a(OplusGLSurfaceView_13, abstractC3051e);
            }
        });
        this.f16778d.m17476a(new ParamsAdapter.InterfaceC3062b() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$IntrinsicsJvm.kt_4$9uAEfNDaxvrGpPkuCMWZtKuwjkM
            @Override // com.oplus.camera.timelapsepro.adapter.ParamsAdapter.InterfaceC3062b
            public final void onValueChanged(int OplusGLSurfaceView_13, int i2) {
                this.COUIBaseListPopupWindow_12$0.m17526b(OplusGLSurfaceView_13, i2);
            }
        });
        this.f16780f.setAdapter(this.f16778d);
        this.f16780f.setClipChildren(false);
        this.f16780f.setClipToPadding(false);
        this.f16762G = new Handler(Looper.myLooper()) { // from class: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4.8
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int OplusGLSurfaceView_13 = message.what;
                if (OplusGLSurfaceView_13 == 1) {
                    ParameterContainer.this.m17520a(true, message.arg1, message.arg2);
                } else {
                    if (OplusGLSurfaceView_13 != 2) {
                        return;
                    }
                    ParameterContainer.this.m17520a(false, message.arg1, message.arg2);
                }
            }
        };
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m17548h() {
        this.f16792r = m17523b("pref_time_lapse_pro_index_of_iso_key", -1);
        this.f16793s = m17523b("pref_time_lapse_pro_index_of_exposure_time_key", -1);
        this.f16794t = m17523b("pref_time_lapse_pro_index_of_exposure_compensation_key", TimeLapseProConstant.f16844a);
        this.f16795u = m17523b("pref_time_lapse_pro_index_of_focus_mode_key", -1);
        this.f16796v = m17523b("pref_time_lapse_pro_index_of_whitebalance_key", -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17517a(String str, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ParameterContainer", "putPreferenceInt, key: " + str + ", value: " + OplusGLSurfaceView_13);
        this.f16775a.edit().putInt(str, OplusGLSurfaceView_13).apply();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m17523b(String str, int OplusGLSurfaceView_13) {
        int i2 = this.f16775a.getInt(str, OplusGLSurfaceView_13);
        CameraLog.m12954a("ParameterContainer", "getPreferenceInt, value: " + i2);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17500a(int OplusGLSurfaceView_13) {
        m17501a(OplusGLSurfaceView_13, 1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17501a(int OplusGLSurfaceView_13, int i2) {
        m17502a(OplusGLSurfaceView_13, i2, 1000L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17502a(int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15) {
        if (this.f16762G.hasMessages(1)) {
            this.f16762G.removeMessages(1);
        }
        Handler handler = this.f16762G;
        handler.sendMessageDelayed(Message.obtain(handler, 1, OplusGLSurfaceView_13, i2), OplusGLSurfaceView_15);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17525b(int OplusGLSurfaceView_13) {
        if (this.f16762G.hasMessages(2)) {
            this.f16762G.removeMessages(2);
        }
        Handler handler = this.f16762G;
        handler.sendMessage(Message.obtain(handler, 2, OplusGLSurfaceView_13, 0));
        m17502a(OplusGLSurfaceView_13, 1, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17520a(boolean z, int OplusGLSurfaceView_13, int i2) {
        TimeLapseProParamScaleBar timeLapseProParamScaleBar;
        if (OplusGLSurfaceView_13 == 1) {
            TimeLapseProParamScaleBar timeLapseProParamScaleBar2 = this.f16787m;
            if (timeLapseProParamScaleBar2 != null && timeLapseProParamScaleBar2.isShown()) {
                this.f16787m.m17417a(z, true);
            }
        } else if (OplusGLSurfaceView_13 == 2) {
            TimeLapseProParamScaleBar timeLapseProParamScaleBar3 = this.f16788n;
            if (timeLapseProParamScaleBar3 != null && timeLapseProParamScaleBar3.isShown()) {
                this.f16788n.m17417a(z, true);
            }
        } else if (OplusGLSurfaceView_13 == 3) {
            TimeLapseProParamScaleBar timeLapseProParamScaleBar4 = this.f16789o;
            if (timeLapseProParamScaleBar4 != null && timeLapseProParamScaleBar4.isShown()) {
                this.f16789o.m17417a(z, true);
            }
        } else if (OplusGLSurfaceView_13 == 4) {
            TimeLapseProParamScaleBar timeLapseProParamScaleBar5 = this.f16790p;
            if (timeLapseProParamScaleBar5 != null && timeLapseProParamScaleBar5.isShown()) {
                this.f16790p.m17417a(z, true);
            }
        } else if (OplusGLSurfaceView_13 == 5 && (timeLapseProParamScaleBar = this.f16791q) != null && timeLapseProParamScaleBar.isShown()) {
            this.f16791q.m17417a(z, true);
        }
        if (1 == i2) {
            m17516a((String) null);
        }
    }

    private RelativeLayout.LayoutParams getScaleLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int OplusGLSurfaceView_13 = this.f16759D;
        if (1 == OplusGLSurfaceView_13) {
            layoutParams.addRule(15);
        } else if (4 == OplusGLSurfaceView_13) {
            layoutParams.width = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_scale_width_rack_screen);
            layoutParams.addRule(2, R.id_renamed.param_rv);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_params_scale_margin_bottom_rack_screen) - getResources().getDimensionPixelSize(R.dimen.blur_menu_seekbar_padding_bottom);
        } else {
            layoutParams.addRule(2, R.id_renamed.param_rv);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_params_scale_margin_bottom_rack_screen) - getResources().getDimensionPixelSize(R.dimen.blur_menu_seekbar_padding_bottom);
        }
        return layoutParams;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17514a(InverseTextView inverseTextView, boolean z) {
        m17515a(inverseTextView, z, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17515a(InverseTextView inverseTextView, boolean z, boolean z2) {
        TimeLapseAnimUtil.m17615a(inverseTextView, z, z2);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m17550i() {
        CameraLog.m12954a("ParameterContainer", "initIsoContainer.");
        this.f16782h = (RelativeLayout) LayoutInflater.from(this.f16779e).inflate(getScaleLayoutId(), (ViewGroup) this, false);
        this.f16782h.setVisibility(8);
        this.f16787m = (TimeLapseProParamScaleBar) this.f16782h.findViewById(R.id_renamed.scale_bar);
        this.f16797w = (InverseTextView) this.f16782h.findViewById(R.id_renamed.auto_btn);
        this.f16797w.setTypeface(Util.m24411c(true));
        this.f16797w.setTextSize(1, 12.0f);
        this.f16797w.setOnTouchListener(this.f16774S);
        if (4 == this.f16759D) {
            this.f16797w.setBackgroundResource(this.f16773R ? R.drawable.time_lapse_pro_auto_btn_bg_default : R.drawable.time_lapse_pro_auto_btn_bg_full_screen);
        }
        m17508a(this.f16787m);
        this.f16797w.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$IntrinsicsJvm.kt_4$CYQbdzb8AX5XQ0dKf15eQxut9x4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m17538d(view);
            }
        });
        if (this.f16761F != null) {
            this.f16797w.setInverseColor(this.f16767L.m17451g());
            InverseTextView inverseTextView = this.f16797w;
            m17515a(inverseTextView, inverseTextView.m20148a(), false);
            this.f16787m.m20766b(this.f16767L.m17458n());
            this.f16787m.setScaleSpace(10);
            this.f16787m.setValueList(this.f16767L.m17459o());
            this.f16787m.setCurrentIndex(this.f16767L.m17458n());
            this.f16787m.setScaleListener(new TimeLapseProParamScaleBar.InterfaceC3044b() { // from class: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4.9
                @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3044b
                public void onValueChanged(TimeLapseProParamScaleBar timeLapseProParamScaleBar, int OplusGLSurfaceView_13) {
                    ParameterContainer.this.f16767L.mo17435a(OplusGLSurfaceView_13);
                    if (!ParameterContainer.this.f16767L.m17451g()) {
                        ParameterContainer c3066b = ParameterContainer.this;
                        c3066b.m17518a(c3066b.f16767L.m17450f(), ParameterContainer.this.f16767L.mo17440d());
                        ParameterContainer c3066b2 = ParameterContainer.this;
                        c3066b2.m17517a("pref_time_lapse_pro_index_of_iso_key", c3066b2.f16767L.m17458n());
                    }
                    ParameterContainer.this.m17564p();
                    ParameterContainer.this.m17562o();
                    if (ParameterContainer.this.f16787m.isShown()) {
                        ParameterContainer.this.f16787m.m17419b(false);
                        ParameterContainer c3066b3 = ParameterContainer.this;
                        c3066b3.m17516a(c3066b3.f16767L.mo17441e());
                    }
                }
            });
            this.f16787m.setMoveListener(new ParameterContainer_3());
            if (!this.f16767L.m17451g()) {
                this.f16787m.m20768c(true);
                this.f16787m.m20766b(this.f16792r);
            }
        }
        addView(this.f16782h, getScaleLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m17538d(View view) {
        this.f16797w.setInverseColor(!r0.m20148a());
        this.f16767L.m17446a(this.f16797w.m20148a());
        this.f16787m.setAutoState(this.f16797w.m20148a());
        m17514a((InverseTextView) view, this.f16797w.m20148a());
        m17564p();
        m17562o();
        if (this.f16797w.m20148a()) {
            m17518a(this.f16767L.m17450f(), getResources().getString(R.string.camera_iso_default_value));
            m17517a("pref_time_lapse_pro_index_of_iso_key", -1);
            m17540d(TimeLapseProMsgData.KEY_TIMELAPSEPRO_ISO_VALUE, "auto");
        } else {
            m17517a("pref_time_lapse_pro_index_of_iso_key", this.f16767L.m17458n());
            m17525b(1);
            m17540d(TimeLapseProMsgData.KEY_TIMELAPSEPRO_ISO_VALUE, this.f16767L.mo17441e());
        }
    }

    /* compiled from: ParameterContainer.java */
    /* renamed from: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4$10, reason: invalid class name */
    class ParameterContainer_3 implements TimeLapseProParamScaleBar.InterfaceC3043a {
        ParameterContainer_3() {
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17427a(TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
            if (ParameterContainer.this.f16767L.m17451g()) {
                ParameterContainer.this.f16797w.performClick();
            }
            ParameterContainer.this.m17566q();
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17426a() {
            ParameterContainer.this.m17500a(1);
            ParameterContainer.this.f16762G.postDelayed(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$IntrinsicsJvm.kt_4$10$k_fg28HmsJnR3pX1UP7OIlpdnQA
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m17580b();
                }
            }, 50L);
            ParameterContainer c3066b = ParameterContainer.this;
            c3066b.m17536c(TimeLapseProMsgData.KEY_TIMELAPSEPRO_ISO_VALUE, c3066b.f16767L.mo17441e());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_4 */
        public /* synthetic */ void m17580b() {
            ParameterContainer.this.f16767L.m17449d(false);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m17552j() {
        CameraLog.m12954a("ParameterContainer", "initShutterContainer.");
        this.f16783i = (RelativeLayout) LayoutInflater.from(this.f16779e).inflate(getScaleLayoutId(), (ViewGroup) this, false);
        this.f16783i.setVisibility(8);
        this.f16788n = (TimeLapseProParamScaleBar) this.f16783i.findViewById(R.id_renamed.scale_bar);
        this.f16798x = (InverseTextView) this.f16783i.findViewById(R.id_renamed.auto_btn);
        this.f16798x.setTypeface(Util.m24411c(true));
        this.f16798x.setTextSize(1, 12.0f);
        this.f16798x.setOnTouchListener(this.f16774S);
        if (4 == this.f16759D) {
            this.f16798x.setBackgroundResource(this.f16773R ? R.drawable.time_lapse_pro_auto_btn_bg_default : R.drawable.time_lapse_pro_auto_btn_bg_full_screen);
        }
        m17508a(this.f16788n);
        this.f16798x.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$IntrinsicsJvm.kt_4$Ap44TBEX-Tddfp0NygY42bbbYn4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m17533c(view);
            }
        });
        if (this.f16761F != null) {
            this.f16798x.setInverseColor(this.f16768M.m17451g());
            InverseTextView inverseTextView = this.f16798x;
            m17515a(inverseTextView, inverseTextView.m20148a(), false);
            this.f16788n.m20766b(this.f16768M.m17458n());
            this.f16788n.setScaleSpace(10);
            this.f16788n.setValueList(this.f16768M.m17459o());
            this.f16788n.setCurrentIndex(this.f16768M.m17458n());
            this.f16788n.setScaleListener(new TimeLapseProParamScaleBar.InterfaceC3044b() { // from class: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4.11
                @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3044b
                public void onValueChanged(TimeLapseProParamScaleBar timeLapseProParamScaleBar, int OplusGLSurfaceView_13) {
                    ParameterContainer.this.f16768M.mo17435a(OplusGLSurfaceView_13);
                    if (!ParameterContainer.this.f16768M.m17451g()) {
                        ParameterContainer c3066b = ParameterContainer.this;
                        c3066b.m17518a(c3066b.f16768M.m17450f(), ParameterContainer.this.f16768M.mo17440d());
                        ParameterContainer c3066b2 = ParameterContainer.this;
                        c3066b2.m17517a("pref_time_lapse_pro_index_of_exposure_time_key", c3066b2.f16768M.m17458n());
                    }
                    ParameterContainer.this.m17564p();
                    ParameterContainer.this.m17562o();
                    if (ParameterContainer.this.f16788n.isShown()) {
                        ParameterContainer.this.f16788n.m17419b(false);
                        String strMo17441e = ParameterContainer.this.f16768M.mo17441e();
                        ParameterContainer.this.m17530b(strMo17441e.substring(0, strMo17441e.length() - 1), strMo17441e.substring(strMo17441e.length() - 1));
                    }
                }
            });
            this.f16788n.setMoveListener(new CameraUIManager_2());
            if (!this.f16768M.m17451g()) {
                this.f16788n.m20768c(true);
                this.f16788n.m20766b(this.f16793s);
            }
        }
        addView(this.f16783i, getScaleLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m17533c(View view) {
        this.f16798x.setInverseColor(!r0.m20148a());
        this.f16768M.m17446a(this.f16798x.m20148a());
        this.f16788n.setAutoState(this.f16798x.m20148a());
        m17514a((InverseTextView) view, this.f16798x.m20148a());
        m17564p();
        m17562o();
        if (this.f16798x.m20148a()) {
            m17518a(this.f16768M.m17450f(), getResources().getString(R.string.camera_exposure_time_default_value));
            m17517a("pref_time_lapse_pro_index_of_exposure_time_key", -1);
            m17540d(TimeLapseProMsgData.KEY_TIMELAPSEPRO_EXPOSURE_TIME, "auto");
        } else {
            m17517a("pref_time_lapse_pro_index_of_exposure_time_key", this.f16768M.m17458n());
            m17525b(2);
            m17540d(TimeLapseProMsgData.KEY_TIMELAPSEPRO_EXPOSURE_TIME, this.f16768M.mo17441e());
        }
    }

    /* compiled from: ParameterContainer.java */
    /* renamed from: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4$12, reason: invalid class name */
    class CameraUIManager_2 implements TimeLapseProParamScaleBar.InterfaceC3043a {
        CameraUIManager_2() {
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17427a(TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
            if (ParameterContainer.this.f16768M.m17451g()) {
                ParameterContainer.this.f16798x.performClick();
            }
            ParameterContainer.this.m17566q();
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17426a() {
            ParameterContainer.this.m17500a(2);
            ParameterContainer.this.f16762G.postDelayed(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$IntrinsicsJvm.kt_4$12$WNHMVRniA9Lw-laBYlHnDSjfqCs
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m17581b();
                }
            }, 50L);
            ParameterContainer c3066b = ParameterContainer.this;
            c3066b.m17536c(TimeLapseProMsgData.KEY_TIMELAPSEPRO_EXPOSURE_TIME, c3066b.f16768M.mo17441e());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_4 */
        public /* synthetic */ void m17581b() {
            ParameterContainer.this.f16768M.m17449d(false);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m17554k() {
        CameraLog.m12954a("ParameterContainer", "initEvContainer.");
        this.f16784j = (RelativeLayout) LayoutInflater.from(this.f16779e).inflate(getScaleLayoutId(), (ViewGroup) this, false);
        this.f16784j.setVisibility(8);
        this.f16789o = (TimeLapseProParamScaleBar) this.f16784j.findViewById(R.id_renamed.scale_bar);
        this.f16784j.findViewById(R.id_renamed.auto_btn).setVisibility(8);
        m17508a(this.f16789o);
        if (this.f16761F != null) {
            this.f16789o.m20766b(this.f16769N.m17458n());
            this.f16789o.m17415a(10, 2);
            this.f16789o.setValueList(this.f16769N.m17459o());
            this.f16789o.m20768c(true);
            this.f16789o.setCurrentIndex(this.f16769N.m17458n());
            this.f16789o.setScaleListener(new TimeLapseProParamScaleBar.InterfaceC3044b() { // from class: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4.13
                @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3044b
                public void onValueChanged(TimeLapseProParamScaleBar timeLapseProParamScaleBar, int OplusGLSurfaceView_13) {
                    ParameterContainer.this.f16769N.mo17435a(OplusGLSurfaceView_13);
                    if (!ParameterContainer.this.f16769N.m17451g()) {
                        ParameterContainer c3066b = ParameterContainer.this;
                        c3066b.m17518a(c3066b.f16769N.m17450f(), ParameterContainer.this.f16769N.mo17440d());
                        ParameterContainer c3066b2 = ParameterContainer.this;
                        c3066b2.m17517a("pref_time_lapse_pro_index_of_exposure_compensation_key", c3066b2.f16769N.m17458n());
                    }
                    ParameterContainer c3066b3 = ParameterContainer.this;
                    c3066b3.f16758C = c3066b3.f16769N.m17458n();
                    ParameterContainer.this.m17564p();
                    ParameterContainer.this.m17562o();
                    if (ParameterContainer.this.f16789o.isShown()) {
                        ParameterContainer.this.f16789o.m17419b(false);
                        ParameterContainer c3066b4 = ParameterContainer.this;
                        c3066b4.m17516a(c3066b4.f16769N.mo17441e());
                    }
                }
            });
            this.f16789o.setMoveListener(new ParameterContainer_5());
        }
        addView(this.f16784j, getScaleLayoutParams());
    }

    /* compiled from: ParameterContainer.java */
    /* renamed from: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4$14, reason: invalid class name */
    class ParameterContainer_5 implements TimeLapseProParamScaleBar.InterfaceC3043a {
        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17427a(TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
        }

        ParameterContainer_5() {
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17426a() {
            ParameterContainer.this.m17500a(3);
            ParameterContainer.this.f16762G.postDelayed(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$IntrinsicsJvm.kt_4$14$_BBpe9w6y_keVJuKbA9m1R2QXaU
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m17582b();
                }
            }, 50L);
            if (ParameterContainer.this.f16769N.mo17440d().equals(ParameterContainer.this.getResources().getString(R.string.camera_exposure_compensation_default_value))) {
                ParameterContainer.this.m17536c(TimeLapseProMsgData.KEY_TIMELAPSEPRO_EXPOSURE_COMPENSATION, "auto");
            } else {
                ParameterContainer c3066b = ParameterContainer.this;
                c3066b.m17536c(TimeLapseProMsgData.KEY_TIMELAPSEPRO_EXPOSURE_COMPENSATION, c3066b.f16769N.mo17441e());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_4 */
        public /* synthetic */ void m17582b() {
            ParameterContainer.this.f16769N.m17449d(false);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m17556l() {
        CameraLog.m12954a("ParameterContainer", "initFocusContainer.");
        this.f16785k = (RelativeLayout) LayoutInflater.from(this.f16779e).inflate(getScaleLayoutId(), (ViewGroup) this, false);
        this.f16785k.setVisibility(8);
        this.f16790p = (TimeLapseProParamScaleBar) this.f16785k.findViewById(R.id_renamed.scale_bar);
        this.f16799y = (InverseTextView) this.f16785k.findViewById(R.id_renamed.auto_btn);
        this.f16799y.setTypeface(Util.m24411c(true));
        this.f16799y.setTextSize(1, 12.0f);
        this.f16799y.setOnTouchListener(this.f16774S);
        if (4 == this.f16759D) {
            this.f16799y.setBackgroundResource(this.f16773R ? R.drawable.time_lapse_pro_auto_btn_bg_default : R.drawable.time_lapse_pro_auto_btn_bg_full_screen);
        }
        m17508a(this.f16790p);
        this.f16799y.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$IntrinsicsJvm.kt_4$ovlCsbMe7pXmOu3t-Y-eH-eZzTA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m17527b(view);
            }
        });
        if (this.f16761F != null) {
            this.f16799y.setInverseColor(this.f16770O.m17451g());
            InverseTextView inverseTextView = this.f16799y;
            m17515a(inverseTextView, inverseTextView.m20148a(), false);
            this.f16790p.m20766b(this.f16770O.m17458n());
            this.f16790p.setScaleSpace(10);
            this.f16790p.setValueList(this.f16770O.m17459o());
            this.f16790p.setCurrentIndex(this.f16770O.m17458n());
            this.f16790p.setScaleListener(new TimeLapseProParamScaleBar.InterfaceC3044b() { // from class: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4.2
                @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3044b
                public void onValueChanged(TimeLapseProParamScaleBar timeLapseProParamScaleBar, int OplusGLSurfaceView_13) {
                    ParameterContainer.this.f16770O.mo17435a(OplusGLSurfaceView_13);
                    if (!ParameterContainer.this.f16770O.m17451g()) {
                        ParameterContainer c3066b = ParameterContainer.this;
                        c3066b.m17518a(c3066b.f16770O.m17450f(), ParameterContainer.this.f16770O.mo17440d());
                        ParameterContainer c3066b2 = ParameterContainer.this;
                        c3066b2.m17517a("pref_time_lapse_pro_index_of_focus_mode_key", c3066b2.f16770O.m17458n());
                    }
                    ParameterContainer.this.m17562o();
                    if (ParameterContainer.this.f16790p.isShown()) {
                        ParameterContainer.this.f16790p.m17419b(false);
                        ParameterContainer c3066b3 = ParameterContainer.this;
                        c3066b3.m17516a(c3066b3.f16770O.mo17441e());
                    }
                }
            });
            this.f16790p.setMoveListener(new ZoomSeekBar_4());
            if (!this.f16770O.m17451g()) {
                this.f16790p.m20768c(true);
                this.f16790p.m20766b(this.f16795u);
            }
        }
        addView(this.f16785k, getScaleLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m17527b(View view) {
        this.f16799y.setInverseColor(!r0.m20148a());
        this.f16770O.m17446a(this.f16799y.m20148a());
        this.f16790p.setAutoState(this.f16799y.m20148a());
        m17514a((InverseTextView) view, this.f16799y.m20148a());
        m17564p();
        m17562o();
        if (this.f16799y.m20148a()) {
            m17518a(this.f16770O.m17450f(), getResources().getString(R.string.camera_focus_mode_default_value));
            m17517a("pref_time_lapse_pro_index_of_focus_mode_key", -1);
            m17540d(TimeLapseProMsgData.KEY_TIMELAPSEPRO_FOCUS_VALUE, "auto");
        } else {
            m17517a("pref_time_lapse_pro_index_of_focus_mode_key", this.f16770O.m17458n());
            m17525b(4);
            m17540d(TimeLapseProMsgData.KEY_TIMELAPSEPRO_FOCUS_VALUE, this.f16768M.mo17441e());
        }
    }

    /* compiled from: ParameterContainer.java */
    /* renamed from: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4$3, reason: invalid class name */
    class ZoomSeekBar_4 implements TimeLapseProParamScaleBar.InterfaceC3043a {
        ZoomSeekBar_4() {
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17427a(TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
            if (ParameterContainer.this.f16770O.m17451g()) {
                ParameterContainer.this.f16799y.performClick();
            }
            ParameterContainer.this.m17566q();
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17426a() {
            ParameterContainer.this.m17500a(4);
            ParameterContainer.this.f16762G.postDelayed(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$IntrinsicsJvm.kt_4$3$qIOm-k1f2VabT7LfoB-qwgpJ614
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m17583b();
                }
            }, 50L);
            ParameterContainer c3066b = ParameterContainer.this;
            c3066b.m17536c(TimeLapseProMsgData.KEY_TIMELAPSEPRO_FOCUS_VALUE, c3066b.f16770O.mo17441e());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_4 */
        public /* synthetic */ void m17583b() {
            ParameterContainer.this.f16770O.m17449d(false);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m17558m() {
        CameraLog.m12954a("ParameterContainer", "initWbContainer.");
        this.f16786l = (RelativeLayout) LayoutInflater.from(this.f16779e).inflate(getScaleLayoutId(), (ViewGroup) this, false);
        this.f16786l.setVisibility(8);
        this.f16791q = (TimeLapseProParamScaleBar) this.f16786l.findViewById(R.id_renamed.scale_bar);
        this.f16800z = (InverseTextView) this.f16786l.findViewById(R.id_renamed.auto_btn);
        this.f16800z.setTypeface(Util.m24411c(true));
        this.f16800z.setTextSize(1, 12.0f);
        this.f16800z.setOnTouchListener(this.f16774S);
        if (4 == this.f16759D) {
            this.f16800z.setBackgroundResource(this.f16773R ? R.drawable.time_lapse_pro_auto_btn_bg_default : R.drawable.time_lapse_pro_auto_btn_bg_full_screen);
        }
        m17508a(this.f16791q);
        this.f16800z.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$IntrinsicsJvm.kt_4$YPZHG20aPbfopjBzaNxik_rM3gk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m17504a(view);
            }
        });
        if (this.f16761F != null) {
            this.f16800z.setInverseColor(this.f16771P.m17451g());
            InverseTextView inverseTextView = this.f16800z;
            m17515a(inverseTextView, inverseTextView.m20148a(), false);
            this.f16791q.m20766b(this.f16771P.m17458n());
            this.f16791q.setScaleSpace(10);
            this.f16791q.setValueList(this.f16771P.m17459o());
            this.f16791q.setCurrentIndex(this.f16771P.m17458n());
            this.f16791q.setScaleListener(new TimeLapseProParamScaleBar.InterfaceC3044b() { // from class: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4.4
                @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3044b
                public void onValueChanged(TimeLapseProParamScaleBar timeLapseProParamScaleBar, int OplusGLSurfaceView_13) {
                    ParameterContainer.this.f16771P.mo17435a(OplusGLSurfaceView_13);
                    if (!ParameterContainer.this.f16771P.m17451g()) {
                        ParameterContainer c3066b = ParameterContainer.this;
                        c3066b.m17518a(c3066b.f16771P.m17450f(), ParameterContainer.this.f16771P.mo17440d());
                        ParameterContainer c3066b2 = ParameterContainer.this;
                        c3066b2.m17517a("pref_time_lapse_pro_index_of_whitebalance_key", c3066b2.f16771P.m17458n());
                    }
                    ParameterContainer.this.m17562o();
                    if (ParameterContainer.this.f16791q.isShown()) {
                        ParameterContainer.this.f16791q.m17419b(false);
                        String strMo17441e = ParameterContainer.this.f16771P.mo17441e();
                        ParameterContainer.this.m17530b(strMo17441e.substring(0, strMo17441e.length() - 1), strMo17441e.substring(strMo17441e.length() - 1));
                    }
                }
            });
            this.f16791q.setMoveListener(new MoreUIControl_7());
            if (!this.f16771P.m17451g()) {
                this.f16791q.m20768c(true);
                this.f16791q.m20766b(this.f16796v);
            }
        }
        addView(this.f16786l, getScaleLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m17504a(View view) {
        this.f16800z.setInverseColor(!r0.m20148a());
        this.f16771P.m17446a(this.f16800z.m20148a());
        this.f16791q.setAutoState(this.f16800z.m20148a());
        m17514a((InverseTextView) view, this.f16800z.m20148a());
        m17564p();
        m17562o();
        if (this.f16800z.m20148a()) {
            m17518a(this.f16771P.m17450f(), getResources().getString(R.string.camera_whitebalance_default_value));
            m17517a("pref_time_lapse_pro_index_of_whitebalance_key", -1);
            m17540d(TimeLapseProMsgData.KEY_TIMELAPSEPRO_WHITE_BALANCE, "auto");
        } else {
            m17517a("pref_time_lapse_pro_index_of_whitebalance_key", this.f16771P.m17458n());
            m17525b(5);
            m17540d(TimeLapseProMsgData.KEY_TIMELAPSEPRO_WHITE_BALANCE, this.f16771P.mo17441e());
        }
    }

    /* compiled from: ParameterContainer.java */
    /* renamed from: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4$5, reason: invalid class name */
    class MoreUIControl_7 implements TimeLapseProParamScaleBar.InterfaceC3043a {
        MoreUIControl_7() {
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17427a(TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
            if (ParameterContainer.this.f16771P.m17451g()) {
                ParameterContainer.this.f16800z.performClick();
            }
            ParameterContainer.this.m17566q();
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17426a() {
            ParameterContainer.this.m17500a(5);
            ParameterContainer.this.f16762G.postDelayed(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$IntrinsicsJvm.kt_4$5$4ukiWCupQF0fVqJGYj2m3cNxiIg
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m17584b();
                }
            }, 50L);
            ParameterContainer c3066b = ParameterContainer.this;
            c3066b.m17536c(TimeLapseProMsgData.KEY_TIMELAPSEPRO_WHITE_BALANCE, c3066b.f16771P.mo17441e());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_4 */
        public /* synthetic */ void m17584b() {
            ParameterContainer.this.f16771P.m17449d(false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17508a(TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
        if (1 == this.f16759D) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) timeLapseProParamScaleBar.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_params_container_margin_top_full_screen);
            if (this.f16760E == 270) {
                layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_params_scale_margin_vertical);
            } else {
                layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_params_scale_margin_vertical);
            }
        }
    }

    private int getScaleLayoutId() {
        CameraLog.m12954a("ParameterContainer", "getScaleLayoutId, mScreenLayoutMode : " + this.f16759D + ", mModeOrientation : " + this.f16760E);
        return 1 == this.f16759D ? 270 == this.f16760E ? R.layout.time_lapse_pro_scale_bar_vertical_270 : R.layout.time_lapse_pro_scale_bar_vertical : R.layout.time_lapse_pro_scale_bar_default;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17571a() {
        CameraLog.m12954a("ParameterContainer", "clearScales.");
        RelativeLayout relativeLayout = this.f16782h;
        if (relativeLayout != null) {
            removeView(relativeLayout);
            this.f16782h = null;
        }
        RelativeLayout relativeLayout2 = this.f16783i;
        if (relativeLayout2 != null) {
            removeView(relativeLayout2);
            this.f16783i = null;
        }
        RelativeLayout relativeLayout3 = this.f16784j;
        if (relativeLayout3 != null) {
            removeView(relativeLayout3);
            this.f16784j = null;
        }
        RelativeLayout relativeLayout4 = this.f16785k;
        if (relativeLayout4 != null) {
            removeView(relativeLayout4);
            this.f16785k = null;
        }
        RelativeLayout relativeLayout5 = this.f16786l;
        if (relativeLayout5 != null) {
            removeView(relativeLayout5);
            this.f16786l = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17573a(BaseScreenMode abstractC2934a, int OplusGLSurfaceView_13, int i2) {
        ParamsAdapter paramsAdapter = this.f16778d;
        if (paramsAdapter != null) {
            paramsAdapter.m17488a(abstractC2934a, OplusGLSurfaceView_13, i2);
        }
        this.f16759D = OplusGLSurfaceView_13;
        this.f16760E = i2;
        this.f16773R = abstractC2934a.mo16630q();
        m17571a();
        if (OplusGLSurfaceView_13 == 1) {
            m17532c(i2);
            this.f16780f.setVerticalFadingEdgeEnabled(true);
            this.f16780f.setFadingEdgeLength(getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_params_fading_length));
        } else if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 4) {
            this.f16780f.setVerticalFadingEdgeEnabled(false);
            m17560n();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17532c(int OplusGLSurfaceView_13) {
        this.f16781g.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f16780f.getLayoutParams();
        layoutParams.removeRule(9);
        layoutParams.removeRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_params_container_options_margin_top_full_screen);
        layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_params_container_options_margin_bottom_full_screen);
        if (270 == OplusGLSurfaceView_13) {
            layoutParams.addRule(11);
            layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_params_container_margin_start_full_screen);
        } else {
            layoutParams.addRule(9);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_params_container_margin_start_full_screen);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m17560n() {
        this.f16781g.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f16780f.getLayoutParams();
        layoutParams.height = -2;
        layoutParams.removeRule(10);
        layoutParams.removeRule(9);
        layoutParams.removeRule(11);
        layoutParams.setMargins(0, 0, 0, 0);
    }

    public void setParamList(List<ProParameter> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f16761F = list;
        this.f16766K = this.f16761F.get(0);
        this.f16767L = this.f16761F.get(1);
        this.f16768M = this.f16761F.get(2);
        this.f16769N = this.f16761F.get(3);
        this.f16770O = this.f16761F.get(4);
        this.f16771P = this.f16761F.get(5);
        this.f16758C = this.f16769N.m17458n();
        this.f16778d.m17490a(this.f16761F);
        this.f16764I = true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m17574b() {
        return this.f16764I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m17562o() {
        if (this.f16761F == null || this.f16766K == null) {
            return;
        }
        boolean zM17451g = true;
        for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < this.f16761F.size(); OplusGLSurfaceView_13++) {
            if (3 == OplusGLSurfaceView_13) {
                zM17451g = this.f16761F.get(OplusGLSurfaceView_13).mo17440d().equals(getResources().getString(R.string.camera_exposure_compensation_default_value));
            } else {
                zM17451g = this.f16761F.get(OplusGLSurfaceView_13).m17451g();
            }
            if (!zM17451g) {
                break;
            }
        }
        this.f16766K.m17447b(zM17451g ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m17564p() {
        ProParameter abstractC3051e;
        if (this.f16761F == null || this.f16769N == null || (abstractC3051e = this.f16767L) == null || this.f16768M == null) {
            return;
        }
        if (!abstractC3051e.m17451g() && !this.f16768M.m17451g()) {
            this.f16769N.mo17438b();
            this.f16769N.mo17436a("-");
            this.f16769N.m17447b(false);
            m17518a(this.f16769N.m17450f(), getResources().getString(R.string.camera_exposure_compensation_default_value));
            return;
        }
        this.f16769N.mo17435a(this.f16758C);
        this.f16769N.m17447b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17526b(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("ParameterContainer", "onParamValueChanged, scale scroll position: " + OplusGLSurfaceView_13 + ", index: " + i2);
        if (OplusGLSurfaceView_13 == 1) {
            if (m17531b(this.f16787m)) {
                this.f16787m.m20766b(i2);
            }
        } else if (OplusGLSurfaceView_13 == 2) {
            if (m17531b(this.f16788n)) {
                this.f16788n.m20766b(i2);
            }
        } else if (OplusGLSurfaceView_13 == 4) {
            if (m17531b(this.f16790p)) {
                this.f16790p.m20766b(i2);
            }
        } else if (OplusGLSurfaceView_13 == 5 && m17531b(this.f16791q)) {
            this.f16791q.m20766b(i2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m17531b(TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
        return timeLapseProParamScaleBar != null && timeLapseProParamScaleBar.isShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m17503a(int r10, com.oplus.camera.timelapsepro.p170a.ProParameter r11) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.timelapsepro.ParameterContainer.m17503a(int, com.oplus.camera.timelapsepro.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8):void");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TimeLapseProParamScaleBar m17537d(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1) {
            return this.f16787m;
        }
        if (OplusGLSurfaceView_13 == 2) {
            return this.f16788n;
        }
        if (OplusGLSurfaceView_13 == 3) {
            return this.f16789o;
        }
        if (OplusGLSurfaceView_13 == 4) {
            return this.f16790p;
        }
        if (OplusGLSurfaceView_13 != 5) {
            return null;
        }
        return this.f16791q;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private InverseTextView m17542e(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1) {
            return this.f16797w;
        }
        if (OplusGLSurfaceView_13 == 2) {
            return this.f16798x;
        }
        if (OplusGLSurfaceView_13 == 4) {
            return this.f16799y;
        }
        if (OplusGLSurfaceView_13 != 5) {
            return null;
        }
        return this.f16800z;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String m17544f(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1) {
            return getResources().getString(R.string.camera_iso_default_value);
        }
        if (OplusGLSurfaceView_13 == 2) {
            return getResources().getString(R.string.camera_exposure_time_default_value);
        }
        if (OplusGLSurfaceView_13 == 3) {
            return getResources().getString(R.string.camera_exposure_compensation_default_value);
        }
        if (OplusGLSurfaceView_13 == 4) {
            return getResources().getString(R.string.camera_focus_mode_default_value);
        }
        if (OplusGLSurfaceView_13 != 5) {
            return null;
        }
        return getResources().getString(R.string.camera_whitebalance_default_value);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m17545g(int OplusGLSurfaceView_13) {
        if (this.f16761F == null) {
            return;
        }
        if (this.f16782h != null && this.f16767L != null) {
            this.f16787m.m17419b(false);
            this.f16797w.setInverseColor(this.f16767L.m17451g());
            m17507a(this.f16782h, OplusGLSurfaceView_13 == 1, OplusGLSurfaceView_13 == 1);
        }
        if (this.f16783i != null && this.f16768M != null) {
            this.f16788n.m17419b(false);
            this.f16798x.setInverseColor(this.f16768M.m17451g());
            m17507a(this.f16783i, OplusGLSurfaceView_13 == 2, OplusGLSurfaceView_13 == 2);
        }
        if (this.f16784j != null) {
            this.f16789o.m17419b(false);
            m17507a(this.f16784j, OplusGLSurfaceView_13 == 3, OplusGLSurfaceView_13 == 3);
        }
        if (this.f16785k != null && this.f16770O != null) {
            this.f16790p.m17419b(false);
            this.f16799y.setInverseColor(this.f16770O.m17451g());
            m17507a(this.f16785k, OplusGLSurfaceView_13 == 4, OplusGLSurfaceView_13 == 4);
        }
        if (this.f16786l != null && this.f16771P != null) {
            this.f16791q.m17419b(false);
            this.f16800z.setInverseColor(this.f16771P.m17451g());
            m17507a(this.f16786l, OplusGLSurfaceView_13 == 5, OplusGLSurfaceView_13 == 5);
        }
        m17500a(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17507a(RelativeLayout relativeLayout, boolean z, boolean z2) {
        if (!z2) {
            int OplusGLSurfaceView_13 = 8;
            if (z && !relativeLayout.isShown()) {
                OplusGLSurfaceView_13 = 0;
            }
            relativeLayout.setVisibility(OplusGLSurfaceView_13);
            if (OplusGLSurfaceView_13 == 0) {
                this.f16765J = true;
                return;
            }
            return;
        }
        if (z) {
            if (!relativeLayout.isShown()) {
                m17506a(relativeLayout, !this.f16765J);
                return;
            } else {
                m17528b(relativeLayout, true);
                this.f16765J = false;
                return;
            }
        }
        if (relativeLayout.isShown()) {
            m17528b(relativeLayout, !this.f16765J);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17506a(RelativeLayout relativeLayout, boolean z) {
        this.f16765J = true;
        m17505a((View) relativeLayout, true, z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17528b(RelativeLayout relativeLayout, boolean z) {
        m17505a((View) relativeLayout, false, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17505a(final View view, final boolean z, final boolean z2) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        if (view == null) {
            return;
        }
        if (z) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        }
        objectAnimatorOfFloat.setInterpolator(ProfessionalAnimConstant.f15694a);
        objectAnimatorOfFloat.setDuration(z ? 400L : 250L);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder builderPlay = animatorSet.play(objectAnimatorOfFloat);
        float COUIBaseListPopupWindow_12 = this.f16776b;
        if (z2) {
            String str = "translationX";
            if (1 != this.f16759D) {
                str = "translationY";
            } else if (270 != this.f16760E) {
                COUIBaseListPopupWindow_12 = -COUIBaseListPopupWindow_12;
            }
            if (z) {
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, str, COUIBaseListPopupWindow_12, 0.0f);
            } else {
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, str, 0.0f, COUIBaseListPopupWindow_12);
            }
            objectAnimatorOfFloat2.setInterpolator(ProfessionalAnimConstant.f15695b);
            objectAnimatorOfFloat2.setDuration(400L);
            builderPlay.with(objectAnimatorOfFloat2);
            if (z) {
                animatorSet.setStartDelay(150L);
            }
        }
        final float f2 = COUIBaseListPopupWindow_12;
        final boolean zIsEnabled = view.isEnabled();
        this.f16780f.setEnabled(false);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_4.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ParameterContainer.this.f16763H = true;
                view.setAlpha(z ? 0.0f : 1.0f);
                if (z2) {
                    if (1 == ParameterContainer.this.f16759D) {
                        view.setTranslationX(z ? f2 : 0.0f);
                    } else {
                        view.setTranslationY(z ? f2 : 0.0f);
                    }
                }
                view.setVisibility(0);
                view.setEnabled(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (z) {
                    view.setAlpha(0.0f);
                    view.setVisibility(8);
                } else {
                    view.setAlpha(1.0f);
                    view.setVisibility(0);
                }
                if (z2) {
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                }
                view.setEnabled(zIsEnabled);
                ParameterContainer.this.f16763H = false;
                ParameterContainer.this.f16780f.setEnabled(true);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!z) {
                    view.setVisibility(8);
                }
                view.setEnabled(zIsEnabled);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                ParameterContainer.this.f16763H = false;
                ParameterContainer.this.f16780f.setEnabled(true);
            }
        });
        animatorSet.start();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m17575c() {
        removeAllViews();
        this.f16779e = null;
        COUIRecyclerView cOUIRecyclerView = this.f16780f;
        if (cOUIRecyclerView != null) {
            cOUIRecyclerView.setAdapter(null);
            ParamsAdapter paramsAdapter = this.f16778d;
            if (paramsAdapter != null) {
                paramsAdapter.mo17470a();
                this.f16778d = null;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m17576d() {
        ProParameter abstractC3051e = this.f16766K;
        if (abstractC3051e != null) {
            return abstractC3051e.m17452h();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m17577e() {
        List<ProParameter> list;
        int OplusGLSurfaceView_13 = this.f16757B;
        if (OplusGLSurfaceView_13 == 0 || (list = this.f16761F) == null) {
            return;
        }
        m17503a(OplusGLSurfaceView_13, list.get(OplusGLSurfaceView_13));
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m17578f() {
        m17503a(0, this.f16761F.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m17566q() {
        PlatformImplementations.kt_3 aVar = this.f16756A;
        if (aVar != null) {
            aVar.mo17585a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17518a(String str, String str2) {
        String str3 = this.f16772Q.get(str);
        if (str3 == null || !str3.equals(str2)) {
            if (TextUtils.isEmpty(str2)) {
                CameraLog.m12954a("ParameterContainer", "parameterChange empty value, key: " + str + ", value: " + str2);
                return;
            }
            this.f16772Q.put(str, str2);
            PlatformImplementations.kt_3 aVar = this.f16756A;
            if (aVar != null) {
                aVar.mo17586a(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17516a(String str) {
        m17530b(str, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17530b(String str, String str2) {
        PlatformImplementations.kt_3 aVar = this.f16756A;
        if (aVar != null) {
            aVar.mo17588b(str, str2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17519a(String str, boolean z, String str2) {
        PlatformImplementations.kt_3 aVar = this.f16756A;
        if (aVar != null) {
            aVar.mo17587a(str, z, str2);
        }
    }

    public void setParameterCallback(PlatformImplementations.kt_3 aVar) {
        this.f16756A = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17572a(long OplusGLSurfaceView_15) {
        ProParameter abstractC3051e = this.f16768M;
        if (abstractC3051e == null || abstractC3051e.m17451g()) {
            return;
        }
        try {
            if (OplusGLSurfaceView_15 > Long.parseLong(this.f16768M.mo17440d()) / 1000000 || this.f16783i == null) {
                return;
            }
            this.f16798x.performClick();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17536c(String str, String str2) {
        PlatformImplementations.kt_3 aVar = this.f16756A;
        if (aVar != null) {
            aVar.mo17590d(str, str2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m17540d(String str, String str2) {
        PlatformImplementations.kt_3 aVar = this.f16756A;
        if (aVar != null) {
            aVar.mo17589c(str, str2);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m17579g() {
        InverseTextView inverseTextView = this.f16799y;
        if (inverseTextView != null) {
            inverseTextView.performClick();
        }
    }
}
