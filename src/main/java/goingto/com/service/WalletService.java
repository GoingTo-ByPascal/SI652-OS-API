package goingto.com.service;

import goingto.com.model.Wallet;

import java.util.List;

public interface WalletService {
    List<Wallet> ListWallets();
    Wallet findById(int id);
    Wallet save(Wallet user);
    void delete(int id);
}
