package com.oplus.camera.photo3d.p159ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.photo3d.p159ui.SceneMenuAdapter;
import java.util.ArrayList;

/* compiled from: SceneMenu.java */
/* renamed from: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class SceneMenu {

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f15291a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SharedPreferences f15292b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RecyclerView f15293c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RelativeLayout f15294d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private RelativeLayout.LayoutParams f15295e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private SceneMenuAdapter f15296f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private AnimatorSet f15297g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private AnimatorSet f15298h;

    /* renamed from: OplusGLSurfaceView_13 */
    private PathInterpolator f15299i = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: OplusGLSurfaceView_15 */
    private PathInterpolator f15300j = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: OplusGLSurfaceView_5 */
    private int f15301k;

    /* renamed from: OplusGLSurfaceView_14 */
    private PlatformImplementations.kt_3 f15302l;

    /* compiled from: SceneMenu.java */
    /* renamed from: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo15295a(SceneItem c2873d);
    }

    public SceneMenu(Activity activity, SharedPreferences sharedPreferences) {
        this.f15291a = activity;
        this.f15292b = sharedPreferences;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m15285c() {
        if (this.f15293c != null) {
            return;
        }
        this.f15301k = this.f15291a.getResources().getDimensionPixelSize(R.dimen.long_exposure_scale_translate_y);
        this.f15293c = new RecyclerView(this.f15291a);
        this.f15293c.setOverScrollMode(2);
        this.f15293c.setVisibility(4);
        this.f15293c.setClipChildren(false);
        m15286d().addView(this.f15293c, m15287e());
        this.f15293c.setLayoutManager(new LinearLayoutManager(this.f15291a, 0, false));
        final float dimensionPixelSize = this.f15291a.getResources().getDimensionPixelSize(R.dimen.long_exposure_effect_menu_item_margin);
        this.f15293c.addItemDecoration(new RecyclerView.AbstractC0692h() { // from class: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_8.1
            @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0692h
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0704t c0704t) {
                super.getItemOffsets(rect, view, recyclerView, c0704t);
                rect.bottom = 0;
                rect.top = 0;
                float COUIBaseListPopupWindow_12 = dimensionPixelSize;
                rect.right = ((int) COUIBaseListPopupWindow_12) / 2;
                rect.left = ((int) COUIBaseListPopupWindow_12) / 2;
            }
        });
        this.f15293c.setAdapter(m15288f());
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RelativeLayout m15286d() {
        if (this.f15294d == null) {
            this.f15294d = (RelativeLayout) this.f15291a.findViewById(R.id_renamed.camera);
        }
        return this.f15294d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private RelativeLayout.LayoutParams m15287e() {
        if (this.f15295e == null) {
            this.f15295e = new RelativeLayout.LayoutParams(-2, -2);
            this.f15295e.addRule(12);
            this.f15295e.addRule(14);
            this.f15295e.setMargins(0, 0, 0, (int) this.f15291a.getResources().getDimension(R.dimen.long_exposure_effect_menu_margin_bottom));
        }
        return this.f15295e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private RecyclerView.AbstractC0685a m15288f() {
        if (this.f15296f == null) {
            int OplusGLSurfaceView_13 = this.f15292b.getInt("pref_3d_photo_scene_type", 1);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SceneItem(1, this.f15291a.getString(R.string.scene_dolly_zoom_title), R.raw.menu_dolly_zoom, 1 == OplusGLSurfaceView_13));
            arrayList.add(new SceneItem(2, this.f15291a.getString(R.string.scene_circle_title), R.raw.menu_circle, 2 == OplusGLSurfaceView_13));
            arrayList.add(new SceneItem(3, this.f15291a.getString(R.string.scene_swing_title), R.raw.menu_swing, 3 == OplusGLSurfaceView_13));
            arrayList.add(new SceneItem(4, this.f15291a.getString(R.string.scene_portrait_title), R.raw.menu_portrait, 4 == OplusGLSurfaceView_13));
            this.f15296f = new SceneMenuAdapter(this.f15291a, arrayList);
            this.f15296f.m15300a(new SceneMenuAdapter.PlatformImplementations.kt_3() { // from class: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_8.2
                @Override // com.oplus.camera.photo3d.p159ui.SceneMenuAdapter.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo15294a(SceneItem c2873d) {
                    if (SceneMenu.this.f15302l != null) {
                        SceneMenu.this.f15292b.edit().putInt("pref_3d_photo_scene_type", c2873d.m15277a()).apply();
                        SceneMenu.this.f15302l.mo15295a(c2873d);
                    }
                }
            });
        }
        return this.f15296f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15290a(boolean z) {
        m15285c();
        if (this.f15293c.isShown()) {
            return;
        }
        AnimatorSet animatorSet = this.f15298h;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f15297g;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            if (!z) {
                this.f15293c.setVisibility(0);
                return;
            }
            this.f15293c.setVisibility(0);
            this.f15293c.setAlpha(0.0f);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f15293c, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setInterpolator(this.f15299i);
            objectAnimatorOfFloat.setDuration(400L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f15293c, "translationY", this.f15301k, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.f15300j);
            objectAnimatorOfFloat2.setDuration(400L);
            this.f15297g = new AnimatorSet();
            this.f15297g.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            this.f15297g.setStartDelay(150L);
            this.f15297g.start();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15293b(boolean z) {
        RecyclerView recyclerView = this.f15293c;
        if (recyclerView == null) {
            CameraLog.m12959b("SceneMenu", "hideMenu, return for not init");
            return;
        }
        if (!z) {
            recyclerView.setVisibility(4);
            return;
        }
        AnimatorSet animatorSet = this.f15297g;
        if (animatorSet != null && (animatorSet.isStarted() || this.f15297g.isRunning())) {
            CameraLog.m12954a("SceneMenu", "hideMenu, view is showing, just invisible and return!");
            this.f15297g.cancel();
        }
        AnimatorSet animatorSet2 = this.f15298h;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f15293c, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.f15299i);
            objectAnimatorOfFloat.setDuration(250L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f15293c, "translationY", 0.0f, this.f15301k);
            objectAnimatorOfFloat2.setInterpolator(this.f15300j);
            objectAnimatorOfFloat2.setDuration(400L);
            this.f15298h = new AnimatorSet();
            this.f15298h.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_8.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    SceneMenu.this.f15293c.setVisibility(4);
                }
            });
            this.f15298h.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            this.f15298h.start();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15291a() {
        RecyclerView recyclerView = this.f15293c;
        return recyclerView != null && recyclerView.getVisibility() == 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15292b() {
        if (this.f15293c != null) {
            m15286d().removeView(this.f15293c);
            this.f15293c = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15289a(PlatformImplementations.kt_3 aVar) {
        this.f15302l = aVar;
    }
}
