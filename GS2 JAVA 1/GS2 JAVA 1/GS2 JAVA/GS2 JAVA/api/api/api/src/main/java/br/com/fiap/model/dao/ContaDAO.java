package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.model.vo.Conta;

public class ContaDAO {

    private Connection minhaConexao;

    public ContaDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir Conta
    public String inserir(Conta conta) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement(
                "INSERT INTO Conta (id_conta, valor_conta, consumo_conta, custo_conta, mes_conta, usuario_conta) " +
                "VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, conta.getId());
            stmt.setFloat(2, conta.getValor());
            stmt.setFloat(3, conta.getConsumo());
            stmt.setFloat(4, conta.getCustoKwh());
            stmt.setString(5, conta.getMes());
            stmt.setString(6, conta.getUsuario());
            stmt.execute();
            return "Conta cadastrada com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Deletar Conta
    public String deletar(int idConta) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement("DELETE FROM Conta WHERE id_conta = ?");
            stmt.setInt(1, idConta);
            stmt.execute();
            return "Conta deletada com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Atualizar Conta
    public String atualizar(Conta conta) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement(
                "UPDATE Conta SET valor_conta = ?, consumo_conta = ?, custo_conta = ?, mes_conta = ?, usuario_conta = ? " +
                "WHERE id_conta = ?");
            stmt.setFloat(1, conta.getValor());
            stmt.setFloat(2, conta.getConsumo());
            stmt.setFloat(3, conta.getCustoKwh());
            stmt.setString(4, conta.getMes());
            stmt.setString(5, conta.getUsuario());
            stmt.setInt(6, conta.getId());
            stmt.executeUpdate();
            return "Conta atualizada com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Selecionar todas as Contas
    public List<Conta> selecionar() throws SQLException {
        List<Conta> listaConta = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = minhaConexao.prepareStatement("SELECT * FROM Conta");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Conta conta = new Conta();
                conta.setId(rs.getInt("id_conta"));
                conta.setValor(rs.getFloat("valor_conta"));
                conta.setConsumo(rs.getFloat("consumo_conta"));
                conta.setCustoKwh(rs.getFloat("custo_conta"));
                conta.setMes(rs.getString("mes_conta"));
                conta.setUsuario(rs.getString("usuario_conta"));
                listaConta.add(conta);
            }
            return listaConta;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Selecionar uma Conta específica pelo ID
    public Conta selecionarUma(int id) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = minhaConexao.prepareStatement("SELECT * FROM Conta WHERE id_conta = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Conta conta = new Conta();
                conta.setId(rs.getInt("id_conta"));
                conta.setValor(rs.getFloat("valor_conta"));
                conta.setConsumo(rs.getFloat("consumo_conta"));
                conta.setCustoKwh(rs.getFloat("custo_conta"));
                conta.setMes(rs.getString("mes_conta"));
                conta.setUsuario(rs.getString("usuario_conta"));
                return conta;
            }
            return null;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }
}
