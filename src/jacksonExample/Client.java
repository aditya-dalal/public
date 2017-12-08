package jacksonExample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by aditya.dalal on 02/02/17.
 */
public class Client {
    public static void main(String[] args) throws JsonProcessingException {
        String userStr = "{\"first-name\": \"aditya\", \"lastName\": \"Dalal\", \"age\": 33}";

        User user = new User();
        ObjectMapper mapper = new ObjectMapper();
        try {
            user = mapper.readValue(userStr, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(user.toString());

        System.out.println(mapper.writeValueAsString(user));
    }
}
