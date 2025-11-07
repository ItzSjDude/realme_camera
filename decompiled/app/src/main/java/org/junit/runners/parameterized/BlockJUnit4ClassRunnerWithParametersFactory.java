package org.junit.runners.parameterized;

/* loaded from: classes2.dex */
public class BlockJUnit4ClassRunnerWithParametersFactory implements org.junit.runners.parameterized.ParametersRunnerFactory {
    @Override // org.junit.runners.parameterized.ParametersRunnerFactory
    public org.junit.runner.Runner createRunnerForTestWithParameters(org.junit.runners.parameterized.TestWithParameters testWithParameters) throws org.junit.runners.model.InitializationError {
        return new org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParameters(testWithParameters);
    }
}
