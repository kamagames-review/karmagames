package md.task.domain;

public class Label {
    public Long userId;
    public Float lat, lon;

    public Label(Long userId, Float x, Float y) {
        this.userId = userId;
        this.lat = x;
        this.lon = y;
    }

    public Float findDistance(Float lat, Float lon) {
        return (float)Math.sqrt(Math.pow(lat- this.lat,2) + Math.pow(lon- this.lon,2));
    }
}
