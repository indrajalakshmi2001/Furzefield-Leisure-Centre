import java.util.*;

public class Lesson {
    private int week;
    private String exerciseType;
    private String day;
    private String time;
    private double price;

    private List<Booking> bookings = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();

    public Lesson(int week, String exerciseType, String day, String time, double price) {
        this.week = week;
        this.exerciseType = exerciseType;
        this.day = day;
        this.time = time;
        this.price = price;
    }

    public boolean addBooking(Booking booking) {
        if (bookings.size() < 4) {
            bookings.add(booking);
            return true;
        }
        return false;
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        if (reviews.isEmpty()) return 0;
        int total = 0;
        for (Review r : reviews) total += r.getRating();
        return (double) total / reviews.size();
    }

    public int getBookingCount() {
        return bookings.size();
    }

    public double getPrice() {
        return price;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public int getWeek() {
        return week;
    }

    public String toString() {
        return "Week" + week + " " + day + " " + time + " - " + exerciseType;
    }
}