
package br.recife.ifpe.edu.model.controllers;


import br.recife.ifpe.edu.model.classes.Cliente;
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
@ManagedBean(name="cController")
@SessionScoped
public class ClienteController {
    private Cliente cadastro;
    private Cliente selecionar;
    
    @PostConstruct
    public void init(){
        cadastro = new Cliente();
    }
    
    public String inserir(){
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        this.cadastro = new Cliente();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente cadastrado com sucesso!"));
        return "listarCliente.xhtml";
    }
    
    public String alterar(){
        ManagerDao.getCurrentInstance().update(this.selecionar);     
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente alterado com sucesso!"));
        return "listarCliente.xhtml";
    }
    
    public void deletar(){
        ManagerDao.getCurrentInstance().delete(this.selecionar);       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cleinte "+ this.selecionar.getNome()+ " deletado com sucesso"));
    }
    
    public List<Cliente> listarTodos(){
        String query="Select c from Cliente c";
        return ManagerDao.getCurrentInstance().read(query, Cliente.class);
    }

    public Cliente getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cliente cadastro) {
        this.cadastro = cadastro;
    }

    public Cliente getSelecionar() {
        return selecionar;
    }

    public void setSelecionar(Cliente selecionar) {
        this.selecionar = selecionar;
    }
    
    
    
    
}
