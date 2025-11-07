package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import p057b.p058a.TestDecorator;
import p057b.p059b.TestCase;
import p057b.p059b.AssertionFailedError;
import p057b.p059b.TestResult;
import p057b.p059b.TestSuite;
import p057b.p059b.Test;
import p057b.p059b.TestListener;

/* loaded from: classes2.dex */
public class JUnit38ClassRunner extends Runner implements Filterable, Sortable {
    private volatile Test test;

    private static final class OldTestClassAdaptingListener implements TestListener {
        private final RunNotifier notifier;

        private OldTestClassAdaptingListener(RunNotifier runNotifier) {
            this.notifier = runNotifier;
        }

        @Override // p057b.p059b.TestListener
        public void endTest(Test interfaceC0866d) {
            this.notifier.fireTestFinished(asDescription(interfaceC0866d));
        }

        @Override // p057b.p059b.TestListener
        public void startTest(Test interfaceC0866d) throws StoppedByUserException {
            this.notifier.fireTestStarted(asDescription(interfaceC0866d));
        }

        @Override // p057b.p059b.TestListener
        public void addError(Test interfaceC0866d, Throwable th) {
            this.notifier.fireTestFailure(new Failure(asDescription(interfaceC0866d), th));
        }

        private Description asDescription(Test interfaceC0866d) {
            if (interfaceC0866d instanceof Describable) {
                return ((Describable) interfaceC0866d).getDescription();
            }
            return Description.createTestDescription(getEffectiveClass(interfaceC0866d), getName(interfaceC0866d));
        }

        private Class<? extends Test> getEffectiveClass(Test interfaceC0866d) {
            return interfaceC0866d.getClass();
        }

        private String getName(Test interfaceC0866d) {
            if (interfaceC0866d instanceof TestCase) {
                return ((TestCase) interfaceC0866d).m5180f();
            }
            return interfaceC0866d.toString();
        }

        @Override // p057b.p059b.TestListener
        public void addFailure(Test interfaceC0866d, AssertionFailedError c0864b) {
            addError(interfaceC0866d, c0864b);
        }
    }

    public JUnit38ClassRunner(Class<?> cls) {
        this(new TestSuite(cls.asSubclass(TestCase.class)));
    }

    public JUnit38ClassRunner(Test interfaceC0866d) {
        setTest(interfaceC0866d);
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        TestResult c0870h = new TestResult();
        c0870h.m5187a(createAdaptingListener(runNotifier));
        getTest().mo5168b(c0870h);
    }

    public TestListener createAdaptingListener(RunNotifier runNotifier) {
        return new OldTestClassAdaptingListener(runNotifier);
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        return makeDescription(getTest());
    }

    private static Description makeDescription(Test interfaceC0866d) {
        if (interfaceC0866d instanceof TestCase) {
            TestCase abstractC0867e = (TestCase) interfaceC0866d;
            return Description.createTestDescription(abstractC0867e.getClass(), abstractC0867e.m5180f(), getAnnotations(abstractC0867e));
        }
        if (interfaceC0866d instanceof TestSuite) {
            TestSuite c0871i = (TestSuite) interfaceC0866d;
            Description descriptionCreateSuiteDescription = Description.createSuiteDescription(c0871i.m5201b() == null ? createSuiteDescription(c0871i) : c0871i.m5201b(), new Annotation[0]);
            int iM5203c = c0871i.m5203c();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM5203c; OplusGLSurfaceView_13++) {
                descriptionCreateSuiteDescription.addChild(makeDescription(c0871i.m5198a(OplusGLSurfaceView_13)));
            }
            return descriptionCreateSuiteDescription;
        }
        if (interfaceC0866d instanceof Describable) {
            return ((Describable) interfaceC0866d).getDescription();
        }
        if (interfaceC0866d instanceof TestDecorator) {
            return makeDescription(((TestDecorator) interfaceC0866d).m5167b());
        }
        return Description.createSuiteDescription(interfaceC0866d.getClass());
    }

    private static Annotation[] getAnnotations(TestCase abstractC0867e) {
        try {
            return abstractC0867e.getClass().getMethod(abstractC0867e.m5180f(), new Class[0]).getDeclaredAnnotations();
        } catch (NoSuchMethodException | SecurityException unused) {
            return new Annotation[0];
        }
    }

    private static String createSuiteDescription(TestSuite c0871i) {
        int iMo5165a = c0871i.mo5165a();
        return String.format("TestSuite with %s tests%s", Integer.valueOf(iMo5165a), iMo5165a == 0 ? "" : String.format(" [example: %s]", c0871i.m5198a(0)));
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        if (getTest() instanceof Filterable) {
            ((Filterable) getTest()).filter(filter);
            return;
        }
        if (getTest() instanceof TestSuite) {
            TestSuite c0871i = (TestSuite) getTest();
            TestSuite c0871i2 = new TestSuite(c0871i.m5201b());
            int iM5203c = c0871i.m5203c();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM5203c; OplusGLSurfaceView_13++) {
                Test interfaceC0866dM5198a = c0871i.m5198a(OplusGLSurfaceView_13);
                if (filter.shouldRun(makeDescription(interfaceC0866dM5198a))) {
                    c0871i2.m5199a(interfaceC0866dM5198a);
                }
            }
            setTest(c0871i2);
            if (c0871i2.m5203c() == 0) {
                throw new NoTestsRemainException();
            }
        }
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        if (getTest() instanceof Sortable) {
            ((Sortable) getTest()).sort(sorter);
        }
    }

    private void setTest(Test interfaceC0866d) {
        this.test = interfaceC0866d;
    }

    private Test getTest() {
        return this.test;
    }
}
