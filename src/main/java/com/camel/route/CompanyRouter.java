package com.camel.route;

import org.apache.camel.builder.RouteBuilder;


public class CompanyRouter extends RouteBuilder {

   
	@SuppressWarnings("deprecation")
	@Override
    public void configure() throws Exception {
        
		from("direct:insert").log("Inserted new Company").beanRef("companyMapper", "getMap").
        to("sqlComponent:{{sql.insertCompany}}");
        
        from("direct:select").to("sqlComponent:{{sql.getAllCompanies}}")
        .beanRef("companyMapper", "readCompanies").log(" passed ");
    }

}