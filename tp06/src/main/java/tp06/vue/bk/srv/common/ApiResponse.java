package tp06.vue.bk.srv.common;

import java.util.LinkedHashMap;
import java.util.List;

import lombok.Data;

@Data
public class ApiResponse {
    private String result;
    private int code;
    private String message;
    private List<LinkedHashMap<String, Object>> data;
    
    public ApiResponse(String result, int code, String message, List<LinkedHashMap<String, Object>> data) {
        this.result = result;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
