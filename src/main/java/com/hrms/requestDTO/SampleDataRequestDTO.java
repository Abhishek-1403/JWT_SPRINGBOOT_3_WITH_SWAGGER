package com.hrms.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SampleDataRequestDTO {

	private String name;
	private String password;
	private String emailId;
	private String message;
}
