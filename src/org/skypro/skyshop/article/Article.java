package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String articleTitle;
    private final String text;
    public Article(String articleTitle,String text){
        this.articleTitle = articleTitle;
        this.text = text;
    }

    public String getArticle() {
        return articleTitle;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return articleTitle + "\n" + text;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return articleTitle;
    }

    @Override
    public String getStringRepresentation() {
        return getName() + " — " + getContentType();
    }
}
