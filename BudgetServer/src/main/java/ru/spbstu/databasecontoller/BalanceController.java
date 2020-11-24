package ru.spbstu.databasecontoller;


import ru.spbstu.entity.ArticlesEntity;
import ru.spbstu.entity.BalanceEntity;
import ru.spbstu.entity.OperationsEntity;
import ru.spbstu.repository.ArticleRepository;
import ru.spbstu.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.spbstu.repository.OperationRepository;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class BalanceController {

    @Autowired
    private BalanceRepository balanceRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private ArticleRepository articleRepository;

    private  boolean wrongadd = false;

    @RequestMapping(value = "/addBalance", method = RequestMethod.POST)
    @ResponseBody
    public String addBalance(@RequestParam String createdate, @RequestParam int debit, @RequestParam int credit) {
        BalanceEntity receivedBalance = new BalanceEntity();
        receivedBalance.setCreatedate(createdate);
        receivedBalance.setDebit(debit);
        receivedBalance.setCredit(credit);
        receivedBalance.setAmount(receivedBalance.getDebit() - receivedBalance.getCredit());
        balanceRepository.save(receivedBalance);

        Optional<ArticlesEntity> checkArticle = articleRepository.findById(receivedBalance.getId());

        OperationsEntity newOperation = new OperationsEntity();
        newOperation.setDebit(receivedBalance.getDebit());
        newOperation.setCredit(receivedBalance.getCredit());
        newOperation.setCreatedate(receivedBalance.getCreatedate());
        newOperation.setBalance(receivedBalance);
        newOperation.setArticle(checkArticle.get());
        operationRepository.save(newOperation);

        return "OK";
    }


    @RequestMapping(value = "/getBalance", method = RequestMethod.GET)
    public String getBalance(@RequestParam int id) {
        Optional<BalanceEntity> checkBalance = balanceRepository.findById(id);
        if (checkBalance.isPresent()) {
            return checkBalance.orElse(new BalanceEntity()).toString();
        }
        return "Balance doesn't exist!";

    }

    @RequestMapping(value = "/deleteBalance", method = RequestMethod.POST)
    public String deleteBalance(@RequestParam int id) {
        Optional<BalanceEntity> checkBalance = balanceRepository.findById(id);
        Optional<ArticlesEntity> checkArticle = articleRepository.findById(id);
        Optional<OperationsEntity> checkOperation = operationRepository.findById(id);

        if (checkArticle.isPresent() && checkBalance.isPresent() &&  checkOperation.isPresent()) {
            operationRepository.deleteById(id);
            balanceRepository.deleteById(id);
            articleRepository.deleteById(id);
            return "OK";
        } else {
            return "Balance doesn't exist!";
        }
    }

    @RequestMapping(value = "/showBalance", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<String> showBalance() {
        ArrayList<String> listBalance = new ArrayList<String>();

        for (BalanceEntity balanceEntity: balanceRepository.findAll()) {
            listBalance.add(balanceEntity.toString());
        }
        return listBalance;
    }

}