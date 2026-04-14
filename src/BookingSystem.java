import java.util.*;

public class BookingSystem {

    private static List<Member> members = new ArrayList<>();
    private static List<Lesson> lessons = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        setupData();
        preRegisteredData();
    }
    private static void setupData() {
        for (int i = 1; i <= 10; i++) {
            members.add(new Member(i, "Member" + i));
        }

        // WEEK 1
        lessons.add(new Lesson(1, "Zumba", "Saturday", "Morning", 7.0));
        lessons.add(new Lesson(1, "BoxFit", "Saturday", "Afternoon", 8.0));
        lessons.add(new Lesson(1, "BodyBlitz", "Saturday", "Evening", 9.0));
        lessons.add(new Lesson(1, "Aquacise", "Sunday", "Morning", 8.75));
        lessons.add(new Lesson(1, "Yoga", "Sunday", "Afternoon", 8.5));
        lessons.add(new Lesson(1, "Zumba", "Sunday", "Evening", 7.0));

        // WEEK 2
        lessons.add(new Lesson(2, "Yoga", "Saturday", "Morning", 8.5));
        lessons.add(new Lesson(2, "Zumba", "Saturday", "Afternoon", 7.0));
        lessons.add(new Lesson(2, "BodyBlitz", "Saturday", "Evening", 9.0));
        lessons.add(new Lesson(2, "BoxFit", "Sunday", "Morning", 8.0));
        lessons.add(new Lesson(2, "Aquacise", "Sunday", "Afternoon", 8.75));
        lessons.add(new Lesson(2, "Yoga", "Sunday", "Evening", 8.5));

        // WEEK 3
        lessons.add(new Lesson(3, "Aquacise", "Saturday", "Morning", 8.75));
        lessons.add(new Lesson(3, "Zumba", "Saturday", "Afternoon", 7.0));
        lessons.add(new Lesson(3, "BoxFit", "Saturday", "Evening", 8.0));
        lessons.add(new Lesson(3, "BoxFit", "Sunday", "Morning", 8.0));
        lessons.add(new Lesson(3, "Yoga", "Sunday", "Afternoon", 8.5));
        lessons.add(new Lesson(3, "BodyBlitz", "Sunday", "Evening", 9.0));

        // WEEK 4
        lessons.add(new Lesson(4, "BoxFit", "Saturday", "Morning", 8.0));
        lessons.add(new Lesson(4, "Aquacise", "Saturday", "Afternoon", 8.75));
        lessons.add(new Lesson(4, "BoxFit", "Saturday", "Evening", 8.0));
        lessons.add(new Lesson(4, "Yoga", "Sunday", "Morning", 8.5));
        lessons.add(new Lesson(4, "Zumba", "Sunday", "Afternoon", 7.0));
        lessons.add(new Lesson(4, "BodyBlitz", "Sunday", "Evening", 9.0));

        // WEEK 5
        lessons.add(new Lesson(5, "Yoga", "Saturday", "Morning", 8.5));
        lessons.add(new Lesson(5, "Aquacise", "Saturday", "Afternoon", 8.75));
        lessons.add(new Lesson(5, "Zumba", "Saturday", "Evening", 7.0));
        lessons.add(new Lesson(5, "BodyBlitz", "Sunday", "Morning", 9.0));
        lessons.add(new Lesson(5, "BoxFit", "Sunday", "Afternoon", 8.0));
        lessons.add(new Lesson(5, "Yoga", "Sunday", "Evening", 8.5));

        // WEEK 6
        lessons.add(new Lesson(6, "Zumba", "Saturday", "Morning", 7.0));
        lessons.add(new Lesson(6, "BoxFit", "Saturday", "Afternoon", 8.0));
        lessons.add(new Lesson(6, "Aquacise", "Saturday", "Evening", 8.75));
        lessons.add(new Lesson(6, "Yoga", "Sunday", "Morning", 8.5));
        lessons.add(new Lesson(6, "BodyBlitz", "Sunday", "Afternoon", 9.0));
        lessons.add(new Lesson(6, "Zumba", "Sunday", "Evening", 7.0));

        // WEEK 7
        lessons.add(new Lesson(7, "BoxFit", "Saturday", "Morning", 8.0));
        lessons.add(new Lesson(7, "Zumba", "Saturday", "Afternoon", 7.0));
        lessons.add(new Lesson(7, "BoxFit", "Saturday", "Evening", 8.0));
        lessons.add(new Lesson(7, "Yoga", "Sunday", "Morning", 8.5));
        lessons.add(new Lesson(7, "Aquacise", "Sunday", "Afternoon", 8.75));
        lessons.add(new Lesson(7, "BodyBlitz", "Sunday", "Evening", 9.0));

        // WEEK 8
        lessons.add(new Lesson(8, "Yoga", "Saturday", "Morning", 8.5));
        lessons.add(new Lesson(8, "BoxFit", "Saturday", "Afternoon", 8.0));
        lessons.add(new Lesson(8, "Aquacise", "Saturday", "Evening", 8.75));
        lessons.add(new Lesson(8, "Zumba", "Sunday", "Morning", 7.0));
        lessons.add(new Lesson(8, "Yoga", "Sunday", "Afternoon", 8.5));
        lessons.add(new Lesson(8, "BodyBlitz", "Sunday", "Evening", 9.0));
    }

    private static void preRegisteredData() {
        Random rand = new Random(1);

        // Make some lessons FULL
        for (int i = 0; i < 5; i++) {
            Lesson lesson = lessons.get(i);

            for (int j = 0; j < 4; j++) {
                Member m = members.get(j);
                Booking b = new Booking(m, lesson);

                if (lesson.addBooking(b)) {
                    bookings.add(b);
                    b.attend(rand.nextInt(5) + 1, "Good session");
                }
            }
        }
    }

}