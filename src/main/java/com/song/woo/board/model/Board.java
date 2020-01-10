package com.song.woo.board.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.song.woo.common.domain.BaseEntity;
import com.song.woo.member.model.Member;

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
public class Board extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;
	
	@NotBlank(message = "제목은 필수값 입니다.")
	private String title;
	
	@NotBlank(message = "내용은 필수값 입니다.")
	private String content;
	
//	@NotBlank(message = "작성자는 필수값 입니다.")
//	private String memId;
	
	private long cnt;
	/*
	 * Optional : 연관관계가 선택적인가?
	 * fetch : 페치전략. EAGER 연관 엔티티 동시조회. LAZY는 실제사용시 조회
	 * cascade : 연관엔티티를 같이 저장, 삭제시 사용
	 */
	@ManyToOne // 여러개의 게시글은 하나의 회원객체를 참조한다.(다대일 관계)
	@JoinColumn(name="MEM_ID", nullable=false) // FK 설정 fk로 맴버객체를 조회한다. nullable=false 인경우 inner join 없으면 left outer join
	private Member memeber;
	
	@Builder
	public Board(String title, String content, long cnt, Member memeber) {
		super();
		this.title = title;
		this.content = content;
		this.cnt = cnt;
		this.memeber = memeber;
	}
}
