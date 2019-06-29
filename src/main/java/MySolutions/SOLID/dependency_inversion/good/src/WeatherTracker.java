package MySolutions.SOLID.dependency_inversion.good.src;

/**
 * Created by mrk on 4/8/14.
 */
public class WeatherTracker {
    public String currentConditions;

    public void setCurrentConditions(String weatherDescription) {
        this.currentConditions = weatherDescription;
    }

    public void notify(Notifier notifier) {
        notifier.alertWeatherConditions(currentConditions);
    }
}
