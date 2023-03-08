package kr.co.swiftER.controller.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		List<ErSearchSubCateVO> sub = service.selectErSubCate();
		
		model.addAttribute("region",region);
		model.addAttribute("sub",sub);
		
		return "search/er";
	}
	
}
