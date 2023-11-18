package functionalprogramming;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionuUrlSupplierList.get());

    }

    static String getDBConnectionuUrl() {
        return "jdbc://localhost:5432/users";
    }

    static Supplier<String> getDBConnectionuUrlSupplier = () ->
            "jdbc://localhost:5432/users";

    static Supplier<List<String>> getDBConnectionuUrlSupplierList = () ->
          List.of( "jdbc://localhost:5432/users");
}
