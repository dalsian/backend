package edu.mum.cinema.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cinema.model.template.LayoutTemplate;
import edu.mum.cinema.model.template.SeatTemplate;
import edu.mum.cinema.model.template.SectionTemplate;
import edu.mum.cinema.service.template.ITemplateService;
import edu.mum.cinema.util.BeanUtil;

@RestController
public class TemplateController {
	
	@Autowired
	private ITemplateService templateService;
	
	@GetMapping("/layouttemplate/{id}")
	public ResponseEntity<LayoutTemplate> getLayoutTemplate(@PathVariable("id") long id) {
		LayoutTemplate template = templateService.getLayoutTemplate(id);
		return ResponseEntity.ok().body(template);
	}
	
	@GetMapping("/layouttemplate")
	public ResponseEntity<List<LayoutTemplate>> getAllLayoutTemplate() {
		List<LayoutTemplate> templateList = templateService.getAllLayoutTemplate();
		return ResponseEntity.ok().body(templateList);
	}
	
	@GetMapping("/sectiontemplatebylayoutid/{id}")
	public ResponseEntity<List<edu.mum.cinema.dto.SectionTemplate>> getsectionTemplateByLayoutId(@PathVariable("id") long id) {
		LayoutTemplate layoutTemplate = templateService.getLayoutTemplate(id);
		List<edu.mum.cinema.dto.SectionTemplate> sectionList = new ArrayList<>();
		
		if (layoutTemplate.getSectionTemplateList() != null) {
			for(SectionTemplate template : layoutTemplate.getSectionTemplateList()) {
				sectionList.add(BeanUtil.toSectionTemplateDto(template));
			}
		}
		
		return ResponseEntity.ok().body(sectionList);
	}
	
	@GetMapping("/sectiontemplate/{id}")
	public ResponseEntity<SectionTemplate> getSectionTemplate(@PathVariable("id") long id) {
		SectionTemplate template = templateService.getSectionTemplate(id);
		return ResponseEntity.ok().body(template);
	}
	
	@GetMapping("/sectiontemplate")
	public ResponseEntity<List<SectionTemplate>> getAllSectionTemplate() {
		List<SectionTemplate> templateList = templateService.getAllSectionTemplate();
		return ResponseEntity.ok().body(templateList);
	}
	
	@GetMapping("/seattemplate/{id}")
	public ResponseEntity<SeatTemplate> getSeatTemplate(@PathVariable("id") long id) {
		SeatTemplate template = templateService.getSeatTemplate(id);
		return ResponseEntity.ok().body(template);
	}
	
	@GetMapping("/seattemplate")
	public ResponseEntity<List<SeatTemplate>> getAllSeatTemplate() {
		List<SeatTemplate> templateList = templateService.getAllSeatTemplate();
		return ResponseEntity.ok().body(templateList);
	}
}
