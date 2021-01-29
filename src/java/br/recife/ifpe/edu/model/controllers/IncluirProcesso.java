
package br.recife.ifpe.edu.model.controllers;

import br.recife.ifpe.edu.model.classes.Historico;
import br.recife.ifpe.edu.model.classes.Processo;
import br.recife.ifpe.edu.model.dao.ManagerDao;
import java.text.ParseException;
import java.util.Calendar;
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
@ManagedBean(name="ipController")
@SessionScoped 
public class IncluirProcesso {
    private Processo cadastrar;
    private Processo selecionar;
    
    @PostConstruct
    public void init(){
      cadastrar = new Processo();      
    }
    
    public String inserir(){
        ManagerDao.getCurrentInstance().insert(this.cadastrar);
        this.cadastrar = new Processo();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Processo incluído com sucesso!"));
        return "listarProcessos.xhtml";
    }
    
    public String alterar(String descricao,String parecer) {
        int statusAnterior = this.cadastrar.getStatus();
        Historico historico = new Historico();
                
        Calendar calendar = Calendar.getInstance(); 

        historico.setDescricao(descricao);
        historico.setDataHist(calendar.getTime());
        historico.setParecer(parecer);
        historico.setStatusAnterior(statusAnterior);
        
        ManagerDao.getCurrentInstance().insert(historico);
      
        ManagerDao.getCurrentInstance().update(this.selecionar);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Processo alterado com sucesso!"));
        return "listarProcessos.xhtml";
    }
    
    public void deletar(){
        ManagerDao.getCurrentInstance().delete(this.selecionar);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Processo delatado com sucesso!"));
    }
    
    public List<Processo> listarTodos(){
        return ManagerDao.getCurrentInstance().read("Select ip from Processo ip", Processo.class);
    }

    public Processo getCadastrar() {
        return cadastrar;
    }

    public void setCadastrar(Processo cadastrar) {
        this.cadastrar = cadastrar;
    }

    public Processo getSelecionar() {
        return selecionar;
    }

    public void setSelecionar(Processo selecionar) {
        this.selecionar = selecionar;
    }
    
    
    
}
