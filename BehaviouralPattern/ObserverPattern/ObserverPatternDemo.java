import java.util.List;
import java.util.ArrayList;
interface Observer {
    void update(String news);
}

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String news);
}

class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String news) {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void publishNews(String news) {
        System.out.println("News Agency: Publishing news - " + news);
        notifyObservers(news);
    }
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println("Subscriber " + name + " received news: " + news);
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        Subscriber subscriber1 = new Subscriber("Subscriber1");
        Subscriber subscriber2 = new Subscriber("Subscriber2");

        newsAgency.registerObserver(subscriber1);
        newsAgency.registerObserver(subscriber2);

        newsAgency.publishNews("Breaking News: World Peace Achieved!");
    }
}
