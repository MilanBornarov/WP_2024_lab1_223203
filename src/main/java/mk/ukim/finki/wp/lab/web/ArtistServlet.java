package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "ArtistServlet", urlPatterns = "/artist")
public class ArtistServlet extends HttpServlet {

    private final ArtistService artistService;
    private final SpringTemplateEngine templateEngine;
    private final SongService servis;

    public ArtistServlet(ArtistService artistService, SpringTemplateEngine templateEngine, SongService servis) {
        this.artistService = artistService;
        this.templateEngine = templateEngine;
        this.servis = servis;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext webContext = new WebContext(webExchange);

        webContext.setVariable("artists", artistService.listArtists());
        templateEngine.process("artistsList", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artistId = req.getParameter("artistId");
        Song song = (Song) req.getSession().getAttribute("trackId");
        if (song == null) {
            resp.sendRedirect("/listSongs");
            return;
        }
        Artist artist11 = artistService.ArtistfindById(Long.parseLong(artistId)).get();
        if (artist11 != null) {
            servis.addArtistToSong(artist11, song);
        }
        resp.sendRedirect("/songDetails");
    }
}
