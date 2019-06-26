package com.camel;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.camel.domain.Company;

public class MainApp {
	public static void main(String[] args) {
       
		 try {
	            ApplicationContext springCtx = new ClassPathXmlApplicationContext("database-context.xml");

	            CamelContext context = springCtx.getBean("companyContext", CamelContext.class);

	            context.start();

	            ProducerTemplate producerTemplate = context.createProducerTemplate();

	            // Insert Company 1
	            Company comp1 = getCompany1();
	            String resp = producerTemplate.requestBody("direct:insert", comp1, String.class);

	            // Insert Company 2
	            Company comp2 = getCompany2(); 
	            resp = producerTemplate.requestBody("direct:insert", comp2, String.class);

	            // Get Employee of inserted employees
	            List<Company> companies = producerTemplate.requestBody("direct:select", null, List.class);
	            System.out.println("companies:" + companies);

	        }
	        catch (Exception e) {

	            e.printStackTrace();

	        }
	    }

	    private static Company getCompany1() {

	        Company comp = new Company();

	        comp.setNome("empId1");
	        comp.setCnpj("1232-2312/00023");
	        comp.setSetor("construcao");
	        comp.setCep("12324-443");
	        comp.setTelefone("19993843443");
	        
	        
	        return comp;

	    }

	    private static Company getCompany2() {

	        Company comp = new Company();

	        comp.setNome("Aviacao BR");
	        comp.setCnpj("5645-7688/00399");
	        comp.setSetor("aviacao");
	        comp.setCep("16577-566");
	        comp.setTelefone("19999834004");
	        
	        
	        return comp;
	    }
}