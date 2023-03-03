package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Child;
import com.example.demo.Repositories.ChildRepo;
import com.example.demo.Service.Apiservice;

@RestController
public class ApiController {
	
	@Autowired
	ChildRepo repo;
	@Autowired
	Apiservice s2;
	@GetMapping("/get")
	List<Child> getlist()
	{
		return repo.findAll();
	}
	@PostMapping("/post")
	public Child create(@RequestBody Child d)
	{
		return repo.save(d);
	}
	@GetMapping("/sort/{field}")
	public List<Child> asc(@PathVariable String field)
	{
		return s2.sort(field);
	}
	@GetMapping("/details/{offset}/{pages}")
	public List<Child> pagination(@PathVariable int offset,@PathVariable int pages)
	{
		return s2.setpages(offset, pages);
	}
	@GetMapping("/geti/{offset}/{pages}/{field}")
	public List<Child> paginationsorting(@PathVariable int offset,@PathVariable int pages,@PathVariable String field)
	{
		Page<Child> pi=s2.pagesort(offset, pages,field);
		return pi.getContent();
	}

}
