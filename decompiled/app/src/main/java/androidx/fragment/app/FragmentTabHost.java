package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private final ArrayList<C0578a> f3401a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f3402b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private FragmentManager f3403c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f3404d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private TabHost.OnTabChangeListener f3405e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private C0578a f3406f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f3407g;

    /* renamed from: androidx.fragment.app.FragmentTabHost$PlatformImplementations.kt_3 */
    static final class C0578a {

        /* renamed from: PlatformImplementations.kt_3 */
        final String f3408a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final Class<?> f3409b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final Bundle f3410c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        Fragment f3411d;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.fragment.app.FragmentTabHost.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        String curTab;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.curTab = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeString(this.curTab);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes PlatformImplementations.kt_3 Context and FragmentManager");
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f3405e = onTabChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f3401a.size();
        FragmentTransaction abstractC0589kMo3389a = null;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            C0578a c0578a = this.f3401a.get(OplusGLSurfaceView_13);
            c0578a.f3411d = this.f3403c.mo3388a(c0578a.f3408a);
            if (c0578a.f3411d != null && !c0578a.f3411d.isDetached()) {
                if (c0578a.f3408a.equals(currentTabTag)) {
                    this.f3406f = c0578a;
                } else {
                    if (abstractC0589kMo3389a == null) {
                        abstractC0589kMo3389a = this.f3403c.mo3389a();
                    }
                    abstractC0589kMo3389a.mo3321b(c0578a.f3411d);
                }
            }
        }
        this.f3407g = true;
        FragmentTransaction abstractC0589kM3303a = m3303a(currentTabTag, abstractC0589kMo3389a);
        if (abstractC0589kM3303a != null) {
            abstractC0589kM3303a.mo3319b();
            this.f3403c.mo3395b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3407g = false;
    }

    @Override // android.view.View
    @Deprecated
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.curTab = getCurrentTabTag();
        return savedState;
    }

    @Override // android.view.View
    @Deprecated
    protected void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.curTab);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String str) {
        FragmentTransaction abstractC0589kM3303a;
        if (this.f3407g && (abstractC0589kM3303a = m3303a(str, null)) != null) {
            abstractC0589kM3303a.mo3319b();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f3405e;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private FragmentTransaction m3303a(String str, FragmentTransaction abstractC0589k) {
        C0578a c0578aM3302a = m3302a(str);
        if (this.f3406f != c0578aM3302a) {
            if (abstractC0589k == null) {
                abstractC0589k = this.f3403c.mo3389a();
            }
            C0578a c0578a = this.f3406f;
            if (c0578a != null && c0578a.f3411d != null) {
                abstractC0589k.mo3321b(this.f3406f.f3411d);
            }
            if (c0578aM3302a != null) {
                if (c0578aM3302a.f3411d == null) {
                    c0578aM3302a.f3411d = this.f3403c.mo3399f().mo3384c(this.f3402b.getClassLoader(), c0578aM3302a.f3409b.getName());
                    c0578aM3302a.f3411d.setArguments(c0578aM3302a.f3410c);
                    abstractC0589k.m3541a(this.f3404d, c0578aM3302a.f3411d, c0578aM3302a.f3408a);
                } else {
                    abstractC0589k.m3546c(c0578aM3302a.f3411d);
                }
            }
            this.f3406f = c0578aM3302a;
        }
        return abstractC0589k;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private C0578a m3302a(String str) {
        int size = this.f3401a.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            C0578a c0578a = this.f3401a.get(OplusGLSurfaceView_13);
            if (c0578a.f3408a.equals(str)) {
                return c0578a;
            }
        }
        return null;
    }
}
