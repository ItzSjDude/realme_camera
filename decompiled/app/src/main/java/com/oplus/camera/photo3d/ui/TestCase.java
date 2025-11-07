package com.oplus.camera.photo3d.ui;

/* compiled from: SceneMenu.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f5063a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.SharedPreferences f5064b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.recyclerview.widget.RecyclerView f5065c;
    private android.widget.RelativeLayout d_renamed;
    private android.widget.RelativeLayout.LayoutParams e_renamed;
    private com.oplus.camera.photo3d.ui.f_renamed f_renamed;
    private android.animation.AnimatorSet g_renamed;
    private android.animation.AnimatorSet h_renamed;
    private android.view.animation.PathInterpolator i_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private android.view.animation.PathInterpolator j_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private int k_renamed;
    private com.oplus.camera.photo3d.ui.e_renamed.a_renamed l_renamed;

    /* compiled from: SceneMenu.java */
    public interface a_renamed {
        void a_renamed(com.oplus.camera.photo3d.ui.d_renamed dVar);
    }

    public e_renamed(android.app.Activity activity, android.content.SharedPreferences sharedPreferences) {
        this.f5063a = activity;
        this.f5064b = sharedPreferences;
    }

    private void c_renamed() {
        if (this.f5065c != null) {
            return;
        }
        this.k_renamed = this.f5063a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_scale_translate_y);
        this.f5065c = new androidx.recyclerview.widget.RecyclerView(this.f5063a);
        this.f5065c.setOverScrollMode(2);
        this.f5065c.setVisibility(4);
        this.f5065c.setClipChildren(false);
        d_renamed().addView(this.f5065c, e_renamed());
        this.f5065c.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this.f5063a, 0, false));
        final float dimensionPixelSize = this.f5063a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_effect_menu_item_margin);
        this.f5065c.addItemDecoration(new androidx.recyclerview.widget.RecyclerView.h_renamed() { // from class: com.oplus.camera.photo3d.ui.e_renamed.1
            @Override // androidx.recyclerview.widget.RecyclerView.h_renamed
            public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
                super.getItemOffsets(rect, view, recyclerView, tVar);
                rect.bottom = 0;
                rect.top = 0;
                float f_renamed = dimensionPixelSize;
                rect.right = ((int) f_renamed) / 2;
                rect.left = ((int) f_renamed) / 2;
            }
        });
        this.f5065c.setAdapter(f_renamed());
    }

    private android.widget.RelativeLayout d_renamed() {
        if (this.d_renamed == null) {
            this.d_renamed = (android.widget.RelativeLayout) this.f5063a.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        }
        return this.d_renamed;
    }

    private android.widget.RelativeLayout.LayoutParams e_renamed() {
        if (this.e_renamed == null) {
            this.e_renamed = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            this.e_renamed.addRule(12);
            this.e_renamed.addRule(14);
            this.e_renamed.setMargins(0, 0, 0, (int) this.f5063a.getResources().getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_effect_menu_margin_bottom));
        }
        return this.e_renamed;
    }

    private androidx.recyclerview.widget.RecyclerView.a_renamed f_renamed() {
        if (this.f_renamed == null) {
            int i_renamed = this.f5064b.getInt("pref_3d_photo_scene_type", 1);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(new com.oplus.camera.photo3d.ui.d_renamed(1, this.f5063a.getString(com.oplus.camera.R_renamed.string.scene_dolly_zoom_title), com.oplus.camera.R_renamed.raw.menu_dolly_zoom, 1 == i_renamed));
            arrayList.add(new com.oplus.camera.photo3d.ui.d_renamed(2, this.f5063a.getString(com.oplus.camera.R_renamed.string.scene_circle_title), com.oplus.camera.R_renamed.raw.menu_circle, 2 == i_renamed));
            arrayList.add(new com.oplus.camera.photo3d.ui.d_renamed(3, this.f5063a.getString(com.oplus.camera.R_renamed.string.scene_swing_title), com.oplus.camera.R_renamed.raw.menu_swing, 3 == i_renamed));
            arrayList.add(new com.oplus.camera.photo3d.ui.d_renamed(4, this.f5063a.getString(com.oplus.camera.R_renamed.string.scene_portrait_title), com.oplus.camera.R_renamed.raw.menu_portrait, 4 == i_renamed));
            this.f_renamed = new com.oplus.camera.photo3d.ui.f_renamed(this.f5063a, arrayList);
            this.f_renamed.a_renamed(new com.oplus.camera.photo3d.ui.f_renamed.a_renamed() { // from class: com.oplus.camera.photo3d.ui.e_renamed.2
                @Override // com.oplus.camera.photo3d.ui.f_renamed.a_renamed
                public void a_renamed(com.oplus.camera.photo3d.ui.d_renamed dVar) {
                    if (com.oplus.camera.photo3d.ui.e_renamed.this.l_renamed != null) {
                        com.oplus.camera.photo3d.ui.e_renamed.this.f5064b.edit().putInt("pref_3d_photo_scene_type", dVar.a_renamed()).apply();
                        com.oplus.camera.photo3d.ui.e_renamed.this.l_renamed.a_renamed(dVar);
                    }
                }
            });
        }
        return this.f_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        c_renamed();
        if (this.f5065c.isShown()) {
            return;
        }
        android.animation.AnimatorSet animatorSet = this.h_renamed;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        android.animation.AnimatorSet animatorSet2 = this.g_renamed;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            if (!z_renamed) {
                this.f5065c.setVisibility(0);
                return;
            }
            this.f5065c.setVisibility(0);
            this.f5065c.setAlpha(0.0f);
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.f5065c, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setInterpolator(this.i_renamed);
            objectAnimatorOfFloat.setDuration(400L);
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.f5065c, "translationY", this.k_renamed, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.j_renamed);
            objectAnimatorOfFloat2.setDuration(400L);
            this.g_renamed = new android.animation.AnimatorSet();
            this.g_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            this.g_renamed.setStartDelay(150L);
            this.g_renamed.start();
        }
    }

    public void b_renamed(boolean z_renamed) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.f5065c;
        if (recyclerView == null) {
            com.oplus.camera.e_renamed.b_renamed("SceneMenu", "hideMenu, return for not init");
            return;
        }
        if (!z_renamed) {
            recyclerView.setVisibility(4);
            return;
        }
        android.animation.AnimatorSet animatorSet = this.g_renamed;
        if (animatorSet != null && (animatorSet.isStarted() || this.g_renamed.isRunning())) {
            com.oplus.camera.e_renamed.a_renamed("SceneMenu", "hideMenu, view is_renamed showing, just invisible and return!");
            this.g_renamed.cancel();
        }
        android.animation.AnimatorSet animatorSet2 = this.h_renamed;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.f5065c, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.i_renamed);
            objectAnimatorOfFloat.setDuration(250L);
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.f5065c, "translationY", 0.0f, this.k_renamed);
            objectAnimatorOfFloat2.setInterpolator(this.j_renamed);
            objectAnimatorOfFloat2.setDuration(400L);
            this.h_renamed = new android.animation.AnimatorSet();
            this.h_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.photo3d.ui.e_renamed.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    super.onAnimationEnd(animator);
                    com.oplus.camera.photo3d.ui.e_renamed.this.f5065c.setVisibility(4);
                }
            });
            this.h_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            this.h_renamed.start();
        }
    }

    public boolean a_renamed() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.f5065c;
        return recyclerView != null && recyclerView.getVisibility() == 0;
    }

    public void b_renamed() {
        if (this.f5065c != null) {
            d_renamed().removeView(this.f5065c);
            this.f5065c = null;
        }
    }

    public void a_renamed(com.oplus.camera.photo3d.ui.e_renamed.a_renamed aVar) {
        this.l_renamed = aVar;
    }
}
