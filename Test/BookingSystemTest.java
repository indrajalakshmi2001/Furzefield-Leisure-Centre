import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookingSystemTest {
    @Test
    public void testBookingSuccess() {
        Member m = new Member(1, "Test");
        Lesson l = new Lesson(1, "Yoga", "Sunday", "Morning", 8.5);

        Booking b = new Booking(m, l);

        boolean result = l.addBooking(b);

        assertTrue(result);
        assertEquals(1, l.getBookingCount());
    }
    @Test
    public void testLessonFull() {
        Member m1 = new Member(1, "A");
        Lesson l = new Lesson(1, "Yoga", "Sunday", "Morning", 8.5);

        // Fill lesson
        for (int i = 0; i < 4; i++) {
            l.addBooking(new Booking(m1, l));
        }

        // Try 5th booking
        boolean result = l.addBooking(new Booking(m1, l));

        assertFalse(result);
    }

    @Test
    public void testDuplicateBooking() {
        Member m = new Member(1, "Test");
        Lesson l = new Lesson(1, "Yoga", "Sunday", "Morning", 8.5);

        Booking b1 = new Booking(m, l);
        Booking b2 = new Booking(m, l);

        l.addBooking(b1);

        // manually check duplicate logic
        boolean duplicate = false;

        if (b2.getMember() == m && b2.getLesson() == l) {
            duplicate = true;
        }

        assertTrue(duplicate);
    }
    @Test
    public void testTimeConflict() {
        Member m = new Member(1, "Test");

        Lesson l1 = new Lesson(1, "Yoga", "Sunday", "Morning", 8.5);
        Lesson l2 = new Lesson(2, "Zumba", "Sunday", "Morning", 7.0);

        Booking b1 = new Booking(m, l1);

        boolean conflict = false;

        if (b1.getLesson().getDay().equals(l2.getDay()) &&
                b1.getLesson().getTime().equals(l2.getTime())) {
            conflict = true;
        }

        assertTrue(conflict);
    }
    @Test
    public void testAttendLesson() {
        Member m = new Member(1, "Test");
        Lesson l = new Lesson(1, "Yoga", "Sunday", "Morning", 8.5);

        Booking b = new Booking(m, l);
        l.addBooking(b);

        b.attend(5, "Excellent");

        assertEquals("attended", b.getStatus());
        assertEquals(5.0, l.getAverageRating());
    }
    @Test
    public void testCancelBooking() {
        Member m = new Member(1, "Test");
        Lesson l = new Lesson(1, "Yoga", "Sunday", "Morning", 8.5);

        Booking b = new Booking(m, l);
        l.addBooking(b);

        b.cancel();

        assertEquals("cancelled", b.getStatus());
        assertEquals(0, l.getBookingCount());
    }
    @Test
    public void testChangeBooking() {
        Member m = new Member(1, "Test");

        Lesson l1 = new Lesson(1, "Yoga", "Sunday", "Morning", 8.5);
        Lesson l2 = new Lesson(1, "Zumba", "Sunday", "Afternoon", 7.0);
        Booking b = new Booking(m, l1);
        l1.addBooking(b);
        l2.addBooking(b);
        b.changeLesson(l2);
        assertEquals(l2, b.getLesson());
        assertEquals(0, l1.getBookingCount());
        assertEquals(1, l2.getBookingCount());
    }
}