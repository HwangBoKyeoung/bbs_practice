package egovframework.example.movie.service.web;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import egovframework.example.movie.sevice.MovieCodeVO;
import egovframework.example.movie.sevice.MovieVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/egovframework/spring/context-*.xml")
public class MovieTest {
	
	@Autowired
	private String uploadPath;

	@Test
	public void movieInsert(MovieVO vo, List<MultipartFile> files, Map<String, Object> map, MovieCodeVO cvo) {
		List<MultipartFile> fileList = files;
		
		for(MultipartFile mf : fileList) {			
			System.out.println("******************************"+mf);
			String orinalFileName = mf.getOriginalFilename();
			String uId = UUID.randomUUID().toString();
			
			System.out.println("******************************"+orinalFileName);
			System.out.println("******************************"+uId);
			
			String fileRename = uId + orinalFileName.substring(orinalFileName.lastIndexOf("."));
			System.out.println("******************************"+fileRename);
			
			File target = new File(uploadPath, fileRename);
			try {
				FileCopyUtils.copy(mf.getBytes(), target);
				fileRename = File.separator + fileRename;;
				
				System.out.println("******************************"+cvo.getMovieCd());
				
				map.put("v_cd", "m"+cvo.getMovieCd());
				map.put("v_cd_detail", orinalFileName);
				map.put("v_cd_rename", fileRename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		map.put("v_name", vo.getMovieName());
		map.put("v_conent", vo.getMovieConent());
		map.put("v_director", vo.getMovieDirector());
		map.put("v_actor", vo.getMovieActor());
		map.put("v_price", vo.getMoviePrice());
		
		System.out.println("=================================="+map);
	}

}
