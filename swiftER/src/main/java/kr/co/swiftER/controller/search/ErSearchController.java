package kr.co.swiftER.controller.search;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.xdevapi.JsonArray;

import kr.co.swiftER.service.ErSearchService;
import kr.co.swiftER.vo.ErSearchCateVO;
import kr.co.swiftER.vo.ErSearchSubCateVO;

@Controller
public class ErSearchController {
	
	@Autowired
	private ErSearchService service;
	
	@GetMapping("search/er")
	public String er(Model model) {
		List<ErSearchCateVO> region = service.selectErCate();
		
		
		model.addAttribute("region",region);
		
		return "search/er";
	}
	
	@PostMapping("search/subregion")
	@ResponseBody
	public List<ErSearchSubCateVO> cate(int city) {
//		System.out.println("city :" + city);
		
		List<ErSearchSubCateVO> sub = service.selectErSubCate(city);
		
		return sub;
	}
	
}
