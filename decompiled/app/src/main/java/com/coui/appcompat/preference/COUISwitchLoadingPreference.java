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
public class COUISwitchLoadingPreference extends SwitchPreferenceCompat {

    /* renamed from: IntrinsicsJvm.kt_4 */
    View f6995b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private COUISwitch f6996c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final C1330a f6997d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f6998e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Drawable f6999f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f7000g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private COUISwitch.InterfaceC1430a f7001h;

    /* renamed from: com.coui.appcompat.preference.COUISwitchLoadingPreference$PlatformImplementations.kt_3 */
    private class C1330a implements CompoundButton.OnCheckedChangeListener {
        private C1330a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!COUISwitchLoadingPreference.this.m6928d(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                COUISwitchLoadingPreference.this.m3903e(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m6928d(Object obj) {
        if (m3797H() == null) {
            return true;
        }
        return m3797H().onPreferenceChange(this, obj);
    }

    public COUISwitchLoadingPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiSwitchLoadPreferenceStyle);
    }

    public COUISwitchLoadingPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUISwitchLoadingPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f6997d = new C1330a();
        this.f6998e = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIPreference, OplusGLSurfaceView_13, 0);
        this.f6998e = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIPreference_couiShowDivider, this.f6998e);
        this.f6999f = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUIPreference_couiDividerDrawable);
        this.f7000g = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIPreference_couiEnalbeClickSpan, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        final TextView textView;
        View viewM4007a = c0668l.m4007a(R.id_renamed.coui_preference);
        if (viewM4007a != null) {
            viewM4007a.setSoundEffectsEnabled(false);
            viewM4007a.setHapticFeedbackEnabled(false);
        }
        this.f6995b = c0668l.m4007a(R.id_renamed.switchWidget);
        View view = this.f6995b;
        if (view instanceof COUISwitch) {
            COUISwitch cOUISwitch = (COUISwitch) view;
            cOUISwitch.setOnCheckedChangeListener(null);
            cOUISwitch.setVerticalScrollBarEnabled(false);
            this.f6996c = cOUISwitch;
        }
        super.mo3736a(c0668l);
        View view2 = this.f6995b;
        if (view2 instanceof COUISwitch) {
            COUISwitch cOUISwitch2 = (COUISwitch) view2;
            cOUISwitch2.setLoadingStyle(true);
            cOUISwitch2.m7469d();
            cOUISwitch2.setOnLoadingStateChangedListener(this.f7001h);
            cOUISwitch2.setOnCheckedChangeListener(this.f6997d);
        }
        if (this.f7000g && (textView = (TextView) c0668l.m4007a(android.R.id_renamed.summary)) != null) {
            textView.setHighlightColor(m3800K().getResources().getColor(android.R.color.transparent));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.preference.COUISwitchLoadingPreference.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    int actionMasked = motionEvent.getActionMasked();
                    int selectionStart = textView.getSelectionStart();
                    int selectionEnd = textView.getSelectionEnd();
                    int offsetForPosition = textView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                    boolean z = selectionStart == selectionEnd || offsetForPosition <= selectionStart || offsetForPosition >= selectionEnd;
                    if (actionMasked != 0) {
                        if (actionMasked == 1 || actionMasked == 3) {
                            textView.setPressed(false);
                            textView.postInvalidateDelayed(70L);
                        }
                    } else {
                        if (z) {
                            return false;
                        }
                        textView.setPressed(true);
                        textView.invalidate();
                    }
                    return false;
                }
            });
        }
        View viewFindViewById = c0668l.itemView.findViewById(android.R.id_renamed.icon);
        View viewM4007a2 = c0668l.m4007a(R.id_renamed.img_layout);
        if (viewM4007a2 != null) {
            if (viewFindViewById != null) {
                viewM4007a2.setVisibility(viewFindViewById.getVisibility());
            } else {
                viewM4007a2.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo3743g() {
        COUISwitch cOUISwitch = this.f6996c;
        if (cOUISwitch != null) {
            cOUISwitch.setShouldPlaySound(true);
            this.f6996c.setTactileFeedbackEnabled(true);
            this.f6996c.m7467b();
        }
    }
}
