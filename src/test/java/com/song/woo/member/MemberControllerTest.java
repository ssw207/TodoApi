package com.song.woo.member;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.song.woo.member.model.Member;
import com.song.woo.member.service.MemberService;

@RunWith(SpringRunner.class)
/* @Controller, @RestController가 설정된 클래스를 메모리에 생성(@Service, @Repository 생성X) */
//@WebMvcTest 
/* 
 * 서블릿 컨테이너를 구동하지않고 테스트용 컨테이너를 사용한다.
 *  webMvcTest와 다르게 @Service, @Repository 객체들도 메모리에 올린다.
 * */
@SpringBootTest(webEnvironment = WebEnvironment.MOCK) 
@AutoConfigureMockMvc // 위의 설정으로 모킹한 객체를 의존성으로 주입받는다.
public class MemberControllerTest {

	@Autowired
	private MockMvc mockMvc; // 서블릿 컨테이너를 모방한 테스트 객체
	
	@MockBean
	private MemberService s;
	
	@Test
	public void 컨트롤러테스트() throws Exception {
		//given
		Member member= Member.builder().memId("admin").memPw("1234").memName("admin2").build();
		
		when(s.memberSave(member))
			.thenReturn(member);
		
		mockMvc.perform(post("/api/member/save") // url요청
				.accept(MediaType.APPLICATION_JSON))			
				.andExpect(status().isOk()) // 결과
				.andExpect(jsonPath("$.memId").value("admin"))
				.andDo(print());
	}
}
