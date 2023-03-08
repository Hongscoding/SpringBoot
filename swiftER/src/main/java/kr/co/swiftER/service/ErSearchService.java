package kr.co.swiftER.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.swiftER.dao.ErSerachDAO;
import kr.co.swiftER.vo.ErSearchCateVO;
import kr.co.swiftER.vo.ErSearchSubCateVO;

@Service
public class ErSearchService {
	
	@Autowired
	private ErSerachDAO dao;
	
	public List<ErSearchCateVO> selectErCate(){
		return dao.selectErCate();
	}
	
	public List<ErSearchSubCateVO> selectErSubCate(int city){
		return dao.selectErSubCate(city);
	}
	
	
}
