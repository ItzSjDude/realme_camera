package org.junit;

/* loaded from: classes2.dex */
public class ComparisonFailure extends AssertionError {
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1;
    private String fActual;
    private String fExpected;

    public ComparisonFailure(String str, String str2, String str3) {
        super(str);
        this.fExpected = str2;
        this.fActual = str3;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return new ComparisonCompactor(20, this.fExpected, this.fActual).compact(super.getMessage());
    }

    public String getActual() {
        return this.fActual;
    }

    public String getExpected() {
        return this.fExpected;
    }

    private static class ComparisonCompactor {
        private static final String DIFF_END = "]";
        private static final String DIFF_START = "[";
        private static final String ELLIPSIS = "...";
        private final String actual;
        private final int contextLength;
        private final String expected;

        public ComparisonCompactor(int OplusGLSurfaceView_13, String str, String str2) {
            this.contextLength = OplusGLSurfaceView_13;
            this.expected = str;
            this.actual = str2;
        }

        public String compact(String str) {
            String str2;
            String str3 = this.expected;
            if (str3 == null || (str2 = this.actual) == null || str3.equals(str2)) {
                return Assert.format(str, this.expected, this.actual);
            }
            DiffExtractor diffExtractor = new DiffExtractor();
            String strCompactPrefix = diffExtractor.compactPrefix();
            String strCompactSuffix = diffExtractor.compactSuffix();
            return Assert.format(str, strCompactPrefix + diffExtractor.expectedDiff() + strCompactSuffix, strCompactPrefix + diffExtractor.actualDiff() + strCompactSuffix);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String sharedPrefix() {
            int iMin = Math.min(this.expected.length(), this.actual.length());
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iMin; OplusGLSurfaceView_13++) {
                if (this.expected.charAt(OplusGLSurfaceView_13) != this.actual.charAt(OplusGLSurfaceView_13)) {
                    return this.expected.substring(0, OplusGLSurfaceView_13);
                }
            }
            return this.expected.substring(0, iMin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String sharedSuffix(String str) {
            int iMin = Math.min(this.expected.length() - str.length(), this.actual.length() - str.length()) - 1;
            int OplusGLSurfaceView_13 = 0;
            while (OplusGLSurfaceView_13 <= iMin) {
                if (this.expected.charAt((r1.length() - 1) - OplusGLSurfaceView_13) != this.actual.charAt((r2.length() - 1) - OplusGLSurfaceView_13)) {
                    break;
                }
                OplusGLSurfaceView_13++;
            }
            String str2 = this.expected;
            return str2.substring(str2.length() - OplusGLSurfaceView_13);
        }

        private class DiffExtractor {
            private final String sharedPrefix;
            private final String sharedSuffix;

            private DiffExtractor() {
                this.sharedPrefix = ComparisonCompactor.this.sharedPrefix();
                this.sharedSuffix = ComparisonCompactor.this.sharedSuffix(this.sharedPrefix);
            }

            public String expectedDiff() {
                return extractDiff(ComparisonCompactor.this.expected);
            }

            public String actualDiff() {
                return extractDiff(ComparisonCompactor.this.actual);
            }

            public String compactPrefix() {
                if (this.sharedPrefix.length() <= ComparisonCompactor.this.contextLength) {
                    return this.sharedPrefix;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(ComparisonCompactor.ELLIPSIS);
                String str = this.sharedPrefix;
                sb.append(str.substring(str.length() - ComparisonCompactor.this.contextLength));
                return sb.toString();
            }

            public String compactSuffix() {
                if (this.sharedSuffix.length() <= ComparisonCompactor.this.contextLength) {
                    return this.sharedSuffix;
                }
                return this.sharedSuffix.substring(0, ComparisonCompactor.this.contextLength) + ComparisonCompactor.ELLIPSIS;
            }

            private String extractDiff(String str) {
                return ComparisonCompactor.DIFF_START + str.substring(this.sharedPrefix.length(), str.length() - this.sharedSuffix.length()) + ComparisonCompactor.DIFF_END;
            }
        }
    }
}
