package egovframework.example.free.web;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import egovframework.example.free.sevice.FreeBulletinReplyVO;
import egovframework.example.free.sevice.FreeBulletinService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/egovframework/spring/context-*.xml")
public class FreeBulletinControllerTest {
	
	@Resource(name="freeService")
	private FreeBulletinService freeService;
	
	@Test
	public void freeReplyTest() {
//		게시글에 대한 댓글 전체 조회
		FreeBulletinReplyVO rvo = new FreeBulletinReplyVO();
		
		rvo.setFreeNo(4);
		List<FreeBulletinReplyVO> list = freeService.selectListFreeBulletinReply(rvo);
		
		for(FreeBulletinReplyVO fvo : list) {
			System.out.println("=========================================list전체: "+fvo);
			System.out.println("=========================================날짜만: "+fvo.getReplyDate());
			/*Date textDate = fvo.getReplyDate();
			String strDate = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.KOREA);
			
			strDate = sdf.format(textDate);*/
		}
		
		
	}
	
}
