package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coui.appcompat.p099a.COUIChangeTextUtil;
import com.coui.appcompat.p099a.COUITextViewCompatUtil;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIFullPageStatement extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private TextView f7306a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private COUIButton f7307b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TextView f7308c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TextView f7309d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private LayoutInflater f7310e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Context f7311f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private InterfaceC1386a f7312g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private COUIMaxHeightScrollView f7313h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f7314i;

    /* renamed from: com.coui.appcompat.widget.COUIFullPageStatement$PlatformImplementations.kt_3 */
    public interface InterfaceC1386a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo7137a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo7138b();
    }

    public COUIFullPageStatement(Context context) {
        this(context, null);
    }

    public COUIFullPageStatement(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiFullPageStatementStyle);
    }

    public COUIFullPageStatement(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUIFullPageStatement(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f7311f = context;
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.f7314i = attributeSet.getStyleAttribute();
        } else {
            this.f7314i = OplusGLSurfaceView_13;
        }
        m7136a();
        TypedArray typedArrayObtainStyledAttributes = this.f7311f.obtainStyledAttributes(attributeSet, R.styleable.COUIFullPageStatement, OplusGLSurfaceView_13, 0);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.COUIFullPageStatement_exitButtonText);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.COUIFullPageStatement_bottomButtonText);
        String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.f24470xcfda8e42);
        this.f7306a.setText(typedArrayObtainStyledAttributes.getString(R.styleable.COUIFullPageStatement_appStatement));
        this.f7308c.setTextColor(typedArrayObtainStyledAttributes.getColor(R.styleable.f24468xb68090c1, 0));
        this.f7306a.setTextColor(typedArrayObtainStyledAttributes.getColor(R.styleable.f24469xfc2ccd3, 0));
        if (string2 != null) {
            this.f7307b.setText(string2);
        }
        if (string != null) {
            this.f7308c.setText(string);
        }
        if (string3 != null) {
            this.f7309d.setText(string3);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7136a() {
        this.f7310e = (LayoutInflater) this.f7311f.getSystemService("layout_inflater");
        View viewInflate = this.f7310e.inflate(R.layout.coui_full_page_statement, this);
        this.f7306a = (TextView) viewInflate.findViewById(R.id_renamed.txt_statement);
        this.f7307b = (COUIButton) viewInflate.findViewById(R.id_renamed.btn_confirm);
        this.f7313h = (COUIMaxHeightScrollView) viewInflate.findViewById(R.id_renamed.scroll_text);
        this.f7308c = (TextView) viewInflate.findViewById(R.id_renamed.txt_exit);
        this.f7309d = (TextView) viewInflate.findViewById(R.id_renamed.txt_title);
        COUIChangeTextUtil.m6390a(this.f7306a, 2);
        COUIChangeTextUtil.m6390a(this.f7308c, 4);
        this.f7307b.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.widget.COUIFullPageStatement.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUIFullPageStatement.this.f7312g != null) {
                    COUIFullPageStatement.this.f7312g.mo7137a();
                }
            }
        });
        this.f7308c.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.widget.COUIFullPageStatement.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUIFullPageStatement.this.f7312g != null) {
                    COUIFullPageStatement.this.f7312g.mo7138b();
                }
            }
        });
        COUITextViewCompatUtil.m6466a(this.f7308c);
    }

    public COUIMaxHeightScrollView getScrollTextView() {
        return this.f7313h;
    }

    public TextView getAppStatement() {
        return this.f7306a;
    }

    public void setAppStatement(CharSequence charSequence) {
        this.f7306a.setText(charSequence);
    }

    public void setButtonText(CharSequence charSequence) {
        this.f7307b.setText(charSequence);
    }

    public void setExitButtonText(CharSequence charSequence) {
        this.f7308c.setText(charSequence);
    }

    public void setTitleText(CharSequence charSequence) {
        this.f7309d.setText(charSequence);
    }

    public void setButtonListener(InterfaceC1386a interfaceC1386a) {
        this.f7312g = interfaceC1386a;
    }

    public void setStatementMaxHeight(int OplusGLSurfaceView_13) {
        this.f7313h.setMaxHeight(OplusGLSurfaceView_13);
    }

    public void setExitTextColor(int OplusGLSurfaceView_13) {
        this.f7308c.setTextColor(OplusGLSurfaceView_13);
    }

    public void setAppStatementTextColor(int OplusGLSurfaceView_13) {
        this.f7306a.setTextColor(OplusGLSurfaceView_13);
    }
}
