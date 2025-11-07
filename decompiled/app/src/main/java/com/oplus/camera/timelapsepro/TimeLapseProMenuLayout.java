package com.oplus.camera.timelapsepro;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.p027a.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.inverse.InverseTextView;
import com.oplus.camera.professional.ProfessionalAnimConstant;
import com.oplus.camera.professional.ProfessionalAnimUtil;
import com.oplus.camera.screen.LayoutUtil;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.statistics.model.TimeLapseProMsgData;
import com.oplus.camera.timelapsepro.ParameterContainer;
import com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar;
import com.oplus.camera.timelapsepro.adapter.TemplateAdapter;
import com.oplus.camera.timelapsepro.adapter.SubSettingAdapter;
import com.oplus.camera.timelapsepro.p170a.ProParameter;
import com.oplus.camera.timelapsepro.p170a.DurationWrapper;
import com.oplus.camera.timelapsepro.p170a.SpeedWrapper;
import com.oplus.camera.timelapsepro.p170a.SubMenuInfo;
import com.oplus.camera.timelapsepro.p170a.TemplateInfo;
import com.oplus.camera.util.Util;
import com.p078a.p079a.Spring;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TimeLapseProMenuLayout.java */
/* renamed from: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class TimeLapseProMenuLayout extends RelativeLayout {

    /* renamed from: A */
    private RelativeLayout f16872A;

    /* renamed from: B */
    private TimeLapseProParamScaleBar f16873B;

    /* renamed from: C */
    private int f16874C;

    /* renamed from: D */
    private int f16875D;

    /* renamed from: E */
    private int f16876E;

    /* renamed from: F */
    private boolean f16877F;

    /* renamed from: G */
    private boolean f16878G;

    /* renamed from: H */
    private InverseTextView f16879H;

    /* renamed from: I */
    private EqualWidthNumberTextView f16880I;

    /* renamed from: J */
    private InverseTextView f16881J;

    /* renamed from: K */
    private InverseTextView f16882K;

    /* renamed from: L */
    private LinearLayout f16883L;

    /* renamed from: M */
    private RelativeLayout.LayoutParams f16884M;

    /* renamed from: N */
    private List<SpeedWrapper> f16885N;

    /* renamed from: O */
    private List<DurationWrapper> f16886O;

    /* renamed from: P */
    private SpeedWrapper f16887P;

    /* renamed from: Q */
    private DurationWrapper f16888Q;

    /* renamed from: R */
    private boolean f16889R;

    /* renamed from: S */
    private ParameterContainer f16890S;

    /* renamed from: T */
    private int f16891T;

    /* renamed from: U */
    private RelativeLayout.LayoutParams f16892U;

    /* renamed from: V */
    private RelativeLayout.LayoutParams f16893V;

    /* renamed from: W */
    private RelativeLayout.LayoutParams f16894W;

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f16895a;

    /* renamed from: aa */
    private RelativeLayout.LayoutParams f16896aa;

    /* renamed from: ab */
    private RelativeLayout.LayoutParams f16897ab;

    /* renamed from: ac */
    private boolean f16898ac;

    /* renamed from: ad */
    private int f16899ad;

    /* renamed from: ae */
    private List<ProParameter> f16900ae;

    /* renamed from: af */
    private BaseScreenMode f16901af;

    /* renamed from: ag */
    private LinearLayoutManager f16902ag;

    /* renamed from: ah */
    private IntrinsicsJvm.kt_4 f16903ah;

    /* renamed from: ai */
    private LinearLayoutManager f16904ai;

    /* renamed from: aj */
    private IntrinsicsJvm.kt_4 f16905aj;

    /* renamed from: ak */
    private boolean f16906ak;

    /* renamed from: al */
    private int f16907al;

    /* renamed from: am */
    private int f16908am;

    /* renamed from: an */
    private int f16909an;

    /* renamed from: ao */
    private boolean f16910ao;

    /* renamed from: ap */
    private String f16911ap;

    /* renamed from: aq */
    private View f16912aq;

    /* renamed from: ar */
    private boolean f16913ar;

    /* renamed from: as */
    private boolean f16914as;

    /* renamed from: at */
    private String f16915at;

    /* renamed from: au */
    private String f16916au;

    /* renamed from: av */
    private SubSettingAdapter.InterfaceC3063a f16917av;

    /* renamed from: aw */
    private TemplateAdapter.PlatformImplementations.kt_3 f16918aw;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f16919b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f16920c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final ComboPreferences f16921d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final List<COUIBaseListPopupWindow_8> f16922e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final List<IntrinsicsJvm.kt_5> f16923f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Handler f16924g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Handler f16925h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Context f16926i;

    /* renamed from: OplusGLSurfaceView_15 */
    private COUIBaseListPopupWindow_8 f16927j;

    /* renamed from: OplusGLSurfaceView_5 */
    private COUIBaseListPopupWindow_12 f16928k;

    /* renamed from: OplusGLSurfaceView_14 */
    private IntrinsicsJvm.kt_3 f16929l;

    /* renamed from: OplusGLSurfaceView_6 */
    private PlatformImplementations.kt_3 f16930m;

    /* renamed from: OplusGLSurfaceView_11 */
    private RecyclerView f16931n;

    /* renamed from: o */
    private List<TemplateInfo> f16932o;

    /* renamed from: p */
    private TemplateAdapter f16933p;

    /* renamed from: q */
    private RecyclerView f16934q;

    /* renamed from: r */
    private RelativeLayout f16935r;

    /* renamed from: s */
    private List<SubMenuInfo> f16936s;

    /* renamed from: t */
    private SubSettingAdapter f16937t;

    /* renamed from: u */
    private volatile SubMenuInfo f16938u;

    /* renamed from: v */
    private volatile int f16939v;

    /* renamed from: w */
    private boolean f16940w;

    /* renamed from: x */
    private RelativeLayout f16941x;

    /* renamed from: y */
    private TimeLapseProParamScaleBar f16942y;

    /* renamed from: z */
    private int f16943z;

    /* compiled from: TimeLapseProMenuLayout.java */
    /* renamed from: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17760a(int OplusGLSurfaceView_13, boolean z, Object... objArr);
    }

    /* compiled from: TimeLapseProMenuLayout.java */
    /* renamed from: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        void onChanged();
    }

    /* compiled from: TimeLapseProMenuLayout.java */
    /* renamed from: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_5 */
    public interface IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17763a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo17764b();
    }

    /* compiled from: TimeLapseProMenuLayout.java */
    /* renamed from: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11$COUIBaseListPopupWindow_8 */
    public interface COUIBaseListPopupWindow_8 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17765a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17766a(long OplusGLSurfaceView_15);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17767a(String str);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17768a(String str, String str2);
    }

    /* compiled from: TimeLapseProMenuLayout.java */
    /* renamed from: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11$COUIBaseListPopupWindow_12 */
    public interface COUIBaseListPopupWindow_12 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17769a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17770a(String str);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17771a(String str, String str2);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17772a(boolean z);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String m17710g(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return TimeLapseProMsgData.KEY_TIMELAPSEPRO_INTERVAL;
        }
        if (OplusGLSurfaceView_13 == 1) {
            return TimeLapseProMsgData.KEY_TIMELAPSEPRO_TIMER;
        }
        if (OplusGLSurfaceView_13 != 2) {
            return null;
        }
        return TimeLapseProMsgData.KEY_TIMELAPSEPRO_PARAMETER;
    }

    public TimeLapseProMenuLayout(Context context, ComboPreferences comboPreferences) {
        super(context);
        this.f16922e = new ArrayList();
        this.f16923f = new ArrayList();
        this.f16926i = null;
        this.f16927j = null;
        this.f16928k = null;
        this.f16929l = null;
        this.f16930m = null;
        this.f16939v = 0;
        this.f16940w = true;
        this.f16943z = -1;
        this.f16874C = 0;
        this.f16875D = 0;
        this.f16876E = 0;
        this.f16889R = false;
        this.f16891T = 0;
        this.f16898ac = false;
        this.f16899ad = 60;
        this.f16900ae = null;
        this.f16901af = null;
        this.f16902ag = null;
        this.f16903ah = null;
        this.f16904ai = null;
        this.f16905aj = null;
        this.f16906ak = false;
        this.f16907al = 3;
        this.f16908am = 3;
        this.f16909an = -1;
        this.f16910ao = true;
        this.f16911ap = "";
        this.f16912aq = null;
        this.f16913ar = false;
        this.f16914as = false;
        this.f16915at = null;
        this.f16916au = null;
        this.f16917av = new SubSettingAdapter.InterfaceC3063a() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11.1
            @Override // com.oplus.camera.timelapsepro.adapter.SubSettingAdapter.InterfaceC3063a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17484a(int OplusGLSurfaceView_13, SubMenuInfo c3056j) {
                if (OplusGLSurfaceView_13 != TimeLapseProMenuLayout.this.f16909an) {
                    int i2 = 0;
                    while (i2 < TimeLapseProMenuLayout.this.f16937t.m17492c().size()) {
                        TimeLapseProMenuLayout.this.f16937t.m17492c().get(i2).f16736b = i2 == OplusGLSurfaceView_13;
                        i2++;
                    }
                    TimeLapseProMenuLayout.this.f16937t.notifyDataSetChanged();
                    TimeLapseProMenuLayout.this.m17652a(OplusGLSurfaceView_13, c3056j);
                    return;
                }
                CameraLog.m12954a("TimeLapseProMenuLayout", "clickItem, current setting is " + OplusGLSurfaceView_13 + ", so return.");
            }
        };
        this.f16918aw = new TemplateAdapter.PlatformImplementations.kt_3() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11.4
            @Override // com.oplus.camera.timelapsepro.adapter.TemplateAdapter.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17498a(int OplusGLSurfaceView_13, TemplateInfo c3057k) {
                int i2 = 0;
                while (true) {
                    boolean z = true;
                    if (i2 >= TimeLapseProMenuLayout.this.f16933p.m17492c().size()) {
                        break;
                    }
                    TemplateInfo c3057k2 = TimeLapseProMenuLayout.this.f16933p.m17492c().get(i2);
                    if (i2 != OplusGLSurfaceView_13) {
                        z = false;
                    }
                    c3057k2.m17466a(z);
                    i2++;
                }
                TimeLapseProMenuLayout.this.f16933p.notifyDataSetChanged();
                TimeLapseProMenuLayout.this.f16891T = OplusGLSurfaceView_13;
                TimeLapseProMenuLayout c3071g = TimeLapseProMenuLayout.this;
                c3071g.m17666a("pref_time_lapse_pro_template_key", c3071g.f16891T);
                TimeLapseProMenuLayout.this.m17653a(R.string.time_lapse_pro_hint_template_format, OplusGLSurfaceView_13 == 0, TimeLapseProMenuLayout.this.f16933p.m17492c().get(OplusGLSurfaceView_13).m17467b());
                TimeLapseProMenuLayout.this.f16906ak = OplusGLSurfaceView_13 != 0;
                if (OplusGLSurfaceView_13 != 0) {
                    TimeLapseProMenuLayout.this.m17725t();
                }
                TimeLapseProMenuLayout.this.m17699d(OplusGLSurfaceView_13);
                TimeLapseProMenuLayout.this.m17703e(OplusGLSurfaceView_13);
            }
        };
        this.f16926i = context;
        this.f16921d = comboPreferences;
        this.f16920c = getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_radius_size);
        this.f16895a = getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dx);
        this.f16919b = getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dy);
        this.f16885N = m17641F();
        this.f16886O = m17642G();
        m17738a();
        m17721r();
        m17729v();
        this.f16924g = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11.5
            @Override // android.os.Handler
            public void handleMessage(Message message) throws Resources.NotFoundException {
                super.handleMessage(message);
                int OplusGLSurfaceView_13 = message.what;
                if (OplusGLSurfaceView_13 == 0) {
                    TimeLapseProMenuLayout.this.m17734x();
                    return;
                }
                if (OplusGLSurfaceView_13 == 1) {
                    TimeLapseProMenuLayout.this.m17678b(-1);
                    return;
                }
                if (OplusGLSurfaceView_13 != 2) {
                    return;
                }
                TimeLapseProMenuLayout.this.m17673a(false, true);
                if (TimeLapseProMenuLayout.this.f16942y != null && TimeLapseProMenuLayout.this.f16942y.isShown()) {
                    TimeLapseProMenuLayout.this.f16942y.m17419b(true);
                }
                if (TimeLapseProMenuLayout.this.f16873B == null || !TimeLapseProMenuLayout.this.f16873B.isShown()) {
                    return;
                }
                TimeLapseProMenuLayout.this.f16873B.m17419b(true);
            }
        };
        HandlerThread handlerThread = new HandlerThread("Report TimelapsePro Thread");
        handlerThread.start();
        this.f16925h = new Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11.6
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 10:
                        TimeLapseProMenuLayout c3071g = TimeLapseProMenuLayout.this;
                        c3071g.m17701d(c3071g.f16887P.mo17462f_());
                        break;
                    case 11:
                        TimeLapseProMenuLayout c3071g2 = TimeLapseProMenuLayout.this;
                        c3071g2.m17707f(c3071g2.f16888Q.m17434b());
                        break;
                    case 12:
                        TimeLapseProMenuLayout c3071g3 = TimeLapseProMenuLayout.this;
                        c3071g3.m17685b(c3071g3.f16915at, TimeLapseProMenuLayout.this.f16916au);
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17666a(String str, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("TimeLapseProMenuLayout", "putPreferenceInt, key: " + str + ", value: " + OplusGLSurfaceView_13);
        this.f16921d.edit().putInt(str, OplusGLSurfaceView_13).apply();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m17675b(String str, int OplusGLSurfaceView_13) {
        int i2 = this.f16921d.getInt(str, OplusGLSurfaceView_13);
        CameraLog.m12954a("TimeLapseProMenuLayout", "getPreferenceInt, key: " + str + ", value: " + i2);
        return i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17738a() {
        this.f16910ao = true;
        this.f16891T = m17675b("pref_time_lapse_pro_template_key", 0);
        this.f16939v = m17675b("pref_time_lapse_pro_sub_setting_key", 0);
        this.f16943z = m17675b("pref_time_lapse_pro_speed_key", -1);
        this.f16874C = m17675b("pref_time_lapse_pro_duration_key", 0);
        this.f16875D = this.f16943z;
        this.f16876E = this.f16874C;
        CameraLog.m12954a("TimeLapseProMenuLayout", "restoreFromPreference, mSelectTemplate: " + this.f16891T + ", mIndexOfCurrentSetting: " + this.f16939v + ", mSpeedIndex: " + this.f16943z + ", mDurationIndex: " + this.f16874C);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17743b() {
        if (this.f16933p != null) {
            int OplusGLSurfaceView_13 = 0;
            while (OplusGLSurfaceView_13 < this.f16932o.size()) {
                this.f16932o.get(OplusGLSurfaceView_13).m17466a(OplusGLSurfaceView_13 == this.f16891T);
                OplusGLSurfaceView_13++;
            }
            this.f16933p.notifyDataSetChanged();
        }
        if (this.f16937t != null) {
            int i2 = 0;
            while (i2 < this.f16936s.size()) {
                this.f16936s.get(i2).f16736b = i2 == this.f16939v;
                i2++;
            }
            this.f16938u = this.f16936s.get(this.f16939v);
            this.f16937t.notifyDataSetChanged();
        }
    }

    public void setShowTemplate(boolean z) throws Resources.NotFoundException {
        if (!this.f16877F) {
            this.f16877F = true;
        }
        this.f16878G = z;
        m17746d();
        if (this.f16878G) {
            m17644I();
            return;
        }
        m17645J();
        if (this.f16906ak) {
            return;
        }
        m17678b(-1);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m17745c() {
        return this.f16878G;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17746d() throws Resources.NotFoundException {
        this.f16931n.setVisibility(this.f16878G ? 0 : 8);
        this.f16912aq.setVisibility(this.f16878G ? 8 : 0);
        this.f16935r.setVisibility(this.f16878G ? 8 : 0);
        if (this.f16878G) {
            this.f16908am = 3;
            m17691c(3);
        } else {
            m17734x();
        }
    }

    /* renamed from: r */
    private void m17721r() {
        this.f16931n = new RecyclerView(this.f16926i);
        if (this.f16896aa == null) {
            this.f16896aa = new RelativeLayout.LayoutParams(-2, -2);
            this.f16896aa.addRule(14);
            this.f16896aa.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.template_margin_bottom);
        }
        addView(this.f16931n, this.f16896aa);
        this.f16902ag = new LinearLayoutManager(this.f16926i, 0, false);
        this.f16931n.setLayoutManager(this.f16902ag);
        this.f16933p = new TemplateAdapter(this.f16926i);
        if (this.f16932o == null) {
            this.f16932o = getTemplateInfoList();
        }
        this.f16933p.m17496a(this.f16918aw);
        this.f16933p.m17490a(this.f16932o);
        this.f16931n.setAdapter(this.f16933p);
        this.f16903ah = new IntrinsicsJvm.kt_4(getResources().getDimensionPixelOffset(R.dimen.template_item_interval) / 2);
        this.f16931n.addItemDecoration(this.f16903ah);
        this.f16931n.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m17724s() {
        if (this.f16891T == 0) {
            return;
        }
        TemplateAdapter c3065b = this.f16933p;
        if (c3065b != null) {
            c3065b.m17493a(0);
        }
        m17678b(R.string.time_lapse_pro_close_template);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m17725t() {
        this.f16921d.edit().remove("pref_time_lapse_pro_speed_key").remove("pref_time_lapse_pro_duration_key").remove("pref_time_lapse_pro_duration_key").apply();
        m17751i();
        m17752j();
        m17750h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17678b(int OplusGLSurfaceView_13) {
        m17653a(OplusGLSurfaceView_13, true, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17653a(int OplusGLSurfaceView_13, boolean z, Object... objArr) {
        PlatformImplementations.kt_3 aVar = this.f16930m;
        if (aVar == null || !this.f16910ao) {
            return;
        }
        aVar.mo17760a(OplusGLSurfaceView_13, z, objArr);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m17747e() throws Resources.NotFoundException {
        String string;
        int iM17434b;
        if (this.f16891T <= 0 && this.f16877F && !this.f16878G) {
            String str = String.format(getResources().getString(R.string.time_lapse_pro_speed_format), this.f16887P.m17464d());
            DurationWrapper c3047a = this.f16888Q;
            if (c3047a == null || (iM17434b = c3047a.m17434b()) <= 0) {
                string = getResources().getString(R.string.time_lapse_pro_unlimited_time);
            } else {
                string = String.format(getResources().getString(R.string.time_lapse_pro_video_time_format_min), Integer.valueOf(iM17434b));
            }
            m17653a(R.string.time_lapse_pro_hint_text_format, m17748f(), str, string);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m17748f() {
        int OplusGLSurfaceView_13 = this.f16875D;
        boolean z = (OplusGLSurfaceView_13 == 0 || -1 == OplusGLSurfaceView_13) && this.f16876E == 0;
        ParameterContainer c3066b = this.f16890S;
        return c3066b != null ? z && !c3066b.m17576d() : z;
    }

    /* renamed from: u */
    private List<TemplateInfo> m17728u() {
        ArrayList arrayList = new ArrayList();
        for (String str : CameraUIInterface.KEY_TIMELAPSE_PRO_TEMPLATES) {
            arrayList.add(m17676b(str));
        }
        return arrayList;
    }

    public List<TemplateInfo> getTemplateInfoList() {
        List<TemplateInfo> list = this.f16932o;
        if (list == null || list.isEmpty()) {
            this.f16932o = m17728u();
        }
        return this.f16932o;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private TemplateInfo m17676b(String str) {
        if (str.equals(CameraUIInterface.KEY_TIMELAPSE_PRO_TEMPLATES[0])) {
            return new TemplateInfo(R.drawable.time_lapse_pro_item_bg, this.f16891T == 0, getResources().getString(R.string.camera_time_lapse_pro_no_template));
        }
        if (str.equals(CameraUIInterface.KEY_TIMELAPSE_PRO_TEMPLATES[1])) {
            return new TemplateInfo(R.drawable.time_lapse_pro_template_car, 1 == this.f16891T, getResources().getString(R.string.camera_time_lapse_pro_template_car));
        }
        if (str.equals(CameraUIInterface.KEY_TIMELAPSE_PRO_TEMPLATES[2])) {
            return new TemplateInfo(R.drawable.time_lapse_pro_template_star, 2 == this.f16891T, getResources().getString(R.string.camera_time_lapse_pro_template_star));
        }
        if (str.equals(CameraUIInterface.KEY_TIMELAPSE_PRO_TEMPLATES[3])) {
            return new TemplateInfo(R.drawable.time_lapse_pro_template_cloud, 3 == this.f16891T, getResources().getString(R.string.camera_time_lapse_pro_template_cloud));
        }
        return null;
    }

    /* renamed from: v */
    private void m17729v() {
        this.f16912aq = new View(this.f16926i);
        this.f16912aq.setId(R.id_renamed.time_lapse_pro_layout_bottom_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(12);
        addView(this.f16912aq, layoutParams);
        this.f16934q = new RecyclerView(this.f16926i);
        this.f16904ai = new LinearLayoutManager(this.f16926i, 0, false);
        this.f16934q.setLayoutManager(this.f16904ai);
        this.f16937t = new SubSettingAdapter(this.f16926i);
        if (this.f16936s == null) {
            this.f16936s = m17731w();
        }
        this.f16937t.m17482a(this.f16917av);
        this.f16937t.m17490a(this.f16936s);
        this.f16934q.setAdapter(this.f16937t);
        this.f16934q.setItemViewCacheSize(-1);
        this.f16905aj = new IntrinsicsJvm.kt_4(getResources().getDimensionPixelOffset(R.dimen.setting_item_divider_horizontal) / 2, getResources().getDimensionPixelOffset(R.dimen.setting_item_divider_vertical) / 2);
        this.f16934q.addItemDecoration(this.f16905aj);
        if (this.f16897ab == null) {
            this.f16897ab = new RelativeLayout.LayoutParams(-2, -2);
        }
        this.f16935r = new RelativeLayout(this.f16926i);
        this.f16935r.setId(R.id_renamed.time_lapse_pro_setting_title);
        this.f16935r.addView(this.f16934q);
        this.f16935r.setGravity(17);
        addView(this.f16935r, this.f16897ab);
        this.f16935r.setVisibility(8);
    }

    /* renamed from: w */
    private List<SubMenuInfo> m17731w() throws Resources.NotFoundException {
        ArrayList arrayList = new ArrayList();
        String[] stringArray = getResources().getStringArray(R.array.time_lapse_pro_settings);
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < stringArray.length) {
            arrayList.add(new SubMenuInfo(stringArray[OplusGLSurfaceView_13], this.f16939v == OplusGLSurfaceView_13));
            OplusGLSurfaceView_13++;
        }
        this.f16938u = (SubMenuInfo) arrayList.get(this.f16939v);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17652a(int OplusGLSurfaceView_13, SubMenuInfo c3056j) {
        this.f16939v = OplusGLSurfaceView_13;
        m17666a("pref_time_lapse_pro_sub_setting_key", this.f16939v);
        this.f16938u = c3056j;
        this.f16924g.sendEmptyMessage(0);
        m17673a(false, true);
        m17736y();
        m17706e(m17710g(OplusGLSurfaceView_13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m17734x() throws Resources.NotFoundException {
        RecyclerView recyclerView;
        BaseScreenMode abstractC2934a = this.f16901af;
        if (abstractC2934a != null) {
            m17651a(abstractC2934a.mo16539j(), this.f16901af.mo16570k());
        }
        if (this.f16941x == null) {
            m17737z();
        }
        if (this.f16872A == null) {
            m17637B();
        }
        if (this.f16890S == null) {
            m17639D();
        }
        m17673a(false, true);
        if (this.f16938u.f16735a.equals(getResources().getString(R.string.time_lapse_pro_setting_of_speed))) {
            TimeLapseProParamScaleBar timeLapseProParamScaleBar = this.f16942y;
            if (timeLapseProParamScaleBar != null) {
                timeLapseProParamScaleBar.setShowText(true);
            }
            m17691c(0);
        } else if (this.f16938u.f16735a.equals(getResources().getString(R.string.time_lapse_pro_setting_of_duration))) {
            TimeLapseProParamScaleBar timeLapseProParamScaleBar2 = this.f16873B;
            if (timeLapseProParamScaleBar2 != null) {
                timeLapseProParamScaleBar2.setShowText(true);
            }
            m17691c(1);
        } else if (this.f16938u.f16735a.equals(getResources().getString(R.string.time_lapse_pro_setting_of_pro_params))) {
            m17691c(2);
        }
        if (1 != this.f16901af.mo16539j() || this.f16913ar || (recyclerView = this.f16934q) == null || this.f16937t == null) {
            return;
        }
        this.f16913ar = true;
        recyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11.7
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                CameraLog.m12954a("TimeLapseProMenuLayout", "onPreDraw, width: " + TimeLapseProMenuLayout.this.f16934q.getWidth());
                if (TimeLapseProMenuLayout.this.f16934q.getWidth() <= 0) {
                    return false;
                }
                TimeLapseProMenuLayout.this.f16937t.m17478a(TimeLapseProMenuLayout.this.f16934q.getWidth());
                TimeLapseProMenuLayout.this.f16937t.notifyDataSetChanged();
                TimeLapseProMenuLayout.this.f16934q.getViewTreeObserver().removeOnPreDrawListener(this);
                return false;
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17691c(int OplusGLSurfaceView_13) {
        this.f16907al = OplusGLSurfaceView_13;
        this.f16909an = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 == 0) {
            m17687b(true, true);
            m17696c(false, true);
            m17702d(false, true);
        } else if (OplusGLSurfaceView_13 == 1) {
            m17687b(false, true);
            m17696c(true, true);
            m17702d(false, true);
        } else if (OplusGLSurfaceView_13 == 2) {
            m17687b(false, true);
            m17696c(false, true);
            m17702d(true, true);
        } else if (OplusGLSurfaceView_13 == 3) {
            m17687b(false, false);
            m17696c(false, false);
            m17702d(false, false);
            m17673a(false, false);
        }
        this.f16908am = OplusGLSurfaceView_13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17668a(String str, String str2, String str3) {
        m17670a(str, str2, str3, true, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17669a(String str, String str2, String str3, boolean z) {
        m17670a(str, str2, str3, z, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17670a(String str, String str2, String str3, boolean z, boolean z2) {
        m17671a(str, str2, str3, z, z2, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17671a(String str, String str2, String str3, boolean z, boolean z2, long OplusGLSurfaceView_15) {
        if (this.f16884M == null) {
            m17736y();
        }
        if (!this.f16889R) {
            this.f16882K = new InverseTextView(this.f16926i);
            this.f16882K.setTextSize(1, 12.0f);
            this.f16882K.setGravity(17);
            this.f16882K.setIncludeFontPadding(false);
            this.f16882K.setSingleLine(true);
            this.f16882K.setTextColor(this.f16926i.getColor(R.color.time_lapse_pro_seek_value_desc_color));
            this.f16882K.setShadowLayer(this.f16920c, this.f16895a, this.f16919b, ContextCompat.m2254c(this.f16926i, R.color.color_black_with_20_percent_transparency));
            this.f16882K.setMaxWidth(getResources().getDimensionPixelOffset(R.dimen.setting_seek_text_desc_max_width));
            this.f16880I = new EqualWidthNumberTextView(this.f16926i);
            this.f16880I.setTextColor(this.f16926i.getColor(R.color.camera_white));
            this.f16880I.m17430a(Util.m24507z(), 2, 56.0f);
            this.f16881J = new InverseTextView(this.f16926i);
            this.f16881J.setTextSize(2, 46.0f);
            this.f16881J.setGravity(17);
            this.f16881J.setTextColor(this.f16926i.getColor(R.color.camera_white));
            this.f16881J.setShadowLayer(this.f16920c, this.f16895a, this.f16919b, ContextCompat.m2254c(this.f16926i, R.color.color_black_with_20_percent_transparency));
            LinearLayout linearLayout = new LinearLayout(this.f16926i);
            linearLayout.setLayoutDirection(0);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(1);
            linearLayout.addView(this.f16880I);
            linearLayout.addView(this.f16881J);
            ((LinearLayout.LayoutParams) this.f16881J.getLayoutParams()).leftMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_center_tips_divider);
            this.f16883L = new LinearLayout(this.f16926i);
            this.f16883L.setId(R.id_renamed.time_lapse_pro_layout_tips_layout);
            this.f16883L.setOrientation(1);
            this.f16883L.setGravity(17);
            this.f16883L.addView(linearLayout, new LinearLayout.LayoutParams(-2, -2));
            this.f16883L.addView(this.f16882K, new LinearLayout.LayoutParams(-2, -2));
            addView(this.f16883L, this.f16884M);
            this.f16883L.setVisibility(8);
            this.f16889R = true;
            this.f16882K.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11.8
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (TimeLapseProMenuLayout.this.f16880I.getHeight() > 0) {
                        TimeLapseProMenuLayout.this.f16882K.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    TimeLapseProMenuLayout.this.f16883L.setPadding(0, TimeLapseProMenuLayout.this.f16882K.getHeight(), 0, 0);
                }
            });
        }
        this.f16882K.setSingleLine(4 == this.f16901af.mo16539j());
        this.f16882K.setEllipsize(TextUtils.TruncateAt.END);
        this.f16882K.setLines(4 == this.f16901af.mo16539j() ? 1 : 2);
        this.f16880I.setTextToDraw(str == null ? "" : str);
        this.f16881J.setText(str2 == null ? "" : str2);
        this.f16882K.setText(str3 != null ? str3 : "");
        this.f16882K.setVisibility(str3 != null ? 0 : 4);
        if (str2 != null && !str2.isEmpty() && this.f16883L.getChildCount() > 0) {
            ((LinearLayout) this.f16883L.getChildAt(0)).setGravity(str2.matches("^[PlatformImplementations.kt_3-zA-Z]*") ? 80 : 17);
        }
        if (z2) {
            m17673a(true, true);
        }
        if (this.f16924g.hasMessages(2)) {
            this.f16924g.removeMessages(2);
        }
        if (z) {
            this.f16924g.sendEmptyMessageDelayed(2, OplusGLSurfaceView_15);
        }
    }

    /* renamed from: y */
    private void m17736y() {
        if (this.f16884M == null) {
            this.f16884M = new RelativeLayout.LayoutParams(-2, -2);
        }
        this.f16884M.removeRule(13);
        this.f16884M.addRule(14);
        this.f16884M.addRule(2, R.id_renamed.time_lapse_pro_setting_title);
        if (1 == this.f16901af.mo16539j()) {
            this.f16884M.removeRule(2);
            this.f16884M.addRule(13);
        } else if (3 == this.f16901af.mo16539j()) {
            this.f16884M.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.setting_seek_text_margin_bottom_split);
        } else if (4 == this.f16901af.mo16539j()) {
            this.f16884M.bottomMargin = getResources().getDimensionPixelOffset(this.f16938u.f16735a.equals(getResources().getString(R.string.time_lapse_pro_setting_of_pro_params)) ? R.dimen.setting_seek_text_margin_bottom_rack_params : R.dimen.setting_seek_text_margin_bottom_rack);
        } else {
            this.f16884M.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.setting_seek_text_margin_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17673a(boolean z, boolean z2) {
        this.f16898ac = z;
        if (z2) {
            m17672a(z);
            return;
        }
        LinearLayout linearLayout = this.f16883L;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 8);
        }
        if (z || !this.f16924g.hasMessages(2)) {
            return;
        }
        this.f16924g.removeMessages(2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17672a(boolean z) {
        if (z) {
            ParameterContainer c3066b = this.f16890S;
            if (c3066b != null) {
                c3066b.setEnabled(false);
            }
            Util.m24264a(this.f16883L, 0.0f, 1.0f, 400L, 150L, new Animation.AnimationListener() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11.9
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (TimeLapseProMenuLayout.this.f16890S != null) {
                        TimeLapseProMenuLayout.this.f16890S.setEnabled(true);
                    }
                }
            }, ProfessionalAnimConstant.f15694a);
            return;
        }
        Util.m24268a(this.f16883L, 250, 0, ProfessionalAnimConstant.f15694a);
    }

    private int getScaleLayoutId() {
        CameraLog.m12954a("TimeLapseProMenuLayout", "getScaleLayoutId");
        return 1 == this.f16901af.mo16539j() ? 270 == this.f16901af.mo16570k() ? R.layout.time_lapse_pro_scale_bar_vertical_270 : R.layout.time_lapse_pro_scale_bar_vertical : R.layout.time_lapse_pro_scale_bar_default;
    }

    /* renamed from: z */
    private void m17737z() {
        this.f16940w = this.f16943z == -1;
        this.f16941x = (RelativeLayout) LayoutInflater.from(this.f16926i).inflate(getScaleLayoutId(), (ViewGroup) this, false);
        this.f16942y = (TimeLapseProParamScaleBar) this.f16941x.findViewById(R.id_renamed.scale_bar);
        this.f16879H = (InverseTextView) this.f16941x.findViewById(R.id_renamed.auto_btn);
        this.f16879H.setTypeface(Util.m24411c(true));
        this.f16879H.setTextSize(1, 12.0f);
        final TextView textView = (TextView) this.f16941x.findViewById(R.id_renamed.scale_text);
        final Spring c1032fM15923a = ProfessionalAnimUtil.m15923a();
        this.f16879H.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    ProfessionalAnimUtil.m15924a(view, c1032fM15923a, true);
                } else if (action == 1 || action == 3) {
                    ProfessionalAnimUtil.m15924a(view, c1032fM15923a, false);
                }
                return false;
            }
        });
        if (this.f16885N == null) {
            this.f16885N = m17641F();
        }
        if (this.f16875D == -1) {
            this.f16875D = 0;
        }
        this.f16887P = this.f16885N.get(this.f16875D);
        this.f16942y.setTextUpdateListener(new TimeLapseProParamScaleBar.InterfaceC3045c() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_11$MLKeWOscLWQ8s98wFOyRI1tGQ1M
            public final void onUpdate(String str) {
                textView.setText(str);
            }
        });
        this.f16879H.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_11$tCrKp-4pvj04dPdkBupmpcP2Dr8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m17655a(view);
            }
        });
        this.f16879H.setInverseColor(this.f16940w);
        TimeLapseAnimUtil.m17615a(this.f16879H, this.f16940w, false);
        this.f16942y.setValueList(this.f16885N);
        this.f16942y.setLineSpace(this.f16899ad);
        int OplusGLSurfaceView_13 = this.f16875D;
        if (OplusGLSurfaceView_13 != 0) {
            this.f16942y.setCurrentIndex(OplusGLSurfaceView_13);
        }
        this.f16942y.setMoveListener(new TimeLapseProParamScaleBar.InterfaceC3043a() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11.11
            @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17427a(TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
                if (TimeLapseProMenuLayout.this.f16940w) {
                    TimeLapseProMenuLayout.this.f16940w = false;
                    TimeLapseProMenuLayout.this.f16942y.setAutoState(false);
                    if (TimeLapseProMenuLayout.this.f16879H != null) {
                        TimeLapseProMenuLayout.this.f16879H.setInverseColor(false);
                        TimeLapseAnimUtil.m17615a(TimeLapseProMenuLayout.this.f16879H, false, true);
                    }
                }
                TimeLapseProMenuLayout.this.m17724s();
            }

            @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17426a() {
                if (TimeLapseProMenuLayout.this.f16924g.hasMessages(2)) {
                    TimeLapseProMenuLayout.this.f16924g.removeMessages(2);
                }
                TimeLapseProMenuLayout.this.f16924g.sendEmptyMessageDelayed(2, 1000L);
                TimeLapseProMenuLayout.this.m17646K();
            }
        });
        this.f16942y.setScaleListener(new TimeLapseProParamScaleBar.InterfaceC3044b() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_11$QD3VFN4PF0R__xhGX1K3W-xTRKE
            @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3044b
            public final void onValueChanged(TimeLapseProParamScaleBar timeLapseProParamScaleBar, int i2) {
                this.COUIBaseListPopupWindow_12$0.m17681b(timeLapseProParamScaleBar, i2);
            }
        });
        m17636A();
        addView(this.f16941x, this.f16892U);
        this.f16942y.m20768c(!this.f16940w);
        int i2 = this.f16943z;
        if (i2 <= 0) {
            this.f16942y.m20766b(0);
        } else {
            this.f16942y.m20766b(i2);
        }
        this.f16941x.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m17655a(View view) {
        this.f16879H.setInverseColor(!r0.m20148a());
        this.f16940w = this.f16879H.m20148a();
        this.f16942y.setAutoState(this.f16940w);
        TimeLapseAnimUtil.m17614a((InverseTextView) view, this.f16940w);
        if (this.f16940w) {
            this.f16911ap = "";
            m17666a("pref_time_lapse_pro_speed_key", -1);
            m17701d("auto");
        } else {
            m17701d(this.f16887P.m17464d());
        }
        if (this.f16924g.hasMessages(2)) {
            this.f16924g.removeMessages(2);
        }
        this.f16924g.sendEmptyMessageDelayed(2, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m17681b(TimeLapseProParamScaleBar timeLapseProParamScaleBar, int OplusGLSurfaceView_13) {
        ParameterContainer c3066b;
        this.f16875D = OplusGLSurfaceView_13;
        this.f16887P = this.f16885N.get(OplusGLSurfaceView_13);
        if (this.f16942y.isShown()) {
            this.f16942y.m17419b(false);
            if (this.f16939v == 0) {
                m17669a(this.f16887P.mo17462f_(), this.f16887P.mo17463g_(), this.f16887P.mo17461c(), false);
            }
        }
        m17695c(this.f16887P.m17464d(), OplusGLSurfaceView_13);
        if (!this.f16942y.isShown() || (c3066b = this.f16890S) == null) {
            return;
        }
        c3066b.m17572a((Long.parseLong(this.f16887P.m17464d()) * 1000) / 30);
    }

    /* renamed from: A */
    private void m17636A() {
        if (this.f16892U == null) {
            this.f16892U = new RelativeLayout.LayoutParams(-2, -2);
        }
        this.f16892U.addRule(2, R.id_renamed.time_lapse_pro_setting_title);
        this.f16892U.removeRule(14);
        this.f16892U.removeRule(9);
        this.f16892U.removeRule(11);
        if (2 == this.f16901af.mo16539j() || 3 == this.f16901af.mo16539j()) {
            this.f16892U.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_scale_margin_bottom_rack_screen) - getResources().getDimensionPixelSize(R.dimen.blur_menu_seekbar_padding_bottom);
            return;
        }
        if (4 == this.f16901af.mo16539j()) {
            this.f16892U.width = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_scale_width_rack_screen);
            this.f16892U.addRule(14);
            this.f16892U.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_scale_margin_bottom_rack_screen) - getResources().getDimensionPixelSize(R.dimen.blur_menu_seekbar_padding_bottom);
            InverseTextView inverseTextView = this.f16879H;
            if (inverseTextView != null) {
                inverseTextView.setBackgroundResource(this.f16901af.mo16630q() ? R.drawable.time_lapse_pro_auto_btn_bg_default : R.drawable.time_lapse_pro_auto_btn_bg_full_screen);
                return;
            }
            return;
        }
        this.f16892U.addRule(270 == this.f16901af.mo16570k() ? 11 : 9);
        this.f16892U.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_scale_margin_bottom_full_screen);
        InverseTextView inverseTextView2 = this.f16879H;
        if (inverseTextView2 != null) {
            ((RelativeLayout.LayoutParams) inverseTextView2.getLayoutParams()).topMargin = Util.m24198Z() == 0 ? getResources().getDimensionPixelOffset(R.dimen.setting_auto_button_margin_vertical_top) : getResources().getDimensionPixelOffset(R.dimen.setting_auto_button_margin_vertical_top_with_nav);
        }
    }

    public void setSettingValues(String str) {
        if (this.f16885N == null) {
            this.f16885N = m17641F();
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f16885N.size(); OplusGLSurfaceView_13++) {
            if (this.f16885N.get(OplusGLSurfaceView_13).m17464d().equals(str)) {
                this.f16875D = OplusGLSurfaceView_13;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17687b(boolean z, boolean z2) {
        RelativeLayout relativeLayout = this.f16941x;
        if (relativeLayout != null) {
            if (z2) {
                if (z || this.f16908am == 0) {
                    if (z) {
                        Util.m24264a(this.f16941x, 0.0f, 1.0f, 400L, 150L, (Animation.AnimationListener) null, ProfessionalAnimConstant.f15694a);
                        return;
                    } else {
                        Util.m24268a(this.f16941x, 250, 0, ProfessionalAnimConstant.f15694a);
                        return;
                    }
                }
                return;
            }
            relativeLayout.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: B */
    private void m17637B() {
        this.f16872A = (RelativeLayout) LayoutInflater.from(this.f16926i).inflate(getScaleLayoutId(), (ViewGroup) this, false);
        this.f16873B = (TimeLapseProParamScaleBar) this.f16872A.findViewById(R.id_renamed.scale_bar);
        this.f16872A.findViewById(R.id_renamed.auto_btn).setVisibility(4);
        final TextView textView = (TextView) this.f16872A.findViewById(R.id_renamed.scale_text);
        if (this.f16886O == null) {
            this.f16886O = m17642G();
        }
        this.f16888Q = this.f16886O.get(0);
        this.f16873B.setTextUpdateListener(new TimeLapseProParamScaleBar.InterfaceC3045c() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_11$zpzuJGx3CnKqsqlHAWGZXdhO0nI
            public final void onUpdate(String str) {
                textView.setText(str);
            }
        });
        this.f16873B.setValueList(this.f16886O);
        this.f16873B.setScaleSpace(12);
        this.f16873B.m20768c(true);
        int OplusGLSurfaceView_13 = this.f16876E;
        if (OplusGLSurfaceView_13 != 0) {
            this.f16873B.setCurrentIndex(OplusGLSurfaceView_13);
        }
        this.f16873B.setMoveListener(new TimeLapseProParamScaleBar.InterfaceC3043a() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11.2
            @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17427a(TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
                TimeLapseProMenuLayout.this.m17724s();
            }

            @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3043a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17426a() {
                TimeLapseProMenuLayout.this.f16924g.sendEmptyMessageDelayed(2, 1000L);
                TimeLapseProMenuLayout.this.m17647L();
            }
        });
        this.f16873B.setScaleListener(new TimeLapseProParamScaleBar.InterfaceC3044b() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_11$EY_RPrT8h8MD8wujwGJ8hP4BXj0
            @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.InterfaceC3044b
            public final void onValueChanged(TimeLapseProParamScaleBar timeLapseProParamScaleBar, int i2) {
                this.COUIBaseListPopupWindow_12$0.m17657a(timeLapseProParamScaleBar, i2);
            }
        });
        m17638C();
        addView(this.f16872A, this.f16893V);
        this.f16873B.m20766b(this.f16874C);
        this.f16872A.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m17657a(TimeLapseProParamScaleBar timeLapseProParamScaleBar, int OplusGLSurfaceView_13) {
        if (this.f16876E != OplusGLSurfaceView_13) {
            this.f16874C = OplusGLSurfaceView_13;
            m17666a("pref_time_lapse_pro_duration_key", OplusGLSurfaceView_13);
        }
        this.f16876E = OplusGLSurfaceView_13;
        this.f16888Q = this.f16886O.get(OplusGLSurfaceView_13);
        this.f16873B.setShowText(false);
        if (1 == this.f16907al) {
            m17669a(this.f16888Q.mo17462f_(), this.f16888Q.mo17463g_(), this.f16888Q.m17432a(this.f16887P).mo17461c(), false);
        }
        m17654a(this.f16888Q.m17431a());
    }

    /* renamed from: C */
    private void m17638C() {
        if (this.f16893V == null) {
            this.f16893V = new RelativeLayout.LayoutParams(-2, -2);
        }
        this.f16893V.addRule(2, R.id_renamed.time_lapse_pro_setting_title);
        this.f16893V.removeRule(14);
        this.f16893V.removeRule(9);
        this.f16893V.removeRule(11);
        if (2 == this.f16901af.mo16539j() || 3 == this.f16901af.mo16539j()) {
            this.f16893V.bottomMargin = getResources().getDimensionPixelSize(R.dimen.blur_menu_seekbar_padding_bottom);
            return;
        }
        if (4 == this.f16901af.mo16539j()) {
            this.f16893V.width = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_scale_width_rack_screen);
            this.f16893V.addRule(14);
            this.f16893V.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_scale_margin_bottom_rack_screen) - getResources().getDimensionPixelSize(R.dimen.blur_menu_seekbar_padding_bottom);
            return;
        }
        this.f16893V.addRule(270 == this.f16901af.mo16570k() ? 11 : 9);
        this.f16893V.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_scale_margin_bottom_full_screen);
        RelativeLayout relativeLayout = this.f16872A;
        if (relativeLayout != null) {
            ((RelativeLayout.LayoutParams) relativeLayout.findViewById(R.id_renamed.auto_btn).getLayoutParams()).topMargin = Util.m24198Z() == 0 ? getResources().getDimensionPixelOffset(R.dimen.setting_auto_button_margin_vertical_top) : getResources().getDimensionPixelOffset(R.dimen.setting_auto_button_margin_vertical_top_with_nav);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17696c(boolean z, boolean z2) {
        RelativeLayout relativeLayout = this.f16872A;
        if (relativeLayout != null) {
            if (z2) {
                if (z || 1 == this.f16908am) {
                    if (z) {
                        Util.m24264a(this.f16872A, 0.0f, 1.0f, 400L, 150L, (Animation.AnimationListener) null, ProfessionalAnimConstant.f15694a);
                        return;
                    } else {
                        Util.m24268a(this.f16872A, 250, 0, ProfessionalAnimConstant.f15694a);
                        return;
                    }
                }
                return;
            }
            relativeLayout.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: D */
    private void m17639D() {
        this.f16890S = new ParameterContainer(this.f16926i, this.f16921d);
        m17640E();
        this.f16890S.setLayoutParams(this.f16894W);
        ParameterContainer c3066b = this.f16890S;
        BaseScreenMode abstractC2934a = this.f16901af;
        c3066b.m17573a(abstractC2934a, abstractC2934a.mo16539j(), this.f16901af.mo16570k());
        List<ProParameter> list = this.f16900ae;
        if (list != null) {
            this.f16890S.setParamList(list);
        }
        this.f16890S.setParameterCallback(new ParameterContainer.PlatformImplementations.kt_3() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11.3
            @Override // com.oplus.camera.timelapsepro.ParameterContainer.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17585a() {
                TimeLapseProMenuLayout.this.m17724s();
            }

            @Override // com.oplus.camera.timelapsepro.ParameterContainer.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17586a(String str, String str2) {
                TimeLapseProMenuLayout.this.m17667a(str, str2);
            }

            @Override // com.oplus.camera.timelapsepro.ParameterContainer.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17587a(String str, boolean z, String str2) {
                if (z) {
                    TimeLapseProMenuLayout.this.m17668a(str, (String) null, (String) null);
                    TimeLapseProMenuLayout.this.m17673a(true, true);
                } else {
                    TimeLapseProMenuLayout.this.m17673a(false, true);
                }
                if (str2 == null) {
                    TimeLapseProMenuLayout.this.m17685b((String) null, TimeLapseProMsgData.KEY_TIMELAPSEPRO_VALUE_CLEAR);
                } else {
                    TimeLapseProMenuLayout.this.m17706e(str2);
                }
            }

            @Override // com.oplus.camera.timelapsepro.ParameterContainer.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo17588b(String str, String str2) {
                if (str != null) {
                    if (2 == TimeLapseProMenuLayout.this.f16907al) {
                        TimeLapseProMenuLayout.this.m17671a(str, str2, null, true, true, 1500L);
                        return;
                    }
                    return;
                }
                TimeLapseProMenuLayout.this.m17673a(false, true);
            }

            @Override // com.oplus.camera.timelapsepro.ParameterContainer.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo17589c(String str, String str2) {
                TimeLapseProMenuLayout.this.f16915at = str;
                TimeLapseProMenuLayout.this.f16916au = str2;
                TimeLapseProMenuLayout.this.f16925h.sendEmptyMessage(12);
            }

            @Override // com.oplus.camera.timelapsepro.ParameterContainer.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_5 */
            public void mo17590d(String str, String str2) {
                TimeLapseProMenuLayout.this.f16915at = str;
                TimeLapseProMenuLayout.this.f16916au = str2;
                if (TimeLapseProMenuLayout.this.f16915at != null && TimeLapseProMenuLayout.this.f16915at.equals(str) && TimeLapseProMenuLayout.this.f16925h.hasMessages(12)) {
                    return;
                }
                TimeLapseProMenuLayout.this.f16925h.sendEmptyMessageDelayed(12, 1000L);
            }
        });
        if (this.f16890S.m17574b()) {
            addView(this.f16890S);
        }
        this.f16890S.setVisibility(8);
    }

    /* renamed from: E */
    private void m17640E() {
        if (this.f16894W == null) {
            this.f16894W = new RelativeLayout.LayoutParams(-2, -2);
        }
        this.f16894W.addRule(2, R.id_renamed.time_lapse_pro_setting_title);
        this.f16894W.removeRule(14);
        this.f16894W.removeRule(9);
        this.f16894W.removeRule(11);
        if (2 == this.f16901af.mo16539j() || 3 == this.f16901af.mo16539j() || 4 == this.f16901af.mo16539j()) {
            RelativeLayout.LayoutParams layoutParams = this.f16894W;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.addRule(14);
            this.f16894W.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_param_bottom_margin);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = this.f16894W;
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(270 == this.f16901af.mo16570k() ? 11 : 9);
        this.f16894W.bottomMargin = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m17702d(boolean z, boolean z2) {
        ParameterContainer c3066b = this.f16890S;
        if (c3066b != null) {
            if (!z) {
                c3066b.m17577e();
            }
            if (z2) {
                if (z || 2 == this.f16908am) {
                    if (z) {
                        Util.m24264a(this.f16890S, 0.0f, 1.0f, 400L, 150L, (Animation.AnimationListener) null, ProfessionalAnimConstant.f15694a);
                        return;
                    } else {
                        Util.m24268a(this.f16890S, 250, 0, ProfessionalAnimConstant.f15694a);
                        return;
                    }
                }
                return;
            }
            this.f16890S.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: F */
    private List<SpeedWrapper> m17641F() throws Resources.NotFoundException {
        ArrayList arrayList = new ArrayList();
        for (String str : getResources().getStringArray(R.array.time_lapse_pro_speeds)) {
            arrayList.add(new SpeedWrapper(str));
        }
        return arrayList;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public String m17749g() {
        if (this.f16943z != -1) {
            return getResources().getStringArray(R.array.time_lapse_pro_speeds)[this.f16943z];
        }
        return getResources().getStringArray(R.array.time_lapse_pro_speeds)[0];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17742a(String str) {
        m17694c(str);
    }

    /* renamed from: G */
    private List<DurationWrapper> m17642G() {
        ArrayList arrayList = new ArrayList();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 <= 240; OplusGLSurfaceView_13 += 5) {
            arrayList.add(new DurationWrapper(OplusGLSurfaceView_13));
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17741a(COUIBaseListPopupWindow_8 eVar) {
        if (this.f16922e.contains(eVar)) {
            return;
        }
        this.f16922e.add(eVar);
    }

    public void setTimeLapseProMenuListener(COUIBaseListPopupWindow_8 eVar) {
        if (eVar == null) {
            COUIBaseListPopupWindow_8 eVar2 = this.f16927j;
            if (eVar2 == null || !this.f16922e.contains(eVar2)) {
                return;
            }
            this.f16922e.remove(this.f16927j);
            this.f16927j = null;
            return;
        }
        this.f16927j = eVar;
        if (this.f16922e.contains(eVar)) {
            this.f16922e.remove(eVar);
        }
        this.f16922e.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f16924g.removeCallbacksAndMessages(null);
        this.f16925h.removeCallbacksAndMessages(null);
        this.f16925h.getLooper().quitSafely();
        this.f16922e.clear();
        this.f16923f.clear();
        this.f16926i = null;
        this.f16930m = null;
        this.f16929l = null;
        this.f16928k = null;
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17699d(int OplusGLSurfaceView_13) {
        Iterator<COUIBaseListPopupWindow_8> it = this.f16922e.iterator();
        while (it.hasNext()) {
            it.next().mo17765a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17695c(String str, int OplusGLSurfaceView_13) {
        if (str.equals(this.f16911ap)) {
            return;
        }
        m17666a("pref_time_lapse_pro_speed_key", OplusGLSurfaceView_13);
        this.f16911ap = str;
        Iterator<COUIBaseListPopupWindow_8> it = this.f16922e.iterator();
        while (it.hasNext()) {
            it.next().mo17767a(str);
        }
        m17694c(str);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17694c(String str) {
        COUIBaseListPopupWindow_8 eVar;
        List<DurationWrapper> list;
        if (this.f16874C != 0 && this.f16927j != null && (list = this.f16886O) != null && !list.isEmpty()) {
            DurationWrapper c3047a = this.f16886O.get(this.f16874C);
            c3047a.m17433a(str);
            this.f16927j.mo17766a(c3047a.m17431a());
        } else {
            if (this.f16874C != 0 || (eVar = this.f16927j) == null) {
                return;
            }
            eVar.mo17766a(0L);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17654a(long OplusGLSurfaceView_15) {
        Iterator<COUIBaseListPopupWindow_8> it = this.f16922e.iterator();
        while (it.hasNext()) {
            it.next().mo17766a(OplusGLSurfaceView_15);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17667a(String str, String str2) {
        Iterator<COUIBaseListPopupWindow_8> it = this.f16922e.iterator();
        while (it.hasNext()) {
            it.next().mo17768a(str, str2);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m17750h() {
        ParameterContainer c3066b = this.f16890S;
        if (c3066b != null) {
            c3066b.m17578f();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m17751i() {
        this.f16943z = -1;
        this.f16940w = true;
        TimeLapseProParamScaleBar timeLapseProParamScaleBar = this.f16942y;
        if (timeLapseProParamScaleBar != null) {
            timeLapseProParamScaleBar.m20768c(false);
            this.f16942y.m20766b(0);
        }
        InverseTextView inverseTextView = this.f16879H;
        if (inverseTextView != null) {
            inverseTextView.setInverseColor(this.f16940w);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17739a(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("TimeLapseProMenuLayout", "resetSpeed, speedIndex: " + OplusGLSurfaceView_13);
        TimeLapseProParamScaleBar timeLapseProParamScaleBar = this.f16942y;
        if (timeLapseProParamScaleBar != null) {
            if (timeLapseProParamScaleBar.getCurrentIndex() < OplusGLSurfaceView_13 || this.f16879H.m20148a()) {
                TimeLapseProParamScaleBar timeLapseProParamScaleBar2 = this.f16942y;
                if (timeLapseProParamScaleBar2 != null) {
                    timeLapseProParamScaleBar2.setCurrentIndex(OplusGLSurfaceView_13);
                }
                InverseTextView inverseTextView = this.f16879H;
                if (inverseTextView == null || inverseTextView.m20148a()) {
                    return;
                }
                this.f16879H.setInverseColor(true);
                this.f16940w = this.f16879H.m20148a();
                this.f16942y.setAutoState(this.f16940w);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m17752j() {
        this.f16874C = 0;
        TimeLapseProParamScaleBar timeLapseProParamScaleBar = this.f16873B;
        if (timeLapseProParamScaleBar != null) {
            timeLapseProParamScaleBar.m20766b(0);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m17753k() {
        Handler handler = this.f16924g;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    public void setProParameterList(List<ProParameter> list) {
        this.f16900ae = list;
    }

    public void setCurrentScreenMode(BaseScreenMode abstractC2934a) throws Resources.NotFoundException {
        m17648M();
        this.f16901af = abstractC2934a;
        m17679b(abstractC2934a.mo16539j(), abstractC2934a.mo16570k());
        m17643H();
    }

    /* renamed from: H */
    private void m17643H() throws Resources.NotFoundException {
        int iJ = this.f16901af.mo16539j();
        int iK = this.f16901af.mo16570k();
        this.f16937t.m17488a(this.f16901af, iJ, iK);
        this.f16904ai.setOrientation(1 == iJ ? 1 : 0);
        m17651a(iJ, iK);
        ParameterContainer c3066b = this.f16890S;
        if (c3066b != null) {
            c3066b.m17573a(this.f16901af, iJ, iK);
        }
        IntrinsicsJvm.kt_4 bVar = this.f16905aj;
        if (bVar != null) {
            bVar.m17761a(1 != iJ ? 2 : 1);
        }
        RelativeLayout relativeLayout = this.f16941x;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            this.f16942y = null;
            this.f16879H = null;
            removeView(this.f16941x);
            this.f16941x = null;
        }
        RelativeLayout relativeLayout2 = this.f16872A;
        if (relativeLayout2 != null) {
            relativeLayout2.removeAllViews();
            this.f16873B = null;
            removeView(this.f16872A);
            this.f16872A = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17651a(int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        int dimensionPixelOffset;
        LayoutUtil.m16634a(this.f16935r);
        if (OplusGLSurfaceView_13 == 1) {
            this.f16897ab.addRule(2, R.id_renamed.time_lapse_pro_layout_bottom_view);
            this.f16897ab.addRule(270 == i2 ? 11 : 9);
            this.f16897ab.width = getResources().getDimensionPixelOffset(R.dimen.setting_item_w_full_max);
            if (270 == this.f16901af.mo16570k() || 90 == this.f16901af.mo16570k()) {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_full_rotate_margin_bottom);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_full_margin_bottom);
            }
            this.f16897ab.bottomMargin = dimensionPixelOffset;
        } else if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 4) {
            this.f16897ab.addRule(12);
            this.f16897ab.addRule(14);
            this.f16897ab.width = -1;
        }
        m17636A();
        m17638C();
        m17640E();
        m17736y();
        this.f16935r.requestLayout();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17679b(int OplusGLSurfaceView_13, int i2) {
        this.f16933p.m17488a(this.f16901af, OplusGLSurfaceView_13, i2);
        this.f16902ag.setOrientation(1 == OplusGLSurfaceView_13 ? 1 : 0);
        m17692c(OplusGLSurfaceView_13, i2);
        IntrinsicsJvm.kt_4 bVar = this.f16903ah;
        if (bVar != null) {
            if (3 == OplusGLSurfaceView_13) {
                bVar.m17762b(getResources().getDimensionPixelOffset(R.dimen.template_item_interval_split) / 2);
            } else {
                bVar.m17762b(getResources().getDimensionPixelOffset(R.dimen.template_item_interval) / 2);
            }
            if (1 == OplusGLSurfaceView_13) {
                this.f16931n.removeItemDecoration(this.f16903ah);
            } else if (this.f16931n.getItemDecorationCount() == 0) {
                this.f16931n.addItemDecoration(this.f16903ah);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17692c(int OplusGLSurfaceView_13, int i2) {
        LayoutUtil.m16634a(this.f16931n);
        if (OplusGLSurfaceView_13 == 1) {
            this.f16896aa.addRule(10);
            this.f16896aa.topMargin = getResources().getDimensionPixelOffset(R.dimen.template_margin_top_full);
            if (270 == i2) {
                this.f16896aa.addRule(11);
                this.f16896aa.rightMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_full_template_margin_start);
            } else {
                this.f16896aa.leftMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_full_template_margin_start);
                this.f16896aa.addRule(9);
            }
        } else if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3) {
            this.f16896aa.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.template_margin_bottom);
            this.f16896aa.addRule(14);
        } else if (OplusGLSurfaceView_13 == 4) {
            this.f16896aa.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_template_rack_margin_bottom);
            this.f16896aa.addRule(14);
        }
        this.f16931n.requestLayout();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m17754l() {
        this.f16906ak = this.f16891T != 0;
        m17653a(R.string.time_lapse_pro_hint_template_format, this.f16891T == 0, this.f16932o.get(this.f16891T).m17467b());
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m17755m() {
        if (2 == this.f16939v) {
            m17702d(false, true);
        }
    }

    public void setAnimationState(boolean z) {
        this.f16914as = z;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public boolean m17756n() {
        return this.f16914as;
    }

    /* renamed from: o */
    public void m17757o() {
        m17686b(m17745c());
    }

    /* renamed from: p */
    public void m17758p() {
        ParameterContainer c3066b = this.f16890S;
        if (c3066b != null) {
            c3066b.m17579g();
        }
    }

    /* renamed from: q */
    public void m17759q() {
        RecyclerView recyclerView = this.f16931n;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
            TemplateAdapter c3065b = this.f16933p;
            if (c3065b != null) {
                this.f16918aw = null;
                c3065b.mo17470a();
                this.f16933p = null;
            }
        }
        RecyclerView recyclerView2 = this.f16934q;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(null);
            SubSettingAdapter subSettingAdapter = this.f16937t;
            if (subSettingAdapter != null) {
                this.f16917av = null;
                subSettingAdapter.mo17470a();
                this.f16937t = null;
            }
        }
        ParameterContainer c3066b = this.f16890S;
        if (c3066b != null) {
            c3066b.m17575c();
        }
        removeAllViews();
        this.f16926i = null;
        this.f16924g.removeCallbacksAndMessages(null);
        this.f16925h.removeCallbacksAndMessages(null);
        this.f16925h.getLooper().quitSafely();
        this.f16922e.clear();
        this.f16923f.clear();
        this.f16930m = null;
        this.f16929l = null;
        this.f16928k = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17740a(IntrinsicsJvm.kt_5 dVar) {
        if (this.f16923f.contains(dVar)) {
            return;
        }
        this.f16923f.add(dVar);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17744b(IntrinsicsJvm.kt_5 dVar) {
        if (this.f16923f.contains(dVar)) {
            this.f16923f.remove(dVar);
        }
    }

    /* renamed from: I */
    private void m17644I() {
        Iterator<IntrinsicsJvm.kt_5> it = this.f16923f.iterator();
        while (it.hasNext()) {
            it.next().mo17763a();
        }
    }

    /* renamed from: J */
    private void m17645J() {
        Iterator<IntrinsicsJvm.kt_5> it = this.f16923f.iterator();
        while (it.hasNext()) {
            it.next().mo17764b();
        }
    }

    public void setReportCallback(COUIBaseListPopupWindow_12 fVar) {
        this.f16928k = fVar;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17686b(boolean z) {
        COUIBaseListPopupWindow_12 fVar = this.f16928k;
        if (fVar != null) {
            fVar.mo17772a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m17703e(int OplusGLSurfaceView_13) {
        COUIBaseListPopupWindow_12 fVar = this.f16928k;
        if (fVar != null) {
            fVar.mo17769a(OplusGLSurfaceView_13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m17646K() {
        if (this.f16925h.hasMessages(10)) {
            return;
        }
        this.f16925h.sendEmptyMessageDelayed(10, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17701d(String str) {
        m17685b(TimeLapseProMsgData.KEY_TIMELAPSEPRO_INTERVAL, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public void m17647L() {
        if (this.f16925h.hasMessages(11)) {
            return;
        }
        this.f16925h.sendEmptyMessageDelayed(11, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m17707f(int OplusGLSurfaceView_13) {
        m17685b(TimeLapseProMsgData.KEY_TIMELAPSEPRO_TIMER, OplusGLSurfaceView_13 == 0 ? "auto" : String.valueOf(OplusGLSurfaceView_13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17685b(String str, String str2) {
        COUIBaseListPopupWindow_12 fVar = this.f16928k;
        if (fVar != null) {
            fVar.mo17771a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m17706e(String str) {
        COUIBaseListPopupWindow_12 fVar = this.f16928k;
        if (fVar != null) {
            fVar.mo17770a(str);
        }
    }

    /* renamed from: M */
    private void m17648M() {
        IntrinsicsJvm.kt_3 cVar = this.f16929l;
        if (cVar != null) {
            cVar.onChanged();
        }
    }

    public void setChangeScreenModeListener(IntrinsicsJvm.kt_3 cVar) {
        this.f16929l = cVar;
    }

    public void setHintCallback(PlatformImplementations.kt_3 aVar) {
        this.f16930m = aVar;
    }

    /* compiled from: TimeLapseProMenuLayout.java */
    /* renamed from: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 extends RecyclerView.AbstractC0692h {

        /* renamed from: PlatformImplementations.kt_3 */
        private int f16956a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f16957b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f16958c;

        public IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13) {
            this.f16956a = 2;
            this.f16957b = 0;
            this.f16958c = 0;
            this.f16958c = OplusGLSurfaceView_13;
        }

        public IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13, int i2) {
            this.f16956a = 2;
            this.f16957b = 0;
            this.f16958c = 0;
            this.f16957b = OplusGLSurfaceView_13;
            this.f16958c = i2;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m17761a(int OplusGLSurfaceView_13) {
            this.f16956a = OplusGLSurfaceView_13;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m17762b(int OplusGLSurfaceView_13) {
            this.f16958c = OplusGLSurfaceView_13;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0692h
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0704t c0704t) {
            int OplusGLSurfaceView_13;
            int i2 = this.f16958c;
            int i3 = this.f16957b;
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                OplusGLSurfaceView_13 = i3;
                i3 = 0;
            } else {
                OplusGLSurfaceView_13 = (recyclerView.getAdapter() == null || recyclerView.getAdapter().getItemCount() - 1 != recyclerView.getChildAdapterPosition(view)) ? i3 : 0;
            }
            CameraLog.m12954a("TimeLapseProMenuLayout", "getItemOffsets, width: " + recyclerView.getChildViewHolder(view).itemView.getWidth() + ", index: " + recyclerView.getChildAdapterPosition(view));
            if (this.f16956a == 1) {
                rect.set(0, i3, 0, OplusGLSurfaceView_13);
            } else {
                rect.set(i2, 0, i2, 0);
            }
        }
    }
}
