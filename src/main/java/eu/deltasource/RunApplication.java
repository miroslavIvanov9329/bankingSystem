package eu.deltasource;

import eu.deltasource.exception.InvalidCurrencyException;
import eu.deltasource.exception.NotAllowedToTransferToTheSameBankAccountException;
import eu.deltasource.exception.NotEnoughMoneyInTheSourceAccountException;
import eu.deltasource.exception.TransfersAllowedBetweenCurrentAccountsException;
import eu.deltasource.model.BankAccount;
import eu.deltasource.model.BankInstitution;
import eu.deltasource.model.BankAccountOwner;

import java.time.LocalDateTime;

public class RunApplication {
    public void run() {

        BankAccountOwner niki4 = new BankAccountOwner("Nikola", "Petrov", "02");
        BankAccountOwner mirki4 = new BankAccountOwner("Ivan", "Pejov", "02");

        BankInstitution dsk = new BankInstitution("dsk", "This street");
        BankInstitution raifaizen = new BankInstitution("raifaizen", "That street");

        BankAccount nikic = new BankAccount(niki4, "GBP", 30, "CurrentAccount", "SavingsAccount");
        BankAccount mirkic = new BankAccount(mirki4, "USD", 30, "CurrentAccount");

        BankService bankService = new BankService();

        bankService.addBank(dsk);
        bankService.addBank(raifaizen);

        bankService.addBankAccountToBank(nikic, dsk);
        bankService.addBankAccountToBank(mirkic, raifaizen);

        bankService.depositMoneyToAccount(mirkic, 2, LocalDateTime.of(2026, 3, 2, 16, 15));
        bankService.withdrawMoneyFromAccount(mirkic, 10, LocalDateTime.of(2025, 3, 2, 15, 25, 22));
        bankService.transferMoney(nikic, mirkic, 10, LocalDateTime.of(2028, 3, 2, 19, 18, 9));
        bankService.transferMoney(nikic, mirkic, 3.01, LocalDateTime.of(2028, 3, 2, 19, 18, 9));
//
//        mirkic.prepareBankStatement(LocalDateTime.of(2002,2,1, 12,12,12), LocalDateTime.of(2029,3,1,12,12,12));
//        nikic.prepareBankStatement(LocalDateTime.of(2002, 2, 1, 12, 12, 12), LocalDateTime.of(2029, 3, 1, 12, 12, 12));
        System.out.println(nikic);
        System.out.println(mirkic);

//        System.out.println(nikic.allTransactions());
//        System.out.println(mirkic.allTransactions());

    }
}
