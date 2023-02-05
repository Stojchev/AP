package mk.ukim.finki.prvKolokIspitni.FrontPageTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//public class FrontPage {
//    private ArrayList<NewsItem> newsItems;
//    private Category[] categories;
//
//    public FrontPage(Category[] categories) {
//        newsItems = new ArrayList<>();
//        this.categories = categories;
//    }
//
//    public void addNewsItem(NewsItem newsItem) {
//        newsItems.add(newsItem);
//    }
//
//    public List<NewsItem> listByCategory(Category category) {
//        ArrayList<NewsItem> tmp = new ArrayList<>();
//        for (NewsItem newsItem : newsItems) {
//            if (newsItem.getCategory().equals(category))
//                tmp.add(newsItem);
//        }
//        return tmp;
//    }
//
//    public List<NewsItem> listByCategoryName(String category) throws CategoryNotFoundException {
//        ArrayList<NewsItem> tmp = new ArrayList<>();
//        for (NewsItem newsItem : newsItems) {
//            if (newsItem.getTitle().equals(category))
//                tmp.add(newsItem);
//        }
//        if (tmp.size() == 0)
//            throw new CategoryNotFoundException(category);
//        return tmp;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        for (NewsItem newsItem : newsItems)
//            sb.append(newsItems.toString());
//        return sb.toString();
//    }
//}
