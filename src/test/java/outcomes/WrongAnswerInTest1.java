package outcomes;

import mock.WithoutException;
import org.hyperskill.hstest.v4.stage.MainMethodTest;
import org.hyperskill.hstest.v4.testcase.CheckResult;
import org.hyperskill.hstest.v4.testcase.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

public class WrongAnswerInTest1 extends MainMethodTest {

    public WrongAnswerInTest1() throws Exception {
        super(WithoutException.class);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        exception.expect(AssertionError.class);
        exception.expectMessage("Wrong answer in test #1");
    }

    @Override
    public List<TestCase> generateTestCases() {
        return Arrays.asList(
            new TestCase()
        );
    }

    @Override
    public CheckResult check(String reply, Object clue) {
        return CheckResult.FALSE;
    }
}
