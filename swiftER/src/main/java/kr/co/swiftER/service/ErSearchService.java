package kr.co.swiftER.service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	public List<ErSearchSubCateVO> selectErSubCate(String city){
		return dao.selectErSubCate(city);
	}
	
	
}
