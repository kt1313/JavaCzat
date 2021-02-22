package javastart.pl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("")
public class MessageController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Message message = createMessage(request);
        saveMessageInHistory(message, request);
    }

    protected Message createMessage(HttpServletRequest request) {
        String author = request.getParameter("author");
        String text = request.getParameter("text");
        return new Message(author, text);
    }
    protected void saveMessageInHistory(Message message, HttpServletRequest request){
        ServletContext context=getServletContext();
        List<Message> messageHistory=(List<Message>) context.getAttribute("messageHistory");
        if (messageHistory == null) {
            messageHistory=new ArrayList<>();
        }
        messageHistory.add(message);
        context.setAttribute("messageHistor", messageHistory);

    }
}