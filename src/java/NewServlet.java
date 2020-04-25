/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author piowo1979
 */
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Witamy " + request.getParameter("imie") + " !!!</h1>");
            out.println("<h2>Podales liczby :</h2>");
            String liczby = request.getParameter("liczby");
            Double[] liczbyArr = rozdzielLiczby(liczby, out);
            for (double liczba : liczbyArr) {
                out.println("<h3>"+liczba+"</h3>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected Double[] rozdzielLiczby(String liczbyStr, PrintWriter out) {
        String[] liczbyArrStr = liczbyStr.trim().split(" ");
        ArrayList<Double> liczbyLstArrDbl = new ArrayList<>();
        int i=0;
        for (String liczba : liczbyArrStr) {
            try {
                liczbyLstArrDbl.add(new Double(liczba));
            } catch(NumberFormatException e) {
                out.println("<h3>Wprowadzono bledna dane: "+liczba+" !!!</h3>");
            }
        }
        Double[] liczbyArrDbl = (Double[])liczbyLstArrDbl.toArray(new Double[liczbyLstArrDbl.size()]);
        return liczbyArrDbl;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
