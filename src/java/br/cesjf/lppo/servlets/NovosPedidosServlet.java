package br.cesjf.lppo.servlets;

import br.cesjf.lppo.dao.ControleDAO;
import br.cesjf.lppo.exr1.cPedido;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "NovoPedidoServlet", urlPatterns = {"/novo.html"})
public class NovosPedidosServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/novo-pedido.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        cPedido nPedido = new cPedido();
        
        nPedido.setPedido(Integer.parseInt(request.getParameter("pedido")));
        nPedido.setDono(request.getParameter("dono"));
        
        nPedido.setValor(Float.parseFloat(request.getParameter("valor")));
        nPedido.setNome(request.getParameter("nome"));
        
        try {
            ControleDAO dao = new ControleDAO();
            dao.cria(nPedido);
            
        } catch (Exception ex) {
            
            request.setAttribute("mensagem", ex);
            request.getRequestDispatcher("WEB-INF/novo-pedido.jsp").forward(request, response);
            return;
        }
        
        response.sendRedirect("listar.html");
    }

}
