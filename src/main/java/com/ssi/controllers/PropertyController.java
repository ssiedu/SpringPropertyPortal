package com.ssi.controllers;

import java.io.IOException;
import java.sql.Blob;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.PropertyDAO;
import com.ssi.entities.Property;

@Controller
public class PropertyController {

	@Autowired
	PropertyDAO propertyDAO;
	
	
	@RequestMapping("imageLoader")
	public void showImage(@RequestParam("pcode") String pcode, HttpServletResponse response){
		Property property=propertyDAO.searchProperty(pcode);
		Blob photo=property.getPhoto();
		byte b[]=null;
		try{
		b=photo.getBytes(1, (int)photo.length());
		ServletOutputStream out=response.getOutputStream();
		out.write(b);
		out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@RequestMapping("registryLoader")
	public void showRegistry(@RequestParam("pcode") String pcode, HttpServletResponse response){
		response.setContentType("application/pdf");
		Property property=propertyDAO.searchProperty(pcode);
		Blob registry=property.getRegistry();
		byte b[]=null;
		try{
		b=registry.getBytes(1, (int)registry.length());
		ServletOutputStream out=response.getOutputStream();
		out.write(b);
		out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping("searchproperty")
	public ModelAndView showPropertyDetails(@RequestParam("pcode") String pcode){
		Property property=propertyDAO.searchProperty(pcode);
		ModelAndView mv=new ModelAndView("propertydetails");
		mv.addObject("property", property);
		return mv;
	}
	
	@RequestMapping("searchform")
	public String showSearchForm(){
		return "search";
	}
	
	@RequestMapping("saveproperty")
	public String savePropertyDetails(@ModelAttribute("property") Property property, @RequestParam("f1") MultipartFile file1, @RequestParam("f2") MultipartFile file2){
		
		byte b1[]=null;
		byte b2[]=null;
		
		try {
			b1=file1.getBytes();
			Blob blob1=BlobProxy.generateProxy(b1);
			property.setPhoto(blob1);
			
			b2=file2.getBytes();
			Blob blob2=BlobProxy.generateProxy(b2);
			property.setRegistry(blob2);
			
			propertyDAO.saveProperty(property);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "propertysuccess";
	}
	
	@RequestMapping("newproperty")
	public String showPropertyEntryForm(){
		return "propertyentry";
	}
	
	
}
