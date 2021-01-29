
package br.recife.ifpe.edu.model.controllers;

import br.recife.ifpe.edu.model.classes.Advogado;
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
@ManagedBean(name="aController")
@SessionScoped
public class AdvogadoController {
    
    private Advogado cadastro;
    private Advogado selecionar;
    
    @PostConstruct
    public void init(){
        cadastro = new Advogado();
    }
    
    public String inserir(){
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        cadastro = new Advogado();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Advogado cadastrado com sucesso!"));
        return "faces/listarAdvogados.xhtml";
    }
    
    public String alterar(){
        ManagerDao.getCurrentInstance().update(this.selecionar);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Advogado alterado com sucesso!"));
        return "faces/listarAdvogados.xhtml";
    }
    
    public void deletar(){
        ManagerDao.getCurrentInstance().delete(this.selecionar);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Advogado "+this.selecionar.getNome() + " deletado com sucesso") );
    }
    
    public List<Advogado> listarTodos(){
        String query = "Select a from Advogado a";
        return ManagerDao.getCurrentInstance().read(query, Advogado.class);
    }

    public Advogado getCadastro() {
        return cadastro;
    }

    public void setCadastro(Advogado cadastro) {
        this.cadastro = cadastro;
    }

    public Advogado getSelecionar() {
        return selecionar;
    }

    public void setSelecionar(Advogado selecionar) {
        this.selecionar = selecionar;
    }
    
    
    
    
}
