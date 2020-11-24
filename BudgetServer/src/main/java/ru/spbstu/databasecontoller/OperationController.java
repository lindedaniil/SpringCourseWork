package ru.spbstu.databasecontoller;



import ru.spbstu.entity.ArticlesEntity;
import ru.spbstu.entity.BalanceEntity;
import ru.spbstu.entity.OperationsEntity;
import ru.spbstu.repository.ArticleRepository;
import ru.spbstu.repository.BalanceRepository;
import ru.spbstu.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class OperationController {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private BalanceRepository balanceRepository;

    @RequestMapping(value = "/addOperation", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String addArticle(@RequestBody OperationsEntity receivedOperation) {
        if (receivedOperation == null) {
            return "Null Data";
        }
        for (OperationsEntity findOperations : operationRepository.findAll()) {
            if (findOperations.equals(receivedOperation)) {
                return "Operation exist";
            }
        }
       // OperationsEntity newOperation = new OperationsEntity();
        //newOperation.setName(receivedOperation.getName());
        operationRepository.save(receivedOperation);
        return "OK";
    }


    @RequestMapping(value = "/getOperation", method = RequestMethod.GET, produces = "application/json")
    public String getOperation(@RequestParam int id) {
        Optional<OperationsEntity> checkOperation = operationRepository.findById(id);
        if (checkOperation.isPresent()) {
            return  checkOperation.orElse(new OperationsEntity()).toString();
        }
        return "Operation doesn't exist!";
    }

    @RequestMapping(value = "/deleteOperation", method = RequestMethod.POST)
    public String deleteOperation(@RequestParam int id) {
        Optional<BalanceEntity> checkBalance = balanceRepository.findById(id);
        Optional<ArticlesEntity> checkArticle = articleRepository.findById(id);
        Optional<OperationsEntity> checkOperation = operationRepository.findById(id);

        if (checkBalance.isPresent() && checkArticle.isPresent() && checkOperation.isPresent()) {
            operationRepository.deleteById(id);
            balanceRepository.deleteById(id);
            articleRepository.deleteById(id);
            return "OK";
        } else {
            return "Operation doesn't exist!";
        }
    }

    @RequestMapping(value = "/showOperations", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<String> showOperations() {
        ArrayList<String> listOperations = new ArrayList<String>();

        for (OperationsEntity operationsEntity: operationRepository.findAll()) {
            listOperations.add(operationsEntity.toString());
        }
        return listOperations;
    }

}