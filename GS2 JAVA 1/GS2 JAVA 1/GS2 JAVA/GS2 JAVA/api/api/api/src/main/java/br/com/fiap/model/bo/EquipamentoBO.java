package br.com.fiap.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.dao.EquipamentoDAO;
import br.com.fiap.model.vo.Equipamento;


public class EquipamentoBO {
	
	EquipamentoDAO equipamentoDAO = null;

    // inserir
    public void inserirBO(Equipamento equipamento) throws ClassNotFoundException, SQLException {
        
    	equipamentoDAO = new EquipamentoDAO();

        // Aplicação de regras de negócio... (se houver)

    	equipamentoDAO.inserir(equipamento);
    }

    // atualizar
    public void atualizarBO(Equipamento equipamento) throws ClassNotFoundException, SQLException {
        
    	equipamentoDAO = new EquipamentoDAO();

        // Aplicação de regra de negócio... (se houver)

    	equipamentoDAO.atualizar(equipamento);
    }

    // deletar
    public void deletarBO(int idEquip) throws ClassNotFoundException, SQLException {
        
    	equipamentoDAO = new EquipamentoDAO();

        // Aplicação de regra de negócio... (se houver)

    	equipamentoDAO.deletar(idEquip);
    }

    // selecionar
    public ArrayList<Equipamento> selecionarBO() throws ClassNotFoundException, SQLException {
        
    	equipamentoDAO = new EquipamentoDAO();
        return (ArrayList<Equipamento>) equipamentoDAO.selecionar();
    }
    
public Equipamento selecionarUmBO(int idEquip) throws ClassNotFoundException, SQLException {
        
	equipamentoDAO = new EquipamentoDAO();
 
        // Aplicação de regra de negócio... (se houver)
        return equipamentoDAO.selecionarUm(idEquip);
    }

}