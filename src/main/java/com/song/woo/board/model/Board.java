package com.song.woo.board.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자를 외부에 열어두지 않는다.
@ToString
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;
	@NotBlank(message = "제목은 필수값 입니다.")
	private String title;
	@NotBlank(message = "내용은 필수값 입니다.")
	private String content;
	@NotBlank(message = "작성자는 필수값 입니다.")
	private String memId;
	private long cnt;
	
	@Builder
	public Board(String title, String content, String memId, long cnt) {
		super();
		this.title = title;
		this.content = content;
		this.memId = memId;
		this.cnt = cnt;
	}
}
