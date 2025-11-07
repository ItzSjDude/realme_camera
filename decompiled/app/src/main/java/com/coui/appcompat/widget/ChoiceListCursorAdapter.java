package com.coui.appcompat.widget;

import android.R;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.p021b.p022a.CursorAdapter;
import java.util.HashSet;

/* compiled from: ChoiceListCursorAdapter.java */
/* renamed from: com.coui.appcompat.widget.w */
/* loaded from: classes.dex */
public class ChoiceListCursorAdapter extends CursorAdapter {

    /* renamed from: OplusGLSurfaceView_15 */
    private int f8856j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f8857k;

    /* renamed from: OplusGLSurfaceView_14 */
    private HashSet<Integer> f8858l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f8859m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f8860n;

    /* renamed from: o */
    private int f8861o;

    /* renamed from: p */
    private String f8862p;

    /* renamed from: q */
    private String f8863q;

    /* renamed from: r */
    private String f8864r;

    public ChoiceListCursorAdapter(Context context, Cursor cursor, int OplusGLSurfaceView_13, String str, String str2) {
        this(context, cursor, OplusGLSurfaceView_13, str, null, str2, false);
    }

    public ChoiceListCursorAdapter(Context context, Cursor cursor, int OplusGLSurfaceView_13, String str, String str2, String str3, boolean z) {
        this(context, cursor);
        this.f8857k = z;
        this.f8862p = str;
        this.f8864r = str3;
        this.f8863q = str2;
        this.f8856j = OplusGLSurfaceView_13;
        this.f8858l = new HashSet<>();
        this.f8859m = cursor.getColumnIndexOrThrow(this.f8862p);
        String str4 = this.f8864r;
        if (str4 != null) {
            this.f8861o = cursor.getColumnIndexOrThrow(str4);
        }
        if (z) {
            this.f8860n = cursor.getColumnIndexOrThrow(this.f8863q);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    if (cursor.getInt(this.f8860n) == 1) {
                        this.f8858l.add(Integer.valueOf(cursor.getPosition()));
                    }
                } while (cursor.moveToNext());
            }
            cursor.moveToFirst();
        }
    }

    public ChoiceListCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        this.f8857k = false;
        this.f8860n = 0;
    }

    @Override // androidx.p021b.p022a.CursorAdapter
    /* renamed from: PlatformImplementations.kt_3 */
    public View mo1524a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(this.f8856j, viewGroup, false);
    }

    @Override // androidx.p021b.p022a.CursorAdapter
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1527a(View view, Context context, Cursor cursor) {
        TextView textView = (TextView) view.findViewById(R.id_renamed.text1);
        TextView textView2 = (TextView) view.findViewById(coui.support.appcompat.R.id_renamed.summary_text2);
        int OplusGLSurfaceView_13 = this.f8858l.contains(Integer.valueOf(cursor.getPosition())) ? 2 : 0;
        if (this.f8857k) {
            ((COUICheckBox) view.findViewById(coui.support.appcompat.R.id_renamed.checkbox)).setState(OplusGLSurfaceView_13);
        }
        textView.setText(cursor.getString(this.f8859m));
        if (this.f8864r == null) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(cursor.getString(this.f8861o));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8243a(int OplusGLSurfaceView_13, int i2, ListView listView) {
        int firstVisiblePosition = i2 - listView.getFirstVisiblePosition();
        if (firstVisiblePosition >= 0) {
            ((COUICheckBox) listView.getChildAt(firstVisiblePosition).findViewById(coui.support.appcompat.R.id_renamed.checkbox)).setState(OplusGLSurfaceView_13);
            if (OplusGLSurfaceView_13 == 2) {
                this.f8858l.add(Integer.valueOf(i2));
            } else {
                this.f8858l.remove(Integer.valueOf(i2));
            }
        }
    }
}
