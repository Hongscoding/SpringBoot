package kr.co.swiftER.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.swiftER.vo.ErSearchCateVO;
import kr.co.swiftER.vo.ErSearchSubCateVO;

@Mapper
@Repository
public interface ErSerachDAO {
	
	public List<ErSearchCateVO> selectErCate();
	public List<ErSearchSubCateVO> selectErSubCate(String city);
	
}
