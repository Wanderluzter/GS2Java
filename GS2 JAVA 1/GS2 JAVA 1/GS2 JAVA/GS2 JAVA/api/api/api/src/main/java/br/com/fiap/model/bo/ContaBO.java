package br.com.fiap.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.model.dao.ContaDAO;
import br.com.fiap.model.vo.Conta;

public class ContaBO {

    ContaDAO contaDAO = null;

    // Inserir
    public void inserirBO(Conta conta) throws ClassNotFoundException, SQLException {

        contaDAO = new ContaDAO();

        // Aplicação de regras de negócio... (se houver)

        contaDAO.inserir(conta);
    }

    // Atualizar
    public void atualizarBO(Conta conta) throws ClassNotFoundException, SQLException {

        contaDAO = new ContaDAO();

        // Aplicação de regras de negócio... (se houver)

        contaDAO.atualizar(conta);
    }

    // Deletar
    public void deletarBO(int idConta) throws ClassNotFoundException, SQLException {

        contaDAO = new ContaDAO();

        // Aplicação de regras de negócio... (se houver)

        contaDAO.deletar(idConta);
    }

    // Selecionar todas as contas
    public ArrayList<Conta> selecionarBO() throws ClassNotFoundException, SQLException {

        contaDAO = new ContaDAO();
        return (ArrayList<Conta>) contaDAO.selecionar();
    }

    // Selecionar uma conta específica
    public Conta selecionarUmBO(int idConta) throws ClassNotFoundException, SQLException {

        contaDAO = new ContaDAO();

        // Aplicação de regras de negócio... (se houver)

        return contaDAO.selecionarUma(idConta);
    }
}
