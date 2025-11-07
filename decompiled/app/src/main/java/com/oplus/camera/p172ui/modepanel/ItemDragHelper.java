package com.oplus.camera.p172ui.modepanel;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.database.SQLException;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p038b.PathInterpolatorCompat_2;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.DimenConstants;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.ScreenModeManager;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.statistics.model.ReminderMsgData;
import com.oplus.camera.util.Util;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: ItemDragHelper.java */
/* renamed from: com.oplus.camera.ui.modepanel.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class ItemDragHelper {

    /* renamed from: A */
    private ScreenModeManager f20539A;

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f20541a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private FloatViewContainer f20542b;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f20552l;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f20543c = -1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RecyclerView f20544d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private RecyclerView f20545e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private RecyclerView f20546f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CameraUIListener f20547g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f20548h = -1;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f20549i = -1;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f20550j = 0.3f;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f20551k = 0.1f;

    /* renamed from: OplusGLSurfaceView_6 */
    private RecyclerView f20553m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f20554n = false;

    /* renamed from: o */
    private View f20555o = null;

    /* renamed from: p */
    private int f20556p = 0;

    /* renamed from: q */
    private int f20557q = 0;

    /* renamed from: r */
    private int f20558r = 0;

    /* renamed from: s */
    private int f20559s = 0;

    /* renamed from: t */
    private int f20560t = 0;

    /* renamed from: u */
    private int f20561u = 90;

    /* renamed from: v */
    private long f20562v = 0;

    /* renamed from: w */
    private int f20563w = -1;

    /* renamed from: x */
    private Rect f20564x = null;

    /* renamed from: y */
    private long f20565y = 0;

    /* renamed from: z */
    private int[] f20566z = null;

    /* renamed from: B */
    private final Runnable f20540B = new Runnable() { // from class: com.oplus.camera.ui.modepanel.COUIBaseListPopupWindow_12.1
        @Override // java.lang.Runnable
        public void run() throws SQLException {
            ItemDragHelper c3348f = ItemDragHelper.this;
            float[] fArrM21891d = c3348f.m21891d(c3348f.f20546f, ItemDragHelper.this.f20557q, ItemDragHelper.this.f20558r);
            ItemDragHelper c3348f2 = ItemDragHelper.this;
            float[] fArrM21891d2 = c3348f2.m21891d(c3348f2.f20544d, ItemDragHelper.this.f20557q, ItemDragHelper.this.f20558r);
            ItemDragHelper c3348f3 = ItemDragHelper.this;
            boolean zM21857a = c3348f3.m21857a(c3348f3.f20546f, (int) fArrM21891d[0], (int) fArrM21891d[1]);
            ItemDragHelper c3348f4 = ItemDragHelper.this;
            boolean zM21857a2 = c3348f4.m21857a(c3348f4.f20544d, (int) fArrM21891d2[0], (int) fArrM21891d2[1]);
            if (ItemDragHelper.this.m21900a()) {
                if (zM21857a || zM21857a2) {
                    ItemDragHelper.this.m21854a(r0.f20557q, ItemDragHelper.this.f20558r);
                    ItemDragHelper.this.f20544d.removeCallbacks(ItemDragHelper.this.f20540B);
                    ViewCompat.m2857a(ItemDragHelper.this.f20544d, this);
                }
            }
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21855a(int OplusGLSurfaceView_13, int i2) {
        return (OplusGLSurfaceView_13 == i2 || OplusGLSurfaceView_13 == -1 || i2 == -1) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m21875b(int OplusGLSurfaceView_13, int i2) {
        return OplusGLSurfaceView_13 == -1 && i2 != -1;
    }

    public ItemDragHelper(Activity activity, ScreenModeManager c2953g) {
        this.f20541a = null;
        this.f20542b = null;
        this.f20552l = 0;
        this.f20539A = null;
        this.f20541a = activity;
        this.f20542b = new FloatViewContainer(activity, c2953g);
        this.f20552l = Util.getScreenHeight() - Util.m24187O();
        this.f20539A = c2953g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21897a(RecyclerView recyclerView) {
        if (recyclerView != this.f20545e) {
            this.f20545e = recyclerView;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21899a(RecyclerView recyclerView, CameraUIListener cameraUIListener) {
        if (recyclerView != this.f20546f) {
            this.f20546f = recyclerView;
        }
        if (cameraUIListener != this.f20547g) {
            this.f20547g = cameraUIListener;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21895a(int OplusGLSurfaceView_13) {
        this.f20560t = OplusGLSurfaceView_13;
        this.f20561u = this.f20539A.mo16411a().mo16570k();
        FloatViewContainer c3347e = this.f20542b;
        if (c3347e != null) {
            c3347e.m21827a(OplusGLSurfaceView_13);
        }
        if (3 == this.f20560t) {
            this.f20552l = Util.getScreenHeight() - ((int) Util.m24456h(R.dimen.fold_split_screen_control_panel_height));
        } else {
            this.f20552l = Util.getScreenHeight() - Util.m24187O();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21898a(RecyclerView recyclerView, View view, int OplusGLSurfaceView_13, MotionEvent motionEvent) {
        if (System.currentTimeMillis() - this.f20562v < ViewConfiguration.getLongPressTimeout()) {
            CameraLog.m12967f("ItemDragHelper", "startDrag, time interval is too short.");
            return;
        }
        if (m21900a() || m21901b()) {
            CameraLog.m12967f("ItemDragHelper", "startDrag, float view is shown, parent: " + recyclerView + ", isAnimationRunning: " + m21901b());
            return;
        }
        if (this.f20556p == 0) {
            CameraLog.m12967f("ItemDragHelper", "startDrag, mLastTouchX is invalid.");
            return;
        }
        int pointerCount = motionEvent.getPointerCount();
        if (1 < pointerCount) {
            CameraLog.m12954a("ItemDragHelper", "startDrag, can't process multi-touch events, count: " + pointerCount);
            return;
        }
        if (5 == motionEvent.getActionMasked() || 6 == motionEvent.getActionMasked()) {
            return;
        }
        this.f20556p = (int) (motionEvent.getX() + 0.5f);
        this.f20553m = recyclerView;
        this.f20555o = view;
        this.f20554n = false;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != -1) {
            OplusGLSurfaceView_13 = childAdapterPosition;
        }
        ModeInfo c3353k = (ModeInfo) this.f20555o.getTag(R.id_renamed.tag_recycle_view_mode_info);
        if (c3353k == null || !c3353k.m21933g()) {
            CameraLog.m12967f("ItemDragHelper", "startDrag, mDragModeInfo: " + c3353k + " can't be selected.");
            return;
        }
        m21856a(this.f20555o, c3353k);
        this.f20543c = recyclerView == this.f20545e ? 0 : 1;
        this.f20544d = recyclerView;
        this.f20548h = OplusGLSurfaceView_13;
        this.f20549i = -1;
        Rect rectM21798c = DragHelperUtils.m21798c(this.f20555o, this.f20560t, this.f20561u);
        ModeInfo c3353k2 = (ModeInfo) this.f20555o.getTag(R.id_renamed.tag_recycle_view_mode_info);
        int iM21865b = m21865b(recyclerView);
        boolean z = 1 == TextUtils.getLayoutDirectionFromLocale(Locale.getDefault());
        if (4 == this.f20560t) {
            if (this.f20561u == 90) {
                rectM21798c.right = rectM21798c.left;
                rectM21798c.left += this.f20555o.getHeight();
            } else {
                int i2 = ScreenModeConst.f16035b - rectM21798c.bottom;
                int i3 = ScreenModeConst.f16034a - rectM21798c.left;
                rectM21798c.top = i2;
                rectM21798c.left = i3;
            }
        }
        this.f20542b.m21830a(c3353k2, iM21865b, z ? Util.getScreenWidth() - rectM21798c.right : rectM21798c.left, rectM21798c.top, view.getWidth());
        RecyclerView.C0694j c0694j = (RecyclerView.C0694j) this.f20555o.getLayoutParams();
        this.f20559s = this.f20555o.getWidth() + c0694j.leftMargin + c0694j.rightMargin;
        if (this.f20545e.getChildAt(0) != null) {
            this.f20564x = DragHelperUtils.m21798c(this.f20545e.getChildAt(0), this.f20560t, this.f20561u);
        } else {
            this.f20564x = DragHelperUtils.m21798c(this.f20545e, this.f20560t, this.f20561u);
            Rect rect = this.f20564x;
            rect.bottom = rect.top + DimenConstants.m14487e();
        }
        this.f20547g.mo10840g(0);
        m21852a(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21852a(boolean z) {
        int[] iArr = this.f20566z;
        if (iArr == null || Arrays.binarySearch(iArr, 0) < 0) {
            this.f20566z = new int[MoreUIControl.f20631a];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < MoreUIControl.f20631a; OplusGLSurfaceView_13++) {
                View viewFindViewByPosition = this.f20545e.getLayoutManager().findViewByPosition(OplusGLSurfaceView_13);
                if (viewFindViewByPosition != null) {
                    int i2 = this.f20560t;
                    if (4 == i2) {
                        this.f20566z[OplusGLSurfaceView_13] = DragHelperUtils.m21798c(viewFindViewByPosition, i2, this.f20561u).top;
                    } else {
                        this.f20566z[OplusGLSurfaceView_13] = DragHelperUtils.m21798c(viewFindViewByPosition, i2, this.f20561u).left;
                    }
                }
            }
        }
        for (int i3 = 1; i3 < MoreUIControl.f20631a; i3++) {
            int[] iArr2 = this.f20566z;
            if (iArr2[i3] == 0) {
                if (z) {
                    iArr2[i3] = (iArr2[i3 - 1] - DimenConstants.m14486d()) - DimenConstants.m14485c();
                } else {
                    iArr2[i3] = iArr2[i3 - 1] + DimenConstants.m14486d() + DimenConstants.m14485c();
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m21865b(RecyclerView recyclerView) {
        if (recyclerView == this.f20545e) {
            return 1;
        }
        return recyclerView == this.f20546f ? 2 : -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21896a(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        int pointerCount = motionEvent.getPointerCount();
        int actionMasked = motionEvent.getActionMasked();
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (System.currentTimeMillis() - this.f20562v < ViewConfiguration.getLongPressTimeout() && 1 != actionMasked && 3 != actionMasked && 4 != actionMasked) {
            CameraLog.m12954a("ItemDragHelper", "onDrag, time interval is too short, action: " + actionMasked);
            return;
        }
        if (pointerCount > 1 && 1 != actionMasked && 6 != actionMasked && 3 != actionMasked) {
            CameraLog.m12954a("ItemDragHelper", "onDrag, can't process multi-touch events, count: " + pointerCount + ", action: " + actionMasked);
            return;
        }
        if (5 == actionMasked || (6 == actionMasked && motionEvent.getPointerId(action) != this.f20563w)) {
            CameraLog.m12954a("ItemDragHelper", "onDrag, can't process action: " + actionMasked + ", index: " + action + ", getPointerId: " + motionEvent.getPointerId(action) + ", mActivePointerId: " + this.f20563w);
            return;
        }
        if (actionMasked == 0) {
            if (-1 != this.f20563w) {
                return;
            } else {
                this.f20563w = motionEvent.getPointerId(0);
            }
        }
        if (motionEvent.getPointerId(0) != this.f20563w) {
            return;
        }
        this.f20556p = (int) (motionEvent.getX() + 0.5f);
        this.f20557q = (int) (motionEvent.getRawX() + 0.5f);
        this.f20558r = (int) (motionEvent.getRawY() + 0.5f);
        this.f20542b.m21829a(motionEvent);
        if (this.f20545e == null || this.f20546f == null) {
            CameraLog.m12967f("ItemDragHelper", "onDrag, host is null, mModelistHost: " + this.f20545e + ", mHeadlineHost: " + this.f20546f);
            return;
        }
        if (!this.f20542b.m21832c()) {
            CameraLog.m12954a("ItemDragHelper", "onDrag, can't process event when float view is not shown.");
            return;
        }
        ModeInfo c3353k = (ModeInfo) this.f20555o.getTag(R.id_renamed.tag_recycle_view_mode_info);
        Rect rectM21836g = this.f20542b.m21836g();
        m21883c(rectM21836g, c3353k);
        CameraLog.m12954a("ItemDragHelper", "onDrag, mDividY: " + this.f20552l + ", mLastTouchX: " + this.f20556p + ", event: " + motionEvent);
        if (2 == actionMasked) {
            m21854a(this.f20557q, this.f20558r);
            m21882c();
        } else if (1 == actionMasked || 6 == actionMasked || 3 == actionMasked || 4 == actionMasked) {
            this.f20562v = System.currentTimeMillis();
            m21846a(rectM21836g);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m21882c() {
        RecyclerView recyclerView = this.f20544d;
        if (recyclerView != null) {
            recyclerView.removeCallbacks(this.f20540B);
            this.f20540B.run();
            this.f20544d.invalidate();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21846a(final Rect rect) {
        CameraLog.m12967f("ItemDragHelper", "stopDrag, mLastItemPos: " + this.f20548h + ", mLastHost: " + this.f20544d);
        if (this.f20542b.m21832c()) {
            final ModeInfo c3353k = (ModeInfo) this.f20555o.getTag(R.id_renamed.tag_recycle_view_mode_info);
            this.f20539A.mo16411a().mo16536d(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$COUIBaseListPopupWindow_12$nn3_UedtgcXhr12iuvuOG8tLijA
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) throws SQLException {
                    this.COUIBaseListPopupWindow_12$0.m21890d(rect, c3353k, objArr);
                }
            }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$COUIBaseListPopupWindow_12$dniMN-FK4i6uMMThUVP9jwrTQTc
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) throws SQLException {
                    this.COUIBaseListPopupWindow_12$0.m21884c(rect, c3353k, objArr);
                }
            });
            this.f20565y = 0L;
        }
        this.f20554n = false;
        this.f20556p = 0;
        this.f20563w = -1;
        this.f20549i = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m21890d(Rect rect, ModeInfo c3353k, Object[] objArr) throws SQLException {
        m21847a(rect, c3353k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m21884c(Rect rect, ModeInfo c3353k, Object[] objArr) throws SQLException {
        m21871b(rect, c3353k);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0179  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m21847a(android.graphics.Rect r16, final com.oplus.camera.p172ui.modepanel.ModeInfo r17) throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.modepanel.ItemDragHelper.m21847a(android.graphics.Rect, com.oplus.camera.ui.modepanel.OplusGLSurfaceView_5):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m21874b(boolean z, RecyclerView recyclerView, ModeInfo c3353k, int OplusGLSurfaceView_13) {
        CameraLog.m12967f("ItemDragHelper", "adsorpt, finalAdsorpt: " + z);
        final BaseModeInfoAdapter abstractC3343a = (BaseModeInfoAdapter) recyclerView.getAdapter();
        if (!z) {
            ModeInfo c3353kM21773b = abstractC3343a.m21773b(this.f20548h);
            c3353kM21773b.m21923b(0);
            c3353kM21773b.m21926c(this.f20541a.getColor(R.color.color_white_with_full_percent_transparency));
            abstractC3343a.notifyItemChanged(this.f20548h);
        } else {
            c3353k.m21923b(0);
            c3353k.m21926c(this.f20541a.getColor(R.color.color_white_with_full_percent_transparency));
            c3353k.m21931e(true);
            abstractC3343a.notifyItemChanged(OplusGLSurfaceView_13);
        }
        if (recyclerView == this.f20545e) {
            this.f20542b.m21831b();
        } else {
            this.f20546f.post(new Runnable() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$COUIBaseListPopupWindow_12$NymiioZp384awSCQNl6vsgJeMiw
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m21873b(abstractC3343a);
                }
            });
        }
        m21885c(this.f20545e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m21873b(BaseModeInfoAdapter abstractC3343a) {
        this.f20542b.m21831b();
        abstractC3343a.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a7  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m21871b(android.graphics.Rect r14, final com.oplus.camera.p172ui.modepanel.ModeInfo r15) throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.modepanel.ItemDragHelper.m21871b(android.graphics.Rect, com.oplus.camera.ui.modepanel.OplusGLSurfaceView_5):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m21853a(boolean z, RecyclerView recyclerView, ModeInfo c3353k, int OplusGLSurfaceView_13) {
        CameraLog.m12967f("ItemDragHelper", "adsorpt, finalAdsorpt: " + z);
        final BaseModeInfoAdapter abstractC3343a = (BaseModeInfoAdapter) recyclerView.getAdapter();
        if (!z) {
            ModeInfo c3353kM21773b = abstractC3343a.m21773b(this.f20548h);
            c3353kM21773b.m21923b(0);
            c3353kM21773b.m21926c(this.f20541a.getColor(R.color.color_white_with_full_percent_transparency));
            abstractC3343a.notifyItemChanged(this.f20548h);
        } else {
            c3353k.m21923b(0);
            c3353k.m21926c(this.f20541a.getColor(R.color.color_white_with_full_percent_transparency));
            c3353k.m21931e(true);
            abstractC3343a.notifyItemChanged(OplusGLSurfaceView_13);
        }
        if (recyclerView == this.f20545e) {
            this.f20542b.m21831b();
        } else {
            this.f20546f.post(new Runnable() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$COUIBaseListPopupWindow_12$mYHulACzkUqhq_pXcWGrp9EiGK0
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m21851a(abstractC3343a);
                }
            });
        }
        m21885c(this.f20545e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m21851a(BaseModeInfoAdapter abstractC3343a) {
        this.f20542b.m21831b();
        abstractC3343a.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c1  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m21854a(float r23, float r24) throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.modepanel.ItemDragHelper.m21854a(float, float):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m21839a(RecyclerView recyclerView, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        if (recyclerView != this.f20546f) {
            return OplusGLSurfaceView_13;
        }
        View viewM21887d = m21887d();
        View viewM21892e = m21892e();
        if (viewM21887d == null || viewM21892e == null) {
            if (viewM21887d != null || viewM21892e == null) {
                return OplusGLSurfaceView_13;
            }
            BaseModeInfoAdapter abstractC3343a = (BaseModeInfoAdapter) recyclerView.getAdapter();
            return abstractC3343a != null && abstractC3343a.m21773b(OplusGLSurfaceView_13) != null && 20 == abstractC3343a.m21773b(OplusGLSurfaceView_13).m21922b() ? OplusGLSurfaceView_13 - 1 : OplusGLSurfaceView_13;
        }
        Rect rectM21798c = DragHelperUtils.m21798c(viewM21887d, this.f20560t, this.f20561u);
        Rect rectM21798c2 = DragHelperUtils.m21798c(viewM21892e, this.f20560t, this.f20561u);
        int i2 = (rectM21798c.left + rectM21798c2.right) / 2;
        if (COUIBaseListPopupWindow_12 >= i2 && COUIBaseListPopupWindow_12 <= rectM21798c2.right) {
            OplusGLSurfaceView_13++;
        }
        CameraLog.m12967f("ItemDragHelper", "regulateHeadlineIndex, middle: " + i2 + ", touchRawX: " + COUIBaseListPopupWindow_12 + ", videoRect: " + rectM21798c + ", photoRect: " + rectM21798c2 + ", itemPos: " + OplusGLSurfaceView_13);
        return OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m21866b(RecyclerView recyclerView, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        if (recyclerView != this.f20546f) {
            return OplusGLSurfaceView_13;
        }
        View viewM21887d = m21887d();
        View viewM21892e = m21892e();
        if (viewM21887d == null || viewM21892e == null) {
            if (viewM21887d != null || viewM21892e == null) {
                return OplusGLSurfaceView_13;
            }
            BaseModeInfoAdapter abstractC3343a = (BaseModeInfoAdapter) recyclerView.getAdapter();
            return abstractC3343a != null && abstractC3343a.m21773b(OplusGLSurfaceView_13) != null && 20 == abstractC3343a.m21773b(OplusGLSurfaceView_13).m21922b() ? OplusGLSurfaceView_13 - 1 : OplusGLSurfaceView_13;
        }
        Rect rectM21798c = DragHelperUtils.m21798c(viewM21887d, this.f20560t, this.f20561u);
        Rect rectM21798c2 = DragHelperUtils.m21798c(viewM21892e, this.f20560t, this.f20561u);
        int i2 = (rectM21798c.top + rectM21798c2.bottom) / 2;
        if (COUIBaseListPopupWindow_12 >= i2 && COUIBaseListPopupWindow_12 <= rectM21798c2.bottom) {
            OplusGLSurfaceView_13++;
        }
        CameraLog.m12967f("ItemDragHelper", "regulateVerticalHeadlineIndex, middle: " + i2 + ", touchRawY: " + COUIBaseListPopupWindow_12 + ", videoRect: " + rectM21798c + ", photoRect: " + rectM21798c2 + ", itemPos: " + OplusGLSurfaceView_13);
        return OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m21878c(RecyclerView recyclerView, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        if (this.f20561u != 90) {
            COUIBaseListPopupWindow_12 = ScreenModeConst.f16035b - COUIBaseListPopupWindow_12;
        }
        return m21866b(recyclerView, COUIBaseListPopupWindow_12, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private View m21887d() {
        int childCount = this.f20546f.getLayoutManager().getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = this.f20546f.getLayoutManager().getChildAt(OplusGLSurfaceView_13);
            if (((ModeInfo) childAt.getTag(R.id_renamed.tag_recycle_view_mode_info)).m21922b() == 21) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private View m21892e() {
        int childCount = this.f20546f.getLayoutManager().getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = this.f20546f.getLayoutManager().getChildAt(OplusGLSurfaceView_13);
            if (((ModeInfo) childAt.getTag(R.id_renamed.tag_recycle_view_mode_info)).m21922b() == 20) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private View m21844a(RecyclerView recyclerView, float COUIBaseListPopupWindow_12, float f2) {
        View viewFindChildViewUnder = recyclerView.findChildViewUnder(COUIBaseListPopupWindow_12, f2);
        if (viewFindChildViewUnder != null) {
            return viewFindChildViewUnder;
        }
        int childCount = recyclerView.getLayoutManager().getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = recyclerView.getLayoutManager().getChildAt(OplusGLSurfaceView_13);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f2 >= childAt.getTop() + translationY && f2 <= childAt.getBottom() + translationY && COUIBaseListPopupWindow_12 < childAt.getLeft() + translationX) {
                if (childAt.getVisibility() == 0) {
                    return childAt;
                }
                return null;
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private View m21870b(RecyclerView recyclerView, float COUIBaseListPopupWindow_12, float f2) {
        View viewFindChildViewUnder = recyclerView.findChildViewUnder(COUIBaseListPopupWindow_12, f2);
        if (viewFindChildViewUnder != null) {
            return viewFindChildViewUnder;
        }
        int childCount = recyclerView.getLayoutManager().getChildCount() - 1;
        for (int OplusGLSurfaceView_13 = childCount; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            View childAt = recyclerView.getLayoutManager().getChildAt(OplusGLSurfaceView_13);
            float translationX = childAt.getTranslationX();
            if (OplusGLSurfaceView_13 == 0 && COUIBaseListPopupWindow_12 <= childAt.getLeft() + translationX) {
                return childAt;
            }
            if (COUIBaseListPopupWindow_12 >= childAt.getLeft() + translationX && COUIBaseListPopupWindow_12 <= childAt.getRight() + translationX) {
                return childAt;
            }
        }
        View childAt2 = recyclerView.getLayoutManager().getChildAt(childCount);
        if (childAt2 == null) {
            return null;
        }
        if (COUIBaseListPopupWindow_12 > childAt2.getRight() + childAt2.getTranslationX()) {
            return childAt2;
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private View m21881c(RecyclerView recyclerView, float COUIBaseListPopupWindow_12, float f2) {
        View viewFindChildViewUnder = recyclerView.findChildViewUnder(COUIBaseListPopupWindow_12, f2);
        if (viewFindChildViewUnder != null) {
            return viewFindChildViewUnder;
        }
        int childCount = recyclerView.getLayoutManager().getChildCount() - 1;
        for (int OplusGLSurfaceView_13 = childCount; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            View childAt = recyclerView.getLayoutManager().getChildAt(OplusGLSurfaceView_13);
            float translationY = childAt.getTranslationY();
            if (OplusGLSurfaceView_13 == 0 && f2 <= childAt.getTop() + translationY) {
                return childAt;
            }
            if (f2 >= childAt.getTop() + translationY && f2 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        View childAt2 = recyclerView.getLayoutManager().getChildAt(childCount);
        if (f2 > childAt2.getBottom() + childAt2.getTranslationY()) {
            return childAt2;
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21850a(RecyclerView recyclerView, View view, int OplusGLSurfaceView_13) {
        recyclerView.getLayoutManager();
        if (this.f20548h == 0 || OplusGLSurfaceView_13 == 0) {
            recyclerView.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public float[] m21891d(RecyclerView recyclerView, float COUIBaseListPopupWindow_12, float f2) {
        return this.f20539A.mo16411a().mo16530a(recyclerView, COUIBaseListPopupWindow_12, f2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m21841a(RecyclerView recyclerView, View view, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, float f2) {
        BaseModeInfoAdapter abstractC3343a = (BaseModeInfoAdapter) recyclerView.getAdapter();
        if (abstractC3343a == null || (OplusGLSurfaceView_13 == -1 && abstractC3343a.getItemCount() == 0)) {
            return 0;
        }
        if (view == null) {
            return OplusGLSurfaceView_13;
        }
        if (recyclerView == this.f20545e) {
            if (1 == this.f20560t) {
                if (view.getRight() >= COUIBaseListPopupWindow_12) {
                    return OplusGLSurfaceView_13;
                }
            } else if (view.getTop() + (view.getHeight() * this.f20551k) >= f2) {
                return OplusGLSurfaceView_13;
            }
        } else if (1 == this.f20560t) {
            if (view.getBottom() >= f2) {
                return OplusGLSurfaceView_13;
            }
        } else if (view.getRight() >= COUIBaseListPopupWindow_12) {
            return OplusGLSurfaceView_13;
        }
        return OplusGLSurfaceView_13 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m21857a(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
        RecyclerView recyclerView2;
        if (!this.f20542b.m21832c()) {
            return false;
        }
        RecyclerView.AbstractC0693i layoutManager = recyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        View childAt = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            childAt = recyclerView.getLayoutManager().getChildAt(i3);
            if (childAt != null) {
                break;
            }
        }
        if (childAt == null) {
            return false;
        }
        Rect rectM21798c = DragHelperUtils.m21798c(childAt, this.f20560t, this.f20561u);
        if (this.f20558r < rectM21798c.top || this.f20558r > rectM21798c.bottom) {
            CameraLog.m12967f("ItemDragHelper", "scrollIfNecessary, mLastTouchRawY: " + this.f20558r + ", rect: " + rectM21798c);
            return false;
        }
        int iM21795b = layoutManager.canScrollHorizontally() ? DragHelperUtils.m21795b(recyclerView, OplusGLSurfaceView_13, i2) : 0;
        int iM21791a = layoutManager.canScrollVertically() ? DragHelperUtils.m21791a(recyclerView, OplusGLSurfaceView_13, i2) : 0;
        if (iM21795b != 0 && recyclerView == (recyclerView2 = this.f20546f) && recyclerView2.getLayoutManager() != null) {
            BaseModeInfoAdapter abstractC3343a = (BaseModeInfoAdapter) recyclerView.getAdapter();
            if (abstractC3343a == null) {
                return false;
            }
            int itemCount = abstractC3343a.getItemCount();
            if (iM21795b > 0 && abstractC3343a.m21773b(itemCount - 1).m21922b() == this.f20542b.m21826a()) {
                View childAt2 = recyclerView.getChildAt(childCount - 1);
                Rect rectM21798c2 = DragHelperUtils.m21798c(childAt2, this.f20560t, this.f20561u);
                int position = recyclerView.getLayoutManager().getPosition(childAt2);
                if (rectM21798c2.right < (Util.getScreenWidth() / 4.0f) * 3.0f && position == itemCount - 2) {
                    return false;
                }
            }
            if (iM21795b < 0 && abstractC3343a.m21773b(0).m21922b() == this.f20542b.m21826a()) {
                View childAt3 = recyclerView.getChildAt(0);
                Rect rectM21798c3 = DragHelperUtils.m21798c(childAt3, this.f20560t, this.f20561u);
                int position2 = recyclerView.getLayoutManager().getPosition(childAt3);
                if (rectM21798c3.left > (Util.getScreenWidth() / 4.0f) * 1.0f && position2 == 0) {
                    return false;
                }
            }
        }
        if (iM21795b != 0 || iM21791a != 0) {
            recyclerView.scrollBy(iM21795b, iM21791a);
        }
        return (iM21795b == 0 && iM21791a == 0) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m21840a(RecyclerView recyclerView, View view, float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13, int i2) {
        int iM21838a = m21838a(view);
        boolean z = 1 == this.f20560t;
        if (iM21838a == -1) {
            if (recyclerView == this.f20546f && view == null) {
                View childAt = this.f20546f.getLayoutManager().getChildAt(recyclerView.getLayoutManager().getChildCount() - 1);
                if (childAt == null) {
                    return -1;
                }
                if (!z && COUIBaseListPopupWindow_12 >= childAt.getRight() + childAt.getTranslationX() && f2 >= childAt.getTop() + childAt.getTranslationY() && f2 <= childAt.getBottom() + childAt.getTranslationY()) {
                    return this.f20546f.getAdapter().getItemCount();
                }
                if (z && COUIBaseListPopupWindow_12 >= childAt.getLeft() + childAt.getTranslationX() && COUIBaseListPopupWindow_12 <= childAt.getRight() + childAt.getTranslationX() && f2 >= childAt.getBottom() + childAt.getTranslationY()) {
                    return this.f20546f.getAdapter().getItemCount();
                }
            }
            return -1;
        }
        if (iM21838a == this.f20548h && OplusGLSurfaceView_13 == i2) {
            return -1;
        }
        return iM21838a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21860a(RecyclerView recyclerView, View view, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, float f2) {
        if (!this.f20542b.m21832c()) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f20562v < ViewConfiguration.getLongPressTimeout()) {
            CameraLog.m12967f("ItemDragHelper", "isItemNeedChange, time interval does not meet the requirements, no transposition is allowed, interval: " + (jCurrentTimeMillis - this.f20562v));
            return false;
        }
        if (recyclerView == this.f20545e) {
            return m21858a(recyclerView, view, OplusGLSurfaceView_13, i2);
        }
        if (1 == this.f20560t) {
            return m21877b(recyclerView, view, OplusGLSurfaceView_13, i2, f2);
        }
        return m21859a(recyclerView, view, OplusGLSurfaceView_13, i2, COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21858a(RecyclerView recyclerView, View view, int OplusGLSurfaceView_13, int i2) {
        if (view != null && OplusGLSurfaceView_13 != -1 && i2 != -1 && OplusGLSurfaceView_13 != i2) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (recyclerView == this.f20546f && jCurrentTimeMillis - this.f20565y < ViewConfiguration.getLongPressTimeout() * 2) {
                return false;
            }
            this.f20565y = jCurrentTimeMillis;
            Rect rectM21836g = this.f20542b.m21836g();
            Rect rectM21798c = DragHelperUtils.m21798c(view, this.f20560t, this.f20561u);
            if (rectM21836g != null && rectM21798c != null) {
                if (4 == this.f20560t) {
                    if (rectM21798c.height() > Math.abs(rectM21836g.centerX() - rectM21798c.centerX()) || rectM21798c.height() > Math.abs(rectM21836g.centerY() - rectM21798c.centerY())) {
                        return true;
                    }
                } else if (rectM21798c.width() > Math.abs(rectM21836g.centerX() - rectM21798c.centerX()) || rectM21798c.width() > Math.abs(rectM21836g.centerY() - rectM21798c.centerY())) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21859a(RecyclerView recyclerView, View view, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        if (view == null || OplusGLSurfaceView_13 == -1 || i2 == -1 || OplusGLSurfaceView_13 == i2 || recyclerView.getScrollState() != 0) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f20542b.m21836g() == null) {
            return false;
        }
        if (4 != this.f20560t) {
            float fM21837h = (((r6.top + this.f20542b.m21837h()) + r6.bottom) + this.f20542b.m21837h()) / 2.0f;
            if (fM21837h <= this.f20552l || fM21837h > r6 + DimenConstants.m14496n()) {
                return false;
            }
        }
        this.f20565y = jCurrentTimeMillis;
        if (OplusGLSurfaceView_13 > i2) {
            if (COUIBaseListPopupWindow_12 < view.getRight() - (view.getWidth() * this.f20550j)) {
                return true;
            }
        } else if (COUIBaseListPopupWindow_12 > view.getLeft() + (view.getWidth() * this.f20550j)) {
            return true;
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m21877b(RecyclerView recyclerView, View view, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        if (view == null || OplusGLSurfaceView_13 == -1 || i2 == -1 || OplusGLSurfaceView_13 == i2 || recyclerView.getScrollState() != 0) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f20542b.m21836g() == null) {
            return false;
        }
        this.f20565y = jCurrentTimeMillis;
        if (OplusGLSurfaceView_13 > i2) {
            if (COUIBaseListPopupWindow_12 < view.getBottom() - (view.getHeight() * this.f20550j)) {
                return true;
            }
        } else if (COUIBaseListPopupWindow_12 > view.getTop() + (view.getHeight() * this.f20550j)) {
            return true;
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m21838a(View view) {
        if (view == null) {
            CameraLog.m12967f("ItemDragHelper", "getPositionByChildView, but itemView is null.");
            return -1;
        }
        try {
            return ((RecyclerView.C0694j) view.getLayoutParams()).m4158g();
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("ItemDragHelper", "getPositionByChildView error.", COUIBaseListPopupWindow_8);
            return -1;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m21900a() {
        return this.f20542b.m21832c();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m21901b() {
        return this.f20542b.m21833d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21856a(View view, ModeInfo c3353k) {
        boolean zM21796b = DragHelperUtils.m21796b(c3353k);
        if (zM21796b) {
            c3353k.m21923b(4);
            view.setVisibility(4);
        }
        return zM21796b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21861a(RecyclerView recyclerView, RecyclerView recyclerView2, int OplusGLSurfaceView_13, int i2, ModeInfo c3353k) throws SQLException {
        int i3 = 0;
        if (!DragHelperUtils.m21792a(c3353k)) {
            CameraLog.m12967f("ItemDragHelper", "changeRecycler, " + c3353k.m21919a() + " don't support change host.");
            return false;
        }
        if (OplusGLSurfaceView_13 < 0) {
            CameraLog.m12967f("ItemDragHelper", "changeRecycler, fItemFromPos: " + OplusGLSurfaceView_13 + " is invalid.");
            return false;
        }
        BaseModeInfoAdapter abstractC3343a = (BaseModeInfoAdapter) recyclerView2.getAdapter();
        abstractC3343a.m21770a(i2, c3353k);
        List<ModeInfo> listM21776c = abstractC3343a.m21776c();
        ((BaseModeInfoAdapter) recyclerView.getAdapter()).m21768a(OplusGLSurfaceView_13);
        recyclerView.invalidateItemDecorations();
        DataBaseOperator.m21777a().m21784a(c3353k.m21922b(), recyclerView2 == this.f20546f ? "position_headline" : "position_mode_panel");
        Iterator<ModeInfo> it = listM21776c.iterator();
        while (it.hasNext()) {
            DataBaseOperator.m21777a().m21783a(it.next().m21922b(), i3, true);
            i3++;
        }
        CameraLog.m12967f("ItemDragHelper", "changeRecycler, id_renamed: " + c3353k.m21922b() + ", fItemFromPos: " + OplusGLSurfaceView_13 + ", fItemToPos: " + i2);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m21885c(final RecyclerView recyclerView) {
        int iM14494l;
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (itemCount <= MoreUIControl.f20631a * 1) {
            iM14494l = DimenConstants.m14490h();
        } else if (itemCount > MoreUIControl.f20631a * 1 && itemCount <= MoreUIControl.f20631a * 2) {
            iM14494l = DimenConstants.m14491i();
        } else if (itemCount > MoreUIControl.f20631a * 2 && itemCount <= MoreUIControl.f20631a * 3) {
            iM14494l = DimenConstants.m14492j();
        } else if (itemCount > MoreUIControl.f20631a * 3 && itemCount <= MoreUIControl.f20631a * 4) {
            iM14494l = DimenConstants.m14493k();
        } else if (itemCount <= MoreUIControl.f20631a * 4 || itemCount <= MoreUIControl.f20631a * 5) {
            iM14494l = DimenConstants.m14494l();
        } else {
            iM14494l = DimenConstants.m14494l();
        }
        final ConstraintLayout.C0398a c0398a = (ConstraintLayout.C0398a) recyclerView.getLayoutParams();
        if (c0398a.topMargin == iM14494l) {
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(c0398a.topMargin, iM14494l);
        valueAnimatorOfInt.setInterpolator(PathInterpolatorCompat_2.m2772a(0.3f, 0.0f, 0.1f, 1.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$COUIBaseListPopupWindow_12$diUbNxd1Axia-04if1v_mBDIMk4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ItemDragHelper.m21849a(c0398a, recyclerView, valueAnimator);
            }
        });
        valueAnimatorOfInt.setDuration(200L);
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m21849a(ConstraintLayout.C0398a c0398a, RecyclerView recyclerView, ValueAnimator valueAnimator) {
        c0398a.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        recyclerView.setLayoutParams(c0398a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        r7 = true;
     */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m21876b(androidx.recyclerview.widget.RecyclerView r8, int r9, int r10) throws android.database.SQLException {
        /*
            r7 = this;
            androidx.recyclerview.widget.RecyclerView$PlatformImplementations.kt_3 r0 = r8.getAdapter()
            com.oplus.camera.ui.modepanel.PlatformImplementations.kt_3 r0 = (com.oplus.camera.p172ui.modepanel.BaseModeInfoAdapter) r0
            androidx.recyclerview.widget.RecyclerView r7 = r7.f20546f
            java.lang.String r1 = ", toPos: "
            java.lang.String r2 = "ItemDragHelper"
            r3 = 0
            r4 = 1
            if (r8 != r7) goto L4c
            if (r9 >= r10) goto L22
            com.oplus.camera.ui.modepanel.OplusGLSurfaceView_5 r7 = r0.m21773b(r10)
            int r7 = r7.m21922b()
            r5 = 21
            if (r7 != r5) goto L20
        L1e:
            r7 = r4
            goto L2f
        L20:
            r7 = r3
            goto L2f
        L22:
            com.oplus.camera.ui.modepanel.OplusGLSurfaceView_5 r7 = r0.m21773b(r10)
            int r7 = r7.m21922b()
            r5 = 20
            if (r7 != r5) goto L20
            goto L1e
        L2f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "changeItem, no mode are allowed to be inserted between the video and capture mode, fromPos: "
            r5.append(r6)
            r5.append(r9)
            r5.append(r1)
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            com.oplus.camera.CameraLog.m12954a(r2, r5)
            if (r7 == 0) goto L4c
            return r3
        L4c:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r5 = "changeItem, fromPos: "
            r7.append(r5)
            r7.append(r9)
            r7.append(r1)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            com.oplus.camera.CameraLog.m12967f(r2, r7)
            r0.m21769a(r9, r10)
            r8.invalidateItemDecorations()
            java.util.List r7 = r0.m21776c()
            java.util.Iterator r7 = r7.iterator()
        L74:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L8d
            java.lang.Object r8 = r7.next()
            com.oplus.camera.ui.modepanel.OplusGLSurfaceView_5 r8 = (com.oplus.camera.p172ui.modepanel.ModeInfo) r8
            com.oplus.camera.ui.modepanel.IntrinsicsJvm.kt_4 r9 = com.oplus.camera.p172ui.modepanel.DataBaseOperator.m21777a()
            int r8 = r8.m21922b()
            r9.m21783a(r8, r3, r4)
            int r3 = r3 + r4
            goto L74
        L8d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.modepanel.ItemDragHelper.m21876b(androidx.recyclerview.widget.RecyclerView, int, int):boolean");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m21883c(final Rect rect, final ModeInfo c3353k) {
        if (rect == null || rect.width() < DimenConstants.m14489g() || rect.height() < DimenConstants.m14489g()) {
            CameraLog.m12967f("ItemDragHelper", "handleDragUI, floatRect: " + rect + " is invalid.");
            return;
        }
        this.f20539A.mo16411a().mo16535c(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$COUIBaseListPopupWindow_12$hmiAkvk-CI-Zs-hS4rbHeZj-v_Q
            @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
            public final void call(Object[] objArr) {
                this.COUIBaseListPopupWindow_12$0.m21872b(rect, c3353k, objArr);
            }
        }, new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$COUIBaseListPopupWindow_12$99Lpj3Rv3guSo9zVFsK-zG8Xc-0
            @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
            public final void call(Object[] objArr) throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m21848a(rect, c3353k, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m21872b(Rect rect, ModeInfo c3353k, Object[] objArr) {
        m21889d(rect, c3353k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m21848a(Rect rect, ModeInfo c3353k, Object[] objArr) throws Resources.NotFoundException {
        m21894e(rect, c3353k);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m21889d(Rect rect, ModeInfo c3353k) {
        if (rect.centerY() >= this.f20552l && DragHelperUtils.m21792a(c3353k)) {
            this.f20542b.m21834e();
        } else if (rect.bottom <= this.f20552l) {
            this.f20542b.m21835f();
        }
        if (rect.centerY() < this.f20552l || DragHelperUtils.m21792a(c3353k) || this.f20554n) {
            return;
        }
        this.f20554n = true;
        Toast.makeText(this.f20541a, R.string.camera_mode_arrange_not_support_drag, 0).show();
        CameraUIListener cameraUIListener = this.f20547g;
        if (cameraUIListener != null) {
            cameraUIListener.mo10750b(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_IMMOVABLE_MODE);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m21894e(Rect rect, ModeInfo c3353k) throws Resources.NotFoundException {
        boolean zA = this.f20539A.mo16411a().mo16555a(this.f20541a, rect);
        boolean zB = this.f20539A.mo16411a().mo16561b(this.f20541a, rect);
        if (zB && DragHelperUtils.m21792a(c3353k)) {
            this.f20542b.m21834e();
        } else if (zA) {
            this.f20542b.m21835f();
        }
        if (!zB || DragHelperUtils.m21792a(c3353k) || this.f20554n) {
            return;
        }
        this.f20554n = true;
        Toast toastMakeText = Toast.makeText(this.f20541a, R.string.camera_mode_arrange_not_support_drag, 0);
        int OplusGLSurfaceView_13 = this.f20560t;
        if ((1 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13) && this.f20547g.mo10769bL() != null) {
            int iK = this.f20547g.mo10769bL().mo16570k();
            if (iK == 90) {
                toastMakeText.setGravity(8388627, 0, -Util.m24460i(R.dimen.camera_mode_arrange_not_support_drag_yOffset));
                View view = toastMakeText.getView();
                view.setRotation(90.0f);
                view.setElevation(300.0f);
            } else if (iK == 270) {
                toastMakeText.setGravity(8388629, 0, -Util.m24460i(R.dimen.camera_mode_arrange_not_support_drag_yOffset));
                View view2 = toastMakeText.getView();
                view2.setRotation(270.0f);
                view2.setElevation(300.0f);
            }
        }
        toastMakeText.show();
        CameraUIListener cameraUIListener = this.f20547g;
        if (cameraUIListener != null) {
            cameraUIListener.mo10750b(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_IMMOVABLE_MODE);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Rect m21868b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            return null;
        }
        View childAt = this.f20546f.getLayoutManager().getChildAt(OplusGLSurfaceView_13);
        if (childAt == null) {
            Rect rectM21798c = DragHelperUtils.m21798c(this.f20546f.getLayoutManager().getChildAt(this.f20546f.getLayoutManager().getChildCount() - 1), this.f20560t, this.f20561u);
            if (4 == this.f20560t) {
                int iM14484b = rectM21798c.bottom + (DimenConstants.m14484b() * 2);
                return new Rect(rectM21798c.left, iM14484b, rectM21798c.right, this.f20555o.getWidth() + iM14484b);
            }
            int iM14484b2 = rectM21798c.right + (DimenConstants.m14484b() * 2);
            return new Rect(iM14484b2, rectM21798c.top, this.f20555o.getWidth() + iM14484b2, rectM21798c.bottom);
        }
        if (!this.f20546f.isAnimating()) {
            return DragHelperUtils.m21798c(childAt, this.f20560t, this.f20561u);
        }
        int iFindFirstVisibleItemPosition = ((LinearLayoutManager) this.f20546f.getLayoutManager()).findFirstVisibleItemPosition();
        if (this.f20549i != -1) {
            View childAt2 = this.f20546f.getLayoutManager().getChildAt(this.f20549i - iFindFirstVisibleItemPosition);
            View childAt3 = this.f20546f.getLayoutManager().getChildAt(this.f20548h - iFindFirstVisibleItemPosition);
            Rect rectM21798c2 = DragHelperUtils.m21798c(childAt2, this.f20560t, this.f20561u);
            Rect rectM21798c3 = DragHelperUtils.m21798c(childAt3, this.f20560t, this.f20561u);
            if (this.f20549i < this.f20548h) {
                int right = childAt.getRight();
                Rect rect = new Rect(right - rectM21798c2.width(), rectM21798c3.top, right, rectM21798c3.bottom);
                return Util.m24495t() ? m21843a(true, childAt2, childAt3, rectM21798c2, rectM21798c3, childAt, rect) : rect;
            }
            int left = childAt.getLeft();
            Rect rect2 = new Rect(left, rectM21798c3.top, rectM21798c2.width() + left, rectM21798c3.bottom);
            return Util.m24495t() ? m21843a(false, childAt2, childAt3, rectM21798c2, rectM21798c3, childAt, rect2) : rect2;
        }
        return DragHelperUtils.m21798c(childAt, this.f20560t, this.f20561u);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Rect m21880c(int OplusGLSurfaceView_13) {
        int width;
        int width2;
        int width3;
        int height;
        CameraLog.m12954a("ItemDragHelper", "getHeadlineTargetVertical, position: " + OplusGLSurfaceView_13);
        RecyclerView.AbstractC0693i layoutManager = this.f20546f.getLayoutManager();
        View viewFindViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(OplusGLSurfaceView_13) : null;
        int i2 = 0;
        if (viewFindViewByPosition != null) {
            int[] iArr = new int[2];
            viewFindViewByPosition.getLocationOnScreen(iArr);
            int i3 = this.f20560t;
            if (1 == i3 || 4 == i3) {
                int i4 = this.f20561u;
                if (90 == i4) {
                    int i5 = iArr[0];
                    int i6 = iArr[1];
                    int height2 = i5 - viewFindViewByPosition.getHeight();
                    width3 = viewFindViewByPosition.getWidth() + i6;
                    width = i5;
                    i2 = height2;
                    width2 = i6;
                } else if (270 == i4) {
                    i2 = iArr[0];
                    int i7 = iArr[1];
                    width2 = i7 - viewFindViewByPosition.getWidth();
                    width3 = i7;
                    width = viewFindViewByPosition.getHeight() + i2;
                } else {
                    width2 = iArr[1];
                    i2 = iArr[0];
                    width = viewFindViewByPosition.getWidth() + i2;
                    height = viewFindViewByPosition.getHeight();
                }
            } else {
                width2 = iArr[1];
                i2 = iArr[0];
                width = viewFindViewByPosition.getWidth() + i2;
                height = viewFindViewByPosition.getHeight();
            }
            width3 = height + width2;
        } else {
            width = 0;
            width2 = 0;
            width3 = 0;
        }
        if (viewFindViewByPosition == null) {
            return m21886d(OplusGLSurfaceView_13);
        }
        return new Rect(i2, width2, width, width3);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Rect m21886d(int OplusGLSurfaceView_13) {
        int iFindFirstVisibleItemPosition;
        int iM14484b;
        int height;
        int width;
        int i2;
        int width2;
        int width3;
        int iM14484b2;
        int height2;
        int width4;
        CameraLog.m12954a("ItemDragHelper", "getHeadlineNextTarget, position: " + OplusGLSurfaceView_13);
        RecyclerView.AbstractC0693i layoutManager = this.f20546f.getLayoutManager();
        int iCenterX = 0;
        if (layoutManager == null) {
            return new Rect(0, 0, 0, 0);
        }
        if (OplusGLSurfaceView_13 == layoutManager.getChildCount()) {
            iFindFirstVisibleItemPosition = OplusGLSurfaceView_13 - 1;
        } else {
            iFindFirstVisibleItemPosition = (OplusGLSurfaceView_13 >= layoutManager.getChildCount() || OplusGLSurfaceView_13 < 0) ? 0 : ((LinearLayoutManager) this.f20546f.getLayoutManager()).findFirstVisibleItemPosition() + 1;
        }
        if (4 == this.f20560t) {
            iFindFirstVisibleItemPosition = ((LinearLayoutManager) this.f20546f.getLayoutManager()).findLastVisibleItemPosition();
        }
        Rect rectM21880c = m21880c(iFindFirstVisibleItemPosition);
        int i3 = this.f20560t;
        if (1 == i3) {
            int i4 = this.f20561u;
            if (90 == i4) {
                iCenterX = DimenConstants.m14484b() + rectM21880c.right;
                int height3 = this.f20555o.getHeight() + iCenterX;
                width2 = rectM21880c.centerY() - (this.f20555o.getWidth() / 2);
                width3 = this.f20555o.getWidth() + width2;
                i2 = height3;
            } else if (270 == i4) {
                iM14484b2 = DimenConstants.m14484b() + rectM21880c.left;
                height2 = iM14484b2 - this.f20555o.getHeight();
                width2 = rectM21880c.centerY() - (this.f20555o.getWidth() / 2);
                width4 = this.f20555o.getWidth();
                int i5 = height2;
                width3 = width4 + width2;
                i2 = iM14484b2;
                iCenterX = i5;
            } else {
                iCenterX = rectM21880c.centerX() - (this.f20555o.getWidth() / 2);
                iM14484b = rectM21880c.top + DimenConstants.m14484b();
                height = iM14484b - this.f20555o.getHeight();
                width = this.f20555o.getWidth();
                i2 = width + iCenterX;
                int i6 = height;
                width3 = iM14484b;
                width2 = i6;
            }
        } else if (4 == i3) {
            int i7 = this.f20561u;
            if (90 == i7) {
                iM14484b2 = rectM21880c.right;
                height2 = rectM21880c.left;
                width2 = rectM21880c.bottom + DimenConstants.m14484b();
                width4 = this.f20555o.getWidth();
                int i52 = height2;
                width3 = width4 + width2;
                i2 = iM14484b2;
                iCenterX = i52;
            } else if (270 == i7) {
                int i8 = rectM21880c.right;
                int i9 = rectM21880c.left;
                int iM14484b3 = rectM21880c.top - DimenConstants.m14484b();
                width2 = iM14484b3 - this.f20555o.getWidth();
                i2 = i8;
                iCenterX = i9;
                width3 = iM14484b3;
            } else {
                i2 = 0;
                width2 = 0;
                width3 = 0;
            }
        } else {
            iCenterX = rectM21880c.centerX() - (this.f20555o.getWidth() / 2);
            iM14484b = rectM21880c.top + DimenConstants.m14484b();
            height = iM14484b - this.f20555o.getHeight();
            width = this.f20555o.getWidth();
            i2 = width + iCenterX;
            int i62 = height;
            width3 = iM14484b;
            width2 = i62;
        }
        return new Rect(iCenterX, width2, i2, width3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Rect m21842a(RecyclerView recyclerView, int OplusGLSurfaceView_13) {
        int iM14486d;
        int iM14486d2;
        int iM14486d3;
        int iM14487e;
        View viewFindViewByPosition = recyclerView.getLayoutManager().findViewByPosition(OplusGLSurfaceView_13);
        int i2 = 0;
        if (viewFindViewByPosition != null) {
            int[] iArr = new int[2];
            viewFindViewByPosition.getLocationOnScreen(iArr);
            int i3 = this.f20560t;
            if (1 == i3 || 4 == i3) {
                int i4 = this.f20561u;
                if (90 == i4) {
                    int i5 = iArr[0];
                    iM14486d = iArr[1];
                    int iM14487e2 = i5 - DimenConstants.m14487e();
                    iM14486d3 = DimenConstants.m14486d() + iM14486d;
                    iM14486d2 = i5;
                    i2 = iM14487e2;
                } else if (270 == i4) {
                    i2 = iArr[0];
                    int i6 = iArr[1];
                    iM14486d3 = i6;
                    iM14486d = i6 - DimenConstants.m14486d();
                    iM14486d2 = DimenConstants.m14487e() + i2;
                } else {
                    iM14486d = iArr[1];
                    i2 = iArr[0];
                    iM14486d2 = DimenConstants.m14486d() + i2;
                    iM14487e = DimenConstants.m14487e();
                }
            } else {
                iM14486d = iArr[1];
                i2 = iArr[0];
                iM14486d2 = DimenConstants.m14486d() + i2;
                iM14487e = DimenConstants.m14487e();
            }
            iM14486d3 = iM14487e + iM14486d;
        } else {
            iM14486d = 0;
            iM14486d2 = 0;
            iM14486d3 = 0;
        }
        if (OplusGLSurfaceView_13 == recyclerView.getChildCount()) {
            return m21869b(recyclerView, OplusGLSurfaceView_13);
        }
        return new Rect(i2, iM14486d, iM14486d2, iM14486d3);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Rect m21869b(RecyclerView recyclerView, int OplusGLSurfaceView_13) {
        int iM14485c;
        int iM14486d;
        int iM14486d2;
        int i2;
        int iM14486d3;
        if (OplusGLSurfaceView_13 % MoreUIControl.f20631a == 0) {
            Rect rectM21842a = m21842a(recyclerView, OplusGLSurfaceView_13 - MoreUIControl.f20631a);
            int i3 = this.f20561u;
            if (90 == i3) {
                iM14486d2 = rectM21842a.left;
                iM14485c = iM14486d2 - DimenConstants.m14487e();
                iM14486d = rectM21842a.top;
                i2 = rectM21842a.bottom;
            } else if (270 == i3) {
                iM14485c = rectM21842a.right;
                iM14486d2 = DimenConstants.m14487e() + iM14485c;
                iM14486d = rectM21842a.top;
                i2 = rectM21842a.bottom;
            } else {
                iM14485c = rectM21842a.left;
                iM14486d2 = rectM21842a.right;
                iM14486d = rectM21842a.bottom;
                iM14486d3 = DimenConstants.m14487e();
                i2 = iM14486d3 + iM14486d;
            }
        } else {
            Rect rectM21842a2 = m21842a(recyclerView, OplusGLSurfaceView_13 - 1);
            int i4 = this.f20561u;
            if (90 == i4) {
                iM14485c = rectM21842a2.left;
                iM14486d = DimenConstants.m14485c() + rectM21842a2.bottom;
                iM14486d2 = rectM21842a2.right;
                iM14486d3 = DimenConstants.m14486d();
                i2 = iM14486d3 + iM14486d;
            } else if (270 == i4) {
                iM14485c = rectM21842a2.left;
                int iM14485c2 = rectM21842a2.top - DimenConstants.m14485c();
                int i5 = rectM21842a2.right;
                iM14486d = iM14485c2 - DimenConstants.m14486d();
                i2 = iM14485c2;
                iM14486d2 = i5;
            } else {
                iM14485c = DimenConstants.m14485c() + rectM21842a2.right;
                iM14486d = rectM21842a2.top;
                iM14486d2 = DimenConstants.m14486d() + iM14485c;
                i2 = rectM21842a2.bottom;
            }
        }
        return new Rect(iM14485c, iM14486d, iM14486d2, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Rect m21843a(boolean z, View view, View view2, Rect rect, Rect rect2, View view3, Rect rect3) {
        if (z) {
            int OplusGLSurfaceView_13 = this.f20560t;
            if (4 == OplusGLSurfaceView_13) {
                int i2 = rect2.bottom;
                return new Rect(rect2.left, i2 - view.getWidth(), rect2.right, i2);
            }
            if (1 == OplusGLSurfaceView_13) {
                int[] iArr = new int[2];
                this.f20546f.getLocationOnScreen(iArr);
                if (5 == this.f20547g.mo10769bL().mo16572m()) {
                    return new Rect(iArr[0] + view3.getTop(), iArr[1] - view3.getRight(), iArr[0] + view3.getBottom(), iArr[1] - view3.getLeft());
                }
                if (6 == this.f20547g.mo10769bL().mo16572m()) {
                    return new Rect(iArr[0] - view3.getBottom(), iArr[1] + view3.getLeft(), iArr[0] - view3.getTop(), iArr[1] + view3.getRight());
                }
                return new Rect(iArr[0] + view3.getLeft(), iArr[1] + view3.getTop(), iArr[0] + view3.getRight(), iArr[1] + view3.getBottom());
            }
        } else {
            int i3 = this.f20560t;
            if (4 == i3) {
                int i4 = rect2.top;
                return new Rect(rect2.left, i4, rect2.right, view.getWidth() + i4);
            }
            if (1 == i3) {
                int[] iArr2 = new int[2];
                this.f20546f.getLocationOnScreen(iArr2);
                if (5 == this.f20547g.mo10769bL().mo16572m()) {
                    return new Rect(iArr2[0] + view3.getTop(), iArr2[1] - view3.getRight(), iArr2[0] + view3.getBottom(), iArr2[1] - view3.getLeft());
                }
                if (6 == this.f20547g.mo10769bL().mo16572m()) {
                    return new Rect(iArr2[0] - view3.getBottom(), iArr2[1] + view3.getLeft(), iArr2[0] - view3.getTop(), iArr2[1] + view3.getRight());
                }
                return new Rect(iArr2[0] + view3.getLeft(), iArr2[1] + view3.getTop(), iArr2[0] + view3.getRight(), iArr2[1] + view3.getBottom());
            }
        }
        return rect3;
    }
}
