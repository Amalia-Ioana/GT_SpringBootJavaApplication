package com.AmaliaStefan.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AmaliaStefan.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Poate fi necesar să adăugați metode suplimentare aici în funcție de nevoile aplicației.
}

