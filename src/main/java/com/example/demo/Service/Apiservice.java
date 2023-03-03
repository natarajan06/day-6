package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Models.Child;
import com.example.demo.Repositories.ChildRepo;
@Service
public class Apiservice {
	
	@Autowired
	ChildRepo repo;
	public List<Child> setpages(@PathVariable int offset,@PathVariable int pages)
	{
		Page<Child> page = repo.findAll(PageRequest.of(offset,pages));
		return page.getContent();
	}
	public List<Child> sort(String field)
	{
		return repo.findAll(Sort.by(Sort.Direction.DESC, field));
	}
	public Page<Child> pagesort(@PathVariable int offset,@PathVariable int pages,String field)
	{
		Pageable paging = PageRequest.of(pages, offset,Sort.by(field));
		return repo.findAll(paging);
	}
}
