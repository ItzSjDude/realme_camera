package com.oplus.camera.p172ui.p173a;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintInfo;
import com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintView;
import com.oplus.camera.p172ui.menu.setting.CameraMenuOption;
import com.oplus.camera.p172ui.p173a.HintModel;
import com.oplus.camera.p172ui.preview.AISceneUI;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: HintManager.java */
/* renamed from: com.oplus.camera.ui.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class HintManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f17419a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f17420b;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Resources f17423e;

    /* renamed from: w */
    private CameraUIInterface f17441w;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f17421c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f17422d = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ViewGroup f17424f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CameraScreenHintView f17425g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private CameraScreenHintView f17426h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private CameraScreenHintView f17427i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private ArrayList<CameraScreenHintView> f17428j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private AISceneUI f17429k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f17430l = 0;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f17431m = 0;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f17432n = 0;

    /* renamed from: o */
    private int f17433o = 0;

    /* renamed from: p */
    private int f17434p = 0;

    /* renamed from: q */
    private int f17435q = 0;

    /* renamed from: r */
    private int f17436r = -1;

    /* renamed from: s */
    private int f17437s = 0;

    /* renamed from: t */
    private boolean f17438t = false;

    /* renamed from: u */
    private long f17439u = 0;

    /* renamed from: v */
    private String f17440v = null;

    /* renamed from: x */
    private ArrayList<HintModel> f17442x = new ArrayList<>();

    /* renamed from: y */
    private ArrayList<HintModel> f17443y = new ArrayList<>();

    /* renamed from: z */
    private ArrayList<HintModel> f17444z = new ArrayList<>();

    /* renamed from: A */
    private ArrayList<HintModel> f17412A = new ArrayList<>();

    /* renamed from: B */
    private ArrayList<HintModel> f17413B = new ArrayList<>();

    /* renamed from: C */
    private List<Integer> f17414C = new ArrayList();

    /* renamed from: D */
    private Map<Integer, String> f17415D = new ConcurrentHashMap();

    /* renamed from: F */
    private IntrinsicsJvm.kt_4 f17417F = null;

    /* renamed from: G */
    private boolean f17418G = false;

    /* renamed from: E */
    private Handler f17416E = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.PlatformImplementations.kt_3.PlatformImplementations.kt_3.1
        @Override // android.os.Handler
        public void handleMessage(Message message) throws NumberFormatException {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 1) {
                int i2 = Integer.parseInt((String) message.obj);
                HintManager.this.m18451a(i2, true);
                if (HintManager.this.f17417F != null) {
                    HintManager.this.f17417F.mo14770a(i2);
                    return;
                }
                return;
            }
            if (OplusGLSurfaceView_13 == 2) {
                HintManager.this.m18493b(true);
            } else if (OplusGLSurfaceView_13 == 3) {
                HintManager.this.m18467l();
            } else {
                if (OplusGLSurfaceView_13 != 4) {
                    return;
                }
                HintManager.this.m18466k();
            }
        }
    };

    /* compiled from: HintManager.java */
    /* renamed from: com.oplus.camera.ui.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo18506a();
    }

    /* compiled from: HintManager.java */
    /* renamed from: com.oplus.camera.ui.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo14770a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo14771a(HintModel c3131b);
    }

    /* compiled from: HintManager.java */
    /* renamed from: com.oplus.camera.ui.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 implements PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final String f17452a;

        public IntrinsicsJvm.kt_3(String str) {
            this.f17452a = str;
        }

        @Override // com.oplus.camera.p172ui.p173a.HintManager.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18506a() {
            if (HintManager.this.f17428j == null || HintManager.this.f17428j.isEmpty()) {
                return;
            }
            Iterator it = HintManager.this.f17428j.iterator();
            while (it.hasNext()) {
                CameraScreenHintView cameraScreenHintView = (CameraScreenHintView) it.next();
                Object tag = cameraScreenHintView.getTag(R.id_renamed.hint_prev_margins_tag);
                if (tag instanceof int[]) {
                    int[] iArr = (int[]) tag;
                    if (iArr.length == 2) {
                        cameraScreenHintView.m18801a(iArr[0], iArr[1]);
                    }
                }
            }
        }
    }

    public HintManager(Resources resources, CameraUIInterface cameraUIInterface) {
        this.f17419a = 0;
        this.f17420b = 0;
        this.f17423e = null;
        this.f17441w = cameraUIInterface;
        this.f17423e = resources;
        this.f17419a = this.f17423e.getDimensionPixelOffset(R.dimen.hint_margin_top_horizontal);
        this.f17420b = this.f17423e.getDimensionPixelOffset(R.dimen.hint_margin_top_vertical);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_5 */
    public void m18466k() {
        m18489a(this.f17414C.get(this.f17436r).intValue());
        this.f17416E.sendEmptyMessageDelayed(3, 3000L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18487a(List<Integer> list, long OplusGLSurfaceView_15) {
        if (!this.f17414C.isEmpty()) {
            this.f17414C.clear();
        }
        this.f17414C.addAll(list);
        this.f17439u = OplusGLSurfaceView_15;
        m18467l();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18472a() {
        if (this.f17414C == null) {
            return;
        }
        CameraLog.m12962c("HintManager", "hideLooperCameraScreenHintText");
        this.f17416E.removeMessages(3);
        this.f17416E.removeMessages(4);
        m18496c(false);
        this.f17414C.clear();
        this.f17436r = -1;
        this.f17439u = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public void m18467l() {
        this.f17436r = (this.f17436r + 1) % this.f17414C.size();
        m18476a(this.f17414C.get(this.f17436r).intValue(), true, false, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, 0, false);
        this.f17416E.sendEmptyMessageDelayed(4, this.f17439u);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18484a(IntrinsicsJvm.kt_4 bVar) {
        this.f17417F = bVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18488a(boolean z) {
        CameraLog.m12962c("HintManager", "setManual: " + this.f17438t + " -> " + z);
        this.f17438t = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m18494b() {
        return this.f17438t;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m18497c() {
        return !this.f17442x.isEmpty();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m18490a(String str) {
        String str2;
        return this.f17438t && (str2 = this.f17440v) != null && str2.equals(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18492b(String str) {
        CameraLog.m12962c("HintManager", "setManualKey: " + this.f17440v + " -> " + str);
        this.f17440v = str;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m18498d() {
        return this.f17440v;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18482a(ViewGroup viewGroup) {
        this.f17424f = viewGroup;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18485a(CameraScreenHintView cameraScreenHintView, CameraScreenHintView cameraScreenHintView2, CameraScreenHintView cameraScreenHintView3) {
        this.f17425g = cameraScreenHintView;
        this.f17426h = cameraScreenHintView2;
        this.f17427i = cameraScreenHintView3;
        this.f17428j = new ArrayList<>();
        this.f17428j.add(this.f17425g);
        this.f17428j.add(this.f17426h);
        this.f17428j.add(this.f17427i);
        this.f17421c = this.f17423e.getDimensionPixelOffset(R.dimen.hint_right_hint_view_height);
        this.f17437s = Util.m24184L();
        CameraScreenHintView cameraScreenHintView4 = this.f17427i;
        int OplusGLSurfaceView_13 = this.f17420b;
        int i2 = this.f17421c;
        cameraScreenHintView4.m18801a(OplusGLSurfaceView_13 + i2, OplusGLSurfaceView_13 + i2);
        this.f17425g.setTag(R.id_renamed.hint_model_tag, null);
        this.f17426h.setTag(R.id_renamed.hint_model_tag, null);
        this.f17427i.setTag(R.id_renamed.hint_model_tag, null);
        this.f17425g.setTag(TtmlNode.LEFT);
        this.f17426h.setTag(TtmlNode.RIGHT);
        this.f17427i.setTag(TtmlNode.CENTER);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18486a(AISceneUI abstractC3391a) {
        this.f17429k = abstractC3391a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public PlatformImplementations.kt_3 m18471a(int OplusGLSurfaceView_13, int i2) {
        ArrayList<CameraScreenHintView> arrayList = this.f17428j;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        Iterator<CameraScreenHintView> it = this.f17428j.iterator();
        while (it.hasNext()) {
            CameraScreenHintView next = it.next();
            next.setTag(R.id_renamed.hint_prev_margins_tag, new int[]{next.getMarginLeft() - next.getViewGap(), next.getMarginTop() - next.getViewGap()});
            next.m18801a(OplusGLSurfaceView_13, i2);
        }
        return new IntrinsicsJvm.kt_3("updateMarginLeftAndTop");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18473a(int OplusGLSurfaceView_13) {
        if (!this.f17444z.isEmpty()) {
            this.f17444z.clear();
            m18458a(this.f17413B, HintModel.PlatformImplementations.kt_3.SPECIAL);
        }
        if (!this.f17442x.isEmpty()) {
            this.f17442x.clear();
            m18458a(this.f17413B, HintModel.PlatformImplementations.kt_3.TEMP);
        }
        HintModel c3131b = new HintModel();
        c3131b.f17474s = HintModel.PlatformImplementations.kt_3.SPECIAL;
        c3131b.f17473r = HintModel.IntrinsicsJvm.kt_4.AI_SCENE;
        c3131b.f17470o = OplusGLSurfaceView_13;
        m18454a(c3131b);
        m18468m();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m18500e() {
        Iterator<HintModel> it = this.f17444z.iterator();
        while (it.hasNext()) {
            if (HintModel.IntrinsicsJvm.kt_4.AI_SCENE == it.next().f17473r) {
                it.remove();
            }
        }
        Iterator<HintModel> it2 = this.f17413B.iterator();
        while (it2.hasNext()) {
            if (HintModel.IntrinsicsJvm.kt_4.AI_SCENE == it2.next().f17473r) {
                it2.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public void m18468m() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.f17416E.post(new Runnable() { // from class: com.oplus.camera.ui.PlatformImplementations.kt_3.PlatformImplementations.kt_3.2
                @Override // java.lang.Runnable
                public void run() {
                    HintManager.this.m18468m();
                }
            });
            return;
        }
        if (this.f17413B.isEmpty()) {
            m18456a(this.f17425g);
            m18456a(this.f17426h);
            m18456a(this.f17427i);
            m18469n();
            return;
        }
        if (!this.f17442x.isEmpty()) {
            m18455a(this.f17442x.get(0), this.f17425g, false);
            m18456a(this.f17426h);
            m18456a(this.f17427i);
            this.f17429k.mo22220c(8);
            m18469n();
            return;
        }
        if (!this.f17443y.isEmpty() && !this.f17444z.isEmpty() && !this.f17412A.isEmpty()) {
            m18455a(this.f17444z.get(0), this.f17425g, false);
            m18455a(this.f17412A.get(0), this.f17426h, false);
            m18455a(this.f17443y.get(0), this.f17427i, true);
        } else if (!this.f17444z.isEmpty() && !this.f17412A.isEmpty()) {
            m18455a(this.f17444z.get(0), this.f17425g, false);
            m18455a(this.f17412A.get(0), this.f17426h, false);
            m18456a(this.f17427i);
        } else if (!this.f17412A.isEmpty() && !this.f17443y.isEmpty()) {
            m18455a(this.f17412A.get(0), this.f17425g, false);
            m18455a(this.f17443y.get(0), this.f17427i, true);
            m18456a(this.f17426h);
        } else if (!this.f17443y.isEmpty() && !this.f17444z.isEmpty()) {
            m18455a(this.f17444z.get(0), this.f17425g, false);
            m18455a(this.f17443y.get(0), this.f17427i, true);
            m18456a(this.f17426h);
        } else {
            m18455a(this.f17413B.get(0), this.f17425g, false);
            m18456a(this.f17426h);
            m18456a(this.f17427i);
        }
        m18469n();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18457a(CameraScreenHintView cameraScreenHintView, boolean z) {
        String str = (String) cameraScreenHintView.getTag();
        Object tag = cameraScreenHintView.getTag(R.id_renamed.hint_model_tag);
        if (tag == null) {
            CameraLog.m12962c("HintManager", "clearViewNoAnim:return: " + str);
            if (cameraScreenHintView.m18820i() && z) {
                cameraScreenHintView.m18815d();
                cameraScreenHintView.m18813b(false);
                cameraScreenHintView.m18808a(false);
                return;
            }
            return;
        }
        HintModel c3131b = (HintModel) tag;
        cameraScreenHintView.m18808a(!z && c3131b.f17466k);
        cameraScreenHintView.m18813b(!z && c3131b.f17465j);
        if (z || !c3131b.f17465j) {
            cameraScreenHintView.m18819h();
        }
        cameraScreenHintView.setTag(R.id_renamed.hint_model_tag, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18456a(CameraScreenHintView cameraScreenHintView) {
        m18457a(cameraScreenHintView, false);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m18501f() {
        this.f17424f.removeView(this.f17425g);
        this.f17424f.removeView(this.f17426h);
        this.f17424f.removeView(this.f17427i);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m18469n() {
        boolean zMo22232i = this.f17429k.mo22232i();
        int OplusGLSurfaceView_13 = this.f17432n;
        if (1 == OplusGLSurfaceView_13) {
            this.f17435q = this.f17423e.getDimensionPixelOffset(R.dimen.fold_full_AI_scene_view_margin_top_offset);
            if (this.f17433o != 0) {
                this.f17435q = this.f17423e.getDimensionPixelOffset(R.dimen.fold_full_AI_scene_view_margin_top_offset_rotate);
            }
        } else if (4 == OplusGLSurfaceView_13) {
            this.f17435q = this.f17423e.getDimensionPixelOffset(R.dimen.rack_mode_AI_scene_view_margin_top_offset);
        } else {
            this.f17435q = 0;
        }
        CameraLog.m12962c("HintManager", "requestLayout:\nleft:" + this.f17425g.getTag(R.id_renamed.hint_model_tag) + "\nright:" + this.f17426h.getTag(R.id_renamed.hint_model_tag) + "\ncenter:" + this.f17427i.getTag(R.id_renamed.hint_model_tag) + "\nisAISceneShow:" + zMo22232i + "\OplusGLSurfaceView_11");
        if (this.f17426h.getTag(R.id_renamed.hint_model_tag) == null) {
            if (zMo22232i) {
                this.f17429k.mo22210a(0, this.f17435q, this.f17434p, this.f17418G);
            } else {
                this.f17425g.m18812b(0);
            }
            this.f17426h.setAlpha(0.0f);
            return;
        }
        int textWidth = this.f17426h.getTextWidth();
        if (zMo22232i) {
            RelativeLayout relativeLayoutMo22228g = this.f17429k.mo22228g();
            iconWidth = relativeLayoutMo22228g != null ? relativeLayoutMo22228g.getMeasuredWidth() : 0;
            this.f17429k.mo22210a((textWidth + this.f17419a) / 2, this.f17435q, this.f17434p, this.f17418G);
        } else if (this.f17425g.getAlpha() != 0.0f) {
            iconWidth = HintModel.IntrinsicsJvm.kt_4.ICON == ((HintModel) this.f17425g.getTag(R.id_renamed.hint_model_tag)).f17473r ? this.f17425g.getIconWidth() : this.f17425g.getMeasuredWidth();
            this.f17425g.m18812b(textWidth + this.f17419a);
        }
        this.f17426h.setAlpha(1.0f);
        this.f17426h.m18812b(-(iconWidth + this.f17419a));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private HintModel m18461b(CameraScreenHintView cameraScreenHintView) {
        Object tag = cameraScreenHintView.getTag(R.id_renamed.hint_model_tag);
        if (tag instanceof HintModel) {
            return (HintModel) tag;
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18455a(HintModel c3131b, CameraScreenHintView cameraScreenHintView, boolean z) {
        String strM24245a;
        if (c3131b == null || cameraScreenHintView == null) {
            return;
        }
        if (!c3131b.equals(m18461b(cameraScreenHintView))) {
            m18457a(cameraScreenHintView, true);
        }
        cameraScreenHintView.setTag(R.id_renamed.hint_model_tag, c3131b);
        cameraScreenHintView.bringToFront();
        CameraUIInterface cameraUIInterface = this.f17441w;
        int OplusGLSurfaceView_13 = (cameraUIInterface == null || !cameraUIInterface.mo18181bd() || Util.m24495t()) ? 0 : this.f17437s;
        int i2 = DoubleExposureMode_3.f17450a[c3131b.f17473r.ordinal()];
        if (i2 == 1) {
            if (cameraScreenHintView != this.f17427i) {
                cameraScreenHintView.m18800a(this.f17423e.getDimensionPixelOffset(R.dimen.hint_icon_margin_top) + OplusGLSurfaceView_13);
            } else {
                cameraScreenHintView.m18800a(this.f17420b + this.f17421c + OplusGLSurfaceView_13);
            }
            cameraScreenHintView.setIconAlpha(1.0f);
            cameraScreenHintView.m18803a(c3131b.f17457b, c3131b.f17460e, c3131b.f17461f, c3131b.f17469n, c3131b.f17462g, c3131b.f17471p);
            m18463c(cameraScreenHintView);
            cameraScreenHintView.setAlpha(1.0f);
            return;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            cameraScreenHintView.setAlpha(0.0f);
            this.f17429k.mo22223d(OplusGLSurfaceView_13);
            this.f17429k.mo22220c(0);
            return;
        }
        if (cameraScreenHintView != this.f17427i) {
            cameraScreenHintView.m18800a(OplusGLSurfaceView_13);
        } else {
            cameraScreenHintView.m18800a(this.f17420b + this.f17421c + OplusGLSurfaceView_13);
        }
        if (c3131b.f17458c > -1) {
            strM24245a = Util.m24244a(c3131b.f17456a, c3131b.f17458c, c3131b.f17472q);
        } else {
            strM24245a = Util.m24245a(c3131b.f17456a, c3131b.f17472q);
        }
        if (z) {
            cameraScreenHintView.setChangeHintColor(true);
            cameraScreenHintView.m18806a(new CameraScreenHintInfo.PlatformImplementations.kt_3().m18845a(strM24245a).m18844a(0).m18846a(c3131b.f17459d).m18849b(false).m18850c(c3131b.f17469n).m18852d(c3131b.f17471p).m18851c(c3131b.f17463h).m18853d(c3131b.f17462g).m18847a());
        } else {
            if (c3131b.f17468m > 0 && c3131b.f17467l > 0) {
                cameraScreenHintView.setChangeHintColor(true);
            }
            cameraScreenHintView.m18806a(new CameraScreenHintInfo.PlatformImplementations.kt_3().m18845a(strM24245a).m18846a(true).m18849b(false).m18852d(c3131b.f17471p).m18844a(c3131b.f17467l).m18848b(c3131b.f17468m).m18851c(c3131b.f17463h).m18854e(c3131b.f17464i).m18853d(c3131b.f17462g).m18847a());
        }
        m18463c(cameraScreenHintView);
        cameraScreenHintView.setAlpha(1.0f);
    }

    /* compiled from: HintManager.java */
    /* renamed from: com.oplus.camera.ui.PlatformImplementations.kt_3.PlatformImplementations.kt_3$4, reason: invalid class name */
    static /* synthetic */ class DoubleExposureMode_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f17450a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        static final /* synthetic */ int[] f17451b = new int[HintModel.PlatformImplementations.kt_3.values().length];

        static {
            try {
                f17451b[HintModel.PlatformImplementations.kt_3.TEMP_COMPATIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17451b[HintModel.PlatformImplementations.kt_3.SPECIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17451b[HintModel.PlatformImplementations.kt_3.CONDITION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17451b[HintModel.PlatformImplementations.kt_3.TEMP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17451b[HintModel.PlatformImplementations.kt_3.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f17450a = new int[HintModel.IntrinsicsJvm.kt_4.values().length];
            try {
                f17450a[HintModel.IntrinsicsJvm.kt_4.ICON.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17450a[HintModel.IntrinsicsJvm.kt_4.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17450a[HintModel.IntrinsicsJvm.kt_4.AI_SCENE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18454a(HintModel c3131b) {
        if (c3131b == null) {
            return;
        }
        int OplusGLSurfaceView_13 = DoubleExposureMode_3.f17451b[c3131b.f17474s.ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            this.f17443y.add(0, c3131b);
            if (this.f17443y.size() > 2) {
                ArrayList<HintModel> arrayList = this.f17443y;
                HintModel c3131b2 = arrayList.get(arrayList.size() - 1);
                ArrayList<HintModel> arrayList2 = this.f17443y;
                arrayList2.remove(arrayList2.size() - 1);
                this.f17413B.remove(c3131b2);
            }
        } else if (OplusGLSurfaceView_13 == 2) {
            this.f17444z.add(0, c3131b);
            if (this.f17444z.size() > 2) {
                ArrayList<HintModel> arrayList3 = this.f17444z;
                HintModel c3131b3 = arrayList3.get(arrayList3.size() - 1);
                ArrayList<HintModel> arrayList4 = this.f17444z;
                arrayList4.remove(arrayList4.size() - 1);
                this.f17413B.remove(c3131b3);
            }
        } else if (OplusGLSurfaceView_13 == 3) {
            this.f17412A.add(0, c3131b);
            if (this.f17412A.size() > 3) {
                ArrayList<HintModel> arrayList5 = this.f17412A;
                HintModel c3131b4 = arrayList5.get(arrayList5.size() - 1);
                ArrayList<HintModel> arrayList6 = this.f17412A;
                arrayList6.remove(arrayList6.size() - 1);
                this.f17413B.remove(c3131b4);
            }
        } else {
            this.f17442x.add(0, c3131b);
            if (this.f17442x.size() > 2) {
                ArrayList<HintModel> arrayList7 = this.f17442x;
                HintModel c3131b5 = arrayList7.get(arrayList7.size() - 1);
                m18459a(this.f17442x, c3131b5);
                m18459a(this.f17413B, c3131b5);
            }
        }
        this.f17413B.add(0, c3131b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18459a(ArrayList<HintModel> arrayList, HintModel c3131b) {
        if (c3131b == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                size = -1;
                break;
            } else if (c3131b.equals(arrayList.get(size))) {
                break;
            } else {
                size--;
            }
        }
        if (size >= 0) {
            arrayList.remove(size);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18476a(int OplusGLSurfaceView_13, boolean z, boolean z2, int i2, int i3, int i4, boolean z3) {
        m18477a(OplusGLSurfaceView_13, z, z2, i2, i3, i4, z3, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18477a(int OplusGLSurfaceView_13, boolean z, boolean z2, int i2, int i3, int i4, boolean z3, Object... objArr) {
        m18475a(OplusGLSurfaceView_13, z, z2, 3000, i2, i3, i4, false, z3, false, -1, objArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18479a(int OplusGLSurfaceView_13, boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, Object... objArr) {
        m18475a(OplusGLSurfaceView_13, z, z2, i2, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, i3, z3, z4, z5, -1, objArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18478a(int OplusGLSurfaceView_13, boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, Object... objArr) {
        m18475a(OplusGLSurfaceView_13, z, z2, i2, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, i3, z3, z4, z5, i4, objArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18474a(int OplusGLSurfaceView_13, boolean z, boolean z2, int i2, int i3, int i4, int i5, boolean z3, boolean z4, boolean z5) {
        m18475a(OplusGLSurfaceView_13, z, z2, i2, i3, i4, i5, z3, z4, z5, -1, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18475a(int OplusGLSurfaceView_13, boolean z, boolean z2, int i2, int i3, int i4, int i5, boolean z3, boolean z4, boolean z5, int i6, Object... objArr) {
        int iM18470o;
        CameraMenuOption cameraMenuOptionMo18220h;
        ComboPreferences comboPreferences;
        if (2 == this.f17422d && Util.m24495t()) {
            CameraUIInterface cameraUIInterface = this.f17441w;
            iM18470o = (cameraUIInterface == null || (cameraMenuOptionMo18220h = cameraUIInterface.mo18220h(CameraUIInterface.KEY_TORCH_MODE)) == null || (comboPreferences = cameraMenuOptionMo18220h.f19918a) == null || "on".equals(comboPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, "off")) || Util.m24498u()) ? i3 : R.drawable.screen_hint_textview_white_bg;
            int i7 = this.f17430l;
            if (i7 % 180 == 0) {
                i7 = 0;
            }
            if (i7 != 0 && !Util.m24498u()) {
                iM18470o = R.drawable.screen_hint_textview_bg;
            }
        } else {
            iM18470o = i3;
        }
        if (1 == this.f17432n) {
            iM18470o = m18470o();
        }
        HintModel c3131b = new HintModel(OplusGLSurfaceView_13, z, z2, i2, iM18470o, i4, i5, z3, z4, z5, i6, objArr);
        CameraLog.m12962c("HintManager", "showHint:" + c3131b.toString());
        IntrinsicsJvm.kt_4 bVar = this.f17417F;
        if (bVar != null) {
            bVar.mo14771a(c3131b);
        }
        m18454a(c3131b);
        m18468m();
        if (z2) {
            if (this.f17416E.hasMessages(1, m18448a(Integer.valueOf(OplusGLSurfaceView_13)))) {
                this.f17416E.removeMessages(1, m18448a(Integer.valueOf(OplusGLSurfaceView_13)));
            }
            this.f17416E.sendMessageDelayed(this.f17416E.obtainMessage(1, m18448a(Integer.valueOf(OplusGLSurfaceView_13))), i2 + i5);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18491b(int OplusGLSurfaceView_13) {
        this.f17422d = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m18448a(Integer num) {
        if (!this.f17415D.containsKey(num)) {
            this.f17415D.put(num, num.toString());
        }
        return this.f17415D.get(num);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18480a(int OplusGLSurfaceView_13, boolean z, boolean z2, int i2, boolean z3, int i3) {
        HintModel c3131b = new HintModel(OplusGLSurfaceView_13, z, z2, i2, z3, i3);
        CameraLog.m12962c("HintManager", "showHintImage:" + c3131b.toString());
        m18454a(c3131b);
        m18468m();
        if (z2) {
            this.f17416E.sendMessageDelayed(this.f17416E.obtainMessage(2, OplusGLSurfaceView_13, 0), i2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18493b(boolean z) {
        HintModel c3131b = (HintModel) this.f17425g.getTag(R.id_renamed.hint_model_tag);
        CameraLog.m12962c("HintManager", "hideHintImage:" + z + ";" + c3131b);
        if (c3131b != null && HintModel.PlatformImplementations.kt_3.SPECIAL == c3131b.f17474s) {
            c3131b.f17466k = z;
        }
        Iterator<HintModel> it = this.f17444z.iterator();
        while (it.hasNext()) {
            HintModel next = it.next();
            if (next.f17473r != HintModel.IntrinsicsJvm.kt_4.AI_SCENE) {
                it.remove();
                this.f17413B.remove(next);
            }
        }
        m18468m();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18458a(ArrayList<HintModel> arrayList, HintModel.PlatformImplementations.kt_3 aVar) {
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator<HintModel> it = arrayList.iterator();
        while (it.hasNext()) {
            if (aVar == it.next().f17474s) {
                it.remove();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m18463c(CameraScreenHintView cameraScreenHintView) {
        if (this.f17424f.indexOfChild(cameraScreenHintView) != -1) {
            return;
        }
        this.f17424f.addView(cameraScreenHintView);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m18502g() {
        this.f17442x.clear();
        m18458a(this.f17413B, HintModel.PlatformImplementations.kt_3.TEMP);
        m18468m();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18496c(boolean z) {
        CameraLog.m12962c("HintManager", "hideHint:" + z);
        if (this.f17416E.hasMessages(1)) {
            this.f17416E.removeMessages(1);
        }
        Iterator<CameraScreenHintView> it = this.f17428j.iterator();
        while (it.hasNext()) {
            HintModel c3131b = (HintModel) it.next().getTag(R.id_renamed.hint_model_tag);
            if (c3131b != null) {
                c3131b.f17466k = z;
                c3131b.f17465j = z;
            }
        }
        this.f17413B.clear();
        this.f17443y.clear();
        this.f17442x.clear();
        this.f17444z.clear();
        this.f17412A.clear();
        this.f17416E.removeCallbacksAndMessages(null);
        this.f17415D.clear();
        m18468m();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18489a(int... iArr) {
        if (iArr == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int OplusGLSurfaceView_13 : iArr) {
            sb.append(this.f17423e.getString(OplusGLSurfaceView_13));
            sb.append(", ");
            if (this.f17416E.hasMessages(1, m18448a(Integer.valueOf(OplusGLSurfaceView_13)))) {
                this.f17416E.removeMessages(1, m18448a(Integer.valueOf(OplusGLSurfaceView_13)));
            }
            m18450a(OplusGLSurfaceView_13, this.f17413B);
            m18450a(OplusGLSurfaceView_13, this.f17443y);
            m18450a(OplusGLSurfaceView_13, this.f17442x);
            m18450a(OplusGLSurfaceView_13, this.f17412A);
            m18450a(OplusGLSurfaceView_13, this.f17444z);
        }
        CameraLog.m12962c("HintManager", "hideHint:" + sb.toString());
        m18468m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m18451a(int OplusGLSurfaceView_13, boolean z) {
        Iterator<CameraScreenHintView> it = this.f17428j.iterator();
        while (it.hasNext()) {
            HintModel c3131b = (HintModel) it.next().getTag(R.id_renamed.hint_model_tag);
            if (c3131b != null && c3131b.f17473r == HintModel.IntrinsicsJvm.kt_4.STRING && c3131b.f17456a == OplusGLSurfaceView_13) {
                c3131b.f17465j = z;
            }
        }
        m18450a(OplusGLSurfaceView_13, this.f17413B);
        m18450a(OplusGLSurfaceView_13, this.f17443y);
        m18450a(OplusGLSurfaceView_13, this.f17442x);
        m18450a(OplusGLSurfaceView_13, this.f17412A);
        m18450a(OplusGLSurfaceView_13, this.f17444z);
        m18468m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m18450a(final int OplusGLSurfaceView_13, final ArrayList<HintModel> arrayList) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.f17416E.post(new Runnable() { // from class: com.oplus.camera.ui.PlatformImplementations.kt_3.PlatformImplementations.kt_3.3
                @Override // java.lang.Runnable
                public void run() {
                    HintManager.this.m18450a(OplusGLSurfaceView_13, (ArrayList<HintModel>) arrayList);
                }
            });
            return;
        }
        Iterator<HintModel> it = arrayList.iterator();
        while (it.hasNext()) {
            HintModel next = it.next();
            if (next.f17473r == HintModel.IntrinsicsJvm.kt_4.STRING && next.f17456a == OplusGLSurfaceView_13) {
                it.remove();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m18499d(boolean z) {
        this.f17425g.setMoreMode(z);
        this.f17426h.setMoreMode(z);
        this.f17427i.setMoreMode(z);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m18503h() {
        this.f17425g.m18814c();
        this.f17426h.m18814c();
        this.f17427i.m18814c();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m18504i() {
        this.f17425g.m18811b();
        this.f17426h.m18811b();
        this.f17427i.m18811b();
        this.f17416E.removeCallbacksAndMessages(null);
        this.f17415D.clear();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18495c(int OplusGLSurfaceView_13) {
        this.f17430l = OplusGLSurfaceView_13;
        Iterator<CameraScreenHintView> it = this.f17428j.iterator();
        while (it.hasNext()) {
            CameraScreenHintView next = it.next();
            if (next.getVisibility() == 0 && 0.0f != next.getAlpha()) {
                next.setOrientation(OplusGLSurfaceView_13);
            } else {
                next.setOrientationNoAnim(OplusGLSurfaceView_13);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18481a(Size size) {
        Iterator<CameraScreenHintView> it = this.f17428j.iterator();
        while (it.hasNext()) {
            it.next().m18804a(size);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18483a(BaseScreenMode abstractC2934a) {
        this.f17418G = abstractC2934a.mo16630q();
        int iK = abstractC2934a.mo16570k();
        int iJ = abstractC2934a.mo16539j();
        Iterator<CameraScreenHintView> it = this.f17428j.iterator();
        while (it.hasNext()) {
            CameraScreenHintView next = it.next();
            next.m18805a(abstractC2934a, iK);
            next.setIsLowRack(this.f17418G);
            if (4 == iJ && this.f17418G) {
                next.m18802a(0, this.f17423e.getDimensionPixelSize(R.dimen.low_rack_mode_camera_screen_hint_view_margin_bottom), 0, true);
            } else {
                next.setBMarginBottom(false);
                next.m18816e();
            }
            if (1 == iJ || 4 == iJ) {
                next.m18817f();
            }
        }
        if ((1 == iJ && iK != 0) || 4 == iJ) {
            this.f17434p = Util.getScreenHeight();
        } else {
            this.f17434p = Util.getScreenWidth();
        }
        if (this.f17429k != null) {
            m18469n();
        }
        this.f17432n = iJ;
        this.f17433o = iK;
    }

    /* renamed from: o */
    private int m18470o() {
        if (this.f17433o == 0) {
            return R.drawable.screen_hint_textview_bg;
        }
        int OplusGLSurfaceView_13 = this.f17422d;
        return (OplusGLSurfaceView_13 == 0 || 1 == OplusGLSurfaceView_13) ? R.drawable.screen_hint_textview_white_bg : R.drawable.screen_hint_textview_bg;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public String m18505j() {
        CameraScreenHintView cameraScreenHintView = this.f17425g;
        return cameraScreenHintView != null ? cameraScreenHintView.getHintTextViewString() : "";
    }
}
