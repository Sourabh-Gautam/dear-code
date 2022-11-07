package go.handler;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageHandler {

    public String base64Encode(File f) throws FileNotFoundException, IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        InputStream is = new FileInputStream(f);
        byte[] bytes = null;
        byte[] buffer = new byte[(int) f.length()];
        String base64Image = null;
        int bytesRead = -1;
        while ((bytesRead = is.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        bytes = os.toByteArray();
        Base64.Encoder en = Base64.getEncoder();
        base64Image = en.encodeToString(bytes);
        is.close();
        return base64Image;
    }

    public HashMap<String, String> getImage(HttpServletRequest request, JSONObject json) throws JSONException, FileNotFoundException, IOException {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 1; i <= json.length(); i++) {
            JSONObject myjson = (JSONObject) json.get("" + i);
            String pname = myjson.getString("pname");
            String PATH = request.getServletContext().getRealPath("/");
            String directoryName = PATH.concat("images/product/" + pname + "/1.jpg");
            File f = new File(directoryName);
            String image = base64Encode(f);
            map.put(pname, image);
        }
        return map;
    }
}
