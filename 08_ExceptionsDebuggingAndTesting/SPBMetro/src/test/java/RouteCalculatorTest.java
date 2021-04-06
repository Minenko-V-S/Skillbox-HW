import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class RouteCalculatorTest extends TestCase {

    List<Station> routeOnTheFirstLine;   //1
    List<Station> routeOnTheSecondLine;  //2
    List<Station> routeNoTransfer;   //3


    StationIndex stationIndex;
    RouteCalculator routeCalculator;



    @Override
    public void setUp() throws Exception {
// Схема "Метро"
        /*             Линия(1)                          Линия(2)               Линия(3)
         *           Московская                         Шарташская                Лесная
         *               ↑                                   ↑                      ↑
         *               ↓                                   ↓                      ↓
         *           Уралмашь                             Озёрная    ←→          Пажарная
         *               ↑                                   ↑                      ↑
         *               ↓                                   ↓                      ↓
         *        Машиностроителей                        Шефская                 Дачная
         *               ↑                                   ↑                       ↑
         *               ↓                                   ↓                       ↓
         *           Уральская                          Комсомольская             Гаражная
         *               ↑                                   ↑
         *               ↓                                   ↓
         *             Динамо                            Гагаринская
         *               ↑                                   ↑
         *               ↓                                   ↓
         *             Омская             ←→              Каминка
         *               ↑
         *               ↓
         *          Геологическая
         *               ↑
         *               ↓
         *            Бажовская
         *
         *
         * */


        stationIndex = new StationIndex();

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");


        Station moskovskaya = new Station("Московская", line1);
        Station uralmash = new Station("Уралмашь", line1);
        Station mashinostroiteley = new Station("Машиностроителей", line1);
        Station uralskaya = new Station("Уральская", line1);
        Station dinamo = new Station("Динамо", line1);
        Station omskaya = new Station("Омская", line1);
        Station geologicheskaya = new Station("Геологическая", line1);
        Station bojovskaya = new Station("Бажовская", line1);

        Station kaminka = new Station("Каминка", line2);
        Station gagarinskaya = new Station("Гагаринская", line2);
        Station komsomolskaya = new Station("Комсомольская", line2);
        Station shefskaya = new Station("Шефская", line2);
        Station ozernaya = new Station("Озёрная", line2);
        Station shartashskaya = new Station("Шарташская", line2);

        Station pagarnaya = new Station("Пажарная", line3);
        Station lesnaya = new Station("Лесная", line3);
        Station dachnaya = new Station("Дачная", line3);
        Station garagnaya = new Station("Гаражная", line3);

        Stream.of(line1, line2, line3).forEach(stationIndex::addLine);
        Stream.of(moskovskaya, uralmash, mashinostroiteley, uralskaya, dinamo, omskaya, geologicheskaya, bojovskaya,
                kaminka, gagarinskaya, komsomolskaya, shefskaya, ozernaya, shartashskaya, pagarnaya, lesnaya, dachnaya, garagnaya)
                .peek(s -> s.getLine().addStation(s)).forEach(stationIndex::addStation);
//пересадки
        stationIndex.addConnection(Stream.of(omskaya, kaminka).collect(Collectors.toList()));
        stationIndex.addConnection(Stream.of(kaminka, ozernaya).collect(Collectors.toList()));
        stationIndex.addConnection(Stream.of(ozernaya, pagarnaya).collect(Collectors.toList()));

        stationIndex.getConnectedStations(moskovskaya);
        stationIndex.getConnectedStations(omskaya);

        routeCalculator = new RouteCalculator(stationIndex);


//тестовый маршрут
        routeOnTheFirstLine = Stream.of(moskovskaya, omskaya, kaminka, shartashskaya)
                .collect(Collectors.toList());
        routeOnTheSecondLine = Stream.of(moskovskaya, kaminka, ozernaya, pagarnaya, garagnaya)
                .collect(Collectors.toList());
        routeNoTransfer = Stream.of(uralmash, bojovskaya).collect(Collectors.toList());


    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(routeOnTheSecondLine);
        double expected = 12.0;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute()
    {
        routeNoTransfer = new ArrayList<>();
        routeNoTransfer.add(stationIndex.getStation("Московская"));
        routeNoTransfer.add(stationIndex.getStation("Уралмашь"));
        routeNoTransfer.add(stationIndex.getStation("Машиностроителей"));
        routeNoTransfer.add(stationIndex.getStation("Уральская"));
        routeNoTransfer.add(stationIndex.getStation("Динамо"));


        List<Station> actual1 = routeCalculator.getShortestRoute(stationIndex.getStation("Московская", 1), stationIndex.getStation("Динамо", 1));
        List<Station> expectedNoTransfers = routeNoTransfer;
        assertEquals(expectedNoTransfers, actual1);




    }
}