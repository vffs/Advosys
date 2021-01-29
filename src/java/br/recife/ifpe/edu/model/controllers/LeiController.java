
package br.recife.ifpe.edu.model.controllers;

import br.recife.ifpe.edu.model.classes.Lei;
import br.recife.ifpe.edu.model.dao.ManagerDao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author valeria
 */
@ManagedBean(name="lController")
@SessionScoped 
public class LeiController {
    private Lei cadastro;
    private Lei selecionar;
    
    @PostConstruct
    public void init(){
        cadastro = new Lei();
    }
    
    public String inserir(){
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        this.cadastro = new Lei();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lei cadastrada com sucesso!"));
        return "listarLei.xhtml";
    }
    
    public String alterar(){
        ManagerDao.getCurrentInstance().update(this.selecionar);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lei alterada com sucesso!"));
        return "listarLei.xhtml";
    }
    
    public void deletar(){
        ManagerDao.getCurrentInstance().delete(this.selecionar);
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Lei deletada com sucesso"));
    }
    
    public List<Lei> listarTodos(){
        return ManagerDao.getCurrentInstance().read("Select l from Lei l", Lei.class);
    }
    
    public Lei getCadastro() {
        return cadastro;
    }

    public void setCadastro(Lei cadastro) {
        this.cadastro = cadastro;
    }

    public Lei getSelecionar() {
        return selecionar;
    }

    public void setSelecionar(Lei selecionar) {
        this.selecionar = selecionar;
    }
    
  
}
