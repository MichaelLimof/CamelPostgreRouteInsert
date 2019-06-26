package com.camel.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.camel.domain.Company;

public class CompanyMapper {

	public Map<String, Object> getMap(Company company) {
		Map<String, Object> answer = new HashMap<String, Object>();
		answer.put("nome", company.getNome());
		answer.put("cnpj", company.getCnpj());
		answer.put("setor", company.getSetor());
		answer.put("cep", company.getCep());
		answer.put("telefone", company.getTelefone());
		return answer;
	}

	public List<Company> readCompanies(List <Map<String, String>>dataList) {
		System.out.println("data:" + dataList);

		List<Company> companies = new ArrayList<Company>();

		for (Map<String, String> data : dataList) {

			Company company = new Company();

			company.setNome(data.get("nome"));
			company.setCnpj(data.get("cnpj"));
			company.setSetor(data.get("setor"));
			company.setCep(data.get("cep"));
			company.setTelefone(data.get("telefone"));

			companies.add(company);

		}

		return companies;

	}

}
