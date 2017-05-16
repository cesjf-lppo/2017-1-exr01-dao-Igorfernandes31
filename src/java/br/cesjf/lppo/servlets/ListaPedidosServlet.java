package br.cesjf.lppo.servlets;

import br.cesjf.lppo.dao.ControleDAO;
import br.cesjf.lppo.exr1.cPedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListaPedidosServlet", urlPatterns = {"/listar.html"})
public class ListaPedidosServlet extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<cPedido> Npedidos;
        
         try {
           ControleDAO dao = new ControleDAO();
            Npedidos = dao.listAll();
            
        } catch (Exception ex) {
            
            Logger.getLogger(ListaPedidosServlet.class.getName()).log(Level.SEVERE, null, ex);
            Npedidos = new ArrayList<>();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
            
        }
        
        request.setAttribute("pedidos", Npedidos);
        request.getRequestDispatcher("WEB-INF/lista-pedidos.jsp").forward(request, response);
    }

}
