package servlets;

import entity.Car;
import services.ISellPriceService;
import services.ITaxService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("/index.html").include(request,response);

        int year=0, engine=0;
        double purchasing=0.0;

        if(!(request.getParameter("fabricationYear").equals("")))
            year=Integer.valueOf(request.getParameter("fabricationYear"));
        if(!(request.getParameter("engineSize").equals("")))
            engine=Integer.valueOf(request.getParameter("engineSize"));
        if(!(request.getParameter("purchasingPrice").equals("")))
            purchasing=Double.valueOf(request.getParameter("purchasingPrice"));

        if(year!=0 && engine!=0 && purchasing!=0.0){

            Car car=new Car(year,engine,purchasing);

            try {
                Registry registry = LocateRegistry.getRegistry(4447);

                ITaxService stub3 = (ITaxService) registry.lookup("tax");
                ISellPriceService stub4=(ISellPriceService) registry.lookup("sell");

                double tax=stub3.computeTax(car);
                double price=stub4.computeSellingPrice(car);

                out.println("The tax is: "+tax+" and the selling price is: "+price);

            } catch (Exception e) {
                System.err.println("Client exception: " + e.toString());
                e.printStackTrace();
            }
        }
        else
            out.println("Fill all the fields!");

    }
}
