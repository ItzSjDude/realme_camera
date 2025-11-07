package com.oplus.camera.p172ui.menu.facebeauty;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p172ui.OplusNumAISeekBar;
import com.oplus.camera.p172ui.OplusNumSeekBar;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu;
import com.oplus.camera.p172ui.preview.p177a.FaceBeautyFilterListener;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FaceBeautyCustomMenu.java */
/* renamed from: com.oplus.camera.ui.menu.facebeauty.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
class FaceBeautyCustomMenu extends FaceBeautyBaseMenu implements BeautyMenuInterface {

    /* renamed from: D */
    private int f19294D;

    /* renamed from: E */
    private FaceBeautyAdapter f19295E;

    /* renamed from: G */
    private View f19297G;

    /* renamed from: H */
    private OplusNumAISeekBar f19298H;

    /* renamed from: I */
    private OplusNumAISeekBar f19299I;

    /* renamed from: K */
    private COUIRecyclerView f19301K;

    /* renamed from: L */
    private LinearLayoutManager f19302L;

    /* renamed from: R */
    private int f19308R;

    /* renamed from: S */
    private int f19309S;

    /* renamed from: T */
    private int f19310T;

    /* renamed from: U */
    private int f19311U;

    /* renamed from: Z */
    private int f19316Z;

    /* renamed from: aa */
    private int f19317aa;

    /* renamed from: ac */
    private int f19319ac;

    /* renamed from: ae */
    private OplusNumSeekBar.InterfaceC3101a f19321ae;

    /* renamed from: ag */
    private PlatformImplementations.kt_3 f19323ag;

    /* renamed from: z */
    private static final int[] f19293z = {0, 0, 0, 0, -50, 0, 0, 0};

    /* renamed from: A */
    private static final int[] f19290A = {100, 100, 100, 100, 50, 100, 100, 100};

    /* renamed from: B */
    private static final int[] f19291B = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: C */
    private static final int[] f19292C = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100};

    /* renamed from: F */
    private FaceBeautyAdapter f19296F = null;

    /* renamed from: J */
    private OplusNumAISeekBar f19300J = null;

    /* renamed from: M */
    private COUIRecyclerView f19303M = null;

    /* renamed from: N */
    private ArrayList<BeautyMenuItem> f19304N = null;

    /* renamed from: O */
    private ArrayList<BeautyMenuItem> f19305O = null;

    /* renamed from: P */
    private ArrayList<BeautyMenuItem> f19306P = null;

    /* renamed from: Q */
    private RelativeLayout.LayoutParams f19307Q = null;

    /* renamed from: V */
    private int f19312V = 0;

    /* renamed from: W */
    private boolean f19313W = false;

    /* renamed from: X */
    private int f19314X = 0;

    /* renamed from: Y */
    private int f19315Y = 0;

    /* renamed from: ab */
    private int f19318ab = 0;

    /* renamed from: ad */
    private LinearLayoutManager f19320ad = null;

    /* renamed from: af */
    private GestureDetector f19322af = null;

    /* compiled from: FaceBeautyCustomMenu.java */
    /* renamed from: com.oplus.camera.ui.menu.facebeauty.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo20629a(View view, int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m20630a();

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean mo20631d();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m20607b(int OplusGLSurfaceView_13, int i2) {
        return 1 == OplusGLSurfaceView_13 ? 270 == i2 ? R.layout.face_beauty_custom_vertical_270 : R.layout.face_beauty_custom_vertical : 3 == OplusGLSurfaceView_13 ? R.layout.face_beauty_custom_split_screen : 4 == OplusGLSurfaceView_13 ? R.layout.face_beauty_custom_rack : R.layout.face_beauty_custom;
    }

    public FaceBeautyCustomMenu(Activity activity, View.OnClickListener onClickListener, PlatformImplementations.kt_3 aVar, OplusNumSeekBar.InterfaceC3101a interfaceC3101a, FaceBeautyBaseMenu.PlatformImplementations.kt_3 aVar2, FaceBeautyFilterListener interfaceC3409f, int OplusGLSurfaceView_13, int i2) {
        this.f19294D = 0;
        this.f19295E = null;
        this.f19297G = null;
        this.f19298H = null;
        this.f19299I = null;
        this.f19301K = null;
        this.f19302L = null;
        this.f19308R = 0;
        this.f19309S = 0;
        this.f19310T = 0;
        this.f19311U = 0;
        this.f19316Z = 0;
        this.f19317aa = 0;
        this.f19319ac = 0;
        this.f19321ae = null;
        this.f19323ag = null;
        Resources resources = activity.getApplicationContext().getResources();
        this.f19308R = resources.getDimensionPixelSize(R.dimen.face_beauty_item_space_start);
        this.f19316Z = resources.getDimensionPixelSize(R.dimen.makeup_item_space);
        this.f19317aa = resources.getDimensionPixelSize(R.dimen.makeup_item_width);
        this.f19309S = resources.getDimensionPixelSize(R.dimen.face_beauty_item_text_width);
        this.f19311U = resources.getDimensionPixelSize(R.dimen.face_beauty_custom_scroll_view_padding);
        this.f19319ac = resources.getDimensionPixelSize(R.dimen.face_beauty_makeup_recycler_view_padding);
        this.f19310T = resources.getDimensionPixelSize(R.dimen.face_beauty_item_touch_height);
        this.f19274v = activity.getResources().getDimensionPixelSize(R.dimen.face_beauty_menu_translate_y);
        this.f19267o = aVar2;
        this.f19323ag = aVar;
        this.f19321ae = interfaceC3101a;
        this.f19275w = OplusGLSurfaceView_13;
        this.f19277y = activity;
        this.f19276x = i2;
        this.f19294D = m20611a(activity);
        this.f19295E = new FaceBeautyAdapter(activity);
        this.f19295E.m20536a(OplusGLSurfaceView_13);
        this.f19295E.m20541a(m20603E());
        this.f19295E.m20540a(aVar);
        this.f19295E.m20537a(onClickListener);
        this.f19297G = activity.getLayoutInflater().inflate(m20607b(OplusGLSurfaceView_13, i2), (ViewGroup) null);
        this.f19253a = (LinearLayout) this.f19297G.findViewById(R.id_renamed.tab_container);
        this.f19299I = (OplusNumAISeekBar) this.f19297G.findViewById(R.id_renamed.face_beauty_seekbar);
        m20606a(this.f19299I);
        this.f19298H = this.f19299I;
        this.f19301K = (COUIRecyclerView) this.f19297G.findViewById(R.id_renamed.face_beauty_custom_recycler);
        final boolean z = 1 == OplusGLSurfaceView_13;
        this.f19302L = new LinearLayoutManager(activity, z ? 1 : 0, false) { // from class: com.oplus.camera.ui.menu.facebeauty.COUIBaseListPopupWindow_12.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
            public boolean canScrollHorizontally() {
                return !z;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
            public boolean canScrollVertically() {
                return z;
            }
        };
        this.f19301K.setLayoutManager(this.f19302L);
        this.f19301K.setAdapter(this.f19295E);
        this.f19301K.setVisibility(8);
        this.f19266n = interfaceC3409f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20606a(OplusNumAISeekBar oplusNumAISeekBar) {
        InverseManager.INS.registerInverse(this.f19297G.getContext(), oplusNumAISeekBar);
        oplusNumAISeekBar.setOnProgressChangedListener(this.f19321ae);
        oplusNumAISeekBar.setFrontStyle(true);
        oplusNumAISeekBar.setmThumbTextShadowBlur((int) Util.m24202a(this.f19297G.getContext(), R.dimen.level_panel_text_shadow_radius, Util.f22962a));
        oplusNumAISeekBar.setmThumbTextShadowColor(this.f19297G.getContext().getResources().getColor(R.color.color_black_with_20_percent_transparency));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m20611a(Activity activity) {
        if (3 == this.f19275w) {
            return activity.getResources().getDimensionPixelOffset(R.dimen.fold_split_screen_face_beauty_tab_margin_bottom);
        }
        return Util.m24187O() - activity.getResources().getDimensionPixelSize(R.dimen.face_beauty_tab_container_height);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: C */
    private void m20601C() {
        View view;
        if (this.f19303M == null && (view = this.f19297G) != null) {
            this.f19300J = (OplusNumAISeekBar) view.findViewById(R.id_renamed.face_beauty_makeup_seekbar);
            m20606a(this.f19300J);
            this.f19296F = new FaceBeautyAdapter(this.f19297G.getContext());
            this.f19296F.m20541a(m20626x());
            this.f19296F.m20540a(this.f19323ag);
            this.f19320ad = new LinearLayoutManager(this.f19297G.getContext(), 0, 0 == true ? 1 : 0) { // from class: com.oplus.camera.ui.menu.facebeauty.COUIBaseListPopupWindow_12.2
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
                public boolean canScrollHorizontally() {
                    return true;
                }
            };
            this.f19303M = (COUIRecyclerView) this.f19297G.findViewById(R.id_renamed.face_beauty_custom_makeup_recycler);
            this.f19303M.setLayoutManager(this.f19320ad);
            this.f19303M.setAdapter(this.f19296F);
        }
        this.f19296F.m20544b(this.f19318ab);
        this.f19296F.notifyDataSetChanged();
        this.f19320ad.scrollToPositionWithOffset(this.f19318ab, m20602D());
    }

    /* renamed from: s */
    public void m20621s() {
        FaceBeautyAdapter c3257c = this.f19295E;
        if (c3257c != null) {
            c3257c.notifyDataSetChanged();
        }
        FaceBeautyAdapter c3257c2 = this.f19296F;
        if (c3257c2 != null) {
            c3257c2.notifyDataSetChanged();
        }
    }

    /* renamed from: D */
    private int m20602D() {
        return ((Util.getScreenWidth() - this.f19317aa) / 2) - this.f19319ac;
    }

    /* renamed from: o */
    public void m20619o(boolean z) {
        FaceBeautyAdapter c3257c = this.f19295E;
        if (c3257c != null) {
            c3257c.m20542a(!z);
        }
    }

    /* renamed from: p */
    public void m20620p(boolean z) {
        m20615a(z, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20615a(boolean z, boolean z2) {
        FaceBeautyAdapter c3257c = this.f19295E;
        if (c3257c != null) {
            c3257c.m20543a(z, z2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20616a(boolean z, boolean z2, boolean z3, int OplusGLSurfaceView_13, boolean z4) {
        CameraLog.m12962c("FaceBeautyCustomMenu", "initFaceBeautyMenu, supportMakeup: " + z + ", supportFilterEffect: " + z2 + ", supFaceBeauty: " + z3 + ", makeupIndex: " + OplusGLSurfaceView_13 + ", supportShowCustomAll: " + z4);
        this.f19261i = z;
        this.f19262j = z2;
        this.f19260h = z3;
        this.f19318ab = OplusGLSurfaceView_13;
        this.f19313W = z4;
        if (this.f19261i) {
            m20601C();
        }
        m20558c();
        this.f19295E.m20541a(m20603E());
        this.f19295E.m20540a(this.f19323ag);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0094  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m20613a(int r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyCustomMenu.m20613a(int, boolean, boolean):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m20617a(int OplusGLSurfaceView_13, RecyclerView.AbstractC0698n abstractC0698n) {
        int i2;
        int iFindLastVisibleItemPosition = this.f19302L.findLastVisibleItemPosition();
        int iFindFirstVisibleItemPosition = this.f19302L.findFirstVisibleItemPosition();
        View viewFindViewByPosition = this.f19302L.findViewByPosition(iFindLastVisibleItemPosition);
        View viewFindViewByPosition2 = this.f19302L.findViewByPosition(iFindFirstVisibleItemPosition);
        Rect rect = new Rect();
        int i3 = this.f19309S + this.f19308R;
        if (viewFindViewByPosition != null && (i2 = iFindLastVisibleItemPosition - OplusGLSurfaceView_13) <= 1 && viewFindViewByPosition.getVisibility() == 0 && viewFindViewByPosition.getLocalVisibleRect(rect) && (iFindLastVisibleItemPosition == OplusGLSurfaceView_13 || rect.width() < viewFindViewByPosition.getWidth())) {
            int width = (viewFindViewByPosition.getWidth() - rect.width()) + ((1 - i2) * i3);
            if (abstractC0698n != null) {
                this.f19301K.clearOnScrollListeners();
                this.f19301K.addOnScrollListener(abstractC0698n);
            }
            this.f19301K.smoothScrollBy(width * (1 == this.f19301K.getLayoutDirection() ? -1 : 1), 0, new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f), 500);
            return width != 0;
        }
        if (viewFindViewByPosition2 == null || OplusGLSurfaceView_13 - iFindFirstVisibleItemPosition > 1 || viewFindViewByPosition2.getVisibility() != 0 || !viewFindViewByPosition2.getLocalVisibleRect(rect)) {
            return false;
        }
        if (iFindFirstVisibleItemPosition != OplusGLSurfaceView_13 && rect.width() >= viewFindViewByPosition2.getWidth()) {
            return false;
        }
        if (abstractC0698n != null) {
            this.f19301K.clearOnScrollListeners();
            this.f19301K.addOnScrollListener(abstractC0698n);
        }
        int width2 = (viewFindViewByPosition2.getWidth() - rect.width()) + (((iFindFirstVisibleItemPosition - OplusGLSurfaceView_13) + 1) * i3);
        this.f19301K.smoothScrollBy((-width2) * (1 == this.f19301K.getLayoutDirection() ? -1 : 1), 0, new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f), 500);
        return width2 != 0;
    }

    /* renamed from: t */
    public boolean m20622t() {
        COUIRecyclerView cOUIRecyclerView = this.f19301K;
        return cOUIRecyclerView == null || this.f19311U > cOUIRecyclerView.getScrollX();
    }

    /* renamed from: u */
    public void m20623u() {
        OplusNumAISeekBar oplusNumAISeekBar = this.f19298H;
        if (oplusNumAISeekBar != null) {
            oplusNumAISeekBar.setVisibility(8);
        }
    }

    /* renamed from: v */
    public void m20624v() {
        OplusNumAISeekBar oplusNumAISeekBar = this.f19298H;
        if (oplusNumAISeekBar != null) {
            oplusNumAISeekBar.setAlpha(0.0f);
            this.f19298H.setVisibility(0);
        }
    }

    /* renamed from: w */
    public int m20625w() {
        if (m20578l()) {
            return this.f19296F.m20534a();
        }
        return this.f19295E.m20534a() - 2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ViewGroup.LayoutParams m20612a(int OplusGLSurfaceView_13, int i2) {
        if (1 == OplusGLSurfaceView_13) {
            this.f19307Q = new RelativeLayout.LayoutParams(-1, -1);
        } else if (4 == OplusGLSurfaceView_13) {
            this.f19307Q = new RelativeLayout.LayoutParams(this.f19277y.getResources().getDimensionPixelOffset(R.dimen.rack_mode_face_beauty_custom_layout_width), -2);
            this.f19307Q.addRule(12);
            this.f19307Q.addRule(14);
            this.f19307Q.setMargins(0, 0, 0, this.f19277y.getResources().getDimensionPixelSize(R.dimen.rack_mode_face_beauty_layout_margin_bottom));
            this.f19307Q.setLayoutDirection(15);
        } else {
            this.f19307Q = new RelativeLayout.LayoutParams(-1, -2);
            this.f19307Q.addRule(12);
            this.f19307Q.setMargins(0, 0, 0, this.f19294D);
        }
        return this.f19307Q;
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.BeautyMenuInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20527a() {
        this.f19257e = 0;
        m20579m(false);
        ViewGroup viewGroup = (ViewGroup) this.f19297G.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f19297G);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20614a(int OplusGLSurfaceView_13, int[] iArr) {
        m20604a(OplusGLSurfaceView_13, iArr, f19293z, f19290A);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20618b(int OplusGLSurfaceView_13, int[] iArr) {
        m20604a(OplusGLSurfaceView_13, iArr, f19291B, f19292C);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20604a(int OplusGLSurfaceView_13, int[] iArr, int[] iArr2, int[] iArr3) {
        int iM20625w = m20625w();
        if (iM20625w < 0 || iM20625w >= iArr3.length) {
            return;
        }
        if (OplusGLSurfaceView_13 == -100000) {
            OplusGLSurfaceView_13 = iArr[iM20625w];
        }
        this.f19298H.m18321b(iArr2[iM20625w]).m18316a(iArr3[iM20625w]).m18325d(iArr[iM20625w]).m18323c(OplusGLSurfaceView_13).postInvalidate();
    }

    /* renamed from: E */
    private List<BeautyMenuItem> m20603E() {
        if (this.f19304N == null) {
            this.f19304N = new ArrayList<>();
            this.f19304N.add(new BeautyMenuItem(R.string.camera_face_beauty_menu_reset, R.drawable.face_beauty_menu_reset, 3));
            this.f19304N.add(new BeautyMenuItem(R.string.camera_face_beauty_menu_level_none, R.drawable.face_beauty_level_none_dark, 4));
            this.f19304N.add(new BeautyMenuItem(R.string.camera_beauty_custom_exfoliating, R.drawable.face_beauty_custom_exfoliating_dark, 0));
            this.f19304N.add(new BeautyMenuItem(R.string.camera_beauty_custom_thin_face, R.drawable.face_beauty_custom_thin_face_dark, 0));
            this.f19304N.add(new BeautyMenuItem(R.string.camera_beauty_custom_big_eye, R.drawable.face_beauty_custom_big_eye_dark, 0));
            this.f19304N.add(new BeautyMenuItem(R.string.camera_beauty_custom_thin_nasal, R.drawable.face_beauty_custom_thin_nasal_dark, 0));
            this.f19304N.add(new BeautyMenuItem(R.string.camera_beauty_custom_chin, R.drawable.face_beauty_custom_chin_dark, 0));
            this.f19304N.add(new BeautyMenuItem(R.string.camera_beauty_custom_little_face, R.drawable.face_beauty_custom_little_face_dark, 0));
            this.f19305O = new ArrayList<>();
            this.f19305O.addAll(this.f19304N);
            this.f19305O.add(new BeautyMenuItem(R.string.camera_beauty_custom_makeup, R.drawable.face_beauty_custom_makeup_dark, 0));
            this.f19305O.add(new BeautyMenuItem(R.string.camera_beauty_custom_3d, R.drawable.face_beauty_custom_3d_dark, 0));
        }
        if (!this.f19313W) {
            return this.f19304N;
        }
        return this.f19305O;
    }

    /* renamed from: x */
    public List<BeautyMenuItem> m20626x() {
        if (this.f19306P == null) {
            this.f19306P = new ArrayList<>();
            this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_none, R.drawable.face_beauty_level_none_dark, 2));
            this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_rosy_nude, R.drawable.makeup_rosy_nude, 1, 1));
            this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_orange_crush, R.drawable.makeup_orange_crush, 1));
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_MAKEUP_TYPE_SNOW)) {
                this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_twilight_snow, R.drawable.makeup_snow, 1, 2));
            }
            this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_first_love, R.drawable.makeup_first_love, 1));
            this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_peach_pink, R.drawable.makeup_peach_pink, 1));
            this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_red_velvet, R.drawable.makeup_red_velvet, 1));
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_MAKEUP_TYPE_DREAM)) {
                this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_dream, R.drawable.makeup_dream, 1, 2));
            }
            this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_sparkling_sea, R.drawable.makeup_sparkling_sea, 1, 1));
            this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_unique_eyes, R.drawable.makeup_unique_eyes, 1, 1));
            this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_midnight, R.drawable.makeup_midnight, 1));
            this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_violet_shimmer, R.drawable.makeup_violet_shimmer, 1, 1));
            this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_smokey, R.drawable.makeup_smokey, 1, 1));
            this.f19306P.add(new BeautyMenuItem(R.string.camera_beauty_makeup_groomed, R.drawable.makeup_groomed, 1));
        }
        return this.f19306P;
    }

    /* renamed from: y */
    public View m20627y() {
        return this.f19297G;
    }

    /* renamed from: z */
    public RecyclerView m20628z() {
        return this.f19301K;
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu
    /* renamed from: q */
    public View mo20585q() {
        return this.f19253a;
    }

    /* renamed from: A */
    public OplusNumAISeekBar m20609A() {
        return this.f19298H;
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu
    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void mo20564e(boolean z) {
        int OplusGLSurfaceView_13 = this.f19257e;
        this.f19257e = 1;
        this.f19267o.mo20592b(m20578l());
        this.f19298H = this.f19299I;
        this.f19298H.setThumbOnDragging(false);
        if (m20556b(OplusGLSurfaceView_13)) {
            mo20572i(z);
        }
        if (m20560c(OplusGLSurfaceView_13)) {
            m20577l(z);
        }
        if (this.f19312V >= 0) {
            this.f19269q = m20547a(this.f19299I, z);
            this.f19268p = m20547a(this.f19301K, z);
            m20614a(this.f19267o.mo20587a(this.f19312V, false), this.f19267o.mo20590a(false));
        } else {
            this.f19268p = m20547a(this.f19301K, z);
            m20605a(8, this.f19299I);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu
    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo20566f(boolean z) {
        this.f19268p = m20553b(this.f19301K, z);
        if (m20608b(this.f19299I)) {
            this.f19269q = m20553b(this.f19299I, z);
        } else {
            m20605a(8, this.f19299I);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu
    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void mo20568g(boolean z) {
        this.f19268p = m20557c(this.f19301K, z);
        if (m20608b(this.f19299I)) {
            this.f19269q = m20557c(this.f19299I, z);
        } else {
            m20605a(8, this.f19299I);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu
    /* renamed from: COUIBaseListPopupWindow_10 */
    protected void mo20570h(boolean z) {
        this.f19303M.setTranslationY(0.0f);
        this.f19300J.setTranslationY(0.0f);
        this.f19300J.setEnabled(true);
        int OplusGLSurfaceView_13 = this.f19257e;
        this.f19257e = 2;
        this.f19267o.mo20592b(m20578l());
        this.f19296F.m20544b(this.f19318ab);
        this.f19296F.notifyDataSetChanged();
        this.f19298H = this.f19300J;
        this.f19298H.setThumbOnDragging(false);
        if (m20552a(OplusGLSurfaceView_13)) {
            mo20566f(z);
        }
        if (m20560c(OplusGLSurfaceView_13)) {
            m20577l(z);
        }
        if (this.f19318ab > 0) {
            this.f19271s = m20547a(this.f19300J, z);
            this.f19270r = m20547a(this.f19303M, z);
            m20618b(this.f19267o.mo20587a(this.f19318ab, true), this.f19267o.mo20590a(true));
        } else {
            this.f19270r = m20547a(this.f19303M, z);
            m20605a(8, this.f19300J);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu
    /* renamed from: OplusGLSurfaceView_13 */
    protected void mo20572i(boolean z) {
        COUIRecyclerView cOUIRecyclerView = this.f19303M;
        if (cOUIRecyclerView != null) {
            this.f19270r = m20553b(cOUIRecyclerView, z);
        }
        if (m20608b(this.f19300J)) {
            this.f19271s = m20553b(this.f19300J, z);
        } else {
            m20605a(8, this.f19300J);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu
    /* renamed from: OplusGLSurfaceView_15 */
    protected void mo20574j(boolean z) {
        COUIRecyclerView cOUIRecyclerView = this.f19303M;
        if (cOUIRecyclerView != null) {
            this.f19270r = m20557c(cOUIRecyclerView, z);
        }
        if (m20608b(this.f19300J)) {
            this.f19271s = m20557c(this.f19300J, z);
        } else {
            m20605a(8, this.f19300J);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20605a(int OplusGLSurfaceView_13, View... viewArr) {
        for (View view : viewArr) {
            view.setVisibility(OplusGLSurfaceView_13);
            view.setAlpha(1.0f);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m20608b(View view) {
        return view != null && view.getVisibility() == 0 && view.getAlpha() > 0.0f;
    }

    /* renamed from: B */
    public void m20610B() {
        COUIRecyclerView cOUIRecyclerView = this.f19301K;
        if (cOUIRecyclerView != null) {
            cOUIRecyclerView.setVisibility(8);
        }
        OplusNumAISeekBar oplusNumAISeekBar = this.f19299I;
        if (oplusNumAISeekBar != null) {
            oplusNumAISeekBar.setVisibility(8);
        }
        OplusNumAISeekBar oplusNumAISeekBar2 = this.f19300J;
        if (oplusNumAISeekBar2 != null) {
            oplusNumAISeekBar2.setVisibility(8);
        }
        COUIRecyclerView cOUIRecyclerView2 = this.f19303M;
        if (cOUIRecyclerView2 != null) {
            cOUIRecyclerView2.setVisibility(8);
        }
    }
}
