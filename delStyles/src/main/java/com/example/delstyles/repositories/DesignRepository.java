package com.example.delstyles.repositories;

import com.example.delstyles.entities.Design;
import com.example.delstyles.entities.User;
import com.example.delstyles.enums.Category;
import com.example.delstyles.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Repository
public interface DesignRepository extends JpaRepository<Design, String> {

    Optional<Design> findDesignByTitle(String title);

//    List<Design> findDesignByCategory(Category category);

    List<Design> findAllByGender(Gender gender);
    List<Design> findAllByUser(User user);

    List<Design> findAllByCategory(Category category);

//    List<Design> findDesignByGenderAndAndCategory(Gender gender, Category category);
}
