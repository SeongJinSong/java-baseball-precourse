package baseball.port.outbound;

import javax.naming.OperationNotSupportedException;

public class StandardOutput {
    private StandardOutput() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("can not allow initiate Instance");
    }

    public static void println(final Object message) {
        System.out.println(message);
    }

    public static void print(final Object message) {
        System.out.print(message);
    }
}
