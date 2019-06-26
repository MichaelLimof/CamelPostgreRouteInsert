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

	            // Get Company of inserted companies
	            List<Company> companies = producerTemplate.requestBody("direct:select", null, List.class);
	            System.out.println("companies:" + companies);

	        }
	        catch (Exception e) {

	            e.printStackTrace();

	        }
	    }

	    private static Company getCompany1() {

	        Company comp = new Company();

	        comp.setNome("Metais Vilares");
	        comp.setCnpj("1293-4304/00875");
	        comp.setSetor("Metalurgica");
	        comp.setCep("18903-776");
	        comp.setTelefone("1923458765");
	        
	        
	        return comp;

	    }

	    private static Company getCompany2() {

	        Company comp = new Company();

	        comp.setNome("Consultories FEM");
	        comp.setCnpj("2356-0083/00078");
	        comp.setSetor("Servicos");
	        comp.setCep("16123-344");
	        comp.setTelefone("19987763423");
	        
	        
	        return comp;
	    }
}