package com.song.woo.member.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.song.woo.common.domain.BaseEntity;

import lombok.Builder;
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
	@Column(length = 30)
	private String memId;
	@Column(length = 30)
	private String memPw;
	
}
