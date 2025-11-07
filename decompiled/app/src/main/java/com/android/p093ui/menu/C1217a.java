package com.android.p093ui.menu;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.MultiSelectListPreference;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.preference.COUIMultiSelectListPreferenceDialogFragment;
import com.coui.appcompat.widget.COUICheckBox;
import com.coui.appcompat.widget.toolbar.COUIActionMenuItemView;
import com.coui.appcompat.widget.toolbar.COUIToolbar;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.util.ToastUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: CameraWatermarkDisplayInfoDialog.java */
/* renamed from: com.android.ui.menu.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class C1217a extends COUIMultiSelectListPreferenceDialogFragment {

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Set<String> f6000e = new HashSet();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f6001f = false;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CharSequence[] f6002g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private CharSequence[] f6003h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private COUIActionMenuItemView f6004i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private PlatformImplementations.kt_3 f6005j = null;

    /* compiled from: CameraWatermarkDisplayInfoDialog.java */
    /* renamed from: com.android.ui.menu.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo6227a(String str);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo6228a(CharSequence charSequence, int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo6229a(CharSequence charSequence, Set<String> set);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, byte] */
    /* renamed from: PlatformImplementations.kt_3 */
    static /* synthetic */ boolean m6219a(C1217a c1217a, int OplusGLSurfaceView_13) {
        ?? r2 = (byte) (OplusGLSurfaceView_13 | (c1217a.f6001f ? 1 : 0));
        c1217a.f6001f = r2;
        return r2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static C1217a m6221b(String str) {
        C1217a c1217a = new C1217a();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        c1217a.setArguments(bundle);
        return c1217a;
    }

    @Override // com.coui.appcompat.preference.COUIMultiSelectListPreferenceDialogFragment, androidx.preference.MultiSelectListPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MultiSelectListPreference multiSelectListPreferenceM6223c = m6223c();
        if (multiSelectListPreferenceM6223c.m3778h() == null || multiSelectListPreferenceM6223c.m3779l() == null) {
            throw new IllegalStateException("requires an entries array and an entryValues array.");
        }
        if (bundle == null) {
            this.f6000e.clear();
            this.f6000e.addAll(multiSelectListPreferenceM6223c.m3780m());
            this.f6003h = multiSelectListPreferenceM6223c.m3779l();
            this.f6001f = false;
        } else {
            this.f6000e.clear();
            this.f6000e.addAll(bundle.getStringArrayList("CameraWatermarkDisplayInfoDialog.values"));
            this.f6001f = bundle.getBoolean("CameraWatermarkDisplayInfoDialog.changed", false);
            this.f6003h = bundle.getCharSequenceArray("CameraWatermarkDisplayInfoDialog.entryValues");
        }
        this.f6002g = multiSelectListPreferenceM6223c.m3778h();
    }

    @Override // androidx.preference.MultiSelectListPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("CameraWatermarkDisplayInfoDialog.values", new ArrayList<>(this.f6000e));
        bundle.putBoolean("CameraWatermarkDisplayInfoDialog.changed", this.f6001f);
        bundle.putCharSequenceArray("CameraWatermarkDisplayInfoDialog.entries", this.f6002g);
        bundle.putCharSequenceArray("CameraWatermarkDisplayInfoDialog.entryValues", this.f6003h);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private MultiSelectListPreference m6223c() {
        return (MultiSelectListPreference) m3930b();
    }

    @Override // androidx.preference.MultiSelectListPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3917a(AlertDialog.PlatformImplementations.kt_3 aVar) {
        super.mo3917a(aVar);
        int length = this.f6003h.length;
        boolean[] zArr = new boolean[length];
        if (this.f6005j != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
                zArr[OplusGLSurfaceView_13] = this.f6005j.mo6229a(this.f6003h[OplusGLSurfaceView_13], this.f6000e);
            }
        }
        aVar.setMultiChoiceItems(this.f6002g, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.android.ui.menu.PlatformImplementations.kt_3.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                if (z) {
                    C1217a c1217a = C1217a.this;
                    C1217a.m6219a(c1217a, c1217a.f6000e.add(C1217a.this.f6003h[i2].toString()) ? 1 : 0);
                } else {
                    C1217a c1217a2 = C1217a.this;
                    C1217a.m6219a(c1217a2, c1217a2.f6000e.remove(C1217a.this.f6003h[i2].toString()) ? 1 : 0);
                }
                if (C1217a.this.f6004i != null) {
                    C1217a.this.f6004i.setEnabled(!C1217a.this.f6000e.isEmpty());
                }
                if (C1217a.this.f6000e.isEmpty()) {
                    ToastUtil.m24642a(MyApplication.m11092d(), C1217a.this.getString(R.string.camera_setting_watermark_display_info_tip));
                }
            }
        });
    }

    @Override // com.coui.appcompat.preference.COUIMultiSelectListPreferenceDialogFragment, androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        COUIToolbar cOUIToolbar = (COUIToolbar) dialogOnCreateDialog.findViewById(R.id_renamed.toolbar);
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) dialogOnCreateDialog.findViewById(R.id_renamed.select_dialog_listview);
        this.f6004i = (COUIActionMenuItemView) cOUIToolbar.findViewById(R.id_renamed.menu_save);
        ViewGroup viewGroup = (ViewGroup) cOUIRecyclerView.getParent();
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4(getActivity());
        viewGroup.addView(bVar, new ViewGroup.MarginLayoutParams(-1, -1));
        viewGroup.removeView(cOUIRecyclerView);
        bVar.addView(cOUIRecyclerView, cOUIRecyclerView.getLayoutParams());
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        COUIActionMenuItemView cOUIActionMenuItemView = this.f6004i;
        if (cOUIActionMenuItemView != null) {
            cOUIActionMenuItemView.setEnabled(!this.f6000e.isEmpty());
        }
    }

    @Override // androidx.preference.MultiSelectListPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3911a(boolean z) {
        if (z && this.f6001f) {
            MultiSelectListPreference multiSelectListPreferenceM6223c = m6223c();
            if (multiSelectListPreferenceM6223c.m3831b((Object) this.f6000e)) {
                multiSelectListPreferenceM6223c.m3776a(this.f6000e);
            }
        }
        PlatformImplementations.kt_3 aVar = this.f6005j;
        if (aVar != null) {
            aVar.mo6227a(z ? "0" : "1");
        }
        this.f6001f = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f6005j = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6226a(PlatformImplementations.kt_3 aVar) {
        this.f6005j = aVar;
    }

    /* compiled from: CameraWatermarkDisplayInfoDialog.java */
    /* renamed from: com.android.ui.menu.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public class IntrinsicsJvm.kt_4 extends LinearLayout {
        public IntrinsicsJvm.kt_4(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (getChildAt(0) instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) getChildAt(0);
                int childCount = recyclerView.getChildCount();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    if (OplusGLSurfaceView_13 >= childCount) {
                        break;
                    }
                    ViewGroup viewGroup = (ViewGroup) recyclerView.getChildAt(OplusGLSurfaceView_13);
                    Rect rect = new Rect();
                    viewGroup.getHitRect(rect);
                    if (rect.contains(x, y)) {
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            View childAt = viewGroup.getChildAt(i2);
                            if (childAt instanceof COUICheckBox) {
                                return C1217a.this.f6005j.mo6228a(C1217a.this.f6002g[OplusGLSurfaceView_13], ((COUICheckBox) childAt).getState());
                            }
                        }
                    } else {
                        OplusGLSurfaceView_13++;
                    }
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }
}
