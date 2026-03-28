package entity;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class test {
	private int userId;
	private String userName;
	private String password;
	private String name;
	private String email;
	private LocalDateTime registerDate;
}
