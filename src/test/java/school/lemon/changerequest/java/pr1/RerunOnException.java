package school.lemon.changerequest.java.pr1;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * A {@link TestRule} that allows re-running the test case in case a specific exception is thrown.
 */
public class RerunOnException implements TestRule {
    private int rerunCount;
    private final Class<? extends Throwable>[] exceptionsToRerun;

    @SafeVarargs
    public RerunOnException(int rerunCount, Class<? extends Throwable>... exceptionsToRerun) {
        this.rerunCount = rerunCount;
        this.exceptionsToRerun = exceptionsToRerun;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return statement(base, description);
    }

    private Statement statement(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable caughtThrowable = null;
                String displayName = description.getDisplayName();
                for (int i = 0; i < rerunCount; i++) {
                    try {
                        base.evaluate();
                        return;
                    } catch (Throwable t) {
                        if (!shouldRerun(t)) {
                            throw t;
                        }
                        caughtThrowable = t;
                        String errorMessage = String.format("%s: run %d failed.", displayName, i + 1);
                        System.err.println(errorMessage);
                    }
                }
                String errorMessage = String.format("%s: giving up after %d failures.", displayName, rerunCount);
                System.err.println(errorMessage);
                //noinspection ConstantConditions throwable can not be null here.
                throw caughtThrowable;
            }
        };
    }

    private boolean shouldRerun(Throwable t) {
        if (exceptionsToRerun == null) {
            return false;
        }
        for (Class<? extends Throwable> throwable : exceptionsToRerun) {
            if (throwable.isInstance(t)) {
                return true;
            }
        }
        return false;
    }
}