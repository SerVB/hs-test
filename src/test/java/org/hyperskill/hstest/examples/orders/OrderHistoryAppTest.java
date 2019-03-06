package org.hyperskill.hstest.examples.orders;

import org.hyperskill.hstest.v2.stage.MainMethodTest;
import org.hyperskill.hstest.v2.testcase.CheckResult;
import org.hyperskill.hstest.v2.testcase.PredefinedIOTestCase;

import java.util.List;

public class OrderHistoryAppTest extends MainMethodTest {

    public OrderHistoryAppTest() throws Exception {
        super(OrderHistoryApp.class);
    }

    /**
     * It generates a list of testcases with a specified input for stdin
     */
    @Override
    public List<PredefinedIOTestCase> generatePredefinedInputOutput() {
        return List.of(
                new PredefinedIOTestCase(
                        "apples 100\noranges 200\n/orders\n/exit",
                        "Order: apples, cost: 100\nOrder: oranges, cost: 200\n"
                ),
                new PredefinedIOTestCase(
                        "apples\nexit",
                        "Invalid order"
                )
        );
    }

    /**
     * It checks our solution equal a learner's solution ignoring cases.
     * It also skips all welcome information
     */
    @Override
    public CheckResult checkSolved(String reply, String clue) {
        reply = reply.toUpperCase();
        clue = clue.toUpperCase();
        return new CheckResult(reply.contains(clue));
    }

}