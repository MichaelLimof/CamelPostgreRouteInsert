package com.camel.domain;




public class Company {

   private String nome;
   private String cnpj;
   private String setor;
   private String cep;
   private String telefone;
   
   
   
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCnpj() {
	return cnpj;
}
public void setCnpj(String cnpj) {
	this.cnpj = cnpj;
}
public String getSetor() {
	return setor;
}
public void setSetor(String setor) {
	this.setor = setor;
}
public String getCep() {
	return cep;
}
public void setCep(String cep) {
	this.cep = cep;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
@Override
public String toString() {
	return "Company [nome=" + nome + ", cnpj=" + cnpj + ", setor=" + setor + ", cep=" + cep + ", telefone=" + telefone
			+ "]";
}
}
