package comp4111.restful.core;

/**
 * Created by SC on 20/3/2018.
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {

    public static ResponseEntity<String> createResponseEntity(String message, HttpStatus statusCode){
        return new ResponseEntity<>(message, statusCode);
    }

}