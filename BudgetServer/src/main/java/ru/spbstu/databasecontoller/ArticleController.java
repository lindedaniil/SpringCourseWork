package ru.spbstu.databasecontoller;


import ru.spbstu.entity.BalanceEntity;
import ru.spbstu.entity.OperationsEntity;
import ru.spbstu.entity.ArticlesEntity;
import ru.spbstu.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.spbstu.repository.BalanceRepository;
import ru.spbstu.repository.OperationRepository;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private BalanceRepository balanceRepository;



    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    @ResponseBody
    public String addArticle(@RequestParam String name) {
        ArticlesEntity receivedArticle = new ArticlesEntity();
        receivedArticle.setName(name);

        if (receivedArticle == null) {
            return "Null Data";
        }
        int countArticles = 0;

        articleRepository.save(receivedArticle);
        return "OK";
    }



    @RequestMapping(value = "/getArticle", method = RequestMethod.GET)
    public String getArticle(@RequestParam int id) {
        Optional<ArticlesEntity> checkArticle = articleRepository.findById(id);
        if (checkArticle.isPresent()) {
            return checkArticle.orElse(new ArticlesEntity()).toString();
        }
        return "Article doesn't exist!";
    }



    @RequestMapping(value = "/deleteArticle", method = RequestMethod.POST)
    public String deleteArticle(@RequestParam int id) {
        Optional<BalanceEntity> checkBalance = balanceRepository.findById(id);
        Optional<ArticlesEntity> checkArticle = articleRepository.findById(id);
        Optional<OperationsEntity> checkOperation = operationRepository.findById(id);

        if (checkBalance.isPresent() && checkArticle.isPresent() && checkOperation.isPresent()) {
            balanceRepository.deleteById(id);
            operationRepository.deleteById(id);
            articleRepository.deleteById(id);
            return "OK";
        } else {
            return "Article doesn't exist!";
        }
    }

    @RequestMapping(value = "/showArticles", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<String> showArticles() {
        ArrayList<String> listArticles = new ArrayList<String>();

        for (ArticlesEntity articlesEntity: articleRepository.findAll()) {
            listArticles.add(articlesEntity.toString());
        }
        return listArticles;
    }
}