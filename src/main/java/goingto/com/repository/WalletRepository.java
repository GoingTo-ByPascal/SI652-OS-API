package goingto.com.repository;

import goingto.com.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}