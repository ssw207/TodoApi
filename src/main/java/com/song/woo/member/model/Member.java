package com.song.woo.member.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.song.woo.common.domain.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Member extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	@NotBlank(message = "아이디는 필수 값 입니다!!")
	@Pattern(regexp="\\S{2,6}", message="이름은 2~6자로 입력해주세요.")
	@Pattern(regexp="\\S", message="공백문자를 입력할 수 없습니다!!")
	@Column(length = 30)
	private String memId;
	
	@NotBlank(message = "비밀번호는 필수 값 입니다!!")
	@Pattern(regexp="\\S", message="공백문자를 입력할 수 없습니다!!")
	@Column(length = 30)
	private String memPw;
	
	@NotBlank(message = "이름은 필수 값 입니다!!")
	@Pattern(regexp="\\S", message="공백문자를 입력할 수 없습니다!!")
	private String nmName;
}
