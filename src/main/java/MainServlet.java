import model.Game;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/go", loadOnStartup = 1)
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // Создаём игру только если её ещё нет в сессии
        if (session.getAttribute("game") == null) {
            session.setAttribute("game", new Game());
        }

        int cardId = getInt(req, "cardId");
        if (cardId != -1) {
            Game game = (Game) session.getAttribute("game");
            game.setCurrentCardId(cardId);
            session.setAttribute("game", game);
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private int getInt(HttpServletRequest req, String attrName){
        try{
            return Integer.parseInt(req.getParameter(attrName));
        }catch (NumberFormatException e){
            return -1;
        }
    }
}
