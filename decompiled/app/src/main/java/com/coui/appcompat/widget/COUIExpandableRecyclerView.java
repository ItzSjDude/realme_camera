package com.coui.appcompat.widget;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.recyclerview.widget.COUILinearLayoutManager;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.widget.ExpandableRecyclerConnector;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class COUIExpandableRecyclerView extends COUIRecyclerView {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private COUIExpandableRecyclerAdapter f7299f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ExpandableRecyclerConnector f7300g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private InterfaceC1381b f7301h;

    /* renamed from: OplusGLSurfaceView_13 */
    private InterfaceC1380a f7302i;

    /* renamed from: OplusGLSurfaceView_15 */
    private InterfaceC1382c f7303j;

    /* renamed from: OplusGLSurfaceView_5 */
    private InterfaceC1383d f7304k;

    /* renamed from: com.coui.appcompat.widget.COUIExpandableRecyclerView$PlatformImplementations.kt_3 */
    public interface InterfaceC1380a {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m7131a(COUIRecyclerView cOUIRecyclerView, View view, int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15);
    }

    /* renamed from: com.coui.appcompat.widget.COUIExpandableRecyclerView$IntrinsicsJvm.kt_4 */
    public interface InterfaceC1381b {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m7132a(COUIExpandableRecyclerView cOUIExpandableRecyclerView, View view, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15);
    }

    /* renamed from: com.coui.appcompat.widget.COUIExpandableRecyclerView$IntrinsicsJvm.kt_3 */
    public interface InterfaceC1382c {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7133a(int OplusGLSurfaceView_13);
    }

    /* renamed from: com.coui.appcompat.widget.COUIExpandableRecyclerView$IntrinsicsJvm.kt_5 */
    public interface InterfaceC1383d {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7134a(int OplusGLSurfaceView_13);
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView, androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.AbstractC0693i abstractC0693i) {
        if (!(abstractC0693i instanceof COUILinearLayoutManager)) {
            throw new RuntimeException("only COUILinearLayoutManager");
        }
        if (((COUILinearLayoutManager) abstractC0693i).getOrientation() != 1) {
            throw new RuntimeException("only vertical orientation");
        }
        super.setLayoutManager(abstractC0693i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setItemAnimator(RecyclerView.AbstractC0690f abstractC0690f) {
        if (abstractC0690f != null) {
            throw new RuntimeException("not set ItemAnimator");
        }
        super.setItemAnimator(null);
    }

    public void setAdapter(COUIExpandableRecyclerAdapter interfaceC1452f) {
        this.f7299f = interfaceC1452f;
        this.f7300g = new ExpandableRecyclerConnector(interfaceC1452f, this);
        super.setAdapter(this.f7300g);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private long m7125a(ExpandableRecyclerPosition c1530x) {
        if (c1530x.f8869d == 1) {
            return this.f7299f.m7651b(c1530x.f8866a, c1530x.f8867b);
        }
        return this.f7299f.m7658d(c1530x.f8866a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m7127a(View view, int OplusGLSurfaceView_13) {
        ExpandableRecyclerConnector.C1445g c1445gM7500b = this.f7300g.m7500b(OplusGLSurfaceView_13);
        long jM7125a = m7125a(c1445gM7500b.f7909a);
        boolean z = true;
        if (c1445gM7500b.f7909a.f8869d == 2) {
            InterfaceC1381b interfaceC1381b = this.f7301h;
            if (interfaceC1381b != null && interfaceC1381b.m7132a(this, view, c1445gM7500b.f7909a.f8866a, jM7125a)) {
                c1445gM7500b.m7520a();
                return true;
            }
            if (c1445gM7500b.m7521b()) {
                m7126a(c1445gM7500b.f7909a.f8866a);
            } else {
                m7128b(c1445gM7500b.f7909a.f8866a);
            }
        } else {
            InterfaceC1380a interfaceC1380a = this.f7302i;
            if (interfaceC1380a != null) {
                return interfaceC1380a.m7131a(this, view, c1445gM7500b.f7909a.f8866a, c1445gM7500b.f7909a.f8867b, jM7125a);
            }
            z = false;
        }
        c1445gM7500b.m7520a();
        return z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.AbstractC0685a abstractC0685a) {
        throw new RuntimeException("adapter instansof COUIExpandableRecyclerAdapter");
    }

    public void setOnGroupClickListener(InterfaceC1381b interfaceC1381b) {
        this.f7301h = interfaceC1381b;
    }

    public void setOnChildClickListener(InterfaceC1380a interfaceC1380a) {
        this.f7302i = interfaceC1380a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m7126a(int OplusGLSurfaceView_13) {
        if (!this.f7300g.m7498a(OplusGLSurfaceView_13)) {
            return false;
        }
        this.f7300g.m7501b();
        InterfaceC1382c interfaceC1382c = this.f7303j;
        if (interfaceC1382c == null) {
            return true;
        }
        interfaceC1382c.m7133a(OplusGLSurfaceView_13);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m7128b(int OplusGLSurfaceView_13) {
        InterfaceC1383d interfaceC1383d;
        boolean zM7506e = this.f7300g.m7506e(OplusGLSurfaceView_13);
        if (zM7506e && (interfaceC1383d = this.f7304k) != null) {
            interfaceC1383d.m7134a(OplusGLSurfaceView_13);
        }
        return zM7506e;
    }

    public void setOnGroupCollapseListener(InterfaceC1382c interfaceC1382c) {
        this.f7303j = interfaceC1382c;
    }

    public void setOnGroupExpandListener(InterfaceC1383d interfaceC1383d) {
        this.f7304k = interfaceC1383d;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.widget.COUIExpandableRecyclerView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return new SavedState(parcel, ExpandableRecyclerConnector.class.getClassLoader());
                }
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        ArrayList<ExpandableRecyclerConnector.GroupMetadata> expandedGroupMetadataList;

        SavedState(Parcelable parcelable, ArrayList<ExpandableRecyclerConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.expandedGroupMetadataList = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.expandedGroupMetadataList = new ArrayList<>();
            parcel.readList(this.expandedGroupMetadataList, ExpandableRecyclerConnector.class.getClassLoader());
        }

        private SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedGroupMetadataList = new ArrayList<>();
            parcel.readList(this.expandedGroupMetadataList, ExpandableRecyclerConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeList(this.expandedGroupMetadataList);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        ExpandableRecyclerConnector expandableRecyclerConnector = this.f7300g;
        return new SavedState(parcelableOnSaveInstanceState, expandableRecyclerConnector != null ? expandableRecyclerConnector.m7504c() : null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f7300g == null || savedState.expandedGroupMetadataList == null) {
            return;
        }
        this.f7300g.m7497a(savedState.expandedGroupMetadataList);
    }
}
