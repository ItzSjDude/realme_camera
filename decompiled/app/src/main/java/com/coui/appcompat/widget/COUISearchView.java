package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUISearchView extends androidx.appcompat.widget.SearchView {
    private androidx.appcompat.widget.SearchView.SearchAutoComplete k_renamed;
    private boolean l_renamed;

    public COUISearchView(android.content.Context context) {
        super(context);
        this.l_renamed = true;
    }

    public COUISearchView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l_renamed = true;
    }

    public COUISearchView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.l_renamed = true;
    }

    public androidx.appcompat.widget.SearchView.SearchAutoComplete getSearchAutoComplete() throws java.lang.NoSuchFieldException {
        androidx.appcompat.widget.SearchView.SearchAutoComplete searchAutoComplete = this.k_renamed;
        if (searchAutoComplete != null) {
            return searchAutoComplete;
        }
        try {
            java.lang.reflect.Field declaredField = java.lang.Class.forName("androidx.appcompat.widget.SearchView").getDeclaredField("mSearchSrcTextView");
            declaredField.setAccessible(true);
            this.k_renamed = (androidx.appcompat.widget.SearchView.SearchAutoComplete) declaredField.get(this);
            return this.k_renamed;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }
}
