package baseball.port.inbound;

import camp.nextstep.edu.missionutils.Console;

import javax.naming.OperationNotSupportedException;

public class StandardInput {
    private StandardInput() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("can not allow initiate Instance");
    }

    public static String readLine() {
        return Console.readLine();
    }
}
