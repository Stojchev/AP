package mk.ukim.finki.prvKolokIspitni.FrontPageTest;

import java.util.*;
import java.util.stream.Collectors;

class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(String message) {
        super(String.format("Category %s was not found", message));
    }
}

class TextNewsItem extends NewsItem {
    private String text;

    public TextNewsItem(String title, Date published, Category category, String text) {
        super(title, published, category);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getType() {
        return "TextNewsItem";
    }

    public String getTeaser() {
        Date date = new Date();
        int minutes = (int) ((date.getTime() - getPublished().getTime()) / 60 / 1000);
        return String.format("%s\n%d\n%s\n", getTitle(), minutes, text.length() <= 80 ? text : text.substring(0, 80));
    }

    @Override
    public String toString() {
        return getTeaser();
    }
}

abstract class NewsItem {
    private String title;
    private Date published;
    private Category category;

    public NewsItem(String title, Date published, Category category) {
        this.title = title;
        this.published = published;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public Date getPublished() {
        return published;
    }

    public Category getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public abstract String getType();

    public abstract String toString();

}

class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class MediaNewsItem extends NewsItem {
    String url;
    int n;

    public MediaNewsItem(String title, Date published, Category category, String url, int n) {
        super(title, published, category);
        this.url = url;
        this.n = n;
    }

    public String getUrl() {
        return url;
    }

    public int getN() {
        return n;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String getType() {
        return "MediaNewsItem";
    }

    public String getTeaser() {
        Date date = new Date();
        int minutes = (int) ((date.getTime() - getPublished().getTime()) / 60 / 1000);
        return String.format("%s\n%d\n%s\n%d\n", getTitle(), minutes, url, n);
    }

    @Override
    public String toString() {
        return getTeaser();
    }
}

class FrontPage {
    private ArrayList<NewsItem> newsItems;
    private Category[] categories;

    public FrontPage(Category[] categories) {
        newsItems = new ArrayList<>();
        this.categories = categories;
    }

    public void addNewsItem(NewsItem newsItem) {
        newsItems.add(newsItem);
    }

    public List<NewsItem> listByCategory(Category category) {
        return newsItems.stream().filter(i -> i.getCategory().equals(category)).collect(Collectors.toList());
    }

    public List<NewsItem> listByCategoryName(String category) throws CategoryNotFoundException {
        if (Arrays.stream(categories).noneMatch(category1 -> category1.getName().equals(category)))
            throw new CategoryNotFoundException(category);
        List<NewsItem> result = new ArrayList<>();
        Arrays.stream(categories).filter(category1 -> category1.getName().equals(category)).forEach(category1 -> result.addAll(listByCategory(category1)));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        newsItems.forEach(newsItem -> sb.append(newsItem.toString()));
//        return sb.toString();
        for (NewsItem newsItem : newsItems)
            sb.append(newsItem.toString());
        return sb.toString();
    }

}

public class FrontPageTest {
    public static void main(String[] args) {
        // Reading
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        Category[] categories = new Category[parts.length];
        for (int i = 0; i < categories.length; ++i) {
            categories[i] = new Category(parts[i]);
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        FrontPage frontPage = new FrontPage(categories);
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < n; ++i) {
            String title = scanner.nextLine();
            cal = Calendar.getInstance();
            int min = scanner.nextInt();
            cal.add(Calendar.MINUTE, -min);
            Date date = cal.getTime();
            scanner.nextLine();
            String text = scanner.nextLine();
            int categoryIndex = scanner.nextInt();
            scanner.nextLine();
            TextNewsItem tni = new TextNewsItem(title, date, categories[categoryIndex], text);
            frontPage.addNewsItem(tni);
        }

        n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; ++i) {
            String title = scanner.nextLine();
            int min = scanner.nextInt();
            cal = Calendar.getInstance();
            cal.add(Calendar.MINUTE, -min);
            scanner.nextLine();
            Date date = cal.getTime();
            String url = scanner.nextLine();
            int views = scanner.nextInt();
            scanner.nextLine();
            int categoryIndex = scanner.nextInt();
            scanner.nextLine();
            MediaNewsItem mni = new MediaNewsItem(title, date, categories[categoryIndex], url, views);
            frontPage.addNewsItem(mni);
        }
        // Execution
        String category = scanner.nextLine();
        System.out.println(frontPage);
        for (Category c : categories) {
            System.out.println(frontPage.listByCategory(c).size());
        }
        try {
            System.out.println(frontPage.listByCategoryName(category).size());
        } catch (CategoryNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}


// Vasiot kod ovde