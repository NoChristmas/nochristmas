package tp06.vue.bk.srv.board.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDto {
	private int bd_no;
	private String usr_id;
	private String bd_name;
	private Timestamp bd_time;
	/*
	public void BoardDto(int bd_no, String usr_id, String bd_name, Timestamp bd_time) {
		this.bd_no = bd_no;
		this.usr_id = usr_id;
		this.bd_name = bd_name;
		this.bd_time = bd_time;
	}
	*/
}
