package com.oplus.camera.p172ui.beauty3d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p140d.Beauty3DTools;
import com.oplus.camera.p172ui.OplusNumSeekBar;
import com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintInfo;
import com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintView;
import com.oplus.camera.p172ui.menu.OplusTextView;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: Beauty3DEditUI.java */
/* renamed from: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class Beauty3DEditUI implements View.OnClickListener, OplusNumSeekBar.InterfaceC3101a {

    /* renamed from: H */
    private OnEdit3DViewListener f17646H;

    /* renamed from: J */
    private RelativeLayout f17648J;

    /* renamed from: K */
    private GestureDetector f17649K;

    /* renamed from: PlatformImplementations.kt_3 */
    private Point f17665a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Point f17694b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Point f17695c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Point f17696d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Point f17697e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Activity f17698f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ViewGroup f17699g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f17700h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f17701i = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f17702j = false;

    /* renamed from: OplusGLSurfaceView_5 */
    private TextView f17703k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private TextView f17704l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private TextView f17705m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private TextView f17706n = null;

    /* renamed from: o */
    private TextView f17707o = null;

    /* renamed from: p */
    private TextView f17708p = null;

    /* renamed from: q */
    private TextView f17709q = null;

    /* renamed from: r */
    private ImageView f17710r = null;

    /* renamed from: s */
    private ImageView f17711s = null;

    /* renamed from: t */
    private RecyclerView f17712t = null;

    /* renamed from: u */
    private RelativeLayout f17713u = null;

    /* renamed from: v */
    private RelativeLayout f17714v = null;

    /* renamed from: w */
    private OplusNumSeekBar f17715w = null;

    /* renamed from: x */
    private OplusNumSeekBar f17716x = null;

    /* renamed from: y */
    private BaseSense f17717y = null;

    /* renamed from: z */
    private BaseSense f17718z = null;

    /* renamed from: A */
    private BaseSense f17639A = null;

    /* renamed from: B */
    private BaseSense f17640B = null;

    /* renamed from: C */
    private BaseSense f17641C = null;

    /* renamed from: D */
    private BaseSense f17642D = null;

    /* renamed from: E */
    private BaseSense f17643E = null;

    /* renamed from: F */
    private LinearLayout f17644F = null;

    /* renamed from: G */
    private LinearLayout f17645G = null;

    /* renamed from: I */
    private View f17647I = null;

    /* renamed from: L */
    private COUIBaseListPopupWindow_8 f17650L = null;

    /* renamed from: M */
    private IntrinsicsJvm.kt_4 f17651M = null;

    /* renamed from: N */
    private List<IntrinsicsJvm.kt_3> f17652N = null;

    /* renamed from: O */
    private boolean f17653O = false;

    /* renamed from: P */
    private View f17654P = null;

    /* renamed from: Q */
    private View f17655Q = null;

    /* renamed from: R */
    private View f17656R = null;

    /* renamed from: S */
    private View f17657S = null;

    /* renamed from: T */
    private View f17658T = null;

    /* renamed from: U */
    private View f17659U = null;

    /* renamed from: V */
    private View f17660V = null;

    /* renamed from: W */
    private OplusTextView f17661W = null;

    /* renamed from: X */
    private OplusTextView f17662X = null;

    /* renamed from: Y */
    private OplusTextView f17663Y = null;

    /* renamed from: Z */
    private OplusTextView f17664Z = null;

    /* renamed from: aa */
    private OplusTextView f17668aa = null;

    /* renamed from: ab */
    private ImageView f17669ab = null;

    /* renamed from: ac */
    private ImageView f17670ac = null;

    /* renamed from: ad */
    private String f17671ad = null;

    /* renamed from: ae */
    private String f17672ae = null;

    /* renamed from: af */
    private String f17673af = null;

    /* renamed from: ag */
    private String f17674ag = null;

    /* renamed from: ah */
    private String f17675ah = null;

    /* renamed from: ai */
    private boolean f17676ai = false;

    /* renamed from: aj */
    private Beauty3DEditStack f17677aj = new Beauty3DEditStack();

    /* renamed from: ak */
    private CameraScreenHintView f17678ak = null;

    /* renamed from: al */
    private int f17679al = 0;

    /* renamed from: am */
    private int f17680am = 0;

    /* renamed from: an */
    private float f17681an = 0.0f;

    /* renamed from: ao */
    private boolean f17682ao = false;

    /* renamed from: ap */
    private int f17683ap = 0;

    /* renamed from: aq */
    private boolean f17684aq = false;

    /* renamed from: ar */
    private boolean f17685ar = true;

    /* renamed from: as */
    private int[] f17686as = {2};

    /* renamed from: at */
    private int[] f17687at = {1};

    /* renamed from: au */
    private int[] f17688au = {0};

    /* renamed from: av */
    private int[] f17689av = new int[8];

    /* renamed from: aw */
    private SparseArray<int[]> f17690aw = new SparseArray<>();

    /* renamed from: ax */
    private SparseArray<int[]> f17691ax = null;

    /* renamed from: ay */
    private int f17692ay = 0;

    /* renamed from: az */
    private int f17693az = 0;

    /* renamed from: aA */
    private View.OnTouchListener f17666aA = new View.OnTouchListener() { // from class: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5.1
        /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
            /*
                r3 = this;
                int r4 = r4.getId()
                r0 = 1
                r1 = 2131296659(0x7f090193, float:1.821124E38)
                if (r4 == r1) goto Lb
                return r0
            Lb:
                int r4 = r5.getActionMasked()
                if (r4 == 0) goto L4a
                if (r4 == r0) goto L1a
                r1 = 2
                if (r4 == r1) goto L4a
                r1 = 3
                if (r4 == r1) goto L1a
                goto L5b
            L1a:
                com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5 r4 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.this
                com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.m18601a(r4, r0)
                com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5 r4 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.this
                com.oplus.camera.ui.beauty3d.OplusGLSurfaceView_13 r4 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.m18599a(r4)
                if (r4 == 0) goto L38
                com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5 r4 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.this
                com.oplus.camera.ui.beauty3d.OplusGLSurfaceView_13 r4 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.m18599a(r4)
                com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5 r1 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.this
                int[] r1 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.m18603b(r1)
                java.lang.String r2 = "com.oplus.beauty3d.custom.mode"
                r4.mo18750a(r2, r1)
            L38:
                com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5 r4 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.this
                android.view.GestureDetector r4 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.m18604c(r4)
                if (r4 == 0) goto L5b
                com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5 r3 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.this
                android.view.GestureDetector r3 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.m18604c(r3)
                r3.onTouchEvent(r5)
                goto L5b
            L4a:
                com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5 r4 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.this
                android.view.GestureDetector r4 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.m18604c(r4)
                if (r4 == 0) goto L5b
                com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5 r3 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.this
                android.view.GestureDetector r3 = com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.m18604c(r3)
                r3.onTouchEvent(r5)
            L5b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.COUIBaseListPopupWindow_2.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    };

    /* renamed from: aB */
    private IntrinsicsJvm.kt_5 f17667aB = new IntrinsicsJvm.kt_5() { // from class: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5.2
        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DEditUI.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18654a(View view, int OplusGLSurfaceView_13) {
            CameraLog.m12954a("Beauty3DEditUI", "onItemClick, position: " + OplusGLSurfaceView_13);
            Beauty3DEditUI.this.m18590H();
            if (OplusGLSurfaceView_13 == 0) {
                Beauty3DEditUI.this.m18632b(0);
                return;
            }
            if (OplusGLSurfaceView_13 == 1) {
                Beauty3DEditUI.this.m18632b(1);
            } else if (OplusGLSurfaceView_13 == 2) {
                Beauty3DEditUI.this.m18632b(2);
            } else {
                if (OplusGLSurfaceView_13 != 3) {
                    return;
                }
                Beauty3DEditUI.this.m18632b(3);
            }
        }
    };

    @Override // com.oplus.camera.p172ui.OplusNumSeekBar.InterfaceC3101a
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo18329a() {
        return true;
    }

    public Beauty3DEditUI(Activity activity, OnEdit3DViewListener interfaceC3142i, RelativeLayout relativeLayout) {
        this.f17665a = null;
        this.f17694b = null;
        this.f17695c = null;
        this.f17696d = null;
        this.f17697e = null;
        this.f17698f = null;
        this.f17646H = null;
        this.f17648J = null;
        this.f17649K = null;
        this.f17698f = activity;
        this.f17646H = interfaceC3142i;
        this.f17648J = relativeLayout;
        this.f17649K = new GestureDetector(this.f17698f, new PlatformImplementations.kt_3());
        this.f17665a = new Point(400, 400);
        this.f17697e = new Point(400, 1000);
        this.f17694b = new Point(400, 700);
        this.f17696d = new Point(400, 1000);
        this.f17695c = new Point(400, 400);
        Beauty3DTools.m12873a().m12877a(this.f17698f);
    }

    /* renamed from: s */
    private void m18616s() {
        if (this.f17647I == null) {
            this.f17647I = this.f17698f.getLayoutInflater().inflate(R.layout.beauty3d_bottom, (ViewGroup) null);
        }
        if (this.f17699g == null) {
            this.f17699g = (ViewGroup) this.f17698f.findViewById(R.id_renamed.camera);
        }
        this.f17647I.setBackgroundColor(-16777216);
        this.f17647I.setVisibility(8);
        this.f17647I.setEnabled(false);
        this.f17647I.setOnTouchListener(this.f17666aA);
        int dimension = (int) this.f17698f.getResources().getDimension(R.dimen.beauty3d_edit_bottom_height);
        if (this.f17702j) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimension);
        layoutParams.addRule(12);
        this.f17699g.addView(this.f17647I, layoutParams);
        this.f17702j = true;
        m18620w();
    }

    /* renamed from: t */
    private void m18617t() {
        if (this.f17654P == null) {
            ViewGroup viewGroup = (ViewGroup) this.f17698f.findViewById(R.id_renamed.camera);
            this.f17654P = this.f17698f.getLayoutInflater().inflate(R.layout.beauty3d_edit_setting, (ViewGroup) null);
            if (this.f17676ai) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            layoutParams.height = (int) this.f17698f.getResources().getDimension(R.dimen.beauty3d_scan_setting_height);
            layoutParams.topMargin = 0;
            this.f17654P.setLayoutParams(layoutParams);
            viewGroup.addView(this.f17654P, layoutParams);
            this.f17676ai = true;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18631b() {
        View view = this.f17647I;
        if (view != null) {
            view.setVisibility(8);
            this.f17647I.setEnabled(false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18636c() {
        View view = this.f17647I;
        if (view != null) {
            view.setVisibility(0);
            this.f17647I.setEnabled(true);
            this.f17647I.setOnTouchListener(this.f17666aA);
            m18621x();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m18639d() {
        m18617t();
        this.f17654P.setOnTouchListener(this.f17666aA);
        this.f17714v = (RelativeLayout) this.f17654P.findViewById(R.id_renamed.beauty3d_edit_setting);
        this.f17713u = (RelativeLayout) this.f17654P.findViewById(R.id_renamed.beauty3d_custom_setting);
        this.f17703k = (TextView) this.f17654P.findViewById(R.id_renamed.beauty3d_title);
        this.f17704l = (TextView) this.f17654P.findViewById(R.id_renamed.custom_title);
        this.f17703k.setText(this.f17698f.getString(R.string.beauty3d_face_edit_title));
        this.f17709q = (TextView) this.f17654P.findViewById(R.id_renamed.custom_rescan);
        this.f17709q.setOnClickListener(this);
        this.f17713u.setVisibility(4);
        this.f17714v.setVisibility(4);
    }

    /* renamed from: u */
    private void m18618u() {
        RelativeLayout relativeLayout = this.f17713u;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.f17714v;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        TextView textView = this.f17703k;
        if (textView != null) {
            textView.setText(this.f17698f.getString(R.string.beauty3d_face_edit_title));
            this.f17703k.setVisibility(0);
        }
    }

    /* renamed from: v */
    private void m18619v() {
        RelativeLayout relativeLayout = this.f17713u;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
            this.f17713u.setEnabled(true);
        }
        TextView textView = this.f17704l;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.f17703k;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = this.f17709q;
        if (textView3 != null) {
            textView3.setVisibility(0);
            this.f17709q.setClickable(true);
            this.f17709q.setOnClickListener(this);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m18640e() {
        View view = this.f17654P;
        if (view != null) {
            view.setVisibility(4);
            this.f17654P.setEnabled(false);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m18641f() {
        View view = this.f17654P;
        if (view != null) {
            view.setOnTouchListener(this.f17666aA);
            this.f17654P.setVisibility(0);
            this.f17654P.setEnabled(true);
        }
    }

    /* renamed from: w */
    private void m18620w() {
        this.f17647I.setClickable(true);
        this.f17705m = (TextView) this.f17647I.findViewById(R.id_renamed.face3d_cancel);
        this.f17706n = (TextView) this.f17647I.findViewById(R.id_renamed.face3d_customize_cancel);
        this.f17707o = (TextView) this.f17647I.findViewById(R.id_renamed.face3d_save);
        this.f17708p = (TextView) this.f17647I.findViewById(R.id_renamed.face3d_customize);
        this.f17710r = (ImageView) this.f17647I.findViewById(R.id_renamed.redo_left);
        this.f17711s = (ImageView) this.f17647I.findViewById(R.id_renamed.redo_right);
        this.f17645G = (LinearLayout) this.f17647I.findViewById(R.id_renamed.down_seekbar_container);
        this.f17644F = (LinearLayout) this.f17647I.findViewById(R.id_renamed.up_seekbar_container);
        this.f17715w = (OplusNumSeekBar) this.f17647I.findViewById(R.id_renamed.up_seekbar);
        this.f17716x = (OplusNumSeekBar) this.f17647I.findViewById(R.id_renamed.down_seekbar);
        this.f17669ab = (ImageView) this.f17647I.findViewById(R.id_renamed.up_seekbar_view);
        this.f17670ac = (ImageView) this.f17647I.findViewById(R.id_renamed.down_seekbar_view);
        this.f17716x.setEnabled(true);
        this.f17715w.setEnabled(true);
        this.f17645G.setVisibility(8);
        this.f17644F.setVisibility(8);
        this.f17710r.setVisibility(4);
        this.f17711s.setVisibility(4);
        this.f17710r.setOnClickListener(this);
        this.f17711s.setOnClickListener(this);
        this.f17705m.setOnClickListener(this);
        this.f17708p.setOnClickListener(this);
        this.f17707o.setOnClickListener(this);
        this.f17706n.setOnClickListener(this);
        this.f17716x.setOnProgressChangedListener(this);
        this.f17715w.setOnProgressChangedListener(this);
        this.f17712t = (RecyclerView) this.f17647I.findViewById(R.id_renamed.beauty3d_recyclerview);
        m18584B();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m18642g() {
        int OplusGLSurfaceView_13 = this.f17700h;
        if (OplusGLSurfaceView_13 == 1) {
            this.f17669ab.setImageDrawable(this.f17642D.f17633f);
            this.f17670ac.setImageDrawable(this.f17641C.f17633f);
            return;
        }
        if (OplusGLSurfaceView_13 == 2) {
            this.f17670ac.setImageDrawable(this.f17640B.f17633f);
            return;
        }
        if (OplusGLSurfaceView_13 == 3) {
            this.f17670ac.setImageDrawable(this.f17718z.f17633f);
            this.f17669ab.setImageDrawable(this.f17717y.f17633f);
        } else if (OplusGLSurfaceView_13 == 4) {
            this.f17670ac.setImageDrawable(this.f17643E.f17633f);
        } else {
            if (OplusGLSurfaceView_13 != 5) {
                return;
            }
            this.f17670ac.setImageDrawable(this.f17639A.f17633f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18629a(int[] iArr) {
        if (this.f17691ax != null || iArr == null || iArr.length < 28) {
            return;
        }
        this.f17691ax = new SparseArray<>();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 4; OplusGLSurfaceView_13++) {
            int i2 = OplusGLSurfaceView_13 * 7;
            this.f17691ax.put(OplusGLSurfaceView_13, Arrays.copyOfRange(iArr, i2, i2 + 7));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m18624a(int OplusGLSurfaceView_13) {
        int[] iArr;
        SparseArray<int[]> sparseArray = this.f17691ax;
        if (sparseArray == null || (iArr = sparseArray.get(this.f17680am)) == null || iArr.length <= OplusGLSurfaceView_13) {
            return 0;
        }
        return iArr[OplusGLSurfaceView_13];
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m18609d(int[] iArr) {
        if (iArr == null || iArr.length != 7) {
            return;
        }
        BaseSense c3134a = this.f17641C;
        if (c3134a != null) {
            c3134a.m18572a(m18624a(0));
            this.f17641C.f17628a = iArr[0];
        }
        BaseSense c3134a2 = this.f17642D;
        if (c3134a2 != null) {
            c3134a2.m18572a(m18624a(1));
            this.f17642D.f17628a = iArr[1];
        }
        BaseSense c3134a3 = this.f17640B;
        if (c3134a3 != null) {
            c3134a3.m18572a(m18624a(2));
            this.f17640B.f17628a = iArr[2];
        }
        BaseSense c3134a4 = this.f17718z;
        if (c3134a4 != null) {
            c3134a4.m18572a(m18624a(3));
            this.f17718z.f17628a = iArr[3];
        }
        BaseSense c3134a5 = this.f17717y;
        if (c3134a5 != null) {
            c3134a5.m18572a(m18624a(4));
            this.f17717y.f17628a = iArr[4];
        }
        BaseSense c3134a6 = this.f17643E;
        if (c3134a6 != null) {
            c3134a6.m18572a(m18624a(5));
            this.f17643E.f17628a = iArr[5];
        }
        BaseSense c3134a7 = this.f17639A;
        if (c3134a7 != null) {
            c3134a7.m18572a(m18624a(6));
            this.f17639A.f17628a = iArr[6];
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18632b(int OplusGLSurfaceView_13) {
        this.f17684aq = true;
        this.f17700h = 0;
        this.f17680am = OplusGLSurfaceView_13;
        int[] iArr = this.f17690aw.get(this.f17680am);
        if (iArr == null) {
            return;
        }
        m18609d(iArr);
        if (this.f17646H != null) {
            m18595M();
        }
        m18608d(false);
        m18611e(false);
        Beauty3DEditStack c3136c = this.f17677aj;
        if (c3136c != null) {
            c3136c.m18582f();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m18643h() {
        if (this.f17651M != null) {
            CameraLog.m12954a("Beauty3DEditUI", "onUpdateStyleViewPosition, mChoseStyle: " + this.f17680am);
            List list = this.f17651M.f17730d;
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
                if (OplusGLSurfaceView_13 == this.f17680am) {
                    list.set(OplusGLSurfaceView_13, true);
                } else {
                    list.set(OplusGLSurfaceView_13, false);
                }
            }
            this.f17651M.notifyDataSetChanged();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18625a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("Beauty3DEditUI", "setSeekBarProgress: progress: " + i2 + ", mTouchLcation: " + this.f17700h);
        int i3 = this.f17700h;
        if (i3 == 1) {
            if (this.f17641C.f17631d == OplusGLSurfaceView_13) {
                this.f17641C.m18574b(i2);
                return;
            } else {
                if (this.f17642D.f17631d == OplusGLSurfaceView_13) {
                    this.f17642D.m18574b(i2);
                    return;
                }
                return;
            }
        }
        if (i3 == 2) {
            this.f17640B.m18574b(i2);
            return;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                this.f17643E.m18574b(i2);
                return;
            } else {
                if (i3 != 5) {
                    return;
                }
                this.f17639A.m18574b(i2);
                return;
            }
        }
        if (this.f17717y.f17631d == OplusGLSurfaceView_13) {
            this.f17717y.m18574b(i2);
        } else if (this.f17718z.f17631d == OplusGLSurfaceView_13) {
            this.f17718z.m18574b(i2);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m18644i() {
        m18636c();
        m18641f();
        RelativeLayout relativeLayout = this.f17648J;
        if (relativeLayout != null) {
            relativeLayout.setOnTouchListener(this.f17666aA);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18633b(int OplusGLSurfaceView_13, int i2) {
        m18646k();
        this.f17680am = i2;
        if (OplusGLSurfaceView_13 == 2) {
            m18592J();
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m18645j() {
        m18639d();
        m18616s();
        m18623z();
        if (this.f17717y == null) {
            this.f17717y = new BaseSense(0, 100, this.f17698f.getDrawable(R.drawable.beauty3d_small_face), R.id_renamed.up_seekbar);
        }
        if (this.f17718z == null) {
            this.f17718z = new BaseSense(0, 100, this.f17698f.getDrawable(R.drawable.beauty3d_fix_face), R.id_renamed.down_seekbar);
        }
        if (this.f17639A == null) {
            this.f17639A = new BaseSense(-50, 50, this.f17698f.getDrawable(R.drawable.beauty3d_chin), R.id_renamed.down_seekbar);
        }
        if (this.f17640B == null) {
            this.f17640B = new BaseSense(0, 100, this.f17698f.getDrawable(R.drawable.beauty3d_big_eye), R.id_renamed.down_seekbar);
        }
        if (this.f17643E == null) {
            this.f17643E = new BaseSense(0, 100, this.f17698f.getDrawable(R.drawable.beauty3d_cheekbone), R.id_renamed.down_seekbar);
        }
        if (this.f17642D == null) {
            this.f17642D = new BaseSense(0, 100, this.f17698f.getDrawable(R.drawable.beauty3d_small_nose), R.id_renamed.up_seekbar);
        }
        if (this.f17641C == null) {
            this.f17641C = new BaseSense(0, 100, this.f17698f.getDrawable(R.drawable.beauty3d_high_nose), R.id_renamed.down_seekbar);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m18646k() {
        m18621x();
        m18618u();
        TextView textView = this.f17705m;
        if (textView != null) {
            textView.setVisibility(0);
            this.f17705m.setClickable(true);
        }
        TextView textView2 = this.f17706n;
        if (textView2 != null) {
            textView2.setVisibility(8);
            this.f17706n.setClickable(false);
        }
        TextView textView3 = this.f17707o;
        if (textView3 != null) {
            textView3.setVisibility(8);
            this.f17707o.setClickable(false);
        }
        TextView textView4 = this.f17708p;
        if (textView4 != null) {
            textView4.setVisibility(0);
            this.f17708p.setClickable(true);
        }
        m18593K();
        m18590H();
        ImageView imageView = this.f17710r;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        ImageView imageView2 = this.f17711s;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        this.f17701i = 1;
    }

    /* renamed from: x */
    private void m18621x() {
        int iM24198Z;
        View view = this.f17647I;
        if (view == null) {
            return;
        }
        int OplusGLSurfaceView_13 = 0;
        view.setVisibility(0);
        this.f17647I.setEnabled(true);
        int dimension = (int) this.f17698f.getResources().getDimension(R.dimen.beauty3d_edit_custom_bottom_height);
        int dimension2 = (int) this.f17698f.getResources().getDimension(R.dimen.beauty3d_redo_margin_bottom);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f17647I.getLayoutParams();
        if (Util.m24338aa() && (iM24198Z = Util.m24198Z() - dimension2) > 0) {
            OplusGLSurfaceView_13 = iM24198Z;
        }
        layoutParams.bottomMargin = OplusGLSurfaceView_13;
        layoutParams.height = dimension;
        CameraLog.m12954a("Beauty3DEditUI", "refreshBottomLayout, bottomMargin: " + OplusGLSurfaceView_13 + ", height: " + dimension);
        this.f17647I.setLayoutParams(layoutParams);
        this.f17647I.requestLayout();
    }

    /* renamed from: y */
    private void m18622y() {
        View view = this.f17655Q;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.f17655Q.setVisibility(0);
    }

    /* renamed from: z */
    private void m18623z() {
        RelativeLayout relativeLayout;
        CameraLog.m12954a("Beauty3DEditUI", "initPreview");
        RelativeLayout relativeLayout2 = this.f17648J;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnTouchListener(this.f17666aA);
        }
        m18583A();
        if (this.f17653O || (relativeLayout = this.f17648J) == null) {
            return;
        }
        relativeLayout.addView(this.f17655Q, -1, -1);
        View viewFindViewById = this.f17655Q.findViewById(R.id_renamed.cheekbone_ffd);
        if (viewFindViewById != null) {
            viewFindViewById.measure(0, 0);
            this.f17692ay = viewFindViewById.getMeasuredWidth() / 2;
        }
        m18634b(false);
        m18600a(this.f17656R, this.f17665a, false);
        m18600a(this.f17657S, this.f17694b, false);
        m18600a(this.f17658T, this.f17696d, false);
        m18600a(this.f17659U, this.f17695c, true);
        m18600a(this.f17660V, this.f17697e, true);
        this.f17653O = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18600a(View view, Point point, boolean z) {
        if (view == null || point == null) {
            CameraLog.m12967f("Beauty3DEditUI", "updateFiveSenseViewLayout, view or point null");
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.width = point.x + this.f17692ay;
                layoutParams.topMargin = point.y - (view.getMeasuredHeight() / 2);
                view.setLayoutParams(layoutParams);
                view.requestLayout();
                return;
            }
            layoutParams.width = (1080 - point.x) + this.f17692ay;
            layoutParams.topMargin = point.y - (view.getMeasuredHeight() / 2);
            view.setLayoutParams(layoutParams);
            view.requestLayout();
        }
    }

    /* renamed from: A */
    private void m18583A() {
        if (this.f17655Q == null) {
            this.f17655Q = this.f17698f.getLayoutInflater().inflate(R.layout.beauty3d_fivesence_hint, (ViewGroup) null);
            this.f17655Q.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
        }
        this.f17656R = this.f17655Q.findViewById(R.id_renamed.eye_hint);
        this.f17657S = this.f17655Q.findViewById(R.id_renamed.nose_hint);
        this.f17658T = this.f17655Q.findViewById(R.id_renamed.chin_hint);
        this.f17659U = this.f17655Q.findViewById(R.id_renamed.face_hint);
        this.f17660V = this.f17655Q.findViewById(R.id_renamed.cheekbone_hint);
        this.f17656R.measure(0, 0);
        this.f17657S.measure(0, 0);
        this.f17658T.measure(0, 0);
        this.f17659U.measure(0, 0);
        this.f17660V.measure(0, 0);
        this.f17661W = (OplusTextView) this.f17655Q.findViewById(R.id_renamed.eye_hint_title);
        this.f17662X = (OplusTextView) this.f17655Q.findViewById(R.id_renamed.nose_hint_title);
        this.f17663Y = (OplusTextView) this.f17655Q.findViewById(R.id_renamed.chin_hint_title);
        this.f17664Z = (OplusTextView) this.f17655Q.findViewById(R.id_renamed.face_hint_title);
        this.f17668aa = (OplusTextView) this.f17655Q.findViewById(R.id_renamed.cheekbone_hint_title);
        this.f17671ad = this.f17698f.getString(R.string.beauty3d_eye);
        this.f17672ae = this.f17698f.getString(R.string.beauty3d_nose);
        this.f17673af = this.f17698f.getString(R.string.beauty3d_chin);
        this.f17674ag = this.f17698f.getString(R.string.beauty3d_face_size);
        this.f17675ah = this.f17698f.getString(R.string.beauty3d_cheekbones);
        this.f17661W.setText(this.f17671ad);
        this.f17662X.setText(this.f17672ae);
        this.f17663Y.setText(this.f17673af);
        this.f17664Z.setText(this.f17674ag);
        this.f17668aa.setText(this.f17675ah);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18630a(String[] strArr) {
        if (strArr == null || strArr.length != 5) {
            return;
        }
        OplusTextView oplusTextView = this.f17668aa;
        if (oplusTextView != null && strArr[0] != null && !strArr[0].equals(oplusTextView.getText())) {
            this.f17668aa.setText(strArr[0]);
            CameraLog.m12954a("Beauty3DEditUI", "setFiveSenseTitles, update CheekBone");
        }
        OplusTextView oplusTextView2 = this.f17664Z;
        if (oplusTextView2 != null && strArr[1] != null && !strArr[1].equals(oplusTextView2.getText())) {
            this.f17664Z.setText(strArr[1]);
            CameraLog.m12954a("Beauty3DEditUI", "setFiveSenseTitles, update Face");
        }
        OplusTextView oplusTextView3 = this.f17663Y;
        if (oplusTextView3 != null && strArr[2] != null && !strArr[2].equals(oplusTextView3.getText())) {
            this.f17663Y.setText(strArr[2]);
            CameraLog.m12954a("Beauty3DEditUI", "setFiveSenseTitles, update Chin");
        }
        OplusTextView oplusTextView4 = this.f17662X;
        if (oplusTextView4 != null && strArr[3] != null && !strArr[3].equals(oplusTextView4.getText())) {
            this.f17662X.setText(strArr[3]);
            CameraLog.m12954a("Beauty3DEditUI", "setFiveSenseTitles, update Nose");
        }
        OplusTextView oplusTextView5 = this.f17661W;
        if (oplusTextView5 == null || strArr[4] == null || strArr[4].equals(oplusTextView5.getText())) {
            return;
        }
        this.f17661W.setText(strArr[4]);
        CameraLog.m12954a("Beauty3DEditUI", "setFiveSenseTitles, update Eye");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18635b(int[] iArr) {
        boolean z;
        if (iArr != null && iArr.length >= 10 && this.f17685ar) {
            int OplusGLSurfaceView_13 = 1440 - iArr[0];
            int i2 = 1080 - iArr[1];
            if (this.f17697e.y == OplusGLSurfaceView_13 && this.f17697e.x == i2) {
                z = false;
            } else {
                Point point = this.f17697e;
                point.y = OplusGLSurfaceView_13;
                point.x = i2;
                z = true;
            }
            int i3 = 1440 - iArr[2];
            int i4 = 1080 - iArr[3];
            if (this.f17695c.y != i3 || this.f17695c.x != i4) {
                Point point2 = this.f17695c;
                point2.y = i3;
                point2.x = i4;
                z = true;
            }
            int i5 = 1440 - iArr[4];
            int i6 = 1080 - iArr[5];
            if (this.f17696d.y != i5 || this.f17696d.x != i6) {
                Point point3 = this.f17696d;
                point3.y = i5;
                point3.x = i6;
                z = true;
            }
            int i7 = 1440 - iArr[6];
            int i8 = 1080 - iArr[7];
            if (this.f17694b.y != i7 || this.f17694b.x != i8) {
                Point point4 = this.f17694b;
                point4.y = i7;
                point4.x = i8;
                z = true;
            }
            int i9 = 1440 - iArr[8];
            int i10 = 1080 - iArr[9];
            if (this.f17665a.y != i9 || this.f17665a.x != i10) {
                Point point5 = this.f17665a;
                point5.y = i9;
                point5.x = i10;
                z = true;
            }
            if (z) {
                CameraLog.m12954a("Beauty3DEditUI", "setFiveSenseViewParams, result: " + iArr[0] + ", " + iArr[1] + ", " + iArr[2] + ", " + iArr[3] + ", " + iArr[4] + ", " + iArr[5] + ", " + iArr[6] + ", " + iArr[7] + ", " + iArr[8] + ", " + iArr[9]);
                m18634b(false);
                m18600a(this.f17656R, this.f17665a, false);
                m18600a(this.f17657S, this.f17694b, false);
                m18600a(this.f17658T, this.f17696d, false);
                m18600a(this.f17659U, this.f17695c, true);
                m18600a(this.f17660V, this.f17697e, true);
            }
            m18622y();
        }
    }

    /* renamed from: B */
    private void m18584B() {
        this.f17650L = new COUIBaseListPopupWindow_8(this.f17698f);
        this.f17650L.setOrientation(0);
        this.f17712t.setLayoutManager(this.f17650L);
        if (this.f17652N == null) {
            this.f17652N = new ArrayList(4);
            this.f17652N.add(new IntrinsicsJvm.kt_3(this.f17698f.getDrawable(R.drawable.beauty3d_style_natural), this.f17698f.getResources().getString(R.string.beauty3d_face_style_natural)));
            this.f17652N.add(new IntrinsicsJvm.kt_3(this.f17698f.getDrawable(R.drawable.beauty3d_style_goose_egg), this.f17698f.getResources().getString(R.string.beauty3d_face_style_delicate)));
            this.f17652N.add(new IntrinsicsJvm.kt_3(this.f17698f.getDrawable(R.drawable.beauty3d_style_lolita), this.f17698f.getResources().getString(R.string.beauty3d_face_style_lolita)));
            this.f17652N.add(new IntrinsicsJvm.kt_3(this.f17698f.getDrawable(R.drawable.beauty3d_style_mode), this.f17698f.getResources().getString(R.string.beauty3d_face_style_mode)));
        }
        this.f17651M = new IntrinsicsJvm.kt_4(this.f17652N, this.f17667aB);
        this.f17712t.setAdapter(this.f17651M);
        this.f17712t.addItemDecoration(new COUIBaseListPopupWindow_12((int) this.f17698f.getResources().getDimension(R.dimen.beauty3d_edit_recyclerview_item_space)));
        m18593K();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18628a(boolean z) {
        if (z) {
            m18586D();
            this.f17701i = 0;
            this.f17700h = 0;
            this.f17679al = 0;
            this.f17684aq = false;
            this.f17682ao = false;
            Beauty3DEditStack c3136c = this.f17677aj;
            if (c3136c != null) {
                c3136c.m18582f();
            }
        } else {
            m18640e();
            m18631b();
            m18634b(false);
        }
        m18653r();
        this.f17648J.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18634b(boolean z) {
        View view = this.f17655Q;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (z) {
            Util.m24387b(this.f17655Q);
        } else {
            this.f17655Q.setVisibility(8);
        }
    }

    /* renamed from: C */
    private void m18585C() {
        View view = this.f17655Q;
        if (view != null && this.f17653O && this.f17648J != null) {
            Animation animation = view.getAnimation();
            if (animation != null) {
                animation.cancel();
            }
            this.f17655Q.setVisibility(8);
            this.f17648J.removeView(this.f17655Q);
            this.f17655Q.setAlpha(1.0f);
        }
        this.f17653O = false;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m18647l() {
        m18586D();
        this.f17701i = 0;
        this.f17682ao = false;
        this.f17684aq = false;
        this.f17698f = null;
        this.f17699g = null;
        this.f17647I = null;
        this.f17654P = null;
        this.f17703k = null;
        this.f17704l = null;
        this.f17705m = null;
        this.f17706n = null;
        this.f17707o = null;
        this.f17708p = null;
        this.f17709q = null;
        this.f17710r = null;
        this.f17711s = null;
        this.f17712t = null;
        this.f17713u = null;
        this.f17714v = null;
        this.f17648J = null;
        this.f17715w = null;
        this.f17716x = null;
        this.f17644F = null;
        this.f17645G = null;
        this.f17656R = null;
        this.f17657S = null;
        this.f17658T = null;
        this.f17659U = null;
        this.f17660V = null;
        this.f17661W = null;
        this.f17662X = null;
        this.f17663Y = null;
        this.f17664Z = null;
        this.f17668aa = null;
    }

    /* renamed from: D */
    private void m18586D() {
        View view;
        View view2;
        m18585C();
        ViewGroup viewGroup = this.f17699g;
        if (viewGroup != null && (view2 = this.f17647I) != null && this.f17702j) {
            viewGroup.removeView(view2);
            this.f17702j = false;
            this.f17647I = null;
        }
        ViewGroup viewGroup2 = this.f17699g;
        if (viewGroup2 == null || (view = this.f17654P) == null || !this.f17676ai) {
            return;
        }
        viewGroup2.removeView(view);
        this.f17676ai = false;
        this.f17654P = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id_renamed = view.getId();
        if (id_renamed != R.id_renamed.custom_rescan) {
            switch (id_renamed) {
                case R.id_renamed.face3d_cancel /* 2131296608 */:
                    m18628a(true);
                    OnEdit3DViewListener interfaceC3142i = this.f17646H;
                    if (interfaceC3142i != null) {
                        interfaceC3142i.mo18749a();
                        break;
                    }
                    break;
                case R.id_renamed.face3d_customize /* 2131296609 */:
                    OnEdit3DViewListener interfaceC3142i2 = this.f17646H;
                    if (interfaceC3142i2 != null) {
                        interfaceC3142i2.mo18750a("com.oplus.beauty3d.mode", new int[]{3});
                    }
                    m18592J();
                    break;
                case R.id_renamed.face3d_customize_cancel /* 2131296610 */:
                    m18591I();
                    break;
                case R.id_renamed.face3d_save /* 2131296611 */:
                    m18628a(true);
                    OnEdit3DViewListener interfaceC3142i3 = this.f17646H;
                    if (interfaceC3142i3 != null) {
                        interfaceC3142i3.mo18750a("com.oplus.beauty3d.custom.mode", this.f17686as);
                        this.f17646H.mo18751b();
                    }
                    m18587E();
                    break;
                default:
                    switch (id_renamed) {
                        case R.id_renamed.redo_left /* 2131297003 */:
                            m18648m();
                            break;
                        case R.id_renamed.redo_right /* 2131297004 */:
                            m18649n();
                            break;
                    }
            }
        }
        m18628a(true);
        OnEdit3DViewListener interfaceC3142i4 = this.f17646H;
        if (interfaceC3142i4 != null) {
            interfaceC3142i4.mo18749a();
        }
    }

    /* renamed from: E */
    private void m18587E() {
        boolean z;
        int[] iArr = this.f17689av;
        if (iArr == null || iArr.length < 8) {
            return;
        }
        int OplusGLSurfaceView_13 = this.f17693az;
        int i2 = this.f17680am;
        if (OplusGLSurfaceView_13 != i2) {
            z = true;
            break;
        }
        int[] iArr2 = this.f17690aw.get(i2);
        if (iArr2 != null) {
            int i3 = 0;
            while (i3 < iArr2.length) {
                int i4 = iArr2[i3];
                i3++;
                if (i4 != this.f17689av[i3]) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            StringBuilder sb = new StringBuilder();
            int i5 = this.f17689av[0];
            String str = null;
            if (i5 == 0) {
                str = CameraStatisticsUtil.BEAUTY3D_NATURAL;
            } else if (i5 == 1) {
                str = CameraStatisticsUtil.BEAUTY3D_GOOSE;
            } else if (i5 == 2) {
                str = CameraStatisticsUtil.BEAUTY3D_LOLITA;
            } else if (i5 == 3) {
                str = CameraStatisticsUtil.BEAUTY3D_MODE;
            }
            if (str != null) {
                sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_CHOSE_STYLE, str));
            }
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_HIGH_NOSE, String.valueOf(this.f17689av[1])));
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_SMALL_NOSE, String.valueOf(this.f17689av[2])));
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_EYE, String.valueOf(this.f17689av[3])));
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_FIX_FACE, String.valueOf(this.f17689av[4])));
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_SMALL_FACE, String.valueOf(this.f17689av[5])));
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_CHEEKBONE, String.valueOf(this.f17689av[6])));
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_CHIN, String.valueOf(this.f17689av[7])));
            if (sb.length() > 0) {
                CameraStatisticsUtil.onCommon(this.f17698f, CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString());
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m18648m() {
        if (this.f17677aj.m18579c() < 2) {
            m18608d(false);
            return;
        }
        this.f17682ao = true;
        Beauty3DEditStack c3136c = this.f17677aj;
        c3136c.m18578b(c3136c.m18575a());
        Beauty3DEditAction c3135bM18575a = this.f17677aj.m18575a();
        this.f17677aj.m18578b(c3135bM18575a);
        CameraLog.m12954a("Beauty3DEditUI", "Beauty3DEditAction, mValueOwner: " + c3135bM18575a.f17635b + ", mValueLocation: " + c3135bM18575a.f17634a + ", mSbValue: " + c3135bM18575a.f17636c);
        this.f17700h = c3135bM18575a.f17634a;
        m18625a(c3135bM18575a.f17635b, c3135bM18575a.f17636c);
        m18595M();
        m18589G();
        if (this.f17677aj.m18579c() < 2) {
            m18608d(false);
        } else {
            m18608d(true);
        }
        if (this.f17677aj.m18580d() < 2) {
            m18611e(false);
        } else {
            m18611e(true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m18608d(boolean z) {
        ImageView imageView = this.f17710r;
        if (imageView != null) {
            if (z) {
                imageView.setImageDrawable(this.f17698f.getResources().getDrawable(R.drawable.beauty3d_left_arrow));
                this.f17710r.setClickable(true);
            } else {
                imageView.setImageDrawable(this.f17698f.getResources().getDrawable(R.drawable.beauty3d_left_arrow_grey));
                this.f17710r.setClickable(false);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m18611e(boolean z) {
        ImageView imageView = this.f17711s;
        if (imageView != null) {
            if (z) {
                imageView.setImageDrawable(this.f17698f.getResources().getDrawable(R.drawable.beauty3d_right_arrow));
                this.f17711s.setClickable(true);
            } else {
                imageView.setImageDrawable(this.f17698f.getResources().getDrawable(R.drawable.beauty3d_right_arrow_grey));
                this.f17711s.setClickable(false);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m18649n() {
        if (this.f17677aj.m18580d() < 2) {
            m18611e(false);
            return;
        }
        this.f17682ao = true;
        Beauty3DEditStack c3136c = this.f17677aj;
        c3136c.m18576a(c3136c.m18577b());
        Beauty3DEditAction c3135bM18577b = this.f17677aj.m18577b();
        this.f17700h = c3135bM18577b.f17634a;
        m18625a(c3135bM18577b.f17635b, c3135bM18577b.f17636c);
        m18595M();
        m18589G();
        this.f17677aj.m18576a(c3135bM18577b);
        if (this.f17677aj.m18579c() < 2) {
            m18608d(false);
        } else {
            m18608d(true);
        }
        if (this.f17677aj.m18580d() < 2) {
            m18611e(false);
        } else {
            m18611e(true);
        }
    }

    /* renamed from: F */
    private void m18588F() {
        if (this.f17644F.getVisibility() != 0) {
            this.f17644F.setVisibility(0);
            this.f17644F.setClickable(true);
        }
        if (this.f17645G.getVisibility() != 0) {
            this.f17645G.setVisibility(0);
            this.f17645G.setClickable(true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m18605c(int OplusGLSurfaceView_13, int i2) {
        if (this.f17644F.getId() == OplusGLSurfaceView_13 && this.f17644F.getVisibility() != i2) {
            this.f17644F.setVisibility(i2);
            if (i2 == 0) {
                this.f17644F.setClickable(true);
                return;
            } else {
                this.f17644F.setClickable(false);
                return;
            }
        }
        if (this.f17645G.getId() != OplusGLSurfaceView_13 || this.f17645G.getVisibility() == i2) {
            return;
        }
        this.f17645G.setVisibility(0);
        if (i2 == 0) {
            this.f17645G.setClickable(true);
        } else {
            this.f17645G.setClickable(false);
        }
    }

    /* renamed from: G */
    private void m18589G() {
        CameraLog.m12954a("Beauty3DEditUI", "showSeekBar");
        m18588F();
        m18642g();
        if (this.f17710r.getVisibility() != 0) {
            this.f17710r.setVisibility(0);
        }
        if (this.f17711s.getVisibility() != 0) {
            this.f17711s.setVisibility(0);
        }
        int OplusGLSurfaceView_13 = this.f17700h;
        if (OplusGLSurfaceView_13 == 1) {
            m18605c(R.id_renamed.up_seekbar_container, 0);
            this.f17715w.m18323c(this.f17642D.m18573b()).m18325d(this.f17642D.m18571a()).m18316a(this.f17642D.f17629b).m18321b(this.f17642D.f17630c).postInvalidate();
            this.f17716x.m18323c(this.f17641C.m18573b()).m18325d(this.f17641C.m18571a()).m18316a(this.f17641C.f17629b).m18321b(this.f17641C.f17630c).postInvalidate();
            return;
        }
        if (OplusGLSurfaceView_13 == 2) {
            m18605c(R.id_renamed.up_seekbar_container, 4);
            this.f17716x.m18323c(this.f17640B.m18573b()).m18325d(this.f17640B.m18571a()).m18316a(this.f17640B.f17629b).m18321b(this.f17640B.f17630c).postInvalidate();
            return;
        }
        if (OplusGLSurfaceView_13 == 3) {
            m18605c(R.id_renamed.up_seekbar_container, 0);
            this.f17715w.m18323c(this.f17717y.m18573b()).m18325d(this.f17717y.m18571a()).m18316a(this.f17717y.f17629b).m18321b(this.f17717y.f17630c).postInvalidate();
            this.f17716x.m18323c(this.f17718z.m18573b()).m18325d(this.f17718z.m18571a()).m18316a(this.f17718z.f17629b).m18321b(this.f17718z.f17630c).postInvalidate();
        } else if (OplusGLSurfaceView_13 == 4) {
            m18605c(R.id_renamed.up_seekbar_container, 4);
            this.f17716x.m18323c(this.f17643E.m18573b()).m18325d(this.f17643E.m18571a()).m18316a(this.f17643E.f17629b).m18321b(this.f17643E.f17630c).postInvalidate();
        } else {
            if (OplusGLSurfaceView_13 != 5) {
                return;
            }
            m18605c(R.id_renamed.up_seekbar_container, 4);
            this.f17716x.m18323c(this.f17639A.m18573b()).m18325d(this.f17639A.m18571a()).m18316a(this.f17639A.f17629b).m18321b(this.f17639A.f17630c).postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public void m18590H() {
        CameraLog.m12954a("Beauty3DEditUI", "hideAllSeekBar");
        View view = this.f17647I;
        if (view != null) {
            view.findViewById(R.id_renamed.up_seekbar_container).setVisibility(8);
            this.f17647I.findViewById(R.id_renamed.up_seekbar_container).setEnabled(false);
            this.f17647I.findViewById(R.id_renamed.down_seekbar_container).setVisibility(8);
            this.f17647I.findViewById(R.id_renamed.down_seekbar_container).setEnabled(false);
        }
    }

    /* renamed from: I */
    private void m18591I() {
        new COUIAlertDialog.PlatformImplementations.kt_3(this.f17698f, 2131821271).m6600f(1).setNeutralButton(R.string.beauty3d_give_up_customize_face, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                dialogInterface.dismiss();
                Beauty3DEditUI.this.m18628a(true);
                if (Beauty3DEditUI.this.f17646H != null) {
                    Beauty3DEditUI.this.f17646H.mo18752c();
                }
            }
        }).setNegativeButton(R.string.beauty3d_cancel, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    /* renamed from: J */
    private void m18592J() {
        m18619v();
        m18643h();
        m18594L();
        TextView textView = this.f17708p;
        if (textView != null) {
            textView.setVisibility(8);
            this.f17708p.setClickable(false);
        }
        TextView textView2 = this.f17705m;
        if (textView2 != null) {
            textView2.setVisibility(8);
            this.f17705m.setClickable(false);
        }
        TextView textView3 = this.f17707o;
        if (textView3 != null) {
            textView3.setVisibility(0);
            this.f17707o.setClickable(true);
        }
        TextView textView4 = this.f17706n;
        if (textView4 != null) {
            textView4.setClickable(true);
            this.f17706n.setVisibility(0);
        }
        m18627a(this.f17698f.getString(R.string.beauty3d_customize_hint));
        Util.m24362ay().postDelayed(new Runnable() { // from class: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5.7
            @Override // java.lang.Runnable
            public void run() {
                Beauty3DEditUI.this.m18653r();
            }
        }, 3000L);
        this.f17701i = 2;
    }

    /* renamed from: K */
    private void m18593K() {
        RecyclerView recyclerView = this.f17712t;
        if (recyclerView != null) {
            recyclerView.setClickable(false);
            this.f17712t.setVisibility(8);
        }
    }

    /* renamed from: L */
    private void m18594L() {
        this.f17701i = 2;
        RecyclerView recyclerView = this.f17712t;
        if (recyclerView != null) {
            recyclerView.setClickable(true);
            this.f17712t.setVisibility(0);
        }
    }

    /* renamed from: o */
    public int m18650o() {
        return this.f17701i;
    }

    /* renamed from: p */
    public int[] m18651p() {
        return this.f17689av;
    }

    @Override // com.oplus.camera.p172ui.OplusNumSeekBar.InterfaceC3101a
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18328a(OplusNumSeekBar oplusNumSeekBar, int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("Beauty3DEditUI", "onProgressChanged, progress: " + OplusGLSurfaceView_13);
        m18625a(oplusNumSeekBar.getId(), OplusGLSurfaceView_13);
        m18595M();
    }

    @Override // com.oplus.camera.p172ui.OplusNumSeekBar.InterfaceC3101a
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18327a(OplusNumSeekBar oplusNumSeekBar, int OplusGLSurfaceView_13) {
        this.f17683ap = OplusGLSurfaceView_13;
        this.f17677aj.m18576a(new Beauty3DEditAction(this.f17700h, oplusNumSeekBar.getId(), OplusGLSurfaceView_13));
    }

    @Override // com.oplus.camera.p172ui.OplusNumSeekBar.InterfaceC3101a
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18330b(OplusNumSeekBar oplusNumSeekBar, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("Beauty3DEditUI", "getProgressOnActionUp, progress: " + OplusGLSurfaceView_13 + ", mDownProgress: " + this.f17683ap);
        if (this.f17683ap != OplusGLSurfaceView_13) {
            this.f17677aj.m18576a(new Beauty3DEditAction(this.f17700h, oplusNumSeekBar.getId(), OplusGLSurfaceView_13));
            this.f17677aj.m18581e();
            m18611e(false);
            if (this.f17677aj.m18579c() < 2) {
                m18608d(false);
            } else {
                m18608d(true);
            }
            m18625a(oplusNumSeekBar.getId(), OplusGLSurfaceView_13);
            return;
        }
        if (this.f17677aj.m18579c() > 1) {
            this.f17677aj.m18575a();
        }
    }

    /* renamed from: M */
    private void m18595M() {
        int[] iArr = this.f17689av;
        iArr[0] = this.f17680am;
        BaseSense c3134a = this.f17641C;
        if (c3134a != null) {
            iArr[1] = c3134a.f17628a;
        }
        BaseSense c3134a2 = this.f17642D;
        if (c3134a2 != null) {
            this.f17689av[2] = c3134a2.f17628a;
        }
        BaseSense c3134a3 = this.f17640B;
        if (c3134a3 != null) {
            this.f17689av[3] = c3134a3.f17628a;
        }
        BaseSense c3134a4 = this.f17718z;
        if (c3134a4 != null) {
            this.f17689av[4] = c3134a4.f17628a;
        }
        BaseSense c3134a5 = this.f17717y;
        if (c3134a5 != null) {
            this.f17689av[5] = c3134a5.f17628a;
        }
        BaseSense c3134a6 = this.f17643E;
        if (c3134a6 != null) {
            this.f17689av[6] = c3134a6.f17628a;
        }
        BaseSense c3134a7 = this.f17639A;
        if (c3134a7 != null) {
            this.f17689av[7] = c3134a7.f17628a;
        }
        CameraLog.m12954a("Beauty3DEditUI", "updateFiveSenseParams, updateFiveSenseParams: " + this.f17689av[0] + ", " + this.f17689av[1] + ", " + this.f17689av[2] + ", " + this.f17689av[3] + ", " + this.f17689av[4] + ", " + this.f17689av[5] + ", " + this.f17689av[6] + ", " + this.f17689av[7]);
        OnEdit3DViewListener interfaceC3142i = this.f17646H;
        if (interfaceC3142i != null) {
            interfaceC3142i.mo18750a("com.oplus.beauty3d.custom.style", this.f17689av);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18638c(int[] iArr) {
        if (iArr == null || iArr.length < 2 || iArr[0] != 2) {
            return;
        }
        int OplusGLSurfaceView_13 = iArr[1];
        CameraLog.m12954a("Beauty3DEditUI", "upParams, location: " + OplusGLSurfaceView_13 + ", mTouchLocation: " + this.f17700h + ", mbRedo: " + this.f17682ao + ", mbChangeStyle: " + this.f17684aq);
        if (2 == this.f17701i && (this.f17700h == OplusGLSurfaceView_13 || this.f17682ao || this.f17684aq)) {
            return;
        }
        if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 5 || OplusGLSurfaceView_13 == 4) {
            CameraLog.m12954a("Beauty3DEditUI", "update, locatio: " + OplusGLSurfaceView_13);
            this.f17700h = OplusGLSurfaceView_13;
            m18589G();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18637c(boolean z) {
        View view = this.f17654P;
        if (view != null) {
            view.setEnabled(z);
            this.f17654P.setClickable(z);
        }
        View view2 = this.f17647I;
        if (view2 != null) {
            view2.setEnabled(z);
            this.f17647I.setClickable(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18626a(int OplusGLSurfaceView_13, int[] iArr) {
        this.f17693az = OplusGLSurfaceView_13;
        this.f17680am = OplusGLSurfaceView_13;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i2 * 7;
            this.f17690aw.put(i2, Arrays.copyOfRange(iArr, i3, i3 + 7));
        }
    }

    /* renamed from: q */
    public HashMap<String, int[]> m18652q() {
        HashMap<String, int[]> map = new HashMap<>();
        CameraLog.m12954a("Beauty3DEditUI", "getBeauty3DEditCurrParams, mChoseStyle: " + this.f17680am + ", mDegree: " + this.f17679al);
        if (this.f17701i != 1) {
            map.put("com.oplus.beauty3d.custom.style", this.f17689av);
        }
        map.put("com.oplus.beauty3d.analyses.rotatedegree", new int[]{this.f17679al});
        return map;
    }

    /* compiled from: Beauty3DEditUI.java */
    /* renamed from: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends RecyclerView.AbstractC0685a<PlatformImplementations.kt_3> {

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_5 f17727a;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private List<IntrinsicsJvm.kt_3> f17729c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private List<Boolean> f17730d = new ArrayList();

        public IntrinsicsJvm.kt_4(List<IntrinsicsJvm.kt_3> list, IntrinsicsJvm.kt_5 dVar) {
            this.f17727a = null;
            this.f17729c = null;
            this.f17729c = list;
            this.f17727a = dVar;
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
                if (OplusGLSurfaceView_13 == 0) {
                    this.f17730d.add(true);
                } else {
                    this.f17730d.add(false);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PlatformImplementations.kt_3 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beauty3d_edit_item, viewGroup, false);
            CameraLog.m12954a("Beauty3DEditUI", "ViewHolder, onCreateViewHolder, Tag: " + OplusGLSurfaceView_13);
            return new PlatformImplementations.kt_3(viewInflate, this.f17727a);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13) {
            aVar.f17731a.setImageDrawable(this.f17729c.get(OplusGLSurfaceView_13).f17735a);
            aVar.f17732b.setText(this.f17729c.get(OplusGLSurfaceView_13).f17736b);
            if (this.f17730d.get(OplusGLSurfaceView_13).booleanValue()) {
                aVar.f17732b.setTextColor(Util.m24164A(Beauty3DEditUI.this.f17698f));
                aVar.f17731a.setHighLight(true);
            } else {
                aVar.f17732b.setTextColor(Beauty3DEditUI.this.f17698f.getColor(R.color.camera_white));
                aVar.f17731a.setHighLight(false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
        public int getItemCount() {
            return this.f17729c.size();
        }

        /* compiled from: Beauty3DEditUI.java */
        /* renamed from: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
        public class PlatformImplementations.kt_3 extends RecyclerView.AbstractC0707w implements View.OnClickListener {

            /* renamed from: PlatformImplementations.kt_3 */
            public BorderRoundImageView f17731a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            public TextView f17732b;

            /* renamed from: IntrinsicsJvm.kt_3 */
            public IntrinsicsJvm.kt_5 f17733c;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < IntrinsicsJvm.kt_4.this.f17730d.size(); OplusGLSurfaceView_13++) {
                    IntrinsicsJvm.kt_4.this.f17730d.set(OplusGLSurfaceView_13, false);
                }
                CameraLog.m12954a("Beauty3DEditUI", "ViewHolder, onClick, Position: " + getPosition());
                IntrinsicsJvm.kt_4.this.f17730d.set(getPosition(), true);
                IntrinsicsJvm.kt_4.this.notifyDataSetChanged();
                IntrinsicsJvm.kt_5 dVar = this.f17733c;
                if (dVar != null) {
                    dVar.mo18654a(view, getPosition());
                }
            }

            public PlatformImplementations.kt_3(View view, IntrinsicsJvm.kt_5 dVar) {
                super(view);
                this.f17731a = null;
                this.f17732b = null;
                this.f17733c = null;
                this.f17731a = (BorderRoundImageView) view.findViewById(R.id_renamed.edit_item_view);
                this.f17732b = (TextView) view.findViewById(R.id_renamed.edit_item_title);
                this.f17733c = dVar;
                view.setOnClickListener(this);
            }
        }
    }

    /* compiled from: Beauty3DEditUI.java */
    /* renamed from: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public Drawable f17735a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public String f17736b;

        public IntrinsicsJvm.kt_3(Drawable drawable, String str) {
            this.f17735a = null;
            this.f17736b = null;
            this.f17735a = drawable;
            this.f17736b = str;
        }
    }

    /* compiled from: Beauty3DEditUI.java */
    /* renamed from: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5$COUIBaseListPopupWindow_12 */
    public class COUIBaseListPopupWindow_12 extends RecyclerView.AbstractC0692h {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f17742b;

        public COUIBaseListPopupWindow_12(int OplusGLSurfaceView_13) {
            this.f17742b = 0;
            this.f17742b = OplusGLSurfaceView_13;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0692h
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0704t c0704t) {
            int OplusGLSurfaceView_13 = this.f17742b;
            rect.right = OplusGLSurfaceView_13;
            rect.left = OplusGLSurfaceView_13;
        }
    }

    /* compiled from: Beauty3DEditUI.java */
    /* renamed from: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5$COUIBaseListPopupWindow_8 */
    private class COUIBaseListPopupWindow_8 extends LinearLayoutManager {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int[] f17740b;

        public COUIBaseListPopupWindow_8(Context context) {
            super(context);
            this.f17740b = new int[2];
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
        public void onMeasure(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, int OplusGLSurfaceView_13, int i2) {
            int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
            int size2 = View.MeasureSpec.getSize(i2);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < getItemCount(); i5++) {
                m18658a(c0700p, i5, View.MeasureSpec.makeMeasureSpec(i5, 0), View.MeasureSpec.makeMeasureSpec(i5, 0), this.f17740b);
                if (getOrientation() == 0) {
                    int[] iArr = this.f17740b;
                    i4 += iArr[0];
                    if (i5 == 0) {
                        i3 = iArr[1];
                    }
                } else {
                    int[] iArr2 = this.f17740b;
                    i3 += iArr2[1];
                    if (i5 == 0) {
                        i4 = iArr2[0];
                    }
                }
            }
            if (mode == Integer.MIN_VALUE || mode == 0 || mode != 1073741824) {
                size = i4;
            }
            if (mode2 == Integer.MIN_VALUE || mode2 == 0 || mode2 != 1073741824) {
                size2 = i3;
            }
            setMeasuredDimension(size, size2);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m18658a(RecyclerView.C0700p c0700p, int OplusGLSurfaceView_13, int i2, int i3, int[] iArr) {
            View viewM4201c = c0700p.m4201c(OplusGLSurfaceView_13);
            if (viewM4201c != null) {
                RecyclerView.C0694j c0694j = (RecyclerView.C0694j) viewM4201c.getLayoutParams();
                viewM4201c.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), c0694j.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), c0694j.height));
                iArr[0] = viewM4201c.getMeasuredWidth() + c0694j.leftMargin + c0694j.rightMargin;
                iArr[1] = viewM4201c.getMeasuredHeight() + c0694j.bottomMargin + c0694j.topMargin;
                c0700p.m4189a(viewM4201c);
            }
        }
    }

    /* renamed from: N */
    private void m18596N() {
        if (this.f17699g != null && this.f17678ak == null) {
            this.f17678ak = (CameraScreenHintView) this.f17698f.getLayoutInflater().inflate(R.layout.camera_screen_hint, (ViewGroup) null);
            this.f17699g.addView(this.f17678ak);
            this.f17678ak.setOrientation(0);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18627a(String str) {
        if (this.f17678ak == null) {
            m18596N();
            if (this.f17678ak != null) {
                this.f17678ak.m18802a(0, (this.f17698f.getResources().getDimensionPixelSize(R.dimen.down_hint_margin_bottom) + ((int) this.f17698f.getResources().getDimension(R.dimen.beauty3d_edit_custom_bottom_height))) - this.f17678ak.getViewGap(), 0, true);
            }
        }
        CameraScreenHintView cameraScreenHintView = this.f17678ak;
        if (cameraScreenHintView == null) {
            return;
        }
        cameraScreenHintView.bringToFront();
        this.f17678ak.m18806a(new CameraScreenHintInfo.PlatformImplementations.kt_3().m18845a(str).m18846a(true).m18849b(false).m18844a(0).m18848b(R.color.screen_hint_text_color).m18847a());
    }

    /* renamed from: r */
    public void m18653r() {
        CameraScreenHintView cameraScreenHintView = this.f17678ak;
        if (cameraScreenHintView == null || cameraScreenHintView.getHintTextView().getVisibility() != 0) {
            return;
        }
        this.f17678ak.m18813b(true);
    }

    /* compiled from: Beauty3DEditUI.java */
    /* renamed from: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_5 */
    private abstract class IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo18654a(View view, int OplusGLSurfaceView_13) {
        }

        private IntrinsicsJvm.kt_5() {
        }
    }

    /* compiled from: Beauty3DEditUI.java */
    /* renamed from: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements GestureDetector.OnGestureListener {
        private PlatformImplementations.kt_3() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (motionEvent == null) {
                return true;
            }
            Beauty3DEditUI.this.f17685ar = false;
            Beauty3DEditUI.this.f17681an = motionEvent.getRawX();
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            CameraLog.m12954a("Beauty3DEditUI", "Beauty3DGestureListener, onShowPress");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (motionEvent == null) {
                return true;
            }
            float y = 1440.0f - motionEvent.getY();
            float x = 1080.0f - motionEvent.getX();
            CameraLog.m12954a("Beauty3DEditUI", "Beauty3DGestureListener, onSingleTapUp, x: " + y + ", y: " + x);
            if (Beauty3DEditUI.this.f17701i == 2) {
                Beauty3DEditUI.this.f17682ao = false;
                Beauty3DEditUI.this.f17684aq = false;
                Beauty3DEditUI.this.f17646H.mo18750a("com.oplus.beauty3d.custom.position", new int[]{(int) y, (int) x});
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
            if (motionEvent != null && motionEvent2 != null) {
                int x = (int) (motionEvent2.getX() - motionEvent.getX());
                CameraLog.m12954a("Beauty3DEditUI", "Beauty3DGestureListener, onScroll, e1.X: " + motionEvent.getX() + ", e2.X:" + motionEvent2.getX());
                if (Math.abs(x) < 10) {
                    return true;
                }
                Beauty3DEditUI.this.m18634b(false);
                Beauty3DEditUI.this.f17679al = Beauty3DTools.m12873a().m12875a(motionEvent2.getRawX(), Util.getScreenWidth(), Beauty3DEditUI.this.f17681an, Beauty3DEditUI.this.f17679al);
                Beauty3DEditUI.this.f17646H.mo18750a("com.oplus.beauty3d.analyses.rotatedegree", new int[]{Beauty3DEditUI.this.f17679al});
                Beauty3DEditUI.this.f17681an = motionEvent2.getRawX();
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
            CameraLog.m12954a("Beauty3DEditUI", "Beauty3DGestureListener, onFling");
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            CameraLog.m12954a("Beauty3DEditUI", "Beauty3DGestureListener, onLongPress");
            if (Beauty3DEditUI.this.f17701i == 2) {
                Beauty3DEditUI.this.f17646H.mo18750a("com.oplus.beauty3d.custom.mode", Beauty3DEditUI.this.f17687at);
            }
        }
    }
}
