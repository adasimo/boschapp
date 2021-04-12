package com.adamsimon.bosch.feladat2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adamsimon.bosch.feladat2.interfaces.ReadWriteControllerI;
import com.adamsimon.bosch.feladat2.interfaces.ReadWriteServiceI;

@Controller
@RequestMapping(value = "/readwrite", produces = "application/json;charset=UTF-8")
public class ReadWriteController implements ReadWriteControllerI {

	
	@Autowired
	private ReadWriteServiceI readWriteService;
	
	
	@Override
	@GetMapping("/")
	public String getReadWrite() {
		return "feladat2/readwrite.html";
	}
	
	@Override
	@GetMapping("/do")
	public String doReadWrite(Model model) {
				
		/********************************************************************************/
		/**********************standard connection establishing**************************/
		/**********************after mysql driver jar including**************************/
		/**********************but I use the embedded H2 db with MYSQL mode**************/
		/**********************for better compact shipping in this***********************/
		/**********************the connecton data is included in application.properties**/
		/**********************and did by spring ****************************************/
		/*try{  																		*/
		/*	Class.forName("com.mysql.jdbc.Driver");  									*/
		/*	Connection con=DriverManager.getConnection(  								*/
		/*	"jdbc:mysql://localhost:3306/cs_beugro","root","pass");  
			
		/*	Statement stmt=con.createStatement();  										*/
		/*	ResultSet rs=stmt.executeQuery(THE QUERY);  								*/
		/*	while(rs.next()) {															*/
		/*	 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));*/
		/*	}																			*/
		/*	  																			*/
		/*	con.close();  																*/
		/*} catch(Exception e) {														*/
		/*		e.printStackTrace();													*/
		/*}  																			*/
		/********************************************************************************/
		
		if (this.readWriteService.doReadWrite()) {
			
			model.addAttribute("success", true);
		} else {
			model.addAttribute("success", false);
		}
		
		return "feladat2/readwrite.html";
	}
	
}
