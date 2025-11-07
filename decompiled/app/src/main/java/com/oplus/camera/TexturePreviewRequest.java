package com.oplus.camera;

/* compiled from: QrCodeManager.java */
/* loaded from: classes2.dex */
public class aa_renamed implements android.view.View.OnClickListener {
    private com.oplus.camera.o_renamed.a_renamed.f_renamed A_renamed;
    private com.oplus.camera.util.YuvUtil B_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f4073a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.o_renamed.c_renamed f4074b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.CameraQrCodeJumpView f4075c;
    private android.app.KeyguardManager f_renamed;
    private int h_renamed;
    private com.oplus.camera.statistics.model.QrCodeDcsMsgData s_renamed;
    private com.oplus.camera.ComboPreferences u_renamed;
    private com.oplus.camera.capmode.a_renamed v_renamed;
    private int w_renamed;
    private java.util.Map<com.google.zxing.DecodeHintType, java.lang.Object> y_renamed;
    private com.google.zxing.qrcode.QRCodeReader z_renamed;
    private com.oplus.camera.ui.CameraQrCodeView d_renamed = null;
    private com.oplus.camera.o_renamed.b_renamed e_renamed = null;
    private com.oplus.camera.o_renamed.b_renamed g_renamed = null;
    private boolean i_renamed = false;
    private boolean j_renamed = true;
    private boolean k_renamed = true;
    private boolean l_renamed = false;
    private boolean m_renamed = false;
    private boolean n_renamed = false;
    private boolean o_renamed = false;
    private android.os.Handler p_renamed = null;
    private android.os.Handler q_renamed = null;
    private int r_renamed = 0;
    private java.lang.Object t_renamed = new java.lang.Object();
    private com.oplus.camera.aa_renamed.a_renamed x_renamed = null;
    private int C_renamed = -1;
    private android.os.Handler D_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.aa_renamed.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            if (i_renamed != 1) {
                if (i_renamed == 2) {
                    if (message.obj != null && com.oplus.camera.aa_renamed.this.f4075c != null && com.oplus.camera.aa_renamed.this.f4075c.getParent() != null) {
                        com.oplus.camera.aa_renamed.this.f4075c.a_renamed(((java.lang.Boolean) message.obj).booleanValue());
                    }
                    com.oplus.camera.aa_renamed.this.s_renamed();
                    return;
                }
                if (i_renamed == 4) {
                    com.oplus.camera.aa_renamed.this.s_renamed();
                    return;
                } else {
                    if (i_renamed != 5) {
                        return;
                    }
                    com.oplus.camera.aa_renamed.this.n_renamed();
                    return;
                }
            }
            if (message.obj != null && com.oplus.camera.aa_renamed.this.f4075c != null && !com.oplus.camera.aa_renamed.this.i_renamed && com.oplus.camera.aa_renamed.this.k_renamed && !com.oplus.camera.aa_renamed.this.n_renamed) {
                com.oplus.camera.aa_renamed.this.e_renamed = (com.oplus.camera.o_renamed.b_renamed) message.obj;
                if (com.oplus.camera.aa_renamed.this.g_renamed == null || !android.text.TextUtils.equals(com.oplus.camera.aa_renamed.this.g_renamed.a_renamed(), com.oplus.camera.aa_renamed.this.e_renamed.a_renamed()) || !com.oplus.camera.aa_renamed.this.m_renamed) {
                    com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "handleMessage, MSG_QR_CODE_RESULT: " + com.oplus.camera.aa_renamed.this.k_renamed);
                    com.oplus.camera.aa_renamed.this.a_renamed();
                    com.oplus.camera.aa_renamed.this.a_renamed(true);
                    com.oplus.camera.aa_renamed.this.r_renamed();
                    return;
                }
                com.oplus.camera.aa_renamed.this.c_renamed();
                return;
            }
            com.oplus.camera.aa_renamed.this.c_renamed();
        }
    };

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "clearHistory, mHistoryQrCodeScanResult: " + this.g_renamed + " ,mQrCodeScanResult: " + this.e_renamed);
        this.g_renamed = null;
        this.m_renamed = false;
    }

    public void b_renamed() {
        this.p_renamed.removeMessages(6);
        this.p_renamed.removeMessages(2);
        this.p_renamed.removeMessages(8);
        this.p_renamed.removeMessages(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n_renamed() {
        com.oplus.camera.ui.CameraQrCodeJumpView cameraQrCodeJumpView = this.f4075c;
        if (cameraQrCodeJumpView != null && cameraQrCodeJumpView.getParent() != null && this.f4075c.b_renamed()) {
            this.f4075c.clearAnimation();
            this.f4075c.setVisibility(8);
        }
        com.oplus.camera.ui.CameraQrCodeView cameraQrCodeView = this.d_renamed;
        if (cameraQrCodeView == null || !cameraQrCodeView.a_renamed()) {
            return;
        }
        this.d_renamed.clearAnimation();
        this.d_renamed.setVisibility(4);
    }

    public aa_renamed(android.app.Activity activity, com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.capmode.a_renamed aVar, int i_renamed) throws android.content.res.Resources.NotFoundException {
        this.f4073a = null;
        this.f4074b = null;
        this.f4075c = null;
        this.f_renamed = null;
        this.s_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = 255;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = null;
        this.B_renamed = null;
        this.f4073a = activity;
        this.u_renamed = comboPreferences;
        this.v_renamed = aVar;
        this.w_renamed = i_renamed;
        com.oplus.camera.ui.preview.PreviewFrameLayout previewFrameLayout = (com.oplus.camera.ui.preview.PreviewFrameLayout) this.f4073a.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout);
        int top = previewFrameLayout.getTop();
        int height = previewFrameLayout.getHeight();
        int dimensionPixelSize = this.f4073a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.pi_ultra_wide_hint_layout_margin_top);
        this.f4074b = new com.oplus.camera.o_renamed.c_renamed();
        this.h_renamed = (int) (com.oplus.camera.util.Util.getScreenWidth() * 1.3333333333333333d);
        this.f4075c = (com.oplus.camera.ui.CameraQrCodeJumpView) android.view.LayoutInflater.from(activity).inflate(com.oplus.camera.R_renamed.layout.camera_qrcode_hint_layout, (android.view.ViewGroup) null);
        this.f4075c.setId(com.oplus.camera.R_renamed.id_renamed.rl_qr_code_click);
        this.f4075c.a_renamed(dimensionPixelSize, top, height, 0);
        this.f4075c.setOnClickListener(this);
        this.f4075c.setDefaultPreviewHeight(this.h_renamed);
        this.f_renamed = (android.app.KeyguardManager) activity.getApplicationContext().getSystemService("keyguard");
        this.s_renamed = new com.oplus.camera.statistics.model.QrCodeDcsMsgData(activity);
        this.A_renamed = new com.oplus.camera.o_renamed.a_renamed.f_renamed();
        this.z_renamed = new com.google.zxing.qrcode.QRCodeReader();
        this.y_renamed = new java.util.Hashtable();
        this.y_renamed.put(com.google.zxing.DecodeHintType.CHARACTER_SET, "utf-8");
        this.y_renamed.put(com.google.zxing.DecodeHintType.TRY_HARDER, java.lang.Boolean.TRUE);
        this.y_renamed.put(com.google.zxing.DecodeHintType.POSSIBLE_FORMATS, com.google.zxing.BarcodeFormat.QR_CODE);
        if (this.B_renamed == null) {
            this.B_renamed = new com.oplus.camera.util.YuvUtil();
        }
        o_renamed();
        if (q_renamed().getPackageManager() == null) {
            com.oplus.camera.e_renamed.f_renamed("QrCodeManager", "QrCodeManager, mbIsWifiQrcodeShare, cannot get packageManager!");
        }
    }

    private void o_renamed() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("CameraQrCode");
        handlerThread.start();
        android.os.HandlerThread handlerThread2 = new android.os.HandlerThread("CameraQrCodeJump");
        handlerThread2.start();
        this.q_renamed = new android.os.Handler(handlerThread2.getLooper());
        this.p_renamed = new android.os.Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.aa_renamed.2
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                int i_renamed = message.what;
                if (i_renamed == 3) {
                    if (message.obj == null || com.oplus.camera.aa_renamed.this.i_renamed || !com.oplus.camera.aa_renamed.this.k_renamed) {
                        return;
                    }
                    com.oplus.camera.o_renamed.a_renamed aVar = (com.oplus.camera.o_renamed.a_renamed) message.obj;
                    com.oplus.camera.o_renamed.b_renamed bVarA = com.oplus.camera.aa_renamed.this.a_renamed(aVar.a_renamed(), aVar.b_renamed(), aVar.c_renamed());
                    if (bVarA == null || bVarA.d_renamed() == null || com.oplus.camera.aa_renamed.this.D_renamed == null || com.oplus.camera.aa_renamed.this.i_renamed) {
                        com.oplus.camera.aa_renamed.this.p_renamed();
                    } else {
                        com.oplus.camera.aa_renamed.this.a_renamed(bVarA);
                        return;
                    }
                }
                switch (i_renamed) {
                    case 6:
                        com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "handleMessage, MSG_QR_CODE_CHECK_LEAVE");
                        com.oplus.camera.aa_renamed.this.p_renamed.removeMessages(8);
                        com.oplus.camera.aa_renamed.this.m_renamed();
                        break;
                    case 7:
                        com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "handleMessage, MSG_QR_CODE_JUMP_DELAY");
                        com.oplus.camera.aa_renamed.this.m_renamed();
                        com.oplus.camera.aa_renamed.this.n_renamed = false;
                        break;
                    case 8:
                        com.oplus.camera.aa_renamed.this.d_renamed(true);
                        if (com.oplus.camera.aa_renamed.this.h_renamed()) {
                            com.oplus.camera.aa_renamed.this.b_renamed(true);
                            break;
                        }
                        break;
                    case 9:
                        com.oplus.camera.aa_renamed.this.e_renamed(true);
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p_renamed() {
        this.D_renamed.removeMessages(4);
        this.D_renamed.sendEmptyMessage(4);
        if (this.m_renamed && !this.p_renamed.hasMessages(6)) {
            com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "qrCodeEmpty, MSG_QR_CODE_CHECK_LEAVE");
            android.os.Handler handler = this.p_renamed;
            handler.sendMessageDelayed(handler.obtainMessage(6), 1000L);
        }
        if (this.m_renamed || this.p_renamed.hasMessages(9)) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "qrCodeEmpty, QR_CODE_MAX_DETECTION_TIME");
        android.os.Handler handler2 = this.p_renamed;
        handler2.sendMessageDelayed(handler2.obtainMessage(9), 15000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.o_renamed.b_renamed bVar) {
        this.p_renamed.removeMessages(6);
        this.p_renamed.removeMessages(9);
        com.oplus.camera.o_renamed.b_renamed bVar2 = this.e_renamed;
        if (bVar2 == null || !android.text.TextUtils.equals(bVar2.a_renamed(), bVar.a_renamed()) || !this.p_renamed.hasMessages(8)) {
            this.p_renamed.removeMessages(8);
            android.os.Handler handler = this.p_renamed;
            handler.sendMessageDelayed(handler.obtainMessage(8), 10000L);
        }
        this.D_renamed.removeMessages(1);
        this.D_renamed.removeMessages(4);
        this.D_renamed.obtainMessage(1, bVar).sendToTarget();
    }

    public void a_renamed(byte[] bArr, android.graphics.Rect rect, android.util.Size size, int i_renamed, int i2) {
        if (this.i_renamed || !this.k_renamed || this.l_renamed) {
            return;
        }
        l_renamed();
        int i3 = (int) (i_renamed / (i2 / 720.0f));
        byte[] bArrA = this.B_renamed.a_renamed(bArr, i_renamed, i2, i3, com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT);
        this.p_renamed.removeMessages(3);
        this.p_renamed.obtainMessage(3, new com.oplus.camera.o_renamed.a_renamed(bArrA, rect, size, i3, com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT)).sendToTarget();
    }

    private com.oplus.camera.o_renamed.b_renamed a_renamed(com.google.zxing.Result result, int i_renamed, int i2) {
        if (result == null || android.text.TextUtils.isEmpty(result.getText()) || q_renamed() == null) {
            com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "innerConvertResult, result is_renamed null");
            return null;
        }
        com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "innerConvertResult, result: " + result.getText());
        android.graphics.RectF rectFA = a_renamed(result.getResultPoints());
        if (rectFA == null) {
            return null;
        }
        if (this.f4074b.a_renamed(result.getText())) {
            return new com.oplus.camera.o_renamed.b_renamed(result.getText(), com.oplus.camera.o_renamed.b_renamed.a_renamed.WIFI, null, rectFA, i_renamed, i2);
        }
        return new com.oplus.camera.o_renamed.b_renamed(result.getText(), com.oplus.camera.o_renamed.b_renamed.a_renamed.NONE, null, rectFA, i_renamed, i2);
    }

    private android.graphics.RectF a_renamed(com.google.zxing.ResultPoint[] resultPointArr) {
        if (4 != resultPointArr.length) {
            return null;
        }
        android.graphics.RectF rectF = new android.graphics.RectF();
        float x_renamed = (resultPointArr[0].getX() + resultPointArr[2].getX()) / 2.0f;
        float y_renamed = (resultPointArr[0].getY() + resultPointArr[2].getY()) / 2.0f;
        float fSqrt = ((float) java.lang.Math.sqrt(java.lang.Math.pow(resultPointArr[0].getX() - resultPointArr[2].getX(), 2.0d) + java.lang.Math.pow(resultPointArr[0].getY() - resultPointArr[2].getY(), 2.0d))) / 2.0f;
        rectF.left = x_renamed - fSqrt;
        rectF.top = y_renamed - fSqrt;
        rectF.right = x_renamed + fSqrt;
        rectF.bottom = y_renamed + fSqrt;
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.oplus.camera.o_renamed.b_renamed a_renamed(byte[] bArr, int i_renamed, int i2) {
        com.google.zxing.Result resultA;
        com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "decode, width: " + i_renamed + ", height: " + i2);
        com.google.zxing.Result resultA2 = a_renamed(bArr, i_renamed, i2, this.C_renamed);
        if (resultA2 == null) {
            this.C_renamed = -1;
            int iNextInt = new java.util.Random().nextInt(this.A_renamed.a_renamed());
            resultA = a_renamed(bArr, i_renamed, i2, iNextInt);
            if (resultA != null) {
                this.C_renamed = iNextInt;
            } else {
                this.C_renamed = -1;
            }
        } else {
            resultA = resultA2;
        }
        return a_renamed(resultA, i_renamed, i2);
    }

    public com.google.zxing.Result a_renamed(byte[] bArr, int i_renamed, int i2, int i3) {
        com.google.zxing.PlanarYUVLuminanceSource planarYUVLuminanceSource = new com.google.zxing.PlanarYUVLuminanceSource(bArr, i_renamed, i2, 0, 0, i_renamed, i2, false);
        if (-1 != i3) {
            this.A_renamed.a_renamed(i3).a_renamed(planarYUVLuminanceSource.getMatrix(), planarYUVLuminanceSource.getWidth(), planarYUVLuminanceSource.getHeight());
        }
        try {
            try {
                return this.z_renamed.decode(new com.google.zxing.BinaryBitmap(new com.google.zxing.common.HybridBinarizer(planarYUVLuminanceSource)), this.y_renamed);
            } catch (com.google.zxing.ChecksumException e_renamed) {
                e_renamed.printStackTrace();
                this.z_renamed.reset();
                return null;
            } catch (com.google.zxing.FormatException e2) {
                e2.printStackTrace();
                this.z_renamed.reset();
                return null;
            } catch (com.google.zxing.NotFoundException e3) {
                e3.printStackTrace();
                this.z_renamed.reset();
                return null;
            }
        } finally {
            this.z_renamed.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(com.oplus.camera.o_renamed.b_renamed bVar) {
        if (this.f4073a == null || this.i_renamed) {
            com.oplus.camera.e_renamed.b_renamed("QrCodeManager", "handleCodeResult activity is_renamed destroyed");
            return;
        }
        if (bVar.g_renamed()) {
            return;
        }
        com.oplus.camera.o_renamed.b_renamed.a_renamed aVarC = bVar.c_renamed();
        java.lang.String strA = bVar.a_renamed();
        if (aVarC == com.oplus.camera.o_renamed.b_renamed.a_renamed.NONE) {
            a_renamed(strA);
            return;
        }
        if (aVarC == com.oplus.camera.o_renamed.b_renamed.a_renamed.WIFI) {
            android.content.Intent intent = new android.content.Intent("wireless.settings.WLAN_CONNECT");
            intent.setPackage("com.oplus.wirelesssettings");
            intent.putExtra("rawResult", strA);
            try {
                this.f4073a.startActivity(intent);
                a_renamed(3, true);
                return;
            } catch (java.lang.Exception e_renamed) {
                com.oplus.camera.e_renamed.f_renamed("QrCodeManager", "handleCodeResult, innerHandleCodeResult e_renamed: " + e_renamed);
                a_renamed(strA);
                return;
            }
        }
        a_renamed(strA);
    }

    private void a_renamed(int i_renamed, boolean z_renamed) {
        synchronized (this.t_renamed) {
            if (this.s_renamed != null) {
                this.s_renamed.buildEventId(z_renamed);
                a_renamed(this.s_renamed);
                if (z_renamed) {
                    this.s_renamed.mProtocol = i_renamed;
                }
                this.s_renamed.report();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:37:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a_renamed(java.lang.String r8) {
        /*
            r7 = this;
            android.app.Activity r0 = r7.f4073a
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            java.util.regex.Pattern r0 = android.util.Patterns.WEB_URL
            java.util.regex.Matcher r0 = r0.matcher(r8)
            boolean r0 = r0.matches()
            java.lang.String r2 = "searchCode e_renamed: "
            java.lang.String r3 = "QrCodeManager"
            r4 = 1
            if (r0 != 0) goto L20
            boolean r0 = android.webkit.URLUtil.isValidUrl(r8)
            if (r0 == 0) goto L1e
            goto L20
        L1e:
            r5 = r1
            goto L52
        L20:
            java.lang.String r0 = com.oplus.camera.util.Util.g_renamed(r8)
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r6 = "android.intent.action.VIEW"
            r5.<init>(r6, r0)
            android.app.Activity r0 = r7.f4073a     // Catch: java.lang.Exception -> L3c
            r0.startActivity(r5)     // Catch: java.lang.Exception -> L3c
            r7.a_renamed(r4, r4)     // Catch: java.lang.Exception -> L39
            r5 = r4
            goto L52
        L39:
            r0 = move-exception
            r5 = r4
            goto L3e
        L3c:
            r0 = move-exception
            r5 = r1
        L3e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.oplus.camera.e_renamed.f_renamed(r3, r0)
            r7.n_renamed = r1
        L52:
            if (r5 != 0) goto La9
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r6 = "android.intent.action.WEB_SEARCH"
            r0.<init>(r6)
            java.lang.String r6 = "query"
            r0.putExtra(r6, r8)
            android.content.Context r8 = r7.q_renamed()
            java.lang.String r6 = "com.heytap.browser"
            boolean r8 = com.oplus.camera.util.Util.d_renamed(r8, r6)
            if (r8 == 0) goto L70
            r0.setPackage(r6)
            goto L81
        L70:
            android.content.Context r8 = r7.q_renamed()
            java.lang.String r6 = "com.android.chrome"
            boolean r8 = com.oplus.camera.util.Util.d_renamed(r8, r6)
            if (r8 != 0) goto L81
            java.lang.String r8 = "com.android.browser"
            r0.setPackage(r8)
        L81:
            r8 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r8)
            android.app.Activity r8 = r7.f4073a     // Catch: java.lang.Exception -> L92
            r8.startActivity(r0)     // Catch: java.lang.Exception -> L92
            r8 = 4
            r7.a_renamed(r8, r4)     // Catch: java.lang.Exception -> L90
            goto Laa
        L90:
            r8 = move-exception
            goto L94
        L92:
            r8 = move-exception
            r4 = r5
        L94:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            com.oplus.camera.e_renamed.f_renamed(r3, r8)
            r7.n_renamed = r1
            goto Laa
        La9:
            r4 = r5
        Laa:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.aa_renamed.a_renamed(java.lang.String):boolean");
    }

    private android.content.Context q_renamed() {
        android.app.Activity activity = this.f4073a;
        if (activity != null) {
            return activity.getApplicationContext();
        }
        return null;
    }

    public void a_renamed(android.view.ViewGroup viewGroup) throws android.content.res.Resources.NotFoundException {
        if (viewGroup == null || this.f4075c == null) {
            return;
        }
        com.oplus.camera.ui.preview.PreviewFrameLayout previewFrameLayout = (com.oplus.camera.ui.preview.PreviewFrameLayout) this.f4073a.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout);
        this.d_renamed = (com.oplus.camera.ui.CameraQrCodeView) previewFrameLayout.findViewById(com.oplus.camera.R_renamed.id_renamed.qrcode_view);
        if (this.d_renamed == null) {
            this.d_renamed = (com.oplus.camera.ui.CameraQrCodeView) this.f4073a.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.view_stub_qrcode_view, previewFrameLayout).findViewById(com.oplus.camera.R_renamed.id_renamed.qrcode_view);
        }
        viewGroup.removeView(this.f4075c);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, q_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.ai_notice_view_height));
        layoutParams.addRule(14);
        layoutParams.addRule(2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout);
        int top = previewFrameLayout.getTop();
        int height = previewFrameLayout.getHeight();
        int dimensionPixelSize = this.f4073a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.pi_ultra_wide_hint_layout_margin_top);
        layoutParams.bottomMargin = this.f4073a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.qr_code_vertical_margin_bottom);
        viewGroup.addView(this.f4075c, layoutParams);
        this.f4075c.a_renamed(dimensionPixelSize, top, height, 0);
        this.f4075c.setVisibility(8);
        this.f4075c.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_qr_code_hint_next).setRotation(this.f4075c.getLayoutDirection() == 1 ? 180.0f : 0.0f);
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.ui.CameraQrCodeJumpView cameraQrCodeJumpView = this.f4075c;
        if (cameraQrCodeJumpView == null || this.f4073a == null || this.e_renamed == null || this.i_renamed || cameraQrCodeJumpView.getParent() == null) {
            return;
        }
        this.f4075c.setOrientation(this.r_renamed);
        if (this.f4075c.b_renamed()) {
            this.f4075c.a_renamed();
        } else {
            this.f4075c.a_renamed(true, z_renamed);
            a_renamed(0, false);
        }
    }

    public void b_renamed(boolean z_renamed) {
        if (this.f4075c == null || this.f4073a == null || this.e_renamed == null || !i_renamed()) {
            android.os.Handler handler = this.D_renamed;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (this.D_renamed != null) {
                this.p_renamed.removeCallbacksAndMessages(null);
                return;
            }
            return;
        }
        this.D_renamed.removeMessages(2);
        this.D_renamed.removeMessages(1);
        this.p_renamed.removeMessages(3);
        this.D_renamed.obtainMessage(2, java.lang.Boolean.valueOf(z_renamed)).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r_renamed() {
        com.oplus.camera.ui.CameraQrCodeView cameraQrCodeView = this.d_renamed;
        if (cameraQrCodeView != null && this.j_renamed) {
            cameraQrCodeView.a_renamed(this.e_renamed.d_renamed(), this.e_renamed.e_renamed(), this.e_renamed.f_renamed());
            return;
        }
        com.oplus.camera.ui.CameraQrCodeView cameraQrCodeView2 = this.d_renamed;
        if (cameraQrCodeView2 != null) {
            cameraQrCodeView2.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s_renamed() {
        com.oplus.camera.ui.CameraQrCodeView cameraQrCodeView = this.d_renamed;
        if (cameraQrCodeView == null || this.i_renamed) {
            return;
        }
        cameraQrCodeView.a_renamed(true);
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "clearQrCodeView, canScanQrCode: " + this.k_renamed + ", mbPause: " + this.i_renamed + ", isMainThread: " + d_renamed());
        if (this.i_renamed || !h_renamed()) {
            return;
        }
        if (!d_renamed()) {
            this.D_renamed.removeCallbacksAndMessages(null);
            this.p_renamed.removeCallbacksAndMessages(null);
            this.D_renamed.sendEmptyMessage(5);
            return;
        }
        n_renamed();
    }

    public boolean d_renamed() {
        return android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread();
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "setOrientation: " + i_renamed);
        this.r_renamed = i_renamed;
        if (h_renamed()) {
            this.f4075c.setOrientation(this.r_renamed);
        }
    }

    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "onResume");
        this.i_renamed = false;
        this.o_renamed = false;
        com.oplus.camera.ui.CameraQrCodeJumpView cameraQrCodeJumpView = this.f4075c;
        if (cameraQrCodeJumpView != null) {
            cameraQrCodeJumpView.d_renamed();
        }
        com.oplus.camera.ui.CameraQrCodeView cameraQrCodeView = this.d_renamed;
        if (cameraQrCodeView != null) {
            cameraQrCodeView.c_renamed();
        }
        if (this.n_renamed) {
            this.p_renamed.removeMessages(7);
            android.os.Handler handler = this.p_renamed;
            handler.sendMessageDelayed(handler.obtainMessage(7), com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        } else {
            a_renamed();
        }
        c_renamed(true);
    }

    public void f_renamed() {
        com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "onPause");
        this.i_renamed = true;
        this.o_renamed = false;
        com.oplus.camera.ui.CameraQrCodeJumpView cameraQrCodeJumpView = this.f4075c;
        if (cameraQrCodeJumpView != null) {
            cameraQrCodeJumpView.c_renamed();
        }
        com.oplus.camera.ui.CameraQrCodeView cameraQrCodeView = this.d_renamed;
        if (cameraQrCodeView != null) {
            cameraQrCodeView.b_renamed();
        }
        com.oplus.camera.aa_renamed.a_renamed aVar = this.x_renamed;
        if (aVar != null) {
            aVar.a_renamed(true);
        }
        c_renamed(false);
        this.D_renamed.removeCallbacksAndMessages(null);
        this.p_renamed.removeCallbacksAndMessages(null);
        this.q_renamed.removeCallbacksAndMessages(null);
        this.r_renamed = 0;
        this.C_renamed = -1;
        n_renamed();
    }

    public void g_renamed() {
        com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "onDestroy");
        com.oplus.camera.aa_renamed.a_renamed aVar = this.x_renamed;
        if (aVar != null) {
            aVar.a_renamed(true);
        }
        this.D_renamed.removeCallbacksAndMessages(null);
        this.p_renamed.removeCallbacksAndMessages(null);
        this.q_renamed.removeCallbacksAndMessages(null);
        this.f4073a = null;
        this.f_renamed = null;
        synchronized (this.t_renamed) {
            this.v_renamed = null;
            this.u_renamed = null;
            this.s_renamed = null;
        }
        try {
            this.p_renamed.getLooper().quitSafely();
            this.p_renamed = null;
            this.q_renamed.getLooper().quitSafely();
            this.q_renamed = null;
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("QrCodeManager", "onDestroy, quit handler: " + e_renamed.toString());
        }
    }

    public void c_renamed(boolean z_renamed) {
        this.k_renamed = z_renamed;
        if (this.k_renamed) {
            return;
        }
        c_renamed();
    }

    public boolean h_renamed() {
        com.oplus.camera.ui.CameraQrCodeJumpView cameraQrCodeJumpView;
        com.oplus.camera.ui.CameraQrCodeView cameraQrCodeView = this.d_renamed;
        return (cameraQrCodeView != null && cameraQrCodeView.a_renamed()) || ((cameraQrCodeJumpView = this.f4075c) != null && cameraQrCodeJumpView.b_renamed());
    }

    public boolean i_renamed() {
        com.oplus.camera.ui.CameraQrCodeJumpView cameraQrCodeJumpView;
        com.oplus.camera.ui.CameraQrCodeView cameraQrCodeView = this.d_renamed;
        return cameraQrCodeView != null && cameraQrCodeView.a_renamed() && (cameraQrCodeJumpView = this.f4075c) != null && cameraQrCodeJumpView.b_renamed();
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.ui.CameraQrCodeJumpView cameraQrCodeJumpView = this.f4075c;
        if (cameraQrCodeJumpView != null && cameraQrCodeJumpView.b_renamed() && a_renamed(this.f4075c, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "needTouchEvent, QrCode is_renamed show and dispatchTouchEvent");
            if (1 == motionEvent.getAction()) {
                c_renamed();
            }
            return true;
        }
        if (motionEvent.getAction() == 0) {
            com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "needTouchEvent, isShowQrCodeView: " + h_renamed());
        }
        if (h_renamed() && motionEvent.getAction() == 0) {
            this.n_renamed = false;
            b_renamed();
            d_renamed(true);
            c_renamed();
        }
        return false;
    }

    private boolean a_renamed(android.view.View view, int i_renamed, int i2) {
        int measuredWidth;
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight2 = iArr[0];
        int measuredWidth2 = iArr[1];
        int i3 = this.r_renamed;
        if (270 == i3) {
            measuredHeight2 -= view.getMeasuredHeight();
            measuredWidth = view.getMeasuredHeight() + measuredHeight2;
            measuredHeight = view.getMeasuredWidth();
        } else if (90 == i3) {
            measuredWidth2 -= view.getMeasuredWidth();
            measuredWidth = view.getMeasuredHeight() + measuredHeight2;
            measuredHeight = view.getMeasuredWidth();
        } else {
            measuredWidth = view.getMeasuredWidth() + measuredHeight2;
            measuredHeight = view.getMeasuredHeight();
        }
        return i2 >= measuredWidth2 && i2 <= measuredHeight + measuredWidth2 && i_renamed >= measuredHeight2 && i_renamed <= measuredWidth;
    }

    public void d_renamed(boolean z_renamed) {
        this.m_renamed = z_renamed;
        if (this.m_renamed) {
            this.g_renamed = this.e_renamed;
        }
    }

    public void e_renamed(boolean z_renamed) {
        this.l_renamed = z_renamed;
    }

    public boolean j_renamed() {
        return this.l_renamed;
    }

    public void k_renamed() {
        com.oplus.camera.ui.CameraQrCodeJumpView cameraQrCodeJumpView = this.f4075c;
        if (cameraQrCodeJumpView != null) {
            cameraQrCodeJumpView.e_renamed();
        }
    }

    private void t_renamed() {
        com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "requestKeyguard");
        this.o_renamed = true;
        try {
            new android.view.OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
        } catch (android.os.RemoteException e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("QrCodeManager", "requestKeyguard: " + e_renamed.toString());
        } catch (java.lang.NoSuchMethodError e2) {
            com.oplus.camera.e_renamed.f_renamed("QrCodeManager", "requestKeyguard: " + e2.toString());
        }
    }

    private boolean u_renamed() {
        android.app.KeyguardManager keyguardManager;
        return (this.f4073a == null || (keyguardManager = this.f_renamed) == null || !keyguardManager.isDeviceLocked()) ? false : true;
    }

    public void l_renamed() {
        if (!this.o_renamed || u_renamed()) {
            return;
        }
        this.o_renamed = false;
        v_renamed();
    }

    private void a_renamed(com.oplus.camera.statistics.model.QrCodeDcsMsgData qrCodeDcsMsgData) {
        if (qrCodeDcsMsgData == null) {
            return;
        }
        com.oplus.camera.capmode.a_renamed aVar = this.v_renamed;
        if (aVar != null) {
            if (aVar.b_renamed() != null) {
                qrCodeDcsMsgData.mCameraEnterType = java.lang.String.valueOf(this.v_renamed.b_renamed().J_renamed());
            }
            qrCodeDcsMsgData.mCameraId = this.v_renamed.aw_renamed();
        }
        com.oplus.camera.ComboPreferences comboPreferences = this.u_renamed;
        if (comboPreferences != null) {
            qrCodeDcsMsgData.mCaptureMode = comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, "");
        }
        qrCodeDcsMsgData.mOrientation = this.r_renamed;
        qrCodeDcsMsgData.mScreenBrightness = android.provider.Settings.System.getInt(this.f4073a.getContentResolver(), com.oplus.camera.statistics.CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (this.w_renamed * 0.4f));
    }

    public void a_renamed(android.view.ViewGroup viewGroup, int i_renamed) {
        a_renamed(viewGroup);
        a_renamed(i_renamed);
    }

    public void m_renamed() {
        this.p_renamed.removeMessages(8);
        a_renamed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        this.n_renamed = true;
        if (u_renamed()) {
            t_renamed();
        } else {
            v_renamed();
        }
    }

    private void v_renamed() {
        if (this.e_renamed == null || this.q_renamed == null) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("QrCodeManager", "jump, QR code jump");
        com.oplus.camera.aa_renamed.a_renamed aVar = this.x_renamed;
        if (aVar != null) {
            this.q_renamed.removeCallbacks(aVar);
            this.x_renamed.a_renamed(true);
        }
        this.x_renamed = new com.oplus.camera.aa_renamed.a_renamed();
        this.x_renamed.a_renamed(this.e_renamed);
        this.q_renamed.post(this.x_renamed);
        d_renamed(true);
        c_renamed();
    }

    /* compiled from: QrCodeManager.java */
    private class a_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        com.oplus.camera.o_renamed.b_renamed f4078a;

        private a_renamed() {
            this.f4078a = null;
        }

        public void a_renamed(com.oplus.camera.o_renamed.b_renamed bVar) {
            this.f4078a = new com.oplus.camera.o_renamed.b_renamed(bVar.a_renamed(), bVar.c_renamed(), bVar.b_renamed(), bVar.d_renamed(), bVar.e_renamed(), bVar.f_renamed());
        }

        public void a_renamed(boolean z_renamed) {
            com.oplus.camera.o_renamed.b_renamed bVar = this.f4078a;
            if (bVar != null) {
                bVar.a_renamed(z_renamed);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.oplus.camera.o_renamed.b_renamed bVar = this.f4078a;
            if (bVar != null) {
                com.oplus.camera.aa_renamed.this.b_renamed(bVar);
                this.f4078a = null;
            }
        }
    }
}
