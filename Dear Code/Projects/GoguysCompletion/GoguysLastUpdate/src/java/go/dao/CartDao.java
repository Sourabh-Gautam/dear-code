package go.dao;

import go.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Sourabh Gautam
 */
public class CartDao {

    public static PreparedStatement ps1, ps2, ps3, ps4 = null;

    static {
        try {
            ps1 = DbConnection.getConnection().prepareStatement("insert into usercart values(?,?,?,?,?)");
            ps2 = DbConnection.getConnection().prepareStatement("delete from usercart where userid=?");
            ps3 = DbConnection.getConnection().prepareStatement("select * from usercart where userid = ?");
            ps4 = DbConnection.getConnection().prepareStatement("select * from products");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean addCartProduct(String userid, long pid, int quantity, String unit, double price) throws SQLException {
        ps1.setString(1, userid);
        ps1.setLong(2, pid);
        ps1.setInt(3, quantity);
        ps1.setString(4, unit);
        ps1.setDouble(5, price);
        int result = ps1.executeUpdate();
        if (result >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void removeCart(String phone) {
        try {
            ps2.setString(1, phone);
            ps2.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserCartItems(String phone) throws SQLException, JSONException {
        ps3.setString(1, phone);
        ResultSet rs = ps3.executeQuery();
        JSONObject json = new JSONObject();
        JSONArray id = new JSONArray();
        int count = 1;
        while (rs.next()) {
            id.put(rs.getString("pid"));
            JSONObject innerjson = new JSONObject();
            innerjson.put("userid", rs.getString("userid"));
            innerjson.put("pid", rs.getLong("pid"));
            innerjson.put("qty", rs.getInt("qty"));
            innerjson.put("unit", rs.getString("unit"));
            innerjson.put("price", rs.getString("price"));
            json.put(count + "", innerjson);
            count++;
        }
        json.put("idArr", id);
        return json;
    }
}
