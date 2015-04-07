package com.company.first.sample.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 해당 어노테이션을 사용하면 프레임워크가 해당 클래스를 자동으로 컨트롤러로 인식
@Controller
public class SampleController {
	protected Logger log = Logger.getLogger(getClass());

	@RequestMapping(value = "/sample/openSampleList.do")
	public ModelAndView openSampleList(Map<String, Object> commandMap)
			throws Exception {
		ModelAndView mv = new ModelAndView(""); // 따로 view가 필요하지 않음
		log.debug("인터셉터 테스트");
		System.out.println("인터셉터 테스트");
		return mv;
	}

}
