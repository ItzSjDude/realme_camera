package com.oplus.camera.longexposure;

/* compiled from: LongExposureMenu.java */
/* loaded from: classes2.dex */
public class g_renamed {
    private android.content.SharedPreferences d_renamed;
    private android.app.Activity e_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.recyclerview.widget.RecyclerView f4836a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.longexposure.c_renamed.a_renamed f4837b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.longexposure.c_renamed f4838c = null;
    private android.widget.RelativeLayout f_renamed = null;
    private com.oplus.camera.longexposure.f_renamed g_renamed = null;
    private android.animation.AnimatorSet h_renamed = null;
    private android.animation.AnimatorSet i_renamed = null;
    private int j_renamed = 0;
    private android.view.animation.PathInterpolator k_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private android.view.animation.PathInterpolator l_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    public g_renamed(android.app.Activity activity, android.content.SharedPreferences sharedPreferences) {
        this.d_renamed = null;
        this.e_renamed = null;
        this.e_renamed = activity;
        this.d_renamed = sharedPreferences;
        a_renamed();
    }

    public void a_renamed(com.oplus.camera.longexposure.f_renamed fVar) {
        this.g_renamed = fVar;
    }

    public void a_renamed() {
        this.f_renamed = (android.widget.RelativeLayout) this.e_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        this.j_renamed = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_scale_translate_y);
        if (this.f4836a == null) {
            int i_renamed = this.d_renamed.getInt("pref_long_exposure_effect_type", 2);
            this.f4836a = new androidx.recyclerview.widget.RecyclerView(this.e_renamed);
            this.f4836a.setOverScrollMode(2);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.setMargins(0, 0, 0, (int) this.e_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_effect_menu_margin_bottom));
            this.f4836a.setVisibility(4);
            this.f4836a.setClipChildren(false);
            this.f_renamed.addView(this.f4836a, layoutParams);
            this.f4836a.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this.e_renamed, 0, false));
            final float dimensionPixelSize = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_effect_menu_item_margin);
            this.f4836a.addItemDecoration(new androidx.recyclerview.widget.RecyclerView.h_renamed() { // from class: com.oplus.camera.longexposure.g_renamed.1
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
            java.util.List<com.oplus.camera.longexposure.j_renamed> listB = b_renamed(i_renamed);
            if (this.f4838c == null) {
                this.f4838c = new com.oplus.camera.longexposure.c_renamed(this.e_renamed, listB);
            }
            this.f4837b = new com.oplus.camera.longexposure.c_renamed.a_renamed() { // from class: com.oplus.camera.longexposure.g_renamed.2
                @Override // com.oplus.camera.longexposure.c_renamed.a_renamed
                public void a_renamed(com.oplus.camera.longexposure.j_renamed jVar) {
                    com.oplus.camera.longexposure.g_renamed.this.g_renamed.a_renamed(jVar);
                }
            };
            this.f4838c.a_renamed(this.f4837b);
            this.f4836a.setAdapter(this.f4838c);
        }
    }

    private java.util.List<com.oplus.camera.longexposure.j_renamed> a_renamed(int i_renamed) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.oplus.camera.longexposure.j_renamed(2, this.e_renamed.getString(com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_long_exposure_type_busy_traffic)), com.oplus.camera.R_renamed.drawable.menu_long_exposure_busy_traffic, 2 == i_renamed));
        arrayList.add(new com.oplus.camera.longexposure.j_renamed(3, this.e_renamed.getString(com.oplus.camera.R_renamed.string.camera_long_exposure_type_flowing_clouds_and_water), com.oplus.camera.R_renamed.drawable.menu_long_exposure_flowing_clouds_and_water, 3 == i_renamed));
        arrayList.add(new com.oplus.camera.longexposure.j_renamed(4, this.e_renamed.getString(com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_long_exposure_type_light_painting)), com.oplus.camera.R_renamed.drawable.menu_long_exposure_light_painting, 4 == i_renamed));
        return arrayList;
    }

    private java.util.List<com.oplus.camera.longexposure.j_renamed> b_renamed(int i_renamed) {
        java.util.List<com.oplus.camera.longexposure.j_renamed> listA = a_renamed(i_renamed);
        int[] configIntArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_LONG_EXPOSURE_SCENE_TYPE_ARRAY);
        if (configIntArrayValue != null && configIntArrayValue.length > 0) {
            if (listA != null && !listA.isEmpty()) {
                listA.clear();
            }
            for (int i2 : configIntArrayValue) {
                if (i2 == 1) {
                    listA.add(new com.oplus.camera.longexposure.j_renamed(1, this.e_renamed.getString(com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_long_exposure_type_light_rail_portrait)), com.oplus.camera.R_renamed.drawable.menu_long_exposure_streamer_portrait, 1 == i_renamed));
                } else if (i2 == 2) {
                    listA.add(new com.oplus.camera.longexposure.j_renamed(2, this.e_renamed.getString(com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_long_exposure_type_busy_traffic)), com.oplus.camera.R_renamed.drawable.menu_long_exposure_busy_traffic, 2 == i_renamed));
                } else if (i2 == 3) {
                    listA.add(new com.oplus.camera.longexposure.j_renamed(3, this.e_renamed.getString(com.oplus.camera.R_renamed.string.camera_long_exposure_type_flowing_clouds_and_water), com.oplus.camera.R_renamed.drawable.menu_long_exposure_flowing_clouds_and_water, 3 == i_renamed));
                } else if (i2 == 4) {
                    listA.add(new com.oplus.camera.longexposure.j_renamed(4, this.e_renamed.getString(com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_long_exposure_type_light_painting)), com.oplus.camera.R_renamed.drawable.menu_long_exposure_light_painting, 4 == i_renamed));
                } else if (i2 == 5) {
                    listA.add(new com.oplus.camera.longexposure.j_renamed(5, this.e_renamed.getString(com.oplus.camera.R_renamed.string.camera_long_exposure_type_moving_crowd), com.oplus.camera.R_renamed.drawable.menu_long_exposure_moving_crowd, 5 == i_renamed));
                }
            }
        }
        return listA;
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.longexposure.c_renamed cVar = this.f4838c;
        if (cVar != null) {
            cVar.a_renamed(z_renamed);
        }
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMenu", "hideMenu");
        if (this.f4836a == null) {
            com.oplus.camera.e_renamed.a_renamed("LongExposureMenu", "EffectMenuRv is_renamed null, so return!");
            return;
        }
        android.animation.AnimatorSet animatorSet = this.h_renamed;
        if (animatorSet != null && (animatorSet.isStarted() || this.h_renamed.isRunning())) {
            com.oplus.camera.e_renamed.a_renamed("LongExposureMenu", "hideMenu, view is_renamed showing, just invisible and return!");
            this.h_renamed.cancel();
        }
        android.animation.AnimatorSet animatorSet2 = this.i_renamed;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            if (z_renamed) {
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.f4836a, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setInterpolator(this.k_renamed);
                objectAnimatorOfFloat.setDuration(250L);
                android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.f4836a, "translationY", 0.0f, this.j_renamed);
                objectAnimatorOfFloat2.setInterpolator(this.l_renamed);
                objectAnimatorOfFloat2.setDuration(400L);
                this.i_renamed = new android.animation.AnimatorSet();
                this.i_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.g_renamed.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        super.onAnimationEnd(animator);
                        com.oplus.camera.longexposure.g_renamed.this.f4836a.setVisibility(4);
                    }
                });
                this.i_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
                this.i_renamed.start();
                return;
            }
            this.f4836a.setVisibility(4);
        }
    }

    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMenu", "showMenu");
        if (this.f4836a == null) {
            a_renamed();
            return;
        }
        android.animation.AnimatorSet animatorSet = this.i_renamed;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        android.animation.AnimatorSet animatorSet2 = this.h_renamed;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            if (z_renamed) {
                this.f4836a.setVisibility(0);
                this.f4836a.setAlpha(0.0f);
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.f4836a, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(this.k_renamed);
                objectAnimatorOfFloat.setDuration(400L);
                android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.f4836a, "translationY", this.j_renamed, 0.0f);
                objectAnimatorOfFloat2.setInterpolator(this.l_renamed);
                objectAnimatorOfFloat2.setDuration(400L);
                this.h_renamed = new android.animation.AnimatorSet();
                this.h_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
                this.h_renamed.setStartDelay(150L);
                this.h_renamed.start();
                return;
            }
            this.f4836a.setTranslationY(0.0f);
            this.f4836a.setAlpha(1.0f);
            this.f4836a.setVisibility(0);
        }
    }

    public boolean b_renamed() {
        return this.f4836a.getVisibility() == 0;
    }

    public int c_renamed() {
        return this.d_renamed.getInt("pref_long_exposure_effect_type", 2);
    }

    public int d_renamed() {
        int iC = c_renamed();
        if (iC == 1) {
            return com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_long_exposure_type_light_rail_portrait);
        }
        if (iC == 2) {
            return com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_long_exposure_type_busy_traffic);
        }
        if (iC == 3) {
            return com.oplus.camera.R_renamed.string.camera_long_exposure_type_flowing_clouds_and_water;
        }
        if (iC == 4) {
            return com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_long_exposure_type_light_painting);
        }
        if (iC != 5) {
            return 0;
        }
        return com.oplus.camera.R_renamed.string.camera_long_exposure_type_moving_crowd;
    }
}
