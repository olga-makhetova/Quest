import model.Game;

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

        // инициализируем счетчики
        initAttr(session, "gameCount");
        initAttr(session, "winCount");

        // Создаём игру только если её ещё нет в сессии
        if (session.getAttribute("game") == null) {
            session.setAttribute("game", new Game());
        }

        // Переход на карточку с заданным номером
        int cardId = getIntParam(req, "cardId");
        if (cardId != -1) {
            Game game = (Game) session.getAttribute("game");
            game.setCurrentCard(cardId);
            session.setAttribute("game", game);

            // если надо - увеличиваем счетчики
            if (game.isEnd()) incAttr(session, "gameCount");
            if (game.isWin()) incAttr(session, "winCount");
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    /**
     * Возвращает int, хранящийся в параметре запроса paramName
     * Если не получается конвертировать в int - возвращает -1
     */
    private int getIntParam(HttpServletRequest req, String paramName) {
        try {
            return Integer.parseInt(req.getParameter(paramName));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Увеличивает счетчик attrName
     */
    private void incAttr(HttpSession session, String attrName) {
        session.setAttribute(attrName, (int) session.getAttribute(attrName) + 1);
    }

    /**
     * Инициализирует счетчик attrName
     */
    private void initAttr(HttpSession session, String attrName) {
        if (session.getAttribute(attrName) == null) {
            session.setAttribute(attrName, 0);
        }
    }
}
