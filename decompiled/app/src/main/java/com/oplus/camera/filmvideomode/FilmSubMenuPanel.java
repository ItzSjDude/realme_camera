package com.oplus.camera.filmvideomode;

import android.content.Context;
import android.widget.ListView;
import com.oplus.camera.R;

/* compiled from: FilmSubMenuPanel.java */
/* renamed from: com.oplus.camera.filmvideomode.o */
/* loaded from: classes2.dex */
public class FilmSubMenuPanel extends ListView {

    /* renamed from: PlatformImplementations.kt_3 */
    private FilmSubMenuAdapter f13719a;

    public FilmSubMenuPanel(Context context) {
        super(context);
        this.f13719a = null;
        setDivider(null);
        setDividerHeight(context.getResources().getDimensionPixelSize(R.dimen.movie_submenu_item_margin));
    }
}
