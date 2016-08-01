package com.aleclownes.asciiweatherwatchface;

import android.graphics.Color;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by alownes on 7/7/2016.
 */

public abstract class WeatherFormatter {

    static HashMap<String, String> iconCodes;
    static int ICON_WIDTH = 13;
    static int SUMMARY_WIDTH = 13;
    static int TOTAL_WIDTH = ICON_WIDTH+SUMMARY_WIDTH;

    static{
        iconCodes = new HashMap<>();
        iconCodes.put("clear-day", "CL");
        iconCodes.put("clear-night", "CL");
        iconCodes.put("rain", "RN");
        iconCodes.put("snow", "SN");
        iconCodes.put("sleet", "SL");
        iconCodes.put("wind", "WN");
        iconCodes.put("fog", "FG");
        iconCodes.put("cloudy", "CD");
        iconCodes.put("partly-cloudy-day", "PC");
        iconCodes.put("partly-cloudy-night", "PC");
        iconCodes.put("hail", "HL");
        iconCodes.put("thunderstorm", "TH");
        iconCodes.put("tornado", "TO");
    }

    public static List<List<ColorText>> createDisplay(JSONObject json, DisplayType displayType) {
        //This is for error returning a blank screen
        List<List<ColorText>> lines = createLines(11);
        if (json == null){
            return lines;
        }
        JSONObject currently = json.optJSONObject("currently");
        if (currently == null){
            return lines;
        }
        JSONObject daily = json.optJSONObject("daily");
        if (daily == null){
            return lines;
        }
        JSONArray days = daily.optJSONArray("data");
        if (days == null){
            return lines;
        }
        JSONObject hourly = json.optJSONObject("hourly");
        if (hourly == null){
            return lines;
        }
        JSONArray hours = hourly.optJSONArray("data");
        if (hours == null){
            return lines;
        }
        JSONObject today = days.optJSONObject(0);
        if (today == null){
            return lines;
        }
        int repeats = json.optInt("repeats");
        switch(displayType){
            case CURRENT:
                return createCurrent(currently, today, days, repeats);
            case DETAIL:
                return createDetail(hours);
        }
        return lines;
    }

    private static List<List<ColorText>> createCurrent(JSONObject currently,
                                                       JSONObject today,
                                                       JSONArray days,
                                                       int repeats){
        List<List<ColorText>> lines = createLines(11);
        createWeatherIcon(currently.optString("icon"), lines, 0);
        createCurrentConditions(currently.optString("summary"), currently.optDouble("temperature"),
                currently.optDouble("windSpeed"), currently.optDouble("windBearing", 0),
                today.optLong("sunsetTime"),
                today.optDouble("precipAccumulation", 0),
                today.optDouble("precipProbability", 0),
                lines, 0);
        List<String> statuses = new ArrayList<>();
        List<Double> highTemps = new ArrayList<>();
        List<Double> lowTemps = new ArrayList<>();
        List<Double> precips = new ArrayList<>();
        for (int i = 1; i < 5; i++){
            JSONObject day = days.optJSONObject(i);
            if (day == null){
                return lines;
            }
            statuses.add(day.optString("icon"));
            highTemps.add(day.optDouble("temperatureMax", 0));
            lowTemps.add(day.optDouble("temperatureMin", 0));
            precips.add(day.optDouble("precipProbability", 0));
        }
        formatForecast(statuses, highTemps, lowTemps, precips, lines, 6);
        if (repeats > 0){
            List<ColorText> repeatLine = new ArrayList<>();
            repeatLine.add(new ColorText(Color.WHITE, "Repeats: " + repeats));
            lines.add(repeatLine);
        }
        return lines;
    }

    private static List<List<ColorText>> createDetail(JSONArray hours){
        List<List<ColorText>> lines = createLines(13);
        JSONObject firstHour = hours.optJSONObject(0);
        double[] rainData = new double[TOTAL_WIDTH];
        double rainCeil = 0;
        double rainFloor = 0;
        double[] tempData = new double[TOTAL_WIDTH];
        double tempCeil = 0;
        double tempFloor = 0;
        if (firstHour != null){
            rainCeil = firstHour.optDouble("precipProbability", 0);
            rainFloor = firstHour.optDouble("precipProbability", 0);
            tempCeil = firstHour.optDouble("temperature", 0);
            tempFloor = firstHour.optDouble("temperature", 0);
        }
        for (int i = 0; i < TOTAL_WIDTH; i++){
            JSONObject hour = hours.optJSONObject(i);
            if (hour == null){
                continue;
            }
            double temp = hour.optDouble("temperature", 0);
            double precip = hour.optDouble("precipProbability", 0)*100;
            if (temp > tempCeil){
                tempCeil = temp;
            }
            if (temp < tempFloor){
                tempFloor = temp;
            }
            tempData[i] = temp;
            if (precip > rainCeil){
                rainCeil = precip;
            }
            if (precip < rainFloor){
                rainFloor = precip;
            }
            rainData[i] = precip;
        }
        lines.get(0).add(new ColorText(Color.BLUE, (int)rainCeil+"% Rain"));
        createLineGraph(rainData, Color.BLUE, rainCeil, rainFloor, lines, 1);
        lines.get(5).add(new ColorText(Color.BLUE, (int)rainFloor+"%"));
        lines.get(6).add(getSeparator());
        lines.get(7).add(new ColorText(Color.YELLOW, (int)tempCeil+"°F Temperature"));
        createLineGraph(tempData, Color.YELLOW, tempCeil, tempFloor, lines, 8);
        lines.get(12).add(new ColorText(Color.YELLOW, (int)tempFloor+"°F"));
        return lines;
    }

    private static void createLineGraph(double[] data, int color, double ceil, double floor,
                                        List<List<ColorText>> lines, int start){
        for (int i = 0; i < data.length; i++){
            double point = data[i];
            int rowNum = start+(3-(int)(((point-floor)/(ceil-floor))*3));
            List<ColorText> row = lines.get(rowNum);
            int currentRowLength = getLengthOfColorTextList(row);
            if (currentRowLength < i){
                row.add(new ColorText(Color.WHITE,
                        String.format("%1$"+(i-currentRowLength)+"s", "")));
            }
            row.add(new ColorText(color, "."));
        }
    }

    /**
     * Creates a list of lists of color text. The result will be 11 items long.
     * @return List of lists of color text 11 items long.
     */
    private static List<List<ColorText>> createLines(int num){
        List<List<ColorText>> lines = new ArrayList<>();
        for (int i = 0; i < num; i++){
            lines.add(new ArrayList<ColorText>());
        }
        return lines;
    }

    private static void createWeatherIcon(String condition, List<List<ColorText>> lines,
                                          int start){
        int olive = Color.parseColor("olive");
        switch(condition){
            case "clear-day":
                lines.get(start+0).add(new ColorText(Color.YELLOW, "    \\   /    "));
                lines.get(start+1).add(new ColorText(Color.YELLOW, "     .-.     "));
                lines.get(start+2).add(new ColorText(Color.YELLOW, "  ‒ (   ) ‒  "));
                lines.get(start+3).add(new ColorText(Color.YELLOW, "     `-'     "));
                lines.get(start+4).add(new ColorText(Color.YELLOW, "    /   \\    "));
                break;
            case "clear-night":
                lines.get(start+0).add(new ColorText(Color.YELLOW, "     *    *  "));
                lines.get(start+1).add(new ColorText(Color.YELLOW, "  *  "));
                lines.get(start+1).add(new ColorText(Color.WHITE, ".-.     "));
                lines.get(start+2).add(new ColorText(Color.WHITE, "    ( (  "));
                lines.get(start+2).add(new ColorText(Color.YELLOW, "*   "));
                lines.get(start+3).add(new ColorText(Color.WHITE, "     `-`     "));
                lines.get(start+4).add(new ColorText(Color.YELLOW, "   *      *  "));
                break;
            case "rain":
                lines.get(start+0).add(new ColorText(Color.GRAY, "     .-.     "));
                lines.get(start+1).add(new ColorText(Color.GRAY, "    (   ).   "));
                lines.get(start+2).add(new ColorText(Color.GRAY, "   (___(__)  "));
                lines.get(start+3).add(new ColorText(Color.BLUE, "    ' ' ' '  "));
                lines.get(start+4).add(new ColorText(Color.BLUE, "   ' ' ' '   "));
                break;
            case "snow":
                lines.get(start+0).add(new ColorText(Color.LTGRAY, "     .-.     "));
                lines.get(start+1).add(new ColorText(Color.LTGRAY, "    (   ).   "));
                lines.get(start+2).add(new ColorText(Color.LTGRAY, "   (___(__)  "));
                lines.get(start+3).add(new ColorText(Color.WHITE, "    *  *  *  "));
                lines.get(start+4).add(new ColorText(Color.WHITE, "   *  *  *   "));
                break;
            case "sleet":
                lines.get(start+0).add(new ColorText(Color.LTGRAY, "     .-.     "));
                lines.get(start+1).add(new ColorText(Color.LTGRAY, "    (   ).   "));
                lines.get(start+2).add(new ColorText(Color.LTGRAY, "   (___(__)  "));
                lines.get(start+3).add(new ColorText(Color.BLUE, "    ' "));
                lines.get(start+3).add(new ColorText(Color.WHITE, "*"));
                lines.get(start+3).add(new ColorText(Color.BLUE, " ' "));
                lines.get(start+3).add(new ColorText(Color.WHITE, "*  "));
                lines.get(start+4).add(new ColorText(Color.WHITE, "   *"));
                lines.get(start+4).add(new ColorText(Color.BLUE, " ' "));
                lines.get(start+4).add(new ColorText(Color.WHITE, "*"));
                lines.get(start+4).add(new ColorText(Color.BLUE, " '   "));
                break;
            case "fog":
                lines.get(start+0).add(new ColorText(Color.LTGRAY, "             "));
                lines.get(start+1).add(new ColorText(Color.LTGRAY, " _ - _ - _ - "));
                lines.get(start+2).add(new ColorText(Color.LTGRAY, "  _ - _ - _  "));
                lines.get(start+3).add(new ColorText(Color.LTGRAY, " _ - _ - _ - "));
                lines.get(start+4).add(new ColorText(Color.LTGRAY, "             "));
                break;
            case "cloudy":
                lines.get(start+0).add(new ColorText(Color.LTGRAY, "             "));
                lines.get(start+1).add(new ColorText(Color.LTGRAY, "     .--.    "));
                lines.get(start+2).add(new ColorText(Color.LTGRAY, "  .-(    ).  "));
                lines.get(start+3).add(new ColorText(Color.LTGRAY, " (___.__)__) "));
                lines.get(start+4).add(new ColorText(Color.LTGRAY, "             "));
                break;
            case "wind":
                lines.get(start+0).add(new ColorText(Color.WHITE, "     ~    ~  "));
                lines.get(start+1).add(new ColorText(Color.WHITE, "  ~   ~"));
                lines.get(start+1).add(new ColorText(Color.GREEN, ". . "));
                lines.get(start+1).add(new ColorText(Color.WHITE, "~ "));
                lines.get(start+2).add(new ColorText(Color.WHITE, "    ~ "));
                lines.get(start+2).add(new ColorText(Color.GREEN, "( ) )  "));
                lines.get(start+3).add(new ColorText(Color.WHITE, " ~  "));
                lines.get(start+3).add(new ColorText(olive, ".-'"));
                lines.get(start+3).add(new ColorText(Color.GREEN, "(__)  "));
                lines.get(start+4).add(new ColorText(olive, "   //        "));
                break;
            case "partly-cloudy-day":
                lines.get(start+0).add(new ColorText(Color.YELLOW, "   \\  /      "));
                lines.get(start+1).add(new ColorText(Color.YELLOW, " _ /\"\""));
                lines.get(start+1).add(new ColorText(Color.LTGRAY, ".-.    "));
                lines.get(start+2).add(new ColorText(Color.YELLOW, "   \\_"));
                lines.get(start+2).add(new ColorText(Color.LTGRAY, "(   ).  "));
                lines.get(start+3).add(new ColorText(Color.YELLOW, "   /"));
                lines.get(start+3).add(new ColorText(Color.LTGRAY, "(___(__) "));
                lines.get(start+4).add(new ColorText(Color.LTGRAY, "             "));
                break;
            case "partly-cloudy-night":
                lines.get(start+0).add(new ColorText(Color.WHITE, "  .-. "));
                lines.get(start+0).add(new ColorText(Color.YELLOW, "*      "));
                lines.get(start+1).add(new ColorText(Color.WHITE, " ( (  "));
                lines.get(start+1).add(new ColorText(Color.LTGRAY, ".-. "));
                lines.get(start+1).add(new ColorText(Color.YELLOW, "*  "));
                lines.get(start+2).add(new ColorText(Color.WHITE, "  `-`"));
                lines.get(start+2).add(new ColorText(Color.LTGRAY, "(   ).  "));
                lines.get(start+3).add(new ColorText(Color.YELLOW, "  * "));
                lines.get(start+3).add(new ColorText(Color.LTGRAY, "(___(__) "));
                lines.get(start+4).add(new ColorText(Color.WHITE, "             "));
                break;
            case "thunderstorm":
                lines.get(start+0).add(new ColorText(Color.YELLOW, " _`/\"\""));
                lines.get(start+0).add(new ColorText(Color.DKGRAY, ".-.    "));
                lines.get(start+1).add(new ColorText(Color.YELLOW, "  ,\\_"));
                lines.get(start+1).add(new ColorText(Color.DKGRAY, "(   ).  "));
                lines.get(start+2).add(new ColorText(Color.YELLOW, "   /"));
                lines.get(start+2).add(new ColorText(Color.DKGRAY, "(___(__) "));
                lines.get(start+3).add(new ColorText(Color.YELLOW, "    /"));
                lines.get(start+3).add(new ColorText(Color.BLUE, "' '"));
                lines.get(start+3).add(new ColorText(Color.YELLOW, "/"));
                lines.get(start+3).add(new ColorText(Color.BLUE, "' ' "));
                lines.get(start+4).add(new ColorText(Color.YELLOW, "    /"));
                lines.get(start+4).add(new ColorText(Color.BLUE, " ' "));
                lines.get(start+4).add(new ColorText(Color.YELLOW, "/"));
                lines.get(start+4).add(new ColorText(Color.BLUE, " '  "));
                break;
            case "hail":
                lines.get(start+0).add(new ColorText(Color.YELLOW, " _`/\"\""));
                lines.get(start+0).add(new ColorText(Color.DKGRAY, ".-.    "));
                lines.get(start+1).add(new ColorText(Color.YELLOW, "  ,\\_"));
                lines.get(start+1).add(new ColorText(Color.DKGRAY, "(   ).  "));
                lines.get(start+2).add(new ColorText(Color.YELLOW, "   /"));
                lines.get(start+2).add(new ColorText(Color.DKGRAY, "(___(__) "));
                lines.get(start+3).add(new ColorText(Color.WHITE, "    o o o o  "));
                lines.get(start+4).add(new ColorText(Color.WHITE, "   o o o o   "));
                break;
            case "tornado":
                lines.get(start+0).add(new ColorText(Color.DKGRAY, " (___.__)__) "));
                lines.get(start+1).add(new ColorText(Color.GRAY, "   ~~~~~~    "));
                lines.get(start+2).add(new ColorText(Color.GRAY, "    ~~~~~    "));
                lines.get(start+3).add(new ColorText(Color.GRAY, "   ~~~~      "));
                lines.get(start+4).add(new ColorText(Color.GRAY, "    ~        "));
                break;
            default:
                lines.get(start+0).add(new ColorText(Color.WHITE, "    .-.      "));
                lines.get(start+1).add(new ColorText(Color.WHITE, "     __)     "));
                lines.get(start+2).add(new ColorText(Color.WHITE, "    (        "));
                lines.get(start+3).add(new ColorText(Color.WHITE, "     `-᾿     "));
                lines.get(start+4).add(new ColorText(Color.WHITE, "      •      "));
                break;
        }
    }

    private static void createCurrentConditions(String summary, double temperature,
                                                double windSpeed, double windDirection,
                                                long sunsetTime,
                                                double precipAccumulation,
                                                double precipProbability,
                                                List<List<ColorText>> lines,
                                                int start){
        if (summary.length() > SUMMARY_WIDTH){
            summary = summary.substring(0, SUMMARY_WIDTH-1)+"…";
        }
        lines.get(start+0).add(new ColorText(Color.WHITE, summary));
        lines.get(start+1).addAll(formatTemperature(temperature));
        lines.get(start+2).addAll(formatWind(windSpeed, windDirection));
        lines.get(start+3).addAll(formatSunset(sunsetTime));
        lines.get(start+4).addAll(formatPrecip(precipAccumulation, precipProbability));
        lines.get(start+5).add(getSeparator());
    }

    private static List<ColorText> formatTemperature(double temperature){
        List<ColorText> line = new ArrayList<>();
        int color;
        if (temperature < 32){
            color = Color.WHITE;
        }
        else if (temperature < 50){
            color = Color.BLUE;
        }
        else if (temperature < 80){
            color = Color.YELLOW;
        }
        else{
            color = Color.RED;
        }
        line.add(new ColorText(color, Integer.toString((int)Math.round(temperature))));
        line.add(new ColorText(Color.WHITE, " °F"));
        return line;
    }

    private static List<ColorText> formatWind(double windSpeed, double windDirection){
        List<ColorText> line = new ArrayList<>();
        int color;
        if (windSpeed < 2){
            color = Color.WHITE;
        }
        else if (windSpeed < 5){
            color = Color.GREEN;
        }
        else if (windSpeed < 11){
            color = Color.YELLOW;
        }
        else{
            color = Color.RED;
        }
        String direction;
        if (windSpeed == 0){
            direction = "";
        }
        else if (windDirection < 45){
            direction = "↓";
        }
        else if (windDirection < 90){
            direction = "↙";
        }
        else if (windDirection < 135){
            direction = "←";
        }
        else if (windDirection < 180){
            direction = "↖";
        }
        else if (windDirection < 225){
            direction = "↑";
        }
        else if (windDirection < 270){
            direction = "↗";
        }
        else if (windDirection < 315){
            direction = "→";
        }
        else if (windDirection < 360){
            direction = "↘";
        }
        else{
            direction = "";
        }
        line.add(new ColorText(Color.WHITE, direction + " "));
        line.add(new ColorText(color, Integer.toString((int)Math.round(windSpeed))+" mph"));
        return line;
    }

    private static List<ColorText> formatSunset(long time){
        Date d = new Date(time*1000);
        DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT);
        df.setTimeZone(TimeZone.getDefault());
        String text = df.format(d);
        List<ColorText> line = new ArrayList<>();
        line.add(new ColorText(Color.RED, "Set: "));
        line.add(new ColorText(Color.WHITE, text));
        return line;
    }

    private static List<ColorText> formatPrecip(double precipAccumulation,
                                                double precipProbability){
        List<ColorText> line = new ArrayList<>();
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(1);
        line.add(new ColorText(Color.WHITE, df.format(precipAccumulation) +
                " in | " + (int)(precipProbability*100)+"%"));
        return line;
    }

    /**
     * Returns TOTAL_WIDTH horizontal line separator characters in white
     * @return
     */
    private static ColorText getSeparator(){
        //"──────────────────────"
        return new ColorText(Color.WHITE, "--------------------------");
    }

    private static void formatForecast(List<String> statuses,
                                       List<Double> highTemps,
                                       List<Double> lowTemps,
                                       List<Double> precips,
                                       List<List<ColorText>> lines,
                                       int start){
        final int totalWidth = 6;
        for (int i = 0; i < 4; i++){
            String code = iconCodes.get(statuses.get(i));
            if (code == null){
                code = "UN";
            }
            lines.get(start).add(new ColorText(Color.WHITE, " "+code+"   "));
            List<ColorText> highTemp = formatTemperature(highTemps.get(i));
            highTemp.add(0, new ColorText(Color.WHITE, " "));
            int highTempLength = getLengthOfColorTextList(highTemp);
            if (highTempLength < totalWidth){
                highTemp.add(new ColorText(Color.WHITE,
                        String.format("%1$"+(totalWidth-highTempLength)+"s", "")));
            }
            lines.get(start+1).addAll(highTemp);
            List<ColorText> lowTemp = formatTemperature(lowTemps.get(i));
            lowTemp.add(0, new ColorText(Color.WHITE, " "));
            int lowTempLength = getLengthOfColorTextList(lowTemp);
            if (lowTempLength < totalWidth){
                lowTemp.add(new ColorText(Color.WHITE,
                        String.format("%1$"+(totalWidth-lowTempLength)+"s", "")));
            }
            lines.get(start+2).addAll(lowTemp);
            String precip = " "+(int)(precips.get(i)*100)+"%";
            precip = String.format("%1$-6s", precip);
            lines.get(start+3).add(new ColorText(Color.WHITE, precip));
        }
        lines.get(start+4).add(getSeparator());
    }

    private static int getLengthOfColorTextList(List<ColorText> colorTextList){
        int i = 0;
        for (ColorText text : colorTextList){
            i += text.getText().length();
        }
        return i;
    }

    public enum DisplayType{
        CURRENT,
        DETAIL;
    }

}
