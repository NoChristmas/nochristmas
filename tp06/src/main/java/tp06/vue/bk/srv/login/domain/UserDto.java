package tp06.vue.bk.srv.login.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserDto implements Serializable {
	private int usr_no;
	private String usr_id;
	private String usr_pwd;
	private Timestamp usr_time;
}
