package Util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

        public static ResponseEntity<Object> generateResponse(HttpStatus status, boolean success, String message, Object result) {
            Map<String,Object> response=new HashMap<>();
            response.put("timeStamp", new Date());
            response.put("message", message);
            response.put("success", success);
            response.put("status", status.value());
            response.put("body", result);
            return new ResponseEntity<>(response,status);
        }

    }

