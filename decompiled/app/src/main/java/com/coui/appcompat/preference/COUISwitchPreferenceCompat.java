package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SwitchPreferenceCompat;
import com.coui.appcompat.widget.COUISwitch;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUISwitchPreferenceCompat extends SwitchPreferenceCompat {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final C1334a f7023b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f7024c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Drawable f7025d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f7026e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private COUISwitch f7027f;

    /* renamed from: com.coui.appcompat.preference.COUISwitchPreferenceCompat$PlatformImplementations.kt_3 */
    private class C1334a implements CompoundButton.OnCheckedChangeListener {
        private C1334a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (COUISwitchPreferenceCompat.this.m3901b() == z) {
                return;
            }
            if (!COUISwitchPreferenceCompat.this.m6935d(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                COUISwitchPreferenceCompat.this.m3903e(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m6935d(Object obj) {
        if (m3797H() == null) {
            return true;
        }
        return m3797H().onPreferenceChange(this, obj);
    }

    public COUISwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchPreferenceCompatStyle);
    }

    public COUISwitchPreferenceCompat(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUISwitchPreferenceCompat(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f7023b = new C1334a();
        this.f7024c = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIPreference, OplusGLSurfaceView_13, 0);
        this.f7024c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIPreference_couiShowDivider, this.f7024c);
        this.f7025d = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUIPreference_couiDividerDrawable);
        this.f7026e = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIPreference_couiEnalbeClickSpan, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        final TextView textView;
        View viewM4007a = c0668l.m4007a(R.id_renamed.coui_preference);
        if (viewM4007a != null) {
            viewM4007a.setSoundEffectsEnabled(false);
        }
        View viewM4007a2 = c0668l.m4007a(R.id_renamed.switchWidget);
        boolean z = viewM4007a2 instanceof COUISwitch;
        if (z) {
            COUISwitch cOUISwitch = (COUISwitch) viewM4007a2;
            cOUISwitch.setOnCheckedChangeListener(null);
            this.f7027f = cOUISwitch;
        }
        super.mo3736a(c0668l);
        if (z) {
            COUISwitch cOUISwitch2 = (COUISwitch) viewM4007a2;
            cOUISwitch2.m7469d();
            cOUISwitch2.setOnCheckedChangeListener(this.f7023b);
        }
        if (!this.f7026e || (textView = (TextView) c0668l.m4007a(android.R.id_renamed.summary)) == null) {
            return;
        }
        textView.setHighlightColor(m3800K().getResources().getColor(android.R.color.transparent));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.preference.COUISwitchPreferenceCompat.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int actionMasked = motionEvent.getActionMasked();
                int selectionStart = textView.getSelectionStart();
                int selectionEnd = textView.getSelectionEnd();
                int offsetForPosition = textView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                boolean z2 = selectionStart == selectionEnd || offsetForPosition <= selectionStart || offsetForPosition >= selectionEnd;
                if (actionMasked != 0) {
                    if (actionMasked == 1 || actionMasked == 3) {
                        textView.setPressed(false);
                        textView.postInvalidateDelayed(70L);
                    }
                } else {
                    if (z2) {
                        return false;
                    }
                    textView.setPressed(true);
                    textView.invalidate();
                }
                return false;
            }
        });
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void mo3743g() {
        COUISwitch cOUISwitch = this.f7027f;
        if (cOUISwitch != null) {
            cOUISwitch.setShouldPlaySound(true);
        }
        super.mo3743g();
    }
}
