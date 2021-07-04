package com.med.buss;

import db.Articledb;

public class CatalogBrowser {

    private int currentPosition = 1;
    private Article currentArticle;
    private int articleCount = Articledb.getArticleCount();
    
   
    
    
    public CatalogBrowser() {
        currentArticle = Articledb.getArticleById( currentPosition );
    }
    
    public Article getCurrentArticle() {
        return currentArticle;
    }

   
    
   
    
    public void goPrevious() {
        if ( --currentPosition < 1 ) {
            currentPosition = articleCount;
        }
        currentArticle = Articledb.getArticleById( currentPosition );
    }
    
    public void goNext() {
        if ( ++currentPosition > articleCount ) {
            currentPosition = 1;
        }
        currentArticle = Articledb.getArticleById( currentPosition );
    }
    
  
    
}
