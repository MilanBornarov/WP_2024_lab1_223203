package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "ArtistServlet", urlPatterns = "/artist")
public class ArtistServlet extends HttpServlet {

    private final ArtistService artistService;
    private final SpringTemplateEngine templateEngine;

    public ArtistServlet(ArtistService artistService, SpringTemplateEngine templateEngine) {
        this.artistService = artistService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId = (String) req.getSession().getAttribute("trackId");
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext webContext = new WebContext(webExchange);

        webContext.setVariable("artists", artistService.listArtists());
        webContext.setVariable("trackId", trackId);
        templateEngine.process("artistsList", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artistId = req.getParameter("artistId");
        String trackId = (String) req.getSession().getAttribute("trackId");

        req.getSession().setAttribute("artistId", artistId);
        resp.sendRedirect("/songDetails");
    }
}
