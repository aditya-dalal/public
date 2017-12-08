package jacksonExample;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by aditya.dalal on 02/02/17.
 */

@Getter
@Setter
public class User {
    String firstName;
    String lastName;
    int age;

    @JsonProperty("first-name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first-name")
    public void setFirstName(String name) {
        firstName = name;
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName + ", " + age;
    }
}
