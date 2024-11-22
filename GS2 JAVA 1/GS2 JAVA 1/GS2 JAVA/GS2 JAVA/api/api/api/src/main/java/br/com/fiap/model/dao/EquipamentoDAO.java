package br.com.fiap.model.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.model.vo.Equipamento;
 
public class EquipamentoDAO {
	public Connection minhaConexao;
    public EquipamentoDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }
    // Insert
    public String inserir(Equipamento equipamento) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement
                ("INSERT INTO EQUIPAMENTO (id_equip, nome_equip, marca_equip, ano_equip, consumo_equip, status_equip, usuario_equip) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, equipamento.getId());
            stmt.setString(2, equipamento.getNome());
            stmt.setString(3, equipamento.getMarca());
            stmt.setInt(4, equipamento.getAno());
            stmt.setDouble(5, equipamento.getConsumo());
            stmt.setString(6, equipamento.getStatus());
            stmt.setString(7, equipamento.getUsuario());
            stmt.execute();
            return "Cadastrado com Sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }
    // Delete
    public String deletar(int idEquip) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement
                ("DELETE * FROM EQUIPAMENTO WHERE equip_id = ?");
            stmt.setInt(1, idEquip);
            stmt.execute();
            return "Deletado com Sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }
    // Update
    public String atualizar(Equipamento equipamento) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement
                ("UPDATE EQUIPAMENTO SET nome_equip = ?, marca_equip = ?, ano_equip = ?, consumo_equip = ?, status_equip = ? WHERE id_equip = ?");
            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getMarca());
            stmt.setInt(3, equipamento.getAno());
            stmt.setString(4, equipamento.getStatus());
            stmt.setDouble(5, equipamento.getConsumo());
            stmt.setInt(6, equipamento.getId());
            stmt.executeUpdate();
            return "Atualizado com Sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }
    // Select
    public List<Equipamento> selecionar() throws SQLException {
        List<Equipamento> listaEquipamento = new ArrayList<Equipamento>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = minhaConexao.prepareStatement("SELECT * FROM EQUIPAMENTO");
            rs = stmt.executeQuery();
            while(rs.next()) {
            	Equipamento equipamento = new Equipamento();
            	equipamento.setId(rs.getInt(1));
            	equipamento.setNome(rs.getString(2));
            	equipamento.setMarca(rs.getString(3));
            	equipamento.setAno(rs.getInt(4));
            	equipamento.setConsumo(rs.getDouble(5));
            	equipamento.setStatus(rs.getString(6));
            	equipamento.setUsuario(rs.getString(7));
                listaEquipamento.add(equipamento);
            }
            return listaEquipamento;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }
    public Equipamento selecionarUm(int id) throws SQLException {
        // Prepare a consulta SQL
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM EQUIPAMENTO WHERE id_equip = ?");
        stmt.setInt(1, id);
        // Execute a consulta e obtenha o ResultSet
        ResultSet rs = stmt.executeQuery();
        // Processa o resultado, se houver
        if (rs.next()) {
        	Equipamento equipamento = new Equipamento();
        	equipamento.setId(rs.getInt(1));
        	equipamento.setNome(rs.getString(2));
        	equipamento.setMarca(rs.getString(3));
        	equipamento.setAno(rs.getInt(4));
        	equipamento.setConsumo(rs.getDouble(5));
        	equipamento.setStatus(rs.getString(6));
        	equipamento.setUsuario(rs.getString(7));
            // Fecha recursos
            rs.close();
            stmt.close();
            minhaConexao.close();
            return equipamento;
        }
        // Fecha recursos caso não haja resultados
        rs.close();
        stmt.close();
        minhaConexao.close();
        return null;
    }
 
}