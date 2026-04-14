import java.util.*;

public class BookingSystem {

    private static List<Member> members = new ArrayList<>();
    private static List<Lesson> lessons = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        setupData();
        preRegisteredData();
        runMenu();
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
    private static void runMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            // Show members
            System.out.println("\n===== MEMBERS =====");
            for (Member m : members) {
                System.out.println(m.getMemberId() + " - " + m.getName());
            }

            System.out.print("\nSelect Member ID: ");
            int memberId = sc.nextInt();

            if (memberId < 1 || memberId > members.size()) {
                System.out.println("Invalid Member!");
                continue;
            }

            Member current = members.get(memberId - 1);

            // Show menu
            System.out.println("\n===== MENU =====");
            System.out.println("1. Book Lesson");
            System.out.println("2. Change/Cancel Booking");
            System.out.println("3. Attend Lesson");
            System.out.println("4. Monthly Report");
            System.out.println("5. Champion Report");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 6) return;

            switch (choice) {
                case 1 -> bookLesson(sc, current);
                case 2 -> changeBooking(sc, current);
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private static void bookLesson(Scanner sc, Member m) {

        System.out.println("\n1. View by Day");
        System.out.println("2. View by Type");
        System.out.print("Choose: ");
        int option = sc.nextInt();

        List<Lesson> filtered = new ArrayList<>();

        if (option == 1) {
            System.out.print("Enter day (Saturday/Sunday): ");
            String day = sc.next();

            for (Lesson l : lessons)
                if (l.getDay().equalsIgnoreCase(day)) filtered.add(l);

        } else {
            System.out.println("Enter exercise type (Yoga/Zumba/Aquacise/BoxFit/BodyBlitz):");
            String type = sc.next();

            for (Lesson l : lessons)
                if (l.getExerciseType().equalsIgnoreCase(type)) filtered.add(l);
        }

        for (int i = 0; i < filtered.size(); i++) {
            Lesson l = filtered.get(i);
            System.out.println(i + ": " + l
                    + " | Price: " + l.getPrice()
                    + " | Available: " + (4 - l.getBookingCount()));
        }

        System.out.print("Select lesson index: ");
        int index = sc.nextInt();

        if (index < 0 || index >= filtered.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Lesson lesson = filtered.get(index);
        for (Booking b : bookings) {
            if (b.getMember() == m && b.getLesson() == lesson) {
                System.out.println("Already booked this lesson!");
                return;
            }
        }
        for (Booking b : bookings) {
            if (b.getMember() == m &&
                    b.getLesson().getDay().equalsIgnoreCase(lesson.getDay()) &&
                    b.getLesson().getTime().equalsIgnoreCase(lesson.getTime())) {

                System.out.println("Time conflict! You already booked a lesson at this time.");
                return;
            }
        }

        Booking b = new Booking(m, lesson);

        if (lesson.addBooking(b)) {
            bookings.add(b);
            System.out.println("Booking successful! ID: " + b.getBookingId());
        } else {
            System.out.println("Lesson is FULL!");
        }
    }

    private static void changeBooking(Scanner sc, Member current) {
        System.out.println("\n===== YOUR BOOKINGS =====");
        boolean hasBookings = false;
        for (Booking b : bookings) {
            if (b.getMember() == current && !b.getStatus().equals("cancelled")) {
                System.out.println("ID: " + b.getBookingId()
                        + " | " + b.getLesson()
                        + " | Status: " + b.getStatus());
                hasBookings = true;
            }
        }
        if (!hasBookings) {
            System.out.println("You have no active bookings.");
            return;
        }
        System.out.print("Enter Booking ID: ");
        int id = sc.nextInt();

        Booking found = null;
        for (Booking b : bookings) {
            if (b.getBookingId() == id) { found = b; break; }
        }

        if (found == null) {
            System.out.println("Booking not found!");
            return;
        }

        if (found.getStatus().equals("cancelled")) {
            System.out.println("This booking is already cancelled!");
            return;
        }

        if (found.getStatus().equals("attended")) {
            System.out.println("This booking has already been attended and cannot be changed!");
            return;
        }

        System.out.println("Booking ID: " + found.getBookingId()
                + " | Lesson: " + found.getLesson()
                + " | Status: " + found.getStatus());
        System.out.println("1. Change Lesson");
        System.out.println("2. Cancel Booking");
        System.out.print("Choose: ");
        int option = sc.nextInt();

        if (option == 2) {
            found.cancel();
            System.out.println("Booking ID " + id + " cancelled successfully. Place released.");
            return;
        }
        System.out.println("\n1. View by Day");
        System.out.println("2. View by Exercise Type");
        System.out.print("Choose: ");
        int viewOption = sc.nextInt();

        List<Lesson> filtered = new ArrayList<>();

        if (viewOption == 1) {
            System.out.print("Enter day (Saturday/Sunday): ");
            String day = sc.next();
            for (Lesson l : lessons)
                if (l.getDay().equalsIgnoreCase(day)) filtered.add(l);
        } else {
            System.out.print("Enter exercise type (Yoga/Zumba/Aquacise/BoxFit/BodyBlitz): ");
            String type = sc.next();
            for (Lesson l : lessons)
                if (l.getExerciseType().equalsIgnoreCase(type)) filtered.add(l);
        }

        if (filtered.isEmpty()) {
            System.out.println("No lessons found!");
            return;
        }

        for (int i = 0; i < filtered.size(); i++) {
            Lesson l = filtered.get(i);
            System.out.println(i + ": " + l
                    + " | Price: £" + l.getPrice()
                    + " | Available: " + (4 - l.getBookingCount()));
        }

        System.out.print("Select lesson index (or -1 to go back): ");
        int newIndex = sc.nextInt();

        if (newIndex < 0 || newIndex >= filtered.size()) {
            System.out.println("Returning to main menu.");
            return;
        }

        Lesson newLesson = filtered.get(newIndex);

        if (newLesson == found.getLesson()) {
            System.out.println("That is the same lesson!");
            return;
        }

        if (newLesson.addBooking(found)) {
            found.changeLesson(newLesson);
            System.out.println("Booking ID " + id + " changed successfully to: " + newLesson
                    + " | Status: " + found.getStatus());
        } else {
            System.out.println("New lesson is FULL! Please select another lesson or return to main menu.");
        }
    }
    private static void attendLesson(Scanner sc, Member current) {
        System.out.println("\n===== YOUR BOOKINGS =====");
        boolean hasBookings = false;
        for (Booking b : bookings) {
            if (b.getMember() == current
                    && (b.getStatus().equals("booked") || b.getStatus().equals("changed"))) {
                System.out.println("ID: " + b.getBookingId()
                        + " | " + b.getLesson()
                        + " | Status: " + b.getStatus());
                hasBookings = true;
            }
        }
        if (!hasBookings) {
            System.out.println("You have no lessons to attend.");
            return;
        }
        System.out.print("Enter Booking ID: ");
        int id = sc.nextInt();

        Booking found = null;
        for (Booking b : bookings) {
            if (b.getBookingId() == id) { found = b; break; }
        }

        if (found == null) {
            System.out.println("Booking not found!");
            return;
        }

        if (found.getStatus().equals("cancelled")) {
            System.out.println("This booking is cancelled and cannot be attended!");
            return;
        }

        if (found.getStatus().equals("attended")) {
            System.out.println("This lesson has already been attended!");
            return;
        }

        System.out.println("Attending: " + found.getLesson()
                + " | Member: " + found.getMember().getName());

        int rating = 0;
        while (rating < 1 || rating > 5) {
            System.out.print("Enter rating (1-5): ");
            rating = sc.nextInt();
            if (rating < 1 || rating > 5)
                System.out.println("Invalid rating! Must be between 1 and 5.");
        }
        sc.nextLine();

        System.out.print("Enter review: ");
        String comment = sc.nextLine();

        found.attend(rating, comment);
        System.out.println("Lesson attended! Status updated to: " + found.getStatus());
    }

}