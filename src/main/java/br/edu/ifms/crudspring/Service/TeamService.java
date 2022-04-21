package br.edu.ifms.crudspring.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Team;
import br.edu.ifms.crudspring.repository.TeamRepository;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public List<Team> getTeams() {
        return this.teamRepository.findAll();
    }

    public void save(Team team) {
        teamRepository.save(team);
    }

    public void delete(UUID id) {
        teamRepository.deleteById(id);
    }

    public Team findById(UUID id) {
        return teamRepository.findById(id).get();
    }
}
