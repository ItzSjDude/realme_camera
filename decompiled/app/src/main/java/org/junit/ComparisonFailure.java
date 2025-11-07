package org.junit;

/* loaded from: classes2.dex */
public class ComparisonFailure extends java.lang.AssertionError {
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1;
    private java.lang.String fActual;
    private java.lang.String fExpected;

    public ComparisonFailure(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(str);
        this.fExpected = str2;
        this.fActual = str3;
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        return new org.junit.ComparisonFailure.ComparisonCompactor(20, this.fExpected, this.fActual).compact(super.getMessage());
    }

    public java.lang.String getActual() {
        return this.fActual;
    }

    public java.lang.String getExpected() {
        return this.fExpected;
    }

    private static class ComparisonCompactor {
        private static final java.lang.String DIFF_END = "]";
        private static final java.lang.String DIFF_START = "[";
        private static final java.lang.String ELLIPSIS = "...";
        private final java.lang.String actual;
        private final int contextLength;
        private final java.lang.String expected;

        public ComparisonCompactor(int i_renamed, java.lang.String str, java.lang.String str2) {
            this.contextLength = i_renamed;
            this.expected = str;
            this.actual = str2;
        }

        public java.lang.String compact(java.lang.String str) {
            java.lang.String str2;
            java.lang.String str3 = this.expected;
            if (str3 == null || (str2 = this.actual) == null || str3.equals(str2)) {
                return org.junit.Assert.format(str, this.expected, this.actual);
            }
            org.junit.ComparisonFailure.ComparisonCompactor.DiffExtractor diffExtractor = new org.junit.ComparisonFailure.ComparisonCompactor.DiffExtractor();
            java.lang.String strCompactPrefix = diffExtractor.compactPrefix();
            java.lang.String strCompactSuffix = diffExtractor.compactSuffix();
            return org.junit.Assert.format(str, strCompactPrefix + diffExtractor.expectedDiff() + strCompactSuffix, strCompactPrefix + diffExtractor.actualDiff() + strCompactSuffix);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public java.lang.String sharedPrefix() {
            int iMin = java.lang.Math.min(this.expected.length(), this.actual.length());
            for (int i_renamed = 0; i_renamed < iMin; i_renamed++) {
                if (this.expected.charAt(i_renamed) != this.actual.charAt(i_renamed)) {
                    return this.expected.substring(0, i_renamed);
                }
            }
            return this.expected.substring(0, iMin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public java.lang.String sharedSuffix(java.lang.String str) {
            int iMin = java.lang.Math.min(this.expected.length() - str.length(), this.actual.length() - str.length()) - 1;
            int i_renamed = 0;
            while (i_renamed <= iMin) {
                if (this.expected.charAt((r1.length() - 1) - i_renamed) != this.actual.charAt((r2.length() - 1) - i_renamed)) {
                    break;
                }
                i_renamed++;
            }
            java.lang.String str2 = this.expected;
            return str2.substring(str2.length() - i_renamed);
        }

        private class DiffExtractor {
            private final java.lang.String sharedPrefix;
            private final java.lang.String sharedSuffix;

            private DiffExtractor() {
                this.sharedPrefix = org.junit.ComparisonFailure.ComparisonCompactor.this.sharedPrefix();
                this.sharedSuffix = org.junit.ComparisonFailure.ComparisonCompactor.this.sharedSuffix(this.sharedPrefix);
            }

            public java.lang.String expectedDiff() {
                return extractDiff(org.junit.ComparisonFailure.ComparisonCompactor.this.expected);
            }

            public java.lang.String actualDiff() {
                return extractDiff(org.junit.ComparisonFailure.ComparisonCompactor.this.actual);
            }

            public java.lang.String compactPrefix() {
                if (this.sharedPrefix.length() <= org.junit.ComparisonFailure.ComparisonCompactor.this.contextLength) {
                    return this.sharedPrefix;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(org.junit.ComparisonFailure.ComparisonCompactor.ELLIPSIS);
                java.lang.String str = this.sharedPrefix;
                sb.append(str.substring(str.length() - org.junit.ComparisonFailure.ComparisonCompactor.this.contextLength));
                return sb.toString();
            }

            public java.lang.String compactSuffix() {
                if (this.sharedSuffix.length() <= org.junit.ComparisonFailure.ComparisonCompactor.this.contextLength) {
                    return this.sharedSuffix;
                }
                return this.sharedSuffix.substring(0, org.junit.ComparisonFailure.ComparisonCompactor.this.contextLength) + org.junit.ComparisonFailure.ComparisonCompactor.ELLIPSIS;
            }

            private java.lang.String extractDiff(java.lang.String str) {
                return org.junit.ComparisonFailure.ComparisonCompactor.DIFF_START + str.substring(this.sharedPrefix.length(), str.length() - this.sharedSuffix.length()) + org.junit.ComparisonFailure.ComparisonCompactor.DIFF_END;
            }
        }
    }
}
