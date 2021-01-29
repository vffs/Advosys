
package br.recife.ifpe.edu.model.controllers;

import br.recife.ifpe.edu.model.classes.Historico;
import br.recife.ifpe.edu.model.dao.ManagerDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author valeria
 */
@ManagedBean(name="hController")
@SessionScoped 
public class HistoricoController {
    
    private Historico selecionar;
    
    public String alterar(){
        ManagerDao.getCurrentInstance().update(this.selecionar);
        return "historicoProcessos.xhtml";
    }
    
    public List<Historico> listarTodos(){
        return ManagerDao.getCurrentInstance().read("Select h from Historico h", Historico.class);
    }

    public Historico getSelecionar() {
        return selecionar;
    }

    public void setSelecionar(Historico selecionar) {
        this.selecionar = selecionar;
    }
    
    
}
