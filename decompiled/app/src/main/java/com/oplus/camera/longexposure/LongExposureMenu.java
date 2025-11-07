package com.oplus.camera.longexposure;

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
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.longexposure.LongExposureEffectMenuAdapter;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LongExposureMenu.java */
/* renamed from: com.oplus.camera.longexposure.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class LongExposureMenu {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private SharedPreferences f14589d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Activity f14590e;

    /* renamed from: PlatformImplementations.kt_3 */
    private RecyclerView f14586a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private LongExposureEffectMenuAdapter.PlatformImplementations.kt_3 f14587b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private LongExposureEffectMenuAdapter f14588c = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private RelativeLayout f14591f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private LongExposureListener f14592g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private AnimatorSet f14593h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private AnimatorSet f14594i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f14595j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private PathInterpolator f14596k = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: OplusGLSurfaceView_14 */
    private PathInterpolator f14597l = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    public LongExposureMenu(Activity activity, SharedPreferences sharedPreferences) {
        this.f14589d = null;
        this.f14590e = null;
        this.f14590e = activity;
        this.f14589d = sharedPreferences;
        m14611a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14612a(LongExposureListener interfaceC2802f) {
        this.f14592g = interfaceC2802f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14611a() {
        this.f14591f = (RelativeLayout) this.f14590e.findViewById(R.id_renamed.camera);
        this.f14595j = this.f14590e.getResources().getDimensionPixelSize(R.dimen.long_exposure_scale_translate_y);
        if (this.f14586a == null) {
            int OplusGLSurfaceView_13 = this.f14589d.getInt("pref_long_exposure_effect_type", 2);
            this.f14586a = new RecyclerView(this.f14590e);
            this.f14586a.setOverScrollMode(2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.setMargins(0, 0, 0, (int) this.f14590e.getResources().getDimension(R.dimen.long_exposure_effect_menu_margin_bottom));
            this.f14586a.setVisibility(4);
            this.f14586a.setClipChildren(false);
            this.f14591f.addView(this.f14586a, layoutParams);
            this.f14586a.setLayoutManager(new LinearLayoutManager(this.f14590e, 0, false));
            final float dimensionPixelSize = this.f14590e.getResources().getDimensionPixelSize(R.dimen.long_exposure_effect_menu_item_margin);
            this.f14586a.addItemDecoration(new RecyclerView.AbstractC0692h() { // from class: com.oplus.camera.longexposure.COUIBaseListPopupWindow_11.1
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
            List<LongExposureSceneItem> listM14610b = m14610b(OplusGLSurfaceView_13);
            if (this.f14588c == null) {
                this.f14588c = new LongExposureEffectMenuAdapter(this.f14590e, listM14610b);
            }
            this.f14587b = new LongExposureEffectMenuAdapter.PlatformImplementations.kt_3() { // from class: com.oplus.camera.longexposure.COUIBaseListPopupWindow_11.2
                @Override // com.oplus.camera.longexposure.LongExposureEffectMenuAdapter.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo14568a(LongExposureSceneItem c2806j) {
                    LongExposureMenu.this.f14592g.mo12538a(c2806j);
                }
            };
            this.f14588c.m14565a(this.f14587b);
            this.f14586a.setAdapter(this.f14588c);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private List<LongExposureSceneItem> m14608a(int OplusGLSurfaceView_13) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LongExposureSceneItem(2, this.f14590e.getString(Util.m24445f(R.string.camera_long_exposure_type_busy_traffic)), R.drawable.menu_long_exposure_busy_traffic, 2 == OplusGLSurfaceView_13));
        arrayList.add(new LongExposureSceneItem(3, this.f14590e.getString(R.string.camera_long_exposure_type_flowing_clouds_and_water), R.drawable.menu_long_exposure_flowing_clouds_and_water, 3 == OplusGLSurfaceView_13));
        arrayList.add(new LongExposureSceneItem(4, this.f14590e.getString(Util.m24445f(R.string.camera_long_exposure_type_light_painting)), R.drawable.menu_long_exposure_light_painting, 4 == OplusGLSurfaceView_13));
        return arrayList;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private List<LongExposureSceneItem> m14610b(int OplusGLSurfaceView_13) {
        List<LongExposureSceneItem> listM14608a = m14608a(OplusGLSurfaceView_13);
        int[] configIntArrayValue = CameraConfig.getConfigIntArrayValue(ConfigDataBase.KEY_LONG_EXPOSURE_SCENE_TYPE_ARRAY);
        if (configIntArrayValue != null && configIntArrayValue.length > 0) {
            if (listM14608a != null && !listM14608a.isEmpty()) {
                listM14608a.clear();
            }
            for (int i2 : configIntArrayValue) {
                if (i2 == 1) {
                    listM14608a.add(new LongExposureSceneItem(1, this.f14590e.getString(Util.m24445f(R.string.camera_long_exposure_type_light_rail_portrait)), R.drawable.menu_long_exposure_streamer_portrait, 1 == OplusGLSurfaceView_13));
                } else if (i2 == 2) {
                    listM14608a.add(new LongExposureSceneItem(2, this.f14590e.getString(Util.m24445f(R.string.camera_long_exposure_type_busy_traffic)), R.drawable.menu_long_exposure_busy_traffic, 2 == OplusGLSurfaceView_13));
                } else if (i2 == 3) {
                    listM14608a.add(new LongExposureSceneItem(3, this.f14590e.getString(R.string.camera_long_exposure_type_flowing_clouds_and_water), R.drawable.menu_long_exposure_flowing_clouds_and_water, 3 == OplusGLSurfaceView_13));
                } else if (i2 == 4) {
                    listM14608a.add(new LongExposureSceneItem(4, this.f14590e.getString(Util.m24445f(R.string.camera_long_exposure_type_light_painting)), R.drawable.menu_long_exposure_light_painting, 4 == OplusGLSurfaceView_13));
                } else if (i2 == 5) {
                    listM14608a.add(new LongExposureSceneItem(5, this.f14590e.getString(R.string.camera_long_exposure_type_moving_crowd), R.drawable.menu_long_exposure_moving_crowd, 5 == OplusGLSurfaceView_13));
                }
            }
        }
        return listM14608a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14613a(boolean z) {
        LongExposureEffectMenuAdapter c2799c = this.f14588c;
        if (c2799c != null) {
            c2799c.m14567a(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14614b(boolean z) {
        CameraLog.m12954a("LongExposureMenu", "hideMenu");
        if (this.f14586a == null) {
            CameraLog.m12954a("LongExposureMenu", "EffectMenuRv is null, so return!");
            return;
        }
        AnimatorSet animatorSet = this.f14593h;
        if (animatorSet != null && (animatorSet.isStarted() || this.f14593h.isRunning())) {
            CameraLog.m12954a("LongExposureMenu", "hideMenu, view is showing, just invisible and return!");
            this.f14593h.cancel();
        }
        AnimatorSet animatorSet2 = this.f14594i;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            if (z) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f14586a, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setInterpolator(this.f14596k);
                objectAnimatorOfFloat.setDuration(250L);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f14586a, "translationY", 0.0f, this.f14595j);
                objectAnimatorOfFloat2.setInterpolator(this.f14597l);
                objectAnimatorOfFloat2.setDuration(400L);
                this.f14594i = new AnimatorSet();
                this.f14594i.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.COUIBaseListPopupWindow_11.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        LongExposureMenu.this.f14586a.setVisibility(4);
                    }
                });
                this.f14594i.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
                this.f14594i.start();
                return;
            }
            this.f14586a.setVisibility(4);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14617c(boolean z) {
        CameraLog.m12954a("LongExposureMenu", "showMenu");
        if (this.f14586a == null) {
            m14611a();
            return;
        }
        AnimatorSet animatorSet = this.f14594i;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f14593h;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            if (z) {
                this.f14586a.setVisibility(0);
                this.f14586a.setAlpha(0.0f);
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f14586a, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(this.f14596k);
                objectAnimatorOfFloat.setDuration(400L);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f14586a, "translationY", this.f14595j, 0.0f);
                objectAnimatorOfFloat2.setInterpolator(this.f14597l);
                objectAnimatorOfFloat2.setDuration(400L);
                this.f14593h = new AnimatorSet();
                this.f14593h.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
                this.f14593h.setStartDelay(150L);
                this.f14593h.start();
                return;
            }
            this.f14586a.setTranslationY(0.0f);
            this.f14586a.setAlpha(1.0f);
            this.f14586a.setVisibility(0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m14615b() {
        return this.f14586a.getVisibility() == 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m14616c() {
        return this.f14589d.getInt("pref_long_exposure_effect_type", 2);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m14618d() {
        int iM14616c = m14616c();
        if (iM14616c == 1) {
            return Util.m24445f(R.string.camera_long_exposure_type_light_rail_portrait);
        }
        if (iM14616c == 2) {
            return Util.m24445f(R.string.camera_long_exposure_type_busy_traffic);
        }
        if (iM14616c == 3) {
            return R.string.camera_long_exposure_type_flowing_clouds_and_water;
        }
        if (iM14616c == 4) {
            return Util.m24445f(R.string.camera_long_exposure_type_light_painting);
        }
        if (iM14616c != 5) {
            return 0;
        }
        return R.string.camera_long_exposure_type_moving_crowd;
    }
}
