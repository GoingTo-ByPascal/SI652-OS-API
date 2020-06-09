package goingto.com.controller;

import goingto.com.model.account.Wallet;
import goingto.com.service.WalletService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class WalletController {

    @Autowired
    private WalletService walletService;


    @ApiOperation("Return all Wallets")
    @GetMapping("/wallets")
    public List<Wallet> GetAll() {
        return walletService.ListWallets();
    }


    @ApiOperation("Return Wallet by id")
    @GetMapping("/wallets/{id}")
    public Wallet show(@PathVariable int id) {
        return walletService.findById(id);
    }

    @ApiOperation("Create new Wallet")
    @PostMapping("/wallets")
    @ResponseStatus(HttpStatus.ACCEPTED) //201: successfully created
    public Wallet create(@RequestBody Wallet wallet) {
        return walletService.save(wallet);
    }


    @ApiOperation("Update existing Wallet by id")
    @PutMapping("/wallets/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Wallet update(@RequestBody Wallet wallet, @PathVariable int id) {

        Wallet existingWallet = walletService.findById(id);

        existingWallet.setPoints(wallet.getPoints());

        return walletService.save(existingWallet);
    }

    @ApiOperation("Delete existing Wallet by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        walletService.delete(id);
    }
}