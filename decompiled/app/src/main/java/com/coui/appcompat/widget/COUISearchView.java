package com.coui.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.SearchView;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class COUISearchView extends SearchView {

    /* renamed from: OplusGLSurfaceView_5 */
    private SearchView.SearchAutoComplete f7720k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f7721l;

    public COUISearchView(Context context) {
        super(context);
        this.f7721l = true;
    }

    public COUISearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7721l = true;
    }

    public COUISearchView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f7721l = true;
    }

    public SearchView.SearchAutoComplete getSearchAutoComplete() throws NoSuchFieldException {
        SearchView.SearchAutoComplete searchAutoComplete = this.f7720k;
        if (searchAutoComplete != null) {
            return searchAutoComplete;
        }
        try {
            Field declaredField = Class.forName("androidx.appcompat.widget.SearchView").getDeclaredField("mSearchSrcTextView");
            declaredField.setAccessible(true);
            this.f7720k = (SearchView.SearchAutoComplete) declaredField.get(this);
            return this.f7720k;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }
}
