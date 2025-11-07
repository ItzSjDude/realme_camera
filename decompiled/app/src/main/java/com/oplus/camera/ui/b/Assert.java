package com.oplus.camera.ui.b_renamed;

/* compiled from: CameraSuperTextUI.java */
/* loaded from: classes2.dex */
public class a_renamed implements com.oplus.camera.d_renamed {
    private android.app.Activity g_renamed;
    private com.oplus.camera.ui.CameraUIListener h_renamed;
    private com.oplus.camera.ui.control.a_renamed i_renamed;
    private android.view.ViewGroup j_renamed = null;
    private android.graphics.Bitmap k_renamed = null;
    private android.graphics.Bitmap l_renamed = null;
    private com.oplus.camera.ui.control.e_renamed m_renamed = null;
    private boolean n_renamed = false;
    private com.oplus.camera.ui.widget.RoundImageView o_renamed = null;
    private com.a_renamed.a_renamed.j_renamed p_renamed = com.a_renamed.a_renamed.j_renamed.c_renamed();
    private android.animation.ObjectAnimator q_renamed = null;
    private android.animation.ObjectAnimator r_renamed = null;
    private boolean s_renamed = false;
    private boolean t_renamed = false;
    private int u_renamed = 0;
    private int v_renamed = 0;

    @android.annotation.SuppressLint({"HandlerLeak"})
    private android.os.Handler w_renamed = new android.os.Handler() { // from class: com.oplus.camera.ui.b_renamed.a_renamed.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) throws android.content.res.Resources.NotFoundException {
            com.oplus.camera.e_renamed.a_renamed("CameraSuperTextUI", "handleMessage, msg: " + message.what);
            if (message.what != 101) {
                return;
            }
            com.oplus.camera.ui.b_renamed.a_renamed.this.d_renamed();
        }
    };

    public a_renamed(android.app.Activity activity, com.oplus.camera.ui.CameraUIListener cameraUIListener, com.oplus.camera.ui.control.a_renamed aVar) {
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.g_renamed = activity;
        this.h_renamed = cameraUIListener;
        this.i_renamed = aVar;
    }

    public void a_renamed(android.view.ViewGroup viewGroup) {
        this.j_renamed = viewGroup;
    }

    public void a_renamed() {
        this.n_renamed = false;
    }

    public void b_renamed() {
        android.animation.ObjectAnimator objectAnimator;
        android.animation.ObjectAnimator objectAnimator2;
        this.n_renamed = true;
        if (this.s_renamed && (objectAnimator2 = this.q_renamed) != null) {
            objectAnimator2.end();
            this.q_renamed = null;
        }
        if (this.t_renamed && (objectAnimator = this.r_renamed) != null) {
            objectAnimator.end();
            this.r_renamed = null;
        }
        this.j_renamed.removeView(this.o_renamed);
    }

    public void c_renamed() {
        android.os.Handler handler = this.w_renamed;
        if (handler != null) {
            handler.removeMessages(101);
            this.w_renamed = null;
        }
        this.g_renamed = null;
        this.j_renamed = null;
    }

    public void a_renamed(android.graphics.Bitmap bitmap, com.oplus.camera.ui.control.e_renamed eVar, int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.f_renamed("CameraSuperTextUI", "showSuperTextResultView start");
        this.k_renamed = bitmap;
        this.m_renamed = eVar;
        this.v_renamed = i_renamed;
        com.oplus.camera.ui.control.ThumbImageView thumbImageViewS = this.i_renamed.s_renamed();
        if (this.n_renamed || !z_renamed) {
            com.oplus.camera.e_renamed.c_renamed("CameraSuperTextUI", "showSuperTextResultView, mbPaused: " + this.n_renamed + ", needShowResult: " + z_renamed);
            a_renamed(thumbImageViewS, eVar, bitmap);
            return;
        }
        android.util.Size sizeA = this.h_renamed.a_renamed(1.3333333333333333d);
        if (sizeA == null) {
            return;
        }
        int iN = com.oplus.camera.util.Util.N_renamed() + (sizeA.getWidth() / 2);
        com.oplus.camera.e_renamed.a_renamed("CameraSuperTextUI", "showSuperTextResultView, size.width: " + sizeA.getWidth() + ", size.height: " + sizeA.getHeight() + ", topBarHeight: " + com.oplus.camera.util.Util.N_renamed() + ", bitmap.width: " + bitmap.getWidth() + ", bitmap.height: " + bitmap.getHeight());
        a_renamed(bitmap, iN);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("showSuperTextResultView, bitmapWidth: ");
        sb.append(bitmap.getWidth());
        sb.append(", bitmapHeight: ");
        sb.append(bitmap.getHeight());
        com.oplus.camera.e_renamed.f_renamed("CameraSuperTextUI", sb.toString());
        final com.a_renamed.a_renamed.f_renamed fVarB = this.p_renamed.b_renamed();
        fVarB.a_renamed(com.a_renamed.a_renamed.g_renamed.b_renamed(5.0d, 8.0d));
        fVarB.a_renamed(false);
        fVarB.a_renamed(new com.a_renamed.a_renamed.e_renamed() { // from class: com.oplus.camera.ui.b_renamed.a_renamed.2
            @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
            public void a_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                super.a_renamed(fVar);
                float fC_renamed = (float) fVar.c_renamed();
                com.oplus.camera.e_renamed.a_renamed("CameraSuperTextUI", "onSpringUpdate, currentScaleValue: " + fC_renamed);
                com.oplus.camera.ui.b_renamed.a_renamed.this.o_renamed.setAlpha(fC_renamed);
                float f_renamed = (fC_renamed * 0.38f) + 0.72f;
                com.oplus.camera.ui.b_renamed.a_renamed.this.o_renamed.setScaleX(f_renamed);
                com.oplus.camera.ui.b_renamed.a_renamed.this.o_renamed.setScaleY(f_renamed);
            }

            @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
            public void b_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                super.b_renamed(fVar);
                fVarB.a_renamed();
                if (com.oplus.camera.ui.b_renamed.a_renamed.this.w_renamed != null) {
                    com.oplus.camera.ui.b_renamed.a_renamed.this.w_renamed.sendEmptyMessageDelayed(101, 500L);
                }
            }
        });
        fVarB.b_renamed(1.0d);
    }

    private void a_renamed(android.graphics.Bitmap bitmap, int i_renamed) {
        this.l_renamed = a_renamed(bitmap);
        this.o_renamed = new com.oplus.camera.ui.widget.RoundImageView(this.g_renamed);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(this.l_renamed.getWidth(), this.l_renamed.getHeight());
        if (com.oplus.camera.util.Util.u_renamed()) {
            layoutParams.addRule(13);
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.topMargin = i_renamed - (this.l_renamed.getHeight() / 2);
            layoutParams.leftMargin = 0;
        }
        this.o_renamed.setLayoutParams(layoutParams);
        this.o_renamed.setBitmap(this.l_renamed);
        this.j_renamed.addView(this.o_renamed);
        this.o_renamed.setVisibility(0);
        this.o_renamed.setAlpha(0.0f);
    }

    private android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap) {
        int screenWidth;
        int width;
        android.util.Size sizeAx = this.h_renamed.ax_renamed();
        if (sizeAx == null) {
            com.oplus.camera.e_renamed.f_renamed("CameraSuperTextUI", "createAnimBitmap, preview size is_renamed null");
            return bitmap;
        }
        if (com.oplus.camera.util.Util.u_renamed()) {
            float width2 = sizeAx.getWidth() / sizeAx.getHeight();
            width = com.oplus.camera.util.Util.getScreenHeight();
            screenWidth = (int) (width / width2);
        } else {
            screenWidth = com.oplus.camera.util.Util.getScreenWidth();
            width = (sizeAx.getWidth() * screenWidth) / sizeAx.getHeight();
        }
        com.oplus.camera.e_renamed.b_renamed("CameraSuperTextUI", "createAnimBitmap, previewFrameWidth: " + screenWidth + ", previewFrameHeight: " + width);
        android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(screenWidth, width, android.graphics.Bitmap.Config.ARGB_8888);
        bitmapA.eraseColor(0);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapA);
        canvas.drawBitmap(bitmap, ((float) (bitmapA.getWidth() - bitmap.getWidth())) / 2.0f, ((float) (bitmapA.getHeight() - bitmap.getHeight())) / 2.0f, (android.graphics.Paint) null);
        canvas.save();
        canvas.restore();
        com.oplus.camera.e_renamed.b_renamed("CameraSuperTextUI", "createAnimBitmap, result width: " + bitmapA.getWidth() + ", height: " + bitmapA.getHeight());
        return bitmapA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.ui.control.ThumbImageView thumbImageView, com.oplus.camera.ui.control.e_renamed eVar, android.graphics.Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || thumbImageView == null) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraSuperTextUI", "updateThumbnailWithoutAnimation");
        if (!com.oplus.camera.util.Util.u_renamed()) {
            bitmap = com.oplus.camera.util.Util.b_renamed(thumbImageView.a_renamed(bitmap, false, false), this.v_renamed);
        }
        com.oplus.camera.ui.control.a_renamed aVar = this.i_renamed;
        if (aVar != null) {
            aVar.b_renamed(eVar);
            this.i_renamed.a_renamed(eVar);
            this.i_renamed.a_renamed(bitmap, 0, false);
        }
        thumbImageView.a_renamed(bitmap, 0, false, true);
        this.h_renamed.c_renamed(false);
        this.h_renamed.au_renamed();
        e_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B_renamed:39:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:41:0x01a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d_renamed() throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.b_renamed.a_renamed.d_renamed():void");
    }

    public void a_renamed(int i_renamed) {
        this.u_renamed = i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e_renamed() {
        android.graphics.Bitmap bitmap = this.k_renamed;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.k_renamed.recycle();
        }
        android.graphics.Bitmap bitmap2 = this.l_renamed;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.l_renamed.recycle();
        }
        this.k_renamed = null;
        this.l_renamed = null;
    }
}
