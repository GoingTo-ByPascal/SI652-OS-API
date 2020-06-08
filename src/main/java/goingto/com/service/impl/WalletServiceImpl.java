package goingto.com.service.impl;

import goingto.com.repository.WalletRepository;
import goingto.com.service.WalletService;
import goingto.com.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public List<Wallet> ListWallets() {
        return walletRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Wallet findById(int id) {
        return walletRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public void delete(int id) {
        walletRepository.deleteById(id);
    }
}