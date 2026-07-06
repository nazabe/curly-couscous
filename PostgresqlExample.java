
// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresqlExample {
  public PostgresqlExample() {
  }

  public static void main(String[] var0) throws ClassNotFoundException {

    try {
      Connection var1 = DriverManager.getConnection("");

      try {
        Statement var2 = var1.createStatement();

        try {
          ResultSet var3 = var2.executeQuery("SELECT version()");

          try {
            while (var3.next()) {
              System.out.println("Version: " + var3.getString("version"));
            }
          } catch (Throwable var9) {
            if (var3 != null) {
              try {
                var3.close();
              } catch (Throwable var8) {
                var9.addSuppressed(var8);
              }
            }

            throw var9;
          }

          if (var3 != null) {
            var3.close();
          }
        } catch (Throwable var10) {
          if (var2 != null) {
            try {
              var2.close();
            } catch (Throwable var7) {
              var10.addSuppressed(var7);
            }
          }

          throw var10;
        }

        if (var2 != null) {
          var2.close();
        }
      } catch (Throwable var11) {
        if (var1 != null) {
          try {
            var1.close();
          } catch (Throwable var6) {
            var11.addSuppressed(var6);
          }
        }

        throw var11;
      }

      if (var1 != null) {
        var1.close();
      }
    } catch (SQLException var12) {
      System.out.println("Connection failure.");
      var12.printStackTrace();
    }

  }
}
