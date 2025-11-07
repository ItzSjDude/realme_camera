package org.p222a.p223a;

import java.util.ArrayList;
import org.p222a.TypeSafeDiagnosingMatcher;
import org.p222a.Description;
import org.p222a.Matcher;
import org.p222a.SelfDescribing;

/* compiled from: IsCollectionContaining.java */
/* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class IsCollectionContaining<T> extends TypeSafeDiagnosingMatcher<Iterable<? super T>> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Matcher<? super T> f24784a;

    public IsCollectionContaining(Matcher<? super T> interfaceC4039f) {
        this.f24784a = interfaceC4039f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p222a.TypeSafeDiagnosingMatcher
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public boolean mo26027a(Iterable<? super T> iterable, Description interfaceC4037d) {
        boolean z = false;
        for (T t : iterable) {
            if (this.f24784a.matches(t)) {
                return true;
            }
            if (z) {
                interfaceC4037d.mo26018a(", ");
            }
            this.f24784a.describeMismatch(t, interfaceC4037d);
            z = true;
        }
        return false;
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        interfaceC4037d.mo26018a("PlatformImplementations.kt_3 collection containing ").mo26020a((SelfDescribing) this.f24784a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<Iterable<? super T>> m26033a(Matcher<? super T> interfaceC4039f) {
        return new IsCollectionContaining(interfaceC4039f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<Iterable<? super T>> m26032a(T t) {
        return new IsCollectionContaining(IsEqual.m26037a(t));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<Iterable<T>> m26035a(Matcher<? super T>... interfaceC4039fArr) {
        ArrayList arrayList = new ArrayList(interfaceC4039fArr.length);
        for (Matcher<? super T> interfaceC4039f : interfaceC4039fArr) {
            arrayList.add(new IsCollectionContaining(interfaceC4039f));
        }
        return AllOf.m26023a(arrayList);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<Iterable<T>> m26034a(T... tArr) {
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t : tArr) {
            arrayList.add(m26032a(t));
        }
        return AllOf.m26023a(arrayList);
    }
}
