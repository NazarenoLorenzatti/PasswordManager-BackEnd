package net.ultrafibra.cotrasenas.dao;

import net.ultrafibra.cotrasenas.model.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iCredencialDao extends JpaRepository<Credencial, Long>{
    
}
