package access;

import static net.mindview.util.Print.printf;

class ConnectionManager {

    private static int limit;
    private static int count;

    public static boolean setLimit(int newLimit) {
        if (ConnectionManager.limit != 0)
            return false;
        ConnectionManager.limit= newLimit;
        return true;
    }

    public static int getLimit() { return limit; }

    private ConnectionManager() {}

    public static class Connection {
        private Connection() {}
    }

    public static Connection open() {
        if (count == limit)
            return null;
        count++;
        return new Connection();

    }

    public static boolean close() {
        if (count == 0)
            return false;
        count--;
        return true;
    }
}

public class Exercise8 {

    public static void main(String[] args) {

        checkConnectionLimit(
                ConnectionManager.setLimit(3));

        for (int i=0; i < 5; i++) {
            ConnectionManager.Connection c= ConnectionManager.open();
            if (c != null)
                printf("Connection no. %d opened.%n", i);
            else
                printf("Connection no. %d not opened.%n", i);
            printf("Total connections %d.%n", ConnectionManager.getLimit());
        }

        checkConnectionLimit(
                ConnectionManager.setLimit(5));
    }

    static void checkConnectionLimit(boolean connectionSetResult) {
        if (connectionSetResult)
            printf("Connection limit set to %d.%n", ConnectionManager.getLimit());
        else
            printf("Connection limit remains %d.%n", ConnectionManager.getLimit());
    }

}





















