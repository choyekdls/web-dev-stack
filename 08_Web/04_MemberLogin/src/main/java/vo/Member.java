package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Member {

	private String name;
	private String id;
	private String pwd;
	private int age;
	
}
