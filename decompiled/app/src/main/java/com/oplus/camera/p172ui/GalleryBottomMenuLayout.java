package com.oplus.camera.p172ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Size;
import android.view.OplusWindowManager;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Camera;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.p154m.ImageSaverThread;
import com.oplus.camera.p172ui.inverse.InverseLinearLayout;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.util.Util;
import com.oplus.p125c.p126a.p130b.MediaItem.kt;

/* compiled from: GalleryBottomMenuLayout.java */
/* renamed from: com.oplus.camera.ui.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class GalleryBottomMenuLayout extends InverseLinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f18757a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f18758b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Context f18759c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ImageButton f18760d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ImageButton f18761e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ImageButton f18762f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PathInterpolator f18763g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private AnimatorSet f18764h;

    /* renamed from: OplusGLSurfaceView_13 */
    private AnimatorSet f18765i;

    /* renamed from: OplusGLSurfaceView_15 */
    private CameraUIListener f18766j;

    /* renamed from: OplusGLSurfaceView_5 */
    private COUIAlertDialog f18767k;

    /* renamed from: OplusGLSurfaceView_14 */
    private ComboPreferences f18768l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Camera f18769m;

    /* renamed from: OplusGLSurfaceView_11 */
    private GalleryPreviewAdapter f18770n;

    /* renamed from: o */
    private String f18771o;

    public GalleryBottomMenuLayout(Context context) {
        super(context);
        this.f18757a = 0;
        this.f18758b = 0;
        this.f18759c = null;
        this.f18760d = null;
        this.f18761e = null;
        this.f18762f = null;
        this.f18763g = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f18764h = null;
        this.f18765i = null;
        this.f18766j = null;
        this.f18767k = null;
        this.f18768l = null;
        this.f18769m = null;
        this.f18770n = null;
        this.f18771o = "";
        this.f18759c = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20183a(CameraUIListener cameraUIListener, ComboPreferences comboPreferences, Activity activity, GalleryPreviewAdapter c3230k) {
        CameraLog.m12954a("GalleryBottomMenuLayout", "initGalleryBottomMenu");
        this.f18766j = cameraUIListener;
        this.f18768l = comboPreferences;
        this.f18769m = (Camera) activity;
        this.f18771o = this.f18769m.getPackageName();
        this.f18770n = c3230k;
        this.f18757a = getResources().getDimensionPixelSize(R.dimen.gallery_bottom_share_menu_width);
        this.f18758b = getResources().getDimensionPixelSize(R.dimen.gallery_bottom_menu_bar_height);
        this.f18762f = new ImageButton(this.f18759c);
        this.f18762f.setImageDrawable(getResources().getDrawable(R.drawable.ic_share_gallery_bottom_menu_fold, null));
        this.f18762f.setBackgroundResource(R.drawable.gallery_bottom_toolbar_menu_bg);
        this.f18762f.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.-$$Lambda$OplusGLSurfaceView_15$qzgT2McSJNVfFmhctzgAHR1jR9A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m20170c(view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f18757a, this.f18758b);
        layoutParams.gravity = 17;
        layoutParams.topMargin = 0;
        layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.gallery_bottom_share_menu_left_margin));
        addView(this.f18762f, layoutParams);
        this.f18761e = new ImageButton(this.f18759c);
        this.f18761e.setImageDrawable(getResources().getDrawable(R.drawable.ic_edit_gallery_bottom_menu_fold, null));
        this.f18761e.setBackgroundResource(R.drawable.gallery_bottom_toolbar_menu_bg);
        this.f18761e.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.-$$Lambda$OplusGLSurfaceView_15$D96y8EcUnV4L2vkBoBYWYhBsp2o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m20167b(view);
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.f18757a, this.f18758b);
        layoutParams2.gravity = 17;
        layoutParams2.setMarginStart(getResources().getDimensionPixelSize(R.dimen.gallery_bottom_edit_menu_left_margin));
        addView(this.f18761e, layoutParams2);
        this.f18760d = new ImageButton(this.f18759c);
        this.f18760d.setImageDrawable(getResources().getDrawable(R.drawable.ic_delete_gallery_bottom_menu_fold, null));
        this.f18760d.setBackgroundResource(R.drawable.gallery_bottom_toolbar_menu_bg);
        this.f18760d.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.-$$Lambda$OplusGLSurfaceView_15$UU0oNqlyvYX0dAlvUck3N9_Fzc0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m20162a(view);
            }
        });
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.f18757a, this.f18758b);
        layoutParams3.gravity = 17;
        layoutParams3.setMarginStart(getResources().getDimensionPixelSize(R.dimen.gallery_bottom_delete_menu_left_margin));
        addView(this.f18760d, layoutParams3);
        m20180a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m20170c(View view) {
        m20174e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m20167b(View view) {
        m20175f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m20162a(View view) {
        Camera camera = this.f18769m;
        if (camera != null) {
            m20161a((Activity) camera);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m20173d() {
        AnimatorSet animatorSet = this.f18765i;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f18765i.cancel();
        }
        ImageButton imageButton = this.f18761e;
        if (imageButton == null || imageButton.isShown()) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f18761e, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.f18763g);
        objectAnimatorOfFloat.setDuration(250L);
        this.f18764h = new AnimatorSet();
        this.f18764h.play(objectAnimatorOfFloat);
        this.f18764h.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_15.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (GalleryBottomMenuLayout.this.f18761e != null) {
                    GalleryBottomMenuLayout.this.f18761e.setVisibility(0);
                    GalleryBottomMenuLayout.this.m20169b(false);
                }
            }
        });
        this.f18764h.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20164a(boolean z) {
        AnimatorSet animatorSet = this.f18764h;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f18764h.cancel();
        }
        ImageButton imageButton = this.f18761e;
        if (imageButton == null || !imageButton.isShown()) {
            return;
        }
        if (z) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f18761e, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.f18763g);
            objectAnimatorOfFloat.setDuration(250L);
            this.f18765i = new AnimatorSet();
            this.f18765i.play(objectAnimatorOfFloat);
            this.f18765i.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_15.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (GalleryBottomMenuLayout.this.f18761e != null) {
                        GalleryBottomMenuLayout.this.f18761e.setTranslationY(0.0f);
                        GalleryBottomMenuLayout.this.f18761e.setTranslationX(0.0f);
                        GalleryBottomMenuLayout.this.f18761e.setAlpha(1.0f);
                        GalleryBottomMenuLayout.this.f18761e.setVisibility(0);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GalleryBottomMenuLayout.this.f18761e != null) {
                        GalleryBottomMenuLayout.this.f18761e.setVisibility(8);
                        GalleryBottomMenuLayout.this.f18761e.setTranslationY(0.0f);
                        GalleryBottomMenuLayout.this.f18761e.setTranslationX(0.0f);
                        GalleryBottomMenuLayout.this.f18761e.setAlpha(0.0f);
                        GalleryBottomMenuLayout.this.m20169b(true);
                    }
                }
            });
            this.f18765i.start();
            return;
        }
        this.f18761e.setAlpha(0.0f);
        this.f18761e.setVisibility(8);
        m20169b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20169b(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f18757a, this.f18758b);
        layoutParams.gravity = 17;
        if (z) {
            layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.gallery_bottom_delete_menu_left_margin_hide_edit));
        } else {
            layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.gallery_bottom_delete_menu_left_margin));
        }
        this.f18760d.setLayoutParams(layoutParams);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m20174e() {
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_15.3
            @Override // java.lang.Runnable
            public void run() {
                GalleryBottomMenuLayout.this.m20176g();
            }
        }, "share");
        ComboPreferences comboPreferences = this.f18768l;
        if (comboPreferences != null) {
            comboPreferences.edit().putBoolean(CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, false).apply();
        }
        m20185b(46);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m20175f() {
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_15.4
            @Override // java.lang.Runnable
            public void run() {
                GalleryBottomMenuLayout.this.m20179j();
            }
        }, "mark");
        ComboPreferences comboPreferences = this.f18768l;
        if (comboPreferences != null) {
            comboPreferences.edit().putBoolean(CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, false).apply();
        }
        m20185b(47);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m20176g() {
        GalleryPreviewAdapter c3230k = this.f18770n;
        MediaItem.kt c2436aM20255e = c3230k != null ? c3230k.m20255e() : null;
        if (c2436aM20255e == null || this.f18769m == null) {
            return;
        }
        Uri uriM9434g = c2436aM20255e.m9434g();
        if (m20166a(uriM9434g, Util.m24289a(uriM9434g))) {
            Intent intent = new Intent("android.intent.action.SEND");
            String strM9431d = c2436aM20255e.m9431d();
            if (strM9431d == null) {
                strM9431d = m20160a(c2436aM20255e.m9433f());
            }
            if (strM9431d == null) {
                strM9431d = Util.m24289a(uriM9434g) ? "image/*" : "video/*";
            }
            intent.setType(strM9431d);
            intent.putExtra("android.intent.extra.STREAM", uriM9434g);
            if (m20186b()) {
                intent.setFlags(268468224);
            }
            m20177h();
            try {
                this.f18769m.startActivity(Intent.createChooser(intent, null));
                this.f18769m.overridePendingTransition(0, 0);
            } catch (Throwable th) {
                CameraLog.m12967f("GalleryBottomMenuLayout", "jumpSystemShare: " + th);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m20177h() {
        if (m20186b()) {
            try {
                new OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                CameraLog.m12967f("GalleryBottomMenuLayout", "OplusWindowManager exception:" + COUIBaseListPopupWindow_8.toString());
            } catch (Exception e2) {
                CameraLog.m12965d("GalleryBottomMenuLayout", "OplusWindowManager error:", e2);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m20166a(Uri uri, boolean z) throws Throwable {
        Camera camera;
        if (uri != null && (camera = this.f18769m) != null) {
            boolean zM24290a = Util.m24290a(uri, camera.getContentResolver());
            if (!m20178i() && zM24290a) {
                return !z || m20165a(uri);
            }
            CameraLog.m12966e("GalleryBottomMenuLayout", "onThumbNailClick, imageCaptureListIsEmpty: " + ImageSaverThread.m14696a().m14714j() + ", imageSaveListIsEmpty: " + ImageSaverThread.m14696a().m14711g() + ", isUriValid: " + zM24290a);
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m20160a(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\.")) == null || 1 > strArrSplit.length) {
            return null;
        }
        String str2 = strArrSplit[strArrSplit.length - 1];
        if (CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG.equalsIgnoreCase(str2) || "jpg".equalsIgnoreCase(str2)) {
            return "image/jpeg";
        }
        if ("raw".equalsIgnoreCase(str2) || "dng".equalsIgnoreCase(str2)) {
            return "image/x-adobe-dng";
        }
        if ("heic_8bits".equalsIgnoreCase(str2) || "heic_10bits".equalsIgnoreCase(str2) || "heic".equalsIgnoreCase(str2)) {
            return "image/heic";
        }
        if ("mp4".equalsIgnoreCase(str2)) {
            return MimeTypes.VIDEO_MP4;
        }
        if ("3gp".equalsIgnoreCase(str2)) {
            return "video/3gp";
        }
        return null;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean m20178i() {
        return (ImageSaverThread.m14696a().m14714j() && ImageSaverThread.m14696a().m14711g()) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m20165a(Uri uri) {
        try {
            return (this.f18769m != null ? this.f18769m.getContentResolver().loadThumbnail(uri, new Size(1, 1), null) : null) != null;
        } catch (Exception unused) {
            CameraLog.m12967f("GalleryBottomMenuLayout", "checkFileOk: " + uri.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public void m20179j() {
        GalleryPreviewAdapter c3230k = this.f18770n;
        MediaItem.kt c2436aM20255e = c3230k != null ? c3230k.m20255e() : null;
        if (c2436aM20255e == null || this.f18769m == null) {
            return;
        }
        Uri uriM9434g = c2436aM20255e.m9434g();
        if (m20166a(uriM9434g, Util.m24289a(uriM9434g))) {
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setData(uriM9434g);
            intent.putExtra("edit_skill", "doodle");
            intent.putExtra("finish_operate", "save,share");
            intent.putExtra("from", this.f18771o);
            intent.putExtra("isInternalSdcard", true);
            intent.putExtra("editor_state_item", "graffiti");
            intent.setPackage(Util.m24327aP());
            intent.setFlags(1);
            if (m20186b()) {
                intent.addFlags(268468224);
            }
            m20177h();
            try {
                this.f18769m.startActivity(intent);
                this.f18769m.overridePendingTransition(R.anim.gallery_push_up_enter, R.anim.camera_fade_out_for_edit);
            } catch (Throwable th) {
                CameraLog.m12967f("GalleryBottomMenuLayout", "split screen mode jumpMark: " + th);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20161a(Activity activity) {
        COUIAlertDialog dialogInterfaceC1289b = this.f18767k;
        if (dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing()) {
            this.f18767k.dismiss();
        }
        this.f18767k = new COUIAlertDialog.PlatformImplementations.kt_3(activity).m6600f(1).setNeutralButton(R.string.camera_shooting_reference_delete, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_15.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                GalleryBottomMenuLayout.this.m20182a(83, "delete");
                if (GalleryBottomMenuLayout.this.f18770n != null) {
                    GalleryBottomMenuLayout.this.f18770n.m20257g();
                }
                dialogInterface.dismiss();
            }
        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.OplusGLSurfaceView_15.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                GalleryBottomMenuLayout.this.m20182a(83, "cancel");
                dialogInterface.dismiss();
            }
        }).create();
        if (activity.isFinishing()) {
            return;
        }
        this.f18767k.show();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20180a() {
        GalleryPreviewAdapter c3230k = this.f18770n;
        if (c3230k == null) {
            return;
        }
        m20184a(c3230k.m20258h(), false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20181a(int OplusGLSurfaceView_13) {
        GalleryPreviewAdapter c3230k = this.f18770n;
        if (c3230k == null) {
            return;
        }
        m20184a(c3230k.m20253c(OplusGLSurfaceView_13), true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20184a(boolean z, boolean z2) {
        if (!z) {
            m20173d();
        } else {
            m20164a(z2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m20186b() {
        CameraUIListener cameraUIListener = this.f18766j;
        if (cameraUIListener != null) {
            return cameraUIListener.mo10786bc().m13359w();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20185b(int OplusGLSurfaceView_13) {
        CameraUIListener cameraUIListener = this.f18766j;
        if (cameraUIListener != null) {
            cameraUIListener.mo10849i(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20182a(int OplusGLSurfaceView_13, String str) {
        CameraUIListener cameraUIListener = this.f18766j;
        if (cameraUIListener != null) {
            cameraUIListener.mo10680a(OplusGLSurfaceView_13, str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20187c() {
        this.f18769m = null;
        this.f18768l = null;
        this.f18770n = null;
        this.f18766j = null;
    }
}
