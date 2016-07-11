package com.aleclownes.asciiweatherwatchface;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by alownes on 7/7/2016.
 */

public abstract class StubData {

    /*
    JSON is
{
  "latitude":37.8267,
  "longitude":-122.423,
  "timezone":"America/Los_Angeles",
  "offset":-7,
  "currently":{
    "time":1467917594,
    "summary":"Loading Data...",
    "icon":"unknown",
    "nearestStormDistance":353,
    "nearestStormBearing":341,
    "precipIntensity":0,
    "precipProbability":0,
    "temperature":58.52,
    "apparentTemperature":58.52,
    "dewPoint":51.3,
    "humidity":0.77,
    "windSpeed":9.9,
    "windBearing":260,
    "visibility":8.23,
    "cloudCover":0.91,
    "pressure":1015.59,
    "ozone":308.89
  },
  "minutely":{
    "summary":"Mostly cloudy for the hour.",
    "icon":"partly-cloudy-day",
    "data":[
      {
        "time":1467917580,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467917640,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467917700,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467917760,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467917820,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467917880,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467917940,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918000,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918060,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918120,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918180,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918240,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918300,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918360,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918420,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918480,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918540,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918600,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918660,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918720,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918780,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918840,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918900,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467918960,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919020,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919080,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919140,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919200,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919260,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919320,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919380,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919440,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919500,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919560,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919620,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919680,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919740,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919800,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919860,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919920,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467919980,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920040,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920100,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920160,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920220,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920280,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920340,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920400,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920460,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920520,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920580,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920640,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920700,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920760,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920820,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920880,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467920940,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467921000,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467921060,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467921120,
        "precipIntensity":0,
        "precipProbability":0
      },
      {
        "time":1467921180,
        "precipIntensity":0,
        "precipProbability":0
      }
    ]
  },
  "hourly":{
    "summary":"Mostly cloudy throughout the day.",
    "icon":"partly-cloudy-night",
    "data":[
      {
        "time":1467914400,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":56.77,
        "apparentTemperature":56.77,
        "dewPoint":52.35,
        "humidity":0.85,
        "windSpeed":8.9,
        "windBearing":257,
        "visibility":7.65,
        "cloudCover":0.88,
        "pressure":1015.71,
        "ozone":308.79
      },
      {
        "time":1467918000,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":58.74,
        "apparentTemperature":58.74,
        "dewPoint":51.15,
        "humidity":0.76,
        "windSpeed":10.03,
        "windBearing":261,
        "visibility":8.31,
        "cloudCover":0.92,
        "pressure":1015.57,
        "ozone":308.91
      },
      {
        "time":1467921600,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":60.65,
        "apparentTemperature":60.65,
        "dewPoint":51.91,
        "humidity":0.73,
        "windSpeed":10.57,
        "windBearing":264,
        "visibility":8.45,
        "cloudCover":0.81,
        "pressure":1015.32,
        "ozone":309.24
      },
      {
        "time":1467925200,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":62.43,
        "apparentTemperature":62.43,
        "dewPoint":52.63,
        "humidity":0.7,
        "windSpeed":11.42,
        "windBearing":266,
        "visibility":8.42,
        "cloudCover":0.65,
        "pressure":1015.02,
        "ozone":309.34
      },
      {
        "time":1467928800,
        "summary":"Partly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":63.48,
        "apparentTemperature":63.48,
        "dewPoint":53.15,
        "humidity":0.69,
        "windSpeed":12.02,
        "windBearing":268,
        "visibility":8.43,
        "cloudCover":0.59,
        "pressure":1014.65,
        "ozone":309.02
      },
      {
        "time":1467932400,
        "summary":"Partly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":64.1,
        "apparentTemperature":64.1,
        "dewPoint":53.67,
        "humidity":0.69,
        "windSpeed":12.38,
        "windBearing":269,
        "visibility":8.85,
        "cloudCover":0.51,
        "pressure":1014.26,
        "ozone":308.46
      },
      {
        "time":1467936000,
        "summary":"Partly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":63.52,
        "apparentTemperature":63.52,
        "dewPoint":53.28,
        "humidity":0.69,
        "windSpeed":12.78,
        "windBearing":269,
        "visibility":9.03,
        "cloudCover":0.51,
        "pressure":1013.97,
        "ozone":307.78
      },
      {
        "time":1467939600,
        "summary":"Partly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":62.12,
        "apparentTemperature":62.12,
        "dewPoint":52.99,
        "humidity":0.72,
        "windSpeed":12.8,
        "windBearing":270,
        "visibility":8.91,
        "cloudCover":0.52,
        "pressure":1013.81,
        "ozone":306.97
      },
      {
        "time":1467943200,
        "summary":"Partly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":60.2,
        "apparentTemperature":60.2,
        "dewPoint":52.5,
        "humidity":0.76,
        "windSpeed":12.1,
        "windBearing":271,
        "visibility":8.48,
        "cloudCover":0.55,
        "pressure":1013.71,
        "ozone":306.05
      },
      {
        "time":1467946800,
        "summary":"Partly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":58.61,
        "apparentTemperature":58.61,
        "dewPoint":52.58,
        "humidity":0.8,
        "windSpeed":11.44,
        "windBearing":271,
        "visibility":7.36,
        "cloudCover":0.59,
        "pressure":1013.72,
        "ozone":305.14
      },
      {
        "time":1467950400,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":57.21,
        "apparentTemperature":57.21,
        "dewPoint":52.93,
        "humidity":0.86,
        "windSpeed":11.01,
        "windBearing":273,
        "visibility":5.68,
        "cloudCover":0.76,
        "pressure":1013.92,
        "ozone":304.38
      },
      {
        "time":1467954000,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":56.3,
        "apparentTemperature":56.3,
        "dewPoint":52.89,
        "humidity":0.88,
        "windSpeed":10.41,
        "windBearing":273,
        "visibility":4.91,
        "cloudCover":0.84,
        "pressure":1014.24,
        "ozone":303.62
      },
      {
        "time":1467957600,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":55.37,
        "apparentTemperature":55.37,
        "dewPoint":52.5,
        "humidity":0.9,
        "windSpeed":10.04,
        "windBearing":274,
        "visibility":4.45,
        "cloudCover":0.9,
        "pressure":1014.47,
        "ozone":302.66
      },
      {
        "time":1467961200,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":54.97,
        "apparentTemperature":54.97,
        "dewPoint":52.31,
        "humidity":0.91,
        "windSpeed":9.94,
        "windBearing":274,
        "visibility":4.37,
        "cloudCover":0.93,
        "pressure":1014.52,
        "ozone":301.25
      },
      {
        "time":1467964800,
        "summary":"Overcast",
        "icon":"cloudy",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":54.68,
        "apparentTemperature":54.68,
        "dewPoint":52.14,
        "humidity":0.91,
        "windSpeed":9.55,
        "windBearing":274,
        "visibility":4.43,
        "cloudCover":0.95,
        "pressure":1014.48,
        "ozone":299.63
      },
      {
        "time":1467968400,
        "summary":"Overcast",
        "icon":"cloudy",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":55.22,
        "apparentTemperature":55.22,
        "dewPoint":52.81,
        "humidity":0.92,
        "windSpeed":9.12,
        "windBearing":273,
        "visibility":4.43,
        "cloudCover":0.95,
        "pressure":1014.44,
        "ozone":298.32
      },
      {
        "time":1467972000,
        "summary":"Overcast",
        "icon":"cloudy",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":55.5,
        "apparentTemperature":55.5,
        "dewPoint":53.21,
        "humidity":0.92,
        "windSpeed":8.75,
        "windBearing":273,
        "visibility":4.61,
        "cloudCover":0.96,
        "pressure":1014.38,
        "ozone":297.49
      },
      {
        "time":1467975600,
        "summary":"Overcast",
        "icon":"cloudy",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":55.76,
        "apparentTemperature":55.76,
        "dewPoint":53.47,
        "humidity":0.92,
        "windSpeed":8.23,
        "windBearing":273,
        "visibility":4.64,
        "cloudCover":0.96,
        "pressure":1014.32,
        "ozone":296.96
      },
      {
        "time":1467979200,
        "summary":"Overcast",
        "icon":"cloudy",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":55.89,
        "apparentTemperature":55.89,
        "dewPoint":53.45,
        "humidity":0.91,
        "windSpeed":7.54,
        "windBearing":271,
        "visibility":5.78,
        "cloudCover":0.96,
        "pressure":1014.38,
        "ozone":296.78
      },
      {
        "time":1467982800,
        "summary":"Overcast",
        "icon":"cloudy",
        "precipIntensity":0.0008,
        "precipProbability":0.01,
        "precipType":"rain",
        "temperature":55.99,
        "apparentTemperature":55.99,
        "dewPoint":53.32,
        "humidity":0.91,
        "windSpeed":6.82,
        "windBearing":268,
        "visibility":7.07,
        "cloudCover":0.96,
        "pressure":1014.63,
        "ozone":297.1
      },
      {
        "time":1467986400,
        "summary":"Overcast",
        "icon":"cloudy",
        "precipIntensity":0.0009,
        "precipProbability":0.01,
        "precipType":"rain",
        "temperature":56.26,
        "apparentTemperature":56.26,
        "dewPoint":53.29,
        "humidity":0.9,
        "windSpeed":6.05,
        "windBearing":266,
        "visibility":8.22,
        "cloudCover":0.96,
        "pressure":1015.01,
        "ozone":297.75
      },
      {
        "time":1467990000,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0.0008,
        "precipProbability":0.01,
        "precipType":"rain",
        "temperature":56.85,
        "apparentTemperature":56.85,
        "dewPoint":53.11,
        "humidity":0.87,
        "windSpeed":5.86,
        "windBearing":265,
        "visibility":9.03,
        "cloudCover":0.93,
        "pressure":1015.38,
        "ozone":298.3
      },
      {
        "time":1467993600,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":57.77,
        "apparentTemperature":57.77,
        "dewPoint":52.89,
        "humidity":0.84,
        "windSpeed":6.19,
        "windBearing":261,
        "visibility":10,
        "cloudCover":0.87,
        "pressure":1015.74,
        "ozone":298.36
      },
      {
        "time":1467997200,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":59.43,
        "apparentTemperature":59.43,
        "dewPoint":53.07,
        "humidity":0.79,
        "windSpeed":7.14,
        "windBearing":261,
        "visibility":10,
        "cloudCover":0.74,
        "pressure":1016.05,
        "ozone":298.31
      },
      {
        "time":1468000800,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":61.08,
        "apparentTemperature":61.08,
        "dewPoint":53.32,
        "humidity":0.76,
        "windSpeed":8.03,
        "windBearing":263,
        "visibility":10,
        "cloudCover":0.67,
        "pressure":1016.23,
        "ozone":298.85
      },
      {
        "time":1468004400,
        "summary":"Partly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":62.71,
        "apparentTemperature":62.71,
        "dewPoint":54.3,
        "humidity":0.74,
        "windSpeed":9.07,
        "windBearing":266,
        "visibility":10,
        "cloudCover":0.54,
        "pressure":1016.22,
        "ozone":300.71
      },
      {
        "time":1468008000,
        "summary":"Partly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":65.08,
        "apparentTemperature":65.08,
        "dewPoint":55.71,
        "humidity":0.72,
        "windSpeed":10.39,
        "windBearing":270,
        "visibility":10,
        "cloudCover":0.41,
        "pressure":1016.09,
        "ozone":303.16
      },
      {
        "time":1468011600,
        "summary":"Partly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":67.17,
        "apparentTemperature":67.17,
        "dewPoint":56.94,
        "humidity":0.7,
        "windSpeed":11.64,
        "windBearing":273,
        "visibility":10,
        "cloudCover":0.3,
        "pressure":1015.91,
        "ozone":304.71
      },
      {
        "time":1468015200,
        "summary":"Clear",
        "icon":"clear-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":68.43,
        "apparentTemperature":68.43,
        "dewPoint":57.74,
        "humidity":0.69,
        "windSpeed":12.65,
        "windBearing":276,
        "visibility":10,
        "cloudCover":0.23,
        "pressure":1015.72,
        "ozone":304.6
      },
      {
        "time":1468018800,
        "summary":"Clear",
        "icon":"clear-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":69.01,
        "apparentTemperature":69.01,
        "dewPoint":58.26,
        "humidity":0.69,
        "windSpeed":13.38,
        "windBearing":279,
        "visibility":10,
        "cloudCover":0.17,
        "pressure":1015.52,
        "ozone":303.59
      },
      {
        "time":1468022400,
        "summary":"Clear",
        "icon":"clear-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":68.3,
        "apparentTemperature":68.3,
        "dewPoint":58.13,
        "humidity":0.7,
        "windSpeed":13.58,
        "windBearing":280,
        "visibility":10,
        "cloudCover":0.15,
        "pressure":1015.42,
        "ozone":302.48
      },
      {
        "time":1468026000,
        "summary":"Clear",
        "icon":"clear-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":66.83,
        "apparentTemperature":66.83,
        "dewPoint":57.9,
        "humidity":0.73,
        "windSpeed":13.18,
        "windBearing":280,
        "visibility":10,
        "cloudCover":0.12,
        "pressure":1015.42,
        "ozone":301.48
      },
      {
        "time":1468029600,
        "summary":"Clear",
        "icon":"clear-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":64.78,
        "apparentTemperature":64.78,
        "dewPoint":57.5,
        "humidity":0.77,
        "windSpeed":12.24,
        "windBearing":279,
        "visibility":10,
        "cloudCover":0.09,
        "pressure":1015.49,
        "ozone":300.37
      },
      {
        "time":1468033200,
        "summary":"Clear",
        "icon":"clear-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":62.74,
        "apparentTemperature":62.74,
        "dewPoint":57.02,
        "humidity":0.82,
        "windSpeed":11.03,
        "windBearing":280,
        "visibility":10,
        "cloudCover":0.11,
        "pressure":1015.67,
        "ozone":299.31
      },
      {
        "time":1468036800,
        "summary":"Clear",
        "icon":"clear-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":60.86,
        "apparentTemperature":60.86,
        "dewPoint":56.57,
        "humidity":0.86,
        "windSpeed":10.04,
        "windBearing":279,
        "visibility":8.67,
        "cloudCover":0.22,
        "pressure":1016.02,
        "ozone":298.38
      },
      {
        "time":1468040400,
        "summary":"Partly Cloudy",
        "icon":"partly-cloudy-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":59.07,
        "apparentTemperature":59.07,
        "dewPoint":56.12,
        "humidity":0.9,
        "windSpeed":9.16,
        "windBearing":278,
        "visibility":6.81,
        "cloudCover":0.38,
        "pressure":1016.46,
        "ozone":297.49
      },
      {
        "time":1468044000,
        "summary":"Partly Cloudy",
        "icon":"partly-cloudy-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":57.64,
        "apparentTemperature":57.64,
        "dewPoint":55.67,
        "humidity":0.93,
        "windSpeed":8.42,
        "windBearing":276,
        "visibility":5.22,
        "cloudCover":0.53,
        "pressure":1016.78,
        "ozone":296.55
      },
      {
        "time":1468047600,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":56.77,
        "apparentTemperature":56.77,
        "dewPoint":55.29,
        "humidity":0.95,
        "windSpeed":7.86,
        "windBearing":274,
        "visibility":4.02,
        "cloudCover":0.63,
        "pressure":1016.9,
        "ozone":295.43
      },
      {
        "time":1468051200,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":56.32,
        "apparentTemperature":56.32,
        "dewPoint":55.04,
        "humidity":0.95,
        "windSpeed":7.4,
        "windBearing":272,
        "visibility":3.09,
        "cloudCover":0.7,
        "pressure":1016.92,
        "ozone":294.27
      },
      {
        "time":1468054800,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":56.08,
        "apparentTemperature":56.08,
        "dewPoint":54.92,
        "humidity":0.96,
        "windSpeed":6.95,
        "windBearing":271,
        "visibility":2.89,
        "cloudCover":0.76,
        "pressure":1016.95,
        "ozone":293.34
      },
      {
        "time":1468058400,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":56.07,
        "apparentTemperature":56.07,
        "dewPoint":55.01,
        "humidity":0.96,
        "windSpeed":6.36,
        "windBearing":271,
        "visibility":3.95,
        "cloudCover":0.79,
        "pressure":1017,
        "ozone":292.79
      },
      {
        "time":1468062000,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":56.34,
        "apparentTemperature":56.34,
        "dewPoint":55.27,
        "humidity":0.96,
        "windSpeed":5.66,
        "windBearing":272,
        "visibility":5.75,
        "cloudCover":0.81,
        "pressure":1017.08,
        "ozone":292.48
      },
      {
        "time":1468065600,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":56.77,
        "apparentTemperature":56.77,
        "dewPoint":55.58,
        "humidity":0.96,
        "windSpeed":5.38,
        "windBearing":273,
        "visibility":7.13,
        "cloudCover":0.82,
        "pressure":1017.24,
        "ozone":292.22
      },
      {
        "time":1468069200,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-night",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":57.22,
        "apparentTemperature":57.22,
        "dewPoint":55.85,
        "humidity":0.95,
        "windSpeed":5.36,
        "windBearing":273,
        "visibility":7.56,
        "cloudCover":0.85,
        "pressure":1017.54,
        "ozone":292.03
      },
      {
        "time":1468072800,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":57.75,
        "apparentTemperature":57.75,
        "dewPoint":56.08,
        "humidity":0.94,
        "windSpeed":5.53,
        "windBearing":272,
        "visibility":7.58,
        "cloudCover":0.87,
        "pressure":1017.93,
        "ozone":291.9
      },
      {
        "time":1468076400,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":58.59,
        "apparentTemperature":58.59,
        "dewPoint":56.4,
        "humidity":0.92,
        "windSpeed":5.93,
        "windBearing":272,
        "visibility":7.62,
        "cloudCover":0.89,
        "pressure":1018.32,
        "ozone":291.66
      },
      {
        "time":1468080000,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":59.95,
        "apparentTemperature":59.95,
        "dewPoint":56.94,
        "humidity":0.9,
        "windSpeed":6.61,
        "windBearing":272,
        "visibility":7.8,
        "cloudCover":0.89,
        "pressure":1018.67,
        "ozone":291.19
      },
      {
        "time":1468083600,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":61.54,
        "apparentTemperature":61.54,
        "dewPoint":57.47,
        "humidity":0.86,
        "windSpeed":7.55,
        "windBearing":274,
        "visibility":8,
        "cloudCover":0.87,
        "pressure":1018.97,
        "ozone":290.6
      },
      {
        "time":1468087200,
        "summary":"Mostly Cloudy",
        "icon":"partly-cloudy-day",
        "precipIntensity":0,
        "precipProbability":0,
        "temperature":63.02,
        "apparentTemperature":63.02,
        "dewPoint":57.75,
        "humidity":0.83,
        "windSpeed":8.82,
        "windBearing":275,
        "visibility":8.32,
        "cloudCover":0.8,
        "pressure":1019.15,
        "ozone":290.15
      }
    ]
  },
  "daily":{
    "summary":"No precipitation throughout the week, with temperatures rising to 71°F on Thursday.",
    "icon":"clear-day",
    "data":[
      {
        "time":1467874800,
        "summary":"Mostly cloudy throughout the day.",
        "icon":"partly-cloudy-day",
        "sunriseTime":1467896155,
        "sunsetTime":1467948941,
        "moonPhase":0.12,
        "precipIntensity":0,
        "precipIntensityMax":0,
        "precipProbability":0,
        "temperatureMin":53.82,
        "temperatureMinTime":1467892800,
        "temperatureMax":64.1,
        "temperatureMaxTime":1467932400,
        "apparentTemperatureMin":53.82,
        "apparentTemperatureMinTime":1467892800,
        "apparentTemperatureMax":64.1,
        "apparentTemperatureMaxTime":1467932400,
        "dewPoint":52.25,
        "humidity":0.84,
        "windSpeed":9.98,
        "windBearing":266,
        "visibility":6.97,
        "cloudCover":0.72,
        "pressure":1014.62,
        "ozone":309.38
      },
      {
        "time":1467961200,
        "summary":"Mostly cloudy until afternoon.",
        "icon":"partly-cloudy-day",
        "sunriseTime":1467982591,
        "sunsetTime":1468035322,
        "moonPhase":0.15,
        "precipIntensity":0.0003,
        "precipIntensityMax":0.0009,
        "precipIntensityMaxTime":1467986400,
        "precipProbability":0.01,
        "precipType":"rain",
        "temperatureMin":54.68,
        "temperatureMinTime":1467964800,
        "temperatureMax":69.01,
        "temperatureMaxTime":1468018800,
        "apparentTemperatureMin":54.68,
        "apparentTemperatureMinTime":1467964800,
        "apparentTemperatureMax":69.01,
        "apparentTemperatureMaxTime":1468018800,
        "dewPoint":54.93,
        "humidity":0.82,
        "windSpeed":9.45,
        "windBearing":274,
        "visibility":8.08,
        "cloudCover":0.59,
        "pressure":1015.43,
        "ozone":299.66
      },
      {
        "time":1468047600,
        "summary":"Mostly cloudy until afternoon.",
        "icon":"partly-cloudy-day",
        "sunriseTime":1468069028,
        "sunsetTime":1468121702,
        "moonPhase":0.18,
        "precipIntensity":0,
        "precipIntensityMax":0,
        "precipProbability":0,
        "temperatureMin":53.66,
        "temperatureMinTime":1468130400,
        "temperatureMax":67.34,
        "temperatureMaxTime":1468101600,
        "apparentTemperatureMin":53.66,
        "apparentTemperatureMinTime":1468130400,
        "apparentTemperatureMax":67.34,
        "apparentTemperatureMaxTime":1468101600,
        "dewPoint":53.88,
        "humidity":0.82,
        "windSpeed":9.83,
        "windBearing":275,
        "visibility":8.01,
        "cloudCover":0.53,
        "pressure":1017.97,
        "ozone":295.93
      },
      {
        "time":1468134000,
        "summary":"Partly cloudy in the morning.",
        "icon":"partly-cloudy-night",
        "sunriseTime":1468155466,
        "sunsetTime":1468208081,
        "moonPhase":0.21,
        "precipIntensity":0,
        "precipIntensityMax":0,
        "precipProbability":0,
        "temperatureMin":52.41,
        "temperatureMinTime":1468148400,
        "temperatureMax":68.95,
        "temperatureMaxTime":1468184400,
        "apparentTemperatureMin":52.41,
        "apparentTemperatureMinTime":1468148400,
        "apparentTemperatureMax":68.95,
        "apparentTemperatureMaxTime":1468184400,
        "dewPoint":49.22,
        "humidity":0.69,
        "windSpeed":8.71,
        "windBearing":289,
        "visibility":10,
        "cloudCover":0.15,
        "pressure":1016.46,
        "ozone":317.28
      },
      {
        "time":1468220400,
        "summary":"Clear throughout the day.",
        "icon":"clear-day",
        "sunriseTime":1468241905,
        "sunsetTime":1468294457,
        "moonPhase":0.24,
        "precipIntensity":0,
        "precipIntensityMax":0,
        "precipProbability":0,
        "temperatureMin":56.2,
        "temperatureMinTime":1468220400,
        "temperatureMax":68.68,
        "temperatureMaxTime":1468267200,
        "apparentTemperatureMin":56.2,
        "apparentTemperatureMinTime":1468220400,
        "apparentTemperatureMax":68.68,
        "apparentTemperatureMaxTime":1468267200,
        "dewPoint":48.98,
        "humidity":0.64,
        "windSpeed":5.5,
        "windBearing":254,
        "cloudCover":0,
        "pressure":1012.26,
        "ozone":298.74
      },
      {
        "time":1468306800,
        "summary":"Clear throughout the day.",
        "icon":"clear-day",
        "sunriseTime":1468328345,
        "sunsetTime":1468380832,
        "moonPhase":0.27,
        "precipIntensity":0,
        "precipIntensityMax":0,
        "precipProbability":0,
        "temperatureMin":54.75,
        "temperatureMinTime":1468324800,
        "temperatureMax":70.91,
        "temperatureMaxTime":1468360800,
        "apparentTemperatureMin":54.75,
        "apparentTemperatureMinTime":1468324800,
        "apparentTemperatureMax":70.91,
        "apparentTemperatureMaxTime":1468360800,
        "dewPoint":50.29,
        "humidity":0.69,
        "windSpeed":5.14,
        "windBearing":235,
        "cloudCover":0,
        "pressure":1011.75,
        "ozone":294.5
      },
      {
        "time":1468393200,
        "summary":"Mostly cloudy until afternoon.",
        "icon":"partly-cloudy-day",
        "sunriseTime":1468414786,
        "sunsetTime":1468467205,
        "moonPhase":0.3,
        "precipIntensity":0,
        "precipIntensityMax":0,
        "precipProbability":0,
        "temperatureMin":53.65,
        "temperatureMinTime":1468411200,
        "temperatureMax":69.35,
        "temperatureMaxTime":1468450800,
        "apparentTemperatureMin":53.65,
        "apparentTemperatureMinTime":1468411200,
        "apparentTemperatureMax":69.35,
        "apparentTemperatureMaxTime":1468450800,
        "dewPoint":51.72,
        "humidity":0.74,
        "windSpeed":5.22,
        "windBearing":220,
        "cloudCover":0.16,
        "pressure":1013.26,
        "ozone":292.02
      },
      {
        "time":1468479600,
        "summary":"Clear throughout the day.",
        "icon":"clear-day",
        "sunriseTime":1468501228,
        "sunsetTime":1468553576,
        "moonPhase":0.33,
        "precipIntensity":0,
        "precipIntensityMax":0,
        "precipProbability":0,
        "temperatureMin":55.44,
        "temperatureMinTime":1468494000,
        "temperatureMax":71.42,
        "temperatureMaxTime":1468530000,
        "apparentTemperatureMin":55.44,
        "apparentTemperatureMinTime":1468494000,
        "apparentTemperatureMax":71.42,
        "apparentTemperatureMaxTime":1468530000,
        "dewPoint":51.39,
        "humidity":0.7,
        "windSpeed":5.56,
        "windBearing":227,
        "cloudCover":0,
        "pressure":1012.53,
        "ozone":289.82
      }
    ]
  },
  "flags":{
    "sources":[
      "darksky",
      "lamp",
      "gfs",
      "cmc",
      "nam",
      "rap",
      "rtma",
      "sref",
      "fnmoc",
      "isd",
      "nwspa",
      "madis",
      "nearest-precip"
    ],
    "darksky-stations":[
      "KMUX"
    ],
    "lamp-stations":[
      "KAPC",
      "KCCR",
      "KHWD",
      "KLVK",
      "KNUQ",
      "KOAK",
      "KPAO",
      "KSFO",
      "KSQL"
    ],
    "isd-stations":[
      "724943-99999",
      "745039-99999",
      "745065-99999",
      "994016-99999",
      "998479-99999"
    ],
    "madis-stations":[
      "AU915",
      "C5988",
      "C8158",
      "C9629",
      "CQ147",
      "CQ188",
      "D5422",
      "E0426",
      "E6067",
      "E9227",
      "FTPC1",
      "GGBC1",
      "OKXC1",
      "PPXC1",
      "PXOC1",
      "SFOC1"
    ],
    "units":"us"
  }
}
     */

    public static JSONObject getStubData() {
        String jsonString = "{\n" +
                "  \"latitude\":37.8267,\n" +
                "  \"longitude\":-122.423,\n" +
                "  \"timezone\":\"America/Los_Angeles\",\n" +
                "  \"offset\":-7,\n" +
                "  \"currently\":{\n" +
                "    \"time\":1467917594,\n" +
                "    \"summary\":\"Loading Data...\",\n" +
                "    \"icon\":\"unknown\",\n" +
                "    \"nearestStormDistance\":353,\n" +
                "    \"nearestStormBearing\":341,\n" +
                "    \"precipIntensity\":0,\n" +
                "    \"precipProbability\":0,\n" +
                "    \"temperature\":58.52,\n" +
                "    \"apparentTemperature\":58.52,\n" +
                "    \"dewPoint\":51.3,\n" +
                "    \"humidity\":0.77,\n" +
                "    \"windSpeed\":9.9,\n" +
                "    \"windBearing\":260,\n" +
                "    \"visibility\":8.23,\n" +
                "    \"cloudCover\":0.91,\n" +
                "    \"pressure\":1015.59,\n" +
                "    \"ozone\":308.89\n" +
                "  },\n" +
                "  \"minutely\":{\n" +
                "    \"summary\":\"Mostly cloudy for the hour.\",\n" +
                "    \"icon\":\"partly-cloudy-day\",\n" +
                "    \"data\":[\n" +
                "      {\n" +
                "        \"time\":1467917580,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467917640,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467917700,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467917760,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467917820,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467917880,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467917940,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918000,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918060,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918120,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918180,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918240,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918300,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918360,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918420,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918480,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918540,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918600,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918660,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918720,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918780,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918840,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918900,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918960,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919020,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919080,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919140,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919200,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919260,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919320,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919380,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919440,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919500,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919560,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919620,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919680,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919740,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919800,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919860,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919920,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467919980,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920040,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920100,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920160,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920220,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920280,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920340,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920400,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920460,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920520,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920580,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920640,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920700,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920760,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920820,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920880,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467920940,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467921000,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467921060,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467921120,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467921180,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"hourly\":{\n" +
                "    \"summary\":\"Mostly cloudy throughout the day.\",\n" +
                "    \"icon\":\"partly-cloudy-night\",\n" +
                "    \"data\":[\n" +
                "      {\n" +
                "        \"time\":1467914400,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":56.77,\n" +
                "        \"apparentTemperature\":56.77,\n" +
                "        \"dewPoint\":52.35,\n" +
                "        \"humidity\":0.85,\n" +
                "        \"windSpeed\":8.9,\n" +
                "        \"windBearing\":257,\n" +
                "        \"visibility\":7.65,\n" +
                "        \"cloudCover\":0.88,\n" +
                "        \"pressure\":1015.71,\n" +
                "        \"ozone\":308.79\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467918000,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":58.74,\n" +
                "        \"apparentTemperature\":58.74,\n" +
                "        \"dewPoint\":51.15,\n" +
                "        \"humidity\":0.76,\n" +
                "        \"windSpeed\":10.03,\n" +
                "        \"windBearing\":261,\n" +
                "        \"visibility\":8.31,\n" +
                "        \"cloudCover\":0.92,\n" +
                "        \"pressure\":1015.57,\n" +
                "        \"ozone\":308.91\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467921600,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":60.65,\n" +
                "        \"apparentTemperature\":60.65,\n" +
                "        \"dewPoint\":51.91,\n" +
                "        \"humidity\":0.73,\n" +
                "        \"windSpeed\":10.57,\n" +
                "        \"windBearing\":264,\n" +
                "        \"visibility\":8.45,\n" +
                "        \"cloudCover\":0.81,\n" +
                "        \"pressure\":1015.32,\n" +
                "        \"ozone\":309.24\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467925200,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":62.43,\n" +
                "        \"apparentTemperature\":62.43,\n" +
                "        \"dewPoint\":52.63,\n" +
                "        \"humidity\":0.7,\n" +
                "        \"windSpeed\":11.42,\n" +
                "        \"windBearing\":266,\n" +
                "        \"visibility\":8.42,\n" +
                "        \"cloudCover\":0.65,\n" +
                "        \"pressure\":1015.02,\n" +
                "        \"ozone\":309.34\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467928800,\n" +
                "        \"summary\":\"Partly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":63.48,\n" +
                "        \"apparentTemperature\":63.48,\n" +
                "        \"dewPoint\":53.15,\n" +
                "        \"humidity\":0.69,\n" +
                "        \"windSpeed\":12.02,\n" +
                "        \"windBearing\":268,\n" +
                "        \"visibility\":8.43,\n" +
                "        \"cloudCover\":0.59,\n" +
                "        \"pressure\":1014.65,\n" +
                "        \"ozone\":309.02\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467932400,\n" +
                "        \"summary\":\"Partly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":64.1,\n" +
                "        \"apparentTemperature\":64.1,\n" +
                "        \"dewPoint\":53.67,\n" +
                "        \"humidity\":0.69,\n" +
                "        \"windSpeed\":12.38,\n" +
                "        \"windBearing\":269,\n" +
                "        \"visibility\":8.85,\n" +
                "        \"cloudCover\":0.51,\n" +
                "        \"pressure\":1014.26,\n" +
                "        \"ozone\":308.46\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467936000,\n" +
                "        \"summary\":\"Partly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":63.52,\n" +
                "        \"apparentTemperature\":63.52,\n" +
                "        \"dewPoint\":53.28,\n" +
                "        \"humidity\":0.69,\n" +
                "        \"windSpeed\":12.78,\n" +
                "        \"windBearing\":269,\n" +
                "        \"visibility\":9.03,\n" +
                "        \"cloudCover\":0.51,\n" +
                "        \"pressure\":1013.97,\n" +
                "        \"ozone\":307.78\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467939600,\n" +
                "        \"summary\":\"Partly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":62.12,\n" +
                "        \"apparentTemperature\":62.12,\n" +
                "        \"dewPoint\":52.99,\n" +
                "        \"humidity\":0.72,\n" +
                "        \"windSpeed\":12.8,\n" +
                "        \"windBearing\":270,\n" +
                "        \"visibility\":8.91,\n" +
                "        \"cloudCover\":0.52,\n" +
                "        \"pressure\":1013.81,\n" +
                "        \"ozone\":306.97\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467943200,\n" +
                "        \"summary\":\"Partly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":60.2,\n" +
                "        \"apparentTemperature\":60.2,\n" +
                "        \"dewPoint\":52.5,\n" +
                "        \"humidity\":0.76,\n" +
                "        \"windSpeed\":12.1,\n" +
                "        \"windBearing\":271,\n" +
                "        \"visibility\":8.48,\n" +
                "        \"cloudCover\":0.55,\n" +
                "        \"pressure\":1013.71,\n" +
                "        \"ozone\":306.05\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467946800,\n" +
                "        \"summary\":\"Partly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":58.61,\n" +
                "        \"apparentTemperature\":58.61,\n" +
                "        \"dewPoint\":52.58,\n" +
                "        \"humidity\":0.8,\n" +
                "        \"windSpeed\":11.44,\n" +
                "        \"windBearing\":271,\n" +
                "        \"visibility\":7.36,\n" +
                "        \"cloudCover\":0.59,\n" +
                "        \"pressure\":1013.72,\n" +
                "        \"ozone\":305.14\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467950400,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":57.21,\n" +
                "        \"apparentTemperature\":57.21,\n" +
                "        \"dewPoint\":52.93,\n" +
                "        \"humidity\":0.86,\n" +
                "        \"windSpeed\":11.01,\n" +
                "        \"windBearing\":273,\n" +
                "        \"visibility\":5.68,\n" +
                "        \"cloudCover\":0.76,\n" +
                "        \"pressure\":1013.92,\n" +
                "        \"ozone\":304.38\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467954000,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":56.3,\n" +
                "        \"apparentTemperature\":56.3,\n" +
                "        \"dewPoint\":52.89,\n" +
                "        \"humidity\":0.88,\n" +
                "        \"windSpeed\":10.41,\n" +
                "        \"windBearing\":273,\n" +
                "        \"visibility\":4.91,\n" +
                "        \"cloudCover\":0.84,\n" +
                "        \"pressure\":1014.24,\n" +
                "        \"ozone\":303.62\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467957600,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":55.37,\n" +
                "        \"apparentTemperature\":55.37,\n" +
                "        \"dewPoint\":52.5,\n" +
                "        \"humidity\":0.9,\n" +
                "        \"windSpeed\":10.04,\n" +
                "        \"windBearing\":274,\n" +
                "        \"visibility\":4.45,\n" +
                "        \"cloudCover\":0.9,\n" +
                "        \"pressure\":1014.47,\n" +
                "        \"ozone\":302.66\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467961200,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":54.97,\n" +
                "        \"apparentTemperature\":54.97,\n" +
                "        \"dewPoint\":52.31,\n" +
                "        \"humidity\":0.91,\n" +
                "        \"windSpeed\":9.94,\n" +
                "        \"windBearing\":274,\n" +
                "        \"visibility\":4.37,\n" +
                "        \"cloudCover\":0.93,\n" +
                "        \"pressure\":1014.52,\n" +
                "        \"ozone\":301.25\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467964800,\n" +
                "        \"summary\":\"Overcast\",\n" +
                "        \"icon\":\"cloudy\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":54.68,\n" +
                "        \"apparentTemperature\":54.68,\n" +
                "        \"dewPoint\":52.14,\n" +
                "        \"humidity\":0.91,\n" +
                "        \"windSpeed\":9.55,\n" +
                "        \"windBearing\":274,\n" +
                "        \"visibility\":4.43,\n" +
                "        \"cloudCover\":0.95,\n" +
                "        \"pressure\":1014.48,\n" +
                "        \"ozone\":299.63\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467968400,\n" +
                "        \"summary\":\"Overcast\",\n" +
                "        \"icon\":\"cloudy\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":55.22,\n" +
                "        \"apparentTemperature\":55.22,\n" +
                "        \"dewPoint\":52.81,\n" +
                "        \"humidity\":0.92,\n" +
                "        \"windSpeed\":9.12,\n" +
                "        \"windBearing\":273,\n" +
                "        \"visibility\":4.43,\n" +
                "        \"cloudCover\":0.95,\n" +
                "        \"pressure\":1014.44,\n" +
                "        \"ozone\":298.32\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467972000,\n" +
                "        \"summary\":\"Overcast\",\n" +
                "        \"icon\":\"cloudy\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":55.5,\n" +
                "        \"apparentTemperature\":55.5,\n" +
                "        \"dewPoint\":53.21,\n" +
                "        \"humidity\":0.92,\n" +
                "        \"windSpeed\":8.75,\n" +
                "        \"windBearing\":273,\n" +
                "        \"visibility\":4.61,\n" +
                "        \"cloudCover\":0.96,\n" +
                "        \"pressure\":1014.38,\n" +
                "        \"ozone\":297.49\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467975600,\n" +
                "        \"summary\":\"Overcast\",\n" +
                "        \"icon\":\"cloudy\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":55.76,\n" +
                "        \"apparentTemperature\":55.76,\n" +
                "        \"dewPoint\":53.47,\n" +
                "        \"humidity\":0.92,\n" +
                "        \"windSpeed\":8.23,\n" +
                "        \"windBearing\":273,\n" +
                "        \"visibility\":4.64,\n" +
                "        \"cloudCover\":0.96,\n" +
                "        \"pressure\":1014.32,\n" +
                "        \"ozone\":296.96\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467979200,\n" +
                "        \"summary\":\"Overcast\",\n" +
                "        \"icon\":\"cloudy\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":55.89,\n" +
                "        \"apparentTemperature\":55.89,\n" +
                "        \"dewPoint\":53.45,\n" +
                "        \"humidity\":0.91,\n" +
                "        \"windSpeed\":7.54,\n" +
                "        \"windBearing\":271,\n" +
                "        \"visibility\":5.78,\n" +
                "        \"cloudCover\":0.96,\n" +
                "        \"pressure\":1014.38,\n" +
                "        \"ozone\":296.78\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467982800,\n" +
                "        \"summary\":\"Overcast\",\n" +
                "        \"icon\":\"cloudy\",\n" +
                "        \"precipIntensity\":0.0008,\n" +
                "        \"precipProbability\":0.01,\n" +
                "        \"precipType\":\"rain\",\n" +
                "        \"temperature\":55.99,\n" +
                "        \"apparentTemperature\":55.99,\n" +
                "        \"dewPoint\":53.32,\n" +
                "        \"humidity\":0.91,\n" +
                "        \"windSpeed\":6.82,\n" +
                "        \"windBearing\":268,\n" +
                "        \"visibility\":7.07,\n" +
                "        \"cloudCover\":0.96,\n" +
                "        \"pressure\":1014.63,\n" +
                "        \"ozone\":297.1\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467986400,\n" +
                "        \"summary\":\"Overcast\",\n" +
                "        \"icon\":\"cloudy\",\n" +
                "        \"precipIntensity\":0.0009,\n" +
                "        \"precipProbability\":0.01,\n" +
                "        \"precipType\":\"rain\",\n" +
                "        \"temperature\":56.26,\n" +
                "        \"apparentTemperature\":56.26,\n" +
                "        \"dewPoint\":53.29,\n" +
                "        \"humidity\":0.9,\n" +
                "        \"windSpeed\":6.05,\n" +
                "        \"windBearing\":266,\n" +
                "        \"visibility\":8.22,\n" +
                "        \"cloudCover\":0.96,\n" +
                "        \"pressure\":1015.01,\n" +
                "        \"ozone\":297.75\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467990000,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0.0008,\n" +
                "        \"precipProbability\":0.01,\n" +
                "        \"precipType\":\"rain\",\n" +
                "        \"temperature\":56.85,\n" +
                "        \"apparentTemperature\":56.85,\n" +
                "        \"dewPoint\":53.11,\n" +
                "        \"humidity\":0.87,\n" +
                "        \"windSpeed\":5.86,\n" +
                "        \"windBearing\":265,\n" +
                "        \"visibility\":9.03,\n" +
                "        \"cloudCover\":0.93,\n" +
                "        \"pressure\":1015.38,\n" +
                "        \"ozone\":298.3\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467993600,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":57.77,\n" +
                "        \"apparentTemperature\":57.77,\n" +
                "        \"dewPoint\":52.89,\n" +
                "        \"humidity\":0.84,\n" +
                "        \"windSpeed\":6.19,\n" +
                "        \"windBearing\":261,\n" +
                "        \"visibility\":10,\n" +
                "        \"cloudCover\":0.87,\n" +
                "        \"pressure\":1015.74,\n" +
                "        \"ozone\":298.36\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467997200,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":59.43,\n" +
                "        \"apparentTemperature\":59.43,\n" +
                "        \"dewPoint\":53.07,\n" +
                "        \"humidity\":0.79,\n" +
                "        \"windSpeed\":7.14,\n" +
                "        \"windBearing\":261,\n" +
                "        \"visibility\":10,\n" +
                "        \"cloudCover\":0.74,\n" +
                "        \"pressure\":1016.05,\n" +
                "        \"ozone\":298.31\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468000800,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":61.08,\n" +
                "        \"apparentTemperature\":61.08,\n" +
                "        \"dewPoint\":53.32,\n" +
                "        \"humidity\":0.76,\n" +
                "        \"windSpeed\":8.03,\n" +
                "        \"windBearing\":263,\n" +
                "        \"visibility\":10,\n" +
                "        \"cloudCover\":0.67,\n" +
                "        \"pressure\":1016.23,\n" +
                "        \"ozone\":298.85\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468004400,\n" +
                "        \"summary\":\"Partly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":62.71,\n" +
                "        \"apparentTemperature\":62.71,\n" +
                "        \"dewPoint\":54.3,\n" +
                "        \"humidity\":0.74,\n" +
                "        \"windSpeed\":9.07,\n" +
                "        \"windBearing\":266,\n" +
                "        \"visibility\":10,\n" +
                "        \"cloudCover\":0.54,\n" +
                "        \"pressure\":1016.22,\n" +
                "        \"ozone\":300.71\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468008000,\n" +
                "        \"summary\":\"Partly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":65.08,\n" +
                "        \"apparentTemperature\":65.08,\n" +
                "        \"dewPoint\":55.71,\n" +
                "        \"humidity\":0.72,\n" +
                "        \"windSpeed\":10.39,\n" +
                "        \"windBearing\":270,\n" +
                "        \"visibility\":10,\n" +
                "        \"cloudCover\":0.41,\n" +
                "        \"pressure\":1016.09,\n" +
                "        \"ozone\":303.16\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468011600,\n" +
                "        \"summary\":\"Partly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":67.17,\n" +
                "        \"apparentTemperature\":67.17,\n" +
                "        \"dewPoint\":56.94,\n" +
                "        \"humidity\":0.7,\n" +
                "        \"windSpeed\":11.64,\n" +
                "        \"windBearing\":273,\n" +
                "        \"visibility\":10,\n" +
                "        \"cloudCover\":0.3,\n" +
                "        \"pressure\":1015.91,\n" +
                "        \"ozone\":304.71\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468015200,\n" +
                "        \"summary\":\"Clear\",\n" +
                "        \"icon\":\"clear-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":68.43,\n" +
                "        \"apparentTemperature\":68.43,\n" +
                "        \"dewPoint\":57.74,\n" +
                "        \"humidity\":0.69,\n" +
                "        \"windSpeed\":12.65,\n" +
                "        \"windBearing\":276,\n" +
                "        \"visibility\":10,\n" +
                "        \"cloudCover\":0.23,\n" +
                "        \"pressure\":1015.72,\n" +
                "        \"ozone\":304.6\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468018800,\n" +
                "        \"summary\":\"Clear\",\n" +
                "        \"icon\":\"clear-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":69.01,\n" +
                "        \"apparentTemperature\":69.01,\n" +
                "        \"dewPoint\":58.26,\n" +
                "        \"humidity\":0.69,\n" +
                "        \"windSpeed\":13.38,\n" +
                "        \"windBearing\":279,\n" +
                "        \"visibility\":10,\n" +
                "        \"cloudCover\":0.17,\n" +
                "        \"pressure\":1015.52,\n" +
                "        \"ozone\":303.59\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468022400,\n" +
                "        \"summary\":\"Clear\",\n" +
                "        \"icon\":\"clear-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":68.3,\n" +
                "        \"apparentTemperature\":68.3,\n" +
                "        \"dewPoint\":58.13,\n" +
                "        \"humidity\":0.7,\n" +
                "        \"windSpeed\":13.58,\n" +
                "        \"windBearing\":280,\n" +
                "        \"visibility\":10,\n" +
                "        \"cloudCover\":0.15,\n" +
                "        \"pressure\":1015.42,\n" +
                "        \"ozone\":302.48\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468026000,\n" +
                "        \"summary\":\"Clear\",\n" +
                "        \"icon\":\"clear-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":66.83,\n" +
                "        \"apparentTemperature\":66.83,\n" +
                "        \"dewPoint\":57.9,\n" +
                "        \"humidity\":0.73,\n" +
                "        \"windSpeed\":13.18,\n" +
                "        \"windBearing\":280,\n" +
                "        \"visibility\":10,\n" +
                "        \"cloudCover\":0.12,\n" +
                "        \"pressure\":1015.42,\n" +
                "        \"ozone\":301.48\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468029600,\n" +
                "        \"summary\":\"Clear\",\n" +
                "        \"icon\":\"clear-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":64.78,\n" +
                "        \"apparentTemperature\":64.78,\n" +
                "        \"dewPoint\":57.5,\n" +
                "        \"humidity\":0.77,\n" +
                "        \"windSpeed\":12.24,\n" +
                "        \"windBearing\":279,\n" +
                "        \"visibility\":10,\n" +
                "        \"cloudCover\":0.09,\n" +
                "        \"pressure\":1015.49,\n" +
                "        \"ozone\":300.37\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468033200,\n" +
                "        \"summary\":\"Clear\",\n" +
                "        \"icon\":\"clear-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":62.74,\n" +
                "        \"apparentTemperature\":62.74,\n" +
                "        \"dewPoint\":57.02,\n" +
                "        \"humidity\":0.82,\n" +
                "        \"windSpeed\":11.03,\n" +
                "        \"windBearing\":280,\n" +
                "        \"visibility\":10,\n" +
                "        \"cloudCover\":0.11,\n" +
                "        \"pressure\":1015.67,\n" +
                "        \"ozone\":299.31\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468036800,\n" +
                "        \"summary\":\"Clear\",\n" +
                "        \"icon\":\"clear-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":60.86,\n" +
                "        \"apparentTemperature\":60.86,\n" +
                "        \"dewPoint\":56.57,\n" +
                "        \"humidity\":0.86,\n" +
                "        \"windSpeed\":10.04,\n" +
                "        \"windBearing\":279,\n" +
                "        \"visibility\":8.67,\n" +
                "        \"cloudCover\":0.22,\n" +
                "        \"pressure\":1016.02,\n" +
                "        \"ozone\":298.38\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468040400,\n" +
                "        \"summary\":\"Partly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":59.07,\n" +
                "        \"apparentTemperature\":59.07,\n" +
                "        \"dewPoint\":56.12,\n" +
                "        \"humidity\":0.9,\n" +
                "        \"windSpeed\":9.16,\n" +
                "        \"windBearing\":278,\n" +
                "        \"visibility\":6.81,\n" +
                "        \"cloudCover\":0.38,\n" +
                "        \"pressure\":1016.46,\n" +
                "        \"ozone\":297.49\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468044000,\n" +
                "        \"summary\":\"Partly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":57.64,\n" +
                "        \"apparentTemperature\":57.64,\n" +
                "        \"dewPoint\":55.67,\n" +
                "        \"humidity\":0.93,\n" +
                "        \"windSpeed\":8.42,\n" +
                "        \"windBearing\":276,\n" +
                "        \"visibility\":5.22,\n" +
                "        \"cloudCover\":0.53,\n" +
                "        \"pressure\":1016.78,\n" +
                "        \"ozone\":296.55\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468047600,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":56.77,\n" +
                "        \"apparentTemperature\":56.77,\n" +
                "        \"dewPoint\":55.29,\n" +
                "        \"humidity\":0.95,\n" +
                "        \"windSpeed\":7.86,\n" +
                "        \"windBearing\":274,\n" +
                "        \"visibility\":4.02,\n" +
                "        \"cloudCover\":0.63,\n" +
                "        \"pressure\":1016.9,\n" +
                "        \"ozone\":295.43\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468051200,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":56.32,\n" +
                "        \"apparentTemperature\":56.32,\n" +
                "        \"dewPoint\":55.04,\n" +
                "        \"humidity\":0.95,\n" +
                "        \"windSpeed\":7.4,\n" +
                "        \"windBearing\":272,\n" +
                "        \"visibility\":3.09,\n" +
                "        \"cloudCover\":0.7,\n" +
                "        \"pressure\":1016.92,\n" +
                "        \"ozone\":294.27\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468054800,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":56.08,\n" +
                "        \"apparentTemperature\":56.08,\n" +
                "        \"dewPoint\":54.92,\n" +
                "        \"humidity\":0.96,\n" +
                "        \"windSpeed\":6.95,\n" +
                "        \"windBearing\":271,\n" +
                "        \"visibility\":2.89,\n" +
                "        \"cloudCover\":0.76,\n" +
                "        \"pressure\":1016.95,\n" +
                "        \"ozone\":293.34\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468058400,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":56.07,\n" +
                "        \"apparentTemperature\":56.07,\n" +
                "        \"dewPoint\":55.01,\n" +
                "        \"humidity\":0.96,\n" +
                "        \"windSpeed\":6.36,\n" +
                "        \"windBearing\":271,\n" +
                "        \"visibility\":3.95,\n" +
                "        \"cloudCover\":0.79,\n" +
                "        \"pressure\":1017,\n" +
                "        \"ozone\":292.79\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468062000,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":56.34,\n" +
                "        \"apparentTemperature\":56.34,\n" +
                "        \"dewPoint\":55.27,\n" +
                "        \"humidity\":0.96,\n" +
                "        \"windSpeed\":5.66,\n" +
                "        \"windBearing\":272,\n" +
                "        \"visibility\":5.75,\n" +
                "        \"cloudCover\":0.81,\n" +
                "        \"pressure\":1017.08,\n" +
                "        \"ozone\":292.48\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468065600,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":56.77,\n" +
                "        \"apparentTemperature\":56.77,\n" +
                "        \"dewPoint\":55.58,\n" +
                "        \"humidity\":0.96,\n" +
                "        \"windSpeed\":5.38,\n" +
                "        \"windBearing\":273,\n" +
                "        \"visibility\":7.13,\n" +
                "        \"cloudCover\":0.82,\n" +
                "        \"pressure\":1017.24,\n" +
                "        \"ozone\":292.22\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468069200,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":57.22,\n" +
                "        \"apparentTemperature\":57.22,\n" +
                "        \"dewPoint\":55.85,\n" +
                "        \"humidity\":0.95,\n" +
                "        \"windSpeed\":5.36,\n" +
                "        \"windBearing\":273,\n" +
                "        \"visibility\":7.56,\n" +
                "        \"cloudCover\":0.85,\n" +
                "        \"pressure\":1017.54,\n" +
                "        \"ozone\":292.03\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468072800,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":57.75,\n" +
                "        \"apparentTemperature\":57.75,\n" +
                "        \"dewPoint\":56.08,\n" +
                "        \"humidity\":0.94,\n" +
                "        \"windSpeed\":5.53,\n" +
                "        \"windBearing\":272,\n" +
                "        \"visibility\":7.58,\n" +
                "        \"cloudCover\":0.87,\n" +
                "        \"pressure\":1017.93,\n" +
                "        \"ozone\":291.9\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468076400,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":58.59,\n" +
                "        \"apparentTemperature\":58.59,\n" +
                "        \"dewPoint\":56.4,\n" +
                "        \"humidity\":0.92,\n" +
                "        \"windSpeed\":5.93,\n" +
                "        \"windBearing\":272,\n" +
                "        \"visibility\":7.62,\n" +
                "        \"cloudCover\":0.89,\n" +
                "        \"pressure\":1018.32,\n" +
                "        \"ozone\":291.66\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468080000,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":59.95,\n" +
                "        \"apparentTemperature\":59.95,\n" +
                "        \"dewPoint\":56.94,\n" +
                "        \"humidity\":0.9,\n" +
                "        \"windSpeed\":6.61,\n" +
                "        \"windBearing\":272,\n" +
                "        \"visibility\":7.8,\n" +
                "        \"cloudCover\":0.89,\n" +
                "        \"pressure\":1018.67,\n" +
                "        \"ozone\":291.19\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468083600,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":61.54,\n" +
                "        \"apparentTemperature\":61.54,\n" +
                "        \"dewPoint\":57.47,\n" +
                "        \"humidity\":0.86,\n" +
                "        \"windSpeed\":7.55,\n" +
                "        \"windBearing\":274,\n" +
                "        \"visibility\":8,\n" +
                "        \"cloudCover\":0.87,\n" +
                "        \"pressure\":1018.97,\n" +
                "        \"ozone\":290.6\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468087200,\n" +
                "        \"summary\":\"Mostly Cloudy\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperature\":63.02,\n" +
                "        \"apparentTemperature\":63.02,\n" +
                "        \"dewPoint\":57.75,\n" +
                "        \"humidity\":0.83,\n" +
                "        \"windSpeed\":8.82,\n" +
                "        \"windBearing\":275,\n" +
                "        \"visibility\":8.32,\n" +
                "        \"cloudCover\":0.8,\n" +
                "        \"pressure\":1019.15,\n" +
                "        \"ozone\":290.15\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"daily\":{\n" +
                "    \"summary\":\"No precipitation throughout the week, with temperatures rising to 71°F on Thursday.\",\n" +
                "    \"icon\":\"clear-day\",\n" +
                "    \"data\":[\n" +
                "      {\n" +
                "        \"time\":1467874800,\n" +
                "        \"summary\":\"Mostly cloudy throughout the day.\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"sunriseTime\":1467896155,\n" +
                "        \"sunsetTime\":1467948941,\n" +
                "        \"moonPhase\":0.12,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipIntensityMax\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperatureMin\":53.82,\n" +
                "        \"temperatureMinTime\":1467892800,\n" +
                "        \"temperatureMax\":64.1,\n" +
                "        \"temperatureMaxTime\":1467932400,\n" +
                "        \"apparentTemperatureMin\":53.82,\n" +
                "        \"apparentTemperatureMinTime\":1467892800,\n" +
                "        \"apparentTemperatureMax\":64.1,\n" +
                "        \"apparentTemperatureMaxTime\":1467932400,\n" +
                "        \"dewPoint\":52.25,\n" +
                "        \"humidity\":0.84,\n" +
                "        \"windSpeed\":9.98,\n" +
                "        \"windBearing\":266,\n" +
                "        \"visibility\":6.97,\n" +
                "        \"cloudCover\":0.72,\n" +
                "        \"pressure\":1014.62,\n" +
                "        \"ozone\":309.38\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1467961200,\n" +
                "        \"summary\":\"Mostly cloudy until afternoon.\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"sunriseTime\":1467982591,\n" +
                "        \"sunsetTime\":1468035322,\n" +
                "        \"moonPhase\":0.15,\n" +
                "        \"precipIntensity\":0.0003,\n" +
                "        \"precipIntensityMax\":0.0009,\n" +
                "        \"precipIntensityMaxTime\":1467986400,\n" +
                "        \"precipProbability\":0.01,\n" +
                "        \"precipType\":\"rain\",\n" +
                "        \"temperatureMin\":54.68,\n" +
                "        \"temperatureMinTime\":1467964800,\n" +
                "        \"temperatureMax\":69.01,\n" +
                "        \"temperatureMaxTime\":1468018800,\n" +
                "        \"apparentTemperatureMin\":54.68,\n" +
                "        \"apparentTemperatureMinTime\":1467964800,\n" +
                "        \"apparentTemperatureMax\":69.01,\n" +
                "        \"apparentTemperatureMaxTime\":1468018800,\n" +
                "        \"dewPoint\":54.93,\n" +
                "        \"humidity\":0.82,\n" +
                "        \"windSpeed\":9.45,\n" +
                "        \"windBearing\":274,\n" +
                "        \"visibility\":8.08,\n" +
                "        \"cloudCover\":0.59,\n" +
                "        \"pressure\":1015.43,\n" +
                "        \"ozone\":299.66\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468047600,\n" +
                "        \"summary\":\"Mostly cloudy until afternoon.\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"sunriseTime\":1468069028,\n" +
                "        \"sunsetTime\":1468121702,\n" +
                "        \"moonPhase\":0.18,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipIntensityMax\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperatureMin\":53.66,\n" +
                "        \"temperatureMinTime\":1468130400,\n" +
                "        \"temperatureMax\":67.34,\n" +
                "        \"temperatureMaxTime\":1468101600,\n" +
                "        \"apparentTemperatureMin\":53.66,\n" +
                "        \"apparentTemperatureMinTime\":1468130400,\n" +
                "        \"apparentTemperatureMax\":67.34,\n" +
                "        \"apparentTemperatureMaxTime\":1468101600,\n" +
                "        \"dewPoint\":53.88,\n" +
                "        \"humidity\":0.82,\n" +
                "        \"windSpeed\":9.83,\n" +
                "        \"windBearing\":275,\n" +
                "        \"visibility\":8.01,\n" +
                "        \"cloudCover\":0.53,\n" +
                "        \"pressure\":1017.97,\n" +
                "        \"ozone\":295.93\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468134000,\n" +
                "        \"summary\":\"Partly cloudy in the morning.\",\n" +
                "        \"icon\":\"partly-cloudy-night\",\n" +
                "        \"sunriseTime\":1468155466,\n" +
                "        \"sunsetTime\":1468208081,\n" +
                "        \"moonPhase\":0.21,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipIntensityMax\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperatureMin\":52.41,\n" +
                "        \"temperatureMinTime\":1468148400,\n" +
                "        \"temperatureMax\":68.95,\n" +
                "        \"temperatureMaxTime\":1468184400,\n" +
                "        \"apparentTemperatureMin\":52.41,\n" +
                "        \"apparentTemperatureMinTime\":1468148400,\n" +
                "        \"apparentTemperatureMax\":68.95,\n" +
                "        \"apparentTemperatureMaxTime\":1468184400,\n" +
                "        \"dewPoint\":49.22,\n" +
                "        \"humidity\":0.69,\n" +
                "        \"windSpeed\":8.71,\n" +
                "        \"windBearing\":289,\n" +
                "        \"visibility\":10,\n" +
                "        \"cloudCover\":0.15,\n" +
                "        \"pressure\":1016.46,\n" +
                "        \"ozone\":317.28\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468220400,\n" +
                "        \"summary\":\"Clear throughout the day.\",\n" +
                "        \"icon\":\"clear-day\",\n" +
                "        \"sunriseTime\":1468241905,\n" +
                "        \"sunsetTime\":1468294457,\n" +
                "        \"moonPhase\":0.24,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipIntensityMax\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperatureMin\":56.2,\n" +
                "        \"temperatureMinTime\":1468220400,\n" +
                "        \"temperatureMax\":68.68,\n" +
                "        \"temperatureMaxTime\":1468267200,\n" +
                "        \"apparentTemperatureMin\":56.2,\n" +
                "        \"apparentTemperatureMinTime\":1468220400,\n" +
                "        \"apparentTemperatureMax\":68.68,\n" +
                "        \"apparentTemperatureMaxTime\":1468267200,\n" +
                "        \"dewPoint\":48.98,\n" +
                "        \"humidity\":0.64,\n" +
                "        \"windSpeed\":5.5,\n" +
                "        \"windBearing\":254,\n" +
                "        \"cloudCover\":0,\n" +
                "        \"pressure\":1012.26,\n" +
                "        \"ozone\":298.74\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468306800,\n" +
                "        \"summary\":\"Clear throughout the day.\",\n" +
                "        \"icon\":\"clear-day\",\n" +
                "        \"sunriseTime\":1468328345,\n" +
                "        \"sunsetTime\":1468380832,\n" +
                "        \"moonPhase\":0.27,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipIntensityMax\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperatureMin\":54.75,\n" +
                "        \"temperatureMinTime\":1468324800,\n" +
                "        \"temperatureMax\":70.91,\n" +
                "        \"temperatureMaxTime\":1468360800,\n" +
                "        \"apparentTemperatureMin\":54.75,\n" +
                "        \"apparentTemperatureMinTime\":1468324800,\n" +
                "        \"apparentTemperatureMax\":70.91,\n" +
                "        \"apparentTemperatureMaxTime\":1468360800,\n" +
                "        \"dewPoint\":50.29,\n" +
                "        \"humidity\":0.69,\n" +
                "        \"windSpeed\":5.14,\n" +
                "        \"windBearing\":235,\n" +
                "        \"cloudCover\":0,\n" +
                "        \"pressure\":1011.75,\n" +
                "        \"ozone\":294.5\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468393200,\n" +
                "        \"summary\":\"Mostly cloudy until afternoon.\",\n" +
                "        \"icon\":\"partly-cloudy-day\",\n" +
                "        \"sunriseTime\":1468414786,\n" +
                "        \"sunsetTime\":1468467205,\n" +
                "        \"moonPhase\":0.3,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipIntensityMax\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperatureMin\":53.65,\n" +
                "        \"temperatureMinTime\":1468411200,\n" +
                "        \"temperatureMax\":69.35,\n" +
                "        \"temperatureMaxTime\":1468450800,\n" +
                "        \"apparentTemperatureMin\":53.65,\n" +
                "        \"apparentTemperatureMinTime\":1468411200,\n" +
                "        \"apparentTemperatureMax\":69.35,\n" +
                "        \"apparentTemperatureMaxTime\":1468450800,\n" +
                "        \"dewPoint\":51.72,\n" +
                "        \"humidity\":0.74,\n" +
                "        \"windSpeed\":5.22,\n" +
                "        \"windBearing\":220,\n" +
                "        \"cloudCover\":0.16,\n" +
                "        \"pressure\":1013.26,\n" +
                "        \"ozone\":292.02\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\":1468479600,\n" +
                "        \"summary\":\"Clear throughout the day.\",\n" +
                "        \"icon\":\"clear-day\",\n" +
                "        \"sunriseTime\":1468501228,\n" +
                "        \"sunsetTime\":1468553576,\n" +
                "        \"moonPhase\":0.33,\n" +
                "        \"precipIntensity\":0,\n" +
                "        \"precipIntensityMax\":0,\n" +
                "        \"precipProbability\":0,\n" +
                "        \"temperatureMin\":55.44,\n" +
                "        \"temperatureMinTime\":1468494000,\n" +
                "        \"temperatureMax\":71.42,\n" +
                "        \"temperatureMaxTime\":1468530000,\n" +
                "        \"apparentTemperatureMin\":55.44,\n" +
                "        \"apparentTemperatureMinTime\":1468494000,\n" +
                "        \"apparentTemperatureMax\":71.42,\n" +
                "        \"apparentTemperatureMaxTime\":1468530000,\n" +
                "        \"dewPoint\":51.39,\n" +
                "        \"humidity\":0.7,\n" +
                "        \"windSpeed\":5.56,\n" +
                "        \"windBearing\":227,\n" +
                "        \"cloudCover\":0,\n" +
                "        \"pressure\":1012.53,\n" +
                "        \"ozone\":289.82\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"flags\":{\n" +
                "    \"sources\":[\n" +
                "      \"darksky\",\n" +
                "      \"lamp\",\n" +
                "      \"gfs\",\n" +
                "      \"cmc\",\n" +
                "      \"nam\",\n" +
                "      \"rap\",\n" +
                "      \"rtma\",\n" +
                "      \"sref\",\n" +
                "      \"fnmoc\",\n" +
                "      \"isd\",\n" +
                "      \"nwspa\",\n" +
                "      \"madis\",\n" +
                "      \"nearest-precip\"\n" +
                "    ],\n" +
                "    \"darksky-stations\":[\n" +
                "      \"KMUX\"\n" +
                "    ],\n" +
                "    \"lamp-stations\":[\n" +
                "      \"KAPC\",\n" +
                "      \"KCCR\",\n" +
                "      \"KHWD\",\n" +
                "      \"KLVK\",\n" +
                "      \"KNUQ\",\n" +
                "      \"KOAK\",\n" +
                "      \"KPAO\",\n" +
                "      \"KSFO\",\n" +
                "      \"KSQL\"\n" +
                "    ],\n" +
                "    \"isd-stations\":[\n" +
                "      \"724943-99999\",\n" +
                "      \"745039-99999\",\n" +
                "      \"745065-99999\",\n" +
                "      \"994016-99999\",\n" +
                "      \"998479-99999\"\n" +
                "    ],\n" +
                "    \"madis-stations\":[\n" +
                "      \"AU915\",\n" +
                "      \"C5988\",\n" +
                "      \"C8158\",\n" +
                "      \"C9629\",\n" +
                "      \"CQ147\",\n" +
                "      \"CQ188\",\n" +
                "      \"D5422\",\n" +
                "      \"E0426\",\n" +
                "      \"E6067\",\n" +
                "      \"E9227\",\n" +
                "      \"FTPC1\",\n" +
                "      \"GGBC1\",\n" +
                "      \"OKXC1\",\n" +
                "      \"PPXC1\",\n" +
                "      \"PXOC1\",\n" +
                "      \"SFOC1\"\n" +
                "    ],\n" +
                "    \"units\":\"us\"\n" +
                "  }\n" +
                "}";
        try {
            return new JSONObject(jsonString);
        } catch (JSONException e){
            return null;
        }
    }
}
