package com.myapp.demo.service.impl;


import com.myapp.demo.dao.IArticleDao;
import com.myapp.demo.dao.IFavoriteDao;
import com.myapp.demo.entity.Article;
import com.myapp.demo.entity.Favorite;
import com.myapp.demo.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Transactional
@Service
public class ArticleService implements IArticleService {

    @Autowired
    private IArticleDao articleDao;

    @Autowired
    private IFavoriteDao favoriteDao;

    @Override
    public Article getArticleById(Integer id) {
        return articleDao.findArticleById(id);
    }

    @Override
    public List<Article> getAllArticle() {
        return articleDao.findAllByOrderByReleaseTimeDesc();
    }

    @Override
    public List<Article> getArticleByTitleLike(String titleLike) {
        return articleDao.findAllByTitleLike("%"+titleLike+"%");
    }

    @Override
    public void addArticle(Article article) {
        articleDao.save(article);
    }

    @Override
    public void setArticleContent(Integer id, String content) {
        Article article = articleDao.findArticleById(id);
        article.setContent(content);
        //article.setReleaseTime(new Date());
        articleDao.save(article);
    }

    @Override
    public void setArticleSrcUrl(Integer id, String srcUrl) {
        Article article = articleDao.findArticleById(id);
        article.setSrcUrl(srcUrl);
        //article.setReleaseTime(new Date());
        articleDao.save(article);
    }

    @Override
    public void deleteArticleById(Integer id) {
        articleDao.deleteById(id);
    }

    @Override
    public List<Article> getUserFavorite(Integer userId) {
        return articleDao.findArticleByUserId(userId);
    }

    @Override
    public void addFavorite(Integer userId, Integer articleId) {
        Favorite fav = new Favorite();
        fav.setUserid(userId);
        fav.setArticleId(articleId);
        fav.setMarkTime(new Date());
        favoriteDao.save(fav);
    }

    @Override
    public void deleteFavorite(Integer userId, Integer articleId) {
        favoriteDao.deleteByUseridAndArticleId(userId,articleId);
    }
}
