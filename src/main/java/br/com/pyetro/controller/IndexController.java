package br.com.pyetro.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexController implements Serializable{

	private static final long serialVersionUID = 5772699247607658016L;
	
	
	public String goToPessoaPage() {
		return "/pessoa/list.xhtml";
	}

}
