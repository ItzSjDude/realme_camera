package com.oplus.camera.filmvideomode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coui.appcompat.widget.COUISwitch;
import com.oplus.camera.R;
import java.util.ArrayList;

/* compiled from: FilmSubMenuAdapter.java */
/* renamed from: com.oplus.camera.filmvideomode.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class FilmSubMenuAdapter extends BaseAdapter {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f13707a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ArrayList<FilmSubMenuItem> f13708b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private LayoutInflater f13709c;

    @Override // android.widget.Adapter
    public long getItemId(int OplusGLSurfaceView_13) {
        return 0L;
    }

    public FilmSubMenuAdapter(Context context, ArrayList<FilmSubMenuItem> arrayList) {
        this.f13707a = null;
        this.f13708b = null;
        this.f13709c = null;
        this.f13707a = context;
        this.f13709c = LayoutInflater.from(context);
        if (arrayList == null) {
            this.f13708b = new ArrayList<>();
        } else {
            this.f13708b = arrayList;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13648a(ArrayList<FilmSubMenuItem> arrayList) {
        this.f13708b = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13708b.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public FilmSubMenuItem getItem(int OplusGLSurfaceView_13) {
        return this.f13708b.get(OplusGLSurfaceView_13);
    }

    @Override // android.widget.Adapter
    public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
        final FilmSubMenuItem item = getItem(OplusGLSurfaceView_13);
        FrameLayout frameLayout = (FrameLayout) this.f13709c.inflate(R.layout.film_submenu_item, (ViewGroup) null);
        ((TextView) frameLayout.findViewById(R.id_renamed.submenu_item_title)).setText(item.m13653b());
        final COUISwitch cOUISwitch = (COUISwitch) frameLayout.findViewById(R.id_renamed.submenu_item_switch);
        cOUISwitch.setTag(item);
        cOUISwitch.setChecked(item.m13652a());
        cOUISwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.oplus.camera.filmvideomode.OplusGLSurfaceView_6.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                item.m13651a(z);
                cOUISwitch.setChecked(z);
                item.m13654c().mo13655a(z);
            }
        });
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.filmvideomode.OplusGLSurfaceView_6.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean z = !item.m13652a();
                item.m13651a(z);
                cOUISwitch.setChecked(z);
                item.m13654c().mo13655a(z);
            }
        });
        return frameLayout;
    }
}
