package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionSet.java */
/* renamed from: androidx.transition.q */
/* loaded from: classes.dex */
public class TransitionSet extends Transition {

    /* renamed from: PlatformImplementations.kt_3 */
    int f4652a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ArrayList<Transition> f4654c = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f4655d = true;

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean f4653b = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f4656e = 0;

    @Override // androidx.transition.Transition
    public /* synthetic */ Transition addTarget(Class cls) {
        return m4815a((Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    public /* synthetic */ Transition removeTarget(Class cls) {
        return m4821b((Class<?>) cls);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public TransitionSet m4808a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            this.f4655d = true;
        } else if (OplusGLSurfaceView_13 == 1) {
            this.f4655d = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + OplusGLSurfaceView_13);
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public TransitionSet m4814a(Transition abstractC0791m) {
        m4806b(abstractC0791m);
        if (this.mDuration >= 0) {
            abstractC0791m.setDuration(this.mDuration);
        }
        if ((this.f4656e & 1) != 0) {
            abstractC0791m.setInterpolator(getInterpolator());
        }
        if ((this.f4656e & 2) != 0) {
            abstractC0791m.setPropagation(getPropagation());
        }
        if ((this.f4656e & 4) != 0) {
            abstractC0791m.setPathMotion(getPathMotion());
        }
        if ((this.f4656e & 8) != 0) {
            abstractC0791m.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4806b(Transition abstractC0791m) {
        this.f4654c.add(abstractC0791m);
        abstractC0791m.mParent = this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m4807a() {
        return this.f4654c.size();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Transition m4817b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f4654c.size()) {
            return null;
        }
        return this.f4654c.get(OplusGLSurfaceView_13);
    }

    @Override // androidx.transition.Transition
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public TransitionSet setDuration(long OplusGLSurfaceView_15) {
        ArrayList<Transition> arrayList;
        super.setDuration(OplusGLSurfaceView_15);
        if (this.mDuration >= 0 && (arrayList = this.f4654c) != null) {
            int size = arrayList.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                this.f4654c.get(OplusGLSurfaceView_13).setDuration(OplusGLSurfaceView_15);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public TransitionSet setStartDelay(long OplusGLSurfaceView_15) {
        return (TransitionSet) super.setStartDelay(OplusGLSurfaceView_15);
    }

    @Override // androidx.transition.Transition
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public TransitionSet setInterpolator(TimeInterpolator timeInterpolator) {
        this.f4656e |= 1;
        ArrayList<Transition> arrayList = this.f4654c;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                this.f4654c.get(OplusGLSurfaceView_13).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    @Override // androidx.transition.Transition
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public TransitionSet addTarget(View view) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4654c.size(); OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    @Override // androidx.transition.Transition
    /* renamed from: IntrinsicsJvm.kt_3, reason: merged with bridge method [inline-methods] */
    public TransitionSet addTarget(int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < this.f4654c.size(); i2++) {
            this.f4654c.get(i2).addTarget(OplusGLSurfaceView_13);
        }
        return (TransitionSet) super.addTarget(OplusGLSurfaceView_13);
    }

    @Override // androidx.transition.Transition
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public TransitionSet addTarget(String str) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4654c.size(); OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public TransitionSet m4815a(Class<?> cls) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4654c.size(); OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    @Override // androidx.transition.Transition
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public TransitionSet addListener(Transition.IntrinsicsJvm.kt_5 dVar) {
        return (TransitionSet) super.addListener(dVar);
    }

    @Override // androidx.transition.Transition
    /* renamed from: IntrinsicsJvm.kt_5, reason: merged with bridge method [inline-methods] */
    public TransitionSet removeTarget(int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < this.f4654c.size(); i2++) {
            this.f4654c.get(i2).removeTarget(OplusGLSurfaceView_13);
        }
        return (TransitionSet) super.removeTarget(OplusGLSurfaceView_13);
    }

    @Override // androidx.transition.Transition
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public TransitionSet removeTarget(View view) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4654c.size(); OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public TransitionSet m4821b(Class<?> cls) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4654c.size(); OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    @Override // androidx.transition.Transition
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public TransitionSet removeTarget(String str) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4654c.size(); OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(View view, boolean z) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4654c.size(); OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(String str, boolean z) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4654c.size(); OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(int OplusGLSurfaceView_13, boolean z) {
        for (int i2 = 0; i2 < this.f4654c.size(); i2++) {
            this.f4654c.get(i2).excludeTarget(OplusGLSurfaceView_13, z);
        }
        return super.excludeTarget(OplusGLSurfaceView_13, z);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(Class<?> cls, boolean z) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4654c.size(); OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    @Override // androidx.transition.Transition
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public TransitionSet removeListener(Transition.IntrinsicsJvm.kt_5 dVar) {
        return (TransitionSet) super.removeListener(dVar);
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion abstractC0785g) {
        super.setPathMotion(abstractC0785g);
        this.f4656e |= 4;
        if (this.f4654c != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4654c.size(); OplusGLSurfaceView_13++) {
                this.f4654c.get(OplusGLSurfaceView_13).setPathMotion(abstractC0785g);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4805b() {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(this);
        Iterator<Transition> it = this.f4654c.iterator();
        while (it.hasNext()) {
            it.next().addListener(aVar);
        }
        this.f4652a = this.f4654c.size();
    }

    /* compiled from: TransitionSet.java */
    /* renamed from: androidx.transition.q$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 extends TransitionListenerAdapter {

        /* renamed from: PlatformImplementations.kt_3 */
        TransitionSet f4659a;

        PlatformImplementations.kt_3(TransitionSet c0795q) {
            this.f4659a = c0795q;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.IntrinsicsJvm.kt_5
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo4763e(Transition abstractC0791m) {
            if (this.f4659a.f4653b) {
                return;
            }
            this.f4659a.start();
            this.f4659a.f4653b = true;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo4757b(Transition abstractC0791m) {
            TransitionSet c0795q = this.f4659a;
            c0795q.f4652a--;
            if (this.f4659a.f4652a == 0) {
                TransitionSet c0795q2 = this.f4659a;
                c0795q2.f4653b = false;
                c0795q2.end();
            }
            abstractC0791m.removeListener(this);
        }
    }

    @Override // androidx.transition.Transition
    protected void createAnimators(ViewGroup viewGroup, TransitionValuesMaps c0798u, TransitionValuesMaps c0798u2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f4654c.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            Transition abstractC0791m = this.f4654c.get(OplusGLSurfaceView_13);
            if (startDelay > 0 && (this.f4655d || OplusGLSurfaceView_13 == 0)) {
                long startDelay2 = abstractC0791m.getStartDelay();
                if (startDelay2 > 0) {
                    abstractC0791m.setStartDelay(startDelay2 + startDelay);
                } else {
                    abstractC0791m.setStartDelay(startDelay);
                }
            }
            abstractC0791m.createAnimators(viewGroup, c0798u, c0798u2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    protected void runAnimators() {
        if (this.f4654c.isEmpty()) {
            start();
            end();
            return;
        }
        m4805b();
        if (!this.f4655d) {
            for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < this.f4654c.size(); OplusGLSurfaceView_13++) {
                Transition abstractC0791m = this.f4654c.get(OplusGLSurfaceView_13 - 1);
                final Transition abstractC0791m2 = this.f4654c.get(OplusGLSurfaceView_13);
                abstractC0791m.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.q.1
                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.IntrinsicsJvm.kt_5
                    /* renamed from: IntrinsicsJvm.kt_4 */
                    public void mo4757b(Transition abstractC0791m3) {
                        abstractC0791m2.runAnimators();
                        abstractC0791m3.removeListener(this);
                    }
                });
            }
            Transition abstractC0791m3 = this.f4654c.get(0);
            if (abstractC0791m3 != null) {
                abstractC0791m3.runAnimators();
                return;
            }
            return;
        }
        Iterator<Transition> it = this.f4654c.iterator();
        while (it.hasNext()) {
            it.next().runAnimators();
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues c0797t) {
        if (isValidTarget(c0797t.f4664b)) {
            Iterator<Transition> it = this.f4654c.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(c0797t.f4664b)) {
                    next.captureStartValues(c0797t);
                    c0797t.f4665c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues c0797t) {
        if (isValidTarget(c0797t.f4664b)) {
            Iterator<Transition> it = this.f4654c.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(c0797t.f4664b)) {
                    next.captureEndValues(c0797t);
                    c0797t.f4665c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    void capturePropagationValues(TransitionValues c0797t) {
        super.capturePropagationValues(c0797t);
        int size = this.f4654c.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).capturePropagationValues(c0797t);
        }
    }

    @Override // androidx.transition.Transition
    public void pause(View view) {
        super.pause(view);
        int size = this.f4654c.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).pause(view);
        }
    }

    @Override // androidx.transition.Transition
    public void resume(View view) {
        super.resume(view);
        int size = this.f4654c.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).resume(view);
        }
    }

    @Override // androidx.transition.Transition
    protected void cancel() {
        super.cancel();
        int size = this.f4654c.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).cancel();
        }
    }

    @Override // androidx.transition.Transition
    void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f4654c.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).forceToEnd(viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public TransitionSet setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f4654c.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // androidx.transition.Transition
    void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.f4654c.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).setCanRemoveViews(z);
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(TransitionPropagation abstractC0794p) {
        super.setPropagation(abstractC0794p);
        this.f4656e |= 2;
        int size = this.f4654c.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).setPropagation(abstractC0794p);
        }
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.IntrinsicsJvm.kt_3 cVar) {
        super.setEpicenterCallback(cVar);
        this.f4656e |= 8;
        int size = this.f4654c.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f4654c.get(OplusGLSurfaceView_13).setEpicenterCallback(cVar);
        }
    }

    @Override // androidx.transition.Transition
    String toString(String str) {
        String string = super.toString(str);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4654c.size(); OplusGLSurfaceView_13++) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append("\OplusGLSurfaceView_11");
            sb.append(this.f4654c.get(OplusGLSurfaceView_13).toString(str + "  "));
            string = sb.toString();
        }
        return string;
    }

    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public Transition mo26268clone() {
        TransitionSet c0795q = (TransitionSet) super.mo26268clone();
        c0795q.f4654c = new ArrayList<>();
        int size = this.f4654c.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            c0795q.m4806b(this.f4654c.get(OplusGLSurfaceView_13).mo26268clone());
        }
        return c0795q;
    }
}
