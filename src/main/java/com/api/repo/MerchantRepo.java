package com.api.repo;

import com.api.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantRepo extends JpaRepository<Merchant,Long> {

    Optional<Merchant> findByMerchantId(Long merchantId);

}
