package ru.amalysheva.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.amalysheva.crud.entities.Persistable;

@NoRepositoryBean
public interface MyRepository<T extends Persistable> extends JpaRepository<T, Integer> {

}
