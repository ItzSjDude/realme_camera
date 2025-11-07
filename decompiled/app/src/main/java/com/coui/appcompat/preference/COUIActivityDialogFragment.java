package com.coui.appcompat.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.p027a.ContextCompat;
import androidx.core.p036h.ViewCompat;
import androidx.preference.ListPreferenceDialogFragmentCompat;
import com.coui.appcompat.p099a.COUIDarkModeUtil;
import com.coui.appcompat.p099a.COUIVersionUtil;
import com.coui.appcompat.widget.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import coui.support.appcompat.R;

/* compiled from: COUIActivityDialogFragment.java */
/* renamed from: com.coui.appcompat.preference.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class COUIActivityDialogFragment extends ListPreferenceDialogFragmentCompat {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private AppCompatDialog f7049b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f7050c;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static COUIActivityDialogFragment m6951b(String str) {
        COUIActivityDialogFragment c1342a = new COUIActivityDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        c1342a.setArguments(bundle);
        return c1342a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private COUIActivityDialogPreference m6953c() {
        return (COUIActivityDialogPreference) m3930b();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) throws Resources.NotFoundException, ClassNotFoundException {
        int OplusGLSurfaceView_13;
        final AppCompatDialog dialogC0208f = new AppCompatDialog(getActivity(), R.style.Theme_COUI_ActivityDialog) { // from class: com.coui.appcompat.preference.PlatformImplementations.kt_3.1
            @Override // android.app.Dialog, android.view.Window.Callback
            public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
                if (menuItem.getItemId() == 16908332) {
                    dismiss();
                    return true;
                }
                return super.onMenuItemSelected(i2, menuItem);
            }
        };
        this.f7049b = dialogC0208f;
        if (dialogC0208f.getWindow() != null) {
            Window window = dialogC0208f.getWindow();
            View decorView = window.getDecorView();
            if (Build.VERSION.SDK_INT >= 21) {
                decorView.setSystemUiVisibility(1024);
                window.setStatusBarColor(0);
                window.setNavigationBarColor(getResources().getColor(R.color.coui_dialog_fragment_navigation_bar_color));
            }
            int systemUiVisibility = decorView.getSystemUiVisibility();
            int iM6500a = COUIVersionUtil.m6500a();
            boolean z = getResources().getBoolean(R.bool.list_status_white_enabled);
            if (iM6500a >= 6 || iM6500a == 0) {
                window.addFlags(Integer.MIN_VALUE);
                if (COUIDarkModeUtil.m6401a(dialogC0208f.getContext())) {
                    OplusGLSurfaceView_13 = systemUiVisibility & (-8193) & (-17);
                } else {
                    OplusGLSurfaceView_13 = Build.VERSION.SDK_INT >= 23 ? !z ? systemUiVisibility | 8192 : systemUiVisibility | 256 : systemUiVisibility | 16;
                }
                decorView.setSystemUiVisibility(OplusGLSurfaceView_13);
            }
        }
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.coui_preference_listview, (ViewGroup) null);
        COUIToolbar cOUIToolbar = (COUIToolbar) viewInflate.findViewById(R.id_renamed.toolbar);
        cOUIToolbar.setNavigationIcon(ContextCompat.m2248a(cOUIToolbar.getContext(), R.drawable.coui_back_arrow));
        cOUIToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.PlatformImplementations.kt_3.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                COUIActivityDialogFragment.this.f7049b.dismiss();
            }
        });
        final AppBarLayout appBarLayout = (AppBarLayout) viewInflate.findViewById(R.id_renamed.abl);
        final ListView listView = (ListView) viewInflate.findViewById(R.id_renamed.coui_preference_listview);
        View viewFindViewById = viewInflate.findViewById(R.id_renamed.divider_line);
        if (getResources().getBoolean(R.bool.is_dialog_preference_immersive)) {
            viewFindViewById.setVisibility(8);
        }
        ViewCompat.m2875c((View) listView, true);
        View viewM6952c = m6952c(appBarLayout.getContext());
        appBarLayout.addView(viewM6952c, 0, viewM6952c.getLayoutParams());
        appBarLayout.post(new Runnable() { // from class: com.coui.appcompat.preference.PlatformImplementations.kt_3.3
            @Override // java.lang.Runnable
            public void run() {
                int measuredHeight = appBarLayout.getMeasuredHeight() + COUIActivityDialogFragment.this.getResources().getDimensionPixelSize(R.dimen.support_preference_listview_margin_top);
                View view = new View(appBarLayout.getContext());
                view.setVisibility(4);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, measuredHeight));
                listView.addHeaderView(view);
            }
        });
        if (m6953c() != null) {
            this.f7050c = m6953c().m3766b(m6953c().m3770o());
            cOUIToolbar.setTitle(m6953c().m3737a());
            listView.setAdapter((ListAdapter) new PlatformImplementations.kt_3(getActivity(), R.layout.coui_preference_listview_item, R.id_renamed.checkedtextview, m6953c().m3767l()) { // from class: com.coui.appcompat.preference.PlatformImplementations.kt_3.4
                @Override // android.widget.ArrayAdapter, android.widget.Adapter
                public View getView(int i2, View view, ViewGroup viewGroup) {
                    View view2 = super.getView(i2, view, viewGroup);
                    if (i2 == COUIActivityDialogFragment.this.f7050c) {
                        ListView listView2 = listView;
                        listView2.setItemChecked(listView2.getHeaderViewsCount() + i2, true);
                    }
                    View viewFindViewById2 = view2.findViewById(R.id_renamed.itemdiver);
                    int count = getCount();
                    if (viewFindViewById2 != null) {
                        if (count == 1 || i2 == count - 1) {
                            viewFindViewById2.setVisibility(8);
                        } else {
                            viewFindViewById2.setBackgroundResource(R.drawable.coui_divider_preference_default);
                        }
                    }
                    return view2;
                }
            });
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coui.appcompat.preference.PlatformImplementations.kt_3.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long OplusGLSurfaceView_15) {
                COUIActivityDialogFragment.this.f7050c = i2 - listView.getHeaderViewsCount();
                COUIActivityDialogFragment.this.onClick(null, -1);
                dialogC0208f.dismiss();
            }
        });
        listView.setChoiceMode(1);
        dialogC0208f.setContentView(viewInflate);
        return dialogC0208f;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private View m6952c(Context context) {
        int iM6949b = m6949b(context);
        ImageView imageView = new ImageView(context);
        imageView.setBackground(getResources().getDrawable(R.drawable.coui_list_statusbar_bg));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, iM6949b));
        return imageView;
    }

    /* compiled from: COUIActivityDialogFragment.java */
    /* renamed from: com.coui.appcompat.preference.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        PlatformImplementations.kt_3(Context context, int OplusGLSurfaceView_13, int i2, CharSequence[] charSequenceArr) {
            super(context, OplusGLSurfaceView_13, i2, charSequenceArr);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m6949b(Context context) {
        int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        return -1;
    }

    @Override // androidx.preference.ListPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3911a(boolean z) {
        COUIActivityDialogPreference cOUIActivityDialogPreferenceM6953c = m6953c();
        if (!z || this.f7050c < 0) {
            return;
        }
        String string = m6953c().m3768m()[this.f7050c].toString();
        if (cOUIActivityDialogPreferenceM6953c.m3831b((Object) string)) {
            cOUIActivityDialogPreferenceM6953c.m3765a(string);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (m3930b() == null) {
            dismiss();
        }
    }
}
