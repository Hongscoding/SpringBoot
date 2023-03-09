package kr.co.swiftER.controller.search;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
	public List<ErSearchSubCateVO> cate(String city) {
//		System.out.println("city :" + city);
		
		List<ErSearchSubCateVO> sub = service.selectErSubCate(city);
		
		return sub;
	}
	
}
