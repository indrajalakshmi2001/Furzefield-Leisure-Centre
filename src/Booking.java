public class Booking {
    private static int counter = 1;

    private int bookingId;
    private Member member;
    private Lesson lesson;
    private String status;

    public Booking(Member member, Lesson lesson) {
        this.bookingId = counter++;
        this.member = member;
        this.lesson = lesson;
        this.status = "booked";
    }

    public int getBookingId() {
        return bookingId;
    }

    public Member getMember() {
        return member;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public String getStatus() {
        return status;
    }

    public void attend(int rating, String comment) {
        status = "attended";
    }

    public void cancel() {
        status = "cancelled";
        lesson.removeBooking(this);
    }

    public void changeLesson(Lesson newLesson) {
        lesson.removeBooking(this);
        lesson = newLesson;
        status = "changed";
    }
}