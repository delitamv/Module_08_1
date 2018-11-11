package TaskThree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Images {
    static String URL = "http://www.google.ru/intl/en_com/images/logo_plain.png";
            private static final List<String> images = new ArrayList<>(25);
            static {
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("https://upload.wikimedia.org/wikipedia/commons/8/80/Coiled_Galaxy.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");

                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("https://upload.wikimedia.org/wikipedia/commons/9/99/Papagaio-verdadeiro.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");

                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("https://upload.wikimedia.org/wikipedia/commons/3/30/Amazona_aestiva_-upper_body-8a_%281%29.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");

                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("https://upload.wikimedia.org/wikipedia/commons/4/41/Diaethria_marchalii.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");

                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
                images.add("http://personal.psu.edu/xqz5228/jpg.jpg");
            }

            public List<String> getList() {
                return images;
            }

            public ArrayList<String> getRandomImages() {
                Random random = new Random();
                ArrayList<String> result = new ArrayList<>(25);
                for (int i = 0; i < 25; i++) {
                    result.add(images.get(random.nextInt(images.size())));
                }
                return result;
            }


}
