package goingto.com.controller;

import goingto.com.model.account.Wallet;
import goingto.com.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;


    @GetMapping
    public List<Wallet> GetAll() {
        return walletService.ListWallets();
    }


    @GetMapping("/{id}")
    public Wallet show(@PathVariable int id) {
        return walletService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED) //201: successfully created
    public Wallet create(@RequestBody Wallet wallet) {
        return walletService.save(wallet);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Wallet update(@RequestBody Wallet wallet, @PathVariable int id) {

        Wallet existingWallet = walletService.findById(id);

        existingWallet.setPoints(wallet.getPoints());

        return walletService.save(existingWallet);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        walletService.delete(id);
    }
}