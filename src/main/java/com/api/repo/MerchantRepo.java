package com.api.repo;

import com.api.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepo extends JpaRepository<Merchant,Long> {
   
}
