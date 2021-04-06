
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pojo.Line;
import pojo.Station;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
@Data
public class Parser {

    private List<Line> lines = new LinkedList<>(); //линии метро
    private Map<String, List<String>> stations = new TreeMap<>(); //станции
    private List<List<Station>> connection = new ArrayList<>(); //пересадки

//парсим пересадки
    private void parseConnections(Elements cols, String stationName) {
        List<String> connectionsLine = cols.get(3).children().eachAttr("title");
        List<String> connectionsNumber = cols.get(3).children().eachText();
        List<String> lineNumbers = cols.get(0).children().eachText();
        String lineId = lineNumbers.get(1);
        if (connectionsNumber.size() != 0) {
            List<Station> temp = new ArrayList<>();
            temp.add(new Station(lineId, stationName));
            for (int i = 0; i < connectionsNumber.size(); i++) {
                temp.add(new Station(connectionsNumber.get(i), connectionsLine.get(i)));
            }
            connection.add(temp);
        }
    }
//парсим линии метро
    private void parseLines(String lineName, List<String> lineNumbers) {
        Line line = new Line(lineNumbers.get(0), lineName);
        if (!lines.contains(line)) lines.add(line);
    }
//парсим станции
    private void parseStation(String stationName, List<String> lineNumbers, List<String> connectionsLineName) {
        String lineId = lineNumbers.get(0);
        if (!stations.containsKey(lineId)) {
            stations.put(lineId, new ArrayList<>());
            stations.get(lineId).add(stationName);
        } else {
            stations.get(lineId).add(stationName);
        }

        if (connectionsLineName.size() == 2) {
            if (!stations.containsKey(lineNumbers.get(1)))
                stations.put(lineNumbers.get(1), new ArrayList<>());
            else {
                stations.get(lineNumbers.get(1)).add(stationName);
            }
        }
    }

    protected String parseFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> sb.append(line).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
//парсим HTML фаил
    protected void parseInputDataHtmlFile(String file) {
        Document document = Jsoup.parse(parseFile(file));
        Element table = document.select("table").get(3);
        Elements rows = table.select("tr");
        rows.stream().skip(1).forEach((row) -> {
            Elements cols = row.select("td");
            String stationName = cols.get(1).text();
            String lineName = cols.get(0).child(1).attr("title");
            List<String> lineNumbers = cols.get(0).children().eachText();
            List<String> connectionsLineName = cols.get(0).children().eachAttr("title");
            List<String> connectionsNumber = cols.get(3).children().eachText();

            parseStation(stationName, lineNumbers, connectionsLineName);
            parseLines(lineName, lineNumbers);
            if (connectionsNumber.size() != 0) {
                parseConnections(cols, stationName);
            }
        });
    }
}