package com.oplus.camera.ui.a_renamed;

/* compiled from: HintManager.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f5827a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f5828b;
    private android.content.res.Resources e_renamed;
    private com.oplus.camera.ui.CameraUIInterface w_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f5829c = 0;
    private int d_renamed = 0;
    private android.view.ViewGroup f_renamed = null;
    private com.oplus.camera.ui.camerascreenhint.CameraScreenHintView g_renamed = null;
    private com.oplus.camera.ui.camerascreenhint.CameraScreenHintView h_renamed = null;
    private com.oplus.camera.ui.camerascreenhint.CameraScreenHintView i_renamed = null;
    private java.util.ArrayList<com.oplus.camera.ui.camerascreenhint.CameraScreenHintView> j_renamed = null;
    private com.oplus.camera.ui.preview.a_renamed k_renamed = null;
    private int l_renamed = 0;
    private int m_renamed = 0;
    private int n_renamed = 0;
    private int o_renamed = 0;
    private int p_renamed = 0;
    private int q_renamed = 0;
    private int r_renamed = -1;
    private int s_renamed = 0;
    private boolean t_renamed = false;
    private long u_renamed = 0;
    private java.lang.String v_renamed = null;
    private java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> x_renamed = new java.util.ArrayList<>();
    private java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> y_renamed = new java.util.ArrayList<>();
    private java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> z_renamed = new java.util.ArrayList<>();
    private java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> A_renamed = new java.util.ArrayList<>();
    private java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> B_renamed = new java.util.ArrayList<>();
    private java.util.List<java.lang.Integer> C_renamed = new java.util.ArrayList();
    private java.util.Map<java.lang.Integer, java.lang.String> D_renamed = new java.util.concurrent.ConcurrentHashMap();
    private com.oplus.camera.ui.a_renamed.a_renamed.b_renamed F_renamed = null;
    private boolean G_renamed = false;
    private android.os.Handler E_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ui.a_renamed.a_renamed.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) throws java.lang.NumberFormatException {
            int i_renamed = message.what;
            if (i_renamed == 1) {
                int i2 = java.lang.Integer.parseInt((java.lang.String) message.obj);
                com.oplus.camera.ui.a_renamed.a_renamed.this.a_renamed(i2, true);
                if (com.oplus.camera.ui.a_renamed.a_renamed.this.F_renamed != null) {
                    com.oplus.camera.ui.a_renamed.a_renamed.this.F_renamed.a_renamed(i2);
                    return;
                }
                return;
            }
            if (i_renamed == 2) {
                com.oplus.camera.ui.a_renamed.a_renamed.this.b_renamed(true);
            } else if (i_renamed == 3) {
                com.oplus.camera.ui.a_renamed.a_renamed.this.l_renamed();
            } else {
                if (i_renamed != 4) {
                    return;
                }
                com.oplus.camera.ui.a_renamed.a_renamed.this.k_renamed();
            }
        }
    };

    /* compiled from: HintManager.java */
    /* renamed from: com.oplus.camera.ui.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public interface HintManager_2 {
        void a_renamed();
    }

    /* compiled from: HintManager.java */
    public interface b_renamed {
        void a_renamed(int i_renamed);

        void a_renamed(com.oplus.camera.ui.a_renamed.b_renamed bVar);
    }

    /* compiled from: HintManager.java */
    private class c_renamed implements com.oplus.camera.ui.a_renamed.a_renamed.HintManager_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final java.lang.String f5837a;

        public c_renamed(java.lang.String str) {
            this.f5837a = str;
        }

        @Override // com.oplus.camera.ui.a_renamed.a_renamed.HintManager_2
        public void a_renamed() {
            if (com.oplus.camera.ui.a_renamed.a_renamed.this.j_renamed == null || com.oplus.camera.ui.a_renamed.a_renamed.this.j_renamed.isEmpty()) {
                return;
            }
            java.util.Iterator it = com.oplus.camera.ui.a_renamed.a_renamed.this.j_renamed.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = (com.oplus.camera.ui.camerascreenhint.CameraScreenHintView) it.next();
                java.lang.Object tag = cameraScreenHintView.getTag(com.oplus.camera.R_renamed.id_renamed.hint_prev_margins_tag);
                if (tag instanceof int[]) {
                    int[] iArr = (int[]) tag;
                    if (iArr.length == 2) {
                        cameraScreenHintView.a_renamed(iArr[0], iArr[1]);
                    }
                }
            }
        }
    }

    public a_renamed(android.content.res.Resources resources, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        this.f5827a = 0;
        this.f5828b = 0;
        this.e_renamed = null;
        this.w_renamed = cameraUIInterface;
        this.e_renamed = resources;
        this.f5827a = this.e_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.hint_margin_top_horizontal);
        this.f5828b = this.e_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.hint_margin_top_vertical);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k_renamed() {
        a_renamed(this.C_renamed.get(this.r_renamed).intValue());
        this.E_renamed.sendEmptyMessageDelayed(3, 3000L);
    }

    public void a_renamed(java.util.List<java.lang.Integer> list, long j_renamed) {
        if (!this.C_renamed.isEmpty()) {
            this.C_renamed.clear();
        }
        this.C_renamed.addAll(list);
        this.u_renamed = j_renamed;
        l_renamed();
    }

    public void a_renamed() {
        if (this.C_renamed == null) {
            return;
        }
        com.oplus.camera.e_renamed.c_renamed("HintManager", "hideLooperCameraScreenHintText");
        this.E_renamed.removeMessages(3);
        this.E_renamed.removeMessages(4);
        c_renamed(false);
        this.C_renamed.clear();
        this.r_renamed = -1;
        this.u_renamed = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l_renamed() {
        this.r_renamed = (this.r_renamed + 1) % this.C_renamed.size();
        a_renamed(this.C_renamed.get(this.r_renamed).intValue(), true, false, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, 0, false);
        this.E_renamed.sendEmptyMessageDelayed(4, this.u_renamed);
    }

    public void a_renamed(com.oplus.camera.ui.a_renamed.a_renamed.b_renamed bVar) {
        this.F_renamed = bVar;
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed("HintManager", "setManual: " + this.t_renamed + " -> " + z_renamed);
        this.t_renamed = z_renamed;
    }

    public boolean b_renamed() {
        return this.t_renamed;
    }

    public boolean c_renamed() {
        return !this.x_renamed.isEmpty();
    }

    public boolean a_renamed(java.lang.String str) {
        java.lang.String str2;
        return this.t_renamed && (str2 = this.v_renamed) != null && str2.equals(str);
    }

    public void b_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.c_renamed("HintManager", "setManualKey: " + this.v_renamed + " -> " + str);
        this.v_renamed = str;
    }

    public java.lang.String d_renamed() {
        return this.v_renamed;
    }

    public void a_renamed(android.view.ViewGroup viewGroup) {
        this.f_renamed = viewGroup;
    }

    public void a_renamed(com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView, com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView2, com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView3) {
        this.g_renamed = cameraScreenHintView;
        this.h_renamed = cameraScreenHintView2;
        this.i_renamed = cameraScreenHintView3;
        this.j_renamed = new java.util.ArrayList<>();
        this.j_renamed.add(this.g_renamed);
        this.j_renamed.add(this.h_renamed);
        this.j_renamed.add(this.i_renamed);
        this.f5829c = this.e_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.hint_right_hint_view_height);
        this.s_renamed = com.oplus.camera.util.Util.L_renamed();
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView4 = this.i_renamed;
        int i_renamed = this.f5828b;
        int i2 = this.f5829c;
        cameraScreenHintView4.a_renamed(i_renamed + i2, i_renamed + i2);
        this.g_renamed.setTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag, null);
        this.h_renamed.setTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag, null);
        this.i_renamed.setTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag, null);
        this.g_renamed.setTag(com.google.android.exoplayer2.text.ttml.TtmlNode.LEFT);
        this.h_renamed.setTag(com.google.android.exoplayer2.text.ttml.TtmlNode.RIGHT);
        this.i_renamed.setTag(com.google.android.exoplayer2.text.ttml.TtmlNode.CENTER);
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed aVar) {
        this.k_renamed = aVar;
    }

    public com.oplus.camera.ui.a_renamed.a_renamed.HintManager_2 a_renamed(int i_renamed, int i2) {
        java.util.ArrayList<com.oplus.camera.ui.camerascreenhint.CameraScreenHintView> arrayList = this.j_renamed;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        java.util.Iterator<com.oplus.camera.ui.camerascreenhint.CameraScreenHintView> it = this.j_renamed.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.camerascreenhint.CameraScreenHintView next = it.next();
            next.setTag(com.oplus.camera.R_renamed.id_renamed.hint_prev_margins_tag, new int[]{next.getMarginLeft() - next.getViewGap(), next.getMarginTop() - next.getViewGap()});
            next.a_renamed(i_renamed, i2);
        }
        return new com.oplus.camera.ui.a_renamed.a_renamed.c_renamed("updateMarginLeftAndTop");
    }

    public void a_renamed(int i_renamed) {
        if (!this.z_renamed.isEmpty()) {
            this.z_renamed.clear();
            a_renamed(this.B_renamed, com.oplus.camera.ui.a_renamed.b_renamed.a_renamed.SPECIAL);
        }
        if (!this.x_renamed.isEmpty()) {
            this.x_renamed.clear();
            a_renamed(this.B_renamed, com.oplus.camera.ui.a_renamed.b_renamed.a_renamed.TEMP);
        }
        com.oplus.camera.ui.a_renamed.b_renamed bVar = new com.oplus.camera.ui.a_renamed.b_renamed();
        bVar.s_renamed = com.oplus.camera.ui.a_renamed.b_renamed.a_renamed.SPECIAL;
        bVar.r_renamed = com.oplus.camera.ui.a_renamed.b_renamed.HintModel_3.AI_SCENE;
        bVar.o_renamed = i_renamed;
        a_renamed(bVar);
        m_renamed();
    }

    public void e_renamed() {
        java.util.Iterator<com.oplus.camera.ui.a_renamed.b_renamed> it = this.z_renamed.iterator();
        while (it.hasNext()) {
            if (com.oplus.camera.ui.a_renamed.b_renamed.HintModel_3.AI_SCENE == it.next().r_renamed) {
                it.remove();
            }
        }
        java.util.Iterator<com.oplus.camera.ui.a_renamed.b_renamed> it2 = this.B_renamed.iterator();
        while (it2.hasNext()) {
            if (com.oplus.camera.ui.a_renamed.b_renamed.HintModel_3.AI_SCENE == it2.next().r_renamed) {
                it2.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_renamed() {
        if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread()) {
            this.E_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.a_renamed.a_renamed.2
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.a_renamed.a_renamed.this.m_renamed();
                }
            });
            return;
        }
        if (this.B_renamed.isEmpty()) {
            a_renamed(this.g_renamed);
            a_renamed(this.h_renamed);
            a_renamed(this.i_renamed);
            n_renamed();
            return;
        }
        if (!this.x_renamed.isEmpty()) {
            a_renamed(this.x_renamed.get(0), this.g_renamed, false);
            a_renamed(this.h_renamed);
            a_renamed(this.i_renamed);
            this.k_renamed.c_renamed(8);
            n_renamed();
            return;
        }
        if (!this.y_renamed.isEmpty() && !this.z_renamed.isEmpty() && !this.A_renamed.isEmpty()) {
            a_renamed(this.z_renamed.get(0), this.g_renamed, false);
            a_renamed(this.A_renamed.get(0), this.h_renamed, false);
            a_renamed(this.y_renamed.get(0), this.i_renamed, true);
        } else if (!this.z_renamed.isEmpty() && !this.A_renamed.isEmpty()) {
            a_renamed(this.z_renamed.get(0), this.g_renamed, false);
            a_renamed(this.A_renamed.get(0), this.h_renamed, false);
            a_renamed(this.i_renamed);
        } else if (!this.A_renamed.isEmpty() && !this.y_renamed.isEmpty()) {
            a_renamed(this.A_renamed.get(0), this.g_renamed, false);
            a_renamed(this.y_renamed.get(0), this.i_renamed, true);
            a_renamed(this.h_renamed);
        } else if (!this.y_renamed.isEmpty() && !this.z_renamed.isEmpty()) {
            a_renamed(this.z_renamed.get(0), this.g_renamed, false);
            a_renamed(this.y_renamed.get(0), this.i_renamed, true);
            a_renamed(this.h_renamed);
        } else {
            a_renamed(this.B_renamed.get(0), this.g_renamed, false);
            a_renamed(this.h_renamed);
            a_renamed(this.i_renamed);
        }
        n_renamed();
    }

    private void a_renamed(com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView, boolean z_renamed) {
        java.lang.String str = (java.lang.String) cameraScreenHintView.getTag();
        java.lang.Object tag = cameraScreenHintView.getTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag);
        if (tag == null) {
            com.oplus.camera.e_renamed.c_renamed("HintManager", "clearViewNoAnim:return: " + str);
            if (cameraScreenHintView.i_renamed() && z_renamed) {
                cameraScreenHintView.d_renamed();
                cameraScreenHintView.b_renamed(false);
                cameraScreenHintView.a_renamed(false);
                return;
            }
            return;
        }
        com.oplus.camera.ui.a_renamed.b_renamed bVar = (com.oplus.camera.ui.a_renamed.b_renamed) tag;
        cameraScreenHintView.a_renamed(!z_renamed && bVar.k_renamed);
        cameraScreenHintView.b_renamed(!z_renamed && bVar.j_renamed);
        if (z_renamed || !bVar.j_renamed) {
            cameraScreenHintView.h_renamed();
        }
        cameraScreenHintView.setTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag, null);
    }

    private void a_renamed(com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView) {
        a_renamed(cameraScreenHintView, false);
    }

    public void f_renamed() {
        this.f_renamed.removeView(this.g_renamed);
        this.f_renamed.removeView(this.h_renamed);
        this.f_renamed.removeView(this.i_renamed);
    }

    private void n_renamed() {
        boolean zI = this.k_renamed.i_renamed();
        int i_renamed = this.n_renamed;
        if (1 == i_renamed) {
            this.q_renamed = this.e_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_AI_scene_view_margin_top_offset);
            if (this.o_renamed != 0) {
                this.q_renamed = this.e_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_AI_scene_view_margin_top_offset_rotate);
            }
        } else if (4 == i_renamed) {
            this.q_renamed = this.e_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_AI_scene_view_margin_top_offset);
        } else {
            this.q_renamed = 0;
        }
        com.oplus.camera.e_renamed.c_renamed("HintManager", "requestLayout:\nleft:" + this.g_renamed.getTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag) + "\nright:" + this.h_renamed.getTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag) + "\ncenter:" + this.i_renamed.getTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag) + "\nisAISceneShow:" + zI + "\n_renamed");
        if (this.h_renamed.getTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag) == null) {
            if (zI) {
                this.k_renamed.a_renamed(0, this.q_renamed, this.p_renamed, this.G_renamed);
            } else {
                this.g_renamed.b_renamed(0);
            }
            this.h_renamed.setAlpha(0.0f);
            return;
        }
        int textWidth = this.h_renamed.getTextWidth();
        if (zI) {
            android.widget.RelativeLayout relativeLayoutG = this.k_renamed.g_renamed();
            iconWidth = relativeLayoutG != null ? relativeLayoutG.getMeasuredWidth() : 0;
            this.k_renamed.a_renamed((textWidth + this.f5827a) / 2, this.q_renamed, this.p_renamed, this.G_renamed);
        } else if (this.g_renamed.getAlpha() != 0.0f) {
            iconWidth = com.oplus.camera.ui.a_renamed.b_renamed.HintModel_3.ICON == ((com.oplus.camera.ui.a_renamed.b_renamed) this.g_renamed.getTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag)).r_renamed ? this.g_renamed.getIconWidth() : this.g_renamed.getMeasuredWidth();
            this.g_renamed.b_renamed(textWidth + this.f5827a);
        }
        this.h_renamed.setAlpha(1.0f);
        this.h_renamed.b_renamed(-(iconWidth + this.f5827a));
    }

    private com.oplus.camera.ui.a_renamed.b_renamed b_renamed(com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView) {
        java.lang.Object tag = cameraScreenHintView.getTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag);
        if (tag instanceof com.oplus.camera.ui.a_renamed.b_renamed) {
            return (com.oplus.camera.ui.a_renamed.b_renamed) tag;
        }
        return null;
    }

    private void a_renamed(com.oplus.camera.ui.a_renamed.b_renamed bVar, com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView, boolean z_renamed) {
        java.lang.String strA;
        if (bVar == null || cameraScreenHintView == null) {
            return;
        }
        if (!bVar.equals(b_renamed(cameraScreenHintView))) {
            a_renamed(cameraScreenHintView, true);
        }
        cameraScreenHintView.setTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag, bVar);
        cameraScreenHintView.bringToFront();
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.w_renamed;
        int i_renamed = (cameraUIInterface == null || !cameraUIInterface.bd_renamed() || com.oplus.camera.util.Util.t_renamed()) ? 0 : this.s_renamed;
        int i2 = com.oplus.camera.ui.a_renamed.a_renamed.DoubleExposureMode_3.f5835a[bVar.r_renamed.ordinal()];
        if (i2 == 1) {
            if (cameraScreenHintView != this.i_renamed) {
                cameraScreenHintView.a_renamed(this.e_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.hint_icon_margin_top) + i_renamed);
            } else {
                cameraScreenHintView.a_renamed(this.f5828b + this.f5829c + i_renamed);
            }
            cameraScreenHintView.setIconAlpha(1.0f);
            cameraScreenHintView.a_renamed(bVar.f5840b, bVar.e_renamed, bVar.f_renamed, bVar.n_renamed, bVar.g_renamed, bVar.p_renamed);
            c_renamed(cameraScreenHintView);
            cameraScreenHintView.setAlpha(1.0f);
            return;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            cameraScreenHintView.setAlpha(0.0f);
            this.k_renamed.d_renamed(i_renamed);
            this.k_renamed.c_renamed(0);
            return;
        }
        if (cameraScreenHintView != this.i_renamed) {
            cameraScreenHintView.a_renamed(i_renamed);
        } else {
            cameraScreenHintView.a_renamed(this.f5828b + this.f5829c + i_renamed);
        }
        if (bVar.f5841c > -1) {
            strA = com.oplus.camera.util.Util.a_renamed(bVar.f5839a, bVar.f5841c, bVar.q_renamed);
        } else {
            strA = com.oplus.camera.util.Util.a_renamed(bVar.f5839a, bVar.q_renamed);
        }
        if (z_renamed) {
            cameraScreenHintView.setChangeHintColor(true);
            cameraScreenHintView.a_renamed(new com.oplus.camera.ui.camerascreenhint.a_renamed.CameraScreenHintInfo_2().a_renamed(strA).a_renamed(0).a_renamed(bVar.d_renamed).b_renamed(false).c_renamed(bVar.n_renamed).d_renamed(bVar.p_renamed).c_renamed(bVar.h_renamed).d_renamed(bVar.g_renamed).a_renamed());
        } else {
            if (bVar.m_renamed > 0 && bVar.l_renamed > 0) {
                cameraScreenHintView.setChangeHintColor(true);
            }
            cameraScreenHintView.a_renamed(new com.oplus.camera.ui.camerascreenhint.a_renamed.CameraScreenHintInfo_2().a_renamed(strA).a_renamed(true).b_renamed(false).d_renamed(bVar.p_renamed).a_renamed(bVar.l_renamed).b_renamed(bVar.m_renamed).c_renamed(bVar.h_renamed).e_renamed(bVar.i_renamed).d_renamed(bVar.g_renamed).a_renamed());
        }
        c_renamed(cameraScreenHintView);
        cameraScreenHintView.setAlpha(1.0f);
    }

    /* compiled from: HintManager.java */
    /* renamed from: com.oplus.camera.ui.a_renamed.a_renamed$4, reason: invalid class name */
    static /* synthetic */ class DoubleExposureMode_3 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f5835a;

        /* renamed from: b_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f5836b = new int[com.oplus.camera.ui.a_renamed.b_renamed.a_renamed.values().length];

        static {
            try {
                f5836b[com.oplus.camera.ui.a_renamed.b_renamed.a_renamed.TEMP_COMPATIBLE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f5836b[com.oplus.camera.ui.a_renamed.b_renamed.a_renamed.SPECIAL.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f5836b[com.oplus.camera.ui.a_renamed.b_renamed.a_renamed.CONDITION.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f5836b[com.oplus.camera.ui.a_renamed.b_renamed.a_renamed.TEMP.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                f5836b[com.oplus.camera.ui.a_renamed.b_renamed.a_renamed.UNKNOWN.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            f5835a = new int[com.oplus.camera.ui.a_renamed.b_renamed.HintModel_3.values().length];
            try {
                f5835a[com.oplus.camera.ui.a_renamed.b_renamed.HintModel_3.ICON.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                f5835a[com.oplus.camera.ui.a_renamed.b_renamed.HintModel_3.STRING.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                f5835a[com.oplus.camera.ui.a_renamed.b_renamed.HintModel_3.AI_SCENE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
        }
    }

    private void a_renamed(com.oplus.camera.ui.a_renamed.b_renamed bVar) {
        if (bVar == null) {
            return;
        }
        int i_renamed = com.oplus.camera.ui.a_renamed.a_renamed.DoubleExposureMode_3.f5836b[bVar.s_renamed.ordinal()];
        if (i_renamed == 1) {
            this.y_renamed.add(0, bVar);
            if (this.y_renamed.size() > 2) {
                java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> arrayList = this.y_renamed;
                com.oplus.camera.ui.a_renamed.b_renamed bVar2 = arrayList.get(arrayList.size() - 1);
                java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> arrayList2 = this.y_renamed;
                arrayList2.remove(arrayList2.size() - 1);
                this.B_renamed.remove(bVar2);
            }
        } else if (i_renamed == 2) {
            this.z_renamed.add(0, bVar);
            if (this.z_renamed.size() > 2) {
                java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> arrayList3 = this.z_renamed;
                com.oplus.camera.ui.a_renamed.b_renamed bVar3 = arrayList3.get(arrayList3.size() - 1);
                java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> arrayList4 = this.z_renamed;
                arrayList4.remove(arrayList4.size() - 1);
                this.B_renamed.remove(bVar3);
            }
        } else if (i_renamed == 3) {
            this.A_renamed.add(0, bVar);
            if (this.A_renamed.size() > 3) {
                java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> arrayList5 = this.A_renamed;
                com.oplus.camera.ui.a_renamed.b_renamed bVar4 = arrayList5.get(arrayList5.size() - 1);
                java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> arrayList6 = this.A_renamed;
                arrayList6.remove(arrayList6.size() - 1);
                this.B_renamed.remove(bVar4);
            }
        } else {
            this.x_renamed.add(0, bVar);
            if (this.x_renamed.size() > 2) {
                java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> arrayList7 = this.x_renamed;
                com.oplus.camera.ui.a_renamed.b_renamed bVar5 = arrayList7.get(arrayList7.size() - 1);
                a_renamed(this.x_renamed, bVar5);
                a_renamed(this.B_renamed, bVar5);
            }
        }
        this.B_renamed.add(0, bVar);
    }

    private void a_renamed(java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> arrayList, com.oplus.camera.ui.a_renamed.b_renamed bVar) {
        if (bVar == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                size = -1;
                break;
            } else if (bVar.equals(arrayList.get(size))) {
                break;
            } else {
                size--;
            }
        }
        if (size >= 0) {
            arrayList.remove(size);
        }
    }

    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2, int i2, int i3, int i4, boolean z3) {
        a_renamed(i_renamed, z_renamed, z2, i2, i3, i4, z3, null);
    }

    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2, int i2, int i3, int i4, boolean z3, java.lang.Object... objArr) {
        a_renamed(i_renamed, z_renamed, z2, 3000, i2, i3, i4, false, z3, false, -1, objArr);
    }

    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, java.lang.Object... objArr) {
        a_renamed(i_renamed, z_renamed, z2, i2, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, i3, z3, z4, z5, -1, objArr);
    }

    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, java.lang.Object... objArr) {
        a_renamed(i_renamed, z_renamed, z2, i2, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, i3, z3, z4, z5, i4, objArr);
    }

    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2, int i2, int i3, int i4, int i5, boolean z3, boolean z4, boolean z5) {
        a_renamed(i_renamed, z_renamed, z2, i2, i3, i4, i5, z3, z4, z5, -1, null);
    }

    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2, int i2, int i3, int i4, int i5, boolean z3, boolean z4, boolean z5, int i6, java.lang.Object... objArr) {
        int iO;
        com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOptionH;
        com.oplus.camera.ComboPreferences comboPreferences;
        if (2 == this.d_renamed && com.oplus.camera.util.Util.t_renamed()) {
            com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.w_renamed;
            iO = (cameraUIInterface == null || (cameraMenuOptionH = cameraUIInterface.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE)) == null || (comboPreferences = cameraMenuOptionH.f6559a) == null || "on_renamed".equals(comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, "off")) || com.oplus.camera.util.Util.u_renamed()) ? i3 : com.oplus.camera.R_renamed.drawable.screen_hint_textview_white_bg;
            int i7 = this.l_renamed;
            if (i7 % 180 == 0) {
                i7 = 0;
            }
            if (i7 != 0 && !com.oplus.camera.util.Util.u_renamed()) {
                iO = com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg;
            }
        } else {
            iO = i3;
        }
        if (1 == this.n_renamed) {
            iO = o_renamed();
        }
        com.oplus.camera.ui.a_renamed.b_renamed bVar = new com.oplus.camera.ui.a_renamed.b_renamed(i_renamed, z_renamed, z2, i2, iO, i4, i5, z3, z4, z5, i6, objArr);
        com.oplus.camera.e_renamed.c_renamed("HintManager", "showHint:" + bVar.toString());
        com.oplus.camera.ui.a_renamed.a_renamed.b_renamed bVar2 = this.F_renamed;
        if (bVar2 != null) {
            bVar2.a_renamed(bVar);
        }
        a_renamed(bVar);
        m_renamed();
        if (z2) {
            if (this.E_renamed.hasMessages(1, a_renamed(java.lang.Integer.valueOf(i_renamed)))) {
                this.E_renamed.removeMessages(1, a_renamed(java.lang.Integer.valueOf(i_renamed)));
            }
            this.E_renamed.sendMessageDelayed(this.E_renamed.obtainMessage(1, a_renamed(java.lang.Integer.valueOf(i_renamed))), i2 + i5);
        }
    }

    public void b_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
    }

    private java.lang.String a_renamed(java.lang.Integer num) {
        if (!this.D_renamed.containsKey(num)) {
            this.D_renamed.put(num, num.toString());
        }
        return this.D_renamed.get(num);
    }

    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2, int i2, boolean z3, int i3) {
        com.oplus.camera.ui.a_renamed.b_renamed bVar = new com.oplus.camera.ui.a_renamed.b_renamed(i_renamed, z_renamed, z2, i2, z3, i3);
        com.oplus.camera.e_renamed.c_renamed("HintManager", "showHintImage:" + bVar.toString());
        a_renamed(bVar);
        m_renamed();
        if (z2) {
            this.E_renamed.sendMessageDelayed(this.E_renamed.obtainMessage(2, i_renamed, 0), i2);
        }
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.ui.a_renamed.b_renamed bVar = (com.oplus.camera.ui.a_renamed.b_renamed) this.g_renamed.getTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag);
        com.oplus.camera.e_renamed.c_renamed("HintManager", "hideHintImage:" + z_renamed + ";" + bVar);
        if (bVar != null && com.oplus.camera.ui.a_renamed.b_renamed.a_renamed.SPECIAL == bVar.s_renamed) {
            bVar.k_renamed = z_renamed;
        }
        java.util.Iterator<com.oplus.camera.ui.a_renamed.b_renamed> it = this.z_renamed.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.a_renamed.b_renamed next = it.next();
            if (next.r_renamed != com.oplus.camera.ui.a_renamed.b_renamed.HintModel_3.AI_SCENE) {
                it.remove();
                this.B_renamed.remove(next);
            }
        }
        m_renamed();
    }

    private void a_renamed(java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> arrayList, com.oplus.camera.ui.a_renamed.b_renamed.a_renamed aVar) {
        if (arrayList.isEmpty()) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.a_renamed.b_renamed> it = arrayList.iterator();
        while (it.hasNext()) {
            if (aVar == it.next().s_renamed) {
                it.remove();
            }
        }
    }

    private void c_renamed(com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView) {
        if (this.f_renamed.indexOfChild(cameraScreenHintView) != -1) {
            return;
        }
        this.f_renamed.addView(cameraScreenHintView);
    }

    public void g_renamed() {
        this.x_renamed.clear();
        a_renamed(this.B_renamed, com.oplus.camera.ui.a_renamed.b_renamed.a_renamed.TEMP);
        m_renamed();
    }

    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed("HintManager", "hideHint:" + z_renamed);
        if (this.E_renamed.hasMessages(1)) {
            this.E_renamed.removeMessages(1);
        }
        java.util.Iterator<com.oplus.camera.ui.camerascreenhint.CameraScreenHintView> it = this.j_renamed.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.a_renamed.b_renamed bVar = (com.oplus.camera.ui.a_renamed.b_renamed) it.next().getTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag);
            if (bVar != null) {
                bVar.k_renamed = z_renamed;
                bVar.j_renamed = z_renamed;
            }
        }
        this.B_renamed.clear();
        this.y_renamed.clear();
        this.x_renamed.clear();
        this.z_renamed.clear();
        this.A_renamed.clear();
        this.E_renamed.removeCallbacksAndMessages(null);
        this.D_renamed.clear();
        m_renamed();
    }

    public void a_renamed(int... iArr) {
        if (iArr == null) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i_renamed : iArr) {
            sb.append(this.e_renamed.getString(i_renamed));
            sb.append(", ");
            if (this.E_renamed.hasMessages(1, a_renamed(java.lang.Integer.valueOf(i_renamed)))) {
                this.E_renamed.removeMessages(1, a_renamed(java.lang.Integer.valueOf(i_renamed)));
            }
            a_renamed(i_renamed, this.B_renamed);
            a_renamed(i_renamed, this.y_renamed);
            a_renamed(i_renamed, this.x_renamed);
            a_renamed(i_renamed, this.A_renamed);
            a_renamed(i_renamed, this.z_renamed);
        }
        com.oplus.camera.e_renamed.c_renamed("HintManager", "hideHint:" + sb.toString());
        m_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, boolean z_renamed) {
        java.util.Iterator<com.oplus.camera.ui.camerascreenhint.CameraScreenHintView> it = this.j_renamed.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.a_renamed.b_renamed bVar = (com.oplus.camera.ui.a_renamed.b_renamed) it.next().getTag(com.oplus.camera.R_renamed.id_renamed.hint_model_tag);
            if (bVar != null && bVar.r_renamed == com.oplus.camera.ui.a_renamed.b_renamed.HintModel_3.STRING && bVar.f5839a == i_renamed) {
                bVar.j_renamed = z_renamed;
            }
        }
        a_renamed(i_renamed, this.B_renamed);
        a_renamed(i_renamed, this.y_renamed);
        a_renamed(i_renamed, this.x_renamed);
        a_renamed(i_renamed, this.A_renamed);
        a_renamed(i_renamed, this.z_renamed);
        m_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(final int i_renamed, final java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed> arrayList) {
        if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread()) {
            this.E_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.a_renamed.a_renamed.3
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.a_renamed.a_renamed.this.a_renamed(i_renamed, (java.util.ArrayList<com.oplus.camera.ui.a_renamed.b_renamed>) arrayList);
                }
            });
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.a_renamed.b_renamed> it = arrayList.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.a_renamed.b_renamed next = it.next();
            if (next.r_renamed == com.oplus.camera.ui.a_renamed.b_renamed.HintModel_3.STRING && next.f5839a == i_renamed) {
                it.remove();
            }
        }
    }

    public void d_renamed(boolean z_renamed) {
        this.g_renamed.setMoreMode(z_renamed);
        this.h_renamed.setMoreMode(z_renamed);
        this.i_renamed.setMoreMode(z_renamed);
    }

    public void h_renamed() {
        this.g_renamed.c_renamed();
        this.h_renamed.c_renamed();
        this.i_renamed.c_renamed();
    }

    public void i_renamed() {
        this.g_renamed.b_renamed();
        this.h_renamed.b_renamed();
        this.i_renamed.b_renamed();
        this.E_renamed.removeCallbacksAndMessages(null);
        this.D_renamed.clear();
    }

    public void c_renamed(int i_renamed) {
        this.l_renamed = i_renamed;
        java.util.Iterator<com.oplus.camera.ui.camerascreenhint.CameraScreenHintView> it = this.j_renamed.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.camerascreenhint.CameraScreenHintView next = it.next();
            if (next.getVisibility() == 0 && 0.0f != next.getAlpha()) {
                next.setOrientation(i_renamed);
            } else {
                next.setOrientationNoAnim(i_renamed);
            }
        }
    }

    public void a_renamed(android.util.Size size) {
        java.util.Iterator<com.oplus.camera.ui.camerascreenhint.CameraScreenHintView> it = this.j_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(size);
        }
    }

    public void a_renamed(com.oplus.camera.screen.b_renamed.a_renamed aVar) {
        this.G_renamed = aVar.q_renamed();
        int iK = aVar.k_renamed();
        int iJ = aVar.j_renamed();
        java.util.Iterator<com.oplus.camera.ui.camerascreenhint.CameraScreenHintView> it = this.j_renamed.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.camerascreenhint.CameraScreenHintView next = it.next();
            next.a_renamed(aVar, iK);
            next.setIsLowRack(this.G_renamed);
            if (4 == iJ && this.G_renamed) {
                next.a_renamed(0, this.e_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.low_rack_mode_camera_screen_hint_view_margin_bottom), 0, true);
            } else {
                next.setBMarginBottom(false);
                next.e_renamed();
            }
            if (1 == iJ || 4 == iJ) {
                next.f_renamed();
            }
        }
        if ((1 == iJ && iK != 0) || 4 == iJ) {
            this.p_renamed = com.oplus.camera.util.Util.getScreenHeight();
        } else {
            this.p_renamed = com.oplus.camera.util.Util.getScreenWidth();
        }
        if (this.k_renamed != null) {
            n_renamed();
        }
        this.n_renamed = iJ;
        this.o_renamed = iK;
    }

    private int o_renamed() {
        if (this.o_renamed == 0) {
            return com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg;
        }
        int i_renamed = this.d_renamed;
        return (i_renamed == 0 || 1 == i_renamed) ? com.oplus.camera.R_renamed.drawable.screen_hint_textview_white_bg : com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg;
    }

    public java.lang.String j_renamed() {
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.g_renamed;
        return cameraScreenHintView != null ? cameraScreenHintView.getHintTextViewString() : "";
    }
}
