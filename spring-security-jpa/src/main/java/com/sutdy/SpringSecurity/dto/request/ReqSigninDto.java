package com.sutdy.SpringSecurity.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class ReqSigninDto {

//    @Pattern(regexp = "^[a-z0-9]{6,}$", message = "사용자이름은 6자이상의 영소문자, 숫자 조합이어야합니다.")
    @NotBlank(message = "아이디 입력하숑")
    private String username;
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[~!@#$%^&*?])[a-zA-Z\\d~!@#$%^&*?]{8,16}$", message = "비밀번호는 8자이상 16자이하의 영대소문, 숫자조합, 특수문자(~!@#$%^&*?)를 포함하여야합니다.")
    @NotBlank(message = "비번 입력")
    private String password;

}
