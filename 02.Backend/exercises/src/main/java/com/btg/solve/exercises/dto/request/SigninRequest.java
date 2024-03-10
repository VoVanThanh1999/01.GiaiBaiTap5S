package com.btg.solve.exercises.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SigninRequest {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
}
