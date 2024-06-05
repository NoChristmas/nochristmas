package tp06.vue.bk.srv.common;

import lombok.Data;

@Data
public class ApiResponse {
    private String result;
    private int code;
    private String message;
    private String data;
    
    public ApiResponse(String result, int code, String message, String data) {
        this.result = result;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
