import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DayOfTheProgrammer {
    DayOfTheProgrammer() {
        System.out.println(solve(2017));
        System.out.println(solve(2016));
        System.out.println(solve(1800));
        System.out.println(solve(1916));
    }
    static String solve(int year) {
        int d = (year == 1918)
                ? 241
                : year > 1918
                ? 255
                : (year % 4 == 0 || year % 100 == 0)
                ? 255
                : 255 + 1;
        LocalDate ld = LocalDate.of(year, Month.JANUARY, 1);
        ld = ld.plusDays(d);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        return ld.format(dtf);
    }
}
