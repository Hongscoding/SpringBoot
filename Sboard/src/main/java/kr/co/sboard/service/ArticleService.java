package kr.co.sboard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard.dao.ArticleDAO;
import kr.co.sboard.vo.ArticleVO;
import kr.co.sboard.vo.FileVo;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleDAO dao;


	public int insertArticle(ArticleVO vo) {
		
		int result = 0;
		MultipartFile file = vo.getFname();
		
		if(file.isEmpty()) {
			//파일 첨부 X
			vo.setFile(0);
			result = dao.insertArticle(vo);
			
		}else {
			//파일 첨부 O
			vo.setFile(1);
			result = dao.insertArticle(vo);
			
			// 파일 업로드
			FileVo fileVO = new FileVo();
			fileVO.setParent(vo.getNo());
			
			fileUpload(file, fileVO);
			
			// 파일 등록
			dao.insertFile(fileVO);
			
			
		}
		
		return result;
	}
	public ArticleVO selectArticle(int no) {
		return dao.selectArticle(no);
	}
	public List<ArticleVO> selectArticles(){
		return dao.selectArticles();
	}
	public int updateArticle(ArticleVO vo) {
		return dao.updateArticle(vo);
	}
	public int  deleteArticle(int no) {
		return dao.deleteArticle(no);
	}
	
	//파일 업로드
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	
	public void fileUpload(MultipartFile file, FileVo fileVO) {
		// 시스템 파일 경로
		String path = new File("경로").getAbsolutePath();
		
		//새 파일명 생성
		String oName = file.getOriginalFilename();
		// 확장자 추출
		String ext = oName.substring(oName.lastIndexOf("."));
		String nName = UUID.randomUUID().toString()+ext;
		
		//파일 저장
		fileVO.setOriName(oName);
		fileVO.setNewName(nName);
		
		
		try {
			file.transferTo(new File(path, nName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
			
			
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
