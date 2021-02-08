import com.RestapiSend;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import static com.RestapiSend.search;

public class test {

    public static void main(String[] args) throws Exception {


        int[] numberArray = {0, 1, 2, 3, 4, 5, 6, 7};
        // length = 8

        int len = numberArray.length; // 8, 고정

        for (int index = 0; index < len; index++) {
            //  (new) numberArray = {0, 1, 2, 5, 6, 7}; 길이 6
            int currentNumber = numberArray[7];
            System.out.println(currentNumber);
            // 0 1 2 3d 4d 5 6

        }
    }
}