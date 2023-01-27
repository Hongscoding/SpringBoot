package kr.co.farmstory.dao;

import kr.co.farmstory.vo.ArticleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleDAO {

    public List<ArticleVO> selectArticles(@Param("cate")String cate, @Param("start")int start);

    public int selectCountTotal(String cate);

}
