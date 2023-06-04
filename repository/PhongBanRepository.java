package com.hoangyen.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoangyen.model.PhongBan;

@Repository
public interface PhongBanRepository  extends JpaRepository<PhongBan, Long> {
}
