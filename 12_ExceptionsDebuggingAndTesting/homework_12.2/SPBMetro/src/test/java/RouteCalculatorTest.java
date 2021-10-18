package test.java;

import junit.framework.TestCase;
import main.java.RouteCalculator;
import main.java.StationIndex;
import main.java.core.Line;
import main.java.core.Station;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> stations;
    StationIndex index = new StationIndex();
    RouteCalculator calculator = new RouteCalculator(index);

    @Before
    protected void setUp() throws Exception {
        stations = new ArrayList<>();
        List<Station> connect1 = new ArrayList<>();
        List<Station> connect2 = new ArrayList<>();
        Line lineFirst = new Line(1, "Первая");
        Line lineSecond = new Line(2, "Вторая");
        Line lIneThird = new Line(3, "Третья");

        stations.add(new Station("Горьковская", lineFirst));
        stations.add(new Station("Невский проспект", lineFirst));
        stations.add(new Station("Гостиный двор", lineSecond));
        stations.add(new Station("Маяковская", lineSecond));
        stations.add(new Station("Площадь восстания", lIneThird));
        stations.add(new Station("Чернышевская", lIneThird));

        index.addLine(lineFirst);
        index.addLine(lineSecond);
        index.addLine(lIneThird);
        stations.forEach(s -> index.addStation(s));
        lineFirst.addStation(index.getStation("Горьковская"));
        lineFirst.addStation(index.getStation("Невский проспект"));
        lineSecond.addStation(index.getStation("Гостиный двор"));
        lineSecond.addStation(index.getStation("Маяковская"));
        lIneThird.addStation(index.getStation("Площадь восстания"));
        lIneThird.addStation(index.getStation("Чернышевская"));
        connect1.add(index.getStation("Невский проспект"));
        connect1.add(index.getStation("Гостиный двор"));
        connect2.add(index.getStation("Маяковская"));
        connect2.add(index.getStation("Площадь восстания"));
        index.addConnection(connect1);
        index.addConnection(connect2);

    }

    @Test
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(stations);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetShortestRoute() {
        List<Station> actual = calculator.getShortestRoute(index.getStation("Горьковская"), index.getStation("Чернышевская"));
        List<Station> expected = stations;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetRouteOnTheLine() {
        List<Station> actual = calculator.getShortestRoute(index.getStation("Горьковская"), index.getStation("Невский проспект"));
        List<Station> expected = index.getLine(1).getStations();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetRouteWithOneConnection() {
        List<Station> actual = calculator.getShortestRoute(index.getStation("Горьковская"), index.getStation("Маяковская"));
        List<Station> expected = index.getLine(1).getStations();
        expected.addAll(index.getLine(2).getStations());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetRouteWithTwoConnections() {
        List<Station> actual = calculator.getShortestRoute(index.getStation("Горьковская"), index.getStation("Чернышевская"));
        List<Station> expected = stations;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {

    }
}
