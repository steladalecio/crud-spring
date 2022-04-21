package br.edu.ifms.crudspring.Controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.model.Team;
import br.edu.ifms.crudspring.Service.TeamService;

@Controller 
@RequestMapping("/team") 
public class TeamController {
    
    @Autowired
    TeamService teamService;

    @PostMapping("/listar")
    public String saves(@ModelAttribute("team") Team team) {
        teamService.save(team);
        return "redirect:/team/listar";
    }

    @GetMapping("/listar")
    public String locall(@Valid Team team, Model model) {
        List<Team> teams = teamService.getTeams();
        model.addAttribute("listTeams", teams);
        model.addAttribute("teamUpdate", new Team());
        return "listTeam";
    }
    

    @GetMapping("/cadastrar")
    public String Cadastrar(Model model) {
        model.addAttribute("team", new Team());
        return "cadTeam";
    }
    

    @GetMapping("/remove/{id}")
    public String removeTeam(@PathVariable("id") UUID id) {
        teamService.delete(id);
        return "redirect:/team/listar";
    }

    
    @PostMapping("/update/{id}")
    public String updateTeam(@PathVariable("id") UUID id, @Valid Team team, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            team.setId(id);
            return "edit";
        }

        this.teamService.save(team);

        return "redirect:/team/listar";
    }
    

}

