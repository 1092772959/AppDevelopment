package com.myapp.demo.service;


import com.myapp.demo.entity.Article;

import java.util.List;

public interface IArticleService {
    Article getArticleById(Integer id);

    List<Article> getAllArticle();

    List<Article> getArticleByTitleLike(String titleLike);

    void addArticle(Article article);

    void setArticleContent(Integer id,String content);

    void setArticleSrcUrl(Integer id, String srcUrl);

    void deleteArticleById(Integer id);


    /**
     * 用户收藏相关
     */
    List<Article> getUserFavorite(Integer userId);

    void addFavorite(Integer userId, Integer articleId);

    void deleteFavorite(Integer userId,Integer articleId);
}
