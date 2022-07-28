package egovframework.example.cost.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.cost.sevice.CostReplyService;
import egovframework.example.cost.sevice.CostReplyVO;
import egovframework.example.cost.sevice.CostService;
import egovframework.example.cost.sevice.CostVO;

@RestController
public class CostRestController {
	
	@Resource(name="costService")
	private CostService costService;
	
	@Resource(name="costReplyService")
	private CostReplyService costReplyService;
	
	@RequestMapping("/ajaxCalendarInfo.do")
	public List<CostVO> ajaxCalendarInfo() {
		List<CostVO> cals = costService.costCalendarList();

		return cals;
	}
	
	@RequestMapping("/ajaxInsertReply.do")
	public List<CostReplyVO> ajaxInsertReply(CostReplyVO vo) {
		int insert = costReplyService.insertCostReply(vo);
		if(insert == 0) {
			return null;
		}
		
		List<CostReplyVO> list = costReplyService.selectCostReply(vo);
		return list;
	}
	
	@RequestMapping("/ajaxDeleteReply.do")
	public String ajaxDeleteReply(CostReplyVO vo) {
		int delete = costReplyService.deleteCostReply(vo);
		if(delete == 0) {
			return null;
		}
		return "success";
	}
	
	@PostMapping("/ajaxCostChartValue.do")
	public List<CostVO> ajaxCostChartValue(@RequestParam("year") String year){
		List<CostVO> list = costService.costSumByYear(year);
		if(list == null) {
			return null;
		}
		return list;
	}
	
}
