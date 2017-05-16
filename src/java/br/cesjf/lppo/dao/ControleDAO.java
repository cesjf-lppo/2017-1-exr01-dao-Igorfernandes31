package br.cesjf.lppo.dao;


import br.cesjf.lppo.exr1.cPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControleDAO {

    private final PreparedStatement opListar;
    private final PreparedStatement opNovo;

    public ControleDAO() throws Exception {
        Connection conexao = ConnectionFactory.createConnection();
        opListar = conexao.prepareStatement("SELECT * FROM Pedido");
        opNovo = conexao.prepareStatement("INSERT INTO Pedido(Pedido, Dono, Valor, Nome) VALUES(?,?,?,?)");
    }

    public List<cPedido> listAll() throws Exception {
        try {
            List<cPedido> pedidos = new ArrayList<>();

            ResultSet resultado = opListar.executeQuery();

            while (resultado.next()) {
                cPedido nPedido = new cPedido();

                nPedido.setId(resultado.getLong("id")); nPedido.setPedido(resultado.getInt("pedido"));
                nPedido.setDono(resultado.getString("dono"));
                nPedido.setValor(resultado.getFloat("valor"));
                nPedido.setNome(resultado.getString("nome"));
                nPedido.setAtualizacao(resultado.getTimestamp("atualizacao"));
                
                pedidos.add(nPedido);
            }
            return pedidos;

        } catch (SQLException ex) {
            throw new Exception("Erro ao listar os pedidos no banco!", ex);
        }
    }

    public void cria(cPedido nPedido) throws Exception {
        try{
            opNovo.clearParameters(); 
            
            opNovo.setInt(1, nPedido.getPedido());
            
            opNovo.setString(2, nPedido.getDono());
            
            opNovo.setFloat(3, nPedido.getValor());
            
            opNovo.setString(4, nPedido.getNome());
            
            opNovo.executeUpdate();
            
        } catch (SQLException ex) {
            throw new Exception("Erro ao inserir novo Pedido", ex);
        }
    }
}