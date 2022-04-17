package br.edu.ifms.crudspring.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifms.crudspring.model.Teacher;

//Conecta ao banco de dados
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, UUID>{
   
}