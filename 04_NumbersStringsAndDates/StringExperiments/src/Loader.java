//В проекте StringExperiments внести изменения таким образом, чтобы суммы заработков каждого человека извлекались из текста регулярным выражением,
// а в конце программы рассчитывалась и распечатывалась общая сумма заработка всех.


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader
{
    public static void main(String args[]) {
        String text = "Вася заработал 546487 рублей, Петя - 75637 рубля, а Маша - 305600 рублей";

        Pattern pattern = Pattern.compile("\\d+\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        System.out.println("----------");

        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(text);
        Integer sum = 0;
        while (m.find()) {
            sum += Integer.parseInt(m.group(1));
        }
        System.out.printf("%d\n", sum);


    }
    }


